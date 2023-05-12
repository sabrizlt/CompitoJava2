package CompitoJava2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Rivista extends Catalogo {
	
	public Periodo periodicità;
	
	static public Logger log = LoggerFactory.getLogger(MainProject.class);
	
	public Rivista(String codiceISBN, String titolo, int annoPublicazione, int numeroPagine, Periodo periodicità) {
		super(codiceISBN, titolo, annoPublicazione, numeroPagine);
		this.periodicità = periodicità;
	}

	@Override
	public String toString() {
		return "Rivista [ CodiceISBN = " + this.getCodiceISBN() + ", Titolo = "
				+ this.getTitolo() + ", AnnoPublicazione = " + this.getAnnoPublicazione() + ", NumeroPagine = "
				+ this.getNumeroPagine() +  ", periodicità = " + this.periodicità + "]";
	}
	
	

}