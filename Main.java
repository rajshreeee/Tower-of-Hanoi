package org.engine;

import org.graphics.Renderer;
import org.test.TestPlayer;
import org.world.World;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
Renderer.init();
GameLoop.start(); 

World.addObject(new TestPlayer());
	}

}
