package br.com.joaocarloslima.epictask.database;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.joaocarloslima.epictask.model.Desafio;
import br.com.joaocarloslima.epictask.model.TipoDesafio;
import br.com.joaocarloslima.epictask.repository.DesafioRepository;
import jakarta.annotation.PostConstruct;

@Component
public class Seeder {

    @Autowired
    private DesafioRepository desafioRepository;

    @PostConstruct
    public void seed() {
        desafioRepository.save(new Desafio(null, "IR A ACADEMIA", TipoDesafio.EXERCICIO));
        desafioRepository.save(new Desafio(null, "LER 10 PÁGINAS DE UM LIVRO", TipoDesafio.ESTUDO));
        desafioRepository.save(new Desafio(null, "FAZER 30 MINUTOS DE MEDITAÇÃO", TipoDesafio.MEDITACAO));
        desafioRepository.save(new Desafio(null, "FAZER UM NOVO AMIGO", TipoDesafio.SOCIAL));
        desafioRepository.save(new Desafio(null, "FAZER UMA ATIVIDADE ARTÍSTICA", TipoDesafio.ARTES));
        desafioRepository.save(new Desafio(null, "FAZER UM TRABALHO VOLUNTÁRIO", TipoDesafio.SOCIAL));
    }
    
}
