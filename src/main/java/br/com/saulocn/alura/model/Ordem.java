package br.com.saulocn.alura.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
public class Ordem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate data;
    private BigDecimal preco;
    private String status;
    private String tipo;
    @Column(name = "user_id")
    private Long userId;

    public void setData(LocalDate data) {
        this.data = data;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
