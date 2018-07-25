package org.engine;

import org.graphics.Renderer;
import org.world.World;

public class GameLoop {

	/**
	 * @param args
	 */
	private static boolean running = false;
	
	private static int updates =0;
	private static final int MAX_UPDATES = 5;
	private static long lastUpdateTime = 0;
	private static int targetFPS =60;
	private static int targetTime =1000000000/targetFPS;
	public static void start(){
		Thread thread = new Thread(){
			public void run(){
				
				running = true;
				lastUpdateTime = System.nanoTime();
				int fps =0;
				long lastFpsCheck = System.nanoTime();
				
				while(running){
					
					long currentTime = System.nanoTime();
					updates = 0;
					while(currentTime - lastUpdateTime > targetTime){
						World.update();
						lastUpdateTime += targetTime;
						updates++;
						if (updates>MAX_UPDATES){
							break;
						}
					}
				Renderer.render();
				
				fps++;
				if(System.nanoTime() >= lastFpsCheck +1000000000){
					
					
					fps=0;
					lastFpsCheck = System.nanoTime();
				}
				
				long timeTaken = System.nanoTime() -currentTime;
				if(targetTime>timeTaken)
				{
					try {
						Thread.sleep((targetTime - timeTaken)/1000000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
					
					
				/*	long startTime = System.nanoTime();
					//poll input
					
					//update game
					World.update();
					//render game
					Renderer.render();
					
					long timeTaken = System.nanoTime() - startTime;
					
					if(timeTaken<targetTime){
					try {
						Thread.sleep((targetTime - timeTaken)/1000000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					}*/
					
				}
			}
		};
		thread.setName("Game loop");
		thread.start();
	}
	public static float updateDelta(){
		
		return 1.0f/1000000000 *targetTime;
	}
}
