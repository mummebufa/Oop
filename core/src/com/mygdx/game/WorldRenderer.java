package com.mygdx.game;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class WorldRenderer {
	private Texture[] rpsTexture = new Texture [3];
	private Texture[] rpsrTexture = new Texture [3];
	private Texture[] scoreTexture = new Texture [4];
	private Texture[] timerTexture = new Texture [4];
	private Texture score;
	private Texture result;
	private Texture backgroundImage;
	private Texture trump;
	private Texture hillary;
	private SpriteBatch batch;
	private World world;
	private String[] imageName = {"rock.png", "paper.png", "scissor.png"};
	private String[] imagerName = {"rockr.png", "paperr.png", "scissorr.png"};
	private String[] timer = {"go.png", "set.png", "ready.png","ready.png"};
	private String[] scoreName = {"0score.png","1score.png", "2score.png", "3score.png"};
	public WorldRenderer (ProjectGame game, World world) {
		this.world = world;
		batch = game.batch;
		score = new Texture("score.png");
		trump = new Texture("trump.png");
		hillary = new Texture("hillary.png");
		backgroundImage = new Texture("whitehouse.jpg");
		for(int i= 0 ; i < 3; i++){
			rpsTexture[i] = new Texture(imageName[i]);
		}
		for(int i= 0 ; i < 3; i++){
			rpsrTexture[i] = new Texture(imagerName[i]);
		}
		for(int j= 0 ; j < 4; j++){
			timerTexture[j] = new Texture(timer[j]);
		}
		for(int i= 0 ; i < 4; i++){
			scoreTexture[i] = new Texture(scoreName[i]);
		}
	
		
    }
	
	public void render () {
		GL20 gl = Gdx.gl;
		gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		renderComputer();
		renderPlayer();
		renderTimer();
		renderComputerScore();
		renderPlayerScore();
		renderleftright();
		renderWinner();
		batch.end();
    }
	
	public void renderBackground () {
		batch.draw(backgroundImage, 0, 0);
	}
	
	public void renderTimer(){
		batch.draw(timerTexture[world.time],350,600);
	}
	
	public void renderleftright(){
		batch.draw(trump,0,0);
		batch.draw(hillary,900,0);
	}
	
	public void renderPlayer () {
		batch.draw(rpsTexture[world.player],350,0);
	}
	public void renderComputer () {
		batch.draw(rpsrTexture[world.computer],660,0);
	}
	public void renderPlayerScore(){
		batch.draw(score,0,700);
		batch.draw(scoreTexture[world.playerScore],0,600);
	}
	public void renderComputerScore(){
		batch.draw(score,950,700);
		batch.draw(scoreTexture[world.computerScore],950,600);
	}
	public void renderWinner(){
		if(world.endgame==true){
			result = new Texture("youlose.png");
			batch.draw(result,350,600);
		}	
	}
}
