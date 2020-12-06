package specs

import pages.AccountPage
import pages.LoginPage
import pages.MainPage

class LoginLogoutSpec extends BaseSpec {

    def 'user should log in with valid credentials and log out'() {
        given: 'main page opens'
            MainPage mainPage = new MainPage().openMainPage()

        when: 'user clicks sign in button'
            LoginPage loginPage = mainPage.header.clickSignInButton()

        and: 'submits email address and clicks sign in button'
            AccountPage accountPage = loginPage.submitCredentialsAndClickSignInButton()

        then: 'sign out button is visible'
            accountPage.header.isSignOutButtonVisible()

        and: 'user info element is visible'
            accountPage.header.isUserInfoVisible()

        when: 'user logs out'
            accountPage.header.logoutUser()

        then: 'sign in button is visible'
            loginPage.header.isSignInButtonVisible()

        and: 'user info element is not visible'
            loginPage.header.isUserInfoNotVisible()
    }
}
