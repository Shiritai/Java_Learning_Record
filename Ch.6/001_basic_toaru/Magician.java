public class Magician extends Person{
   
    private int magicPower;
    private int speedOfMagicRecover;
    
    public Magician(){}
    
    public Magician(int magicPower, int blood, String name){
        super(blood, name);
        this.magicPower = magicPower;
    }
    
    @Override
    public void setSkills(String [] skills, int skillNum){
        for (int i = 0; i < skillNum; ++i){
            this.skills[i] = skills[i]; // shallow copy
        }
        this.skillNum = skillNum;
    }

    public int getMagicPower(){
        return magicPower;
    }

}
