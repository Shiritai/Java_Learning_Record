public class QuickUnionFind1 implements UnionFind {
    private int [] parent;
    private int [] rank; // i.e. rank

    public QuickUnionFind1(int size){
        parent = new int[size];
        rank = new int[size];
        for (int i = 0; i < size; ++i){
            parent[i] = i;
            rank[i] = 1;
        }
    }

    @Override
    public int getSize(){
        return parent.length;
    }
    
    private int find(int index){
        assert index >= 0 && index < parent.length : "Index out of range!";
        while (index != parent[index]){
            parent[index] = parent[parent[index]];
            index = parent[index];
        }
        return index;
    }
    
    @Override 
    public boolean isConnected(int e1, int e2) {
        assert e1 >= 0 && e1 < parent.length && e2 >= 0 && e2 < parent.length : "Index out of range!";
        return find(e1) == find(e2);
    }
    
    @Override 
    public void union(int e1, int e2){
        assert e1 >= 0 && e1 < parent.length && e2 >= 0 && e2 < parent.length : "Index out of range!";
        int parent1 = find(e1);
        int parent2 = find(e2);
        if (parent1 != parent2){
            if (rank[parent1] > rank[parent2]){
                parent[parent2] = parent1;
            }
            else if (rank[parent1] < rank[parent2]){
                parent[parent1] = parent2;
            }
            else {
                parent[parent1] = parent2;
                rank[parent1] += 1;
            }
        }
    }
}
