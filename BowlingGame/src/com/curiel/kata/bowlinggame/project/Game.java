package com.curiel.kata.bowlinggame.project;

public class Game {	
	private int[] rolls;
	private int rollsCounter;
	
	public Game() {		
		rolls = new int[21];
		rollsCounter = 0;
	}
	
	public void roll(int fallenPines) {
		rolls[rollsCounter++] = fallenPines;		
	}

	public int score() {
		int score = 0;
		int currentRoll = 0;
		for(int frame = 1; frame <= 10; frame ++){
			score += getFallenPinesInFrame(currentRoll);			
			currentRoll += 2;		
		}
		return score;
	}

	private boolean isSpare(int currentRoll) {
		return rolls[currentRoll] + rolls[currentRoll + 1] == 10;
	}
	
	private int getFallenPinesInFrame(int currentRoll){
		int totalFallenPines = 0;
		if(isSpare(currentRoll))
			totalFallenPines += rolls[currentRoll + 2] + 10;			
		else
			totalFallenPines += rolls[currentRoll] + rolls[currentRoll + 1];
		return totalFallenPines;
	}


}
