package br.com.monodev.hangman.main;

import br.com.monodev.hangman.models.Forca;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner leitura = new Scanner(System.in);
        Forca forca = new Forca();

        System.out.println("JOGO DA FORCA (HANGMAN)");
        forca.mostrarLetras();
        while (forca.getAcertos() != forca.getPalavras()[0].length() && forca.getErros() < 6) {
            System.out.println("Digite uma letra: ");
            char letra = leitura.next().charAt(0);
            forca.jogar(letra);
        }
        System.out.println("JOGO FINALIZADO");
    }
}
