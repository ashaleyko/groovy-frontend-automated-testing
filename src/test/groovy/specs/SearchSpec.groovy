package specs

import pages.MainPage
import pages.SearchPage
import spock.lang.Unroll

@Unroll
class SearchSpec extends BaseSpec {

    def 'anonymous user should search using valid product category: #productCategory'() {
        given: 'main page opens'
            MainPage mainPage = new MainPage().openMainPage()

        when: 'user submits search query for #productCategory and clicks search button'
            SearchPage searchPage = mainPage.header.submitQueryAndClickSearch(productCategory)

        then: 'search page displays #expectedFoundItemsAmount items'
            searchPage.searchResultIsEqualTo(expectedFoundItemsAmount)

        where:
            productCategory   || expectedFoundItemsAmount
            'blouses'         || 1
            'casual dresses'  || 4
            'printed dresses' || 5
    }
}
