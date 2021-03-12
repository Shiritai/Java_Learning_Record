public class Person {
    /* "protected" 修飾 : 其子類別可以直接訪問 */
    protected final String name;
    protected String nickName;
    protected String occupation; // 職業
    protected String motto;
    protected int blood;
    protected String organization;

    protected String[] skills;
    protected int skillNum;
    
    public Person(){
        this.name = "Anonymous";
    }
    
    public Person(int blood, String name){
        this(blood, name, "", "", "");
    }
    
    public Person(int blood, String name, String occupation, String motto, String organ){
        this.blood = blood;
        this.name = name;
        this.occupation = occupation;
        this.motto = motto;
        this.organization = organ;
    }
    
    /* Prepare for Override (i.e. re-define) */
    public void setSkills(String [] skills, int skillNum){
        // please override this method
    }
    
    /* below are the setting functions */
    public void setNickName(String nickName){
        this.nickName = nickName;
    }

    public void setMotto(String motto){
        this.motto = motto;
    }
    
    /* below are the access functions */
    public String getOrgan(){
        return organization;
    }
    
    public int getBlood(){
        return blood;
    }

    public String getName(){
        return name;
    }
    
    public String getNickName(){
        return nickName;
    }

    public String getJob(){
        return occupation;
    }

    public String getMotto(){
        return motto;
    }
}
