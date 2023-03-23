package infrastructure;

public class Random {

    public String RandomValue() {
        java.util.Random rand = new java.util.Random();
        int randomNum = rand.nextInt(10) + 1;
        String randomValue;
        return randomValue = String.valueOf(randomNum);/*+"@maildrop.cc";*/
    }
}
