package com.davidlambiase.game.sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

import java.util.Random;

public class Tube {
    public  static final  int TUBE_WIDTH=52;

    private static final int LOWEST_OPENING  = 138;
    private static final int TUBE_GAP = 120;
    private static final int FLUCTUATION = 138;
    private Texture topTube, bottomTube;
    private Rectangle boundsTop, boundsBottom;
    private Vector2 posTopTube, posBottomTube;
    private Random rand;

    public  Tube(float x){
        topTube = new Texture("topTube.png");
        bottomTube = new Texture("bottomTube.png");
        rand = new Random();

        posTopTube = new Vector2(x, rand.nextInt(FLUCTUATION)+TUBE_GAP + LOWEST_OPENING);
        posBottomTube = new Vector2(x, posTopTube.y-TUBE_GAP - bottomTube.getHeight());

        boundsTop = new Rectangle(posTopTube.x, posTopTube.y, topTube.getWidth(), topTube.getHeight());
        boundsBottom = new Rectangle(posBottomTube.x, posBottomTube.y, bottomTube.getWidth(), bottomTube.getHeight());
    }

    public Texture getTopTube() {
        return topTube;
    }

    public Texture getBottomTube() {
        return bottomTube;
    }

    public  boolean collides(Rectangle player){
        return  player.overlaps(boundsTop) || player.overlaps(boundsBottom);
    }

    public Vector2 getPosTopTube() {
        return posTopTube;
    }

    public Vector2 getPosBottomTube() {
        return posBottomTube;
    }

    public  void reposition(float x){
        posTopTube.set(x, rand.nextInt(FLUCTUATION)+TUBE_GAP + LOWEST_OPENING);
        boundsTop.setPosition(posTopTube.x, posTopTube.y);
        posBottomTube.set(x, posTopTube.y-TUBE_GAP - bottomTube.getHeight());
        boundsBottom.setPosition(posBottomTube.x, posBottomTube.y);
    }

    public void  dispose(){
        bottomTube.dispose();
        topTube.dispose();
    }
}
