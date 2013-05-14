/**
 * 
 */
package pk.cronometro;

import java.util.List;

import android.view.View;

/**
 * @author egmn472
 *
 */
public class Cronometro extends Thread {

	/*
	 * ATRIBUTOS
	 */
	boolean aRun;
	boolean aPause;
	
	ServicioCronometro aServiceCrono;
	Display aDisplay;
		
	
	/*******************************
	 * CONSTRUCTOR 
	 *******************************/
	public Cronometro(List<View> valor) {
		
		aDisplay      = new Display();
		aServiceCrono = new ServicioCronometro(valor);
		
		aDisplay.SetReinicioTotal();
		
		ReinicioContador();
		
	}

	
	/*******************************
	 *          METODOS
	 *******************************/
	public void ReinicioContador(){
		
		aRun      = true;
		aPause    = true;
	}
	
	@SuppressWarnings("static-access")
	public void run(){
		
		while (aRun){
			while (!aPause){
				
				try{
					
					if(aDisplay.GetCentesimas() == 99){
						
						aDisplay.SetReinicioCentesimas();
						aDisplay.IncSegundos();
					}
					
					if ( aDisplay.GetSegundos() == 59){
						
						aDisplay.SetReinicioSegundos();
						aDisplay.IncMinutos();
					}
					
					if (aDisplay.GetMinutos() == 59){
						
						aDisplay.SetReinicioMinutos();
						aDisplay.IncHoras();
					}
					
					aDisplay.IncCentesimas();
					aServiceCrono.setVistaDisplay(aDisplay);
					aServiceCrono.start();
					this.sleep(10);
					
				}
				catch (Exception e){
					
					e.printStackTrace();
					
				}
				
			}
		}
	}
	
	
	
	
	/*******************************
	 * GET AND SET
	 *******************************/
	public void SetPause(boolean valor){
		
		aPause = valor;
	}
	
	public void SetReinicio(){
		
		ReinicioContador();
	}
	
	
	
}
