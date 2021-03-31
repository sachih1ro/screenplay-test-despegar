package com.despegar.screenplay.userinterface.searchaccommodation;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;

import static com.despegar.screenplay.utils.DateUtils.getNDaysAferTodayDateAsStr;

@DefaultUrl("https://www.despegar.com.co/hoteles/")
public class SearchAccommodationPage extends PageObject {

    //To close unwanted elements
    public static final Target NO_SIGN_IN_BUTTON = Target
            .the("no sign in - button")
            .located(By.xpath("//i[@class='tooltip-close dreck-3-icon-close incentive-close']"));

    public static final Target LOCATION_FIELD = Target.the("Location - textbox")
            .located(By.xpath("//input[@placeholder='Ingres\u00E1 una ciudad, " +
                    "alojamiento o atracci\u00F3n']"));
    public static final Target LOCATION_DETAILED_FIELD = Target.the("destination detailed - text")
            .located(By.xpath("//em[contains(text(),'Santa')]"));

    //Cambiar a locatedBy
    public static final Target DATE_FIELD = Target.the("date field")
            .located(By.xpath("//input[@placeholder='Entrada']"));
    public static final Target TOMORROW_DATE_BUTTON = Target.the("tomorrow date - button")
            .located(By.xpath("//div[@data-month='" + getNDaysAferTodayDateAsStr(1)[0]
                    + "']//div[text()='" + getNDaysAferTodayDateAsStr(1)[1] + "']"));
    public static final Target TWO_DAYS_AFTER_TODAY_BUTTON = Target.the("two days after tomorrow date - button")
            .located(By.xpath("//div[@data-month='" + getNDaysAferTodayDateAsStr(2)[0]
                    + "']//div[text()='" + getNDaysAferTodayDateAsStr(2)[1] + "']"));
    public static final Target SEARCH_BUTTON = Target.the("search - button")
            .located(By.xpath("//em[contains(text(),'Buscar')]"));


}
