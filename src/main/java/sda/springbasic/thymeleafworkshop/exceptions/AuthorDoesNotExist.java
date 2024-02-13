package sda.springbasic.thymeleafworkshop.exceptions;

public class AuthorDoesNotExist extends RuntimeException{
    public AuthorDoesNotExist() {
        super("Nie można usunąć autora, ponieważ nie istnieje.");
    }
}
