package starter.search;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Clear;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.questions.WebElementQuestion;
import net.serenitybdd.screenplay.waits.Wait;
import org.openqa.selenium.Keys;


import static net.serenitybdd.screenplay.Tasks.instrumented;

public class SearchFor implements Task{

    private final String term;

    public SearchFor(String term) {
        this.term = term;
    }


    public static Performable searchFor(String term){
        return instrumented(SearchFor.class,term);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Wait.until(
                        WebElementQuestion.the(SearchForm.SEARCH_FIELD) , WebElementStateMatchers.isEnabled()
                ).forNoLongerThan(30).seconds(),
                Enter.theValue(term).into(SearchForm.SEARCH_FIELD).thenHit(Keys.ENTER)
        );

    }
}
