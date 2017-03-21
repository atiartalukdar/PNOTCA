package info.atiar.pnotca.patternL2;

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

public class PM_L2_G2 extends AppCompatActivity {
    ImageView target1,target2,
            source1,source2,source3,source4;

    CheckAnswer ca;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ca = new CheckAnswer(2);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);

        setContentView(R.layout.activity_pm__l2__g2);


        target1 = (ImageView) findViewById(R.id.pm_target1);
        target2 = (ImageView) findViewById(R.id.pm_target2);

        source1 = (ImageView) findViewById(R.id.pm_source1);
        source2 = (ImageView) findViewById(R.id.pm_source2);

        target1.setOnDragListener(dragListener);
        target2.setOnDragListener(dragListener);

        source1.setOnLongClickListener(longClickListener);
        source2.setOnLongClickListener(longClickListener);
    }
    public void resetButton(View view){
        finish();
        startActivity(getIntent());
    }
    @Override
    public void finish() {
        super.finish();
        //    finish();

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
                    if (v.getId() == R.id.pm_target1){
                        String details = v.getId() +" "+ R.id.pm_target1 +" "+ view.getId() +" "+ R.id.pm_source1;

                        target1.setOnDragListener(null);


                        view.animate()
                                .x(target1.getX())
                                .y(target1.getY())
                                .setDuration(1000)
                                .start();

                        int result = ca.performCheck(details);
                        if (result==1){
                            loadPhoto((ImageView)findViewById(R.id.pm_source1),300,300);
                        }else if(result==-1){
                            Message("Wrong Answer!!!!","Oh !!!, You made a mistake");
                        }


                        Toast.makeText(PM_L2_G2.this, "Atiar Its dropped ",Toast.LENGTH_LONG).show();

                    } else if (v.getId() == R.id.pm_target2){
                        String details = v.getId() +" "+ R.id.pm_target2 +" "+ view.getId() +" "+ R.id.pm_source2;

                        target2.setOnDragListener(null);


                        view.animate()
                                .x(target2.getX())
                                .y(target2.getY())
                                .setDuration(1000)
                                .start();


                        int result = ca.performCheck(details);
                        if (result==1){
                            loadPhoto((ImageView)findViewById(R.id.pm_source2),300,300);
                        }else if(result==-1){
                            Message("Wrong Answer!!!!","Oh !!!, You made a mistake");
                        }
                        Toast.makeText(PM_L2_G2.this, "Atiar dropped it",Toast.LENGTH_LONG).show();

                    }
            }



            return true;
        }
    };
}
