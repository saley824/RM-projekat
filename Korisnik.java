package GUI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;



public class Korisnik {
	public static void main(String[] args) {
       // Korisnik korisnik = new Korisnik("localhost");
       // korisnik.execute();
	
    }


    private final String hostname="localhost";
    private final int port;
    private String ime;
    private Igra igra;
    private BufferedReader citac;
    private PrintWriter pisac;
    int brojBodova;
    public Korisnik(String ime,Igra igra) {
        this.ime = ime;
        this.port = 12345;
        this.igra=igra;
        this.brojBodova=0;
    }


    void execute() {
        try {
            try (Socket socket = new Socket(this.hostname, this.port)) {
                System.out.println("Usao u sobu:" + this.hostname);
                this.citac = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                this.pisac=new PrintWriter(socket.getOutputStream(), true);
                //Predstavljanje serveru
                pisac.println(this.ime);
                //Cekanje na pocetak igre
                citac.readLine();
                int br=0;
                while(br<5) {
                String slovo=citac.readLine();
                this.igra.txtS.setText(slovo);
                this.igra.tfDrzava.setText("");
                this.igra.tfRijeka.setText("");
                this.igra.tfPlanina.setText("");
                this.igra.tfGrad.setText("");
                this.igra.tfBiljka.setText("");
                //Cekanje na potvrdu odgovora
                while(!this.igra.spremnoSlanje) {}
		        String drzava = this.igra.tfDrzava.getText();
				String rijeka = this.igra.tfRijeka.getText();
				String planina = this.igra.tfPlanina.getText();
				String grad = this.igra.tfGrad.getText();
				String biljka = this.igra.tfBiljka.getText();
	        	if(drzava.equals("")) {
	        		drzava="X";
	        	}
	        	if(rijeka.equals("")) {
	        		rijeka="X";
	        	}
	        	if(grad.equals("")) {
	        		grad="X";
	        	}
	        	if(biljka.equals("")) {
	        		biljka="X";
	        	}
	        	if(planina.equals("")) {
	        		planina="X";
	        	}
	        	String odgovori=drzava+"_"+grad+"_"+planina+"_"+rijeka+"_"+biljka;
	        	pisac.println(odgovori);
	        	String rjesenja=citac.readLine();
	        	
	        	String[] odgovoriIgraca=rjesenja.split("/");
	        	int i=1;	        	
	        	for(String odgovor:odgovoriIgraca) {
	        		String[] odg=odgovor.split("_");
	        		
	        		
	        			this.igra.r.tfIgraci[i].setText(odg[0]);
	        			this.igra.r.tfDrzave[i].setText(odg[1]);
	        			this.igra.r.tfBiljke[i].setText(odg[2]);
	        			this.igra.r.tfGradovi[i].setText(odg[3]);
	        			this.igra.r.tfPlanine[i].setText(odg[4]);
	        			this.igra.r.tfRijeke[i].setText(odg[5]);
	        			i++;
	        	}
	        	//Slanje primjedbi
	        	pisac.println(this.igra.primjedbe);
	        	//Server vraca primjedbe ostalih korisnika
	        	String primjedbeSve=citac.readLine();
	        	String[]nizPrimjedbi=primjedbeSve.split("|");
	        	br++;
	        	this.igra.spremnoSlanje=false;
                }
                


                
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (Exception ex) {
            System.out.println("Greska");
        } 
    }

   
}
