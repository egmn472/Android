/**
 * 
 */
package pk.cronometro;

/**
 * @author egmn472
 *
 */
public class Display {

	int aHoras     ;
	int aMinutos   ;
	int aSegundos  ;
	int aCentesimas; 
	
	/**
	 * CRONSTRUCTOR
	 */
	public Display() {
		
		SetReinicioTotal();
	}
	
	public void SetReinicioTotal(){
		aHoras      = 00;
		aMinutos    = 00;
		aSegundos   = 00;
		aCentesimas = 00;
	}
	
	
	/*
	 * METODOS
	 */
	public void IncCentesimas(){
		
		aCentesimas++;
	}
	
	public void IncSegundos(){
		
		aSegundos++;
	}
	
	public void IncMinutos(){
		
		aMinutos++;
	}
	
	public void IncHoras(){
		
		aHoras++;
	}
	
	
	/*
	 * GET AND SET
	 */
	public int GetCentesimas(){
		
		return aCentesimas;
	}
	
	public int GetSegundos(){
		
		return aSegundos;
	}
	
	public int GetMinutos(){
		
		return aMinutos;
	}
	
	public int GetHoras(){
		
		return aHoras;
	}
	
	public void SetReinicioCentesimas(){
		
		aCentesimas = 00;
	}
	
	public void SetReinicioSegundos(){
		
		aSegundos = 00;
	}
	
	public void SetReinicioMinutos(){
		
		aMinutos = 00;
	}
	
	public void SetReinicoHoras(){
		
		aHoras = 00;
	}
}
