public class Divide implements Operate {
    @Override
    public Double getResult(Double... numbers){
        Double div = numbers[0];

        for(int i=1;i< numbers.length;i++){
            div /= numbers[i];
        }
        return div;
    }
}
