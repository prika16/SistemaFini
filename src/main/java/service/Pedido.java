package service;

import entities.Produto;

import javax.persistence.*;

import java.io.Serializable;
import java.time.Instant;
import java.time.LocalDate;


@Entity
public class Pedido implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer idPedido;
	
	
    private Instant dataPedido;

    private String descricao;

    private Integer qtd;

    @ManyToOne(cascade=CascadeType.PERSIST)
    @JoinColumn(name = "produto_id")    
    private Produto produto;
    
    @Enumerated(EnumType.STRING)
    private StatusPedido status;

    public Pedido() {
    }

    public Pedido(Integer idPedido, Instant dataPedido, String descricao, Integer qtd, Produto produto, StatusPedido status) {
        this.idPedido = idPedido;
        this.dataPedido = dataPedido;
        this.descricao = descricao;
        this.qtd = qtd;
        this.produto = produto;
        this.status = status;
    }

    public Integer getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public Instant getDataPedido() {
        return dataPedido;
    }

    public void setDataPedido(Instant dataPedido) {
        this.dataPedido = dataPedido;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Integer getQtd() {
        return qtd;
    }

    public void setQtd(Integer qtd) {
        this.qtd = qtd;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public StatusPedido getStatus() {
        return status;
    }

    public void setStatus(StatusPedido status) {
        this.status = status;
    }

    public  double calculaPedido() {
        if (qtd >= 30) {  // a partir de 30 unidades, desconto de 15%
            return (produto.getPreco()) * qtd* (1 - 0.10);
        } else { // desconto de 5%
            return (produto.getPreco()) * qtd * (1 - 0.05);
        }

        }
    public double comissaoVendedor () {
        return calculaPedido() * 0.15;

    }

    @Override
    public String toString() {
        return "PEDIDO: " +
                "\nId do Pedido: " + idPedido   +
                "\nData pedido: " + dataPedido +
                "\nProduto: " + produto.getNome()  +
                "\nDescricao: " + descricao +
                "\nPreco: R$ " + produto.getPreco() +
                "\nQuantidade: " + qtd +
                "\nValor sem desconto:  R$ " +( qtd * produto.getPreco()) +
                "\nValor do pedido:  R$ " + calculaPedido()+
                "\nComissão do vendedor: R$ " + String.format("%.2f", comissaoVendedor()) +
                "\nStatus do Pedido:  " + status;

    }
}
