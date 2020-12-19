package specs

import pages.AccountPage
import pages.LoginPage
import pages.MainPage
import pages.CheckoutPage
import pages.OrderHistoryPage
import pages.SignUpPage
import pages.elements.ShoppingCartPopUp

class CheckoutSpec extends BaseSpec {

    def 'checkout should succeed for new user'() {
        given: 'login page opens'
            LoginPage loginPage = new LoginPage().openLoginPage()

        and: 'user submits email address and clicks create account button'
            SignUpPage signUpPage = loginPage.submitEmailAndClickCreate()

        and: 'user submits valid user data and clicks register button'
            AccountPage accountPage = signUpPage.submitValidAccountDataAndClickRegister()

        and: 'user navigates to main page by clicking home button'
            MainPage mainPage = accountPage.clickHomeButton()

        when: 'user adds first featured product to shopping cart'
            ShoppingCartPopUp shoppingCartPopUp = mainPage.product.addFirstFeaturedProductToCart()

        and: 'clicks proceed to checkout button at shopping cart pop up'
            CheckoutPage checkoutPage = shoppingCartPopUp.clickProceedToCheckout()

        then: 'product is displayed at shopping cart'
            checkoutPage.product.isFirstProductDisplayedInShoppingCart()

        when: 'user clicks proceed to checkout button at shopping cart summary stage'
            checkoutPage.clickProceedToCheckoutAtShoppingCartSummary()

        and: 'user clicks proceed to checkout button at address stage'
            checkoutPage.clickProceedToCheckoutAtAddress()

        and: 'user agrees to terms and clicks proceed to checkout button at shipping stage'
            checkoutPage.selectAgreeToTermsCheckbox()
            checkoutPage.clickProceedToCheckoutAtShipping()

        and: 'user selects pay by wire option'
            checkoutPage.clickPayByBankWireButton()

        and: 'user confirms order'
            checkoutPage.clickConfirmOrderButton()

        then: 'payment details are displayed'
            checkoutPage.paymentDetailsAreDisplayed()

        when: 'user clicks back to orders button'
            OrderHistoryPage orderHistoryPage = checkoutPage.clickBackToOrdersButton()

        then: 'first order is displayed'
            orderHistoryPage.isFirstOrderDisplayed()

        cleanup: 'user logs out'
            orderHistoryPage.header.logoutUser()
    }
}
