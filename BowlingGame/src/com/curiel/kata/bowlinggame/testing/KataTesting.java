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
		for(int i = 1; i<=20; i++)
			game.roll(0);
		assertEquals(0, game.score());
	}
	
	@Test
	public void allOneGame(){
		for(int i = 1; i<=20; i++)
			game.roll(1);
		assertEquals(20, game.score());		
	}

}
