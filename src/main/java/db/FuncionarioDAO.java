package db;

import entities.CadastroFuncionario;

public class FuncionarioDAO extends DAO<CadastroFuncionario> {

    public  FuncionarioDAO(){
        super(CadastroFuncionario.class);
    }
}
