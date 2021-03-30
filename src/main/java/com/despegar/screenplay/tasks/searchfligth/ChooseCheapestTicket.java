package com.despegar.screenplay.tasks.searchfligth;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Step;

import static com.despegar.screenplay.userinterface.PaymentGatewayPage.WAY_TO_PAY_TITLE;
import static com.despegar.screenplay.userinterface.searchflight.FlightSelectionPage.FIRST_SELECT_BUTTON;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class ChooseCheapestTicket implements Task {

    public static ChooseCheapestTicket now() {
        return instrumented(ChooseCheapestTicket.class);
    }

    @Override
    @Step("{0} try to choose flight")
    public <T extends Actor> void performAs(T actor) {

        WaitUntil.the(FIRST_SELECT_BUTTON, WebElementStateMatchers.isVisible())
                .forNoMoreThan(20).seconds();

        /*
        actor.should(seeThat(the(FIRST_SELECT_BUTTON), isVisible())
                .orComplainWith(NoFlightsFoundError.class,
                        MESSAGE_NO_FLIGHT_FOUND));
         */

        actor.attemptsTo(
                Scroll.to(FIRST_SELECT_BUTTON),
                Click.on(FIRST_SELECT_BUTTON)
        );

        //Esperar carga de la siguiente página
        WaitUntil.the(WAY_TO_PAY_TITLE, WebElementStateMatchers.isVisible())
                .forNoMoreThan(20).seconds();


    }
}
