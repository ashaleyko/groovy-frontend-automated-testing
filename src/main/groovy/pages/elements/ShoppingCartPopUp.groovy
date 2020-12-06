package pages.elements

import com.codeborne.selenide.SelenideElement
import pages.CheckoutPage

import static com.codeborne.selenide.Selenide.$

class ShoppingCartPopUp {

    private final SelenideElement proceedToCheckoutButton = $('[title="Proceed to checkout"]')
    private final SelenideElement continueShoppingButton = $('[title="Continue shopping"]')

    CheckoutPage clickProceedToCheckout() {
        proceedToCheckoutButton.click()
        return new CheckoutPage()
    }

    void clickContinueShopping() {
        continueShoppingButton.click()
    }
}
