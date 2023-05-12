package CompitoJava2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Libro extends Catalogo{
	
	private String autore;
	private String genere;
	
	static public Logger log = LoggerFactory.getLogger(MainProject.class);
	public Libro(String codiceISBN, String titolo, int annoPublicazione, int numeroPagine, String autore, String genere) {
		super(codiceISBN, titolo, annoPublicazione, numeroPagine);
		this.autore = autore;
		this.genere = genere;
	}


	public String getAutore() {
		return autore;
	}


	public void setAutore(String autore) {
		this.autore = autore;
	}


	public String getGenere() {
		return genere;
	}


	public void setGenere(String genere) {
		this.genere = genere;
	}


	@Override
	public String toString() {
		return "(Libro)= CodiceISBN: " + this.getCodiceISBN() + ", Titolo: " + this.getTitolo()
				+ ", AnnoPublicazione: " + this.getAnnoPublicazione() + ", NumeroPagine: " + this.getNumeroPagine()
				+ ", Autore: " + this.autore + ", Genere: " + this.genere + "";
	}
	
	

}