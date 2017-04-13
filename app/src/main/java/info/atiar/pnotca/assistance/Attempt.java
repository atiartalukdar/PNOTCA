package info.atiar.pnotca.assistance;

/**
 * Created by DotNet on 4/13/2017.
 */

public class Attempt {
    String time;
    String game;
    String isSuccessful;

    public Attempt(String data){
        /** UNPACK data **/
        String d[] = data.split("\\*");
        String game = d[0];
        String isSuccessful = d[1];
        String time = d[2];

        setter(game,isSuccessful,time);
    }

    private void setter(String game, String isSuccessful, String time){
        this.time = time;
        this.game = game;
        this.isSuccessful = isSuccessful;
    }
    public String getData(){
        String data = game + "&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;" + isSuccessful + "&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;"
                + time + " Sec <br>";

        return data;
    }

    public String getSuccess(){
        return isSuccessful;
    }
}
