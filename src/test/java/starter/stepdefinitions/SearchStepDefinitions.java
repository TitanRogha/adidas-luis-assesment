package starter.stepdefinitions;

import cucumber.api.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.thucydides.core.annotations.Steps;
import starter.navigation.NavigateTo;
import starter.search.SearchFor;
import starter.search.SearchResult;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static org.assertj.core.api.Assertions.assertThat;
import static starter.matchers.TextMatcher.textOf;



public class SearchStepDefinitions {

    @Steps
    SearchResult searchResult;

    String actor;
    @Before
    public void setTheStage() {
        OnStage.setTheStage(new OnlineCast());
    }

    @Given("^(.*) is on the Adidas home page")
    public void on_the_Adidas_login_page(String actor){
        this.actor=actor;
        theActorCalled(actor).attemptsTo(NavigateTo.theAdidasHomePage());
    }

    @When("^s?He searches for (.*)")
    public void he_search_for(String term){
        theActorCalled(actor).attemptsTo(
               SearchFor.searchFor(term)
        );
    }

    @Then("^s?He should see items related to \"(.*)\"")
    public void he_should_see_items_related(String expectedTerm){
        assertThat(searchResult.titles()).allMatch(title ->textOf(title).containsIgnoringCase(expectedTerm));
    }
}
