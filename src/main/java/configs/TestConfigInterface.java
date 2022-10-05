package configs;

import org.aeonbits.owner.Config;

@org.aeonbits.owner.Config.LoadPolicy(org.aeonbits.owner.Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "system:env",
        "classpath:test.properties"})
public interface TestConfigInterface extends Config{

    @Key("mnemonic")
    String mnemonic ();
}