package simplejavaapps.Lottery;

public class LotteryEntry {

    private String timestamp;
    private String userName;
    private String userMail;
    private String topic;
    private String introductor;
    private int chance = 1;

    public LotteryEntry(String timestamp, String userName, String userMail, String topic, String introductor)
    {
        this.timestamp = timestamp;
        this.userName = userName;
        this.userMail = userMail;
        this.topic = topic;
        this.introductor = introductor;

    }

    public int getChance() {
        return chance;
    }

    public void setChance(int chance) {
        this.chance = chance;
    }

    public String getIntroductor() {
        return introductor;
    }

    public String getUserName() {
        return userName;
    }
}
