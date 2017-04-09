package info.atiar.pnotca;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import info.atiar.pnotca.assistance.GameStatus;

public class Start extends AppCompatActivity {

    GameStatus gs = GameStatus.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

    }

    public void start(View view){
        Intent intent=new Intent(Start.this,Select_Category.class);
        startActivity(intent);
    }
}
