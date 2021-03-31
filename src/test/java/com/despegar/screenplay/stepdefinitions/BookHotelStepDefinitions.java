package com.despegar.screenplay.stepdefinitions;

import com.despegar.screenplay.exceptions.CanNotLoadPaymentGateway;
import com.despegar.screenplay.questions.ThePaymentGatewayPage;
import com.despegar.screenplay.tasks.searchaccommodation.ChooseCheapestAccommodation;
import com.despegar.screenplay.tasks.searchaccommodation.SearchAccommodation;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

import static com.despegar.screenplay.exceptions.CanNotLoadPaymentGateway.MESSAGE_CAN_NOT_LOAD_PAYMENT_GATEWAY;
import static com.despegar.screenplay.model.AccommodationBuilder.location;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class BookHotelStepDefinitions {

    @Before
    public void prepareStage(){
        OnStage.setTheStage(new OnlineCast());
    }

    @Given("^(.*) wants to search accommodation in (.*)$")
    public void anaWantsToSearchAccommodation(String actorName, String location) {
        theActorCalled(actorName).attemptsTo(SearchAccommodation.in(location(location)));
    }

    @When("^Ana chooses the cheapest accommodation$")
    public void anaChoosesTheCheapestAccommodation() {
        theActorInTheSpotlight().attemptsTo(ChooseCheapestAccommodation.now());
    }

    @Then("^Ana should watch the accommodation payment gateway$")
    public void anaShouldWatchTheAccommodationPaymentGateway() {
        theActorInTheSpotlight().should(seeThat(ThePaymentGatewayPage.isVisible())
                .orComplainWith(CanNotLoadPaymentGateway.class,
                        MESSAGE_CAN_NOT_LOAD_PAYMENT_GATEWAY));
    }
}
