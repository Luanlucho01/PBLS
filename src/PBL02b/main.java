package PBL02b;

import java.util.Scanner;

class ProgressaoAritmetica {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o valor do primeiro termo da PA: ");
        double a1 = scanner.nextDouble();

        System.out.print("Digite a razão da PA: ");
        double r = scanner.nextDouble();

        System.out.print("Digite o número de termos da PA: ");
        int n = scanner.nextInt();
        double an = a1 + (n - 1) * r;

        System.out.printf("Último termo da PA: %.2f%n", an);

        double sn = (a1 + an) * n / 2;
        System.out.printf("Soma de todos os termos da PA: %.2f%n", sn);

        scanner.close();
    }
}

