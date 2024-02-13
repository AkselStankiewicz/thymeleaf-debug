package sda.springbasic.thymeleafworkshop.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import sda.springbasic.thymeleafworkshop.exceptions.AuthorDoesNotExist;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(IllegalArgumentException.class)
    public ModelAndView handleIllegalArgumentException(IllegalArgumentException e) {
        ModelAndView mov = new ModelAndView();
        mov.setViewName("wrongData");
        mov.addObject("errorMessage", e.getMessage());
        return mov;
    }

    @ExceptionHandler(AuthorDoesNotExist.class)
    public ModelAndView handleAuthorDoesNotExistException(AuthorDoesNotExist e) {
        ModelAndView mov = new ModelAndView();
        mov.setViewName("noSuchAuthorExists");
        mov.addObject("errorMessage", e.getMessage());
        return mov;
    }
}
