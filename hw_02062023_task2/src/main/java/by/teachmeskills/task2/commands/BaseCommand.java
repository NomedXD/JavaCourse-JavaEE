package by.teachmeskills.task2.commands;

import jakarta.servlet.http.HttpServletRequest;


public interface BaseCommand {
    String execute(HttpServletRequest request);
}


