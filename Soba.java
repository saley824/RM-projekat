package GUI;



import java.util.Collections;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.Vector;

public class Soba extends Thread
{
	private int id;
	public  Set<UserThread> korisnici = Collections.synchronizedSet(new HashSet<>());
	public Set<Character> slova = Collections.synchronizedSet(new HashSet<>());
	public Vector<PrimjedbaServer> gradoviPrimjedbe = new Vector<PrimjedbaServer>();
	public Vector<PrimjedbaServer> rijekePrimjedbe = new Vector<PrimjedbaServer>();
	public Vector<PrimjedbaServer> drzavaPrimjedbe = new Vector<PrimjedbaServer>();
	public Vector<PrimjedbaServer> planinaPrimjedbe = new Vector<PrimjedbaServer>();
	public Vector<PrimjedbaServer> biljkaPrimjedbe = new Vector<PrimjedbaServer>();
	
	public boolean status;
	


	public Soba(int id) {
		this.id=id;
		this.status=false;
		
		while(this.slova.size()<5) {
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
		int n= r.nextInt(31);
		char c='a';
		if(n<26 && n!=24 ) {
			c=(char) (n+97);
		}
		else if(n==26) c='a'; 
			else if(n==27) c='b';
				else if(n==28) c='c';
					else if(n==29) c='d'; 
						else if(n==30) c='e';
		
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
	public  Set<UserThread> getKorisnici() {
		return korisnici;
	}
	public  void setKorisnici(Set<UserThread> korisnici) {
		this.korisnici = korisnici;
	}
	
	public Set<Character> getSlova() {
		return slova;
	}

	public void setSlova(Set<Character> slova) {
		this.slova = slova;
	}
	
	public void dodajPrimjedbu(Vector<PrimjedbaServer>lista, PrimjedbaServer primjedba) {
		if(!provjeriDaLiPostojiRijec(lista, primjedba.getUnos()))
			lista.add(primjedba);
	}
	private boolean provjeriDaLiPostojiRijec(Vector<PrimjedbaServer> lista, String rijec) {
		for(PrimjedbaServer ps: lista) {
			if(ps.getUnos().equalsIgnoreCase(rijec)) {
				return true;
			}
		}
		return false;
	}
}
