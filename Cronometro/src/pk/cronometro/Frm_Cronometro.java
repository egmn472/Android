package pk.cronometro;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class Frm_Cronometro extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.frm_cronometro);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.frm_cronometro, menu);
        return true;
    }
}
