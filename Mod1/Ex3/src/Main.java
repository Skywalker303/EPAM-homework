import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int x = 0;
        double F = 0.0;
        int a = 0;
        int b = 0;
        int h;

        Scanner sc = new Scanner(System.in);

        System.out.println("Введите длины отрезка [a,b]:");
        a = sc.nextInt();
        b = sc.nextInt();
        System.out.println("Введите шаг h:");
        h = sc.nextInt();
        System.out.println("x" + "|" + "F(x)");
        x = a;
        while (x <= b) {
            F = ((Math.tan(2 * x) - 3));
            System.out.println(x + "|" + F);
            x = x + h;
        }
    }
}
