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
		int totalFallenPines = 0;
		for(int fallenPines : rolls)
			totalFallenPines += fallenPines;
		return totalFallenPines;
	}

}
