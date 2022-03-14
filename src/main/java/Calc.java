import java.util.Scanner;

public class Calc {

    public static void calculator() {

        double num1 = getDouble();
        double num2 = getDouble();
        char operation = getOperation();

        double result = calc(num1,num2,operation);

        System.out.printf("Результат вычислений с округлением до .4: %.4f", result);
    }

    /**
     * Ввод дробного числа из консоли.
     * @return double num -- нецелое число
     */
    public static double getDouble() {
        Scanner inputNum = new Scanner(System.in);

        System.out.println("Введи нецелое число; разделитель ',':");
        double num = 0;
        if(inputNum.hasNextDouble()){
            try {
                num = inputNum.nextDouble();
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println("Принято");
        } else {
            System.out.println("Нет такой операции. Попробуй еще раз.");
            inputNum.next();            //рекурсия
            num = getDouble();
        }
        return num;
    }

    /**
     * Ввод символа операции из консоли.
     * @return char operation -- символ операции
     */
    public static char getOperation(){
        Scanner inputOp = new Scanner(System.in);

        System.out.println("Чо делать с ними?");
        System.out.println( "Варианты:\n" +
                "  Тык +, чтобы добавить второе к первому;\n" +
                "  Тык -, чтобы второе из первого;\n" +
                "  Тык *, чтобы умножить первое на второе;\n" +
                "  Тык /, чтобы поделить первое на второе;\n" +
                "  Тык ~, если передумал");

        char operation = 'N';
        if(inputOp.hasNext()){
            try {
                operation = inputOp.next().charAt(0);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Нет такой операции. Попробуй еще раз.");
            inputOp.next();         //рекурсия
            operation = getOperation();
        }
        return operation;
    }

    /**
     * Свитч операций по введенному из консоли символу
     * @param num1 первое число
     * @param num2 второе число
     * @param operation операция
     * @return double result результат
     */
    public static double calc(double num1, double num2, char operation){
        double result;
        switch (operation){
            case '+':
                result = num1+num2;
                break;
            case '-':
                result = num1-num2;
                break;
            case '*':
                result = num1*num2;
                break;
            case '/':
                result = num1/num2;
                break;
            case  '~':
                result = 0;
                System.out.println("Отмена");
                break;
            default:
                System.out.println("Операция не распознана.");
                result = calc(num1, num2, getOperation());//рекурсия
        }
        return result;
    }
}
