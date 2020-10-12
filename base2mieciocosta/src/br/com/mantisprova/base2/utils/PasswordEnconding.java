/*
* Classe PasswordEnconding responsável por codificar senha do usuário para não ficar
* exposto diretamente no código.
*/

package br.com.mantisprova.base2.utils;

import org.apache.commons.codec.binary.Base64;

/**
 * @version 1.0
 * @author Miécio Santos Costa
 */

public class PasswordEnconding {

	public static void main(String[] args) {
		
		// Senha "original" do usuário
		String PassWord = "230507";

		// Codigicando a senha do usuário em uma String com dados aleatórios
		byte[] encodePassword = Base64.encodeBase64(PassWord.getBytes());
//		System.out.println("senha : " + new String(encodePassword));

		/*
		 * Decodificando a senha com a informação recebida do console java
		 * podendo ser inserida posteriormentes nos testes.
		 */
		byte[] decodePassword = Base64.decodeBase64("MjMwNTA3".getBytes());
	}

}
