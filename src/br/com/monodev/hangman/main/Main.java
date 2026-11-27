package br.com.monodev.hangman.main;

import br.com.monodev.hangman.models.Forca;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner leitura = new Scanner(System.in);
        Forca forca = new Forca();

        System.out.println("*********************************");
        System.out.println("JOGO DA FORCA (HANGMAN)");
        System.out.println("*********************************");
        while (forca.getErros() != 6) {
            forca.mostrarLetras();
            if (forca.verificaAcerto()) break;
            System.out.print("QUAL LETRA VOCÊ ACHA QUE TEM? ");
            char letra = leitura.next().charAt(0);
            System.out.println("*********************************");
            forca.jogar(letra);
            System.out.println("*********************************");
            forca.mostrarLetrasCertas();
        }
        System.out.println("JOGO FINALIZADO");
        System.out.println("*********************************");
    }
}
