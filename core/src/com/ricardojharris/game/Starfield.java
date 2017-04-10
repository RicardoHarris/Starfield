package com.ricardojharris.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;

import java.util.Random;

public class Starfield extends ApplicationAdapter {

	ShapeRenderer myRenderer;
	Random myRandom;
	int y;
	int x ;
	int screenWidth, screenHeight;
	Array<Vector2> stars;
	private float starDensity = 0.1f;
	int numStars;

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
		numStars = (int) (screenHeight * screenWidth * starDensity);
		stars = new Array<Vector2>(numStars);
		starPoint();
		for (int i = 0; i < numStars; i++){
			x = myRandom.nextInt(screenWidth);
			y = myRandom.nextInt(screenHeight);
			stars.add(new Vector2(x, y));
		}
	}

	@Override
	public void render (){
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		myRenderer.begin(ShapeRenderer.ShapeType.Line);
		myRenderer.rect(x,y,1,0);
		for (Vector2 star : stars){
			myRenderer.rect(star.x, star.y, 1,0);
		}
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
