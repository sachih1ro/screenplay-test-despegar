package com.despegar.screenplay.userinterface;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class PaymentGatewayPage extends PageObject {
    public static final Target WAY_TO_PAY_TITLE = Target
            .the("Seat selection - map container")
            .located(By.xpath("//span[@class='eva-3-h4 form-title']"));
}
