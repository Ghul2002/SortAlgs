import java.util.Random;

public class ArrayCreator {
    public int[] create(int size) {
        int[] array = new int[size];
        Random ran = new Random();
        for (int i = 0; i < size; i++) {
            array[i] = i + 1;
        }
        for (int i = 0; i < size; i++) {
            int ranIndex = ran.nextInt(size);
            int temp = array[i];
            array[i] = array[ranIndex];
            array[ranIndex] = temp;
        }
        return array;
    }
}
