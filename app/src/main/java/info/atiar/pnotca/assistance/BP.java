package info.atiar.pnotca.assistance;

/**
 * Created by DotNet on 4/9/2017.
 */

public class BP {


    public static void print(String data){
        System.out.println(data);
    }
    public static void print(int data){
        System.out.println(data);
    }
    public static void print(double data){
        System.out.println(data);
    }

    public static String listFormat(String game, int number_of_tries, boolean status, long totalTime){

        GameStatus gs = GameStatus.getInstance();
        gs.calculateSuccessAndAttempts(status);

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

    public static double successRate(int s,int a){
        double rate;

        double success = (double)s*1.0;
        double attempted = (double)a*1.0;

        BP.print(success);
        BP.print(attempted);
        rate = (success / (success+attempted) )*100.0;

        return rate;
    }



}
