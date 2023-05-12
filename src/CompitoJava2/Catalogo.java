package CompitoJava2;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;

public abstract class Catalogo {

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
        return "[codiceISBN: " + codiceISBN + ", titolo: " + titolo + ", annoPublicazione: " + annoPublicazione
                + ", numeroPagine: " + numeroPagine + "]";
    }

    public void writeToFile(String filePath) throws IOException {
        String data = toString();
        FileUtils.writeStringToFile(new File(filePath), data, "UTF-8", true);
        log.info("Dati scritti su file: " + filePath);
    }
}
