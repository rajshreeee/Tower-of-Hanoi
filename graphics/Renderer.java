package org.graphics;

import org.engine.GameLoop;
import org.input.KeyInput;
import org.test.TestPlayer;
import org.world.World;

import com.jogamp.newt.opengl.GLWindow;
import com.jogamp.opengl.GLCapabilities;
import com.jogamp.opengl.GLProfile;
import com.jogamp.opengl.util.FPSAnimator;

public class Renderer {
	
	private static GLWindow window = null;
	
	private static GLProfile profile =null;
	public static void init(){
		GLProfile.initSingleton();
	profile = GLProfile.get(GLProfile.GL2);
		GLCapabilities caps = new GLCapabilities(profile);
		
		window = GLWindow.create(caps);
		window.setSize(640,360);
		window.setResizable(true);
		window.addGLEventListener(new EventListener());
		window.addKeyListener(new KeyInput());
		//FPSAnimator animator = new FPSAnimator(window, 40);
		//animator.start();
		
		window.setVisible(true);
		
	}
	public static void render(){
		
		if (window == null){
			
			return;
		}
		window.display();
	}
	
	public static GLProfile getProfile(){
		return profile;
	}
	

}
