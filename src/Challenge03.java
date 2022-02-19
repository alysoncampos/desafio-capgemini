import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
/* 
 * Desafio de Programação - Academia Capgemini
 * Autor: Ályson Batista Siqueira Campos
 * Questão 03: Duas palavras podem ser consideradas anagramas de si mesmas se as letras de uma palavra 
 * podem ser realocadas para formar a outra palavra. Dada uma string qualquer, desenvolva um algoritmo
 * que encontre o número de pares de substrings que são anagramas. 
 */
public class Challenge03 {
	
	public static void main(String[] args) {
		
		//instanciando e criando um objeto Scanner para capturar a entrada de dados
		Scanner sc = new Scanner(System.in);
		
		String frase;//declarando variável que armazenará o input do usuário
		
		System.out.print("Digite uma frase qualquer: ");
		frase = sc.nextLine();//entrada de dados (lendo uma String)
		
		verificaAnagrama(frase);//Chamando a função verificaAnagrama.
		
		sc.close();//fechando o scanner que foi aberto
	
	}

	private static void verificaAnagrama(String frase) {
		
		/*
		 * criando e instanciando HashMap que irá armazenar um par chave-valor,
		 * sendo que a chave deverá ser do tipo String e o valor do tipo Interger,
		 * conforme especificado no Generics através do <String, Interger> 
		 */
		Map<String, Integer> map = new HashMap<>();
		
		for (int i = 0; i <= frase.length(); i++) {

			for (int j = i; j < frase.length(); j++) {
				
				/*
				 * O método "substring()" retornará parte da string, enquanto o método
				 * "toCharArray() converterá em caracter. Esses caracteres serão armazenados
				 * em um array." 
				 */
				char[] caractere = frase.substring(i, j + 1).toCharArray();
				Arrays.sort(caractere);//ordenando o array de caracteres
				String subCaract = new String(caractere);
				
				//O método "containsKey()" irá procurar a chave especificada.
				if (map.containsKey(subCaract)) {
					map.put(subCaract, map.get(subCaract) + 1);//associando o valor especificado com a chave especificada
				} else {
					map.put(subCaract, 1);
				}
			}
		}
		
		//variavel para armazenar a quantidade de pares de anagramas.
		int qtdPares = 0;
		
		/*
		 * Foreach com HashMap: o método "keySet()" retorna um Set com todas as chaves
		 * do HasMap, e tendo o Set com todas as Chaves, podemos pegar os valores desejados 
		 */
		for (String cont : map.keySet()) {
			int n = map.get(cont);
			qtdPares += (n * (n - 1)) / 2;
		}
		//saída de dados com a quantidade de pares de anagramas 
		System.out.print("Pares de anagramas: " + qtdPares);	
	}
}
