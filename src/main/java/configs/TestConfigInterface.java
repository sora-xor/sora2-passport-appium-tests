package configs;

import org.aeonbits.owner.Config;

@org.aeonbits.owner.Config.LoadPolicy(org.aeonbits.owner.Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "system:env",
        "classpath:test.properties"})
public interface TestConfigInterface extends Config{

    @Key("mnemonic1")
    String mnemonic1 ();

    @Key("rawseed")
    String rawseed ();
    @Key("mnemonic2")
    String mnemonic2 ();
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

    @Key("referrerLink1")
    String referrerLink1();

    @Key("referrerLink2")
    String referrerLink2();

    @Key("assetId")
    String assetId();

    @Key("countryCode")
    String countryCode();
}