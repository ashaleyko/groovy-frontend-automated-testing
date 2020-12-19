package specs

import pages.AccountPage
import pages.LoginPage
import pages.MainPage
import pages.SignUpPage

class SignUpSpec extends BaseSpec {

    def 'user should sign up with valid data'() {
        given: 'main page opens'
            MainPage mainPage = new MainPage().clearCookiesAndOpenMainPage()

        when: 'user clicks sign in button'
            LoginPage loginPage = mainPage.header.clickSignInButton()

        and: 'submits email address and clicks create account button'
            SignUpPage signUpPage = loginPage.submitEmailAndClickCreate()

        and: 'submits valid user data and clicks register button'
            AccountPage accountPage = signUpPage.submitValidAccountDataAndClickRegister()

        then: 'user account page displays'
            accountPage.isMyAccountElementVisible()

        and: 'user info element is visible'
            accountPage.header.isUserInfoVisible()

        cleanup: 'user logs out'
            accountPage.header.logoutUser()
    }
}
