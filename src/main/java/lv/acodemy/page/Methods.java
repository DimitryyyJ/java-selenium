package lv.acodemy.page;

import java.util.Scanner;

public class Methods {
    public static void main(String[] args) {
        int a = celsius(90);
        System.out.println(a);

    }

    public static int celsius(int degrees) {
        Scanner scanner = new Scanner(System.in);
        int temperatureCelsius = scanner.nextInt();
        int faregeiti = (temperatureCelsius*9/5+32);
        return faregeiti;

    }
}
