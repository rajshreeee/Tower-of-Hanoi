package org.graphics;



import java.awt.Font;

import org.input.KeyInput;
import org.resource.ImageResource;
import org.world.World;

import com.jogamp.newt.event.KeyEvent;
import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLEventListener;
import com.jogamp.opengl.util.awt.TextRenderer;


public class EventListener  implements GLEventListener{

	public static float x =30;
	public static GL2 gl =null;
public static ImageResource image = null;
	

public void display(GLAutoDrawable drawable) {
		 gl = drawable.getGL().getGL2();
		gl.glClear(GL2.GL_COLOR_BUFFER_BIT);
	
	//Graphics.fillRect( x,50,30,50);
	//Graphics.drawImage(image, 0, 0, 100, 100);
		TextRenderer textRenderer = new TextRenderer(new Font("Verdana", Font.BOLD, 14));
		textRenderer.beginRendering(900, 700);
		textRenderer.setColor(1, 0, 0, 1);
		textRenderer.setSmoothing(true);

		
		textRenderer.draw("-> Use up,down,left and right key to control the smallest disc.", (int) 50,50);
		textRenderer.draw("-> Use W,S,A and D key to control the largest disc.", (int) 50,70);
		textRenderer.draw("-> Use I,K,J and L key to control the medium disc.", (int) 50,30);
		textRenderer.endRendering();
		World.render();
	}

	public void dispose(GLAutoDrawable drawable) {
		
		
	}

	public void init(GLAutoDrawable drawable) {
		GL2 gl = drawable.getGL().getGL2();
		
		gl.glClearColor(1,1,1,1);
		gl.glEnable(GL2.GL_TEXTURE_2D);
		//image = new ImageResource("/res/oval.png");
		//System.out.println(image);
	}

	public void reshape(GLAutoDrawable drawable, int x, int y, int width,
			int height) {
		
		GL2 gl = drawable.getGL().getGL2();
		
		gl.glMatrixMode(GL2.GL_PROJECTION);
		gl.glLoadIdentity();
		gl.glOrtho(-320, 320, -180, 180, -1, 1);
		gl.glMatrixMode(GL2.GL_MODELVIEW);
		
		
	}
	
	

}
