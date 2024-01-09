package jp.co.soramitsu.sora.configs;

import org.aeonbits.owner.Config;

@org.aeonbits.owner.Config.LoadPolicy(org.aeonbits.owner.Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "system:env",
        "classpath:envs/${STAGE}/test.properties"})
public interface TestConfigInterface extends Config{
    @Key("user1.mnemonic")
    String mnemonic1 ();
    @Key("user1.rawseed")
    String rawseed ();
    @Key("user2.mnemonic")
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
    @Key("user1.referrerLink")
    String referrerLink1();
    @Key("user2.referrerLink")
    String referrerLink2();
    @Key("user2.assetId")
    String assetId();
}