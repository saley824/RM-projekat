package GUI;




import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Server2 {
	static int SERVER_PORT = 12345;
	public static Set<UserThread> allUsers = Collections.synchronizedSet(new HashSet<>());
	public static Set<Soba> sobe = Collections.synchronizedSet(new HashSet<>());
	public static Soba trenutnaSoba=null;
	public static int id=0;
	public static int sobaId=0;
	//public static Boolean full=false;

	
	public static char charGenerator() {
		Random r= new Random();
		int n= r.nextInt(31);
		char c='a';
		if(n<26 && n!=24 ) {
			c=(char) (n+97);
		}
		else if(n==26) c='ć'; 
			else if(n==27) c='č';
				else if(n==28) c='đ';
					else if(n==29) c='š'; 
						else if(n==30) c='ž';
		
		return c;
	}

	public static void main(String[] args){
		try {
			ServerSocket ss = new ServerSocket(SERVER_PORT);
			//System.out.println("Server je pokrenut...");
			
			
			Set<Character> slova = Collections.synchronizedSet(new HashSet<>());
//			while(slova.size()<5) {
//				char c=charGenerator();
//				slova.add(c);
//			}
			
			
			
			while(true) {
				Socket sc = ss.accept();
				
				System.out.println("Klijent prihvacen");
				if(trenutnaSoba==null || trenutnaSoba.getKorisnici().size()==3) {
					Soba soba= new Soba(sobaId);
					trenutnaSoba=soba;
					UserThread korisnik=new UserThread(sc, sobaId, trenutnaSoba.getSlova(), trenutnaSoba);
					trenutnaSoba.dodajKorisnika(korisnik);
					
					//korisnik.setSoba(soba);
					sobaId++;
					System.out.println("prvi if");
					
				}
				else if(trenutnaSoba!=null && trenutnaSoba.getKorisnici().size()<3) {
					UserThread korisnik=new UserThread(sc, sobaId, trenutnaSoba.getSlova(), trenutnaSoba);
					trenutnaSoba.dodajKorisnika(korisnik);
					
					System.out.println("drugi if");
				}
				
				System.out.println(trenutnaSoba.korisnici);
			
				
				id++;
				//allUsers.add(new UserThread(sc, id, c));
				//System.out.println(allUsers);	
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	// slanje rjesenja ostalih igraca
	synchronized public static void posaljiRjesenja( UserThread posiljaoc, Soba soba ) {
		String s="";
		for(UserThread user: soba.getKorisnici()) {
			if(user!=posiljaoc) {
			s+=user.getPlayerName()+"_"+user.getDrzava()+"_"+user.getGrad()+"_"+user.getPlanina()+"_"+user.getRijeka()+"_"+user.getBiljka()+"/";
			}
			//System.out.println(s);
		}
		String m=s.substring(0,s.length()-1);
		//System.err.println(m);
		posiljaoc.sendMessage(m);

	}
	
	synchronized public static void posaljiPrimjedbe( UserThread posiljaoc, Soba soba ) {
		int brojac=0;
		String s="";
		if(!soba.drzavaPrimjedbe.isEmpty()) {
			for(PrimjedbaServer d: soba.drzavaPrimjedbe) {
				if(!posiljaoc.getDrzava().equalsIgnoreCase(d.getUnos())) {
					s+=d.getUnos()+"_";
					brojac++;
				}
				
			}
//			if(!s.isEmpty()) {
//				s=s.substring(0,s.length()-1);
//				s+="/";
//			}
			
		}
		
		if(brojac==0) 
			s+="X/";
		else {
			s=s.substring(0,s.length()-1);
			s+="/";
		}
		
		brojac=0;
		
		if(!soba.gradoviPrimjedbe.isEmpty()) {
			for(PrimjedbaServer g: soba.gradoviPrimjedbe) {
				if(!posiljaoc.getGrad().equalsIgnoreCase(g.getUnos())) {
					s+=g.getUnos()+"_";
					brojac++;
				}
				
			}
//			if(!s.isEmpty()) {
//			s=s.substring(0,s.length()-1);
//			s+="/";
//			}

		}
		
		if(brojac==0) 
			s+="X/";
		else {
			s=s.substring(0,s.length()-1);
			s+="/";
		}
		brojac=0;
		
		if(!soba.planinaPrimjedbe.isEmpty()) {
			for(PrimjedbaServer p: soba.planinaPrimjedbe) {
				if(!posiljaoc.getPlanina().equalsIgnoreCase(p.getUnos())) {
					s+=p.getUnos()+"_";
					brojac++;
				}
				
			}
//			if(!s.isEmpty()) {
//			s=s.substring(0,s.length()-1);
//			s+="/";
//			}
			
		}
		
		if(brojac==0) 
			s+="X/";
		else {
			s=s.substring(0,s.length()-1);
			s+="/";
		}
		
		brojac=0;
		
		if(!soba.rijekePrimjedbe.isEmpty()) {
			for(PrimjedbaServer r: soba.rijekePrimjedbe) {
				if(!posiljaoc.getRijeka().equalsIgnoreCase(r.getUnos())) {
					s+=r.getUnos()+"_";
					brojac++;
				}
					
			}
//			if(!s.isEmpty()) {
//			s=s.substring(0,s.length()-1);
//			s+="/";
//			}
		}
		
		if(brojac==0) 
			s+="X/";
		else {
			s=s.substring(0,s.length()-1);
			s+="/";
		}
		
		brojac=0;
	
		
		if(!soba.biljkaPrimjedbe.isEmpty()) {
			for(PrimjedbaServer b: soba.biljkaPrimjedbe) {
				if(!posiljaoc.getBiljka().equalsIgnoreCase(b.getUnos())) {
					s+=b.getUnos()+"_";
					brojac++;
				}
				
			}
//			if(!s.isEmpty()) {
//			s=s.substring(0,s.length()-1);
//			s+="/";
//			}
		}
		
		if(brojac==0) 
			s+="X";
		
		else {
			s=s.substring(0,s.length()-1);
		}
		brojac=0;
		
		
		posiljaoc.sendMessage(s);

	}

}

