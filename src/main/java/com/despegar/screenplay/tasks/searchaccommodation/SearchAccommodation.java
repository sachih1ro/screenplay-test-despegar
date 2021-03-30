package com.despegar.screenplay.tasks.searchaccommodation;

import com.despegar.screenplay.model.Accommodation;
import com.despegar.screenplay.userinterface.searchaccommodation.SearchAccommodationPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.*;
import net.serenitybdd.screenplay.conditions.Check;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Step;

import static com.despegar.screenplay.userinterface.searchaccommodation.SearchAccommodationPage.*;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class SearchAccommodation implements Task {
    private Accommodation accommodation;
    private SearchAccommodationPage searchAccommodationPage;

    public SearchAccommodation(Accommodation accommodation){
        this.accommodation = accommodation;
    }

    public static SearchAccommodation with(Accommodation accommodation) {
        return instrumented(SearchAccommodation.class, accommodation);
    }

    @Override
    @Step("{0} try to search accommodations")
    public <T extends Actor> void performAs(T actor) {
        //open search flight webpage
        actor.attemptsTo(Open.browserOn(searchAccommodationPage));

        //close unwanted elements
        actor.attemptsTo(
                Check.whether(NO_SIGN_IN_BUTTON.resolveAllFor(actor).size() > 0)
                        .andIfSo(Click.on(NO_SIGN_IN_BUTTON))
        );

        // fill data and search tickets
        actor.attemptsTo(

                Click.on(LOCATION_FIELD),
                Enter.theValue(accommodation.getDestinationStr()).into(LOCATION_FIELD),
                WaitUntil.the(LOCATION_DETAILED_FIELD, WebElementStateMatchers.isClickable()),
                Click.on(LOCATION_DETAILED_FIELD),

                WaitUntil.the(DATE_FIELD, WebElementStateMatchers.isClickable()),
                Click.on(DATE_FIELD),

                Scroll.to(TOMORROW_DATE_BUTTON),
                WaitUntil.the(TOMORROW_DATE_BUTTON, WebElementStateMatchers.isClickable()),
                Scroll.to(TOMORROW_DATE_BUTTON),
                Click.on(TOMORROW_DATE_BUTTON),
                Click.on(TWO_DAYS_AFTER_TODAY_BUTTON),

                Scroll.to(SEARCH_BUTTON),
                Click.on(SEARCH_BUTTON)
        );


    }
}
