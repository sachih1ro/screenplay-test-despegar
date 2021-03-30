package com.despegar.screenplay.tasks.searchaccommodation;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.webdriver.SerenityWebdriverManager;

import static com.despegar.screenplay.userinterface.PaymentGatewayPage.WAY_TO_PAY_TITLE;
import static com.despegar.screenplay.userinterface.searchaccommodation.AccommodationSelectionPage.FIRST_DETAILS_BUTTON;
import static com.despegar.screenplay.userinterface.searchaccommodation.RoomPage.RESERVE_BUTTON;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class ChooseCheapestAccommodation implements Task {

    public static ChooseCheapestAccommodation now() {
        return instrumented(ChooseCheapestAccommodation.class);
    }

    String strNewFrame;

    @Override
    @Step("{0} try to choose accommodation")
    public <T extends Actor> void performAs(T actor) {

        WaitUntil.the(FIRST_DETAILS_BUTTON, WebElementStateMatchers.isClickable())
                .forNoMoreThan(20).seconds();

        actor.attemptsTo(
                Scroll.to(FIRST_DETAILS_BUTTON),
                Click.on(FIRST_DETAILS_BUTTON)
        );

        //Cambio de pestaña
        strNewFrame = (String) SerenityWebdriverManager.inThisTestThread().getCurrentDriver().getWindowHandles().stream().toArray()[1];
        System.out.println(strNewFrame);
        System.out.println(SerenityWebdriverManager.inThisTestThread().getCurrentDriver().getWindowHandles().size());
        SerenityWebdriverManager.inThisTestThread().getCurrentDriver().switchTo().window(strNewFrame);

        WaitUntil.the(RESERVE_BUTTON, WebElementStateMatchers.isEnabled())
                .forNoMoreThan(10).seconds();

        actor.attemptsTo(
                Scroll.to(RESERVE_BUTTON),
                Click.on(RESERVE_BUTTON)
        );

        //Esperar carga de pasarela de pago
        WaitUntil.the(WAY_TO_PAY_TITLE, WebElementStateMatchers.isVisible())
                .forNoMoreThan(20).seconds();

    }
}
