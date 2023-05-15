package entities;

import java.util.Objects;

import javax.persistence.*;

@Entity
@Table(name = "estoque_ingredientes")
public class EstoqueIngredientes {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private Double estoque;

	public EstoqueIngredientes() {

	}

	public EstoqueIngredientes(Integer id, String nome, Double estoque) {
		this.id = id;
		this.nome = nome;
		this.estoque = estoque;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getEstoque() {
		return estoque;
	}

	public void setEstoque(Double estoque) {
		this.estoque = estoque;
	}
	

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EstoqueIngredientes other = (EstoqueIngredientes) obj;
		return Objects.equals(id, other.id);
	}

	public void addIngrediente(Double quantidade) {

		estoque += quantidade;
	}

	public void subIngrediente(Double quantidade) {
		if (quantidade > estoque) {		
			System.out.println("Estoque de " + nome + " insuficiente!");
			estoque = 0.0;
			
		} else {			
			estoque -= quantidade;
			
		}
	}

	@Override
	public String toString() {
		return  "|_______________________________________|" +
				"\n|"+ getNome() + ", " + getEstoque() +"|";
	}

}
