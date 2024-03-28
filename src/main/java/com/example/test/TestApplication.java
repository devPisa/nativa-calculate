package com.example.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class TestApplication {

	public static void main(String[] args) {

		SpringApplication.run(TestApplication.class, args);
		String repetir = "";
		Scanner sc = new Scanner(System.in);
		while (!repetir.equals("n")) {
			Aluno aluno = new Aluno();
			String resultado = aluno.calcularResultado();
			System.out.println(resultado);
			System.out.println("Deseja calcular o resultado novamente?(Y/N)");
			if (sc.hasNext()) {
				repetir = sc.next();
			} else {
				sc.close();
			}
			System.exit(0);
		}
	}
}

