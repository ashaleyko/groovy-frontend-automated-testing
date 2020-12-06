package config

import org.aeonbits.owner.Config
import org.aeonbits.owner.Config.Key
import org.aeonbits.owner.Config.Sources

@Sources('classpath:env.properties')
interface EnvConfig extends Config {

    @Key('base.url')
    String baseURL()

    @Key('default.username.email')
    String defaultUsernameEmail()

    @Key('default.username.password')
    String defaultUsernamePassword()
}
