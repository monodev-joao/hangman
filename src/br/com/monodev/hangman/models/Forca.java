package br.com.monodev.hangman.models;

public class Forca {
    private String[] palavras = {"parada", "bola", "sorvete"};
    private char[] letrasTentadas = new char[palavras[0].length() + 6];
    private char[] correta = new char[palavras[0].length()];
    private int erros = 0;

    public String[] getPalavras() {
        return palavras;
    }

    public char[] getLetrasTentadas() {
        return letrasTentadas;
    }

    public int getErros() {
        return erros;
    }

    // Núcleo do jogo
    public void jogar(char letra) {
        if (verificarLetraRepetida(letra)) {
            System.out.println("LETRA REPETIDA, TENTE OUTRA");
        } else {

            for (int i = 0; i < letrasTentadas.length; i++) {
                if (letrasTentadas[i] == 0) {
                    letrasTentadas[i] = letra;
                    break;
                }
            }

            char[] palavra = palavras[0].toCharArray();
            int acerto = 0;
            int quantErros = 0;
            for (int i = 0; i < palavras[0].length(); i++) {
                if (letra != palavra[i]) {
                    quantErros++;
                } else {
                    acerto++;
                }
            }

            if (quantErros != palavra.length) {
                System.out.println("ACERTOU A LETRA - QUANT:" + acerto);
            } else {
                System.out.println("ERROU A ELTRA");
                erros++;
            }
        }
    }

    // Quero usar ela para mostrar a palavra com as letras corretas a cada rodada
    public void mostrarLetras() {
        char[] palavra = palavras[0].toCharArray();
        System.out.print("PALAVRA: ");
        for (int i = 0; i < palavra.length; i++) {
            System.out.print("_ ");
        }
        System.out.println();
    }

    public void mostrarLetrasCertas() {
        char[] palavra = palavras[0].toCharArray();
        System.out.print("PALAVRA: ");
        for (int i = 0; i < letrasTentadas.length; i++) {
            if (letrasTentadas[i] == 0) break;
            for (int j = 0; j < palavra.length; j++) {
                if (letrasTentadas[i] == palavra[j]) {
                    correta[j] = letrasTentadas[i];
                    continue;
                }
                if (correta[j] != palavra[j]) {
                    correta[j] = '_';
                }
            }
        }
        System.out.println(correta);
    }

    // Verifica se a letra digitada já foi digitada anteriormente
    public boolean verificarLetraRepetida(char letra) {
        for (char i : letrasTentadas) {
           if (letra == i) {
               return true;
           }
        }
        return false;
    }

    // Verifica as letras tentadas com as da palavra e retorna caso tenha acertado
    public boolean verificaAcerto() {
        int acertos = 0;
        for (char l : letrasTentadas) {
            for (char p : palavras[0].toCharArray()) {
                if (l == p) acertos++;
            }
        }
        return acertos == palavras[0].length();
    }
}
