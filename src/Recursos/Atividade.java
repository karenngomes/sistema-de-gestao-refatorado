package Recursos;

import Cadastro.Usuario;

public class Atividade {
	private int tipo;
	private String titulo;
	private String descricao;
	private String participantes;
	private String material;
	
	public Atividade(int tipo, String titulo, String descricao, String participantes, String material, Usuario user) {
		if((user.getOcupacao() < 4) && ((tipo == 2)||(tipo == 3)))
		{
			System.out.println("Essa atividade não é compatível com sua ocupação.\n A atividade será definida com o tipo compatível");
			this.tipo = 1;
			
		}
		else
		{
			this.tipo = tipo;
			this.titulo = titulo;
			this.descricao = descricao;
			this.participantes = participantes;
			this.material = material;
		}
	}
	public int getTipo()
	{
		return this.tipo;
	}
	public String getTipoTraduzido()
	{
		if(this.tipo == 1)
			return "Apresentacao";
		else if(this.tipo == 2)
			return "Aula Tradicional";
		else
			return "Laboratório";
	}
	public String getTitulo()
	{
		return this.titulo;
	}
	public String getDescricao()
	{
		return this.descricao;
	}
	public String getParticipantes()
	{
		return this.participantes;
	}
	public String getMateriais()
	{
		return this.material;
	}
	
}