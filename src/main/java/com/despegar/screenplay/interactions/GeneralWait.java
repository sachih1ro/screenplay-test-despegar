package com.despegar.screenplay.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.thucydides.core.webdriver.SerenityWebdriverManager;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GeneralWait implements Performable {

    //Timer general
    WebDriverWait waiter = new WebDriverWait(SerenityWebdriverManager
            .inThisTestThread().getCurrentDriver(), 5);

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                //waiter;
        );
    }
}
