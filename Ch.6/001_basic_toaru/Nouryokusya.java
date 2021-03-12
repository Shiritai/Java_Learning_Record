public class Nouryokusya extends Person {
    private int level; // 能力者等級
    private int rank; // only for top 10
    private String type;
    
    public Nouryokusya(){}
    
    public Nouryokusya(int level, int blood, String name){
        super(blood, name);
        this.level = level;
    }

    public Nouryokusya(int level, int rank, int blood, String name, String occupation, String motto, String type, String organ){
        super(blood, name, occupation, motto, organ);
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

    public String attackMethod(int skillCode){
        return skills[skillCode];
    }

    public int getLevel(){
        return level;
    }

    public int getRank(){
        return rank;
    }

    public String getType(){
        return type;
    }

}
