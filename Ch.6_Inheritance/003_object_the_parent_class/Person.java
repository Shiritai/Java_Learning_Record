/* just for convenience */

public class Person {

    protected final String name;
    protected String nickName = null;
    protected int blood;

    protected String[] skills;
    protected int skillNum;

    public Person() {
        this.name = "Anonymous";
    }

    public Person(int blood, String name) {
        this.blood = blood;
        this.name = name;
    }

    public String dataString(){
        if (this.name.equals("Anonymous")){
            return "___A unknown person___\n...OwO";
        }
        if (this.nickName != null){
            return String.format("___%s___\nblood : %d, nickname : %s", this.name, this.blood, this.nickName);
        }
        return String.format("___%s___\nblood : %d, with no nickname", this.name, this.blood);
    }

    /* below are the setting functions */
    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public int getBlood() {
        return blood;
    }

    public String getName() {
        return name;
    }

    public String getNickName() {
        return nickName;
    }
}
