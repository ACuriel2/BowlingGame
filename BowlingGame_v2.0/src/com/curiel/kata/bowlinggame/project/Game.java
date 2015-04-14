package com.curiel.kata.bowlinggame.project;

public class Game {
	private int score;
	
	public Game() {
		score = 0;
	}

	public void roll(int fallenPines) {
		score += fallenPines;
	}

	public int score() {
		return score;
	}

}
