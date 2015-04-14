package com.curiel.kata.bowlinggame.project;

public class Game {
	private int fallenPines;
	
	public Game() {
		fallenPines = 0;
	}
	
	public void roll(int fallenPines) {
		this.fallenPines += fallenPines;		
	}

	public int score() {
		return fallenPines;
	}

}
