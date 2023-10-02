import java.util.Arrays;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

public class Calculator {
    public static void main(String[] args){
        final String inputExp = ReadInput.read();

        Queue<String> operations;
        Queue<String> numbers;

        String[] numbersArr = inputExp.split("[-+*/%]");
//        String[] operArr = inputExp.split("[0-9]+");
        String[] operArr = inputExp.split("\\d+");
        numbers = new LinkedList<>(Arrays.asList(numbersArr));
        operations = new LinkedList<>(Arrays.asList(operArr));

        Double res = Double.parseDouble(Objects.requireNonNull(numbers.poll()));

        while(!numbers.isEmpty()){
            String opr = operations.poll();

            Operate operate;
            switch(Objects.requireNonNull(opr)){
                case "+":
                    operate = new Add();
                    break;
                case "-":
                    operate = new Sub();
                    break;
                case "*":
                    operate = new Multiply();
                    break;
                case "/":
                    operate = new Divide();
                    break;
                case "%":
                    operate = new Modulus();
                    break;
                default:
                    continue;
            }
            Double num = Double.parseDouble(Objects.requireNonNull(numbers.poll()));
            res = operate.getResult(res, num);
        }

        System.out.println(res);
    }
}