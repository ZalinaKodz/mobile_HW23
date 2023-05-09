package config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "system:properties"
})
public interface HostConfig extends Config {
    @Key("Host")
    @DefaultValue("emulation")
    Host host();

}
