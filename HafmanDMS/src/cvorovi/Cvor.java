package cvorovi;

public class Cvor implements Comparable<Cvor>{
	public String simbol;
	public int frekvencija;
	public String kod;
	public Cvor levo;
	public Cvor desno;
	
	public Cvor(String simbol,int frekvencija,Cvor levo,Cvor desno) {
		this.simbol = simbol;
		this.frekvencija = frekvencija;
		this.levo = levo;
		this.desno = desno;
	}
	
	public Cvor(String simbol,int frekvencija){
		this.simbol = simbol;
		this.frekvencija = frekvencija;
	}

	@Override
	public int compareTo(Cvor o) {
		return Integer.compare(this.frekvencija, o.frekvencija);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((simbol == null) ? 0 : simbol.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cvor other = (Cvor) obj;
		if (simbol == null) {
			if (other.simbol != null)
				return false;
		} else if (!simbol.equals(other.simbol))
			return false;
		return true;
	}
	
	
	
	
}
