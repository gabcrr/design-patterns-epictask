package br.com.joaocarloslima.epictask.model;

import jakarta.persistence.Entity;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class RecompensaMeditacao extends RecompensaEntity {
    private String descricao = "Cristal da vitalidade";
    private int valor = 120;
}
