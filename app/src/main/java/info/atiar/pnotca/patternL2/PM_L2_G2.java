package info.atiar.pnotca.patternL2;

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

public class PM_L2_G2 extends AppCompatActivity {
    ImageView target1, target2,
            source1, source2, source3, source4;

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
        //constratcor for assistance
        ca = new CheckAnswer(2);

        String temp = this.getLocalClassName();
        String[] parts = temp.split(Pattern.quote("."));
        Game = Game + parts[1] + " - ";

        //initialize the media player
        welldone = MediaPlayer.create(this, R.raw.welldone);
        tryagain = MediaPlayer.create(this,R.raw.tryagain);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);

        setContentView(R.layout.activity_pm__l2__g2);


        target1 = (ImageView) findViewById(R.id.pm_target1);
        target2 = (ImageView) findViewById(R.id.pm_target2);

        source1 = (ImageView) findViewById(R.id.pm_source1);
        source2 = (ImageView) findViewById(R.id.pm_source2);
        source3 = (ImageView) findViewById(R.id.pm_source3);

        target1.setOnDragListener(dragListener);
        target2.setOnDragListener(dragListener);

        source1.setOnLongClickListener(longClickListener);
        source2.setOnLongClickListener(longClickListener);
        source3.setOnLongClickListener(longClickListener);
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

    @Override
    protected void onStop() {
        super.onStop();
        if (number_of_tries > 0){
            Game = Game + number_of_tries + " - " + status + " - " + totalTime + " Seconds <br>";

            //pass the data to GameStatus class
            gs.addToList(Game);
            System.out.println("List Object = " +Game);
        }
    }

    public void resetButton(View view) {
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
        imageDialog.setPositiveButton("Ok", new DialogInterface.OnClickListener() {

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

    View.OnLongClickListener longClickListener = new View.OnLongClickListener() {

        @Override
        public boolean onLongClick(View v) {
            ClipData data = ClipData.newPlainText("", "");
            View.DragShadowBuilder myShadowBuilder = new View.DragShadowBuilder(v);
            v.startDrag(data, myShadowBuilder, v, 0);
            return true;
        }
    };


    View.OnDragListener dragListener = new View.OnDragListener() {
        @Override
        public boolean onDrag(View v, DragEvent event) {
            int dragEvent = event.getAction();
            final View view = (View) event.getLocalState();


            switch (dragEvent) {
                case DragEvent.ACTION_DRAG_ENTERED:
                    break;
                case DragEvent.ACTION_DRAG_EXITED:
                    break;
                case DragEvent.ACTION_DROP:
                    number_of_tries++;
                    if (v.getId() == R.id.pm_target1) {
                        String details = v.getId() + " " + R.id.pm_target1 + " " + view.getId() + " " + R.id.pm_source1;


                        CheckAnswer caSingle = new CheckAnswer(1);
                        int temp = caSingle.performCheck(details);
                        if (temp == 1) {

                            view.animate()
                                    .x(target1.getX())
                                    .y(target1.getY())
                                    .setDuration(1000)
                                    .start();
                            //you can't move any others image on that position
                            target1.setOnDragListener(null);

                            int result = ca.performCheck(details);

                            if (result == 1) {
                                loadPhoto((ImageView) findViewById(R.id.pm_source1), 300, 300);
                                welldone.start();
                            } else if (result == -1) {
                                Message("Wrong Answer!!!!", "Oh !!!, You made a mistake");
                            }
                        } else if (temp == -1) {
                            tryagain.start();
                        }

                    } else if (v.getId() == R.id.pm_target2) {
                        String details = v.getId() + " " + R.id.pm_target2 + " " + view.getId() + " " + R.id.pm_source2;

                        CheckAnswer caSingle = new CheckAnswer(1);
                        int temp = caSingle.performCheck(details);
                        if (temp==1){
                            //you can't move any others image on that position
                            target2.setOnDragListener(null);

                            view.animate()
                                    .x(target2.getX())
                                    .y(target2.getY())
                                    .setDuration(1000)
                                    .start();

                            int result = ca.performCheck(details);
                            if (result == 1) {
                                loadPhoto((ImageView) findViewById(R.id.pm_source2), 300, 300);
                                welldone.start();
                            } else if (result == -1) {
                                Message("Wrong Answer!!!!", "Oh !!!, You made a mistake");
                            }

                        }else if (temp==-1){
                            tryagain.start();
                        }
                    }
            }


            return true;
        }
    };

}

/*
    MediaPlayer welldone, tryagain;

    welldone = MediaPlayer.create(this, R.raw.welldone);
    tryagain = MediaPlayer.create(this,R.raw.tryagain);

    CheckAnswer caSingle = new CheckAnswer(1);
    int temp = caSingle.performCheck(details);
    if (temp==1){

    }else if (temp==-1){
        tryagain.start();
    }
*/
