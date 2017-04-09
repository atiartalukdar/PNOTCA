package info.atiar.pnotca.assistance;

/**
 * Created by DotNet on 4/9/2017.
 */

public class BP {

    public static void print(String data){
        System.out.println(data);
    }

    public static String listFormat(String game, int number_of_tries, boolean status, long totalTime){

        String tempStatus = "";
        if (status == true){
            tempStatus = "Succeed";
        }else{
            tempStatus = "Attempted";
        }

        String data = game + "&nbsp; &nbsp; &nbsp; &nbsp;" + number_of_tries + "&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;"
                + tempStatus + "&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;" + totalTime + " Sec <br>";

        return data;
    }
}
