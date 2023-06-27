package by.teachmeskills.task2.enums;

public enum CommandsEnum {

    REDIRECT_TO_SHOP_PAGE_COMMAND("shop_redirect"),
    LOG_IN_COMMAND("login"),
    REGISTRATION_COMMAND("register"),
    REDIRECT_TO_REGISTRATION_COMMAND("register_redirect"),
    REDIRECT_TO_CATEGORY_COMMAND("category_redirect"),
    REDIRECT_TO_CART_COMMAND("redirect_to_cart"),
    REDIRECT_TO_PRODUCT_COMMAND("product_redirect"),
    ADD_PRODUCT_TO_CART("add_product_to_cart"),
    DELETE_PRODUCT_FROM_CART("delete_product_from_cart"),
    REDIRECT_TO_ACCOUNT_COMMAND("redirect_to_account"),
    CHANGE_USER_MOBILE_COMMAND("change_user_mobile"),
    CHANGE_USER_STREET_COMMAND("change_user_street"),
    CHANGE_USER_ACCOMMODATION_NUMBER_COMMAND("change_user_accommodation_number"),
    CHANGE_USER_FLAT_NUMBER_COMMAND("change_user_flat_number");
    private final String command;

    CommandsEnum(String command) {
        this.command = command;
    }

    public String getCommand() {
        return command;
    }
}

