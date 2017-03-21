package info.atiar.pnotca.patternL1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import info.atiar.pnotca.R;

public class PM_L1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pm__l1);
    }

    //:::::::::::::::::::::::: Moving to Game two :::::::::::::::::::::::::::::::::://

    public void mangoButton(View view){
        Intent intent=new Intent(PM_L1.this,PM_L1_G2.class);
        startActivity(intent);

    }public void orangeButton(View view){
        Intent intent=new Intent(PM_L1.this,PM_L1_G2.class);
        startActivity(intent);

    }

    //:::::::::::::::::::::::: Moving to Game ONe :::::::::::::::::::::::::::::::::://

    public void catButton(View view){
        Intent intent=new Intent(PM_L1.this,PM_L1_G1.class);
        startActivity(intent);

    }public void treeButton(View view){
        Intent intent=new Intent(PM_L1.this,PM_L1_G1.class);
        startActivity(intent);

    }
}
