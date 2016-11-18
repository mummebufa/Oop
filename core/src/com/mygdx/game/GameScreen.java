package com.mygdx.game;

import com.badlogic.gdx.ScreenAdapter;

public class GameScreen extends ScreenAdapter {
	
	ProjectGame game;
	World world;
	WorldRenderer worldRenderer;
	
	public GameScreen (ProjectGame game,int level) {
		this.game = game;
		world = new World(game,level);
		worldRenderer = new WorldRenderer(game, world);
	}
	
	@Override
	public void render (float delta) {
		world.update();
		draw();
	}
	
	public void draw () {
		worldRenderer.render();
	}
}
