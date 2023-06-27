package by.teachmeskills.task2.commands;

import by.teachmeskills.task2.enums.PagesPathEnum;
import jakarta.servlet.http.HttpServletRequest;

public class RedirectToAccountCommandImpl implements BaseCommand {
    @Override
    public String execute(HttpServletRequest request) {
        return PagesPathEnum.ACCOUNT_PAGE.getPath();
    }
}
