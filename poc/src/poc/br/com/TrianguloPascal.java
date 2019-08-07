package poc.br.com;

import java.util.Scanner;

public class TrianguloPascal {

	public static void main(String[] args) {
		int quantidade;
		Scanner ler = new Scanner(System.in);
		System.out.println("Quantidade de linhas: ");
		quantidade = ler.nextInt();

		calcularTrianguloPascal(quantidade);
		System.out.println();
		calcularTriangulo(quantidade);
	}
	
	public static void calcularTriangulo(int quantidade) {
		for(int i = 0; i < quantidade; i++) {
            int valor = 1; 
            System.out.format("","%"  + (quantidade - i) * 2 + "s");
            for(int j = 0; j <= i; j++) {
                System.out.format("%3d", valor);
                valor = valor * (i - j) / (j + 1);
            }
            System.out.println();
        }
	}

	public static void calcularTrianguloPascal(int quantidade) {
		int[] vetor = new int[quantidade * quantidade];
		vetor[0] = 1;
		for (int i = 0; i < quantidade; i++) {
			int x = 0, y;
			for (int j = 0; j <= i; j++) {
				y = x + vetor[j];
				x = vetor[j];
				vetor[j] = y;
				System.out.printf("%3d", vetor[j]);
			}
			System.out.println();
		}

	}
}
