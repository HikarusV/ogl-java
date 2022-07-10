package com.games;

import com.jogamp.newt.event.KeyEvent;
import com.jogamp.newt.event.KeyListener;

public class KeyInput implements KeyListener{

    @Override
    public void keyPressed(KeyEvent e) {
//        System.out.println(e.getKeyCode());
        if (e.getKeyCode() == 151 || e.getKeyCode() == 149) { // 151 kanan, 149 kiri
            if (e.getKeyCode() == 149) {
                Listener.setCekPoin(true, false);
            } else {
                Listener.setCekPoin(true, true);
            }
        } else if (e.getKeyCode() == 150 || e.getKeyCode() == 152){ // 150 atas, 152 bawah
            if (e.getKeyCode() == 152) {
                Listener.setCekPoin(false, false);
            } else {
                Listener.setCekPoin(false, true);
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
