package pages

import com.codeborne.selenide.SelenideElement

import static com.codeborne.selenide.Selenide.$

class OrderHistoryPage {

    private final SelenideElement firstOrder = $('.first_item')

    Boolean isFirstOrderDisplayed() {
        firstOrder.isDisplayed()
    }
}
