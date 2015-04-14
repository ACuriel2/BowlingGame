package com.curiel.kata.bowlinggame.project;

public class Game {
	private int rollCounter;
	private int[] rolls;
	
	public Game() {		
		rollCounter = 0;
		rolls = new int[21];
	}

	public void roll(int fallenPines) {
		rolls[rollCounter++] = fallenPines;
	}

	public int score() {
		int score = 0;
		int rollIndex = 0;
		for(int frame = 1; frame <= 10; frame++){
			if((rolls[rollIndex] + rolls[rollIndex + 1]) == 10)
				score += rolls[rollIndex] + rolls[rollIndex + 1] + rolls[rollIndex + 2];			
			else
				score+= rolls[rollIndex] + rolls[rollIndex + 1];
			rollIndex += 2;
		}
		return score;
	}

}
