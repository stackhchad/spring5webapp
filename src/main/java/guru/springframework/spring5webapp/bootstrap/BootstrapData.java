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
public class BootstrapData implements CommandLineRunner {


    private final BookRepository bookRepository;

    private final AuthorRepository authorRepository;

    private final PublisherRepository publisherRepository;

    public BootstrapData(BookRepository bookRepository, AuthorRepository authorRepository, PublisherRepository publisherRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Publisher publisher1=new Publisher();
        publisher1.setName("publisher1");
        publisherRepository.save(publisher1);
        Book book1= new Book();
        book1.setTitle("book1");
        book1.setIsbn("111");
        Book book2= new Book();
        book2.setTitle("book2");
        book2.setIsbn("112");
        Author author1= new Author("author1","author1");
        Author author2= new Author("author2","author2");

        author1.getBooks().add(book1);
        author1.getBooks().add(book2);
        book1.setPublisher(publisher1);
        book2.setPublisher(publisher1);
        publisher1.getBooks().add(book1);
        publisher1.getBooks().add(book2);
        authorRepository.save(author1);
        authorRepository.save(author2);
        bookRepository.save(book1);
        bookRepository.save(book2);


       // System.out.println("zine"+authorRepository.count());
      //  System.out.println("publisher  book1 = "+publisher1.getBooks().size());



    }
}
