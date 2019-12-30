import java.util.*;
class Game{
    private ArrayList<Integer> snakeStartPoint= new ArrayList<Integer>();
    private ArrayList<Integer> snakeEndPoint=new ArrayList<Integer>();
    private ArrayList<Integer> ladderStartPoint=new ArrayList<>();
    private ArrayList<Integer> ladderEndPoint=new ArrayList<>();
    Player p1=new Player("Nazeer");
    Player p2=new Player("Mohin");
    Game(){
        //snakes
        snakeStartPoint.add(16);
        snakeStartPoint.add(52);
        snakeStartPoint.add(78);
        snakeStartPoint.add(93);
        snakeStartPoint.add(95);
        snakeStartPoint.add(99);
        snakeEndPoint.add(8);
        snakeEndPoint.add(28);
        snakeEndPoint.add(25);
        snakeEndPoint.add(89);
        snakeEndPoint.add(75);
        snakeEndPoint.add(21);
        //ladder
        ladderStartPoint.add(2);
        ladderStartPoint.add(4);
        ladderStartPoint.add(9);
        ladderStartPoint.add(47);
        ladderStartPoint.add(70);
        ladderStartPoint.add(71);
        ladderEndPoint.add(45);
        ladderEndPoint.add(27);
        ladderEndPoint.add(31);
        ladderEndPoint.add(84);
        ladderEndPoint.add(87);
        ladderEndPoint.add(91);

    }
    public void  startGame(){
            p1.id=1;
            p2.id=2;
            Player currentPlayer=p1;
            while(!currentPlayer.isWin){
                int temp=currentPlayer.rollDice();
                System.out.println("##############Player"+currentPlayer.id+" ¯\\_(ツ)_/¯##########");
                System.out.println("Current Location: "+currentPlayer.location);
                System.out.println("Dice value: "+temp);
                if(currentPlayer.location+temp>100){
                    if(currentPlayer==p1) currentPlayer=p2;
                    else currentPlayer=p1;
                    continue;
                }
                else{
                    if(currentPlayer.location+temp==100){
                        currentPlayer.isWin=true;
                        break;
                    }
                    else{
                        int val=currentPlayer.location+temp;
                        if(snakeStartPoint.contains(val)){
                            for(int i=0;i<snakeStartPoint.size();i++){
                                if(snakeStartPoint.get(i)==val){
                                    currentPlayer.location=snakeEndPoint.get(i);
                                    System.out.println("Snake :( "+val+"-->"+currentPlayer.location);
                                    break;
                                }
                            }
                        }
                        else if(ladderStartPoint.contains(val)){
                            for(int i=0;i<ladderStartPoint.size();i++){
                                if(ladderStartPoint.get(i)==val){
                                    currentPlayer.location=ladderEndPoint.get(i);
                                    System.out.println("Ladder :) "+val+"-->"+currentPlayer.location);
                                    break;
                                }
                            }
                        }
                        else{
                            currentPlayer.location+=temp;
                            System.out.println(currentPlayer.name+": "+currentPlayer.location);
                        }

                    }
                }
                if(temp!=6) {
                    if (currentPlayer == p1) currentPlayer = p2;
                    else currentPlayer = p1;
                }
            }
            System.out.println(currentPlayer.name+" Wins (=^ェ^=)");
    }
}
class Player{
    int id;
    boolean isWin=false;
    int location;
    String name;
    Player(String name){
        this.name=name;

    }
    public int rollDice(){
        return (int)((Math.random())*(6))+1;
    }
}

public class GameTestDrive {
    public static  void main(String args[]){
        Game g=new Game();
        g.startGame();
    }
}
