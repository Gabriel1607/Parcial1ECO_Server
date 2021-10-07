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

import com.google.gson.Gson;

import model.Particle;
import processing.core.PApplet;

public class Main extends PApplet {
	private Socket socketcito;
	private BufferedWriter escritorcito;
	private BufferedReader lectorcito;

	public static void main(String[] args) {
		PApplet.main("main.Main");
	}
	public void settings() {
		size(500, 500);
	}
public void setup() {
	background(0);
	initServer();
	}
public void draw() {
	
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
						Particle p = gson.fromJson(line, Particle.class);
						System.out.println("posiciones    "+p.getPosX()+" "+p.getPosY());
						System.out.println("colores       "+p.getR()+" "+p.getG()+" "+p.getB());
						System.out.println("grupo         "+p.getGrupo()+" #departiculas     "+p.getParNum());
					}

				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

	).start();
}
}
