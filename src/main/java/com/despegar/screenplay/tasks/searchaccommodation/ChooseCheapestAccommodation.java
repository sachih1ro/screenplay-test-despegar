package com.despegar.screenplay.tasks.searchaccommodation;

import com.despegar.screenplay.exceptions.CanNotReserveFoundError;
import com.despegar.screenplay.exceptions.NoAccommodationFoundError;
import com.despegar.screenplay.interactions.SwitchTo;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.JavaScriptClick;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Step;

import static com.despegar.screenplay.exceptions.CanNotReserveFoundError.MESSAGE_CAN_NOT_RESERVE_FOUND;
import static com.despegar.screenplay.exceptions.NoAccommodationFoundError.MESSAGE_NO_ACCOMMODATION_FOUND;
import static com.despegar.screenplay.userinterface.PaymentGatewayPage.WAY_TO_PAY_TITLE;
import static com.despegar.screenplay.userinterface.searchaccommodation.AccommodationSelectionPage.FIRST_DETAILS_BUTTON;
import static com.despegar.screenplay.userinterface.searchaccommodation.RoomPage.RESERVE_BUTTON;
import static net.serenitybdd.screenplay.EventualConsequence.eventually;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static net.serenitybdd.screenplay.questions.WebElementQuestion.the;

public class ChooseCheapestAccommodation implements Task {

    public static ChooseCheapestAccommodation now() {
        return instrumented(ChooseCheapestAccommodation.class);
    }

    @Override
    @Step("{0} try to choose accommodation")
    public <T extends Actor> void performAs(T actor) {

        actor.should(eventually(seeThat(the(FIRST_DETAILS_BUTTON), isVisible()))
                .waitingForNoLongerThan(15).seconds()
                .orComplainWith(NoAccommodationFoundError.class,MESSAGE_NO_ACCOMMODATION_FOUND));

        actor.attemptsTo(
                Scroll.to(FIRST_DETAILS_BUTTON),
                Click.on(FIRST_DETAILS_BUTTON)
        );

        actor.attemptsTo(
                SwitchTo.newFramePage()
        );

        actor.should(eventually(seeThat(the(RESERVE_BUTTON), isVisible()))
                .waitingForNoLongerThan(15).seconds()
                .orComplainWith(CanNotReserveFoundError.class,MESSAGE_CAN_NOT_RESERVE_FOUND));

        actor.attemptsTo(
                Scroll.to(RESERVE_BUTTON),
                JavaScriptClick.on(RESERVE_BUTTON) //Corregir para poder usar click normal
        );

        WaitUntil.the(WAY_TO_PAY_TITLE, isVisible())
                .forNoMoreThan(30).seconds();
    }

}
