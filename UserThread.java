package GUI;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.CharConversionException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Collections;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.Vector;
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
	private Soba soba;
	private Set<Character> slova = Collections.synchronizedSet(new HashSet<>());
	private SwingWorker worker;
	

//private void initializeWorker() {
//    	
//    	UserThread sender=this;
//        worker = new SwingWorker<Void, Void>() {
//        
//            @Override
//            protected Void doInBackground() throws Exception {
//            	PlayerName = in.readLine();
//            	while(Server2.trenutnaSoba.korisnici.size()<2) {
//					//System.out.println();
//				}
//                
//                
//                return null;
//            }
//            @Override
//            protected void done() {
//            	out.println("start");
//    			//out.println(c+""); // slanje slova
//    			
//    			for(Character c: sender.slova) {
//					
//    				
//    				out.println(c+""); // slanje slova
//    				System.out.println(c+"");
//    				String[] odgovori=null;
//					try {
//						odgovori = in.readLine().split("_");
//					} catch (IOException e2) {
//						// TODO Auto-generated catch block
//						e2.printStackTrace();
//					} // uzimanje rjesenja
//    				
//    				sender.drzava=odgovori[0];
//    				sender.grad=odgovori[1];
//    				sender.planina=odgovori[2];
//    				sender.rijeka=odgovori[3];
//    				sender.biljka=odgovori[4];
//    				
//    				try {
//						TimeUnit.SECONDS.sleep(10);
//					} catch (InterruptedException e2) {
//						// TODO Auto-generated catch block
//						e2.printStackTrace();
//					}
//    				Server2.posaljiRjesenja(sender, soba);
//    				
//    				// nek je primjedba u obliku drzava_grad_planina_rijeka_biljka/drzava2_grad2_planina2_rijeka2_biljka2
//    				String[] svePrimjedbe=null;
//					try {
//						svePrimjedbe = in.readLine().split("/");
//					} catch (IOException e2) {
//						// TODO Auto-generated catch block
//						e2.printStackTrace();
//					}
//    				for(String p:svePrimjedbe) {
//    	        		//System.out.println();
//    	        		String[] primjedba=p.split("_");
////    	        			
////    	        			String imeIgraca=primjedba[0];
////    	        			String polje=primjedba[1];
////    	        			String unos=primjedba[2];
//    	        			
//    	        			if(!primjedba[0].equals("X")) 
//    	        				sender.soba.dodajPrimjedbu(sender.soba.drzavaPrimjedbe, new PrimjedbaServer(primjedba[0]));
//    	        			
//    	        			if(!primjedba[1].equals("X")) 
//    	        				sender.soba.dodajPrimjedbu(sender.soba.gradoviPrimjedbe, new PrimjedbaServer(primjedba[1]));
//    	        			
//    	        			if(!primjedba[2].equals("X")) 
//    	        				sender.soba.dodajPrimjedbu(sender.soba.planinaPrimjedbe, new PrimjedbaServer(primjedba[2]));
//    	        			
//    	        			if(!primjedba[3].equals("X")) 
//    	        				sender.soba.dodajPrimjedbu(sender.soba.rijekePrimjedbe, new PrimjedbaServer(primjedba[3]));
//    	        			
//    	        			if(!primjedba[4].equals("X")) 
//    	        				sender.soba.dodajPrimjedbu(sender.soba.biljkaPrimjedbe, new PrimjedbaServer(primjedba[4]));
//    	        	
//    	        	}
//    				
//    				try {
//						TimeUnit.SECONDS.sleep(10);
//					} catch (InterruptedException e1) {
//						// TODO Auto-generated catch block
//						e1.printStackTrace();
//					}
//    				 //posaljem ostalim igracima
//    					Server2.posaljiPrimjedbe(sender, sender.soba);
//    				// klijent glasa i salje serveru
//    					String[] glasovi=null;
//						try {
//							glasovi = in.readLine().split("/");
//						} catch (IOException e) {
//							// TODO Auto-generated catch block
//							e.printStackTrace();
//						}
//    					int brojac=0;
//    					for(String g:glasovi) {
//    		        		System.out.println(g);
//    		        		String[] glas=g.split("_");
//    		        		
//    		        	
//    		        			if(!glas[0].equals("X")) {
//    		        			
//    		        				
//    		        				if(brojac==0)
//    		        					glasanje(sender.soba.drzavaPrimjedbe, glas);
//    		        				else if(brojac==1)
//    		        					glasanje(sender.soba.gradoviPrimjedbe, glas);
//    		        				else if(brojac==2)
//    		        					glasanje(sender.soba.planinaPrimjedbe, glas);
//    		        				else if(brojac==3)
//    		        					glasanje(sender.soba.rijekePrimjedbe, glas);
//    		        				else if(brojac==4)
//    		        					glasanje(sender.soba.biljkaPrimjedbe, glas);
//    		        							
//    		        			}
//    		        			
//    		        	brojac++;
//    		        	
//    		        	}
//    					try {
//							TimeUnit.SECONDS.sleep(10);
//						} catch (InterruptedException e) {
//							// TODO Auto-generated catch block
//							e.printStackTrace();
//						}
//    					System.out.println(sender.getSoba().gradoviPrimjedbe);
//    					
//    					try {
//							in.close();
//							out.close();
//	    					sock.close();
//						} catch (IOException e) {
//							// TODO Auto-generated catch block
//							e.printStackTrace();
//						}
//    					
//    					//sabac1_prijed0/moskva
//    					
//    				// System.out.println("primjedbe"+in.readLine());
//    				}
//    			
//    			
//    			//Server2.posaljiRjesenja(sender);
//    			/*try {
//    			System.out.println("primjedbe"+in.readLine());
//    			
//    			in.close();
//    			out.close();
//    			sock.close();}
//    			catch(Exception e) {
//    				e.printStackTrace();}*/
//            }
//
//            
//        };
//    }

	// private char c;

	public UserThread(Socket sock, int id, Set<Character> slova, Soba soba) {
		this.slova = slova;
		this.id = id;
		this.sock = sock;
		this.soba = soba;
		try {
			this.in = new BufferedReader(new InputStreamReader(sock.getInputStream()));
			this.out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(sock.getOutputStream())), true);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		start();
	}

	@Override
	public void run() {
		
			//this.soba.dodajKorisnika(this);		
		try {
			PlayerName = in.readLine();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
    	while(Server2.trenutnaSoba.korisnici.size()<3) {
			//System.out.println();
		}
//		try {
//		
//		this.initializeWorker();
//		this.worker.execute();
//	
//		
//	}catch(Exception ex) {
//		ex.printStackTrace();
//	}
    	//znak za pocetak igre
    	out.println("start");
    	for(Character c: this.slova) {
			
    		// slanje slova
			out.println(c+""); 
			System.out.println(c+"");
			
			// uzimanje odgovora
			
			String[] odgovori=null;
			try {
				odgovori = in.readLine().split("_");
			} catch (IOException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			} 
			
			this.drzava=odgovori[0];
			this.grad=odgovori[1];
			this.planina=odgovori[2];
			this.rijeka=odgovori[3];
			this.biljka=odgovori[4];
			
			try {
				TimeUnit.SECONDS.sleep(10);
			} catch (InterruptedException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
			Server2.posaljiRjesenja(this, soba);
			
			//uzimanje primjedbi koje je ovaj korisnik uputio
			// nek je primjedba u obliku drzava_grad_planina_rijeka_biljka/drzava2_grad2_planina2_rijeka2_biljka2
			String[] svePrimjedbe=null;
			String prim="";
			try {
				 prim=in.readLine();
			} catch (IOException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
			System.out.println("Primjedbe koje su stigle: "+prim);
			
			svePrimjedbe=prim.split("/");
			for(String p:svePrimjedbe) {
        		
        		String[] primjedba=p.split("_");
        		
        			if(!primjedba[0].equals("X")) 
        				this.soba.dodajPrimjedbu(this.soba.drzavaPrimjedbe, new PrimjedbaServer(primjedba[0]));
        			
        			if(!primjedba[1].equals("X")) 
        				this.soba.dodajPrimjedbu(this.soba.gradoviPrimjedbe, new PrimjedbaServer(primjedba[1]));
        			
        			if(!primjedba[2].equals("X")) 
        				this.soba.dodajPrimjedbu(this.soba.planinaPrimjedbe, new PrimjedbaServer(primjedba[2]));
        			
        			if(!primjedba[3].equals("X")) 
        				this.soba.dodajPrimjedbu(this.soba.rijekePrimjedbe, new PrimjedbaServer(primjedba[3]));
        			
        			if(!primjedba[4].equals("X")) 
        				this.soba.dodajPrimjedbu(this.soba.biljkaPrimjedbe, new PrimjedbaServer(primjedba[4]));
        	
        	}
			
			//System.out.println("drzava primjedbe"+ this.soba.drzavaPrimjedbe);
			
			try {
				TimeUnit.SECONDS.sleep(10);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			 //slanje primjedbi od ostalih igraca, kako bi se ovaj korisnik izjasnio
				Server2.posaljiPrimjedbe(this, this.soba);
				
				// preuzimanje glasova za primjedbe ovog korisnika 
				String[] glasovi=null;
				try {
					glasovi = in.readLine().split("/");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				int brojac=0;
				for(String g:glasovi) {
	        		System.out.println(g);
	        		String[] glas=g.split("_");
	        		
	        	
	        			if(!glas[0].equals("X")) {
	        			
	        				
	        				if(brojac==0)
	        					glasanje(this.soba.drzavaPrimjedbe, glas);
	        				else if(brojac==1)
	        					glasanje(this.soba.gradoviPrimjedbe, glas);
	        				else if(brojac==2)
	        					glasanje(this.soba.planinaPrimjedbe, glas);
	        				else if(brojac==3)
	        					glasanje(this.soba.rijekePrimjedbe, glas);
	        				else if(brojac==4)
	        					glasanje(this.soba.biljkaPrimjedbe, glas);
	        							
	        			}
	        			
	        	brojac++;
	        	
	        	}
    	
				System.out.println(this.soba.drzavaPrimjedbe);
				
				
    	}
    	
    	
    	

	
				

		
			
//			in.close();
//			out.close();
//			sock.close();
		
	}
	
	private void glasanje(Vector<PrimjedbaServer> lista, String[] glas ) {
		for(String s: glas) {
			for(PrimjedbaServer ps: lista) {
					if(ps.getUnos().equalsIgnoreCase(s.substring(0,s.length()-1))) 
						if((s.substring(s.length()-1).equals("1")))
							ps.setNegativniGlasovi(ps.getNegativniGlasovi()+1);
						
					

			}
		}
	}
	public void sendToClient(String s) {
		out.println(s);
	}

	public void sendMessage(String msg) {
		if (this.out != null)
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
		return id + ".  " + PlayerName + "   " + points;
	}

	public Soba getSoba() {
		return soba;
	}

	public void setSoba(Soba soba) {
		this.soba = soba;
	}

	public Set<Character> getSlova() {
		return slova;
	}

	public void setSlova(Set<Character> slova) {
		this.slova = slova;
	}

}
