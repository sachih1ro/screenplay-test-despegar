package com.despegar.screenplay.runners;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = {"src/test/resources/features/booking_accommodation.feature"},
        glue = {"com.despegar.screenplay.stepdefinitions"},
        snippets = SnippetType.CAMELCASE)
public class BookHotel {
}
