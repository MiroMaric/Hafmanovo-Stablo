package stabla;

import java.util.Queue;

import cvorovi.Cvor;

public class StabloGenerator {
	
	public static Cvor HafmanovAlgoritam(Queue<Cvor> red){
		int brojac = 1;
		while(red.size()>1){
			Cvor cvor1 = red.poll();
			Cvor cvor2 = red.poll();
			Cvor t = new Cvor("T"+brojac, cvor1.frekvencija+cvor2.frekvencija, cvor1, cvor2);
			brojac++;
			red.add(t);
		}
		return red.poll();
	}
	
}
