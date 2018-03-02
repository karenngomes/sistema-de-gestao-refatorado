package Recursos;

import Cadastro.Usuario;

public class RecursosUA {
	private Atividade atividade;
	private DataHora inicio;
	private DataHora termino;
	private Usuario responsavel;
	private String status;
	
	
	public RecursosUA(Atividade atividade, DataHora inicio, DataHora termino, Usuario responsavel) 
	{
		
		this.atividade = atividade;
		this.inicio = inicio;
		this.termino = termino;
		if(responsavel.getOcupacao() >= 4)
			this.responsavel = responsavel;
		else {
			System.out.println("O Responsável deve ser Professor(4), Pesquisador(5) ou Administrador(6)");
			this.responsavel = null;
		}
		
		this.status = "Em processo de alocacao";
	}
	
	public DataHora getInicio()
	{
		return this.inicio;
	}
	public DataHora getTermino()
	{
		return this.termino;
	}
	public Usuario getResponsavel()
	{
		return this.responsavel;
	}
	public String getStatus()
	{
		return this.status;
	}
	public void setStatus(String newStatus)
	{
		this.status = newStatus;
	}

	public void adminOverall()
	{
		System.out.println("Atividade: " + atividade.getTipoTraduzido() + ".");
		System.out.println("Título: " + atividade.getTitulo() + ".");
		System.out.println("Breve descição: " + atividade.getDescricao() + ".");
		System.out.println("Participantes: " + atividade.getParticipantes() + ".");
		System.out.println("Materiais:"  + atividade.getMateriais() + ".");
		
		System.out.printf("Inicio: Dia: %d//%d//%d as %d:%d\n", this.inicio.getDia() , this.inicio.getMes(), this.inicio.getAno(), this.inicio.getHora(), this.inicio.getMinuto());
		System.out.printf("Termino: Dia: %d//%d//%d as %d:%d\n", this.termino.getDia() , this.termino.getMes(), this.termino.getAno(), this.termino.getHora(), this.termino.getMinuto());
		
		System.out.println("Ocupação do responsável: " + this.responsavel.getOcupacaoTraduzido());
		System.out.println("Status do recurso: " + this.status);
	
	}


}
