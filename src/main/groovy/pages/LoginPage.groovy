package pages

import com.codeborne.selenide.SelenideElement
import com.github.javafaker.Faker
import pages.elements.Header

import static com.codeborne.selenide.Selenide.$
import static com.codeborne.selenide.Selenide.open
import static config.Config.getEnvConfig

class LoginPage {

    private static final Faker FAKER = new Faker()

    private final SelenideElement emailAddressInput = $('#email')
    private final SelenideElement newAccountEmailAddressInput = $('#email_create')
    private final SelenideElement passwordInput = $('#passwd')
    private final SelenideElement signInButton = $('#SubmitLogin')
    private final SelenideElement createAccountButton = $('#SubmitCreate')

    Header header

    LoginPage() {
        this.header = new Header()
    }

    LoginPage openLoginPage() {
        open(new URL(envConfig.baseURL() + '/index.php?controller=authentication'), LoginPage)
    }

    AccountPage submitCredentialsAndClickSignInButton(String userEmail = envConfig.defaultUsernameEmail(),
                           String userPassword = envConfig.defaultUsernamePassword()) {
        emailAddressInput.setValue(userEmail)
        passwordInput.setValue(userPassword)
        signInButton.click()
        return new AccountPage()
    }

    SignUpPage submitEmailAndClickCreate(String userEmail = FAKER.internet().emailAddress()) {
        newAccountEmailAddressInput.setValue(userEmail)
        createAccountButton.click()
        return new SignUpPage()
    }
}
