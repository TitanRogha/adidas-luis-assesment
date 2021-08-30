package starter.add_to_cart;

import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.TextContent;
import starter.dashboard.Account;

public class Cart {
    public static Question<String> cart_title(){
        return actor -> TextContent.of(Man.ADDED_TO_CART).viewedBy(actor).asString();
    }
}
