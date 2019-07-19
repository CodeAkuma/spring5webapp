package com.example.springframework.spring5webapp.bootstrap;

import com.example.springframework.spring5webapp.model.Author;
import com.example.springframework.spring5webapp.model.Book;
import com.example.springframework.spring5webapp.repositories.AuthorRepo;
import com.example.springframework.spring5webapp.repositories.BookRepo;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootStrap implements ApplicationListener<ContextRefreshedEvent>
{
    private AuthorRepo authorRepo;
    private BookRepo bookRepo;

    public DevBootStrap(AuthorRepo authorRepo, BookRepo bookRepo) {
        this.authorRepo = authorRepo;
        this.bookRepo = bookRepo;
    }

    private void initData()
    {
        // Sage
        Author sage = new Author("Sage", "Sage");
        Book dao = new Book("The Dao", "12345", "Way");
        sage.getBooks().add(dao);
        dao.getAuthors().add(sage);
        authorRepo.save(sage);
        bookRepo.save(dao);

        // Akuma
        Author akuma = new Author("Akuma", "Akuma");
        Book hado = new Book("The Hado", "54321", "Dark");
        akuma.getBooks().add(hado);
        authorRepo.save(akuma);
        bookRepo.save(hado);
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }
}
