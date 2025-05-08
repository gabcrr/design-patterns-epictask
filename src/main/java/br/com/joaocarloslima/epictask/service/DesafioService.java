package br.com.joaocarloslima.epictask.service;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.joaocarloslima.epictask.model.Desafio;
import br.com.joaocarloslima.epictask.model.Recompensa;
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

    public Recompensa concluirDesafio(Long id) {
        var desafio = desafioRepository.findById(id).get();

        var tipo = desafio.getTipo();
        var descricao = "";
        int valor = 0;

        // Aqui estão os ifs que devem ser refatorados
        if (tipo.equals(TipoDesafio.ESTUDO)) {
            descricao = "XP de conhecimento";
            valor = 100;
        } else if (tipo.equals(TipoDesafio.EXERCICIO)) {
            descricao = "Moedas Fitness";
            valor = 150;
        } else if (tipo.equals(TipoDesafio.MEDITACAO)) {
            descricao = "Cristal da vitalidade";
            valor = 120;
        } else if (tipo.equals(TipoDesafio.SOCIAL)) {
            descricao = "Pontos de amizade";
            valor = 80;
        } else if (tipo.equals(TipoDesafio.ARTES)) {
            descricao = "Pontos de criatividade";
            valor = 90;
        } else if (tipo.equals(TipoDesafio.FINANCEIRO)) {
            descricao = "Moedas de Ouro";
            valor = 300;
        }

        // Lógica de bônus (refatorar)
        int valorFinal = valor;
        LocalDate hoje = LocalDate.now();
        // Fim de semana → dobra
        if (hoje.getDayOfWeek().getValue() >= 6) {
            valorFinal *= 2;
        }
        // Segunda-feira → bônus motivacional
        else if (hoje.getDayOfWeek() == DayOfWeek.MONDAY) {
            valorFinal = (int) (valor * 1.5);
        }
        // Desafios saudáveis → +10
        if (desafio.getTipo() == TipoDesafio.EXERCICIO || desafio.getTipo() == TipoDesafio.MEDITACAO) {
            valorFinal += 10;
        }

        desafioRepository.delete(desafio);

        Recompensa recompensa = new Recompensa(null, descricao, valorFinal);
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
