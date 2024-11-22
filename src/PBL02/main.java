package PBL02;

import java.util.Scanner;

class IntegralAproximada {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        System.out.print("Digite o valor de a: ");
        double a = teclado.nextDouble();

        System.out.print("Digite o valor de b: ");
        double b = teclado.nextDouble();

        if (a <= b) {
            System.out.print("Digite o valor de n: ");
            int n = teclado.nextInt();

            if (n > 0) {
                double areaTotal = 0.0;
                double x = a;
                double h = (b - a) / n;
                double y1 = f(x);

                for (int i = 0; i < n; i++) {
                    x = x + h;
                    double y2 = f(x);
                    double areaTrapezio = ((y1 + y2) / 2) * h;
                    areaTotal += areaTrapezio;
                    y1 = y2;
                }

                System.out.printf("Área total aproximada: %.6f\n", areaTotal);
            } else {
                System.out.println("Erro: o valor de n deve ser maior que zero");
            }
        } else {
            System.out.println("Erro: valor de a deve ser menor ou igual ao valor de b");
        }

        teclado.close();
    }

    public static double f(double x) {
        return 2 * Math.sin(x) + Math.cos(x) / 3;
    }
}
