package com.despegar.screenplay.userinterface.searchflight;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class FlightSelectionPage extends PageObject {

    // Lista de precios no usada por ahora
    //public static final Target PRICES_LIST = Target.the("ticket price list")
    //        .located(By.xpath("//span[@class='flight-price-label']//span[@class='amount price-amount']"));

    //El primer precio, por defecto, es el más económico
    public static final Target FIRST_SELECT_BUTTON = Target.the("select - button")
            .located(By.xpath("(//em[contains(text(),'Seleccionar')])[1]"));



}
