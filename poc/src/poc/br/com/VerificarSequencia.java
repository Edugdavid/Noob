package poc.br.com;

import java.util.Scanner;

public class VerificarSequencia {
	public static void main(String[] args) {
		int quantidade;
		float[] vetor = new float[8];
		Scanner ler = new Scanner(System.in);
		System.out.println("Digite o numero de elementos do vetor: ");
		quantidade = ler.nextInt();
		System.out.print("Digite uma sequencia de " + quantidade + " numeros reais: ");
		for (int i = 0; i < quantidade; i++) {
			vetor[i] = ler.nextFloat();
		}

		verificarElementosRepetidos(vetor, quantidade);
	}

	public static void verificarElementosRepetidos(float[] vetor, int quantidade) {
		int vezes, j;
		for (int i = 0; i < quantidade; i++) {
			vezes = 1;
			j = i + 1;
			while (j < quantidade) {
				if (vetor[j] != vetor[i]) {
					j++;
				} else {
					vezes++;
					quantidade--;
					vetor[j] = vetor[quantidade];
				}
			}
			System.out.printf("%f ocorre %d vezes\n " , vetor[i] , vezes);
		}
	}
}
