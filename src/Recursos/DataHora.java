package Recursos;

public class DataHora {

	private int dia;
	private int mes;
	private int ano;
	private int hora;
	private int minuto;
	private int alocou = 0;

	private static final int[] daysPerMonth = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	
	public DataHora(int year, int month, int day, int hour, int minute)
	{
		

		if(month <= 0 || month > 12) 
		{
			System.out.println("Meses devem ser 1-12");
			return;
		}
		
		if(day <= 0 || day > daysPerMonth[month] && !(month == 2 && day == 29)) 
		{
			System.out.printf("Dia %d nao pode ser do especifico mes\n", day);
			return;
		}
			
		if(month == 2 && day == 29 && !(year % 400 == 0 || (year % 4 == 0 && year % 100 != 0))) 
		{
			System.out.printf("Dia %d nao pode ser do especifico mes e ano\n", day);
			return;
		}
		
		
		this.dia = month;
		this.mes = day;
		this.ano = year;
		this.hora = hour;
		this.minuto = minute;
		this.alocou = 1;
	}


	public int getDia() {
		return this.dia;
	}		
	public int getMes() {
		return this.mes;
	}		

	public int getAno() {
		return this.ano;
	}		
		
	public int getHora() {
		return this.hora;
	}		
	public int getMinuto() {
		return this.minuto;
	}		
	
	public int getAlocacao() {
		return this.alocou;
	}

	



}
