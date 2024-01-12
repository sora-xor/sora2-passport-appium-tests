package jp.co.soramitsu.sora.qa.configs;

import org.aeonbits.owner.ConfigFactory;

public class TestConfig {
    public static final TestConfigInterface config = ConfigFactory.create(TestConfigInterface.class);
}