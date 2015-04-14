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
			if(isStrike(rollIndex)){
				score += getFirstRollOfFrame(rollIndex) + getStrikeBonus(rollIndex);
				rollIndex++;
			}else{
				score += getCurrentFrameValue(rollIndex);
				if(isSpare(rollIndex))
					score += getSpareBonus(rollIndex);				
				rollIndex += 2;			
			}
		}
		return score;
	}

	private boolean isSpare(int rollIndex) {
		return getCurrentFrameValue(rollIndex) == 10;
	}

	private boolean isStrike(int rollIndex) {
		return getFirstRollOfFrame(rollIndex) == 10;
	}

	private int getFirstRollOfFrame(int rollIndex) {
		return rolls[rollIndex];
	}

	private int getStrikeBonus(int rollIndex) {
		return rolls[rollIndex + 1] + rolls[rollIndex + 2];
	}

	private int getSpareBonus(int rollIndex) {
		return rolls[rollIndex + 2];
	}

	private int getCurrentFrameValue(int rollIndex) {
		return getFirstRollOfFrame(rollIndex) + rolls[rollIndex + 1];
	}

}
