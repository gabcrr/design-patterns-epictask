package br.com.joaocarloslima.epictask.service;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.joaocarloslima.epictask.model.Desafio;
// import br.com.joaocarloslima.epictask.model.Recompensa;
import br.com.joaocarloslima.epictask.model.RecompensaEntity;
import br.com.joaocarloslima.epictask.model.RecompensaFactory;
import br.com.joaocarloslima.epictask.model.RecompensaEstudoFactory;
import br.com.joaocarloslima.epictask.model.RecompensaExercicioFactory;
import br.com.joaocarloslima.epictask.model.RecompensaMeditacaoFactory;
import br.com.joaocarloslima.epictask.model.RecompensaSocialFactory;
import br.com.joaocarloslima.epictask.model.RecompensaArtesFactory;
import br.com.joaocarloslima.epictask.model.RecompensaFinanceiroFactory;
import br.com.joaocarloslima.epictask.model.TipoDesafio;
import br.com.joaocarloslima.epictask.repository.DesafioRepository;
import br.com.joaocarloslima.epictask.repository.RecompensaRepository;

@Service
public class DesafioService {

    @Autowired
    private DesafioRepository desafioRepository;

    @Autowired
    private RecompensaRepository recompensaRepository;

    public List<Desafio> todos() {
        return desafioRepository.findAll();
    }

    private RecompensaFactory getFactory(TipoDesafio tipo) {
        switch (tipo) {
            case ESTUDO:
                return new RecompensaEstudoFactory();
            case EXERCICIO:
                return new RecompensaExercicioFactory();
            case MEDITACAO:
                return new RecompensaMeditacaoFactory();
            case SOCIAL:
                return new RecompensaSocialFactory();
            case ARTES:
                return new RecompensaArtesFactory();
            case FINANCEIRO:
                return new RecompensaFinanceiroFactory();
            default:
                throw new IllegalArgumentException("Tipo de desafio inválido");
        }
    }

    private List<BonusStrategy> getBonusStrategies(TipoDesafio tipo) {
        List<BonusStrategy> strategies = new ArrayList<>();
        LocalDate hoje = LocalDate.now();

        if (hoje.getDayOfWeek().getValue() >= 6) {
            strategies.add(new BonusFimDeSemana());
        } else if (hoje.getDayOfWeek() == DayOfWeek.MONDAY) {
            strategies.add(new BonusSegundaFeira());
        }
        if (tipo == TipoDesafio.EXERCICIO || tipo == TipoDesafio.MEDITACAO) {
            strategies.add(new BonusSaudavel());
        }
        if (strategies.isEmpty()) {
            strategies.add(new BonusPadrao());
        }

        return strategies;
    }

    public RecompensaEntity concluirDesafio(Long id) {
        var desafio = desafioRepository.findById(id).get();
        var tipo = desafio.getTipo();

        RecompensaFactory factory = getFactory(tipo);
        RecompensaEntity recompensa = (RecompensaEntity) factory.criarRecompensa();

        int valorFinal = recompensa.getValor();
        List<BonusStrategy> strategies = getBonusStrategies(tipo);
        for (BonusStrategy strategy : strategies) {
            valorFinal = strategy.calcularBonus(valorFinal, tipo);
        }

        recompensa.setValor(valorFinal);
        desafioRepository.delete(desafio);
        recompensaRepository.save(recompensa);
        return recompensa;
    }

    public void adicionarDesafio(Desafio desafio) {
        desafio.setId(null);
        desafioRepository.save(desafio);
    }

    public List<RecompensaEntity> getInventario() {
        return recompensaRepository.findAll();
    }
}
