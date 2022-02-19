import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/*
 * Desafio de Programação - Academia Capgemini
 * Autor: Ályson Batista Siqueira Campos
 * Questão 01: Escreva um algoritmo que mostre na tela uma escada de tamanho n utilizando o caractere *
 * e espaços. A base e altura da escada devem ser iguais ao valor de n. A última linha não
 * deve conter nenhum espaço.
 */
public class Challenge01 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);//instanciando e criando um objeto Scanner
		
		List<String> degraus = new ArrayList<>();//instanciando uma lista
		
		int numDegraus;//declarando variável do tipo inteiro onde será armazenado o número de degraus

		System.out.print("Informe o número de degraus para a escada: ");
		numDegraus = sc.nextInt();//entrada de dados (lendo um valor inteiro)
		
		//loop for adicionando elementos na lista degraus de acordo com o número de degraus inserido pelo usuário
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
