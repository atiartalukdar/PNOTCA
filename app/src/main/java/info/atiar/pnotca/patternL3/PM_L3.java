package info.atiar.pnotca.patternL3;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import info.atiar.pnotca.R;

public class PM_L3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pm__l3);
    }


    //:::::::::::::::::::::::: Moving to Game One :::::::::::::::::::::::::::::::::://

    public void flower1Button(View view){
        Intent intent=new Intent(PM_L3.this,PM_L3_G1.class);
        startActivity(intent);

    }public void flower2Button(View view){
        Intent intent=new Intent(PM_L3.this,PM_L3_G1.class);
        startActivity(intent);

    }
    public void flower3Button(View view){
        Intent intent=new Intent(PM_L3.this,PM_L3_G1.class);
        startActivity(intent);

    }

    //:::::::::::::::::::::::: Moving to Game Two :::::::::::::::::::::::::::::::::://

    public void icecreamButton(View view){
        Intent intent=new Intent(PM_L3.this,PM_L3_G2.class);
        startActivity(intent);

    }public void scissorButton(View view){
        Intent intent=new Intent(PM_L3.this,PM_L3_G2.class);
        startActivity(intent);

    }public void cowButton(View view){
        Intent intent=new Intent(PM_L3.this,PM_L3_G2.class);
        startActivity(intent);

    }
}
