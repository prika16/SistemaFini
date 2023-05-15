package view;

import entities.CadastroFuncionario;
import entities.EstoqueIngredientes;
import entities.Produto;
import entities.Usuario;
import service.Pedido;

public class View {
    Usuario usuario;
    CadastroFuncionario funcionario;
    EstoqueIngredientes ingredientes;
    Produto produto;
    Pedido pedido;


    public String telaInicial(){
        return  "*************************************************"+
               "\n*  SISTEMA FINI INICIANDO POR FAVOR AGUARDE...  *"+
               "\n*************************************************";
    }    
    
    public String login() {
    	return 	"  \n+-----------------------------+" 
    			+ "\n|      ESCOLHA UMA OPÇÃO:     |" 
    			+ "\n|_____________________________|" 
    			+ "\n|  [1]  - LOGIN               |" 
    			+ "\n|____________________________ |"
    			+ "\n|  [2]  - CADASTRAR USUARIO   |" 
    			+ "\n+____________________________ +";
    }
    public String menuOpcoes(){
        return  "\n+-----------------------------+" +
                "\n|      ESCOLHA UMA OPÇÃO:     |" +
                "\n|_____________________________|"+
                "\n|[1] - CADASTRAR FUNCIONÁRIO  |" +
                "\n|____________________________ |"+
                "\n|[2] - ATUALIZAR INGREDIENTES |"+
                "\n|_____________________________|"+
                "\n|[3] - ESTOQUE DE INGREDIENTES|" +
                "\n|_____________________________|"+
                "\n|[4] - PEDIDO                 |"   +
                "\n|_____________________________|"+
                "\n|[5] - SAIR                   |" +
                "\n+-----------------------------+";
    }
    
    public String tabelaIngredientes() {
    	return  "\n+-----------------------------+" +
                "\n|  SELECIONE UM INGREDIENTE   |" +
                "\n|_____________________________|"+
                "\n|[1] - XAROPE DE GLICOSE      |" +
                "\n|____________________________ |"+
                "\n|[2] -      AÇÚCAR            |"+
                "\n|_____________________________|"+
                "\n|[3] -     GELATINA           |" +
                "\n|_____________________________|"+
                "\n|[4] -   AMIDO DE MILHO       |"   +
                "\n|_____________________________|"+
                "\n|[5] -    ÓLEO VEGETAL        |" +              
                "\n|_____________________________|"+
                "\n|[6] -      CORANTES          |"   +
                "\n|_____________________________|"+
                "\n|[7] -    AROMATIZANTES       |" +
                "\n|_____________________________|"+
                "\n|[0] -        SAIR            |" +
                "\n+-----------------------------+";
    }


}
