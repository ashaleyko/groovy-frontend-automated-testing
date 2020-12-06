package pages

import pages.elements.Header
import pages.elements.Product

import static com.codeborne.selenide.Selenide.open
import static config.Config.envConfig

class MainPage {

    Header header
    Product product

    MainPage() {
        this.header = new Header()
        this.product = new Product()
    }

    MainPage openMainPage() {
        open(new URL(envConfig.baseURL()), MainPage)
    }
}
