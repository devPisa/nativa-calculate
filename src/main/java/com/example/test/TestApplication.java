package com.example.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.text.DecimalFormat;
import java.util.Scanner;

@SpringBootApplication
public class TestApplication {

	public static void main(String[] args) {

		SpringApplication.run(TestApplication.class, args);

		String resultado = "";
		String calculo = "";
		Scanner sc = new Scanner(System.in);
		DecimalFormat df = new DecimalFormat("#.##");

		while (!calculo.equals("n")){
			System.out.println("Escreva a primeira nota: ");
			double nota1 = sc.nextDouble();
			System.out.println("Escreva a segunda nota: ");
			double nota2 = sc.nextDouble();
			System.out.println("Escreva a terceira nota: ");
			double nota3 = sc.nextDouble();

			double media = (nota1 + nota2 + nota3) / 3;

			if (media >= 7.0) {
				resultado = String.valueOf(media);
				System.out.println("Você está aprovado com:" + df.format(media));
			} else if (media >= 4.0 && media < 6.9) {
				resultado = String.valueOf(media);
				System.out.println("Infelizmente você foi para segunda oportunidade com: " + df.format(media) + ", estude!");
			} else {
				resultado = String.valueOf(media);
				System.out.println("Você reprovou com: " + df.format(media));
			}
			System.out.println("Deseja calcular uma nova nota?(y/n)");
			calculo = sc.next();
		}
		System.exit(0);
	}
}
