package com.bridgelabz.gamblingsimulation;
import java.util.Random;

public class EachMonth {
	   public static final int STAKE=100;
	    public static final int BET=1;
	    public static final int PERCENTAGE_50_STAKE=(STAKE/100)*50;
	    public static final int MAX_DAY=20;


public static void main(String[] args) {
        
   	GamblingSimulator gambling = new GamblingSimulator();
       System.out.println();
       System.out.println("Initial stake of Gambler is : "+STAKE);
       System.out.println("Initial betting money in gambling is : "+BET);
       System.out.println();
       startsGambling(gambling);

   }
   
    // Method for starting the game.
    
   public static void startsGambling(GamblingSimulator gambling) {
       //Declaring variables
       Random random = new Random();
       int highestStake = (int) (STAKE + (STAKE * PERCENTAGE_50_STAKE));
       int lowestStake = (int) (STAKE - (STAKE * PERCENTAGE_50_STAKE));

       
        // Checking randomly if win or loose with the condition for 20 days
        
       checkingCondition(highestStake,lowestStake,random);
   }
   public static void checkingCondition(int highestStake, int lowestStake, Random random) {
       int totalWon = 0,totalLost = 0,totalDollars = 0,maxProfit = 0,maxLoss = 0,maxCount;
       for (int i = 1; i <= MAX_DAY; i++) {
           int totalStake = STAKE;
           while (totalStake != highestStake && totalStake != lowestStake) {
               int bet = random.nextInt(2);
               switch (bet) {
                   case 1:
                       //Gambler Won
                       totalStake = totalStake + BET;
                       totalDollars = highestStake - STAKE;
                       maxProfit++;
                       break;
                   default:
                       //Gambler Lost
                       totalStake = totalStake - BET;
                       totalDollars = STAKE - lowestStake;
                       maxLoss++;
                       break;
               }
           }
           System.out.println("Gambler resigns for the day " + i);
           System.out.println("Amount remaining at Gambler is : " + totalStake);
           System.out.println("Amount won count by Gambler : "+maxProfit+" for day "+i);
           System.out.println("Amount lost count by Gambler : "+maxLoss+" for day "+i);
           if (totalStake == highestStake)
           {
               maxCount = maxProfit - maxLoss;
               System.out.println("Gambler having highest won count : "+maxCount+" for the day "+i);
               System.out.println("Gambler won by $" +totalDollars+" for the day "+i);
               totalWon = totalWon + totalDollars;
           }
           else if (totalStake == lowestStake)
           {
               maxCount = maxLoss - maxProfit;
               System.out.println("Gambler having highest lost count : "+maxCount+" for the day "+i);
               System.out.println("Gambler lost by $" +totalDollars+" for the day "+i);
               totalLost = totalLost + totalDollars;
           }
           System.out.println();
       }
       if(totalWon > totalLost)
       {
           int total = totalWon - totalLost;
           System.out.println("Gambler having overall total won $"+total+" in this 20 days");
       }
       else if (totalLost > totalWon)
       {
           int total = totalLost - totalWon;
           System.out.println("Gambler having overall total lost $"+total+" in this 20 days");
       }
       else if (totalWon == totalLost)
       {
           System.out.println("Gambler neither having total won or total lost in this 20 days");
       }
  }
}
