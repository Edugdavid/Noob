package poc.br.com;

import java.util.Scanner;

public class MediaAritmetica {
	public static void main(String[] args) {
		float nota1, nota2, nota3;
		Scanner ler = new Scanner(System.in);

		System.out.println("Digite a nota para calcular a media: ");
		nota1 = ler.nextFloat();
		System.out.println("Digite a nota para calcular a media: ");
		nota2 = ler.nextFloat();
		System.out.println("Digite a nota para calcular a media: ");
		nota3 = ler.nextFloat();
		
		System.out.println("A media artimetica é " + calcularMediaAritmetica(nota1, nota2, nota3));

	}

	public static float calcularMediaAritmetica(float nota1, float nota2, float nota3) {
		float media;
		media = (nota1 + nota2 + nota3) / 3;

		return media;
	}
}
