package pk.cronometro;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Frm_Cronometro extends Activity {
	
    /*********************************
     *  ATRIBUTOS
     *********************************/
	
	//INICIALIZAR ANCHO PANTALLA
	int aWidth = 0;
	
	//BOTONES
	private Button btnStart;
	private Button btnStop;
	private Button btnLap;
	private Button btnContinue;
	private Button btnRestart;
	
	//DISPLAY
	private LinearLayout lyBotones;
	private TextView     lblHoras;
	private TextView     lblSegundos;
	private TextView     lblMinutos;
	private TextView     lblCentesimas;
	
	private Cronometro aCrono;
	private List<View> aListDisplay; 
	
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.frm_cronometro);
        
        //INICIALIZAR OBJETOS DESDE R
        SetInicializarObjetos();
       
        //INICIALIZAR VISTA
        InicializarVista();
        
        //LISTA DISPLAY
        List<View> aListDisplay = new ArrayList<View>(); 
        aListDisplay.clear();
        aListDisplay.add(lblHoras);
        aListDisplay.add(lblMinutos);
        aListDisplay.add(lblSegundos);
        aListDisplay.add(lblCentesimas);
        
        //THREAD
        aCrono = new Cronometro(aListDisplay);
        aCrono.start();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.frm_cronometro, menu);
        return true;
    }
    
   
    /*********************************
     * EVENTOS BOTONES
     *********************************/
    public void onbtnStart (View v){
    
    	//INICIAR CRONOMETRO
    	aCrono.SetPause(false);
    	
    	//VISIBLE btnStop , btnLap
    	setVisibleBotones(2);
    }
    
    public void onbtnStop (View v){
    	
    	//PAUSAR CRONOMETRO
    	aCrono.SetPause(true);
    	
    	//VISIBLE btnContinue, btnRestart
    	setVisibleBotones(3);
    }

    public void onbtnLap (View v){
    	
    	//REGISTRAR VUELTA
    	
    }
    
    public void onbtnContinue (View v){
    	
    	//CONTINUAR CRONOMETRO
    	aCrono.SetPause(false);
    	
    	//VISIBLE btnStop , btnLap
    	setVisibleBotones(2);
    }
    
    public void onbtnRestart (View v){
    	
    	//REINICIAR CRONOMETRO
    	
    	//INICIAR VISTA
    	InicializarVista();
    	
    }
    
    
    
    /*********************************
     *		INICIALIZAR VISTA
     *********************************/
	private void InicializarVista(){
		
		//VISIBLE btnStart
		setVisibleBotones(1);
	}
    
	
    /*********************************
     *		HIDDEN BOTONES
     *********************************/
    private void setVisibleBotones(int valor){
    	
    	int aWidthDiv = 0;
    	btnStart.setWidth( 0 );
    	btnStop.setWidth( 0 );
    	btnLap.setWidth( 0 );
    	btnContinue.setWidth(0);
    	btnRestart.setWidth(0);
    	
    	switch (valor){
    	
    		
    		case 1:
    			//VISIBLE btnStart
    	    	btnStart.setVisibility(View.VISIBLE);
    	    	btnStop.setVisibility(View.INVISIBLE);
    	    	btnLap.setVisibility(View.INVISIBLE);
    	    	btnContinue.setVisibility(View.INVISIBLE);
    	    	btnRestart.setVisibility(View.INVISIBLE);
    	
    	    	btnStart.setWidth( aWidth );
    			break;
    		
    		case 2:
        		//VISIBLE btnStop , btnLap
    			btnStart.setVisibility(View.INVISIBLE);
    	    	btnStop.setVisibility(View.VISIBLE);
    	    	btnLap.setVisibility(View.VISIBLE);
    	    	btnContinue.setVisibility(View.INVISIBLE);
    	    	btnRestart.setVisibility(View.INVISIBLE);
    	    	    			
    			aWidthDiv =  aWidth / 2;
    			btnStop.setWidth(aWidthDiv );
    			btnLap.setWidth( aWidthDiv );
        		break;
        		
    		case 3:
    			//VISIBLE btnContinue , btnRestart
    			btnStart.setVisibility(View.INVISIBLE);
    	    	btnStop.setVisibility(View.INVISIBLE);
    	    	btnLap.setVisibility(View.INVISIBLE);
    	    	btnContinue.setVisibility(View.VISIBLE);
    	    	btnRestart.setVisibility(View.VISIBLE);
    	    	
    	    	aWidthDiv =  aWidth / 2;
    			btnContinue.setWidth(aWidthDiv );
    			btnRestart.setWidth( aWidthDiv );
        		break;
       }
    }
    
    
    /*********************************
     *		INICIALIZAR OBJETOS
     *********************************/
     @SuppressWarnings("deprecation")
	private void SetInicializarObjetos(){
    	
        //BOTONES
        btnStart     = (Button)findViewById(R.id.btnStart);
        btnStop      = (Button)findViewById(R.id.btnStop);
        btnLap       = (Button)findViewById(R.id.btnLap);
        btnContinue  = (Button)findViewById(R.id.btnContinue);
        btnRestart   = (Button)findViewById(R.id.btnRestart);
        
        //DISPLAY
        lyBotones     = (LinearLayout)findViewById(R.id.lyBotones);
        lblHoras      = (TextView)findViewById(R.id.lblHoras);
        lblMinutos    = (TextView)findViewById(R.id.lblMinutos);
        lblSegundos   = (TextView)findViewById(R.id.lblSegundos);
        lblCentesimas = (TextView)findViewById(R.id.lblCentesimas);
        
        //ANCHO PANTALLA
		android.view.Display display = getWindowManager().getDefaultDisplay();
		aWidth = display.getWidth();
    }
    


	
}
