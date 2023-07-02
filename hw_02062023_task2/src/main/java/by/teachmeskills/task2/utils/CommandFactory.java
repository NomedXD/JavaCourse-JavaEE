package by.teachmeskills.task2.utils;

import by.teachmeskills.task2.commands.AddProductToCardCommandImpl;
import by.teachmeskills.task2.commands.BaseCommand;
import by.teachmeskills.task2.commands.DeleteProductFromCartCommandImpl;
import by.teachmeskills.task2.commands.RedirectToAccountCommandImpl;
import by.teachmeskills.task2.commands.RedirectToCartCommandImpl;
import by.teachmeskills.task2.commands.RedirectToCategoryCommandImpl;
import by.teachmeskills.task2.commands.RedirectToProductCommandImpl;
import by.teachmeskills.task2.commands.RedirectToRegistrationCommandImpl;
import by.teachmeskills.task2.commands.RedirectToShopPageCommandImpl;
import by.teachmeskills.task2.commands.RegistrationCommandImpl;
import by.teachmeskills.task2.commands.SignInCommandImpl;
import by.teachmeskills.task2.commands.UpdateUserDataCommandImpl;
import by.teachmeskills.task2.enums.CommandsEnum;
import by.teachmeskills.task2.enums.RequestParamsEnum;
import jakarta.servlet.http.HttpServletRequest;

import java.util.HashMap;
import java.util.Map;

public class CommandFactory {
    private static final Map<String, BaseCommand> COMMAND_LIST = new HashMap<>();

    static {
        COMMAND_LIST.put(CommandsEnum.REDIRECT_TO_SHOP_PAGE_COMMAND.getCommand(), new RedirectToShopPageCommandImpl());
        COMMAND_LIST.put(CommandsEnum.LOG_IN_COMMAND.getCommand(), new SignInCommandImpl());
        COMMAND_LIST.put(CommandsEnum.REGISTRATION_COMMAND.getCommand(), new RegistrationCommandImpl());
        COMMAND_LIST.put(CommandsEnum.REDIRECT_TO_REGISTRATION_COMMAND.getCommand(), new RedirectToRegistrationCommandImpl());
        COMMAND_LIST.put(CommandsEnum.REDIRECT_TO_CATEGORY_COMMAND.getCommand(), new RedirectToCategoryCommandImpl());
        COMMAND_LIST.put(CommandsEnum.REDIRECT_TO_PRODUCT_COMMAND.getCommand(), new RedirectToProductCommandImpl());
        COMMAND_LIST.put(CommandsEnum.ADD_PRODUCT_TO_CART.getCommand(), new AddProductToCardCommandImpl());
        COMMAND_LIST.put(CommandsEnum.DELETE_PRODUCT_FROM_CART.getCommand(), new DeleteProductFromCartCommandImpl());
        COMMAND_LIST.put(CommandsEnum.REDIRECT_TO_CART_COMMAND.getCommand(), new RedirectToCartCommandImpl());
        COMMAND_LIST.put(CommandsEnum.REDIRECT_TO_ACCOUNT_COMMAND.getCommand(), new RedirectToAccountCommandImpl());
        COMMAND_LIST.put(CommandsEnum.UPDATE_USER_DATA_COMMAND.getCommand(), new UpdateUserDataCommandImpl());
    }

    public static BaseCommand defineCommand(HttpServletRequest request) {
        String commandKey = request.getParameter(RequestParamsEnum.COMMAND.getValue());
        if (commandKey == null || commandKey.isEmpty()) {
            commandKey = CommandsEnum.LOG_IN_COMMAND.getCommand();
        }
        return COMMAND_LIST.get(commandKey);
    }

}

