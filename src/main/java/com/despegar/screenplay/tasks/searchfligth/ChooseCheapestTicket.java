package com.despegar.screenplay.tasks.searchfligth;

import com.despegar.screenplay.exceptions.NoFlightFoundError;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Step;

import static com.despegar.screenplay.exceptions.NoFlightFoundError.MESSAGE_NO_FLIGHT_FOUND;
import static com.despegar.screenplay.userinterface.PaymentGatewayPage.WAY_TO_PAY_TITLE;
import static com.despegar.screenplay.userinterface.searchflight.FlightSelectionPage.FIRST_SELECT_BUTTON;
import static net.serenitybdd.screenplay.EventualConsequence.eventually;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static net.serenitybdd.screenplay.questions.WebElementQuestion.the;

public class ChooseCheapestTicket implements Task {

    public static ChooseCheapestTicket now() {
        return instrumented(ChooseCheapestTicket.class);
    }

    @Override
    @Step("{0} try to choose flight")
    public <T extends Actor> void performAs(T actor) {

        actor.should(eventually(seeThat(the(FIRST_SELECT_BUTTON),isVisible()))
                .waitingForNoLongerThan(15).seconds().orComplainWith(
                NoFlightFoundError.class, MESSAGE_NO_FLIGHT_FOUND));

        actor.attemptsTo(
                Scroll.to(FIRST_SELECT_BUTTON),
                Click.on(FIRST_SELECT_BUTTON)
        );

        WaitUntil.the(WAY_TO_PAY_TITLE, isVisible())
                .forNoMoreThan(30).seconds();

    }
}
