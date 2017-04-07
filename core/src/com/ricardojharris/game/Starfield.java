package com.ricardojharris.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

import java.util.Random;

public class Starfield extends ApplicationAdapter {

	ShapeRenderer myRenderer;
	Random myRandom;
	int y;
	int x ;
	int screenWidth, screenHeight;

	@Override
	public void create () {
		myRenderer = new ShapeRenderer();

		myRandom = new Random();
		y= myRandom.nextInt(101);
		x= myRandom.nextInt(101);
		screenWidth = Gdx.graphics.getWidth();
		screenHeight = Gdx.graphics.getHeight();
		x = myRandom.nextInt(screenWidth);
		y = myRandom.nextInt(screenHeight);
		starPoint();
	}

	@Override
	public void render (){

		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		myRenderer.begin(ShapeRenderer.ShapeType.Line);
		myRenderer.rect(x,y,1,0);
		myRenderer.end();
	}

	@Override
	public void resize(int width, int height) {
		starPoint();
	}

	public void starPoint(){
		screenWidth = Gdx.graphics.getWidth();
		screenHeight = Gdx.graphics.getHeight();
		x = myRandom.nextInt(screenWidth);
		y = myRandom.nextInt(screenHeight);
	}
	

}
