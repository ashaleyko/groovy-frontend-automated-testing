package pages

import com.codeborne.selenide.SelenideElement
import pages.elements.Product

import static com.codeborne.selenide.Selenide.$
import static com.codeborne.selenide.Selenide.$x

class CheckoutPage {

    private final SelenideElement proceedToCheckoutButtonAtShoppingCartSummary = $x('//span[text()="Proceed to checkout"]')
    private final SelenideElement proceedToCheckoutButtonAtAddress = $('[name="processAddress"]')
    private final SelenideElement proceedToCheckoutButtonAtShipping = $('[name="processCarrier"]')
    private final SelenideElement agreeToTermsCheckbox = $('[type="checkbox"]')
    private final SelenideElement payByBankWireButton = $('.bankwire')
    private final SelenideElement confirmOrderButton = $x('//span[text()="I confirm my order"]')
    private final SelenideElement paymentDetails = $('.box')
    private final SelenideElement backToOrdersButton = $('[title="Back to orders"]')

    Product product

    CheckoutPage() {
        this.product = new Product()
    }

    void clickProceedToCheckoutAtShoppingCartSummary() {
        proceedToCheckoutButtonAtShoppingCartSummary.click()
    }

    void clickProceedToCheckoutAtAddress() {
        proceedToCheckoutButtonAtAddress.click()
    }

    void clickProceedToCheckoutAtShipping() {
        proceedToCheckoutButtonAtShipping.click()
    }

    void selectAgreeToTermsCheckbox() {
        agreeToTermsCheckbox.click()
    }

    void clickPayByBankWireButton() {
        payByBankWireButton.click()
    }

    void clickConfirmOrderButton() {
        confirmOrderButton.click()
    }

    OrderHistoryPage clickBackToOrdersButton() {
        backToOrdersButton.click()
        return new OrderHistoryPage()
    }

    Boolean paymentDetailsAreDisplayed() {
        paymentDetails.isDisplayed()
    }
}
