package app;

import java.util.Scanner;


public class Main {
    private final Data data = new Data();

    public static void main(String[] args) throws InvalidDataException {
        Scanner scanner = new Scanner(System.in);
        String in = "12+45*(2-45)#";//scanner.nextLine();
        Data data = new Data();
        LexAnalyzer analyzer = new LexAnalyzer(data);
        analyzer.analyze(in);
        System.out.println(data);
    }

}
