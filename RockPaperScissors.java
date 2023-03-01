import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.io.FileWriter;

public class RockPaperScissors {


    public static void main(String[] args) throws IOException {
        int Score =0;
        String playerName ="";
        int HighScore =0;
        File obj = new File("highScore.txt");
        if(obj.createNewFile()) {
            obj.createNewFile();//create file
        }
        else{
            File o = new File("highScore.txt");
            Scanner read = new Scanner(o);
            read.useDelimiter("\\Z");
            HighScore = read.nextInt();

        }
        System.out.println(HighScore);

        //read the score in  highScore.txt
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter Player Name: ");
        playerName = scan.nextLine();
        while(true){
            String[] rps = {"r","p","s"};
            String ComputerMove = rps[new Random().nextInt(rps.length)];
            String PlayerMove;
            while(true){
                System.out.println("Please enter your move \nr-Rock\np-Paper\ns-Scissor");
                System.out.print("Enter your Move: ");
                PlayerMove = scan.nextLine();
                if(PlayerMove.equals("r")|| PlayerMove.equals("p")|| PlayerMove.equals("s")){
                    break;
                }
                else{
                    System.out.println("You entered invalid move");
                }
            }
            System.out.println("Computer Played: "+ComputerMove);
            if(PlayerMove.equals(ComputerMove)){
                System.out.println("Game was tie!");
            }
            else if(PlayerMove.equals("r")){
                if(ComputerMove.equals("p")){
                    System.out.println("You lose!");
                }
                else if (ComputerMove.equals("s")){
                    System.out.println("You Win!");
                    Score++;
                }
            }
            else if(PlayerMove.equals("p")){
                if(ComputerMove.equals("r")){
                    System.out.println("You win!");
                    Score++;
                }
                else if (ComputerMove.equals("s")){
                    System.out.println("You lose!");
                }
            }
            else if(PlayerMove.equals("s")){
                if(ComputerMove.equals("r")){
                    System.out.println("You lose!");
                }
                else if (ComputerMove.equals("p")){
                    System.out.println("You Win!");
                    Score++;
                }
                File ob = new File("highScore.txt");
                Scanner Reader = new Scanner(ob);
                Reader.useDelimiter("\\Z");
                HighScore = Reader.nextInt();

               // write the score in highScore.txt
                FileWriter fw = new FileWriter("highScore.txt");
               String highScore = String.valueOf(Score);
                fw.write(highScore);
                fw.close();//close filewriter



                if(Score>HighScore){
                    FileWriter overwrite = new FileWriter("highScore.txt");
                    overwrite.flush();
                    overwrite.write(Score);
                    overwrite.close();
                }


            }
            System.out.println("do you like to play again (y/n)?: ");
            String PlayerChoice = scan.nextLine();
            if(PlayerChoice.equals("n")){
                if(Score>0){
                    if(Score>HighScore)
                    System.out.println("Congrulations "+playerName+" You set a new high score: "+Score);
                    else{
                        System.out.println(playerName+" your Score is "+Score);
                    }
                }
                System.out.println("Thanks for Playing!");
                break;
            }
        }
    }
}
