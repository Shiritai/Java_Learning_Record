public interface UnionFind {
    int getSize();
    boolean isConnected(int e1, int e2);
    void union(int e1, int e2);
}
