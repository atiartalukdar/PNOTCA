package info.atiar.pnotca;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import java.util.Arrays;
import java.util.List;

import info.atiar.pnotca.assistance.GameStatus;
import info.atiar.pnotca.gmailAssistance.SendMailTask;

public class Register extends AppCompatActivity {

    GameStatus gs = GameStatus.getInstance();

    String emailBodyTitle = "<p style=\"text-align: left;\"><strong><span style=\"text-decoration: underline;\">GAME</span>&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;<span style=\"text-decoration: underline;\">TRIES</span>&nbsp; &nbsp; &nbsp;&nbsp;<span style=\"text-decoration: underline;\">STATUS</span> &nbsp; &nbsp; <span style=\"text-decoration: underline;\">ELAPSED</span><br /></strong></p>";

    String fromEmail = "pnotca@gmail.com";
    String fromPassword = "freelancer";
    String toEmails = "bilalsalas@gmail.com";

    /*List toEmailList = Arrays.asList(toEmails
            .split("\\s*,\\s*"));*/

    List toEmailList = Arrays.asList(toEmails,"swajan.talukdar@gmail.com");

    String emailSubject = "Testing Email";
    String emailBody = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
    }

    public void sendFeedback(View view){

        emailBody = emailBodyTitle+gs.getEmailBody();

        new SendMailTask(this).execute(fromEmail,
                fromPassword, toEmailList, emailSubject, emailBody);

        gs.clearTheList();

       /* finish();
        System.exit(0);*/
    }
}
