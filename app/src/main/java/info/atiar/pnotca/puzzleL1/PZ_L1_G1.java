package info.atiar.pnotca.puzzleL1;

import android.content.ClipData;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.DragEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;

import info.atiar.pnotca.R;

public class PZ_L1_G1 extends AppCompatActivity {
    ImageView target1,target2,target3,target4,source1,source2,source3,source4;
    LinearLayout l1,l2,l3,l4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);

        setContentView(R.layout.activity_pz__l1__g1);

        target1 = (ImageView) findViewById(R.id.pz_l1_11);
        target2 = (ImageView) findViewById(R.id.pz_l1_12);

        source1 = (ImageView) findViewById(R.id.pz_l1_q_11);
        source2 = (ImageView) findViewById(R.id.pz_l1_q_12);


        target1.setOnDragListener(dragListener);
        target2.setOnDragListener(dragListener);

        source1.setOnLongClickListener(longClickListener);
        source2.setOnLongClickListener(longClickListener);

    }

    View.OnLongClickListener longClickListener = new View.OnLongClickListener(){

        @Override
        public boolean onLongClick(View v) {
            ClipData data = ClipData.newPlainText("","");
            View.DragShadowBuilder myShadowBuilder = new View.DragShadowBuilder(v);
            v.startDrag(data,myShadowBuilder,v,0);
            return true;
        }
    };

    View.OnDragListener dragListener = new View.OnDragListener() {
        @Override
        public boolean onDrag(View v, DragEvent event) {
            int dragEvent = event.getAction();
            final View view = (View) event.getLocalState();

            switch (dragEvent){
                case DragEvent.ACTION_DRAG_ENTERED:
                    break;
                case DragEvent.ACTION_DRAG_EXITED:
                    break;
                case DragEvent.ACTION_DROP:
                    view.animate()
                            .x(target1.getX())
                            .y(target1.getY())
                            .setDuration(1000)
                            .start();

                    /*if (view.getId() == R.id.pz_l1_q_11 && view.getId() == R.id.pz_l1_11){
                        ((ImageView) view).setImageResource(R.drawable.a);

                        Toast.makeText(PZ_L1_G1.this, "Image dropped 1",Toast.LENGTH_LONG).show();
                    }
                    else if (view.getId() == R.id.pz_l1_q_11 && view.getId() == R.id.pz_l1_11){
                        ((ImageView) view).setImageResource(R.drawable.b);

                        Toast.makeText(PZ_L1_G1.this, "Image dropped 2",Toast.LENGTH_LONG).show();
                    }*/




                    break;
            }

            return true;
        }
    };
}
