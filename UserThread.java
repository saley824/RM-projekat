package GUI;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import javax.swing.SwingWorker;

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
	
	private void initializeWorker() {
    	
    	UserThread sender=this;
        worker = new SwingWorker<Void, Void>() {
        
            @Override
            protected Void doInBackground() throws Exception {
            	PlayerName = in.readLine();
                while (Server2.users.size()<1) {
                  
                }
                
                
                return null;
            }
            @Override
            protected void done() {
            	out.println("start");
    			out.println(c+""); // slanje slova
    			
    			String[] odgovori=null;
				try {
					odgovori = in.readLine().split("_");
					for(int i=0;i<odgovori.length;i++)
			        	System.out.println(odgovori[i]);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} // uzimanje rjesenja
    			
    			sender.drzava=odgovori[0];
    			sender.grad=odgovori[1];
    			sender.planina=odgovori[2];
    			sender.rijeka=odgovori[3];
    			sender.biljka=odgovori[4];
    			//Simuliranje slanja rjesenja korisniku
    			out.println("1_a_b_c_d_E/2_a_b_c_d_e/3_a_b_c_d_e/4_a_b_c_d_e");
    			try {
					String primjedbeigraca=in.readLine();
					System.out.println("Primjedbe igraca:"+primjedbeigraca);
					out.println("Grad-Beograd/Rijeka-Sava/Biljka-Krava");
					String odgovoriNaPrimjedbe=in.readLine();
					System.out.println("Odgovori na primjedbe "+odgovoriNaPrimjedbe);
					out.println(5);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

    			
    			//Server2.posaljiRjesenja(sender);
    			/*try {
    			System.out.println("primjedbe"+in.readLine());
    			
    			in.close();
    			out.close();
    			sock.close();}
    			catch(Exception e) {
    				e.printStackTrace();}*/
            }

            
        };
    }

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
	
	private SwingWorker worker;
	@Override
	public void run() {
		try {
			
			this.initializeWorker();
			this.worker.execute();
		
			
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
