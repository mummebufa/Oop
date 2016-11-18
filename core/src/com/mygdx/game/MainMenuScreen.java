package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;

public class MainMenuScreen extends ScreenAdapter {
	
	ProjectGame game;
	private Texture mainMenu;
	private SpriteBatch batch;
	Rectangle playBounds;
	Rectangle exitBounds;
	Vector3 touchPoint;
	OrthographicCamera guiCam;
	
	MainMenuScreen (ProjectGame projectGame) {
		this.game = projectGame;
		mainMenu = new Texture("mainmenu.png");
		batch = new SpriteBatch(); 
		guiCam = new OrthographicCamera(800, 800);
		guiCam.position.set(800 / 2, 800 / 2, 0);
		playBounds = new Rectangle(-102, -95, 222, 55);
		exitBounds = new Rectangle(-40, -265, 95, 55);
		touchPoint = new Vector3();
	}
	
	public void update () {
		if (Gdx.input.justTouched()) {
			guiCam.unproject(touchPoint.set(Gdx.input.getX(), Gdx.input.getY(), 0));
			if (playBounds.contains(touchPoint.x, touchPoint.y)) {
				game.setScreen(new GameScreen(game,0));
				return;
			}
			if (exitBounds.contains(touchPoint.x, touchPoint.y)) {
				game.setScreen(new GameScreen(game,0));
				Gdx.app.exit();
			}
		}
	}
	
	public void draw () {
		batch.begin();
		batch.draw(mainMenu, 0, 0);
		batch.end();
	}
	
	@Override
	public void render (float delta) {
		update();
		draw();
	}
	
}
