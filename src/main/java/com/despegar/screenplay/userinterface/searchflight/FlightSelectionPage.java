package com.despegar.screenplay.userinterface.searchflight;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class FlightSelectionPage extends PageObject {

    public static final Target FIRST_SELECT_BUTTON = Target.the("select - button")
            .located(By.xpath("(//em[contains(text(),'Seleccionar')])[1]"));

}
