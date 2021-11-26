package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.domain.Publisher;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import guru.springframework.spring5webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Started in BootStrap");
        Publisher publisher = new Publisher("AlDustoor","Marj Al-Hammam", "Amman", "Amman", "11732");
        publisherRepository.save(publisher);
        System.out.println("Number of Publishers: " + publisherRepository.count());

        System.out.println("Publisher Number of Books: " + publisher.getBooks().size());

        Author eric = new Author("Eric", "Evans");
        Book ddd = new Book("Domain Driven Design", "123123");
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);

        ddd.setPublisher(publisher);
        publisher.getBooks().add(ddd);

        authorRepository.save(eric);
        bookRepository.save(ddd);
        publisherRepository.save(publisher);

        System.out.println("Publisher Number of Books: " + publisher.getBooks().size());

        Author omar = new Author("Omar", "Didan");
        Book otc = new Book("Omar The Cool", "12312");
        omar.getBooks().add(otc);
        otc.getAuthors().add(omar);

        otc.setPublisher(publisher);
        publisher.getBooks().add(otc);

        authorRepository.save(omar);
        bookRepository.save(otc);
        publisherRepository.save(publisher);

        System.out.println("Number of books: " + bookRepository.count());
        System.out.println("Publisher Number of Books: " + publisher.getBooks().size());


    }
}
