package com.javaee.lucas;

public class EmailSender {

	public static void main(String[] args) {
		final String fromEmail = "testemanobray@gmail.com";
		final String password = "HAHAHA123";
		final String toEmail = "testemanobray@gmail.com";
		
		EmailConfig config = new EmailConfig();
		
		System.out.println("Sucesso");
		
		config.sendEmail(fromEmail, password, toEmail, "Assunto Javão2", "Teste Javão2");
		
		System.out.println("Enviado");

	}

}
