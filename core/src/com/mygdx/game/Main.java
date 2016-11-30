package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import static com.badlogic.gdx.math.Interpolation.circle;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.*;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;
import com.badlogic.gdx.physics.box2d.World;
import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Main extends ApplicationAdapter {

    ShapeRenderer shape;
    SpriteBatch batch;
    Texture imgBall;
    Texture imgBox;
    Sprite sprBall;
    Sprite sprBox;
    movement move;
    int nX;
    int nY;
    Rectangle[] arRect = new Rectangle[5];
    Random rn = new Random();
    Rectangle rect1;
    Rectangle rect2;

    public void create() {
        shape = new ShapeRenderer();
        batch = new SpriteBatch();
        imgBall = new Texture(Gdx.files.internal("ball.png"));
        sprBall = new Sprite(imgBall);
        imgBox = new Texture(Gdx.files.internal("box.png"));
        move = new movement();
        setBox();
    }

    @Override
    public void render() {
        Gdx.gl.glClearColor(100, 100, 100, 20);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        stuff();
        batch.draw(sprBall, nX, nY);
        batch.end();
        shape.begin(ShapeType.Filled);
        shape.setColor(0, 0, 0, 1);
        shape.rect(rect2.getX(), rect2.getY(), rect2.getWidth(), rect2.getHeight());
      //  shape.rect(rect1.getX(), rect1.getY(), rect1.getWidth(), rect1.getHeight());
        for (int i = 0; i < arRect.length; i++) {
            shape.rect(arRect[i].getX(), arRect[i].getY(), arRect[i].getWidth(), arRect[i].getHeight());
        }
        shape.end();
    }

    public void stuff() {
        if (Gdx.input.isKeyPressed('r')) {
            reload();
        }
        if (move.nLives == 0) {
            System.exit(0);
        }
        nX = move.getX();
        nY = move.getY();
        rect1 = new Rectangle(nX, nY, sprBall.getWidth(), sprBall.getHeight());
        rect2 = new Rectangle(0, Gdx.graphics.getHeight() - 64, Gdx.graphics.getWidth(), 64);
        move.Move();
        move.isHitBox(rect1, arRect);
        move.isHitBar(rect1, rect2);
    }

    public void setBox() {
        for (int i = 0; i < arRect.length; i++) {
            arRect[i] = new Rectangle(rn.nextInt(Gdx.graphics.getWidth()), rn.nextInt(Gdx.graphics.getHeight()), rn.nextInt(100) + 30, rn.nextInt(100) + 30);
        }
    }

    public void reload() {
        int nSize = arRect.length;
        arRect = new Rectangle[nSize];
    }

}
