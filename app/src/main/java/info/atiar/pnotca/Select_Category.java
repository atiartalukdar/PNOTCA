package info.atiar.pnotca;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class Select_Category extends AppCompatActivity {
    String category = "";
    //category = pattern, category = object, category = puzzle
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select__category);
    }

    public void pattrenMatching(View view){
        category = "pattern";
        Intent intent=new Intent(Select_Category.this,Select_Level.class);
        intent.putExtra("EXTRA_SESSION_ID", category);
        startActivity(intent);
    }

    public void objectIdentification(View view){
        category = "object";
        Intent intent=new Intent(Select_Category.this,Select_Level.class);
        intent.putExtra("EXTRA_SESSION_ID", category);
        startActivity(intent);
    }

    public void puzzle(View view){
        category = "puzzle";
        Intent intent=new Intent(Select_Category.this,Select_Level.class);
        intent.putExtra("EXTRA_SESSION_ID", category);
        startActivity(intent);
    }
}
