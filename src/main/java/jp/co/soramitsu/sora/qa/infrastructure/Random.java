package jp.co.soramitsu.sora.qa.infrastructure;

public class Random {

    public String RandomValue() {
        java.util.Random rand = new java.util.Random();
        int randomNum = rand.nextInt(10) + 1;
        return String.valueOf(randomNum);
    }
}
