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
	public static Set<UserThread> users = Collections.synchronizedSet(new HashSet<>());
	public static int id=0;
	//public static Boolean full=false;

	
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

	public static void main(String[] args){
		try {
			ServerSocket ss = new ServerSocket(SERVER_PORT);
			//System.out.println("Server je pokrenut...");
			char c=charGenerator();
			while(true) {
				Socket sc = ss.accept();
				
				System.out.println("Klijent prihvacen");
				
				id++;
				users.add(new UserThread(sc, id, c));
				System.out.println(users);	
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	// slanje rjesenja ostalih igraca
	synchronized public static void posaljiRjesenja( UserThread sender) {
		String s="";
		for(UserThread user: users) {
			if(user!=sender) {
			s+=user.getPlayerName()+"_"+user.getDrzava()+"_"+user.getGrad()+"_"+user.getPlanina()+"_"+user.getRijeka()+"_"+user.getBiljka()+"/";
			}
			//System.out.println(s);
		}
		String m=s.substring(0,s.length()-1);
		//System.err.println(m);
		sender.sendMessage(m);

	}

}
