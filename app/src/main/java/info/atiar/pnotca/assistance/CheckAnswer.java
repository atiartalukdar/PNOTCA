package info.atiar.pnotca.assistance;

/**
 * Created by DotNet on 3/20/2017.
 */

public class CheckAnswer {

    boolean ALLOW_PRINT_OPERATION = true;

    int PIECES;
    int CORRECT;
    int INCORRECT;
    int DURATION = 1000;

    public int getDURATION() {
        return DURATION;
    }

    public CheckAnswer(int numberOfPieces){
        PIECES = numberOfPieces;
        CORRECT = 0;
        INCORRECT = 0;
    }

    // MASTER in format : "viewID viewReal vID vReal"
    public int performCheck(String master){

        int[] details = new int[4];

        String[] words = master.split("\\s");

        for(int i=0;i<4;i++){
            details[i] = Integer.parseInt(words[i]);
        }

        if(ALLOW_PRINT_OPERATION )
            for(int i: details)
                System.out.println(i);

        return comparator(details[0],details[1],details[2],details[3]);
    }

    int comparator(int viewID, int viewReal, int vID, int vReal){

        if(ALLOW_PRINT_OPERATION ) {
            if(viewID == viewReal)
                System.out.println("::::::::::::: FIRST CORRECT :::::::::::::");

            if(vID == vReal)
                System.out.println("::::::::::::: SECOND CORRECT :::::::::::::");
        }


        if(viewID == viewReal && vID == vReal){
            CORRECT++;

            if(ALLOW_PRINT_OPERATION )
                System.out.println("::::::::::::: RIGHT :::::::::::::");
        }
        else{
            INCORRECT++;

            if(ALLOW_PRINT_OPERATION )
                System.out.println("::::::::::::: WRONG :::::::::::::");
        }

        if(INCORRECT+CORRECT == PIECES){
            if(INCORRECT == 0)
                return 1; // CORRECT ANSWER
            else
                return -1; // INCORRECT ANSWER
        }
        else return 0; // CONTINUE GAME

    }

    // FREELY MOVABLE PIECE - SOLUTION
    /*
    int MAPPED;
    boolean[] checker;
    int[] imageMap;

    void initializeChecker(int n){
        checker = new boolean[n+1];
        imageMap = new int[n+1];

        for(int i=1;i<n+1;i++)
            checker[i] = false;

        MAPPED = 0;
        PIECES = n;
    }

    private int comparator(int position, int piece){
        int map = 0;

        for(int i=1;i<=MAPPED;i++){
            if(piece == imageMap[i]){
                map = i;
                break;
            }
        }

        // incase position accessed for the first time
        if(map == 0){
            MAPPED++;
            imageMap[MAPPED] = piece;
            map = MAPPED;
        }

        // check if piece is correctly placed or not
        if(position == piece)
            checker[map] = true;
        else checker[map] = false;

        int rightPlacement = 0;
        // check if all pieces are correctly placed
        for(int i=1;i<=PIECES;i++){
            if(checker[i] == true)
                rightPlacement++;
        }

        if(rightPlacement == PIECES)
            return 1; //ANSWER CORRECT
        else if(MAPPED == PIECES)
            return -1; //ANSWER WRONG
        else
            return 0; //DO NOTHING (Continue game)


    }
    */
}
