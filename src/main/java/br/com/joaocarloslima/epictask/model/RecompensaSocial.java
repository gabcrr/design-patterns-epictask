package br.com.joaocarloslima.epictask.model;

import jakarta.persistence.Entity;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class RecompensaSocial implements Recompensa {
    private String descricao = "Pontos de amizade";
    private int valor = 80;
}
