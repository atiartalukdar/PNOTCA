package info.atiar.pnotca.assistance;

/**
 * Created by DotNet on 3/20/2017.
 */

public class CheckAnswer {

    int PIECES;
    int MAPPED;
    boolean[] checker;
    int[] imageMap;


    public CheckAnswer(int numberOfPieces){
        initializeChecker(numberOfPieces);
    }

    void initializeChecker(int n){
        checker = new boolean[n+1];
        imageMap = new int[n+1];

        for(int i=1;i<n+1;i++)
            checker[i] = false;

        MAPPED = 0;
        PIECES = n;
    }

    public int performCheck(int position, int piece){

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

}
