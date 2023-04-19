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

    @Key("rawseed")
    String rawseed ();
    @Key("email")
    String email ();
    @Key("phonePending")
    String phonePending();

    @Key("phoneApproved")
    String phoneApproved();

    @Key("phoneFailed")
    String phoneFailed();

    @Key("phoneRejected")
    String phoneRejected();

    @Key("testOtp")
    String testOtp();
}