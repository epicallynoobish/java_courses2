import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        char operation = 0;
        Scanner input = new Scanner(System.in);

        System.out.println("Выбери операцию");
        System.out.println("Варианты:\n" +
                "  Тык (1), чтобы запустить калькулятор;\n" +
                "  Тык (2), чтобы запустить работу с массивами;\n" +
                "  Тык (3), чтобы выйти.\n");

        //char operation = 'N';
        if (input.hasNext()) {
            try {
                operation = input.next().charAt(0);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Нет такой операции. Попробуй еще раз.");
            input.next();         //рекурсия
        }

        switch (operation) {
            case '1':
                System.out.println("Выбран калькулятор");
                System.out.println("-----------");
                Calc.calculator();
                break;
            case '2':
                System.out.println("Выбрана работа с массивами");
                System.out.println("-----------");
                ArrayCheck.check();
                break;
            case '3':
                System.out.println("Выход");
                break;
            default:
                System.out.println("Нет такой операции!");
        }
    }
}
