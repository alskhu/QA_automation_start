package org.example;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.element;

public class SimpleUITest {
    @Test
    public void userCanNotCreateAccountWithNameAndSurnameOnly() {
        //Подготовка
        Selenide.open("https://parabank.parasoft.com/parabank/register.htm");


        //Шаги теста
        SelenideElement firstName = element(Selectors.byId("customer.firstName"));
        firstName.sendKeys("Jack");

        SelenideElement lastName = element(Selectors.byId("customer.lastName"));
        lastName.sendKeys("Maxinov");

        SelenideElement registerButton = element(Selectors.byValue("Register"));
        registerButton.click();

        //Проверка ожидаемого результата
        SelenideElement addressError = element(Selectors.byId("customer.address.street.errors"));
        addressError.shouldHave(Condition.exactText("Address is required."));
    }
}
