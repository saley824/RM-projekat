package RM;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class UserThread extends Thread {
	private Socket sock;
	private BufferedReader in;
	private PrintWriter out;
	private int id;
	private int points;
	private String PlayerName;
	private String drzava;
	private String rijeka;
	private String planina;
	private String grad;
	private String biljka;
	private char c;
	
	

	public UserThread(Socket sock, int id, char c) {
		this.c=c;
		this.id=id;
		this.sock = sock;
		try {
			this.in = new BufferedReader(new InputStreamReader(sock.getInputStream()));
			this.out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(sock.getOutputStream())), true);
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		start();
	}
	

	@Override
	public void run() {
		try {
			PlayerName = in.readLine();
					
				while(Server2.users.size()<3) {
					//System.out.println();
				}
	
		
			out.println("start");
			out.println(c+""); // slanje slova
			
			String [] odgovori=in.readLine().split("_"); // uzimanje rjesenja
			
			this.drzava=odgovori[0];
			this.grad=odgovori[1];
			this.planina=odgovori[2];
			this.rijeka=odgovori[3];
			this.biljka=odgovori[4];
			
			TimeUnit.SECONDS.sleep(5);
			Server2.posaljiRjesenja(this);
			
			System.out.println("primjedbe"+in.readLine());
			
			in.close();
			out.close();
			sock.close();
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	
	public void sendToClient(String s) {
		out.println(s);
	}
	
	public void sendMessage(String msg) {
		if(this.out!= null)
		this.out.println(msg);
	}

	public long getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}

	public String getPlayerName() {
		return PlayerName;
	}

	public void setPlayerName(String PlayerName) {
		this.PlayerName = PlayerName;
	}
	public String getDrzava() {
		return drzava;
	}


	public void setDrzava(String drzava) {
		this.drzava = drzava;
	}


	public String getRijeka() {
		return rijeka;
	}


	public void setRijeka(String rijeka) {
		this.rijeka = rijeka;
	}


	public String getPlanina() {
		return planina;
	}


	public void setPlanina(String planina) {
		this.planina = planina;
	}


	public String getGrad() {
		return grad;
	}


	public void setGrad(String grad) {
		this.grad = grad;
	}


	public String getBiljka() {
		return biljka;
	}


	public void setBiljka(String biljka) {
		this.biljka = biljka;
	}

	
	public String toString() {
		return id+".  "+PlayerName+"   "+ points;
	}
	
}
