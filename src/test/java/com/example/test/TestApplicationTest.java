package com.example.test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TestApplicationTest {

    private final InputStream systemIn = System.in;
    private final PrintStream systemOut = System.out;

    private ByteArrayInputStream testEntrada;
    private ByteArrayOutputStream testSaida;

    @BeforeEach
    public void setUpOutput() {
        testSaida = new ByteArrayOutputStream();
        System.setOut(new PrintStream(testSaida));
    }

    private void inputNota(String data) {
        testEntrada = new ByteArrayInputStream(data.getBytes());
        System.setIn(testEntrada);
    }

    private String getOutput() {
        return testSaida.toString();
    }

    @Test
    @DisplayName("Testando input")
    void main() {
        String input = "5\n6\n7\nn\n";
        inputNota(input);

        TestApplication.main(new String[]{});

        String saidaEsperada =
                                "Escreva a primeira nota: \n" +
                                "Escreva a segunda nota: \n" +
                                "Escreva a terceira nota: \n" +
                                "Você reprovou com: 6.0\n" +
                                "Deseja calcular uma nova nota? (y/n)\n";
        assertEquals(saidaEsperada, getOutput());
    }
}
