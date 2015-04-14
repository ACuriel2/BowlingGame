package com.curiel.kata.bowlinggame.testing;

import static org.junit.Assert.*;

import org.junit.Test;

import com.curiel.kata.bowlinggame.project.Game;

public class KataTesting {

	@Test
	public void testGutterGame() {
		Game game = new Game();
		for(int i=0; i<20; i++)
			game.roll(0);
		assertEquals(0, game.score());
	}

}
