import java.util.Scanner;

/*	
 * Desafio de Programa��o - Academia Capgemini
 * Autor: �lyson Batista Siqueira Campos
 * Quest�o 02: D�bora se inscreveu em uma rede social para se manter em contato com seus amigos. 
 * A p�gina de cadastro exigia o preenchimento dos campos de nome e senha, por�m a senha precisa ser forte.
 * O site considera uma senha forte quando ela satisfaz os seguintes crit�rios:
 * Possui no m�nimo 6 caracteres.
 * Cont�m no m�nimo 1 digito.
 * Cont�m no m�nimo 1 letra em min�sculo.
 * Cont�m no m�nimo 1 letra em mai�sculo.
 * Cont�m no m�nimo 1 caractere especial. Os caracteres especiais s�o: !@#$%^&*()-+
 * D�bora digitou uma string aleat�ria no campo de senha, por�m ela n�o tem certeza se � uma senha forte.
 * Para ajudar D�bora, construa um algoritmo que informe qual � o n�mero m�nimo de caracteres que devem ser 
 * adicionados para uma string qualquer ser considerada segura.
 */
public class Challenge02 {
	
	public static void main(String[] args) {
		
		//instanciando e criando um objeto Scanner para capturar a entrada de dados
		Scanner sc = new Scanner (System.in);
		
		//declarando as vari�veis
		String senha;
		boolean temDigito = false;
		boolean temMaisculo = false;
		boolean temMinusculo = false;
		boolean temSimbolo = false;
		boolean numeroMinimo = false;
		int requisitosRestantes = 0;
		
		System.out.println("A senha deve atender aos seguintes requisitos de seguran�a:\n"+
	            "- Possua no m�nimo 6 caracteres;\n" +
	            "- Contenha no m�nimo 1 digito;\n" +
	            "- Contenha no m�nimo 1 letra em min�sculo;\n" +
	            "- Contenha no m�nimo 1 letra em mai�sculo;\n" +
	            "- Contenha no m�nimo 1 caractere especial (!@#$%^&*()-+);\n");
		System.out.print("Digite sua senha: ");
		senha = sc.nextLine();//entrada de dados no sistema (lendo uma String)
		/*
		 * Verificando se a senha informada pelo usu�rio tem seis ou mais caracteres
		 * e, em caso afirmativo, atribuindo true � vari�vel "numeroMinimo".
		 */
		if(senha.length() >= 6) {
			numeroMinimo = true;
		}
		/*
		 * Percorrendo cada caracter da senha e verificando se a mesma atende aos requisitos
		 * de seguran�a. 
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
		 * A partir da verifica��o do tamanho senha (se >= 6) faz-se o c�lculo da
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
		 * Sa�da de dados:
		 * Se todos os requisitos atendidos, programa informa ao usu�rio que a senha � segura.
		 * Caso contr�rio, o programa informa quantos caracters s�o necess�rios para torn�-la
		 * segura e informa os requisitos que ainda n�o foram atendidos..
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
				System.out.println("Sua senha precisa ter no m�nimo 6 (seis) caracteres");
			}
		}
		//fechando o scanner que foi aberto
		sc.close();
	}

}
