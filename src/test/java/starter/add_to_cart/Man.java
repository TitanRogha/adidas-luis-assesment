package starter.add_to_cart;

import org.openqa.selenium.By;

public class Man {
    public static By MAN_BUTTON = By.cssSelector("a[href='/hombre']");
    public static By MAN_TENIS_BUTTON = By.cssSelector("li>a[href='/calzado-hombre']");
    public static By DURAMO_TENIS_BUTTON = By.cssSelector("img[title='Tenis Duramo SL']:first-child");
    public static By MODAL_CLOSE_BUTTON = By.className("gl-modal__close");
    public static By SIZE_BUTTON = By.cssSelector("div[data-auto-id='size-selector']>button:nth-child(8)>span");
    public static By ADD_TO_CART_BUTTON = By.cssSelector("button[data-auto-id='add-to-bag']");
    public static By ADDED_TO_CART = By.cssSelector("h5[data-auto-id='added-to-bag-modal-title']");
}
