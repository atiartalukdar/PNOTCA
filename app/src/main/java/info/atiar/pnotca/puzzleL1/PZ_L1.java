package info.atiar.pnotca.puzzleL1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import info.atiar.pnotca.R;

public class PZ_L1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pz__l1);
    }

    public void triangleFace(View view){
        Intent intent=new Intent(PZ_L1.this,PZ_L1_G1.class);
        startActivity(intent);
    }

    public void circleFace(View view){
        Intent intent=new Intent(PZ_L1.this,PZ_L1_G2.class);
        startActivity(intent);
    }
}
