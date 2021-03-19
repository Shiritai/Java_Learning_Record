public class Sort {
    public static void main(String[] args) {
        int [] number = {70, 80, 31, 37, 10, 1, 48, 60, 33, 80};
        for (int i = number.length - 1; i >= 1; --i){
            for (int j = 0; j < i; ++j){
                if (number[j] > number[j + 1]){
                    int tmp = number[j];
                    number[j] = number[j + 1];
                    number[j + 1] = tmp;
                }
            }
        }
        for (var i : number){
            System.out.printf("%d ", i);
        }
    }
}
