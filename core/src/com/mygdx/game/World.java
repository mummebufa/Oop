package com.mygdx.game;

import java.util.Random;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;



public class World {
	public int time;
	public int player;
	public int playerScore;
	public int computerScore; 
	public int computer;
	public int number[] = new int [4];
	public float[] speed ={(float) 0.1,(float) 0.5,(float) 1.5};
	public float totalTime;
	public int stage;
	public int timer;
	public float deltatime;
	public static boolean endgame;
	private boolean ready;
	public static float temp = 0;
	public static boolean x =false;
	public static float veryTime=0;
	public final Random rand;
	public World (ProjectGame game,int level) {
		this.time=3;
		this.player = 0;
		this.ready =true;
		this.endgame=false;
		rand = new Random();
		this.playerScore =0;
		this.computerScore=0;
		this.stage=level;
	}
	
	public void update () {		
		if(this.playerScore<3 && this.computerScore<3){
		updateTime();
		updatePlayer();
		updateComputer();}
		else{
			this.endgame=true;
			}
		}

	public void updateTime(){
		float deltaTime = Gdx.graphics.getDeltaTime();
		veryTime+=deltaTime;
		if(veryTime>=1 &&veryTime<2){
			this.time = 2;
			this.ready=true;
			this.computer = rand.nextInt(3);
		}
		else if(veryTime>=2 &&veryTime<3){
			this.time = 1;
			
			this.ready=true;
			this.computer = rand.nextInt(3);
		}
		else if(veryTime>=3 &&veryTime<4){
			this.time = 0;
			x=true;
			updateComputer();
			this.ready=true;
			
		}
		else if(veryTime>=4 &&veryTime<5){
			updateScore();
			this.ready=false;
			this.veryTime=0;
		}
	}
	public void updatePlayer(){
		if(this.ready){
			if(Gdx.input.isKeyJustPressed(Keys.Q)){
				this.player = 0;
				x = true;
			}
			if(Gdx.input.isKeyJustPressed(Keys.W)){
				this.player = 1;
				x = true;
			}
			if(Gdx.input.isKeyJustPressed(Keys.E)){
				this.player = 2;
				x = true;
			}	
		}
	}
	public void updateComputer(){
		if(this.ready){
			float deltaTime = Gdx.graphics.getDeltaTime();
		
		if(x){
			temp +=deltaTime;
			}
		if(temp > this.speed[this.stage])
			{
				if(this.player == 0){
				this.computer = 1;
			}
			if(this.player == 1){
				this.computer = 2;
			}
			if(this.player == 2){
				this.computer = 0;
			}
				
			temp = 0;
			x = false;
			}
		}
	}
	public void updateScore(){
		if(this.ready){
		if(this.player==0){
			if(this.computer==0){
				return;
			}else if(this.computer==1){
				this.computerScore+=1;
			}else if(this.computer==2){
				this.playerScore+=1;
			}
		}
		else if(this.player==1){
			if(this.computer==1){
				return;
			}else if(this.computer==0){
				this.playerScore+=1;
			}else if(this.computer==2){
				this.computerScore+=1;
			}
		}
		else if(this.player==2){
			if(this.computer==2){
				return;
			}else if(this.computer==1){
				this.playerScore+=1;
			}else if(this.computer==0){
				this.computerScore+=1;
			}
		}
		}
		
		
	}
	
	
	
}
