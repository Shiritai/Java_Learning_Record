/* Unknown Error */
public class Kyara {

    private String name;
    private int rank;

    public Kyara(String name, int rank){
        this.name = name;
        this.rank = rank;
    }

    @Override
    public String toString(){
        return String.format("(%s, %d)", name, rank);
    }

    public static void main(String[] args){
        var kyaraList = new Array<Kyara>();
        kyaraList.addLast(new Kyara("Eroiko", 3));
        kyaraList.addLast(new Kyara("Senjyougahara", 1));
        kyaraList.addLast(new Kyara("Hanekawa", 2));
        System.out.println(kyaraList);
    }
}
