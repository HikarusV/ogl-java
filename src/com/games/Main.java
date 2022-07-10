package com.games;

import com.jogamp.nativewindow.WindowClosingProtocol;
import com.jogamp.newt.opengl.GLWindow;

import com.jogamp.opengl.GLProfile;
import com.jogamp.opengl.GLCapabilities;
import com.jogamp.opengl.util.FPSAnimator;

import javax.swing.*;
//import javax.media.opengl.*;

public class Main {

    private static GLWindow window = null;

    private static int width, height;
    private static float unitWide = 120;
    private boolean isX = true;

    public static void init() {

        GLProfile.initSingleton();
        GLProfile profile = GLProfile.get(GLProfile.GL2);
        GLCapabilities caps = new GLCapabilities(profile);

        window = GLWindow.create(caps);
        window.setSize(600, 600);
        //window.setResizable(false);

        window.addGLEventListener(new Listener(window, unitWide));
        window.addMouseListener(new MiceInput());
        window.addKeyListener(new KeyInput());

        FPSAnimator anim = new FPSAnimator(window, 240);

        anim.start();

        //window.setFullscreen(true);
        window.setVisible(true);
        window.setDefaultCloseOperation(WindowClosingProtocol.WindowClosingMode.DISPOSE_ON_CLOSE);
        //window.display();

    }

    public static void main(String[] args) {
        init();
    }

}
