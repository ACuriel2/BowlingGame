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
		rollSpare();
		game.roll(2);
		rollMany(17, 1);
		assertEquals(31, game.score());
	}

	
	@Test
	public void testOneStrike(){
		rollStrike();
		game.roll(3);
		game.roll(4);
		rollMany(16, 1);
		assertEquals(40, game.score());
	}
	
	@Test
	public void testPerfectGame(){
		rollMany(12, 10);
		assertEquals(300, game.score());
	}

	private void assertSimilarRollSequence(int fallenPines, int expectedScore) {
		rollMany(20, fallenPines);
		assertEquals(expectedScore, game.score());
	}
	
	private void rollMany(int rolls, int fallenPines){
		for(int i = 1; i <= rolls; i++)
			game.roll(fallenPines);
	}
	
	private void rollStrike() {
		game.roll(10);
	}

	private void rollSpare() {
		game.roll(5);
		game.roll(5);
	}
}
