public class Role {
    private String name;
    private String fightingMethod;
    private int level;
    private int blood;

    public void setName(String name){
        this.name = name;
    }

    public void setFightMethod(String fightMethod){
        this.fightingMethod = fightMethod;
    }

    public void setLevelString(int level){
        this.level = level;
    }

    public void setBlood(int blood){
        this.blood = blood;
    }

    public String getName(){
        return name;
    }

    public String getFightMethod(){
        return fightingMethod;
    }

    public int getLevel(){
        return level;
    }

    public int getBlood(){
        return blood;
    }
}