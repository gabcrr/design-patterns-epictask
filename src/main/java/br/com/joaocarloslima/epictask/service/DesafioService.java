package br.com.joaocarloslima.epictask.service;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.joaocarloslima.epictask.model.Desafio;
import br.com.joaocarloslima.epictask.model.Recompensa;
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

    public Recompensa concluirDesafio(Long id) {
        var desafio = desafioRepository.findById(id).get();
        var tipo = desafio.getTipo();

        // Usar Factory Method
        RecompensaFactory factory = getFactory(tipo);
        Recompensa recompensa = factory.criarRecompensa();

        // Lógica de bônus (ainda não refatorada)
        int valorFinal = recompensa.getValor();
        LocalDate hoje = LocalDate.now();
        if (hoje.getDayOfWeek().getValue() >= 6) {
            valorFinal *= 2;
        } else if (hoje.getDayOfWeek() == DayOfWeek.MONDAY) {
            valorFinal = (int) (valorFinal * 1.5);
        }
        if (desafio.getTipo() == TipoDesafio.EXERCICIO || desafio.getTipo() == TipoDesafio.MEDITACAO) {
            valorFinal += 10;
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

    public List<Recompensa> getInventario() {
        return recompensaRepository.findAll();
    }
}
