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
			if(isSpare(currentRoll)){
				score += rolls[currentRoll + 2] + 10;
				currentRoll += 2;				
			}
			else if(rolls[currentRoll] == 10){
				score += rolls[currentRoll + 2] + rolls[currentRoll + 1] + 10;
				currentRoll += 1;
			}
			else{
				score += rolls[currentRoll] + rolls[currentRoll + 1];			
				currentRoll += 2;				
			}			
		}
		return score;
	}

	private boolean isSpare(int currentRoll) {
		return rolls[currentRoll] + rolls[currentRoll + 1] == 10;
	}
}
