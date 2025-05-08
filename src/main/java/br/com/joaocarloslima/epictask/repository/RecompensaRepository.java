package br.com.joaocarloslima.epictask.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.joaocarloslima.epictask.model.Recompensa;

public interface RecompensaRepository extends JpaRepository<Recompensa, Long> {
    
    
}
