package br.com.joaocarloslima.epictask.model;

import jakarta.persistence.Entity;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class RecompensaEstudo extends RecompensaEntity {
    private String descricao = "XP de conhecimento";
    private int valor = 100;
}
