package info.atiar.pnotca.assistance;

import java.util.ArrayList;

/**
 * Created by DotNet on 4/8/2017.
 */

public class GameStatus {

    //public static ArrayList<String> list = new ArrayList<String>();

///*
    private static GameStatus instance = new GameStatus();
    private ArrayList<String> list;

    private GameStatus(){

        list = new ArrayList<String>();

    }

    public static GameStatus getInstance(){
        if(instance == null){
            instance = new GameStatus();
        }
        return instance;
    }
//*/

    public void addToList(String data){
        list.add(data);
    }

    public String getEmailBody(){
        String emailBody = "";
        while (list.size()!=0){
            emailBody = list.remove(getListSize()-1)+emailBody;
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
