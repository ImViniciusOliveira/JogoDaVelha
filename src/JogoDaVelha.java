import java.util.Scanner;

public class JogoDaVelha {
    String n[][] = new String[3][3]; // n = números de 1 a 9 do jogo da velha
    int c1 = 0;
    int c2 = 0;

    // Inicialização da tela
    public void velhaZerado() {
        int c = 0; // contador
        for (int i = 0; i < 3; i++) { // i = linha
            for (int j = 0; j < 3; j++) { // j = coluna
                c++;
                n[i][j] = Integer.toString(c);
            }
        }
    }

    // Atualização e exibição da tela
    public void mostrarTela() {
        System.out.println("Tabuleiro Atual: ");
        for (int i = 0; i < 3; i++) { // i = linha
            for (int j = 0; j < 3; j++) { // j = coluna
                System.out.print(" " + n[i][j] + " ");
                if (j < 2) {
                    System.out.print("|");
                }
            }
            if (i < 2) {
                System.out.println("\n-----------");
            }
        }
        System.out.println();
    }

    public void trocarCaractere(int r, String novoCaractere) { // r = resposta
        // Calculando a linha e a coluna com base na posição fornecida
        int linha = (r - 1) / 3; // sempre -1 ( pelo java comecar com 0) e / pelo numero de linhas
        int coluna = (r - 1) % 3; // sempre -1 ( pelo java comecar com 0) e % pelo numero de colunas
        n[linha][coluna] = novoCaractere;
    }

    // valida se a entrada foi inserida certa, podendo ser apenas numeros disponiveis
    public int validarEntrada(Scanner t) {
        while (true) {
            System.out.print("Digite um número disponível: ");
            String input = t.nextLine();
            System.out.println();
            try {
                int num = Integer.parseInt(input);
                if (num >= 1 && num <= 9) {
                    if (sobreposicao(num)) {
                        System.out.print("Espaço já ocupado, ");
                    } else {
                        return num;
                    }
                } else {
                    System.out.print("Apenas números de 1 a 9, ");
                }
            } catch (NumberFormatException e) {
                System.out.print("Pode ser inserido apenas números, ");
            }
        }
    }

    // Jogadas dos 2 jogadores
    public void jogadas(Scanner t) { // t = teclado
        int c = 0; // contador
        while (true) {
            int r; // r = resposta
            if (c % 2 == 0) {
                System.out.print("Jogador 1 (X), ");
            } else {
                System.out.print("Jogador 2 (O), ");
            }
            r = validarEntrada(t);
            if (c % 2 == 0) {
                trocarCaractere(r, "X");
            } else {
                trocarCaractere(r, "O");
            }
            mostrarTela();
            c++;
            if (ganhadorOuVelha(r)) {
                break;
            }
        }
    }

    public boolean sobreposicao(int r) { // resposta
        int linha = (r - 1) / 3; // sempre -1 ( pelo java comecar com 0) e / pelo numero de linhas
        int coluna = (r - 1) % 3; // sempre -1 ( pelo java comecar com 0) e % pelo numero de colunas
        return n[linha][coluna].equals("X") || n[linha][coluna].equals("O");
    }

    public boolean ganhadorOuVelha(int r) {
        // Verificar linhas
        for (int i = 0; i < 3; i++) {
            if (n[i][0].equals(n[i][1]) && n[i][1].equals(n[i][2])) {
                if (n[i][0].equals("X")) {
                    System.out.println("O jogador 1 (X) ganhou!");
                    c1++;
                } else {
                    System.out.println("O jogador 2 (O) ganhou!");
                    c2++;
                }
                if(c1 != c2) {
                    System.out.println("PLACAR:\np1 " + c1 + "x" + c2 + " p2");
                } else {
                    System.out.println("PLACAR:\np1 " + c1 + "x" + c2 + " p2 TA TUDO EMPATADO!!!");
                }
                return true;
            }
        }

        // Verificar colunas
        for (int j = 0; j < 3; j++) {
            if (n[0][j].equals(n[1][j]) && n[1][j].equals(n[2][j])) {
                if (n[0][j].equals("X")) {
                    System.out.println("O jogador 1 (X) ganhou!");
                    c1++;
                } else {
                    System.out.println("O jogador 2 (O) ganhou!");
                    c2++;
                }
                if(c1 != c2) {
                    System.out.println("PLACAR:\np1 " + c1 + "x" + c2 + " p2");
                } else {
                    System.out.println("PLACAR:\np1 " + c1 + "x" + c2 + " p2 TA TUDO EMPATADO!!!");
                }
                return true;
            }
        }

        // Verificar diagonais
        if (n[0][0].equals(n[1][1]) && n[1][1].equals(n[2][2])) {
            if (n[0][0].equals("X")) {
                System.out.println("O jogador 1 (X) ganhou!");
                c1++;
            } else {
                System.out.println("O jogador 2 (O) ganhou!");
                c2++;
            }
            if(c1 != c2) {
                System.out.println("PLACAR:\np1 " + c1 + "x" + c2 + " p2");
            } else {
                System.out.println("PLACAR:\np1 " + c1 + "x" + c2 + " p2 TA TUDO EMPATADO!!!");
            }
            return true;
        }
        if (n[0][2].equals(n[1][1]) && n[1][1].equals(n[2][0])) {
            if (n[0][2].equals("X")) {
                System.out.println("O jogador 1 (X) ganhou!");
                c1++;
            } else {
                System.out.println("O jogador 2 (O) ganhou!");
                c2++;
            }
            if(c1 != c2) {
                System.out.println("PLACAR:\np1 " + c1 + "x" + c2 + " p2");
            } else {
                System.out.println("PLACAR:\np1 " + c1 + "x" + c2 + " p2 TA TUDO EMPATADO!!!");
            }
            return true;
        }

        // Verificar empate
        boolean empate = true;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (!n[i][j].equals("X") && !n[i][j].equals("O")) {
                    empate = false;
                    break;
                }
            }
            if (!empate) {
                break;
            }
        }
        if (empate) {
            System.out.println("Velha!");
            System.out.println("PLACAR:\np1 " + c1 + "x" + c2 + " p2");
            return true;
        }
        return false;
    }
}
