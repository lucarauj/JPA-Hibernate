package br.com.restaurante.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "pedidos")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "valor_total")
    private BigDecimal valorTotal = BigDecimal.ZERO;

    @Column(name = "data_de_criacao")
    private LocalDateTime dataDeCriacao = LocalDateTime.now();

    @ManyToOne(fetch = FetchType.LAZY)
    private Cliente cliente;

//    ALL = realiza todas as operações em cascata
//    DETACH = executa no pai e no filho
//    MERGE = salva pai e filho, podendo já haver a entidade gerenciada
//    PERSIST = cria pai e filho
//    REFRESH = atualiza entidade com operações do banco
//    REMOVE = propaga remoção entre pai e filho

    @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL)
    private List<PedidosCardapio> pedidosCardapioList = new ArrayList<>();

    public Pedido() {}

    public void addPedidosCardapio(PedidosCardapio pedidosCardapio) {
        pedidosCardapio.setPedido(this);
        this.pedidosCardapioList.add(pedidosCardapio);
        this.valorTotal = valorTotal.add(pedidosCardapio.getValorDeRegistro()
                .multiply(BigDecimal.valueOf(pedidosCardapio.getQuantidade())));
    }

    public Pedido(Cliente cliente) {
        this.cliente = cliente;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }

    public LocalDateTime getDataDeCriacao() {
        return dataDeCriacao;
    }

    public void setDataDeCriacao(LocalDateTime dataDeCriacao) {
        this.dataDeCriacao = dataDeCriacao;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<PedidosCardapio> getPedidosCardapioList() {
        return pedidosCardapioList;
    }

    public void setPedidosCardapioList(List<PedidosCardapio> pedidosCardapioList) {
        this.pedidosCardapioList = pedidosCardapioList;
    }

    @Override
    public String toString() {
        return "Pedido{" +
                "id=" + id +
                ", valorTotal=" + valorTotal +
                ", dataDeCriacao=" + dataDeCriacao +
                ", cliente=" + cliente +
                ", pedidosCardapioList=" + pedidosCardapioList +
                '}';
    }
}
