import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/*
 * Desafio de Programa��o - Academia Capgemini
 * Autor: �lyson Batista Siqueira Campos
 * Quest�o 01: Escreva um algoritmo que mostre na tela uma escada de tamanho n utilizando o caractere *
 * e espa�os. A base e altura da escada devem ser iguais ao valor de n. A �ltima linha n�o
 * deve conter nenhum espa�o.
 */
public class Challenge01 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);//instanciando e criando um objeto Scanner
		
		List<String> degraus = new ArrayList<>();//instanciando uma lista
		
		int numDegraus;//declarando vari�vel do tipo inteiro onde ser� armazenado o n�mero de degraus

		System.out.print("Informe o n�mero de degraus para a escada: ");
		numDegraus = sc.nextInt();//entrada de dados (lendo um valor inteiro)
		
		//loop for adicionando elementos na lista degraus de acordo com o n�mero de degraus inserido pelo usu�rio
		for (int i = 0; i < numDegraus; i++) {
			degraus.add(" ".repeat(numDegraus - i) + "*".repeat(i + 1));
		}
		
		//foreach percorrendo a lista e imprimindo a escada
		for (String d : degraus ) {
			System.out.println(d);
		}
		//fechando o scanner que foi aberto
		sc.close();
	}
}
