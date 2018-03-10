public class Main {

    public static void main(String[] args) {

        int increment = Integer.parseInt(args[args.length - 1]);
        double numerator = 0;
        int denominator = 0;
        for(int i = args.length - 2; i >= 0;  i -=increment) {
            System.out.println(args[i]);
            numerator += Double.parseDouble(args[i]);
            denominator++;
        }

        System.out.println(numerator / denominator);
    }
}
