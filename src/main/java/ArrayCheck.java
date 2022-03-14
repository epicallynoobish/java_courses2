import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ArrayCheck {

    public static void check(){
        int length = getArrayLength();
        List<String> list = getList(length);
        String longestWord = findLongest(list);
        System.out.println("Самый длинный элемент массива: "+longestWord+" и его длина равна "+longestWord.length());
    }

    //размерность задается в консоли
    public static int getArrayLength() {
        Scanner arrayLength = new Scanner(System.in);

        System.out.print("Введи длину массива: ");
        int length = 0;

        if (arrayLength.hasNextInt()) {
            try {
                length = arrayLength.nextInt();
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println("Принято");
        } else {
            System.out.println("Ты втираешь мне какую-то дичъ! Попробуй еще раз.");
            arrayLength.next();            //рекурсия
            length = getArrayLength();
        }
        return length;
    }

    //задаем массив слов
    public static List<String> getList(int length) {
        //водим слова
        List<String> list = new ArrayList<String>();
        Scanner stdin = new Scanner(System.in);

        //System.out.println("длина = "+length);

        for (int i=1;i<=(length);i++) {
            System.out.println("Введи слово №"+i);
            try {
                list.add(stdin.next());
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println("Принято");
            System.out.println("***");
        }

        stdin.close();

        //конвертируем в стринг для работы с массивом
        String[] arr = list.toArray(new String[0]);
        System.out.println("Array is " + Arrays.toString(arr));

        return list;
    }

    //ищем самое длинное слово
    public static String findLongest(List<String> list) {
        String longestWord = null;

        for (String item : list) {
            if (longestWord == null || item.length() > longestWord.length()) {
                longestWord = item;
            }
        }
        return longestWord;
    }
}
