package org.graphics;

import org.resource.ImageResource;

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.util.texture.Texture;

public class Graphics {

	public static void drawImage( ImageResource image, float x, float y, float width, float height){
		GL2 gl = EventListener.gl;
		
		Texture tex = image.getTexture();
		if(tex!=null){
			
			gl.glBindTexture(GL2.GL_TEXTURE_2D, tex.getTextureObject());
		}
	
		 gl.glBegin(GL2.GL_QUADS);
		 gl.glColor3f(  1f,1f,1f);
		 	gl.glTexCoord2f(0, 0);
		 	gl.glVertex2f(x-width/2,y-height/2);
		 	gl.glTexCoord2f(1, 0);
		 	gl.glVertex2f(x+width/2,y-height/2);
		 	gl.glTexCoord2f(1,1);
		 	gl.glVertex2f(x+width/2,y+height/2);
		 	gl.glTexCoord2f(0, 1);
		 	gl.glVertex2f(x-width/2,y+height/2);
		 	
		 gl.glEnd();
		 
		 
		
		 
		 
		 gl.glFlush();
		gl.glBindTexture(GL2.GL_TEXTURE_2D, 0);
	}
public static void towers(int x){
	GL2 gl = EventListener.gl;
	
	
	 gl.glBegin(GL2.GL_QUADS);
	 gl.glColor3f(  0.35f, 0.16f, 0.14f);
	 	gl.glTexCoord2f(0, 0);
	 	gl.glVertex2f(x,150);
	 	gl.glTexCoord2f(1, 0);
	 	gl.glVertex2f(x,-70);
	 	gl.glTexCoord2f(1,1);
	 	gl.glVertex2f(x+10,-70);
	 	gl.glTexCoord2f(0, 1);
	 	gl.glVertex2f(x+10,150);
	 	
	 gl.glEnd();
}
}
