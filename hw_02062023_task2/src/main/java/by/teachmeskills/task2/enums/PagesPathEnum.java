package by.teachmeskills.task2.enums;

public enum PagesPathEnum {
    SHOP_PAGE("shop.jsp"),
    LOG_IN_PAGE("login.jsp"),
    REGISTRATION_PAGE("register.jsp"),
    CATEGORY_PAGE("category.jsp"),
    CART_PAGE("cart.jsp"),
    PRODUCT_PAGE("product.jsp"),
    ACCOUNT_PAGE("account.jsp");

    private final String path;

    PagesPathEnum(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }
}

