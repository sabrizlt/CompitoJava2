package CompitoJava2;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MainProject {
	static public Logger log = LoggerFactory.getLogger(MainProject.class);
	private static String path = "CatalogoBiblioteca/cat.txt";
	private static File file = new File(path);
	static List<Catalogo> catalogo = new ArrayList<Catalogo>();

	public static void main(String[] args) {

		catalogo.add(new Libro("L1234O", "Lo straniero", 1942, 150, "Albert Camus", "Romanzo"));
		catalogo.add(new Libro("L5678O", "Alla ricerca del tempo perduto", 1927, 250, "Marcel Proust", "Romanzo"));
		catalogo.add(new Libro("L9012O", "Il processo", 1925, 350, "Franz Kafka", "Romanzo"));
		catalogo.add(new Libro("L3456O", "Il piccolo principe", 1943, 450, "Antoine Saint-Exupery", "Racconto"));
		catalogo.add(new Libro("L7890O", "Furore", 1939, 550, "John Steinbeck", "Romanzo"));

		catalogo.add(new Rivista("R1234A", "Focus", 2010, 120, Periodo.SETTIMANALE));
		catalogo.add(new Rivista("R5678A", "NYMagazine", 2006, 150, Periodo.MENSILE));
		catalogo.add(new Rivista("R9012A", "Vanity Fair", 2005, 200, Periodo.SEMESTRALE));
		catalogo.add(new Rivista("R3456A", "Vogue", 2010, 100, Periodo.MENSILE));
		catalogo.add(new Rivista("R7890A", "Giallo Zafferano", 2012, 50, Periodo.SETTIMANALE));

		log.info("ARCHIVIO");
		catalogo.forEach(e -> System.out.println(e));

		log.info("RIMOZIONE ELEMENTI CON ISBN");
		String elementoRimosso = removeElement("L9012O");
		log.info("Elemento rimosso" + elementoRimosso);

		log.info("RICERCA ELEMENTI CON ISBN");
		String ricercaIsbn = cercaISBN("R7890A").toString();
		log.info("Elemento ricercato per codice ISBN" + ricercaIsbn);

		log.info("RICERCA ELEMENTI PER ANNO");
		String ricercaAnno = cercaAnno(2005).toString();
		log.info("Elemento ricercato per anno pubblicazione" + ricercaAnno);

		log.info("RICERCA ELEMENTI PER AUTORE");
		String ricercaAutore = cercaAutore("John Steinbeck").toString();
		log.info("Elemento ricercato per Autore" + ricercaAutore);

	}

	public static String removeElement(String ISBN) {
		Optional<Catalogo> s = catalogo.stream()
				.filter(c -> c.getCodiceISBN().equals(ISBN))
				.findFirst();
		if (s.isPresent()) {
			Catalogo removedEl = s.get();
			catalogo.remove(removedEl);
			return removedEl.toString();
		} else {
			return null;
		}

	}

	public static List<Catalogo> cercaISBN(String ISBN) {
		return catalogo.stream().filter(e -> e.getCodiceISBN().equals(ISBN)).collect(Collectors.toList());
	}

	public static List<Catalogo> cercaAnno(int year) {
		return catalogo.stream().filter(e -> e.getAnnoPublicazione() == (year)).collect(Collectors.toList());
	}

	public static List<Catalogo> cercaAutore(String autore) {
		return catalogo.stream().filter(e -> e instanceof Libro && ((Libro) e).getAutore().equals(autore))
				.collect(Collectors.toList());
	}

	public static void scriviSuFile() throws IOException {
		FileUtils.writeStringToFile(file, catalogo.toString(), "UTF-8", true);
		System.out.println("Testo scritto su file");
	}



}
