/* override */

public class Nouryokusya extends Person {
    private int level; // 能力者等級
    private String type;
    
    public Nouryokusya(){}
    
    public Nouryokusya(int level, int blood, String name){
        super(blood, name);
        this.level = level;
    }

    public Nouryokusya(int level, int rank, int blood, String name, String type){
        super(blood, name);
        this.level = level;
        this.rank = rank;
        this.type = type;
    }

    @Override
    public void setSkills(String [] skills, int skillNum){
        for (int i = 0; i < skillNum; ++i){
            this.skills[i] = skills[i];
        }
        this.skillNum = skillNum;
    }

    /* You can't override a method with weaker privilege */
    // @Override
    // protected String dataString(){
    //     return super.dataString() + String.format(", whose level is %d", this.level);
    // }
    @Override
    public String dataString(){
        return super.dataString() + String.format(", whose level is %d", this.level);
    }

    public String attackMethod(int skillCode){
        return skills[skillCode];
    }

    public void setLevel(int level){
        this.level = level;
    }

    public int getLevel(){
        return level;
    }

    public String getType(){
        return type;
    }

}
