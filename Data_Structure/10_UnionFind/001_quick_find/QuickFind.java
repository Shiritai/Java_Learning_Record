public class QuickFind implements UnionFind {
    private int [] id;

    public QuickFind(int size){
        id = new int[size];
        for (int i = 0; i < size; ++i) id[i] = i;
    }

    @Override
    public int getSize(){
        return id.length;
    }
    
    private int find(int index){ return id[index]; }

    @Override 
    public boolean isConnected(int e1, int e2) {
        return find(e1) == find(e2);
    }

    @Override 
    public void union(int e1, int e2){
        int ID1 = find(e1);
        int ID2 = find(e2);
        if (ID1 != ID2){
            for (int i = 0; i < id.length; ++i){
                if (id[i] == ID1){
                    id[i] = ID2;
                }
            }
        }
    }
}
