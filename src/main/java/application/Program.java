package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import db.EstoqueDAO;
import db.FuncionarioDAO;
import db.PedidoDAO;
import db.ProdutoDAO;
import db.UsuarioDAO;
import entities.CadastroFuncionario;
import entities.EstoqueIngredientes;
import entities.Produto;
import entities.Usuario;
import service.Pedido;
import service.StatusPedido;
import view.View;

public class Program {
	public static void main(String[] args) throws ParseException {

		PedidoDAO pedidoDao = new PedidoDAO();
		FuncionarioDAO cadastroDao = new FuncionarioDAO();
		ProdutoDAO produtoDAO = new ProdutoDAO();
		EstoqueDAO estoqueDao = new EstoqueDAO();
		UsuarioDAO usuarioDao = new UsuarioDAO();

		//Pedido pedido2 = pedidoDao.obterPorID(47);

		Locale.setDefault(Locale.US);

		View view = new View();

		EstoqueIngredientes xarope = estoqueDao.obterPorID(1);
		EstoqueIngredientes acuc = estoqueDao.obterPorID(2);
		EstoqueIngredientes gelatin = estoqueDao.obterPorID(3);
		EstoqueIngredientes amidoDeMilho = estoqueDao.obterPorID(4);
		EstoqueIngredientes oleoVegetal = estoqueDao.obterPorID(5);
		EstoqueIngredientes corantes = estoqueDao.obterPorID(6);
		EstoqueIngredientes aromatizantes = estoqueDao.obterPorID(7);

		 estoqueDao.incluirAtomico(aromatizantes).fechar();

		List<EstoqueIngredientes> estoque = Arrays.asList(xarope, acuc, gelatin, amidoDeMilho, oleoVegetal, corantes,
				aromatizantes);

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		Instant data = Instant.now();

		Scanner sc = new Scanner(System.in);

		Produto produto = new Produto(null, "Marshmallow", 5.60);
		 produtoDAO.abrirT().remover(produto).fecharT().fechar();

		Usuario usuario = new Usuario(null, "admin", "1010");

		int resposta = 1;

        System.out.println(view.telaInicial());
        System.out.println(view.login());
        int opcaoLogin = sc.nextInt();
        if(opcaoLogin == 1) {
        System.out.print("Login: ");
        sc.nextLine();
        String login = sc.nextLine();        
        System.out.print("Senha: ");
        String senha = sc.nextLine();
        List<Usuario> usuarios = usuarioDao.obterTodos();
        for(Usuario user : usuarios ) {
        	while( usuario.getLogin().equalsIgnoreCase(login)  || usuario.getSenha().equals(senha) ){
        		System.out.println("LOGIN OU SENHA INVÁLIDO! POR FAVOR TENTE NOVAMENTE...");
                System.out.print("Login: ");
                login = sc.nextLine();
                System.out.print("Senha: ");
                senha = sc.nextLine();
            }
            System.out.println("\nUSUÁRIO AUTENTICADO COM SUCESSO!");
        	}
        
        }else {
        	System.out.print(" Cadastre um usuário: ");
        	String user = sc.next();
        	System.out.print(" Cadastre uma senha: ");
        	String senha = sc.next();
        	Usuario novoUsuario = new Usuario(null, user, senha);
        	System.out.println("USUÁRIO CADASTRADO COM SUCESSO!");
        	usuarioDao.incluirAtomico(novoUsuario).fechar();
		 }

		while (resposta == 1) {
			System.out.println(view.menuOpcoes());
			int opcao = sc.nextInt();
			switch (opcao) {
			case 1:
				System.out.println("ENTRE COM OS DADOS DO FUNCIONÁRIO: ");
				System.out.print("NOME: ");
				sc.nextLine();
				String nome = sc.nextLine();
				System.out.print("CPF: ");
				String cpf = sc.next();
				sc.nextLine();
				while (cpf.length() > 11 || cpf.length() < 11) {
					System.out.print("CPF inválido!\nInforme um CPF válido: ");
					cpf = sc.nextLine();
				}
				System.out.print("EMAIL: ");
				String email = sc.nextLine();
				System.out.print("DATA DE NASCIMENTO (dd/MM/yyyy): ");
				Date dataNascimento = sdf.parse(sc.next());
				System.out.print("FUNÇÃO: ");
				sc.nextLine();
				String funcao = sc.nextLine();
				System.out.print("DEPARTAMENTO: ");
				String departamento = sc.nextLine();
				System.out.print("SALÁRIO: ");
				Double salario = sc.nextDouble();
				CadastroFuncionario cadastro = new CadastroFuncionario(null, nome, cpf, email, dataNascimento, funcao,
						departamento, salario);
				System.out.println(cadastro);
				cadastroDao.incluirAtomico(cadastro).fechar();

				break;

			case 2:
				System.out.println(view.tabelaIngredientes());
				int alternativa = sc.nextInt();
				if (alternativa == 1) {
					System.out.println("SELECIONE UMA OPÇÃO ( 1- INCLUSÃO  / 2- RETIRADA): ");
					int selecao = sc.nextInt();
					if (selecao == 1) {
						System.out.println("INFORME A QUANTIDADE: ");
						System.out.print("Xarope de Glicose(Litro): ");
						xarope.addIngrediente(sc.nextDouble());
						
					} else {
						System.out.println("INFORME A QUANTIDADE: ");
						System.out.print("Xarope de Glicose(Litro): ");
						xarope.subIngrediente(sc.nextDouble());						
					}
					estoqueDao.abrirT().atualizar(xarope).fecharT();

				} else if (alternativa == 2) {
					System.out.println("SELECIONE UMA OPÇÃO ( 1- INCLUSÃO / 2- RETIRADA): ");
					int selecao = sc.nextInt();
					if (selecao == 1) {
						System.out.println("INFORME A QUANTIDADE: ");
						System.out.print("Açúcar(Kg): ");
						acuc.addIngrediente(sc.nextDouble());
					} else {
						System.out.println("INFORME A QUANTIDADE: ");
						System.out.print("Açúcar(Kg): ");
						acuc.subIngrediente(sc.nextDouble());
					}

					estoqueDao.abrirT().atualizar(acuc).fecharT();

				} else if (alternativa == 3) {
					System.out.println("SELECIONE UMA OPÇÃO ( 1- INCLUSÃO / 2- RETIRADA): ");
					int selecao = sc.nextInt();
					if (selecao == 1) {
						System.out.println("INFORME A QUANTIDADE: ");
						System.out.print("Gelatina(Kg): ");
						gelatin.addIngrediente(sc.nextDouble());
					} else {
						System.out.println("INFORME A QUANTIDADE: ");
						System.out.print("Gelatina(Kg): ");
						gelatin.subIngrediente(sc.nextDouble());
					}

					estoqueDao.abrirT().atualizar(gelatin).fecharT();

				} else if (alternativa == 4) {
					System.out.println("SELECIONE UMA OPÇÃO ( 1- INCLUSÃO / 2- RETIRADA): ");
					int selecao = sc.nextInt();
					if (selecao == 1) {
						System.out.println("INFORME A QUANTIDADE: ");
						System.out.print("Amido de Milho(Kg): ");
						amidoDeMilho.addIngrediente(sc.nextDouble());
					} else {
						System.out.println("INFORME A QUANTIDADE: ");
						System.out.print("Amido de Milho(Kg): ");
						amidoDeMilho.subIngrediente(sc.nextDouble());
					}
					estoqueDao.abrirT().atualizar(amidoDeMilho);

				} else if (alternativa == 5) {
					System.out.println("SELECIONE UMA OPÇÃO ( 1- INCLUSÃO / 2- RETIRADA): ");
					int selecao = sc.nextInt();
					if (selecao == 1) {
						System.out.println("INFORME A QUANTIDADE: ");
						System.out.print("Óleo Vegetal(Litro): ");
						oleoVegetal.addIngrediente(sc.nextDouble());
					} else {
						System.out.println("INFORME A QUANTIDADE: ");
						System.out.print("Óleo Vegetal(Litro): ");
						oleoVegetal.subIngrediente(sc.nextDouble());
					}

					estoqueDao.abrirT().atualizar(oleoVegetal).fecharT();

				} else if (alternativa == 6) {
					System.out.println("SELECIONE UMA OPÇÃO ( 1- INCLUSÃO / 2- RETIRADA): ");
					int selecao = sc.nextInt();
					if (selecao == 1) {
						System.out.println("INFORME A QUANTIDADE: ");
						System.out.print("Corante(litro): ");
						corantes.addIngrediente(sc.nextDouble());
					} else {
						System.out.println("INFORME A QUANTIDADE: ");
						System.out.print("Corante(litro): ");
						corantes.subIngrediente(sc.nextDouble());
					}
					estoqueDao.abrirT().atualizar(corantes).fecharT();

				} else if (alternativa == 7) {
					System.out.println("SELECIONE UMA OPÇÃO ( 1- INCLUSÃO / 2- RETIRADA): ");
					int selecao = sc.nextInt();
					if (selecao == 1) {
						System.out.println("INFORME A QUANTIDADE: ");
						System.out.print("Aromatizante(litro): ");
						aromatizantes.addIngrediente(sc.nextDouble());
					} else {
						System.out.println("INFORME A QUANTIDADE: ");
						System.out.print("Aromatizante(litro): ");
						aromatizantes.subIngrediente(sc.nextDouble());
					}

					estoqueDao.abrirT().atualizar(aromatizantes).fecharT();
				}

				System.out.println("\nLISTA DE ESTOQUE ATUALIZADA: ");
				List<EstoqueIngredientes> lista = estoqueDao.obterTodos();
				for (EstoqueIngredientes ingrediente : lista) {
					System.out.println("ID: " + ingrediente.getId() + ", " + ingrediente.getNome() + ", "
							+ ingrediente.getEstoque());
					
					
				}
				estoqueDao.fechar();
			

				break;
			case 3:
				System.out.println("\nLISTA DE ESTOQUE ATUALIZADA: ");
				List<EstoqueIngredientes> ingredientes = estoqueDao.obterTodos();
				for (EstoqueIngredientes ingrediente : ingredientes) {
					System.out.println("ID: " + ingrediente.getId() + ", " + ingrediente.getNome() + ", "
							+ ingrediente.getEstoque());
				}
				break;
			case 4:
				System.out.print("DESCRIÇÃO: ");
				sc.nextLine();
				String descricao = sc.nextLine();
				System.out.print("QUANTIDADE: ");
				int qtd = sc.nextInt();
				if (qtd >= 30) {
					System.out.println("CLIENTE COM 10% DE DESCONTO!");
				} else {
					System.out.println("CLIENTE COM 5% DE DESCONTO!");
				}
				Pedido pedido = new Pedido(null, data, descricao, qtd, produto, StatusPedido.PAGAMENTO_PENDENTE);

				System.out.println(pedido);
				pedidoDao.incluirAtomico(pedido).fechar();
				break;

			case 5:
				break;
			default:
				System.out.print("OPÇÃO INVÁLIDA! ");
				break;
			}
			System.out.print("\nDESEJA  FAZER OUTRA OPERAÇÃO (1- SIM / 2- NÃO )? ");
			resposta = sc.nextInt();
			if (resposta != 1) {
				System.out.println("OBRIGADO POR UTILIZAR NOSSOS SERVIÇOS!");
			}
		}
		sc.close();
	}
}
