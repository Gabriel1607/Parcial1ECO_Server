package model;

import processing.core.PApplet;

public class Particula {
	private float posX,posY,dirX,dirY;
	private int size,spd,r,g,b;
	private String grupo;
	PApplet app;

		public Particula(float posX, float posY, int r, int g, int b,String grupo, PApplet app) {
			this.app = app;
	        this.posX = posX;
	        this.posY = posY;
	        this.dirX = -1;
	        this.dirY = 1;
	        this.size = 20;
	        this.spd = 1;
	        this.r = r;
	        this.g = g;
	        this.b = b;
	        this.grupo = grupo;
	       
	    }
		
	    public int getSize() {
			return size;
		}
		public void setSize(int size) {
			this.size = size;
		}
		


	    
	    public float getDirX() {
			return dirX;
		}

		public void setDirX(float dirX) {
			this.dirX = dirX;
		}

		public float getDirY() {
			return dirY;
		}

		public void setDirY(float dirY) {
			this.dirY = dirY;
		}

		public int getSpd() {
			return spd;
		}

		public void setSpd(int spd) {
			this.spd = spd;
		}

		public void move(){
	        posX+=dirX*spd;
	        posY+=dirY*spd;
	        if(posX>app.width||0>posX) {
	            dirX=-dirX;
	        }
	        if(posY>app.height||0>posY) {
	            dirY=-dirY;
	        }
	    }
		public float getPosX() {
			return posX;
		}
		public void setPosX(float posX) {
			this.posX = posX;
		}
		public float getPosY() {
			return posY;
		}
		public void setPosY(float posY) {
			this.posY = posY;
		}
		public int getR() {
			return r;
		}
		public void setR(int r) {
			this.r = r;
		}
		public int getG() {
			return g;
		}
		public void setG(int g) {
			this.g = g;
		}
		public int getB() {
			return b;
		}
		public void setB(int b) {
			this.b = b;
		}
		public String getGrupo() {
			return grupo;
		}
		public void setGrupo(String grupo) {
			this.grupo = grupo;
		}
	    
}
