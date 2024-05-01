import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner t = new Scanner(System.in);
        JogoDaVelha jogo = new JogoDaVelha();
        String r;

        // Primeira Tela
        jogo.velhaZerado(); // Reinicia o tabuleiro antes do loop começar
        do {
            jogo.mostrarTela();

            // Jogadas do jogador
            jogo.jogadas(t);

            // Perguntar se deseja jogar novamente
            boolean respostaValida = false;
            do {
                System.out.print("Quer jogar novamente? [S/N] ");
                r = t.nextLine().toLowerCase(); // Converter para minúsculas para facilitar a comparação
                if (r.equals("s") || r.equals("n")) {
                    respostaValida = true;
                } else {
                    System.out.println("Resposta inválida! Digite S para Sim ou N para Não.");
                }
            } while (!respostaValida);

            if (r.equals("n")) {
                break; // Sai do loop se não deseja jogar novamente
            } else {
                jogo.velhaZerado(); // Reinicia o tabuleiro para um novo jogo
            }
        } while (true);

        t.close();
    }
}
