package poc.br.com;

import java.util.Scanner;

public class AreaTriangulo {
	public static void main(String[] args) {
		float base, altura;
		Scanner ler = new Scanner(System.in);
		System.out.println("Digite a base do triangulo");
		base = ler.nextFloat();
		System.out.println("Digite a altura do triangulo");
		altura = ler.nextFloat();
		
		System.out.println("A area do triangulo é:  " + calcularAreaTriangulo(base, altura));
	}

	public static float calcularAreaTriangulo(float base, float altura) {
		float area;

		area = base * altura / 2;
		return area;
	}
}
