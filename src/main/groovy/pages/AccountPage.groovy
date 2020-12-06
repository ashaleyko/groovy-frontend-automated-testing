package pages

import com.codeborne.selenide.SelenideElement
import pages.elements.Header

import static com.codeborne.selenide.Selenide.$

class AccountPage {

    private final SelenideElement myAccountLinksElement = $('.myaccount-link-list')
//    private final SelenideElement homeButton = $('[title="Home"]')
    private final SelenideElement homeButton = $('[href="http://automationpractice.com/"]')

    Header header

    AccountPage() {
        this.header = new Header()
    }

    MainPage clickHomeButton() {
        homeButton.click()
        return new MainPage()
    }

    Boolean isMyAccountElementVisible() {
        myAccountLinksElement.isDisplayed()
    }
}
