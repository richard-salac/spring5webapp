/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.domain.Publisher;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import guru.springframework.spring5webapp.repositories.PublisherRepository;
import org.graalvm.compiler.lir.CompositeValue;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 *
 * @author Richard Salac <richard.salac@datera.cz>
 */
@Component
public class BootStrapData implements CommandLineRunner{

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
    
       Publisher p = new Publisher("The Publisher", "Streer XY", "The City", "The State", "123456");
        publisherRepository.save(p);
        
        Author eric = new Author("Eric", "Evans");
        Book ddd = new Book("Domain Driven Design","123123");
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);
        ddd.setPublisher(p);
        p.getBooks().add(ddd);
        
        authorRepository.save(eric);
        bookRepository.save(ddd);
        publisherRepository.save(p);
        
        
        Author rod = new Author("Rod","Johnson");
        Book noEJB = new Book("J2EE Development without EJB", "321321");
        
        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);
        noEJB.setPublisher(p);
        p.getBooks().add(noEJB);
        
        authorRepository.save(rod);
        bookRepository.save(noEJB);
        publisherRepository.save(p);
        
        
        System.out.println("Started in Bootstrap");
        System.out.println("Number of books: " + bookRepository.count());
        
        System.out.println("Number of publishers: " + publisherRepository.count());
        System.out.println("Publisher Number of books:" + p.getBooks().size());
    }
    
}
