import org.lwjgl.glfw.GLFWErrorCallback;
//import org.lwjgl.glfw.Callbacks;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.opengl.GL;

import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.*;

public class Display {
	
	private static GLFWErrorCallback errorCallback;
	private static long windowId;

	public static void main(String[] args) {
		
		errorCallback = GLFWErrorCallback.createPrint();
		glfwSetErrorCallback(errorCallback);
		
		int gflwResult = glfwInit();
		if(gflwResult==GL_FALSE){
			throw new IllegalStateException("GLFW innit failed");
		}
		windowId = glfwCreateWindow(
				640,480, "AnimationDisplay", MemoryUtil.NULL,MemoryUtil.NULL
				);
		if(windowId== MemoryUtil.NULL)
			throw new IllegalStateException("Window Failed");
		
		glfwMakeContextCurrent(windowId);
		glfwSwapInterval(1);
		glfwShowWindow(windowId);
		
		GL.createCapabilities();
		
		while(glfwWindowShouldClose(windowId)== GL_FALSE){
			glClear(GL_COLOR_BUFFER_BIT);
			glfwSwapBuffers(windowId);
			glfwPollEvents();
		}
		glfwDestroyWindow(windowId);glfwTerminate();
	}

}
