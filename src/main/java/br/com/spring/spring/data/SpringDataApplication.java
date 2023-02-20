package br.com.spring.spring.data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Scanner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.spring.spring.data.orm.Cargo;
import br.com.spring.spring.data.service.CrudCargoRepository;
import br.com.spring.spring.data.service.CrudFuncionarioRepository;
import br.com.spring.spring.data.service.CrudUnidadeDeTrabalhoRepository;
import br.com.spring.spring.data.service.RelatorioService;

@SpringBootApplication
//é nescessário implementar essa interface CommandLinerRunner para poder rodar aquele método
//run depois que a main terminar de ser executada
public class SpringDataApplication implements CommandLineRunner {

	// para fazer a injeção de dependências é preciso criar um atributo para a
	// classe principal
	// SpringDataApplication e depois um construtor passando a interface como
	// parâmetro e fazendo
	// o atributo receber aquela interface
	private CrudCargoRepository crudCargoRepository;
	private CrudUnidadeDeTrabalhoRepository crudUnidadeDeTrabalhoRepository;
	private CrudFuncionarioRepository crudFuncionarioRepository;
	private RelatorioService relatorio;

	public SpringDataApplication(CrudCargoRepository crudCargoRepository,
			CrudUnidadeDeTrabalhoRepository crudUnidadeDeTrabalhoRepository,
			CrudFuncionarioRepository crudFuncionarioRepository,
			RelatorioService relatorio
			) {
		this.crudCargoRepository = crudCargoRepository;
		this.crudUnidadeDeTrabalhoRepository = crudUnidadeDeTrabalhoRepository;
		this.crudFuncionarioRepository = crudFuncionarioRepository;
		this.relatorio = relatorio;
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringDataApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Scanner sc = new Scanner(System.in);

		// instanciei tudo aqui fora pra não ficar criando um monte de nome diferente
		// pra variável
		BigDecimal salario = null;
		LocalDate data = null;
		String descricao = null;
		String rua = null;
		String bairro = null;
		String cidade = null;
		String numero = null;
		String nome = null;
		String cpf = null;
		Cargo cargo = null;
		Long id = null;
		Integer opcao = null;

		while (true) {
			System.out.println(" ");
			System.out.println("Gerenciamento de funcionarios");
			System.out.println("0 - Sair");
			System.out.println("1 - Busca");
			System.out.println("2 - CRUD de dados");
			opcao = sc.nextInt();

			if (opcao == 0)
				break;

			switch (opcao) {
			case 1:

				while (true) {
					System.out.println(" ");
					System.out.println("Qual acao voce quer executar?");
					System.out.println("0 - Voltar");
					System.out.println("1 - Busca funcionario nome");
					System.out.println("2 - Buscar funcionario com maior salario pela data");
					System.out.println("3 - Projecao funcionarios");

					opcao = sc.nextInt();
					if (opcao == 0)
						break;
					
					switch (opcao) {
					case 1:
						System.out.println("Digite o nome do funcionario que deseja procurar");
						nome = sc.next();
						this.relatorio.buscaFuncionarioNome(nome);
						break;
						
					case 2:
						System.out.println("Digite o salário mínimo da busca");
						salario = sc.nextBigDecimal();
						System.out.println("Digite a data");
						descricao = sc.next();
						this.relatorio.buscaMaiorSalarioDataContratacao(salario, descricao);
						break;
						
					case 3:
						this.crudFuncionarioRepository.pesquisaFuncionarioSalario();
						break;
					default:
						System.out.println("Digite uma opcao valida");
						break;
					}
				}
				break;

			case 2:

				while (true) {
					System.out.println(" ");
					System.out.println("Qual acao voce quer executar?");
					System.out.println("0 - Voltar");
					System.out.println("1 - Adicionar cargo");
					System.out.println("2 - Atualizar cargo");
					System.out.println("3 - Ver cargos");
					System.out.println("4 - Deletar cargo");
					System.out.println("5 - Adicionar Unidade de Trabalho");
					System.out.println("6 - Atualizar Unidade de Trabalho");
					System.out.println("7 - Ver Unidades de Trabalho");
					System.out.println("8 - Deletar Unidade de Trabalho");
					System.out.println("9 - Adicionar Funcionario");
					System.out.println("10 - Atualizar Funcionario");
					System.out.println("11 - Ver Funcionarios");
					System.out.println("12 - Deletar Funcionarios");

					opcao = sc.nextInt();

					if (opcao == 0)
						break;

					System.out.println("");
					switch (opcao) {

					case 1:

						System.out.println("Escreva a descricao");
						sc.next();
						descricao = sc.nextLine();
						break;

					case 2:

						System.out.println("Escreva o id do cargo que quer atualizar");
						id = sc.nextLong();
						System.out.println("Escreva a descricao");
						sc.next();
						descricao = sc.nextLine();
						this.crudCargoRepository.atualizar(id, descricao);
						break;

					case 3:

						this.crudCargoRepository.visualizar();
						break;

					case 4:

						System.out.println("Escreva o id do cargo que quer deletar");
						id = sc.nextLong();
						this.crudCargoRepository.deletar(id);
						break;

					case 5:
						System.out.println("Digite a descricao ->");
						descricao = sc.next();
						System.out.println("Digite a rua ->");
						rua = sc.next();
						System.out.println("Digite o bairro ->");
						bairro = sc.next();
						System.out.println("Digite a cidade ->");
						cidade = sc.next();
						System.out.println("Digite o numero ->");
						numero = sc.next();
						this.crudUnidadeDeTrabalhoRepository.adicionar(descricao, rua, bairro, cidade, numero);
						break;

					case 6:
						System.out.println("Digite o id da Unidade que voce quer atualizar -> ");
						id = sc.nextLong();
						System.out.println("Digite a descricao ->");
						descricao = sc.next();
						System.out.println("Digite a rua ->");
						rua = sc.next();
						System.out.println("Digite o bairro ->");
						bairro = sc.next();
						System.out.println("Digite a cidade ->");
						cidade = sc.next();
						System.out.println("Digite o numero ->");
						numero = sc.next();
						this.crudUnidadeDeTrabalhoRepository.atualizar(id, descricao, rua, bairro, cidade, numero);
						break;

					case 7:
						this.crudUnidadeDeTrabalhoRepository.visualizar();
						break;

					case 8:
						System.out.println("Digite o id da Unidade que voce quer deletar -> ");
						id = sc.nextLong();
						this.crudUnidadeDeTrabalhoRepository.deletar(id);
						break;

					case 9:
						System.out.println("Selecione um cargo para o novo funcionario");
						this.crudCargoRepository.visualizar();
						id = sc.nextLong();
						System.out.println("Digite o nome ->");
						nome = sc.next();
						System.out.println("Digite o cpf ->");
						cpf = sc.next();
						System.out.println("Digite o salario ->");
						salario = sc.nextBigDecimal();
						cargo = this.crudCargoRepository.pegarCargoPorId(id);
						this.crudFuncionarioRepository.adicionar(nome, cpf, salario, cargo);
						break;

					case 10:
						System.out.println("Selecione o id do funcionario que quer atualizar ->");
						Long idFuncionario = sc.nextLong();
						System.out.println("Selecione um cargo para o funcionario");
						this.crudCargoRepository.visualizar();
						id = sc.nextLong();
						System.out.println("Digite o nome ->");
						nome = sc.next();
						System.out.println("Digite o cpf ->");
						cpf = sc.next();
						System.out.println("Digite o salario ->");
						salario = sc.nextBigDecimal();
						cargo = this.crudCargoRepository.pegarCargoPorId(id);
						this.crudFuncionarioRepository.atualizar(idFuncionario, nome, cpf, salario, cargo);
						break;

					case 11:
						System.out.println("Digite a pagina que quer visualizar");
						opcao = sc.nextInt();
						this.crudFuncionarioRepository.visualizar(opcao);
						break;

					case 12:
						System.out.println("Digite o id do funcionário que quer excluir ->");
						id = sc.nextLong();
						this.crudFuncionarioRepository.remover(id);

					default:
						System.out.println("Digite uma opcao valida");
						break;
					}
				}
				break;

			default:
				break;
			}
		sc.close();
		}
	}
}
