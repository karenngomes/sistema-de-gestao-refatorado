package Cadastro;

import Recursos.RecursosUA;

public class Usuario {
	private String user;
	private String name;
	private String email;
	private int ocupacao;
	private RecursosUA recurso;
	
	
	public Usuario(String user, String name, String email, int Ocupacao) {
		this.user = user;
		this.name = name;
		this.email = email;
		this.ocupacao = Ocupacao;
		this.recurso = null;
		
	}
	public String getUser()
	{
		return this.user;
	}
	public String getName()
	{
		return this.name;
	}
	public String getEmail()
	{
		return this.email;
	}
	public int getOcupacao()
	{
		return this.ocupacao;
	}
	public RecursosUA getRecurso()
	{
		return this.recurso;
	}
	public String getOcupacaoTraduzido()
	{
		int ocupacao = this.ocupacao;
		switch(ocupacao) 
		{
			case 1:
				return "Aluno Graduação";
			case 2:
				return "Aluno Mestrado";
			case 3:
				return "Aluno Doutorado";
			case 4:
				return "Professor";
			case 5:
				return "Pesquisador";
			default:
				return "Administrador";
			
		}
		
	}
	public void setRecurso(RecursosUA recurso)
	{
		this.recurso = recurso;
	}
}
