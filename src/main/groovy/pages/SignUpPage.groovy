package pages

import com.codeborne.selenide.SelenideElement
import com.github.javafaker.Faker

import static com.codeborne.selenide.Selenide.$

class SignUpPage {

    private static final Faker FAKER = new Faker()

    private final SelenideElement firstNameInput = $('[name="customer_firstname"]')
    private final SelenideElement lastNameInput = $('[name="customer_lastname"]')
    private final SelenideElement passwordInput = $('[name="passwd"]')
    private final SelenideElement addressLineOneInput = $('[name="address1"]')
    private final SelenideElement cityInput = $('[name="city"]')
    private final SelenideElement stateDropDownList = $('[name="id_state"]')
    private final SelenideElement zipPostalCodeInput = $('[name="postcode"]')
    private final SelenideElement mobilePhoneInput = $('[name="phone_mobile"]')
    private final SelenideElement registerButton = $('[name="submitAccount"]')

    AccountPage submitValidAccountDataAndClickRegister() {
        firstNameInput.setValue(FAKER.name().firstName())
        lastNameInput.setValue(FAKER.name().lastName())
        passwordInput.setValue(FAKER.internet().password())
        addressLineOneInput.setValue(FAKER.address().streetAddress())
        cityInput.setValue(FAKER.address().city())
        stateDropDownList.selectOption(1)
        zipPostalCodeInput.setValue(FAKER.number().digits(5))
        mobilePhoneInput.setValue(FAKER.phoneNumber().cellPhone())
        registerButton.click()
        return new AccountPage()
    }
}
