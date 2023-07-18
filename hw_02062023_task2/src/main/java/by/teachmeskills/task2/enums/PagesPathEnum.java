package by.teachmeskills.task2.enums;

public enum PagesPathEnum {
    SHOP_PAGE("/WEB-INF/view/shop.jsp"),
    LOG_IN_PAGE("/WEB-INF/view/login.jsp"),
    REGISTRATION_PAGE("/WEB-INF/view/register.jsp"),
    CATEGORY_PAGE("/WEB-INF/view/category.jsp"),
    CART_PAGE("/WEB-INF/view/cart.jsp"),
    PRODUCT_PAGE("/WEB-INF/view/product.jsp"),
    ACCOUNT_PAGE("/WEB-INF/view/account.jsp"),
    SEARCH_PAGE("/WEB-INF/view/search.jsp");

    private final String path;

    PagesPathEnum(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }
}

