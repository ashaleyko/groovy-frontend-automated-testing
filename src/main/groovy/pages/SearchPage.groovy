package pages

import com.codeborne.selenide.ElementsCollection

import static com.codeborne.selenide.CollectionCondition.size
import static com.codeborne.selenide.Selenide.$$

class SearchPage {

    private final ElementsCollection searchResult = $$('.product-container')

    Boolean searchResultIsEqualTo(Integer expectedFoundItemsAmount) {
        searchResult.shouldHave(size(expectedFoundItemsAmount))
    }
}
