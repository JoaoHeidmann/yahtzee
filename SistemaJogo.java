import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class SistemaJogo {
    public static ArrayList<Jogador> listaJogadores = new ArrayList<>();
    public static Menu exibidorMenu = new Menu();
    public static Scanner input = new Scanner(System.in);

    public static void exibirTabelaClassificacao(){
        Collections.sort(listaJogadores);
        String corTexto;
        for (Jogador jogador: listaJogadores){
            if (listaJogadores.indexOf(jogador) == 0)
                corTexto = SistemaCor.CORVERDE;
            else
                corTexto = SistemaCor.CORAMARELA;
            System.out.printf("%s%dº LUGAR: %s - %d pts %s\n", corTexto,
                    listaJogadores.indexOf(jogador) + 1, jogador.getNome(), jogador.getPontuacaoTotal(),
                    SistemaCor.RESETACOR);
        }
    }
    public static void cadastrarJogador(String nome, String corTabela)
            throws IOException, InterruptedException {
        if (verificarNome(nome)){
            System.out.println("O nome já está registrado no sistema, não é possível ter 2 jogadores com " +
                    "mesma identificação");
        } else {
            Jogador jogador = new Jogador(nome, corTabela);
            listaJogadores.add(jogador);
            System.out.printf("Jogador %s adicionado com sucesso\n", nome);
            Thread.sleep(1000);
        }
    }

    private static boolean verificarNome(String nome){
        for (Jogador jogador: listaJogadores) {
            if (jogador.getNome().equals(nome))
                return true;
        }
        return false;
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        String resposta;
        SistemaArquivarJogador.criarPastadeJogadores("ArquivoJogadores");
        System.out.println("SISTEMA DE CADASTRO DO JOGO YAHTZEE");
        Thread.sleep(1000);
        System.out.println("Antes de iniciar a partida, deve cadastrar no mínimo 2 jogadores");
        Thread.sleep(2000);
        while (listaJogadores.size() < 2){
            String nome = exibidorMenu.capturarNomeJogador();
            System.out.println("Para facilitar diferenciação entre jogadores, disponibilizamos uma lista de" +
                    "cores para personalizar sua tabela");
            String cor = SistemaCor.selecionarCor(Menu.capturarCorUsuario());
            cadastrarJogador(nome, cor);
        }
        System.out.print("O mínimo de jogadores necessários foi registrado, deseja registrar outro(S/N)? ");
        resposta = input.nextLine();
        if (resposta == null)
            resposta = input.nextLine();
        while (!(resposta.equalsIgnoreCase("s") || resposta.equalsIgnoreCase("n"))){
            System.out.print("Escolha uma opção válida(S/N): ");
            resposta = input.nextLine();
            if (resposta == null)
                resposta = input.nextLine();
        }
        while (resposta.equalsIgnoreCase("S")){
            String nome = exibidorMenu.capturarNomeJogador();
            System.out.println("Para facilitar diferenciação entre jogadores, disponibilizamos uma lista de" +
                    "cores para personalizar sua tabela");
            String cor = SistemaCor.selecionarCor(Menu.capturarCorUsuario());
            cadastrarJogador(nome, cor);
            System.out.print("Deseja registrar outro jogador(S/N)? ");
            resposta = input.nextLine();
            if (resposta == null)
                resposta = input.nextLine();
            while (!(resposta.equalsIgnoreCase("s") || resposta.equalsIgnoreCase("n"))){
                System.out.print("Escolha uma opção válida(S/N): ");
                resposta = input.nextLine();
                if (resposta == null)
                    resposta = input.nextLine();
            }
        }
        for (int c = 1; c < 14; c++){
            System.out.println(c + "º Rodada");
            for (Jogador jogador: listaJogadores) {
                ArrayList<Integer> listaDados = new ArrayList<>();
                while(listaDados.size() < 5) {
                    listaDados.add(Dado.girarDado());
                }
                SistemaRegistradorTabela.marcarTabela(listaDados, jogador);
                SistemaArquivarJogador.arquivarJogador(jogador);
            }
        }
        System.out.println("Após as 13 rodadas, calculando os pontos da partida, a classificação dos " +
                "jogadores fica:");
        exibirTabelaClassificacao();
    }
}
