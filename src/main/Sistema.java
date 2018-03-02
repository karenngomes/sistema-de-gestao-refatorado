package main;

import java.util.ArrayList;
import java.util.Scanner;
import java.time.LocalDateTime;

import Cadastro.Usuario;
import Recursos.Atividade;
import Recursos.DataHora;
import Recursos.RecursosUA;

public class Sistema {
		
	private static Scanner input;


	static Object login(ArrayList<Usuario> listaUsuarios)
	{
		int index = -1;
		input = new Scanner(System.in);
		System.out.println("Digite seu user:");
		String user = input.nextLine();
		for (int i = 0; i < listaUsuarios.size(); i++) {
			if( ((Usuario) listaUsuarios.get(i)).getUser().equals(user))
			{
				
				index = i;
			}
		}
		if (index > -1) {
			return listaUsuarios.get(index);
		}
		else 
			return null;
		
	}
	
	static Object signUp()
	{
		input = new Scanner(System.in);
		String user = new String();
		String name = new String();
		String email = new String();
		int ocupacao;
		
		System.out.println("Digite qual será seu username:" );
		user = input.nextLine();
		System.out.println("Digite qual o seu nome:");
		name = input.nextLine();
		System.out.println("Digite qual será seu email:");
		email = input.nextLine();
		System.out.println("Digite qual é sua ocupação entre 1 e 6 (1- Aluno Graduação, 2- Aluno de Mestrado, 3- Aluno de Doutorado, 4- Professor, 5- Pesquisador e 6- Administrador):");
		ocupacao = input.nextInt();
		while(ocupacao < 1 || ocupacao >6)
		{
			System.out.println("Ocupação Invalida!");
			System.out.println("Digite qual é sua ocupação entre 1 e 6(1- Aluno Graduação, 2- Aluno de Mestrado, 3- Aluno de Doutorado, 4- Professor, 5- Pesquisador e 6- Administrador):");
			ocupacao = input.nextInt();
		}
		
		return new Usuario(user, name, email, ocupacao);
	}
	
	static RecursosUA createRecurso(Usuario user, Usuario responsavel)
	{
		System.out.println(responsavel.getOcupacao());
		if(responsavel.getOcupacao() < 4)
		{
			System.out.println("ERRO: Responsável não possui requisitos para tal posto!");
			return null;
		}
		else
		{
			input = new Scanner(System.in);
			int tipo;
			String titulo = new String();
			String descricao = new String();
			String material = new String();
			String participantes = new String();
			
			System.out.println("Identifique a atividade que deseja alocar:" );
			System.out.println("Qual tipo:\nDigite 1 para Apresentações.\nDigite 2 para aula tradicional(disponível apenas para professores e pesquisadores).\nDigite 3 para laboratório(disponível apenas para professores e pesquisadores))");
			tipo = input.nextInt();
			input.nextLine();
			System.out.println("Identifique o título de sua atividade:" );
			titulo = input.nextLine();
			System.out.println("Descrição da atividae:");
			descricao = input.nextLine();
			System.out.println("Material usado na atividade:" );
			material = input.nextLine();
			System.out.println("Lista de participantes: ");
			participantes = input.nextLine();
			
			Atividade atividade = new Atividade(tipo, titulo, descricao, participantes, material, user);
			
			DataHora inicio = null;
			DataHora termino = null;
			int dia, mes, ano, hora, minuto;
			
			do 
			{
				System.out.println("Identifique a data e hora de inicio:" );
				System.out.println("Dia:");
				dia = input.nextInt();
				System.out.println("Mes:");
				mes = input.nextInt();
				System.out.println("Ano:");
				ano = input.nextInt();
				System.out.println("Hora:");
				hora = input.nextInt();
				System.out.println("Minuto:");
				minuto = input.nextInt();
				inicio = new DataHora(ano, mes, dia, hora, minuto);

				if(inicio.getAlocacao() == 1)
					break;
				else
					System.out.println("Favor digitar uma data de inicio valida");
				
			}while(inicio.getAlocacao() == 0);
			
			LocalDateTime dataHoraInicio = LocalDateTime.of(inicio.getAno(), inicio.getMes(), inicio.getDia(), inicio.getHora(), inicio.getMinuto());
			
			int inicioEAntes = 1;
			
			do 
			{
				System.out.println("Identifique a data e hora de Termino:" );
				System.out.println("Dia:");
				dia = input.nextInt();
				System.out.println("Mes:");
				mes = input.nextInt();
				System.out.println("Ano:");
				ano = input.nextInt();
				System.out.println("Hora:");
				hora = input.nextInt();
				System.out.println("Minuto:");
				minuto = input.nextInt();
				
				termino = new DataHora(ano, mes, dia, hora, minuto);
				
				LocalDateTime dataHoraTermino = LocalDateTime.of(termino.getAno(), termino.getMes(), termino.getDia(), termino.getHora(), termino.getMinuto());

				if(termino.getAlocacao() == 1)
					if (dataHoraInicio.isAfter(dataHoraTermino))
					{
						System.out.println("Favor digitar uma data de termino antes da data de inicio");
						inicioEAntes = 0;
					}
					else
						break;
				
				else
					System.out.println("Favor digitar uma data de termino valida");
				
			}while(termino.getAlocacao() == 0 || inicioEAntes == 0);
			
			
			
			System.out.println("Recurso criado com sucesso...necessita aprovação do administrador");
			
			return new RecursosUA(atividade, inicio, termino, responsavel);
			
		}
	}
	

