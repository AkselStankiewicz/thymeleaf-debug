package sda.springbasic.thymeleafworkshop.controller;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import sda.springbasic.thymeleafworkshop.exceptions.AuthorDoesNotExist;
import sda.springbasic.thymeleafworkshop.model.AuthorToDelete;
import sda.springbasic.thymeleafworkshop.model.Book;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/book")
public class BookController {

    private final List<Book> books;

    @GetMapping("/all")
    public String showAllBooks(ModelMap model) {

        model.addAttribute("books", books);
        model.addAttribute("newBook", new Book());
        model.addAttribute("authorToDeleteFromBase", new AuthorToDelete());

        return "book";
    }

    @PostMapping("/addBook")
    public String addBook(@ModelAttribute("newBook") @Valid Book book, BindingResult result, ModelMap model) { // @ModelAttribute - coś jak request body

        if (result.hasErrors()) {
            model.addAttribute("books", books);
            model.addAttribute("newBook", new Book());
            model.addAttribute("authorToDeleteFromBase", new AuthorToDelete());
            System.out.println(result.getAllErrors());
            return "book";
        }

        System.out.println(book);
        books.add(book);

        return "redirect:/book/all";
    }

    @PostMapping("/deleteBookByAuthor")
    public String deleteBookByAuthor (@ModelAttribute("authorToDeleteFromBase") AuthorToDelete authorToDelete) {

        if (authorToDelete.getName().isBlank()) {
            throw new IllegalArgumentException("Nie może być pusty.");
        }

         if(!books.removeIf(b-> b.getAuthor().equals(authorToDelete.getName()))) {
             throw new AuthorDoesNotExist();
         }
         return "redirect:/book/all";
    }

    public BookController(List<Book> books) {
        this.books = books;
        books.add(new Book("Ogniem i Mieczem", "Henryk Sienkiewicz"));
        books.add(new Book("Pan Tadeusz", "Adam Mickiewicz"));
        books.add(new Book("Harry Potter i Kamień Filozoficzny", "J.K. Rowling"));
        books.add(new Book("Harry Potter i Komnata Tajemnic", "J.K. Rowling"));
    }
}
