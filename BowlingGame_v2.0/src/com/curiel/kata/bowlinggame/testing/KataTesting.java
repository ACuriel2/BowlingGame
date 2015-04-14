package com.curiel.kata.bowlinggame.testing;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.curiel.kata.bowlinggame.project.Game;

public class KataTesting {
	Game game;
	
	@Before
	public void setup(){
		game = new Game();
	}

	@Test
	public void testGutterGame() {
		rollMany(0, 20);
		assertEquals(0, game.score());
	}
	
	@Test
	public void testAllOnesGame() {
		rollMany(1, 20);
		assertEquals(20, game.score());
	}
	
	@Test
	public void testOneSpareGame(){
		game.roll(4);
		game.roll(6);
		game.roll(4);
		rollMany(0, 17);
		assertEquals(18, game.score());
	}

	private void rollMany(int pines, int rolls) {
		for(int i=1; i<=rolls; i++)
			game.roll(pines);
	}

}
