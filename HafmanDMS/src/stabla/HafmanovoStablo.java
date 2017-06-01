package stabla;

import cvorovi.Cvor;

public class HafmanovoStablo {
	
	private Cvor koren;

	public Cvor getKoren() {
		return koren;
	}

	public void setKoren(Cvor koren) {
		this.koren = koren;
	}
	
	public static int visinaStabla(Cvor k){
		if(k==null)
			return 0;
		if(k.levo==null && k.desno==null)
			return 1;
		return 1+Integer.max(visinaStabla(k.levo), visinaStabla(k.desno));
	}
	
	public static boolean balansirano(Cvor k){
		if(k==null)
			return true;
		return Math.abs(visinaStabla(k.levo)-visinaStabla(k.desno))<2;
	}
	
	private static int brojCvorova(Cvor k){
		if(k==null)
			return 0;
		return 1 + brojCvorova(k.levo)+brojCvorova(k.desno);
	}
	
	public static boolean potpuno(Cvor k){
		if(k==null)
			return true;
		if(brojCvorova(k)==(Math.pow(2, visinaStabla(k))-1))
			return true;
		return false;
	}
	
	public static boolean postojiCvor(Cvor k,Cvor cvor){
		if(k==null || cvor==null)
			return false;
		if(k.simbol.equals(cvor.simbol))
			return true;
		return postojiCvor(k.levo, cvor) || postojiCvor(k.desno, cvor);
	}
	
	public static String hafmanovKod(Cvor k,Cvor cvor){
		if(k==null || !postojiCvor(k, cvor))
			throw new RuntimeException();
		String kod = "";
		Cvor pom = k;
		if(postojiCvor(k,cvor)){
			while(!pom.simbol.equals(cvor.simbol)){
				if(postojiCvor(pom.levo, cvor)){
					pom = pom.levo;
					kod+="0";
				}
				else if(postojiCvor(pom.desno, cvor)){
					pom = pom.desno;
					kod+="1";
				}
				else
					throw new RuntimeException();
			}
		}
		return kod;
	}
	
	public static String dekodirajKod(Cvor k,String kod){
		if(kod==null || k==null)
			throw new RuntimeException();
		String text = "";
		
		for(int i=0;i<kod.length();){
			Cvor pom = k;
			while(pom.levo!=null || pom.desno!=null){
				if(kod.charAt(i)=='0')
					pom = pom.levo;
				else if(kod.charAt(i)=='1')
					pom = pom.desno;
				else
					throw new RuntimeException();
				i++;
			}
			text+=pom.simbol;
		}
		return text;
	}
	
	public static String kodirajRec(Cvor k, String rec){
		if(k==null || rec==null)
			throw new RuntimeException();
		String kod = "";
		for(int i=0;i<rec.length();i++){
			kod+=hafmanovKod(k, new Cvor(rec.charAt(i)+"", 1))+" ";
		}
		return kod;
	}
}
