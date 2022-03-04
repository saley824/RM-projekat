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
	Korisnik ovaj = this;
	
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
    
    public String getIme() {
    	return ime;
    }
    protected SwingWorker worker;
    protected String primjedbeOdgovori="";
    
       
    
    protected Socket socket;
    
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
    		
         
        } catch (Exception ex) {
            ex.printStackTrace();
        } 
    }
    public class SWIterator extends SwingWorker {

		@Override
		protected Object doInBackground() throws Exception {
			
			int br=0;
			while(br<2) {
				System.out.print(br);
				TimeUnit.SECONDS.sleep(1);
				
				String slovoBodIme=citac.readLine();
				String[] slovoBodIme2=slovoBodIme.split("#");
				String slovo = slovoBodIme2[0];
				String bod=slovoBodIme2[1];
				ovaj.ime=slovoBodIme2[2];
				int bodovi = Integer.parseInt(bod);
               	igra=new Igra(ovaj.getIme(), bodovi);
               	
               	igra.slovo.setText(slovo);
           		igra.setVisible(true);
           		SWKorisnik kor=new SWKorisnik();
           		kor.execute();
           		gotovCiklus=false;
           		while(!gotovCiklus) {
           			System.out.println("");
           		}
           		br++;
			}
				
			String pobjednik = citac.readLine();
			String[] listaRezultata=pobjednik.split("#");
			int rez1 =Integer.parseInt( listaRezultata[1]);
			int rez2 =Integer.parseInt( listaRezultata[3]);
			int rez3 =Integer.parseInt( listaRezultata[5]);
			Rezultati r = new Rezultati(listaRezultata[0], listaRezultata[2], listaRezultata[4], rez1, rez2, rez3);

		
			r.setVisible(true);
			
			return null;
		}

	}
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
        public class SWRjesenja extends SwingWorker {

    		@Override
    		protected Object doInBackground() throws Exception {
    			
    			String [] odgIgrac=citac.readLine().split("/");
    			r=new Rjesenja();
    			r.setVisible(true);
    			for(int i=0;i<3;i++) {
    			String []odgovoriI=odgIgrac[i].split("_");
    			r.tfIgraci[i].setText(odgovoriI[0]);
    			r.tfDrzave[i].setText(odgovoriI[1]);
    			r.tfRijeke[i].setText(odgovoriI[4]);
    			r.tfPlanine[i].setText(odgovoriI[3]);
    			r.tfGradovi[i].setText(odgovoriI[2]);
    			r.tfBiljke[i].setText(odgovoriI[5]);
    			}
    			while(r.PrimjedbeSpremne==false) {
    				System.out.print(r.PrimjedbeSpremne);
    				Thread.sleep(1000);
    			}
    			
    			System.out.println("Poslao");
    			pisac.println(r.primjedba.substring(0, r.primjedba.length()-1));
    			r.setVisible(false);
    			System.out.println("Poslao");
    			String primjedbeSve=citac.readLine();
    			//System.out.println(primjedbeSve);
    			
    			
    			// ovaj dio koda sam mijenjao da bih lakse razlikova oblasti jedne od  drugih(npr. gradove i drzave)
    			// znakom / su razdvojene razlicite kategorije(grad, blijka)
    			// znakom _ su razdvojeni nor. razliciti gradovi
    			String[]nizPrimjedbi=primjedbeSve.split("/");
    			
    			int i=0;
    			for(String prim:nizPrimjedbi) {
    				
    				String[]jednaVrstaPrimjedbi=prim.split("_");
    					if(jednaVrstaPrimjedbi[0].equals("X"))
    						odgovoriNaPrimjedbe+="X/";
    					else {
    						for(String prim2: jednaVrstaPrimjedbi) {
    							Primjedbe p=new Primjedbe(ovaj.ime);
    							if(i==0)
    							p.tfOdgovor.setText(prim2+"-drzava");
    							if(i==1)
    								p.tfOdgovor.setText(prim2+"-grad");
    							if(i==2)
    								p.tfOdgovor.setText(prim2+"-planina");
    							if(i==3)
    								p.tfOdgovor.setText(prim2+"-rijeka");
    							if(i==4)
    								p.tfOdgovor.setText(prim2+"-biljka");
    							
    							p.setVisible(true);
    							
    							while(p.gotov==false) {
    								System.out.print(p.gotov);
    							}
    							if(p.odbio) {
    								
    								// 0 odbijen
    								odgovoriNaPrimjedbe+=prim2+"0_";
    							}
    							if(p.prihvatio) {
    								// 1 prihvacen
    								odgovoriNaPrimjedbe+=prim2+"1_";
    							}
    							
    							
    							p.setVisible(false);
    						}
    						odgovoriNaPrimjedbe=odgovoriNaPrimjedbe.substring(0,odgovoriNaPrimjedbe.length()-1);
    						odgovoriNaPrimjedbe+="/";
    					
    					}
    				
    				i++;
    				
    			}
    			//Slanje Odgovora
    			System.out.print(odgovoriNaPrimjedbe.substring(0,odgovoriNaPrimjedbe.length()-1));
    			pisac.println(odgovoriNaPrimjedbe.substring(0,odgovoriNaPrimjedbe.length()-1));
    			//Dobijanje bodova od servera
    			String sBodovi=citac.readLine();
    			brojBodova+=Integer.parseInt(sBodovi);
    			System.out.println(brojBodova);
    			gotovCiklus=true;
    			return null;
    		}

    	}
    }
