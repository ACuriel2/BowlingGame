package com.curiel.kata.bowlinggame.testing;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.curiel.kata.bowlinggame.project.Game;

public class KataTesting {
	private Game game;
	
	@Before
	public void setup(){
		game = new Game();		
	}
	
	@Test
	public void testGutterGame(){
		assertSimilarRollSequence(0, 0);
	}
	
	@Test
	public void allOneGame(){
		assertSimilarRollSequence(1, 20);		
	}
	
	@Test
	public void testOneSpare(){
		game.roll(5);
		game.roll(5);
		game.roll(2);
		rollMany(17, 1);
		assertEquals(31, game.score());
	}

	private void assertSimilarRollSequence(int fallenPines, int expectedScore) {
		rollMany(20, fallenPines);
		assertEquals(expectedScore, game.score());
	}
	
	private void rollMany(int rolls, int fallenPines){
		for(int i = 1; i <= rolls; i++)
			game.roll(fallenPines);
	}

}
