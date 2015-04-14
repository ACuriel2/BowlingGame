package com.curiel.kata.bowlinggame.project;

import java.util.ArrayList;
import java.util.List;

public class Game {	
	private List<Frame> frames;
	private int currentRoll;
	private int currentFrame;
	
	public Game() {		
		frames = new ArrayList<Frame>();
		currentRoll = 1;
		currentFrame = 1;
	}

	public void roll(int fallenPines) {
		if(isNeededNewFrame()){
			createFrame(fallenPines);			
		}else{
			addToCurrentFrame(fallenPines);			
		}
	}

	public int score() {
		int score = 0;
		for(int i = 0; i<frames.size(); i++){
			if(isSpare(i))
				score += getCurrentFramePines(i) + getSpareBonus(i);
			else
				score += getCurrentFramePines(i);
		}			
		return score;
	}

	private boolean isSpare(int i) {
		return getCurrentFramePines(i) == 10;
	}
	
	private boolean isNeededNewFrame() {
		return currentRoll >= 2 || currentFrame == 1;
	}

	private void addToCurrentFrame(int fallenPines) {
		Frame frame = getCurrentFrame();
		frame.setFallenPines(fallenPines);
		currentRoll++;
	}

	private Frame getCurrentFrame() {
		return frames.get(currentFrame - 2);
	}

	private void createFrame(int fallenPines) {
		Frame frame = new Frame(currentFrame++);
		frame.setFallenPines(fallenPines);
		frames.add(frame);
		currentRoll = 1;
	}

	private int getCurrentFramePines(int i) {
		return currentFrame(i).getTotalFallenPines();
	}

	private Frame currentFrame(int i) {
		return frames.get(i);
	}

	private int getSpareBonus(int i) {
		return nextFrame(i).getFirstFallenPines();
	}

	private Frame nextFrame(int i) {
		return frames.get(i+1);
	}

}
