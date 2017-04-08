package info.atiar.pnotca.assistance;

import java.util.ArrayList;

/**
 * Created by DotNet on 4/8/2017.
 */

public class GameStatus {
    String emailBody;
    public static ArrayList<String> list = new ArrayList<String>();



    public void addToList(String data){
        list.add(data);
    }

    public String getEmailBody(){
        for(int i=0;i<getListSize();i++){
            emailBody = emailBody + list.remove(i);
        }
        System.out.print("List Size = " + getListSize() + "\n" + "Email Body = " + emailBody +"\n");
        return emailBody;
    }

    public int getListSize(){
        return list.size();
    }

    public void clearTheList(){
        list.clear();
    }



}
