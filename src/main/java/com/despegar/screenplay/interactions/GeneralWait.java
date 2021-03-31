package com.despegar.screenplay.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.actions.DriverTask;
import net.thucydides.core.webdriver.SerenityWebdriverManager;
import org.openqa.selenium.support.ui.WebDriverWait;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class GeneralWait implements Interaction {

    private int secondsToWait;

    public GeneralWait(int secondsToWait){
        this.secondsToWait = secondsToWait;
    }

    public static GeneralWait seconds(int secondsToWait){
        return instrumented(GeneralWait.class, secondsToWait);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                waitSomeSeconds(secondsToWait)
        );
    }

    private Performable waitSomeSeconds(int secondsToWait) {
        return new DriverTask(driver -> {
            try {
                Thread.sleep(secondsToWait*1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

    }
}
