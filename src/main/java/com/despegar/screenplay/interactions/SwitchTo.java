package com.despegar.screenplay.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.actions.DriverTask;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.webdriver.SerenityWebdriverManager;

public class SwitchTo implements Performable {

    @Step("{0} switch to new tab")
    public static Performable newFrame() {

        //Debería utilizar el performAs y el frameId de la nueva tab

        String newFrameHandle = (String) SerenityWebdriverManager.inThisTestThread()
                .getCurrentDriver().getWindowHandles().stream().toArray()[1];
        return new DriverTask(driver -> driver.switchTo().window(newFrameHandle) );
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

    }

}
