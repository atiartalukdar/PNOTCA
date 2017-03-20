package info.atiar.pnotca.puzzleL1;

import android.content.ClipData;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.DragEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import info.atiar.pnotca.R;

public class PZ_L1_G1 extends AppCompatActivity {
    ImageButton target1,target2,target3,target4,source1,source2,source3,source4;
    LinearLayout l1,l2,l3,l4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);

        setContentView(R.layout.activity_pz__l1__g1);

        target1 = (ImageButton) findViewById(R.id.pz_l1_a1);
        target2 = (ImageButton) findViewById(R.id.pz_l1_a2);
        target3 = (ImageButton) findViewById(R.id.pz_l1_a3);
        target4 = (ImageButton) findViewById(R.id.pz_l1_a4);

        l1 = (LinearLayout) findViewById(R.id.a);
        l2 = (LinearLayout) findViewById(R.id.b);
        l3 = (LinearLayout) findViewById(R.id.c);
        l4 = (LinearLayout) findViewById(R.id.d);

        source1 = (ImageButton) findViewById(R.id.pz_l1_qa);
        source2 = (ImageButton) findViewById(R.id.pz_l1_qb);
        source3 = (ImageButton) findViewById(R.id.pz_l1_qc);
        source4 = (ImageButton) findViewById(R.id.pz_l1_qd);


        target1.setOnDragListener(dragListener);
        target2.setOnDragListener(dragListener);
        target3.setOnDragListener(dragListener);
        target4.setOnDragListener(dragListener);

        l1.setOnDragListener(dragListener);
        l2.setOnDragListener(dragListener);
        l3.setOnDragListener(dragListener);
        l4.setOnDragListener(dragListener);

        source1.setOnLongClickListener(longClickListener);
        source2.setOnLongClickListener(longClickListener);
        source3.setOnLongClickListener(longClickListener);
        source4.setOnLongClickListener(longClickListener);

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
                    if (view.getId() == R.id.pz_l1_qa && view.getId() == R.id.a){
                        ((ImageButton) view).setImageResource(R.drawable.pz_l1_qa);
                    }

                        view.animate()
                                .x(l1.getX())
                                .y(l2.getY())
                                .setDuration(1000)
                                .start();


                    break;
            }

            return true;
        }
    };
}
