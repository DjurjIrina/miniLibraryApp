package ro.fasttrackit.proiectfinal1;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import ro.fasttrackit.proiectfinal1.model.Book;
import ro.fasttrackit.proiectfinal1.model.BookSynopsis;
import ro.fasttrackit.proiectfinal1.model.BookType;
import ro.fasttrackit.proiectfinal1.repository.BookRepository;
import ro.fasttrackit.proiectfinal1.repository.BookSynopsisRepository;

import java.util.List;

@SpringBootApplication
public class Proiectfinal1CodeApplication {

	public static void main(String[] args) {
		SpringApplication.run(Proiectfinal1CodeApplication.class, args);
	}
	@Bean
	CommandLineRunner atStartup(BookRepository repo, BookSynopsisRepository bookSynopsisRepository) {
		return  args -> {

			BookSynopsis descriptionBookSynopsis = bookSynopsisRepository.save(new BookSynopsis("In timpul revoltei vrajitorilor, Geralt a fost ranit. Iar acum, cand intunericul s-a lasat peste intreaga lume, nu poate face nimic pana nu se vindeca."));
			BookSynopsis descriptionBookSynopsis2 = bookSynopsisRepository.save(new BookSynopsis("Geralt din Rivia, vanatorul de monstri, a asteptat decenii intregi nasterea copilului din profetie: Ciri, cea care va schimba lumea, fie in bine, fie in rau."));
			BookSynopsis descriptionBookSynopsis3 = bookSynopsisRepository.save(new BookSynopsis("Pentru Geralt si Yennefer, e tot mai greu sa-si tina promisiunea de a o apara pe Ciri de oricine si orice ar vana-o, pentru ca ea este cheia salvarii lumii intregi."));
			repo.saveAll(List.of(
					new Book("Scurta istorie a romanilor" ,"Ioan-Aurel Pop", BookType.HISTORY, "Litera", null)
					,new Book("Mica gramatica a limbii germane" ,"Emilia Savin", BookType.GRAMATICA, "Editura Stiintifica", null )
					,new Book("Maestrul si Margareta" ,"Mihail Bulgakov", BookType.FANTASY, "Biblioteca Adevarul" ,null )
					,new Book("Botezul focului" ,"Andrezej Sapkowski", BookType.FANTASY, "Armada",descriptionBookSynopsis )
					,new Book("Sangele elfilor" ,"Andrezej Sapkowski", BookType.FANTASY, "Armada",descriptionBookSynopsis2 )
					,new Book("Vremea dispretului" ,"Andrezej Sapowski", BookType.FANTASY, "Armada",descriptionBookSynopsis3 )
					));
		};
	}
}

