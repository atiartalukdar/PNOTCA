package info.atiar.pnotca.puzzleL1;

import android.content.ClipData;
import android.content.DialogInterface;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.DragEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;

import java.util.regex.Pattern;

import info.atiar.pnotca.R;
import info.atiar.pnotca.assistance.CheckAnswer;
import info.atiar.pnotca.assistance.GameStatus;
import info.atiar.pnotca.patternL1.PM_L1_G1;

public class PZ_L1_G1 extends AppCompatActivity {
    ImageView target1,target2,target3,target4,source1,source2,source3,source4;

    CheckAnswer ca;
    MediaPlayer welldone, tryagain;

    GameStatus gs;
    String Game = "";
    int number_of_tries = 0;
    boolean status = false;
    long startTime = 0,endTime = 0,totalTime = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ca = new CheckAnswer(4);

        String temp = this.getLocalClassName();
        String[] parts = temp.split(Pattern.quote("."));
        Game = Game + parts[1] + " - ";

        welldone = MediaPlayer.create(this, R.raw.welldone);
        tryagain = MediaPlayer.create(this,R.raw.tryagain);

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

    @Override
    protected void onStart() {
        super.onStart();
        gs = new GameStatus();
        startTime = 0;
        endTime = 0;
        totalTime = 0;
    }

    @Override
    protected void onResume() {
        super.onResume();
        startTime = System.currentTimeMillis();
    }

    @Override
    protected void onPause() {
        super.onPause();
        endTime = System.currentTimeMillis();
        totalTime += (endTime - startTime)/1000; // tempTotalTime will store duration in seconds
    }

    public void resetButton(View view){
        finish();
        startActivity(getIntent());
    }

    public void exitButton(View view){
        PM_L1_G1 g = new PM_L1_G1();
        g.Message("Confirmation","Do you want to exit the game?",this);
    }

    @Override
    public void finish() {
        super.finish();
        //    finish();

    }
    //load photo on the popup window
    private void loadPhoto(ImageView imageView, int width, int height) {

        status = true;

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
                    number_of_tries++;

                    if (v.getId() == R.id.pz_l1_11){
                        String details = v.getId() +" "+ R.id.pz_l1_11 +" "+ view.getId() +" "+ R.id.pz_l1_q_11;

                        CheckAnswer caSingle = new CheckAnswer(1);
                        int temp = caSingle.performCheck(details);
                        if (temp==1){
                            target1.setOnDragListener(null);

                            view.animate()
                                    .x(target1.getX())
                                    .y(target1.getY())
                                    .setDuration(1000)
                                    .start();

                            int result = ca.performCheck(details);
                            if (result==1){
                                loadPhoto((ImageView)findViewById(R.id.pz_l1_triangle_back_imgView),400,400);
                                welldone.start();
                            }else if(result==-1){
                                Message("Wrong Answer!!!!","Oh !!!, You made a mistake");
                            }

                        }else if (temp==-1){
                            tryagain.start();
                        }

//##################################################################################################//
                        //option 2
//##################################################################################################//


                    }else if(v.getId() == R.id.pz_l1_12){
                        String details = v.getId() +" "+ R.id.pz_l1_12 +" "+ view.getId() +" "+ R.id.pz_l1_q_12;

                        CheckAnswer caSingle = new CheckAnswer(1);
                        int temp = caSingle.performCheck(details);
                        if (temp==1){
                            target2.setOnDragListener(null);

                            view.animate()
                                    .x(target2.getX())
                                    .y(target2.getY())
                                    .setDuration(1000)
                                    .start();

                            int result = ca.performCheck(details);
                            if (result==1){
                                loadPhoto((ImageView)findViewById(R.id.pz_l1_triangle_back_imgView),400,400);
                                welldone.start();
                            }else if(result==-1){
                                Message("Wrong Answer!!!!","Oh !!!, You made a mistake");
                            }

                        }else if (temp==-1){
                            tryagain.start();
                        }

//##################################################################################################//
                        //option 3
//##################################################################################################//

                    }else if(v.getId() == R.id.pz_l1_21){
                        String details = v.getId() +" "+ R.id.pz_l1_21 +" "+ view.getId() +" "+ R.id.pz_l1_q_21;

                        CheckAnswer caSingle = new CheckAnswer(1);
                        int temp = caSingle.performCheck(details);
                        if (temp==1){

                            target3.setOnDragListener(null);

                            view.animate()
                                    .x(target3.getX())
                                    .y(target3.getY())
                                    .setDuration(1000)
                                    .start();

                            int result = ca.performCheck(details);
                            if (result==1){
                                loadPhoto((ImageView)findViewById(R.id.pz_l1_triangle_back_imgView),400,400);
                                welldone.start();
                            }else if(result==-1){
                                Message("Wrong Answer!!!!","Oh !!!, You made a mistake");
                            }
                        }else if (temp==-1){
                            tryagain.start();
                        }


                    }

//##################################################################################################//
                    //option 4
//##################################################################################################//
                    else if(v.getId() == R.id.pz_l1_22){
                        String details = v.getId() +" "+ R.id.pz_l1_22 +" "+ view.getId() +" "+ R.id.pz_l1_q_22;

                        CheckAnswer caSingle = new CheckAnswer(1);
                        int temp = caSingle.performCheck(details);
                        if (temp==1){
                            target4.setOnDragListener(null);

                            view.animate()
                                    .x(target4.getX())
                                    .y(target4.getY())
                                    .setDuration(1000)
                                    .start();

                            int result = ca.performCheck(details);
                            if (result==1){
                                loadPhoto((ImageView)findViewById(R.id.pz_l1_triangle_back_imgView),400,400);
                                welldone.start();
                            }else if(result==-1){
                                Message("Wrong Answer!!!!","Oh !!!, You made a mistake");
                            }
                        }else if (temp==-1){
                            tryagain.start();
                        }
                    }
                    break;
            }
            return true;
        }
    };
}
