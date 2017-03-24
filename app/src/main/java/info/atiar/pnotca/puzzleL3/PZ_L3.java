package info.atiar.pnotca.puzzleL3;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import info.atiar.pnotca.R;

public class PZ_L3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pz__l3);
    }

    public void animalButton(View view){
        Intent intent=new Intent(PZ_L3.this,PZ_L3_G1.class);
        startActivity(intent);
    }

    public void kidsButton(View view){
        Intent intent=new Intent(PZ_L3.this,PZ_L3_G2.class);
        startActivity(intent);
    }
}

