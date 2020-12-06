package specs

import com.anotherchrisberry.spock.extensions.retry.RetryOnFailure
import com.codeborne.selenide.Configuration
import spock.lang.Specification

@RetryOnFailure(times = 1, delaySeconds = 5)
abstract class BaseSpec extends Specification {

    static {
        Configuration.timeout = 10000
        Configuration.headless = true
    }
}
