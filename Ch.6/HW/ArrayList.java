import java.util.Arrays;

public class ArrayList {

    private Object[] data;
    private int size;

    ArrayList(int len){
        data = new Object[len];
    }

    ArrayList(){
        this(64);
    }

    public void pushItem(Object o){
        if (size == data.length){
            data = Arrays.copyOf(data, data.length * 2);
        }
        data[size++] = o;
    }

    public Object popItem(){
        if (size == 0)
            return null;
        if (size < data.length / 3 && data.length / 2 > 0){
            data = Arrays.copyOf(data, data.length / 2);
        }
        return data[size-- - 1];
    }

    public int getSize(){
        return size;
    }

    @Override
    public String toString(){
        String result = "";
        for (int i = 0; i < size; ++i){
            result += String.format("%s", data[i]);
        }
        return result;
    }

    public Object getItem(int Ind){
        return data[Ind];
    }

    @Override
    public boolean equals(Object Comp){
        if (size != ((ArrayList) Comp).getSize()){
            return false;
        }
        for (int i = 0; i < size; ++i){
            if (!data[i].equals(((ArrayList) Comp).getItem(i))){
                return false;
            }
        }
        return true;
    }
}