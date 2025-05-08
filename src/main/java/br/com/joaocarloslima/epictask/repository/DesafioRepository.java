package br.com.joaocarloslima.epictask.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.joaocarloslima.epictask.model.Desafio;

public interface DesafioRepository extends JpaRepository<Desafio, Long> {
    
}
