package main;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import com.google.gson.Gson;

import model.Particle;
import model.Particula;
import processing.core.PApplet;

public class Main extends PApplet {
	private Socket socketcito;
	private BufferedWriter escritorcito;
	private BufferedReader lectorcito;
	private ArrayList<Particula> particulas;
	PApplet app;
	Particula je;

	public static void main(String[] args) {
		PApplet.main("main.Main");
	}
	public void settings() {
		size(1000, 1000);
	}
public void setup() {
	
	
	particulas = new ArrayList<Particula>();
	initServer();
	je = new Particula(500,500,255,0,0,"rupo 1",app);
	
	}
public void draw() {
	background(0);
	
	dibujarYmoverParticulas();
}
public void initServer() {
	new Thread(

			() -> {
				try {
					// Paso 1: Esperar una conexion
					ServerSocket server = new ServerSocket(6969);
					System.out.println("Esperando conexión....");
					socketcito = server.accept();
					// Paso 3: Cliente y Server conectados
					System.out.println("Cliente conectado!!!");

					InputStream is = socketcito.getInputStream();
					InputStreamReader isr = new InputStreamReader(is);
					lectorcito = new BufferedReader(isr);

					OutputStream os = socketcito.getOutputStream();
					OutputStreamWriter osw = new OutputStreamWriter(os);
					escritorcito = new BufferedWriter(osw);
					// Recibir mensajitos

					while (true) {
						System.out.println("Esperando mensaje....");
						String line = lectorcito.readLine();
						//System.out.println("Recibido: " + line);
						Gson gson = new Gson();
						//Particle es la clase que existe en android y eclipse,
						//pero como en Android no sé implementar Processing sin dañar todo
						//es necesario la creación de una nueva clase, la clase Particula
						Particle p = gson.fromJson(line, Particle.class);
						createParticulas(p.getPosX(),p.getPosY(),p.getR(),p.getG(),p.getB(),p.getGrupo(),p.getParNum());
						System.out.println(particulas.size());
					}

				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

	).start();
}

public void createParticulas(float posx, float posy,int r, int g, int b, String grupo, int cuantasQuiere) {
	for (int i = 0; i < cuantasQuiere; i++) {
		Particula p = new Particula(posx,posy,r,g,b,grupo,app);
		particulas.add(p);
	}
}
public void dibujarYmoverParticulas() {
	float rndX;
	float rndY;
	for (int i = 0; i < particulas.size(); i++) {
		rndX = random(1,999);
		rndY = random(1,999);
	System.out.println(particulas.get(i).getR());
		drawParticle(particulas.get(i));
		randomDirParticle(particulas.get(i),rndX,rndY);
		moveParticle(particulas.get(i));
	}
}
//METODO PA DIBUJAR LAS PARTICULAS
public void drawParticle(Particula p) {
	fill(p.getR(),p.getG(),p.getB());
	ellipse(p.getPosX(),p.getPosY(),p.getSize(),p.getSize());
}
//METODO PA QUE LAS PARTICULAS COJAN PA DIRECCIONES RANDOM
public void randomDirParticle(Particula p,float rndX, float rndY) {
	 //Diferencia entre vectores
    p.setDirX(rndX-p.getPosX());
    p.setDirY(rndY-p.getPosY());
    //Normalizar el vector para que valga 1 o -1
    float dist = (float) Math.sqrt(p.getDirX() * p.getDirX() + p.getDirY() * p.getDirY());
    if(dist != 0.0) {
    	p.setDirX(p.getDirX()/dist);
    	p.setDirY(p.getDirY()/dist);
    
    
}
}
//METODO PA QUE LAS PARTICULAS SE MUEVAN
public void moveParticle(Particula p) {
	 p.setPosX(p.getPosX()+p.getDirX()*p.getSpd());
	 p.setPosY(p.getPosY()+p.getDirY()*p.getSpd());
     if(p.getPosX()>width||0>p.getPosX()) {
         p.setDirX(p.getDirX()-p.getDirX());
     }
     if(p.getPosY()>height||0>p.getPosY()) {
    	 p.setDirY(p.getDirY()-p.getDirY());
     }
}
}
