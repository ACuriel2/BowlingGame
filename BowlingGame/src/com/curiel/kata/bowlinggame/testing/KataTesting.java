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

	private void assertSimilarRollSequence(int fallenPines, int expectedScore) {
		for(int i = 1; i<=20; i++) {
			game.roll(fallenPines);
		}
		assertEquals(expectedScore, game.score());
	}

}
