package specs

import pages.CheckoutPage
import pages.MainPage
import pages.elements.ShoppingCartPopUp

class ShoppingCartSpec extends BaseSpec {

    def 'anonymous user should add two products to shopping cart and remove them'() {
        given: 'main page opens'
            MainPage mainPage = new MainPage().openMainPage()

        when: 'user adds first featured product to shopping cart'
            ShoppingCartPopUp shoppingCartPopUp = mainPage.product.addFirstFeaturedProductToCart()

        and: 'clicks continue shopping button at shopping cart pop up'
            shoppingCartPopUp.clickContinueShopping()

        and: 'user adds second featured product to shopping cart'
            mainPage.product.addSecondFeaturedProductToCart()

        and: 'clicks proceed to checkout button at shopping cart pop up'
            CheckoutPage checkoutPage = shoppingCartPopUp.clickProceedToCheckout()

        then: 'two products are displayed at shopping cart'
            checkoutPage.product.isTwoProductsDisplayedInShoppingCart()

        when: 'user removes two products from shopping cart'
            checkoutPage.product.removeTwoProductsFromShoppingCart()

        then: 'shopping cart is empty'
            checkoutPage.product.isShoppingCartEmpty()
    }
}
