// package br.com.joaocarloslima.epictask.model;

// import jakarta.persistence.Entity;
// import jakarta.persistence.GeneratedValue;
// import jakarta.persistence.GenerationType;
// import jakarta.persistence.Id;
// import lombok.AllArgsConstructor;
// import lombok.Data;
// import lombok.NoArgsConstructor;

// @Entity
// @Data
// @AllArgsConstructor
// @NoArgsConstructor
// public class Recompensa {

//     @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;
//     private String descricao;
//     private int valor;
    
// }

package br.com.joaocarloslima.epictask.model;

public interface Recompensa {
    String getDescricao();
    int getValor();
    void setValor(int valor);
}
