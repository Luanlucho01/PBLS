package PBL01;

import java.util.Random;
import java.util.Scanner;

class PBL01 {
    public static void main(String[] args){
        int n = retornaNumeroUsuario();
        int[] vetor = geraVetorAleatorio(n);

        // verfiiar se vetor[i] é par, impar ou multiplo de 3
        for (int i = 0; i < n; i++) {
            int valor = vetor[1];

            if(valor % 2 == 0) {
                System.out.println(valor + "- é par");
            } else if (valor % 3 == 0){
                System.out.println(valor + "- é multiplo de 3");
            } else{
                System.out.println(valor + "- é impar");
            }
        }
    }

    public static int retornaNumeroUsuario(){
        System.out.println("Digite um número: ");
        Scanner s = new Scanner(System.in);
        return s.nextInt();
    }

    public static int[] geraVetorAleatorio(int n) {
        int[] vetor = new int[n]; /* criando um vetor com (n) número de bits */
        Random r = new Random();

        for (int i = 0; i < n; i++) {
            vetor[i] = r.nextInt(0,100);
        }
        return vetor;
    }

}
