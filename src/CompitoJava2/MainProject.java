package CompitoJava2;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MainProject {
	static public Logger log = LoggerFactory.getLogger(MainProject.class);
	private static String path = "CatalogoBiblioteca/cat.txt";
	private static File file = new File(path);
	static List<Catalogo> catalogo = new ArrayList<Catalogo>();

	public static void main(String[] args) {

		catalogo.add(new Libro("1L1L", "Lo straniero", 1942, 400, "Albert Camus", "Romanzo"));
		catalogo.add(new Libro("2L", "Alla ricerca del tempo perduto", 1927, 600, "Marcel Proust", "Romanzo"));
		catalogo.add(new Libro("3L", "Il processo", 1925, 400, "Franz Kafka", "Romanzo"));
		catalogo.add(new Libro("4L", "Il piccolo principe", 1943, 500, "Antoine Saint-Exupery", "Racconto"));
		catalogo.add(new Libro("5L", "Furore", 1939, 200, "John Steinbeck", "Romanzo"));

		catalogo.add(new Rivista("1R", "Focus", 2010, 120, Periodo.SETTIMANALE));
		catalogo.add(new Rivista("2R", "NYMagazine", 2006, 150, Periodo.MENSILE));
		catalogo.add(new Rivista("3R", "Vanity Fair", 2005, 200, Periodo.SEMESTRALE));
		catalogo.add(new Rivista("4R", "Vogue", 2010, 100, Periodo.MENSILE));
		catalogo.add(new Rivista("5R", "Giallo Zafferano", 2012, 50, Periodo.SETTIMANALE));

		log.info("ARCHIVIO");
		catalogo.forEach(e -> System.out.println(e));

		log.info("RIMOZIONE ELEMENTI CON ISBN");
		String elementoRimosso = removeElement("3L");
		log.info("Elemento rimosso" + elementoRimosso);

		log.info("RICERCA ELEMENTI CON ISBN");
		String ricercaPerIsbn = cercaISBN("3R").toString();
		log.info("Elemento ricercato per codice ISBN" + ricercaPerIsbn);

		log.info("RICERCA ELEMENTI PER ANNO");
		String ricercaPerAnnoPub = cercaAnno(2005).toString();
		log.info("Elemento ricercato per anno pubblicazione" + ricercaPerAnnoPub);

		log.info("RICERCA ELEMENTI PER AUTORE");
		String ricercaPerAutore = cercaAutore("John Steinbeck").toString();
		log.info("Elemento ricercato per Autore" + ricercaPerAutore);

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

	
	

}

