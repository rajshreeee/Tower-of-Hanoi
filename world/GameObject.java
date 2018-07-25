package org.world;

import org.graphics.Animation;
import org.graphics.Graphics;

public class GameObject {
//posn
	public float x = 0;
	public float y =0;
	
	public float p = 0;
	public float q =0;
	

	public float a = 0;
	public float b =0;
	
	
	
	//size
	
	public float width = 30;
	public float height = 30;
	
	
	public float rotation = 0;
	
	public Animation[] animations;
	public int currentAnimation = 0;
	public void update(){}
	
	public void render(){
		animations[currentAnimation].play();

		Graphics.drawImage(animations[currentAnimation].getImage(), x-250, y+90, width+20, height+10);
		
		Graphics.drawImage(animations[currentAnimation].getImage(), p-250, q-30, width+90, height+30);
		
		Graphics.drawImage(animations[currentAnimation].getImage(), a-250, b+30, width+50, height+20);
		
		Graphics.towers(-250);

		Graphics.towers(0);

		Graphics.towers(250);
	}

}
