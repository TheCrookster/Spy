package com.NemianStudios.Display;


import com.NemianStudios.Main;
import com.NemianStudios.Util.Timer;

import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.*;


public class DisplayHandle {

    public static final int TARGET_FPS = 75;

    public static final int TARGET_UPS = 30;

    private final Timer timer;


    public DisplayHandle(){
        timer = new Timer();
    }

    public void initDisplay(){
        timer.init();
    }

    //Main game loop
    public void Loop(){

        float elapsedTime;
        float accumulator = 0f;
        float interval = 1f / TARGET_UPS;

        while ( !glfwWindowShouldClose(Main.getWindow()) ) {
            elapsedTime = timer.getElapsedTime();
            accumulator += elapsedTime;




            while (accumulator >= interval) {
                accumulator -= interval;
            }


            glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT); // clear the framebuffer

            glfwSwapBuffers(Main.getWindow()); // swap the color buffers

            // Poll for window events. The key callback above will only be
            // invoked during this call.
            glfwPollEvents();
        }
    }
    //main Image Update
    public void update(){

    }


}
