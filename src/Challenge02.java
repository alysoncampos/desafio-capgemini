import java.util.Scanner;

/*	
 * Desafio de Programação - Academia Capgemini
 * Autor: Ályson Batista Siqueira Campos
 * Questão 02: Débora se inscreveu em uma rede social para se manter em contato com seus amigos. 
 * A página de cadastro exigia o preenchimento dos campos de nome e senha, porém a senha precisa ser forte.
 * O site considera uma senha forte quando ela satisfaz os seguintes critérios:
 * Possui no mínimo 6 caracteres.
 * Contém no mínimo 1 digito.
 * Contém no mínimo 1 letra em minúsculo.
 * Contém no mínimo 1 letra em maiúsculo.
 * Contém no mínimo 1 caractere especial. Os caracteres especiais são: !@#$%^&*()-+
 * Débora digitou uma string aleatória no campo de senha, porém ela não tem certeza se é uma senha forte.
 * Para ajudar Débora, construa um algoritmo que informe qual é o número mínimo de caracteres que devem ser 
 * adicionados para uma string qualquer ser considerada segura.
 */
public class Challenge02 {
	
	public static void main(String[] args) {
		
		//instanciando e criando um objeto Scanner para capturar a entrada de dados
		Scanner sc = new Scanner (System.in);
		
		//declarando as variáveis
		String senha;
		boolean temDigito = false;
		boolean temMaisculo = false;
		boolean temMinusculo = false;
		boolean temSimbolo = false;
		boolean numeroMinimo = false;
		int requisitosRestantes = 0;
		
		System.out.println("A senha deve atender aos seguintes requisitos de segurança:\n"+
	            "- Possua no mínimo 6 caracteres;\n" +
	            "- Contenha no mínimo 1 digito;\n" +
	            "- Contenha no mínimo 1 letra em minúsculo;\n" +
	            "- Contenha no mínimo 1 letra em maiúsculo;\n" +
	            "- Contenha no mínimo 1 caractere especial (!@#$%^&*()-+);\n");
		System.out.print("Digite sua senha: ");
		senha = sc.nextLine();//entrada de dados no sistema (lendo uma String)
		/*
		 * Verificando se a senha informada pelo usuário tem seis ou mais caracteres
		 * e, em caso afirmativo, atribuindo true à variável "numeroMinimo".
		 */
		if(senha.length() >= 6) {
			numeroMinimo = true;
		}
		/*
		 * Percorrendo cada caracter da senha e verificando se a mesma atende aos requisitos
		 * de segurança. 
		 */
		for(char c : senha.toCharArray()) {
			if(c >= '0' && c <= '9') {
				temDigito = true;
			}
			if(c >= 'A' && c <= 'Z') {
				temMaisculo = true;
			}
			if(c >= 'a' && c <= 'z') {
				temMinusculo = true;
			}
			if(c == '!' || c == '@' || c == '#' || c == '$' || c == '%'
				|| c == '^' || c == '&' || c == '*' || c == '(' || c == ')'
				|| c == '-' || c == '+') {
				temSimbolo = true;
			}
		}
		/*
		 * A partir da verificação do tamanho senha (se >= 6) faz-se o cálculo da
		 * quantidade de caracteres que faltam para tornar a senha segura.
		 */
		if(numeroMinimo) {
			if(!temDigito) {
				requisitosRestantes++;
			}
			if(!temMaisculo) {
				requisitosRestantes++;
			}
			if(!temMinusculo) {
				requisitosRestantes++;
			}
			if(!temSimbolo) {
				requisitosRestantes++;
			}
		} else {
			if(!temDigito) {
				requisitosRestantes++;
			}
			if(!temMaisculo) {
				requisitosRestantes++;
			}
			if(!temMinusculo) {
				requisitosRestantes++;
			}
			if(!temSimbolo) {
				requisitosRestantes++;
			}
			if(6 - senha.length() > requisitosRestantes) {
				requisitosRestantes = 6 - senha.length();
			}
		}
		/*
		 * Saída de dados:
		 * Se todos os requisitos atendidos, programa informa ao usuário que a senha é segura.
		 * Caso contrário, o programa informa quantos caracters são necessários para torná-la
		 * segura e informa os requisitos que ainda não foram atendidos..
		 */
		if (requisitosRestantes == 0) {
			System.out.println("Senha segura");
		} else {
			System.out.println("Para tornar segura falta atender: " + requisitosRestantes + " requisito(s)");
			if(!temDigito) {
				System.out.println("Sua senha precisa ter pelo menos um digito!");
			}
			if(!temMaisculo) {
				System.out.println("Sua senha precisa ter pelo menos uma letra em maiusculo!");
			}
			if(!temMinusculo) {
				System.out.println("Sua senha precisa ter pelo menos uma letra em minusculo!");
			}
			if(!temSimbolo) {
				System.out.println("Sua senha precisa ter pelo menos um caractere especial");
			}
			if(!numeroMinimo) {
				System.out.println("Sua senha precisa ter no mínimo 6 (seis) caracteres");
			}
		}
		//fechando o scanner que foi aberto
		sc.close();
	}

}
