import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    static final Scanner input = new Scanner(System.in);

    public String capturarNomeJogador(){
        String nome = null,
                resposta = "";
        while (!resposta.equalsIgnoreCase("S")) {
            System.out.print("Selecione o nome do jogador a ser adicionado: ");
            nome = input.nextLine();
            if (nome == null)
                nome = input.nextLine();
            System.out.printf("O nome digitado foi '%s', está correto(S/N)? ", nome);
            resposta = input.nextLine();
            if (resposta == null)
                resposta = input.nextLine();
            while (!(resposta.equalsIgnoreCase("S") ||
                    resposta.equalsIgnoreCase("N"))) {
                System.out.print("Digite uma opção válida(S/N): ");
                resposta = input.nextLine();
            }
        }
            return nome;
        }
    public static void exibirDados(ArrayList<Integer> listaDado){
        for (int index = 0; index < 5; index++) {
            System.out.printf("|%dº dado: %d| ", index + 1, listaDado.get(index));
        }
        System.out.println();
    }

    public static int capturarCorUsuario(){
        String opcao;
        SistemaCor.exibicaoCores();
        System.out.print("Escolha o número da cor desejada: ");
        opcao = input.nextLine();
        while (Integer.parseInt(opcao) < 1 || Integer.parseInt(opcao) > 7){
            System.out.print("Escolha uma opção válida: ");
            opcao = input.nextLine();
        }
        return Integer.parseInt(opcao);
    }
    static void modificarDados(ArrayList<Integer> listaDado,
                               int quantidadeModificacoes) throws InterruptedException {
        if (quantidadeModificacoes == 2){
            System.out.println("Você já fez o limite de mudanças possíveis");
            Thread.sleep(1000);
            return;
        }
        int posicao = -1;
        ArrayList<Integer> listaPosicaoDados = new ArrayList<>();
        while (posicao != 0){
            System.out.print("Escolha a posição do dado que deseja mudar(Digite 0 para sair): ");
            posicao = input.nextInt();
            while (posicao < 0 || posicao > 5){
                System.out.print("Escolha uma posição de dado válida(De 1 a 5): ");
                posicao = input.nextInt();
            }
            if (!listaPosicaoDados.contains(posicao) && posicao != 0) {
                listaPosicaoDados.add(posicao);
            }
            else if(posicao != 0)
                System.out.println("Você já escolheu o dado dessa posição!");
        }
        for (int index: listaPosicaoDados) {
            listaDado.set(index - 1, Dado.girarDado());
        }
    }
   public static void exibirTabelaPontuacaoJogador(ArrayList<Integer> listaQuantidadeDados, Jogador jogador,
                                      boolean adicionarCor)
           throws FileNotFoundException {
        System.out.printf("%55.55s\n", jogador.getCorTabela() + "Tabela jogador " + jogador.getNome() +
                SistemaCor.RESETACOR);
       File file = new File(SistemaExtrairCaminhoArquivo.extrairCaminhoArquivo("descricaoCategorias.txt") +
               "/src/descricaoCategorias.txt");
       Scanner scanner = new Scanner(file);
        for (int c = 0; c < 13; c++){
            System.out.printf("%50.50s: %20s%n\n",
                    jogador.getCorTabela() + scanner.nextLine(),
                    SistemaPontuacaoJogo.escolherVerificacao(listaQuantidadeDados, c + 1,
                            jogador, adicionarCor));
            if (c == 5){
                if (jogador.getPontuacaoBonus() == 35) {
                    System.out.printf("%50.50s: %20s%n\n", jogador.getCorTabela() + scanner.nextLine(),
                            SistemaCor.CORAMARELA + jogador.getPontuacaoBonus() + "pts" +
                                    SistemaCor.RESETACOR);
                } else {
                    System.out.printf("%50.50s: %20s%n\n", jogador.getCorTabela() + scanner.nextLine(),
                            SistemaCor.CORVERMELHA + jogador.getPontuacaoBonus() +
                                    SistemaCor.RESETACOR);
                }
            }
        }
       System.out.printf("%50.50s: %20s%n\n", jogador.getCorTabela() + "Total pts",
               SistemaCor.CORVERDE + jogador.getPontuacaoTotal() +
                       SistemaCor.RESETACOR);
    }
}
