package starter.stepdefinitions;

import cucumber.api.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.questions.WebElementQuestion;
import net.serenitybdd.screenplay.waits.Wait;
import org.hamcrest.core.IsEqual;
import starter.dashboard.Account;
import starter.dashboard.AccountMenu;
import starter.login.DoLogin;
import starter.navigation.NavigateTo;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class LoginStepDefinitions {

    String actor;
    @Before
    public void setTheStage() {
        OnStage.setTheStage(new OnlineCast());
    }

    @Given("^(.*) is on the Adidas login page")
    public void on_the_Adidas_login_page(String actor){
        this.actor=actor;
        theActorCalled(actor).attemptsTo(NavigateTo.theAdidasLoginPage());
    }

    @When("He sends their valid credentials")
    public void he_sends_their_valid_credentials(){
        theActorCalled(actor).attemptsTo(
                DoLogin.withCredentials("luchocd27@hotmail.com","Werewolf27*")
        );
    }

    @Then("he should have access to manage his account")
    public void he_should_have_access_to_manage_his_account(){
        theActorCalled(actor).attemptsTo(
                Wait.until(
                        WebElementQuestion.the(Account.PEDIDOS) , WebElementStateMatchers.isEnabled()
                ).forNoLongerThan(30).seconds()
        );
        theActorInTheSpotlight().should(
                seeThat("The Orders option is correctly displayed", AccountMenu.orders(), IsEqual.equalTo("Pedidos")),
                seeThat("The Preferences option is correctly displayed", AccountMenu.preferences(), IsEqual.equalTo("Preferencias")),
                seeThat("The Personal Data option is correctly displayed", AccountMenu.personalData(), IsEqual.equalTo("Datos personales")),
                seeThat("The Address Book option is correctly displayed", AccountMenu.addressBook(), IsEqual.equalTo("Agenda de direcciones"))
        );
    }
}
