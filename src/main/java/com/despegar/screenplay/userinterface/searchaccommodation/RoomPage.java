package com.despegar.screenplay.userinterface.searchaccommodation;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class RoomPage extends PageObject {
    public static final Target RESERVE_BUTTON = Target.the("reserve - button")
            .located(By.xpath("//em[contains(text(),'Reservar ahora')]"));
}
