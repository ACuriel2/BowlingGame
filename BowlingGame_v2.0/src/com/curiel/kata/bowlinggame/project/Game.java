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

	public int score() {
		int score = 0;
		for(int i = 0; i<frames.size(); i++){
			if(frames.get(i).getTotalFallenPines() == 10)
				score += frames.get(i).getTotalFallenPines() + frames.get(i+1).getFirstFallenPines();
			else
				score += frames.get(i).getTotalFallenPines();
		}			
		return score;
	}

}
