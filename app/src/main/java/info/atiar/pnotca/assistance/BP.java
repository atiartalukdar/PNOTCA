package info.atiar.pnotca.assistance;

/**
 * Created by DotNet on 4/9/2017.
 */

public class BP {

    public static void print(String data){
        System.out.println(data);
    }

    public static String listFormat(String game, int number_of_tries, boolean status, long totalTime){

        String data = game + "&nbsp; &nbsp; &nbsp; &nbsp;" + number_of_tries + "&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;"
                + status + "&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;" + totalTime + " Sec <br>";

        return data;
    }
}
