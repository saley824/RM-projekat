package GUI;



import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.Vector;

public class Soba extends Thread
{
	private int id;
	//public List <UserThread> list = new ArrayList<UserThread>();
	public  List<UserThread> korisnici = Collections.synchronizedList(new ArrayList<UserThread>());

	public  Set<UserThread> korisnici2 = Collections.synchronizedSet(new HashSet<>());
	public  Set<UserThread> korisnici3 = Collections.synchronizedSet(new HashSet<>());
	public  Set<UserThread> korisnici4 = Collections.synchronizedSet(new HashSet<>());
	public  Set<UserThread> korisnici5 = Collections.synchronizedSet(new HashSet<>());
	public  Set<UserThread> korisnici6 = Collections.synchronizedSet(new HashSet<>());

	public  List<PrimjedbaServer> gradoviPrimjedbe = Collections.synchronizedList(new ArrayList<PrimjedbaServer>());
	public  List<PrimjedbaServer> rijekePrimjedbe = Collections.synchronizedList(new ArrayList<PrimjedbaServer>());
	public  List<PrimjedbaServer> drzavaPrimjedbe = Collections.synchronizedList(new ArrayList<PrimjedbaServer>());
	public  List<PrimjedbaServer> planinaPrimjedbe = Collections.synchronizedList(new ArrayList<PrimjedbaServer>());
	public  List<PrimjedbaServer> biljkaPrimjedbe = Collections.synchronizedList(new ArrayList<PrimjedbaServer>());
	
	public Set<Character> slova = Collections.synchronizedSet(new HashSet<>());
//	public Vector<PrimjedbaServer> gradoviPrimjedbe = new Vector<PrimjedbaServer>();
//	public Vector<PrimjedbaServer> rijekePrimjedbe = new Vector<PrimjedbaServer>();
//	public Vector<PrimjedbaServer> drzavaPrimjedbe = new Vector<PrimjedbaServer>();
//	public Vector<PrimjedbaServer> planinaPrimjedbe = new Vector<PrimjedbaServer>();
//	public Vector<PrimjedbaServer> biljkaPrimjedbe = new Vector<PrimjedbaServer>();
	
	public boolean status;
	


	public Soba(int id) {
		this.id=id;
		this.status=false;
		
		while(this.slova.size()<2) {
			char c=charGenerator();
			this.slova.add(c);
		}
		
		start();
		
	}
	
	public void run(){
		
		while(!status) {
			
		}
	}
	
	public static char charGenerator() {
		Random r= new Random();
		
		int n= r.nextInt(26);
		while(n==24 || n==23 || n== 16 || n==22) {
			 n= r.nextInt(26);
		}
		char c=(char) (n+97);
//		 if(n==24) {
//			c='ć';
//		}
//		else if(n==23) {
//			c='�?';
//		}
//		else if(n==22) {
//			c='đ';
//		}
//		else if(n==16) {
//			c='ž';
//		}
//		else if(n==16) {
//			c='š';
//		}
//		//if(n<26 && n!=24 && n! )
//		else {
		
	//	}
//		else if(n==26) c='A'; 
//			else if(n==27) c='B';
//				else if(n==28) c='C';
//					else if(n==29) c='E'; +
//						else if(n==30) c='F';
//		
		return c;
	}
	
	public void dodajKorisnika(UserThread korisnik) {
		this.korisnici.add(korisnik);
	}
	public long getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public  List<UserThread> getKorisnici() {
		return korisnici;
	}
	public  void setKorisnici(List<UserThread> korisnici) {
		this.korisnici = korisnici;
	}
	
	public Set<Character> getSlova() {
		return slova;
	}

	public void setSlova(Set<Character> slova) {
		this.slova = slova;
	}
	
	public void dodajPrimjedbu(List<PrimjedbaServer>lista, PrimjedbaServer primjedba) {
		if(!provjeriDaLiPostojiRijec(lista, primjedba.getUnos()))
			lista.add(primjedba);
	}
	private boolean provjeriDaLiPostojiRijec(List<PrimjedbaServer> lista, String rijec) {
		for(PrimjedbaServer ps: lista) {
			if(ps.getUnos().equalsIgnoreCase(rijec)) {
				return true;
			}
		}
		return false;
	}
}
