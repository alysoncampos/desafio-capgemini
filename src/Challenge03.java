import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
/* 
 * Desafio de Programa��o - Academia Capgemini
 * Autor: �lyson Batista Siqueira Campos
 * Quest�o 03: Duas palavras podem ser consideradas anagramas de si mesmas se as letras de uma palavra 
 * podem ser realocadas para formar a outra palavra. Dada uma string qualquer, desenvolva um algoritmo
 * que encontre o n�mero de pares de substrings que s�o anagramas. 
 */
public class Challenge03 {
	
	public static void main(String[] args) {
		
		//instanciando e criando um objeto Scanner para capturar a entrada de dados
		Scanner sc = new Scanner(System.in);
		
		String frase;//declarando vari�vel que armazenar� o input do usu�rio
		
		System.out.print("Digite uma frase qualquer: ");
		frase = sc.nextLine();//entrada de dados (lendo uma String)
		
		verificaAnagrama(frase);//Chamando a fun��o verificaAnagrama.
		
		sc.close();//fechando o scanner que foi aberto
	
	}

	private static void verificaAnagrama(String frase) {
		
		/*
		 * criando e instanciando HashMap que ir� armazenar um par chave-valor,
		 * sendo que a chave dever� ser do tipo String e o valor do tipo Interger,
		 * conforme especificado no Generics atrav�s do <String, Interger> 
		 */
		Map<String, Integer> map = new HashMap<>();
		
		for (int i = 0; i <= frase.length(); i++) {

			for (int j = i; j < frase.length(); j++) {
				
				/*
				 * O m�todo "substring()" retornar� parte da string, enquanto o m�todo
				 * "toCharArray() converter� em caracter. Esses caracteres ser�o armazenados
				 * em um array." 
				 */
				char[] caractere = frase.substring(i, j + 1).toCharArray();
				Arrays.sort(caractere);//ordenando o array de caracteres
				String subCaract = new String(caractere);
				
				//O m�todo "containsKey()" ir� procurar a chave especificada.
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
		 * Foreach com HashMap: o m�todo "keySet()" retorna um Set com todas as chaves
		 * do HasMap, e tendo o Set com todas as Chaves, podemos pegar os valores desejados 
		 */
		for (String cont : map.keySet()) {
			int n = map.get(cont);
			qtdPares += (n * (n - 1)) / 2;
		}
		//sa�da de dados com a quantidade de pares de anagramas 
		System.out.print("Pares de anagramas: " + qtdPares);	
	}
}
