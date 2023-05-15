package entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CadastroFuncionario {

    private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/YYYY ");
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String nome;
    private  String cpf;
    private String email;
    private Date dataNacimento;
    private String funcao;
    private String departamento;
    private  Double salario;

    public CadastroFuncionario() {
    }

    public CadastroFuncionario(Integer id, String nome, String cpf, String email, Date dataNacimento, String funcao, String departamento, Double salario) {
        this.id = id;
    	this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.dataNacimento = dataNacimento;
        this.funcao = funcao;
        this.departamento = departamento;
        this.salario = salario;
    }

    @Override
    public String toString() {
        return "FUNCIONÁRIO:" +
                "\nNome: " + nome +
                "\nCpf: " + cpf  +
                "\nEmail: " + email +
                "\nDataNacimento: " + sdf.format(dataNacimento) +
                "\nFunção: " + funcao+
                "\nDepartamento: " + departamento +
                "\nSalário: " + salario;
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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDataNacimento() {
        return dataNacimento;
    }

    public void setDataNacimento(Date dataNacimento) {
        this.dataNacimento = dataNacimento;
    }

    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
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
		CadastroFuncionario other = (CadastroFuncionario) obj;
		return Objects.equals(id, other.id);
	}
    
    
}
