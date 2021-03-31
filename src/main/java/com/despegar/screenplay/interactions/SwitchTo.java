package com.despegar.screenplay.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.actions.DriverTask;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.webdriver.SerenityWebdriverManager;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class SwitchTo implements Interaction {

    public static SwitchTo newFramePage(){
        return instrumented(SwitchTo.class);
    }

    @Override
    @Step("{0} switch to new tab")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                newFrame()
        );

    }
    private Performable newFrame() {
        String newFrameHandle = (String) SerenityWebdriverManager.inThisTestThread()
                .getCurrentDriver().getWindowHandles().stream().toArray()[1];
        return new DriverTask(driver -> driver.switchTo().window(newFrameHandle) );
    }


}
