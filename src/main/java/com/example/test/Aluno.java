package com.example.test;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.text.DecimalFormat;
import java.util.Scanner;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Aluno {

    private double nota1;
    private double nota2;
    private double nota3;

    public String calcularResultado() {

        String resultado = "";

        DecimalFormat df = new DecimalFormat("#.##");
        Scanner sc = new Scanner(System.in);

            System.out.println("Escreva a primeira nota: ");
            double nota1 = sc.nextDouble();
            System.out.println("Escreva a segunda nota: ");
            double nota2 = sc.nextDouble();
            System.out.println("Escreva a terceira nota: ");
            double nota3 = sc.nextDouble();

            double media = (nota1 + nota2 + nota3) / 3;

            if (media >= 7.0) {
                resultado = "Você foi aprovado com: " + df.format(media);
            } else if (media >= 4.0 && media < 6.9) {
                resultado = "Você ficou de recuperação com: " + df.format(media) + ", estude";
            } else {
                resultado = "Nos vemos semestre que vem: " + df.format(media) + ", reprovado";
            }

        return resultado;
    }
}
