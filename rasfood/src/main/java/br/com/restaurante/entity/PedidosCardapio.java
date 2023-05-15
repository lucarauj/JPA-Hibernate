package br.com.restaurante.entity;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "pedidos_cardapio")
public class PedidosCardapio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Pedido pedido;

    @ManyToOne(fetch = FetchType.LAZY)
    private Cardapio cardapio;

    @Column(name = "valor_de_registro")
    private BigDecimal valorDeRegistro;

    private Integer quantidade;

    public PedidosCardapio() {}

    public PedidosCardapio(Cardapio cardapio, Integer quantidade) {
        this.cardapio = cardapio;
        this.quantidade = quantidade;
        this.valorDeRegistro = cardapio.getValor();

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public Cardapio getCardapio() {
        return cardapio;
    }

    public void setCardapio(Cardapio cardapio) {
        this.cardapio = cardapio;
    }

    public BigDecimal getValorDeRegistro() {
        return valorDeRegistro;
    }

    public void setValorDeRegistro(BigDecimal valorDeRegistro) {
        this.valorDeRegistro = valorDeRegistro;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    @Override
    public String toString() {
        return "PedidosCardapio{" +
                "id=" + id +
                ", cardapio=" + cardapio +
                ", valorDeRegistro=" + valorDeRegistro +
                ", quantidade=" + quantidade +
                '}';
    }
}
