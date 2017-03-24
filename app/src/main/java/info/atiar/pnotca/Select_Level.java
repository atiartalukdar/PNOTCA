package info.atiar.pnotca;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import info.atiar.pnotca.patternL1.PM_L1;
import info.atiar.pnotca.patternL2.PM_L2;
import info.atiar.pnotca.patternL3.PM_L3;
import info.atiar.pnotca.puzzleL1.PZ_L1;
import info.atiar.pnotca.puzzleL2.PZ_L2;
import info.atiar.pnotca.puzzleL3.PZ_L3;

public class Select_Level extends AppCompatActivity {
    String category = "";
    //category = pattern, category = object, category = puzzle
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select__level);

        category = getIntent().getStringExtra("EXTRA_SESSION_ID");
    }

    public void backButton(View view){
        onBackPressed();
    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        //    finish();

    }


    public void simpleLevel(View view){
        if (category.equals("pattern")){

           Intent intent=new Intent(Select_Level.this,PM_L1.class);
            startActivity(intent);

        }else if (category.equals("object")){
            Toast.makeText(Select_Level.this,R.string.feature_comming_soon,Toast.LENGTH_LONG).show();

           /* Intent intent=new Intent(Select_Level.this,OB_L1.class);
            startActivity(intent);*/

        }else if (category.equals("puzzle")){
            Intent intent=new Intent(Select_Level.this,PZ_L1.class);
            startActivity(intent);
        }

    }

    public void medianLevel(View view){
        if (category.equals("pattern")){

           Intent intent=new Intent(Select_Level.this,PM_L2.class);
            startActivity(intent);

        }else if (category.equals("object")){
            Toast.makeText(Select_Level.this,R.string.feature_comming_soon,Toast.LENGTH_LONG).show();

           /* Intent intent=new Intent(Select_Level.this,OB_L2.class);
            startActivity(intent);*/

        }else if (category.equals("puzzle")){
            Intent intent=new Intent(Select_Level.this,PZ_L2.class);
            startActivity(intent);
        }
    }

    public void advancedLevel(View view){
        if (category.equals("pattern")){
           Intent intent=new Intent(Select_Level.this,PM_L3.class);
            startActivity(intent);

        }else if (category.equals("object")){
            Toast.makeText(Select_Level.this,R.string.feature_comming_soon,Toast.LENGTH_LONG).show();

           /* Intent intent=new Intent(Select_Level.this,OB_L3.class);
            startActivity(intent);*/

        }else if (category.equals("puzzle")){
            Intent intent=new Intent(Select_Level.this,PZ_L3.class);
            startActivity(intent);
        }
    }
}
