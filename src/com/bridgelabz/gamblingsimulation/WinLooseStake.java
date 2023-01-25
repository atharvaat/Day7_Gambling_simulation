package com.bridgelabz.gamblingsimulation;
import java.util.Random;

public class WinLooseStake {
	public static final int initialStake = 100;
	public static final int stakeBet = 1;
	public static final float percentage50 = (initialStake / 100) * 50;
	public static final float highestStake = percentage50 + initialStake;
	public static final float lowestStake = percentage50 - initialStake;

	static Random random = new Random();

	public static void main(String[] args) {

		int totalStake = initialStake;

		while (totalStake < highestStake && totalStake > lowestStake) {
			int play = random.nextInt(2);

			switch (play) {

			case 0:
				totalStake = totalStake - stakeBet;
				System.out.println("Stake after loosing: " + totalStake); 
				break;

			case 1:
				totalStake = totalStake + stakeBet;
				System.out.println("Stake after winning: " + totalStake);
				break;
			}

		}
	
		if (totalStake == highestStake)
			System.out.println("Gambler won by: " + totalStake);
		else
			System.out.println("Gambler lost by: " + totalStake);
	}
}
