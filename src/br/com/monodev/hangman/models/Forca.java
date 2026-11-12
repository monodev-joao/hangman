package br.com.monodev.hangman.models;

public class Forca {
    private String[] palavras = {"parada", "bola", "sorvete"};
    private char[] letras = new char[6];
    private int acertos = 0;
    private int erros = 0;

    public String[] getPalavras() {
        return palavras;
    }

    public int getAcertos() {
        return acertos;
    }

    public int getErros() {
        return erros;
    }

    public void jogar(char letra) {
        int letraErrada = 0;
        for (char c : palavras[0].toCharArray()) {
            if (letra == c) {
                acertos++;
            } else {
                letraErrada++;
            }
        }
        if (letraErrada == palavras[0].length()) erros++;
        System.out.println(letra);
    }

    public void mostrarLetras() {
        System.out.print("Palavra: ");
        for (int i = 0; i < palavras[0].length(); i++) {
            System.out.print("_ ");
        }
        System.out.println();
    }
}
