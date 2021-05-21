import java.util.ArrayList;

public class AVLMap<K extends Comparable<K>, V> implements Map<K, V> {
    private AVLTree<K, V> tree;

    public AVLMap(){
        tree = new AVLTree<>();
    }

    @Override
    public boolean isEmpty(){ return tree.isEmpty();}

    @Override
    public int getSize(){ return tree.getSize();}

    @Override
    public void add(K key, V value){
        tree.add(key, value);
    }

    @Override
    public boolean exist(K key){ return tree.exist(key);}

    @Override
    public V get(K key){
        return tree.get(key);
    }
    
    @Override
    public void change(K key, V value){
        tree.change(key, value);
    }

    @Override
    public V remove(K key){
        return tree.remove(key);
    }

    /** 輔助判斷函數, 利用 inorder 特性判斷 */
    public boolean isBST(){
        return tree.isBST();
    }

    public boolean isBalanced(){
        return tree.isBalanced();
    }
}
