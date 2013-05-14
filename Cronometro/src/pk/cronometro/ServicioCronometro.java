/**
 * 
 */
package pk.cronometro;

import java.util.List;
import android.os.Handler;
import android.os.Message;
import android.text.format.Formatter;
import android.view.View;
import android.webkit.WebChromeClient.CustomViewCallback;
import android.widget.TextView;

/**
 * @author egmn472
 * @desciption Clase que sirve para poder actualizar el UIThread, 
 *             segun los cambios generados por el hilo Cronometro
 * @since 09 Mayo de 2013
 */
public class ServicioCronometro extends Handler {

	/*
	 * ATRIBUTOS
	 */
	private Display aDisplay;
	private List<View> aListDisplay;
	
	private TextView lblCentesimas;
	private TextView lblSegundos;
	private TextView lblMinutos;
	private TextView lblHoras;
	
	Formatter aFormat;
	
	/*******************************
	 *CONSTRUCTOR 
	 ********************************/
	public ServicioCronometro(List<View> valor) {
		
		aListDisplay = valor;
		Formatter aFormat = new Formatter();
		
		lblHoras      = (TextView) aListDisplay.get(0);
		lblMinutos    = (TextView) aListDisplay.get(1);
		lblSegundos   = (TextView) aListDisplay.get(2);
		lblCentesimas = (TextView) aListDisplay.get(3);
	}
	
	public void start(){
		
		super.sendEmptyMessage(0);
	}

	
	public void setVistaDisplay(Display valor) {
	
		this.aDisplay = valor;
	}
	
	@Override
	public void handleMessage(Message msg) {
		
		lblCentesimas.setText( String.format( "%02d" ,   aDisplay.GetCentesimas() ) );
		lblSegundos.setText  ( String.format( "%02d" ,   aDisplay.GetSegundos()   ) );
		lblMinutos.setText   ( String.format( "%02d" ,   aDisplay.GetMinutos()    ) );
		lblHoras.setText     ( String.format( "%02d" ,   aDisplay.GetHoras()      ) );
	}
}
