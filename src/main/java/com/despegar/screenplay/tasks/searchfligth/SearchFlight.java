package com.despegar.screenplay.tasks.searchfligth;

import com.despegar.screenplay.interactions.GeneralWait;
import com.despegar.screenplay.model.Flight;
import com.despegar.screenplay.userinterface.searchflight.SearchFlightPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.*;
import net.serenitybdd.screenplay.conditions.Check;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.Wait;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.Keys;

import static com.despegar.screenplay.userinterface.searchflight.SearchFlightPage.*;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class SearchFlight implements Task {

    private Flight flight;
    private SearchFlightPage searchFlightPage;

    public SearchFlight(Flight flight){
        this.flight = flight;
    }

    public static SearchFlight with(Flight flight) {
        return instrumented(SearchFlight.class, flight);
    }

    @Override
    @Step("{0} try to search flights")
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(Open.browserOn(searchFlightPage));

        actor.attemptsTo(
                Check.whether(NO_SIGN_IN_BUTTON.resolveAllFor(actor).size() > 0)
                        .andIfSo(Click.on(NO_SIGN_IN_BUTTON))
        );

        actor.attemptsTo(
                Click.on(ONE_WAY_RADIOBUTTON),

                Enter.theValue(flight.getOriginStr()).into(ORIGIN_FIELD),
                WaitUntil.the(SELECTED_LOCATION_FIELD, WebElementStateMatchers.isClickable()),
                Click.on(SELECTED_LOCATION_FIELD),

                Enter.theValue(flight.getDestinationStr()).into(DESTINATION_FIELD),
                WaitUntil.the(SELECTED_LOCATION_FIELD, WebElementStateMatchers.isClickable()),
                Click.on(SELECTED_LOCATION_FIELD),

                WaitUntil.the(DATE_FIELD, WebElementStateMatchers.isClickable()),
                Click.on(DATE_FIELD),

                WaitUntil.the(TOMORROW_DATE_BUTTON, WebElementStateMatchers.isClickable()),
                Scroll.to(TOMORROW_DATE_BUTTON),
                Click.on(TOMORROW_DATE_BUTTON),

                Scroll.to(SEARCH_BUTTON),
                Click.on(SEARCH_BUTTON)
        );

    }
}
