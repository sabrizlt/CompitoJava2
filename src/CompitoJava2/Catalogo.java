package CompitoJava2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class  Catalogo {
	
	private String codiceISBN;
	private String titolo;
	private int annoPublicazione;
	private int numeroPagine;
	static public Logger log = LoggerFactory.getLogger(Catalogo.class);
	
	public Catalogo(String codiceISBN, String titolo, int annoPublicazione, int numeroPagine) {
		super();
		this.codiceISBN = codiceISBN;
		this.titolo = titolo;
		this.annoPublicazione = annoPublicazione;
		this.numeroPagine = numeroPagine;
	}

	public String getCodiceISBN() {
		return codiceISBN;
	}

	public void setCodiceISBN(String codiceISBN) {
		this.codiceISBN = codiceISBN;
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public int getAnnoPublicazione() {
		return annoPublicazione;
	}

	public void setAnnoPublicazione(int annoPublicazione) {
		this.annoPublicazione = annoPublicazione;
	}

	public int getNumeroPagine() {
		return numeroPagine;
	}

	public void setNumeroPagine(int numeroPagine) {
		this.numeroPagine = numeroPagine;
	}

	@Override
	public String toString() {
		return "Catalogo [codiceISBN = " + codiceISBN + ", titolo = " + titolo + ", annoPublicazione = " + annoPublicazione
				+ ", numeroPagine = " + numeroPagine + "]";
	}
	
	
	

}