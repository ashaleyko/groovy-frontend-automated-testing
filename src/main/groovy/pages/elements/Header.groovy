package pages.elements

import com.codeborne.selenide.SelenideElement
import pages.LoginPage
import pages.SearchPage

import static com.codeborne.selenide.Selenide.$

class Header {

    private final SelenideElement signInButton = $('.login')
    private final SelenideElement signOutButton = $('.logout')
    private final SelenideElement userAccountElement = $('.account')
    private final SelenideElement searchQueryInput = $('[name="search_query"]')
    private final SelenideElement searchButton = $('[name="submit_search"]')

    void logoutUser() {
        signOutButton.click()
    }

    LoginPage clickSignInButton() {
        signInButton.click()
        return new LoginPage()
    }

    SearchPage submitQueryAndClickSearch(String searchQuery) {
        searchQueryInput.setValue(searchQuery)
        searchButton.click()
        return new SearchPage()
    }

    Boolean isSignInButtonVisible() {
        signInButton.isDisplayed()
    }

    Boolean isSignOutButtonVisible() {
        signOutButton.isDisplayed()
    }

    Boolean isUserInfoVisible() {
        userAccountElement.isDisplayed()
    }

    Boolean isUserInfoNotVisible() {
        !userAccountElement.isDisplayed()
    }
}
