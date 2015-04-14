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
		if(isNeededNewFrame())
			createFrame(fallenPines);			
		else
			addToCurrentFrame(fallenPines);		
	}

	public int score() {
		int score = 0;
		for(int i = 0; i<frames.size(); i++)
			score += getFinalFrameResult(i);				
		return score;
	}
	
	private int getFinalFrameResult(int index){
		int finalPinesSum = 0;
		finalPinesSum += getCurrentFramePines(index);
		if(isStrike(index))
			finalPinesSum += getStrikeBonus(index);
		else if(isSpare(index))
			finalPinesSum += getSpareBonus(index);
		return finalPinesSum;
	}

	private int getStrikeBonus(int index) {
		return nextFrame(index).getTotalFallenPines();
	}

	private boolean isStrike(int index) {
		return thisFrame(index).getFirstFallenPines() == 10;
	}

	private boolean isSpare(int index) {
		return getCurrentFramePines(index) == 10;
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
		currentRoll = fallenPines == 10 ? 2 : 1;
	}

	private int getCurrentFramePines(int index) {
		return thisFrame(index).getTotalFallenPines();
	}

	private Frame thisFrame(int index) {
		return frames.get(index);
	}

	private int getSpareBonus(int index) {
		return nextFrame(index).getFirstFallenPines();
	}

	private Frame nextFrame(int index) {
		return frames.get(index+1);
	}

}
