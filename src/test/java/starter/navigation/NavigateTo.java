package starter.navigation;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;

public class NavigateTo {

    public static Performable theAdidasHomePage() {
        return Task.where("{0} opens the Adidas home page",
                Open.browserOn().the(AdidasHomePage.class)
        );
    }
    public static Performable theAdidasLoginPage() {
        return Task.where("{0} opens the Adidas Login page",
                Open.browserOn().the(AdidasLoginPage.class)
        );
    }

}