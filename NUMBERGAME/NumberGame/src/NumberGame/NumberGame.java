package NumberGame;

import java.util.Random;
import java.util.Scanner;

public class NumberGame {
    static int CompNum, UserNum,chances=0;
    public static void NumGame(){
        //taking user input
        Scanner sc= new Scanner(System.in);
        System.out.print("Guess the number in range 0 to 100: ");
        UserNum=sc.nextInt();
        //counting number of chances
        chances=chances+1;

        if (UserNum>CompNum)
            System.out.println("XXXXX Your guessed number is too high XXXXX");
        else if(UserNum<CompNum)
            System.out.println("XXXXX Your guessed number is too less XXXXX");
        }

    public static void main(String[] args) {
        System.out.println("You have only 10 attempts.....");
        //generating random number
        Random ran = new Random();
        CompNum = ran.nextInt(0, 101);

        //driver code
        while(UserNum!=CompNum){
            NumGame();
            //limiting attempts
            if (chances==10)
            {
                System.out.println("%%% YOU LOSE %%");
                break;
            }
        }
        if(chances<10)
             System.out.println("!!!*****Congrats you guessed the number in "+chances+" chances*****!!!");
    }
}