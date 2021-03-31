package com.despegar.screenplay.userinterface.searchaccommodation;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class AccommodationSelectionPage extends PageObject {

    //Cambiar a .locatedBy
    public static final Target FIRST_DETAILS_BUTTON = Target
            .the("view details - button")
            .located(By.xpath("(//em[contains(text(),'Ver detalle')])[1]"));

}
