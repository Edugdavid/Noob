package poc.br.com;

import java.util.Random;

public class QuadradoMagico {
	public static void main(String args[]) {
		double tentativa = 0;
		int dimensao = 4;
		int min = 1;
		int max = 16;
		int somatorio = 34;
		int[][] matriz = new int[dimensao][dimensao];
		while (!verificarQuadradoMagico(matriz, somatorio)) {
			if (tentativa % 1000000 == 0) {
				System.out.println("Tentativa: " + tentativa);
			}
			matriz = new int[dimensao][dimensao];
			matriz = gerarMatriz(matriz, min, max);
			tentativa++;
		}
		System.out.println("Achei uma matriz quadrado magico!");
		imprimirMatriz(matriz);
	}

	public static int[][] gerarMatriz(int[][] matriz, int min, int max) {
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
				int numeroAleatorio = gerarNumeroAleatorio(min, max);
				while (verificarExistente(numeroAleatorio, matriz)) {
					numeroAleatorio = gerarNumeroAleatorio(min, max);
				}
				matriz[i][j] = numeroAleatorio;
			}
		}

		return matriz;
	}

	public static int gerarNumeroAleatorio(int min, int max) {
		return new Random().nextInt((max - min) + 1) + min;
	}

	private static boolean verificarExistente(int numero, int[][] matriz) {
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
				if (matriz[i][j] == numero) {
					return true;
				}
			}
		}
		return false;
	}

	public static boolean verificarQuadradoMagico(int[][] matriz, int somatorio) {
		if (verificarLinhasQuadradoMagico(matriz, somatorio) && verificarColunasQuadradoMagico(matriz, somatorio)
				&& verificarDiagonalPrincipal(matriz, somatorio) && verificarDiagonalSecundaria(matriz, somatorio)) {
			return true;
		} else {
			return false;
		}
	}

	public static boolean verificarLinhasQuadradoMagico(int[][] matriz, int somatorio) {
		int soma = 0;
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz.length; j++) {
				soma += matriz[i][j];
			}
			if (soma != somatorio) {
				return false;
			}
			soma = 0;
		}
		return true;
	}

	public static boolean verificarColunasQuadradoMagico(int[][] matriz, int somatorio) {
		int soma = 0;
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz.length; j++) {
				soma += matriz[j][i];
			}
			if (soma != somatorio) {
				return false;
			}
			soma = 0;
		}
		return true;
	}

	public static boolean verificarDiagonalPrincipal(int[][] matriz, int somatorio) {
		int soma = 0;
		for (int i = 0; i < matriz.length; i++) {
			soma += matriz[i][i];
		}
		if (soma != somatorio) {
			return false;
		}
		return true;
	}

	public static boolean verificarDiagonalSecundaria(int[][] matriz, int somatorio) {
		int soma = 0;
		for (int i = matriz.length - 1; i >= 0; i--) {
			soma += matriz[i][matriz.length - 1 - i];
		}
		if (soma != somatorio) {
			return false;
		}
		return true;
	}

	public static void imprimirMatriz(int[][] matriz) {
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz.length; j++) {
				System.out.print(matriz[i][j] + ", ");
			}
			System.out.println();
		}
	}
}
