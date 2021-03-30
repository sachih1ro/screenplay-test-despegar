package com.despegar.screenplay.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static com.despegar.screenplay.userinterface.PaymentGatewayPage.WAY_TO_PAY_TITLE;

public class ThePaymentGatewayPage implements Question<Boolean> {

    public static Question<Boolean> isVisible() {
        return new ThePaymentGatewayPage();
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        return WAY_TO_PAY_TITLE.resolveFor(actor).isVisible();
    }

    @Override
    public String getSubject() {
        return "the payment gateway page is visible";
    }
}
