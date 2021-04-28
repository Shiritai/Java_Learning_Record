public class QuickestUnion implements UnionFind {
    private int [] parent;
    private int [] depth; // i.e. rank

    public QuickestUnion(int size){
        parent = new int[size];
        depth = new int[size];
        for (int i = 0; i < size; ++i){
            parent[i] = i;
            depth[i] = 1;
        }
    }

    @Override
    public int getSize(){
        return parent.length;
    }
    
    private int find(int index){
        assert index >= 0 && index < parent.length : "Index out of range!";
        while (index != parent[index]){
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
            if (depth[parent1] > depth[parent2]){
                parent[parent2] = parent1;
            }
            else if (depth[parent1] < depth[parent2]){
                parent[parent1] = parent2;
            }
            else {
                parent[parent1] = parent2;
                depth[parent1] += 1;
            }
        }
    }
}
