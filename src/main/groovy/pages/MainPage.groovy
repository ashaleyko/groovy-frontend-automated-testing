package pages

import com.codeborne.selenide.SelenideElement
import pages.elements.Header
import pages.elements.Product

import static com.codeborne.selenide.Selenide.$
import static com.codeborne.selenide.Selenide.clearBrowserCookies
import static com.codeborne.selenide.Selenide.open
import static config.Config.envConfig

class MainPage {

    private final SelenideElement popularGrid = $('#homefeatured')
    private final SelenideElement bestSellersGrid = $('#blockbestsellers')

    Header header
    Product product

    MainPage() {
        this.header = new Header()
        this.product = new Product()
    }

    MainPage clearCookiesAndOpenMainPage() {
        clearBrowserCookies()
        MainPage mainPage = open(new URL(envConfig.baseURL()), MainPage)
        assertMainPageOpened()
        return mainPage
    }

    void assertMainPageOpened() {
        assert popularGrid.exists()
        assert bestSellersGrid.exists()
    }
}
