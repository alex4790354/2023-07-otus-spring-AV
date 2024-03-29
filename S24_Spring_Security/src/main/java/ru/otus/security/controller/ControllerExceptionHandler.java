package ru.otus.security.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import ru.otus.security.exception.NotFoundException;

@Slf4j
@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(value = {NotFoundException.class})
    public ModelAndView handleNotFoundException(NotFoundException exception) {
        var modelAndView = new ModelAndView("error");
        modelAndView.addObject("error", exception.getMessage());
        return modelAndView;
    }

    @ExceptionHandler(value = {Exception.class})
    public ModelAndView handleException(Exception exception) {

        log.error("An exception occurred: ", exception);

        var modelAndView = new ModelAndView("error");
        modelAndView.addObject("error", "Something went wrong. Please try again later.");
        return modelAndView;
    }
}
