package pages

import com.codeborne.selenide.SelenideElement
import pages.elements.Header

import static com.codeborne.selenide.Selenide.$

class OrderHistoryPage {

    private final SelenideElement firstOrder = $('.first_item')

    Header header

    Boolean isFirstOrderDisplayed() {
        firstOrder.isDisplayed()
    }
}
