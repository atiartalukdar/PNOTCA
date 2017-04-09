package info.atiar.pnotca.puzzleL2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import info.atiar.pnotca.R;

public class PZ_L2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pz__l2);
    }

    public void appleButton(View view){
        Intent intent=new Intent(PZ_L2.this,PZ_L2_G1.class);
        startActivity(intent);
    }

    public void flowerButton(View view){
        Intent intent=new Intent(PZ_L2.this,PZ_L2_G2.class);
        startActivity(intent);
    }
}
