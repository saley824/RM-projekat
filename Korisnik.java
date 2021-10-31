package GUI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import javax.swing.SwingWorker;



public class Korisnik {
	public class SWRjesenja extends SwingWorker {

		@Override
		protected Object doInBackground() throws Exception {
			
			String [] odgIgrac=citac.readLine().split("/");
			r=new Rjesenja();
			r.setVisible(true);
			for(int i=0;i<4;i++) {
			String []odgovoriI=odgIgrac[i].split("_");
			r.tfIgraci[i].setText(odgovoriI[0]);
			r.tfDrzave[i].setText(odgovoriI[1]);
			r.tfRijeke[i].setText(odgovoriI[2]);
			r.tfPlanine[i].setText(odgovoriI[3]);
			r.tfGradovi[i].setText(odgovoriI[4]);
			r.tfBiljke[i].setText(odgovoriI[5]);
			}
			while(r.PrimjedbeSpremne==false) {
				System.out.print(r.PrimjedbeSpremne);
				Thread.sleep(1000);
			}
			
			//System.out.println("Poslao");
			pisac.println(r.primjedba.substring(0, r.primjedba.length()-1));
			r.setVisible(false);
			System.out.println("Poslao");
			String primjedbeSve=citac.readLine();
			System.out.println(primjedbeSve);
			String[]nizPrimjedbi=primjedbeSve.split("/");
			for(String prim:nizPrimjedbi) {
				Primjedbe p=new Primjedbe();
				p.tfOdgovor.setText(prim);
				p.setVisible(true);
				while(p.gotov==false) {
					System.out.print(p.gotov);
				}
				if(p.odbio) {
					odgovoriNaPrimjedbe+=prim+"-ODBIJEN";
				}
				if(p.prihvatio) {
					odgovoriNaPrimjedbe+=prim+"-PRIHVACEN";
				}
				odgovoriNaPrimjedbe+="/";
				p.setVisible(false);
				
			}
			//Slanje Odgovora
			System.out.print(odgovoriNaPrimjedbe.substring(0,odgovoriNaPrimjedbe.length()-1));
			pisac.println(odgovoriNaPrimjedbe.substring(0,odgovoriNaPrimjedbe.length()-1));
			//Dobijanje bodova od servera
			String sBodovi=citac.readLine();
			brojBodova+=Integer.parseInt(sBodovi);
			gotovCiklus=true;
			return null;
		}

	}
	protected boolean gotovCiklus=true;
	protected String odgovoriNaPrimjedbe="";
	protected boolean spremnoSlanje;
    private final String hostname="localhost";
    private final int port;
    private String ime;
    private Igra igra;
    private BufferedReader citac;
    private PrintWriter pisac;
    int brojBodova;
    protected Rjesenja r;
    public Korisnik(String ime) {
        this.ime = ime;
        this.port = 12345;
       // this.igra=igra;
        this.brojBodova=0;
    } 
    protected SwingWorker worker;
    protected String primjedbeOdgovori="";
    public class SWKorisnik extends SwingWorker {
    	
    	SwingWorker w1=igra.worker;
    	
       
        
            @Override
            protected Void doInBackground() throws Exception {
               
                while (!w1.isDone()) {
                  
                }
                System.out.println("Gotovo");
                
                return null;
            }
            @Override
            protected void done() {
            	String drzava = igra.tfDrzava.getText();
				String rijeka = igra.tfRijeka.getText();
				String planina = igra.tfPlanina.getText();
				String grad = igra.tfGrad.getText();
				String biljka = igra.tfBiljka.getText();
            	System.out.print("Korisnik kliknuo potvrdi");
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
	        	SWRjesenja wk1=new SWRjesenja();
	        	wk1.execute();
            }

            
        };
       
    
    protected Socket socket;
    public class SWIterator extends SwingWorker {

		@Override
		protected Object doInBackground() throws Exception {
			
			int br=0;
			while(br<5) {
				System.out.print(br);
				String slovo=citac.readLine();
               	igra=new Igra();
               	igra.txtS.setText(slovo);
           		igra.setVisible(true);
           		SWKorisnik kor=new SWKorisnik();
           		kor.execute();
           		gotovCiklus=false;
           		while(!gotovCiklus) {}
           		br++;
			}
				
			
			
			return null;
		}

	}
    void execute() {
        try {
        	
        	
    		try{
    			this.socket = new Socket(this.hostname, this.port);
   			 	this.citac = new BufferedReader(new InputStreamReader(socket.getInputStream()));
   			 	this.pisac=new PrintWriter(socket.getOutputStream(), true);
   			//Predstavljanje serveru
               	pisac.println(this.ime);
               	citac.readLine();
               	SWIterator i=new SWIterator();
               	i.execute();
               	//System.out.println(true);
               	
                
               
    		}
    		catch(Exception e) {
   			
   		}	
    		
           /* try (Socket socket = new Socket(this.hostname, this.port)) {
                System.out.println("Usao u sobu:" + this.hostname);
                
               
               
                this.citac = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                this.pisac=new PrintWriter(socket.getOutputStream(), true);
                //Predstavljanje serveru
                pisac.println(this.ime);
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
                this.igra=new Igra();
        		this.igra.setVisible(true);
        		
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
	        	System.out.println("Nez vise");
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
	        	
	        	System.out.println( this.igra.primjedbe);
	        	pisac.println(this.igra.primjedbe);
	        	//Server vraca primjedbe ostalih korisnika
	        	String primjedbeSve=citac.readLine();
	        	String[]nizPrimjedbi=primjedbeSve.split("|");
	        	
	        	br++;
	        	this.igra.spremnoSlanje=false;
                }
                


                
            } catch (Exception e) {
                e.printStackTrace();
            }*/
        } catch (Exception ex) {
            ex.printStackTrace();
        } 
    }
    
   
}
