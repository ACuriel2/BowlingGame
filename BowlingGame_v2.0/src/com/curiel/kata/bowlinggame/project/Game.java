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
		for(int pinesByRoll : rolls)
			score+=pinesByRoll;
		return score;
	}

}
