package info.atiar.pnotca.puzzleL1;

import android.content.ClipData;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.DragEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.Toast;

import info.atiar.pnotca.R;
import info.atiar.pnotca.assistance.CheckAnswer;

public class PZ_L1_G1 extends AppCompatActivity {
    ImageView target1,target2,target3,target4,source1,source2,source3,source4;

    CheckAnswer ca;
    boolean flag = false;
    int counter = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ca = new CheckAnswer(4);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);

        setContentView(R.layout.activity_pz__l1__g1);

        target1 = (ImageView) findViewById(R.id.pz_l1_11);
        target2 = (ImageView) findViewById(R.id.pz_l1_12);
        target3 = (ImageView) findViewById(R.id.pz_l1_21);
        target4 = (ImageView) findViewById(R.id.pz_l1_22);

        source1 = (ImageView) findViewById(R.id.pz_l1_q_11);
        source2 = (ImageView) findViewById(R.id.pz_l1_q_12);
        source3 = (ImageView) findViewById(R.id.pz_l1_q_21);
        source4 = (ImageView) findViewById(R.id.pz_l1_q_22);


        target1.setOnDragListener(dragListener);
        target2.setOnDragListener(dragListener);
        target3.setOnDragListener(dragListener);
        target4.setOnDragListener(dragListener);

        source1.setOnLongClickListener(longClickListener);
        source2.setOnLongClickListener(longClickListener);
        source3.setOnLongClickListener(longClickListener);
        source4.setOnLongClickListener(longClickListener);

    }
    //load photo on the popup window
    private void loadPhoto(ImageView imageView, int width, int height) {

        ImageView tempImageView = imageView;


        AlertDialog.Builder imageDialog = new AlertDialog.Builder(this);
        LayoutInflater inflater = (LayoutInflater) this.getSystemService(LAYOUT_INFLATER_SERVICE);

        View layout = inflater.inflate(R.layout.custom_fullimage_dialog,
                (ViewGroup) findViewById(R.id.layout_root));
        ImageView image = (ImageView) layout.findViewById(R.id.fullimage);
        image.setImageDrawable(tempImageView.getDrawable());
        imageDialog.setView(layout);
        imageDialog.setPositiveButton("Ok", new DialogInterface.OnClickListener(){

            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }

        });


        imageDialog.create();
        imageDialog.show();
    }

    //load message on pop up window
    public void Message(String Title, String Message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(Title);
        builder.setMessage(Message);

        builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {

            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });

        builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {

                // Do nothing
                dialog.dismiss();
            }
        });

        AlertDialog alert = builder.create();
        alert.show();
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
                    if (v.getId() == R.id.pz_l1_11){
                        String details = view.getId() +" "+ R.id.pz_l1_11 +" "+ v.getId() +" "+ R.id.pz_l1_q_11;

                        target1.setOnDragListener(null);

                        view.animate()
                                .x(target1.getX())
                                .y(target1.getY())
                                .setDuration(1000)
                                .start();

                        if (ca.performCheck(details) == 1){
                            loadPhoto((ImageView)findViewById(R.id.pz_l1_triangle_back_imgView),400,400);
                        }else if(ca.performCheck(details) == -1){
                            Message("Wrong Answer!!!!","Oh !!!, You made a mistake");
                        }


                        Toast.makeText(PZ_L1_G1.this, "Dropped @ 11 = "+counter + flag,Toast.LENGTH_LONG).show();

                    }else if(v.getId() == R.id.pz_l1_12){
                        String details = view.getId() +" "+ R.id.pz_l1_12 +" "+ v.getId() +" "+ R.id.pz_l1_q_12;
                        target2.setOnDragListener(null);

                        view.animate()
                                .x(target2.getX())
                                .y(target2.getY())
                                .setDuration(1000)
                                .start();

                        if (ca.performCheck(details) == 1){
                            loadPhoto((ImageView)findViewById(R.id.pz_l1_triangle_back_imgView),400,400);
                        }else if(ca.performCheck(details) == -1){
                            Message("Wrong Answer!!!!","Oh !!!, You made a mistake");
                        }
                        Toast.makeText(PZ_L1_G1.this, "Dropped @ 12",Toast.LENGTH_LONG).show();

                    }else if(v.getId() == R.id.pz_l1_21){
                        String details = view.getId() +" "+ R.id.pz_l1_21 +" "+ v.getId() +" "+ R.id.pz_l1_q_21;
                        target3.setOnDragListener(null);

                        view.animate()
                                .x(target3.getX())
                                .y(target3.getY())
                                .setDuration(1000)
                                .start();

                        if (ca.performCheck(details) == 1){
                            loadPhoto((ImageView)findViewById(R.id.pz_l1_triangle_back_imgView),400,400);
                        }else if(ca.performCheck(details) == -1){
                            Message("Wrong Answer!!!!","Oh !!!, You made a mistake");
                        }
                        Toast.makeText(PZ_L1_G1.this, "Dropped @ 21= "+counter+ flag,Toast.LENGTH_LONG).show();


                    }
                    else if(v.getId() == R.id.pz_l1_22){
                        String details = view.getId() +" "+ R.id.pz_l1_22 +" "+ v.getId() +" "+ R.id.pz_l1_q_22;
                        target4.setOnDragListener(null);

                        view.animate()
                                .x(target4.getX())
                                .y(target4.getY())
                                .setDuration(1000)
                                .start();

                        if (ca.performCheck(details) == 1){
                            loadPhoto((ImageView)findViewById(R.id.pz_l1_triangle_back_imgView),400,400);
                        }else if(ca.performCheck(details) == -1){
                            Message("Wrong Answer!!!!","Oh !!!, You made a mistake");
                        }

                        Toast.makeText(PZ_L1_G1.this, "Dropped @ 22= "+counter+ flag,Toast.LENGTH_LONG).show();

                    }
                    break;
            }



            return true;
        }
    };
}
