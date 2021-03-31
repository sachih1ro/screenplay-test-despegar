package com.despegar.screenplay.stepdefinitions;

import com.despegar.screenplay.exceptions.CanNotLoadPaymentGateway;
import com.despegar.screenplay.questions.ThePaymentGatewayPage;
import com.despegar.screenplay.tasks.searchfligth.ChooseCheapestTicket;
import com.despegar.screenplay.tasks.searchfligth.SearchFlight;
import com.despegar.screenplay.userinterface.searchflight.SearchFlightPage;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

import static com.despegar.screenplay.exceptions.CanNotLoadPaymentGateway.MESSAGE_CAN_NOT_LOAD_PAYMENT_GATEWAY;
import static com.despegar.screenplay.model.FlightBuilder.origin;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class BookFlightStepDefinitions {

    @Before
    public void prepareStage(){
        OnStage.setTheStage(new OnlineCast());
    }

    @Given("^(.*) wants to search a ticket from (.*) to (.*)")
    public void anaSearchAvailableTickets(String actorName, String origin, String destination) {
        theActorCalled(actorName).attemptsTo(SearchFlight
                .with(origin(origin).andDestination(destination)));
    }

    @When("^Ana chooses the cheapest ticket$")
    public void anaChoosesTheCheapestTicket() {
        theActorInTheSpotlight()
                .attemptsTo(ChooseCheapestTicket.now());
    }

    @Then("^Ana should watch the ticket payment gateway$")
    public void anaShouldWatchThePaymentGateway() {
        theActorInTheSpotlight().should(seeThat(ThePaymentGatewayPage.isVisible())
                .orComplainWith(CanNotLoadPaymentGateway.class,
                        MESSAGE_CAN_NOT_LOAD_PAYMENT_GATEWAY));
    }
}
