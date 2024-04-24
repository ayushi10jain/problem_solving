package CompanhWise;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;


public class SnakeLadderGame {
    public static int MAX_POINTS=100;
    public static Map<Integer, Integer> playerPoints = new HashMap();
    static int  player = -1;
    public static void main(String[] args) {
        fixSnakesOnBoard(50,20);
        fixLadderOnBoard(30, 20);

        while(getPlayerPosition(getPlayer())<100){
            getPlayerPosition(getPlayer());
        }

    }

    public static void fixSnakesOnBoard(int start, int end){
        Snake snake = new Snake(start, end);
        snake.fixSnake(start,end);
    }
    public static void fixLadderOnBoard(int start, int end){
        Ladder ladder = new Ladder(start, end);
        ladder.fixLadder(start, end);
    }

    public int startGame(){
        player = 1;
        return player;
    }

    public static int rollDice(){
        return (int) Math.random()*(6-0+1);
    }

    public static int getPlayerPosition(int player){
        int currenPosition = playerPoints.get(player);
        int diceNumber = rollDice();
        if(Objects.nonNull(currenPosition)){
            currenPosition = currenPosition + diceNumber;
            if(Snake.getSnake(currenPosition)!=null){
                currenPosition= Snake.getSnake(currenPosition).end;
            }
             else if(Ladder.getSnake(currenPosition)!=null){
                currenPosition = Ladder.getSnake(currenPosition).end;
             }
         if(currenPosition == MAX_POINTS){
            return player;
         }
        }
        playerPoints.put(player, currenPosition);
        setPlayer();
        return 0;
    }

    private static void setPlayer() {
        if(player == 1){
            player = 2;
        }else{
            player = 1;
        }
    }
    private static int getPlayer(){
        if(player == -1){
            return 1;
        }
        return player;
    }

}
