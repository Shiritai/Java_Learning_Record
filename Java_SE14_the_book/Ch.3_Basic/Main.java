/* for practice */
public class Main {
    public static void main(String[] args) {
        /* practice 1 */
        int m = 1000, n = 495;
        while (n > 0){
            int tmp = n;
            n = m % n;
            m = tmp;
        }
        System.out.printf("%d\n", m);
        /* practice 2 */
        for (var i = 1; i < 10; ++i){
            for (var j = i + 1; j < 10; ++j){
                for (var k = j + 1; k < 10; ++k){
                    int eroiko = i * i * i + j * j * j + k * k * k;
                    if (eroiko >= 100 && eroiko < 1000)
                        System.out.printf("%6d%6d%6d\n", i, j, k);
                }
            }
        }
    }
}