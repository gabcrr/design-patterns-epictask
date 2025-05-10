package br.com.joaocarloslima.epictask.model;

import jakarta.persistence.Entity;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class RecompensaMeditacao implements Recompensa {
    private String descricao = "Cristal da vitalidade";
    private int valor = 120;
}
