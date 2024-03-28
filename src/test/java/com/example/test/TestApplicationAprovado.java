package com.example.test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestApplicationAprovado {

    private final InputStream systemIn = System.in;
    private final PrintStream systemOut = System.out;

    private ByteArrayOutputStream testOutput;

    @BeforeEach
    public void setUpOutput() {
        testOutput = new ByteArrayOutputStream();
        System.setOut(new PrintStream(testOutput));
    }

    private void provideInput(String data) {
        ByteArrayInputStream testInput = new ByteArrayInputStream(data.getBytes());
        System.setIn(testInput);
    }

    private String getOutput() {
        return testOutput.toString().trim();
    }

    @Test
    @DisplayName("Testing Aprovado")
    void main_Aprovado() {
        String input = "8\n6\n7\ny\n";
        provideInput(input);

        TestApplication.main(new String[]{});

        String expectedOutput =
                        "Escreva a primeira nota: \n" +
                        "Escreva a segunda nota: \n" +
                        "Escreva a terceira nota: \n" +
                        "Você foi aprovado com: 7.0\n" +
                        "Deseja calcular o resultado novamente?(Y/N)\n";
        assertEquals(expectedOutput, getOutput());
    }
    @Test
    @DisplayName("Testing Recuperacao")
    void main_Recuperacao() {
        String input = "5\n6\n7\ny\n";
        provideInput(input);

        TestApplication.main(new String[]{});

        String expectedOutput =
                "Escreva a primeira nota: \n" +
                        "Escreva a segunda nota: \n" +
                        "Escreva a terceira nota: \n" +
                        "Você ficou de recuperação com: 6.0, estude\n" +
                        "Deseja calcular o resultado novamente?(Y/N)\n";
        assertEquals(expectedOutput, getOutput());
    }
    @Test
    @DisplayName("Testing reprovado")
    void main_Reprovado() {
        String input = "3\n6\n7\nn\n";
        provideInput(input);

        TestApplication.main(new String[]{});

        String expectedOutput =
                "Escreva a primeira nota: \n" +
                        "Escreva a segunda nota: \n" +
                        "Escreva a terceira nota: \n" +
                        "Nos vemos semestre que vem: 5.33, reprovado\n" +
                        "Deseja calcular o resultado novamente?(Y/N)\n";
        assertEquals(expectedOutput, getOutput());
    }
}


