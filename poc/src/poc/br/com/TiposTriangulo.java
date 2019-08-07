package poc.br.com;

import java.util.Scanner;

public class TiposTriangulo {
	public static void main(String args[]) {
		float lado1, lado2, lado3;

		Scanner ler = new Scanner(System.in);

		System.out.println("Digite o primeiro lado do triangulo: ");
		lado1 = ler.nextFloat();
		System.out.println("Digite o segundo lado do triangulo: ");
		lado2 = ler.nextFloat();
		System.out.println("Digite o terceiro lado do triangulo: ");
		lado3 = ler.nextFloat();

		verificarTipoTriangulo(lado1, lado2, lado3);
	}

	public static void verificarTipoTriangulo(float lado1, float lado2, float lado3) {
		if (trianguloIsoceles(lado1, lado2, lado3)) {
			System.out.println(" O triangulo é Isoceles :)");
		} else if (trianguloEscaleno(lado1, lado2, lado3)) {
			System.out.println(" O triangulo é Escaleno :)");
		} else if (trianguloEquilatero(lado1, lado2, lado3)) {
			System.out.println(" O triangulo é Equilatero");
		}
	}

	public static boolean trianguloIsoceles(float lado1, float lado2, float lado3) {
		if (lado1 == lado2 && lado1 != lado3 || lado1 == lado3 && lado1 != lado2 || lado2 == lado3 && lado2 != lado1) {
			return true;
		}
		return false;

	}

	public static boolean trianguloEscaleno(float lado1, float lado2, float lado3) {
		if (lado1 != lado2 && lado1 != lado3 && lado2 != lado3) {
			return true;
		}
		return false;

	}

	public static boolean trianguloEquilatero(float lado1, float lado2, float lado3) {
		if (lado1 == lado2 && lado1 == lado3 && lado2 == lado3) {
			return true;
		}
		return false;

	}
}
