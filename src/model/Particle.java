package model;

public class Particle {
private float posX,posY,dirX,dirY;
private int size,spd,r,g,b,parNum;
private String grupo;

	public Particle(float posX, float posY, int r, int g, int b,String grupo, int parNum) {
        this.posX = posX;
        this.posY = posY;
        this.dirX = 0;
        this.dirY = 0;
        this.size = 20;
        this.spd = 1;
        this.r = r;
        this.g = g;
        this.b = b;
        this.grupo = grupo;
        this.parNum = parNum;
    }

    public Particle() {
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

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getSpd() {
        return spd;
    }

    public void setSpd(int spd) {
        this.spd = spd;
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

    public int getParNum() {
        return parNum;
    }

    public void setParNum(int parNum) {
        this.parNum = parNum;
    }

    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }
}