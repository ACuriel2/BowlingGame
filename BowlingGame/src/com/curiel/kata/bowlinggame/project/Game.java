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
				score += getSpareBonus(currentRoll) + 10;
				currentRoll += 2;				
			}
			else if(isStrike(currentRoll)){
				score += 10 + getStrikeBonus(currentRoll);
				currentRoll += 1;
			}
			else{
				score += getCurrentFramePines(currentRoll);			
				currentRoll += 2;				
			}			
		}
		return score;
	}

	private boolean isStrike(int currentRoll) {
		return rolls[currentRoll] == 10;
	}
	
	private boolean isSpare(int currentRoll) {
		return getCurrentFramePines(currentRoll) == 10;
	}

	private int getStrikeBonus(int currentRoll) {
		return rolls[currentRoll + 2] + rolls[currentRoll + 1];
	}

	private int getSpareBonus(int currentRoll) {
		return rolls[currentRoll + 2];
	}

	private int getCurrentFramePines(int currentRoll) {
		return rolls[currentRoll] + rolls[currentRoll + 1];
	}

}
