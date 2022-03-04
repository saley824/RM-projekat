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
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.Vector;
import java.util.concurrent.TimeUnit;

import javax.swing.SwingWorker;

public class UserThread extends Thread implements Comparable<UserThread> {
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
	private int brojac;

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

		// this.soba.dodajKorisnika(this);
		try {
			PlayerName = in.readLine();
			provjeraImena(Server2.trenutnaSoba.korisnici, this);
			
		} catch (IOException e) {

			e.printStackTrace();
		}
		while (Server2.trenutnaSoba.korisnici.size() < 3) {
			// System.out.println();
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
		// znak za pocetak igre
		out.println("start");
		for (Character c : this.slova) {

			// slanje slova

			out.println(c + "#" +this.points+"#"+PlayerName);
			
			
			//out.println(this.points+"");

			// uzimanje odgovora

			String[] odgovori = null;
			try {
				odgovori = in.readLine().split("_");
			} catch (IOException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			
			}
			
			this.drzava =odgovori[0];
			this.grad = odgovori[1];
			this.planina = odgovori[2];
			this.rijeka = odgovori[3];
			this.biljka = odgovori[4];
			if(!(odgovori[0].substring(0,1).equalsIgnoreCase(c+""))) 
				this.drzava = "X";
			if(!(odgovori[1].substring(0,1).equalsIgnoreCase(c+""))) 
				this.grad = "X";
			if(!(odgovori[2].substring(0,1).equalsIgnoreCase(c+""))) 
				this.planina = "X";
			if(!(odgovori[3].substring(0,1).equalsIgnoreCase(c+""))) 
				this.rijeka = "X";
			if(!(odgovori[4].substring(0,1).equalsIgnoreCase(c+""))) 
				this.biljka = "X";
			
			
//			System.out.println(odgovori[0]+(odgovori[0].length()));
//			System.out.println(odgovori[1]+(odgovori[1].length()));
//			System.out.println(odgovori[2]+(odgovori[2].length()));
//			System.out.println(odgovori[3]+(odgovori[3].length()));
//			System.out.println(odgovori[4]+(odgovori[4].length()));
			this.soba.korisnici2.add(this);
			while (this.soba.korisnici2.size() < 3) {
				// System.out.println();
			}

//			try {
//				TimeUnit.SECONDS.sleep(5);
//			} catch (InterruptedException e2) {
//				// TODO Auto-generated catch block
//				e2.printStackTrace();
//			}
			Server2.posaljiRjesenja(this, soba);

			// uzimanje primjedbi koje je ovaj korisnik uputio
			// nek je primjedba u obliku
			// drzava_grad_planina_rijeka_biljka/drzava2_grad2_planina2_rijeka2_biljka2
			String[] svePrimjedbe = null;
			String prim = "";
			try {
				prim = in.readLine();
			} catch (IOException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
			System.out.println("Primjedbe koje su stigle: " + prim);

			svePrimjedbe = prim.split("/");
			for (String p : svePrimjedbe) {

				String[] primjedba = p.split("_");

				if (!primjedba[0].equals("X"))
					this.soba.dodajPrimjedbu(this.soba.drzavaPrimjedbe, new PrimjedbaServer(primjedba[0]));

				if (!primjedba[3].equals("X"))
					this.soba.dodajPrimjedbu(this.soba.gradoviPrimjedbe, new PrimjedbaServer(primjedba[3]));

				if (!primjedba[2].equals("X"))
					this.soba.dodajPrimjedbu(this.soba.planinaPrimjedbe, new PrimjedbaServer(primjedba[2]));

				if (!primjedba[1].equals("X"))
					this.soba.dodajPrimjedbu(this.soba.rijekePrimjedbe, new PrimjedbaServer(primjedba[1]));

				if (!primjedba[4].equals("X"))
					this.soba.dodajPrimjedbu(this.soba.biljkaPrimjedbe, new PrimjedbaServer(primjedba[4]));

			}

			// System.out.println("drzava primjedbe"+ this.soba.drzavaPrimjedbe);

//			try {
//				TimeUnit.SECONDS.sleep(5);
//			} catch (InterruptedException e1) {
//				// TODO Auto-generated catch block
//				e1.printStackTrace();
//			}

			this.soba.korisnici3.add(this);
			while (this.soba.korisnici3.size() < 3) {
				// System.out.println();
			}

			// slanje primjedbi od ostalih igraca, kako bi se ovaj korisnik izjasnio
			Server2.posaljiPrimjedbe(this, this.soba);

			// preuzimanje glasova za primjedbe ovog korisnika
			String[] glasovi = null;
			String s10= "";
			try {
				 s10 = in.readLine();
				glasovi = s10.split("/");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			this.soba.korisnici4.add(this);
			while (this.soba.korisnici4.size() < 3) {
				// System.out.println();
			}
			 brojac = 0;
			System.out.println("GLASANJEEEEEEEEEEEEEEEE  "+ s10);
			for (String g : glasovi) {
				if(brojac>4)
					brojac=0;
				System.out.println(g);
				String[] glas = g.split("_");

				if (!glas[0].equals("X")) {
					
					if (brojac == 0)
						glasanje(this.soba.drzavaPrimjedbe, glas);
					else if (brojac == 1)
						glasanje(this.soba.gradoviPrimjedbe, glas);
					else if (brojac == 2)
						glasanje(this.soba.planinaPrimjedbe, glas);
					else if (brojac == 3)
						glasanje(this.soba.rijekePrimjedbe, glas);
					else if (brojac == 4)
						glasanje(this.soba.biljkaPrimjedbe, glas);

				}

				brojac++;

			}
			
			
			this.soba.korisnici5.add(this);
			while (this.soba.korisnici5.size() < 3) {
				// System.out.println();
			}
			System.out.println(this.soba.drzavaPrimjedbe);

			bodovanje(this.soba.drzavaPrimjedbe, this.drzava, 0);
			bodovanje(this.soba.gradoviPrimjedbe, this.grad, 1);
			bodovanje(this.soba.planinaPrimjedbe, this.planina, 2);
			bodovanje(this.soba.rijekePrimjedbe, this.rijeka, 3);
			bodovanje(this.soba.biljkaPrimjedbe, this.biljka, 4);
			
			
			this.soba.korisnici6.add(this);
			while (this.soba.korisnici6.size() < 3) {
				// System.out.println();
			}
			this.getSoba().biljkaPrimjedbe.clear();
			this.getSoba().gradoviPrimjedbe.clear();
			this.getSoba().drzavaPrimjedbe.clear();
			this.getSoba().planinaPrimjedbe.clear();
			this.getSoba().rijekePrimjedbe.clear();
			this.getSoba().korisnici4.clear();
			this.getSoba().korisnici2.clear();
			this.getSoba().korisnici3.clear();
			this.getSoba().korisnici5.clear();
			this.getSoba().korisnici6.clear();
			out.println(this.points);
			System.out.println(this);

		}

		out.println(pobjednik());

//			in.close();
//			out.close();
//			sock.close();

	}

	private synchronized String pobjednik() {
		synchronized (this.soba.korisnici) {
			Collections.sort(this.soba.korisnici);
			String s = "";
			UserThread kor = null;
//			for(UserThread korisnik: this.soba.korisnici) {
//				if (korisnik.getPoints()>maks) {
//					maks=korisnik.getPoints();
//					kor=korisnik;
//				}
//				
//			}
			int i = 0;
			for (UserThread korisnik : this.soba.korisnici) {
				s += korisnik.getPlayerName() + "#" + korisnik.getPoints() + "#";
				i++;
			}
			s = s.substring(0, s.length() - 1);
			return s;
		}
	
	}

	// vraca true ako je rijec prosla, vraca false ako rijec nije prosla
	
	private void provjeraImena(List<UserThread> korisnici, UserThread thisUser) {
		synchronized (korisnici) {
			for(UserThread user:korisnici ) {
				
				if(thisUser!=user) {
					if(thisUser.PlayerName.equals(user.PlayerName)) {
						thisUser.PlayerName+="_2";
						break;
					}
				}
					
			
		}
			
	for(UserThread user:korisnici ) {
				
				if(thisUser!=user) {
					if(thisUser.PlayerName.equals(user.PlayerName)) {
						thisUser.PlayerName=thisUser.PlayerName.substring(0,thisUser.PlayerName.length()-2);
						thisUser.PlayerName+="_3";
						break;
					}
				}
					
			
		}
		}
	}
	
	private void bodovanje(List<PrimjedbaServer> lista, String polje, int n) {
		synchronized (lista) {
			if (!polje.equals("X") && provjeraPrimjedbe(lista, polje)) {
				int b = 0;
				for (UserThread korisnik : this.soba.korisnici) {
					if (n == 0) {
						if (korisnik.getDrzava().equalsIgnoreCase(polje))
							b++;
					}

					if (n == 1) {
						if (korisnik.getGrad().equalsIgnoreCase(polje))
							b++;
					}

					if (n == 2) {
						if (korisnik.getPlanina().equalsIgnoreCase(polje))
							b++;
					}

					if (n == 3) {
						if (korisnik.getRijeka().equalsIgnoreCase(polje))
							b++;
					}

					if (n == 4) {
						if (korisnik.getBiljka().equalsIgnoreCase(polje))
							b++;
					}

				}
				// 20 poena ako jedini pogodi, 10 ako dvojica isto, 5 ako svi isto
				if (b == 1)
					this.setPoints(this.getPoints() + 20);

				else if (b == 2)
					this.setPoints(this.getPoints() + 10);

				else if (b > 2)
					this.setPoints(this.getPoints() + 5);

			}
		}

	}

	private boolean provjeraPrimjedbe(List<PrimjedbaServer> lista, String polje) {
		synchronized (lista) {
			for (PrimjedbaServer ps : lista) {
				if (ps.getUnos().equalsIgnoreCase(polje))
					if (ps.getNegativniGlasovi() >= 2)
						return false;
			}
			return true;
		}

	}

	private void glasanje(List<PrimjedbaServer> lista, String[] glas) {
		synchronized (lista) {
			for (String s : glas) {
				for (PrimjedbaServer ps : lista) {
					if (ps.getUnos().equalsIgnoreCase(s.substring(0, s.length() - 1)))
						if ((s.substring(s.length() - 1).equals("1")))
							ps.setNegativniGlasovi(ps.getNegativniGlasovi() + 1);

				}
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

	@Override
	public int compareTo(UserThread ut) {
		// TODO Auto-generated method stub
		return ut.points - this.points;
	}

}
