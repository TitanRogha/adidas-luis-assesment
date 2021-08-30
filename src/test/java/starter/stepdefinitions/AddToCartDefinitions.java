package starter.stepdefinitions;

import cucumber.api.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.questions.WebElementQuestion;
import net.serenitybdd.screenplay.waits.Wait;
import net.thucydides.core.annotations.Steps;
import org.hamcrest.core.IsEqual;
import starter.add_to_cart.Cart;
import starter.add_to_cart.Man;
import starter.dashboard.AccountMenu;
import starter.navigation.NavigateTo;
import starter.search.SearchFor;
import starter.search.SearchForm;
import starter.search.SearchResult;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.assertj.core.api.Assertions.assertThat;
import static starter.matchers.TextMatcher.textOf;

public class AddToCartDefinitions {

    @Steps
    SearchResult searchResult;

    String actor;
    @Before
    public void setTheStage() {
        OnStage.setTheStage(new OnlineCast());
    }

    @Given("^(.*) navigate to the Adidas home page")
    public void on_the_Adidas_login_page(String actor){
        this.actor=actor;
        theActorCalled(actor).attemptsTo(NavigateTo.theAdidasHomePage());
    }
    @When("^s?He navigate to Man Tenis submenu")
    public void he_navigate_to_man_tenis_submenu(){
        theActorCalled(actor).attemptsTo(

                Click.on(Man.MAN_BUTTON),
                Click.on(Man.MODAL_CLOSE_BUTTON),
                Wait.until(
                        WebElementQuestion.the(Man.MAN_TENIS_BUTTON) , WebElementStateMatchers.isEnabled()
                ).forNoLongerThan(30).seconds(),
                Click.on(Man.MAN_TENIS_BUTTON)

        );
    }
    @When("^s?He looks for (.*)")
    public void he_search_for(String term){
        theActorCalled(actor).attemptsTo(
                Click.on(Man.DURAMO_TENIS_BUTTON)
        );
    }

    @When("^s?He selects the size and add to the cart")
    public void he_selects_the_size_and_add_to_the_cart(){
        theActorCalled(actor).attemptsTo(
                Wait.until(
                        WebElementQuestion.the(Man.SIZE_BUTTON) , WebElementStateMatchers.isEnabled()
                ).forNoLongerThan(30).seconds(),
                Click.on(Man.SIZE_BUTTON),
                Click.on(Man.ADD_TO_CART_BUTTON),
                Wait.until(
                        WebElementQuestion.the(Man.ADDED_TO_CART) , WebElementStateMatchers.isEnabled()
                ).forNoLongerThan(30).seconds()
        );
    }

    @Then("The item should be added to the cart")
    public void he_should_see_items_related(){
        theActorInTheSpotlight().should(
                seeThat("The Item is added correctly to the cart", Cart.cart_title(), IsEqual.equalTo("¡Añadido al carrito correctamente!"))
        );
    }
}
