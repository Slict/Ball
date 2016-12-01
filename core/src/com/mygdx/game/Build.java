/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Rectangle;

/**
 *
 * @author Justin
 */
public class Build {

    int nX = 100;
    int nY = 100;

    public Rectangle[] build1(Rectangle[] arrRect) {
        arrRect = new Rectangle[16];
        for (int i = 0; i < arrRect.length / 2; i++) {
            arrRect[i] = new Rectangle(nX, 0, 10, 300);
            nX += 100;
        }
        nX = 150;
        for (int i = 8; i < arrRect.length; i++) {
            arrRect[i] = new Rectangle(nX, Gdx.graphics.getHeight() - 360, 10, 300);
            nX += 100;
        }
        return arrRect;
    }

    public Rectangle[] build2(Rectangle[] arrRect) {
        arrRect = new Rectangle[16];
        for (int i = 0; i < arrRect.length / 2; i++) {
            arrRect[i] = new Rectangle(0, nY, 400, 10);
            nY += 100;
        }
        for (int i = 0; i < arrRect.length; i++) {
            arrRect[i] = new Rectangle(100, nY, 400, 10);
        }
        return arrRect;
    }
}
