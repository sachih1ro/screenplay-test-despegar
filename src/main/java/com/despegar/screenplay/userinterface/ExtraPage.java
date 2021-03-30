package com.despegar.screenplay.userinterface;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

public class ExtraPage extends PageObject {
    public WebElementFacade generalWait(int seconds){
        return waitFor(seconds).seconds().find("");
    }
}
