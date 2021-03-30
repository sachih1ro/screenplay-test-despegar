package com.despegar.screenplay.userinterface.searchaccommodation;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class AccommodationSelectionPage extends PageObject {
    // Lista de precios no usada por ahora
    //public static final Target PRICES_LIST = Target.the("ticket price list")
    //        .located(By.xpath("//span[@class='main-value']"));

    //El primer precio, por defecto, es el más económico
    public static final Target FIRST_DETAILS_BUTTON = Target.the("view details - button")
            .located(By.xpath("(//em[contains(text(),'Ver detalle')])[1]"));

}
