package info.atiar.pnotca;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;

import java.util.Arrays;
import java.util.List;

import info.atiar.pnotca.assistance.BP;
import info.atiar.pnotca.assistance.GameStatus;
import info.atiar.pnotca.gmailAssistance.SendMailTask;

public class Register extends AppCompatActivity {

    GameStatus gs = GameStatus.getInstance();

    String emailBody4Title = "<p style=\"text-align: left;\"><strong><span style=\"text-decoration: underline;\">GAME</span>&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;<span style=\"text-decoration: underline;\">TRIES</span>&nbsp; &nbsp; &nbsp;&nbsp;<span style=\"text-decoration: underline;\">STATUS</span> &nbsp; &nbsp; &nbsp; &nbsp; <span style=\"text-decoration: underline;\">ELAPSED</span><br /></strong></p>";
    String emailBody3Title = "<p><strong>GAME&nbsp; &nbsp; &nbsp;&nbsp;STATUS &nbsp; &nbsp; &nbsp; &nbsp; ELAPSED<br /></strong></p>";

    String fromEmail = "pnotca@gmail.com";
    String fromPassword = "123asdASD";
    String toEmails = "bilalsalas@gmail.com";

    /*List toEmailList = Arrays.asList(toEmails
            .split("\\s*,\\s*"));*/

    String emailSubject = "Testing Email";
    String emailBody = "";

    EditText email;
    EditText specialistName;
    EditText childAge;
    EditText childName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        email = (EditText) findViewById(R.id.emailED);
        specialistName = (EditText) findViewById(R.id.nameOfSpecialistED);
        childAge = (EditText) findViewById(R.id.childAgeED);
        childName = (EditText) findViewById(R.id.childNameED);
    }

    public void sendFeedback(View view){

        CharSequence temp_emilID=email.getText().toString();//here email is your edittext object...

        if(!isValidEmail(temp_emilID))
        {
            email.requestFocus();
            email.setError("Enter Correct Mail_ID ..!!");
            /*or
            Toast.makeText(getApplicationContext(), "Enter Correct Mail_ID", Toast.LENGTH_SHORT).show();*/
        }
        else
        {
            List toEmailList = Arrays.asList(email.getText().toString().trim(),"swajan.talukdar@gmail.com");
            String specialist = specialistName.getText().toString();
            String ageOfChild = childAge.getText().toString().trim();
            String nameOfChild = childName.getText().toString();

            String bodyHead = "Child Name = " + nameOfChild + "<br>Child Age = " + ageOfChild + "<br>Specialist Name = " + specialist + "<br><br><br>";
            String successRate = "<br><br><br>Success Rate = " + BP.successRate(gs.getSuccess(),gs.getAttempted())+"%";

            emailBody = bodyHead + emailBody3Title + gs.getEmailBody() + successRate;

            BP.print(successRate);

            new SendMailTask(this).execute(fromEmail,
                    fromPassword, toEmailList, emailSubject, emailBody);

            gs.clearTheList();
        }




    }

    public final static boolean isValidEmail(CharSequence target)
    {
        if (TextUtils.isEmpty(target))
        {
            return false;
        } else {
            return android.util.Patterns.EMAIL_ADDRESS.matcher(target).matches();
        }
    }

    public void MessageOnly(String Title, String Message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(Title);
        builder.setMessage(Message);

        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {

            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });

        AlertDialog alert = builder.create();
        alert.show();
    }
}
