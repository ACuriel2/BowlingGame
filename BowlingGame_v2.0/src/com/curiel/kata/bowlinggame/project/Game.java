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
			if(getCurrentFrameValue(rollIndex) == 10)
				score += getCurrentFrameValue(rollIndex) + getSpareBonus(rollIndex);			
			else
				score+= getCurrentFrameValue(rollIndex);
			rollIndex += 2;
		}
		return score;
	}

	private int getSpareBonus(int rollIndex) {
		return rolls[rollIndex + 2];
	}

	private int getCurrentFrameValue(int rollIndex) {
		return rolls[rollIndex] + rolls[rollIndex + 1];
	}

}
