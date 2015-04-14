package com.curiel.kata.bowlinggame.project;

public class Frame {
	private int number;
	private int[] rolls;
	private int currentRoll;
	
	public Frame(int currentFrame) {		
		rolls = new int[2];
		currentRoll = 0;
		number = currentFrame;
	}
	
	public int getNumber() {
		return number;
	}
	
	public void setFallenPines(int fallenPines){
		rolls[currentRoll++] = fallenPines;
	}
	
	public int getTotalFallenPines(){
		int totalPines = 0;
		for(int fallenPines : rolls)
			totalPines += fallenPines;
		return totalPines;
	}
	
	public int getFirstFallenPines(){
		return rolls[0];
	}
}
