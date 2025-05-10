package br.com.joaocarloslima.epictask.model;

import jakarta.persistence.Entity;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class RecompensaArtes implements Recompensa {
    private String descricao = "Pontos de criatividade";
    private int valor = 90;
}
