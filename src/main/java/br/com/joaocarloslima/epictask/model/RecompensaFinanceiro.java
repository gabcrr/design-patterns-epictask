package br.com.joaocarloslima.epictask.model;

import jakarta.persistence.Entity;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class RecompensaFinanceiro extends RecompensaEntity {
    private String descricao = "Moedas de Ouro";
    private int valor = 300;
}
