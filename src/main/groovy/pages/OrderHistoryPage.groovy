package pages

import com.codeborne.selenide.SelenideElement
import pages.elements.Header

import static com.codeborne.selenide.Selenide.$

class OrderHistoryPage {

    private final SelenideElement firstOrder = $('.first_item')

    Header header

    OrderHistoryPage() {
        this.header = new Header()
    }

    Boolean isFirstOrderDisplayed() {
        firstOrder.isDisplayed()
    }
}
