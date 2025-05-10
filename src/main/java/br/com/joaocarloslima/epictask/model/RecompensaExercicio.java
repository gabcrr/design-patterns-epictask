package br.com.joaocarloslima.epictask.model;

import jakarta.persistence.Entity;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class RecompensaExercicio extends RecompensaEntity {
    private String descricao = "Moedas Fitness";
    private int valor = 150;
}
