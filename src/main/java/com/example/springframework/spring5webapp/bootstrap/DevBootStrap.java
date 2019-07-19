package com.example.springframework.spring5webapp.bootstrap;

import com.example.springframework.spring5webapp.model.Author;
import com.example.springframework.spring5webapp.model.Book;
import com.example.springframework.spring5webapp.model.Publisher;
import com.example.springframework.spring5webapp.repositories.AuthorRepo;
import com.example.springframework.spring5webapp.repositories.BookRepo;
import com.example.springframework.spring5webapp.repositories.PublisherRepo;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootStrap implements ApplicationListener<ContextRefreshedEvent>
{
    private AuthorRepo authorRepo;
    private BookRepo bookRepo;
    private PublisherRepo publisherRepo;

    public DevBootStrap(AuthorRepo authorRepo, BookRepo bookRepo, PublisherRepo publisherRepo) {
        this.authorRepo = authorRepo;
        this.bookRepo = bookRepo;
        this.publisherRepo = publisherRepo;
    }

    private void initData()
    {
        // Publisher Way
        Publisher way = new Publisher("Way", "Himalayas");
        publisherRepo.save(way);

        // Publisher Dark
        Publisher dark = new Publisher("Dark", "Japon");
        publisherRepo.save(dark);

        // Sage
        Author sage = new Author("Sage", "Sage");
        Book dao = new Book("The Dao", "12345", way);
        sage.getBooks().add(dao);
        dao.getAuthors().add(sage);
        authorRepo.save(sage);
        bookRepo.save(dao);


        // Akuma
        Author akuma = new Author("Akuma", "Akuma");
        Book hado = new Book("The Hado", "54321", dark);
        akuma.getBooks().add(hado);
        authorRepo.save(akuma);
        bookRepo.save(hado);

    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }
}
