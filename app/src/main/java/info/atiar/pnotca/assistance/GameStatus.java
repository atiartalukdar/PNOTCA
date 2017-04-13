package info.atiar.pnotca.assistance;

import java.util.ArrayList;

/**
 * Created by DotNet on 4/8/2017.
 */

public class GameStatus {

    private static GameStatus instance = new GameStatus();
    private ArrayList<Attempt> list;
    private static int success   = 0;
    private static int attempted = 0;

    private GameStatus(){

        list = new ArrayList<Attempt>();

    }

    public static GameStatus getInstance(){
        if(instance == null){
            instance = new GameStatus();
        }
        return instance;
    }
//*/

    public void addToList(String data){
        list.add(new Attempt(data));
    }

    public String getEmailBody(){
        String emailBody = "";
        while (list.size()!=0){
            emailBody = list.remove(getListSize()-1).getData()+emailBody;
        }
        System.out.print("List Size = " + getListSize() + "\n" + "Email Body = " + emailBody +"\n");
        return emailBody;
    }


    public void calculateSuccessAndAttempts(boolean status){
        int s = 0, a = 0;
        if (status == true){
            s = getSuccess();
            s++;
            setSuccess(s);
        } else if (status == false){
            a = getAttempted();
            a++;
            setAttempted(a);
        }
    }

    public void setSuccess(int success) {
        this.success = success;
    }

    public void setAttempted(int attempted) {
        this.attempted = attempted;
    }

    public int getSuccess() {
        return success;
    }

    public int getAttempted() {
        return attempted;
    }

    public int getListSize(){
        return list.size();
    }

    public void clearTheList(){
        list.clear();
    }
    }