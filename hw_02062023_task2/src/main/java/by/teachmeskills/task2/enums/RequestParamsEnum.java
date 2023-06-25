package by.teachmeskills.task2.enums;

public enum RequestParamsEnum {
    MAIL("mail"),
    NAME("name"),
    SURNAME("surname"),
    PASSWORD("password"),
    REPEATPASSWORD("repeatPassword"),
    COMMAND("command"),
    SHOPPING_CART("cart"),
    SHOPPING_CART_PRODUCTS("cartProductsList"),
    CATEGORIES("categories"),
    CATEGORYID("categoryid"),
    PRODUCT("product"),
    PRODUCTS("products"),
    PRODUCT_ID("productid"),
    CURRENT_USER("currentUser");


    private final String value;

    RequestParamsEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}

