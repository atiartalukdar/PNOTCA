package info.atiar.pnotca.puzzleL2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import info.atiar.pnotca.R;
import info.atiar.pnotca.puzzleL1.PZ_L1;
import info.atiar.pnotca.puzzleL1.PZ_L1_G1;
import info.atiar.pnotca.puzzleL1.PZ_L1_G2;

public class PZ_L2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pz__l2);
    }

    public void triangleFace(View view){
        Intent intent=new Intent(PZ_L2.this,PZ_l2_G1.class);
        startActivity(intent);
    }

    public void circleFace(View view){
        Intent intent=new Intent(PZ_L2.this,PZ_l2_G2.class);
        startActivity(intent);
    }
}
