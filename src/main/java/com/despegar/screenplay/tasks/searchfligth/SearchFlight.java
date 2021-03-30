package com.despegar.screenplay.tasks.searchfligth;

import com.despegar.screenplay.model.Flight;
import com.despegar.screenplay.userinterface.searchflight.SearchFlightPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.*;
import net.serenitybdd.screenplay.conditions.Check;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Step;

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

        //open search flight webpage
        actor.attemptsTo(Open.browserOn(searchFlightPage));

        //close unwanted elements
        actor.attemptsTo(
                Check.whether(NO_SIGN_IN_BUTTON.resolveAllFor(actor).size() > 0)
                        .andIfSo(Click.on(NO_SIGN_IN_BUTTON))
        );

        // fill data and search tickets
        actor.attemptsTo(
                Click.on(ONE_WAY_RADIOBUTTON),

                Enter.theValue(flight.getOriginStr()).into(ORIGIN_FIELD),
                WaitUntil.the(ORIGIN_DETAILED_FIELD, WebElementStateMatchers.isClickable()),
                Click.on(ORIGIN_DETAILED_FIELD),

                Enter.theValue(flight.getDestinationStr()).into(DESTINATION_FIELD),
                WaitUntil.the(DESTINATION_DETAILED_FIELD, WebElementStateMatchers.isClickable()),
                Click.on(DESTINATION_DETAILED_FIELD),

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
