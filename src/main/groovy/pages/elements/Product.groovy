package pages.elements

import com.codeborne.selenide.Condition
import com.codeborne.selenide.ElementsCollection
import com.codeborne.selenide.SelenideElement

import static com.codeborne.selenide.CollectionCondition.size
import static com.codeborne.selenide.Selenide.$
import static com.codeborne.selenide.Selenide.$$
import static com.codeborne.selenide.Selenide.$x

class Product {

    private final ElementsCollection featuredProducts = $$('.product-container')
    private final ElementsCollection cartItems = $$('.cart_item')
    private final ElementsCollection deleteProductButtons = $$('.cart_quantity_delete')
    private final SelenideElement firstFeaturedProductAddToCartButton = $('[data-id-product="1"]')
    private final SelenideElement secondFeaturedProductAddToCartButton = $('[data-id-product="2"]')
    private final SelenideElement emptyShoppingCartBanner = $x('//*[text()="Your shopping cart is empty."]')

    ShoppingCartPopUp addFirstFeaturedProductToCart() {
        featuredProducts.first().hover()
        firstFeaturedProductAddToCartButton.click()
        return new ShoppingCartPopUp()
    }

    ShoppingCartPopUp addSecondFeaturedProductToCart() {
        featuredProducts.get(1).hover()
        secondFeaturedProductAddToCartButton.click()
        return new ShoppingCartPopUp()
    }

    Boolean isFirstProductDisplayedInShoppingCart() {
        cartItems.first().isDisplayed()
    }

    Boolean isTwoProductsDisplayedInShoppingCart() {
        cartItems.shouldHave(size(2))
    }

    Boolean isShoppingCartEmpty() {
        emptyShoppingCartBanner.shouldBe(Condition.visible)
    }

    void removeTwoProductsFromShoppingCart() {
        deleteProductButtons.first(2).each { it.click() }
    }
}
