package com.despegar.screenplay.userinterface.searchflight;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;

import static com.despegar.screenplay.utils.GeneralUtils.getNDaysAferTodayDateAsStr;

@DefaultUrl("https://www.despegar.com.co/vuelos/")
public class SearchFlightPage extends PageObject{

    //To close unwanted elements
    public static final Target NO_SIGN_IN_BUTTON = Target
            .the("no sign in - button")
            .located(By.xpath("//i[@class='tooltip-close dreck-3-icon-close incentive-close']"));

    //To fill data
    public static final Target ONE_WAY_RADIOBUTTON = Target.the("one way - radiobutton")
            .located(By.xpath("//span[contains(text(),'Solo ida')]"));

    public static final Target ORIGIN_FIELD = Target.the("origin - textbox")
            .located(By.xpath("//input[@class='input-tag sbox-main-focus " +
                    "sbox-bind-reference-flight-roundtrip-origin-input " +
                    "sbox-primary sbox-places-first places-inline']"));
    public static final Target ORIGIN_DETAILED_FIELD = Target.the("origin detailed - text")
            .located(By.xpath("//span[contains(text(),'Medell\u00EDn, Antioquia, Colombia')]"));
    public static final Target DESTINATION_FIELD = Target.the("destination - textbox")
            .located(By.xpath("//input[@class='input-tag sbox-main-focus " +
                    "sbox-bind-reference-flight-roundtrip-destination-input " +
                    "sbox-secondary sbox-places-second places-inline']"));
    public static final Target DESTINATION_DETAILED_FIELD = Target.the("destination detailed - text")
            .located(By.xpath("//em[contains(text(),'Santa')]"));

    public static final Target DATE_FIELD = Target.the("date field")
            .located(By.xpath("(//i[@class='input-icon sbox-ui-icon sbox-3-icon-calendar'])[1]"));
    public static final Target TOMORROW_DATE_BUTTON = Target.the("tomorrow date - button")
            .located(By.xpath("//div[@data-month='" + getNDaysAferTodayDateAsStr(1)[0]
                    + "']//span[contains(text(),'" + getNDaysAferTodayDateAsStr(1)[1] + "')]"));
    public static final Target SEARCH_BUTTON = Target.the("search - button")
            .located(By.xpath("//em[contains(text(),'Buscar')]"));

}