	public static void main(String[] args) {
		
		ArrayList<Usuario> listaUsuarios = new ArrayList<Usuario>();
		ArrayList<RecursosUA> listaRecursos = new ArrayList<RecursosUA>();
		Usuario users = new Usuario("admin", "Robert Silva", "bob@gmail.com", 6);
		listaUsuarios.add(users);
		users = new Usuario("prof", "Jackson Souza", "jax@gmail.com", 4);
		listaUsuarios.add(users);
		users = new Usuario("student", "Jorge Silva", "jorge@gmail.com", 1);
		listaUsuarios.add(users);
		
		users = null;
		int loop = 1;
		int controle;
		boolean aux;;
		
		input = new Scanner(System.in);
		
		while(loop == 1)
		{
			
			System.out.println("Digite 1: se desejar fazer login.\nDigite 2: se desejar criar sua conta.\nDigite 3 se deseja saber o número de usuários cadastrados e recursos cadastrados.\nDigite 4: se desejar encerar o programa.");
			controle = input.nextInt();
			input.hasNextLine();
			if(controle == 4)
				loop = 0;
			else if(controle == 3)
			{
				System.out.printf("Número de usuários cadastrados: %d\nNúmero de recursos cadastrados: %d\n", listaUsuarios.size(), listaRecursos.size());
			}
			else if(controle == 2)
			{
				listaUsuarios.add((Usuario) signUp());
			}
			else
			{
				
				users = (Usuario) login(listaUsuarios);
				if(users == null)
					System.out.println("Usuário não cadastrado");
				else
				{
					if(users.getOcupacao() == 6)
					{
						System.out.printf("Bem vindo %s o que deseja fazer:\nDigite 1 para acessar os recursos pedentes.\nDigite 2 para acessar recursos de que és responsável\nDigite 3 para alocar um recurso da Unidade Acadêmica.\n ", users.getName());
						controle = input.nextInt();
						input.nextLine();
						if(controle == 1)
						{
							for(int i = 0; i < listaRecursos.size(); i++)
							{
								if(listaRecursos.get(i).getStatus().equals("Em processo de alocacao"))
								{
									listaRecursos.get(i).adminOverall();
									System.out.println("Gostaria de avançar o processo de alocação para 'Alocado'? Digite 'true' ou 'false'");
									aux = input.nextBoolean();
									input.nextLine();
									if(aux)
									{
										listaRecursos.get(i).setStatus("Alocado");
									}
								}
								else if(listaRecursos.get(i).getStatus().equals("Em andamento"))
								{
									listaRecursos.get(i).adminOverall();
									System.out.println("Gostaria de avançar o processo de alocação para 'Concluído'? Digite 'true' ou 'false'");
									aux = input.nextBoolean();
									input.nextLine();
									if(aux)
									{
										listaRecursos.get(i).setStatus("Concluído");
									}
								}
							}
						}
					
						else if(controle == 2)
						{
							for(int i = 0; i < listaRecursos.size(); i++)
							{
								if(listaRecursos.get(i).getResponsavel() == users)
								{
									System.out.println("Deseja alterar o status da alocação para 'Em andamento'? Digite 'true' ou 'false'");
									aux = input.nextBoolean();
									input.nextLine();
									if(aux)
									{
										listaRecursos.get(i).setStatus("Em andamento");
									}
								}
							}
						}
						else if(controle == 3)
						{
							users.setRecurso(createRecurso(users, listaUsuarios.get(0)));
							listaRecursos.add(users.getRecurso());
						}
						
					}
					else if(users.getOcupacao() >= 4)
					{
						System.out.printf("Bem vindo %s o que deseja fazer:\nDigite 1 para acessar recursos de que és responsável\nDigite 2 para alocar um recurso da Unidade Acadêmica", users.getName());
						controle = input.nextInt();
						input.nextLine();
						if(controle == 1)
						{
							for(int i = 0; i < listaRecursos.size(); i++)
							{
								if(listaRecursos.get(i).getResponsavel() == users)
								{
									System.out.println("Deseja alterar o status da alocação para 'Em andamento'? Digite 'true' ou 'false'");
									aux = input.nextBoolean();
									if(aux)
									{
										listaRecursos.get(i).setStatus("Em andamento");
									}
								}
							}
						}
						else
						{
							users.setRecurso(createRecurso(users, listaUsuarios.get(0)));
							listaRecursos.add(users.getRecurso());
						}
					}
					else
					{
						
						System.out.printf("Bem vindo %s o que deseja fazer:\nDigite 1 para alocar um recurso da Unidade Acadêmica\n", users.getName());
						controle = input.nextInt();
						input.nextLine();
						if(controle == 1)
						{
							users.setRecurso(createRecurso(users, listaUsuarios.get(0)));
							listaRecursos.add(users.getRecurso());
						}
					}
			
			    }
			}
		}
		
	}
}