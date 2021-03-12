/* final class, final method, override */

/* a "final" class means that this class CAN'T be inherit! */
public final class Magician extends Person{
   
    private int magicPower;
    private int speedOfMagicRecover;
    
    public Magician(){}
    
    public Magician(int magicPower, int blood, String name){
        super(blood, name);
        this.magicPower = magicPower;
    }
    
    /* *
     * use "Override" to make sure that the compiler check 
     * if you successfully override a parent method
     * */
    @Override
    public void setSkills(String [] skills, int skillNum){
        for (int i = 0; i < skillNum; ++i){
            this.skills[i] = skills[i]; // shallow copy
        }
        this.skillNum = skillNum;
    }

    @Override
    public String dataString(){
        return super.dataString() + String.format(", whose magic power is %d", this.magicPower);
    }

    public int getMagicPower(){
        return magicPower;
    }

    /* a "final" method means that this method CAN'T be Override */
    public final void setMagicPower(int magicPower){
        this.magicPower = magicPower;
    }

}
