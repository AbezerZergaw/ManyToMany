package com.example.demo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashSet;
import java.util.Set;

@Controller
public class MainController {


    @Autowired
    BookRepository bookRepository;

    @Autowired
    AuthorRepository authorRepository;


    @RequestMapping("/")
    public String index(Model model) {

        Set<Author> authores = new HashSet<>();
        Set<Book>  books = new HashSet<>();
        Author author = new Author();
        author.setName("Micheal");
        author.setEmail("mic@gmail.com");
        authores.add(author);
        authorRepository.save(author);

        author = new Author();
        author.setName("Fi");
        author.setEmail("fi@gmail.com");
        authores.add(author);

        authorRepository.save(author);


        Book book = new Book();

        book.setTitle("Java");
        book.setAuthors(authores);

        books.add(book);
        bookRepository.save(book);

        book = new Book();
        book.setTitle("Math");
        book.setAuthors(authores);
        books.add(book);
        bookRepository.save(book);



        model.addAttribute("authors", authorRepository.findAll());

        model.addAttribute("books", bookRepository.findAll());


        return "index";
    }

}
