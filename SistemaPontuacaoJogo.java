import java.util.ArrayList;
import java.util.Scanner;

public class SistemaPontuacaoJogo {
    public static Scanner input = new Scanner(System.in);
    public static ArrayList<Integer> construirListaNumeros(ArrayList<Integer> listaDosDados) {
        int numeroUm = 0;
        int numeroDois = 0;
        int numeroTres = 0;
        int numeroQuatro = 0;
        int numeroCinco = 0;
        int numeroSeis = 0;

        for (Integer valorDado : listaDosDados) {
            switch (valorDado) {
                case 1:
                    numeroUm += 1;
                    break;
                case 2:
                    numeroDois += 1;
                    break;
                case 3:
                    numeroTres += 1;
                    break;
                case 4:
                    numeroQuatro += 1;
                    break;
                case 5:
                    numeroCinco += 1;
                    break;
                case 6:
                    numeroSeis += 1;
                    break;
            }
        }
        ArrayList<Integer> lista = new ArrayList<>();
        lista.add(numeroUm);
        lista.add(numeroDois);
        lista.add(numeroTres);
        lista.add(numeroQuatro);
        lista.add(numeroCinco);
        lista.add(numeroSeis);
        return lista;
    }

    public static String escolherVerificacao(ArrayList<Integer> listaQuantidadeDados, int operacao,
                                              Jogador jogador, boolean adicionarCor){
        switch (operacao) {
            case 1:
                return verificarUns(listaQuantidadeDados,jogador, adicionarCor );
            case 2:
                return verificarDois(listaQuantidadeDados,jogador, adicionarCor);
            case 3:
                return verificarTres(listaQuantidadeDados,jogador, adicionarCor);
            case 4:
                return verificarQuatros(listaQuantidadeDados,jogador, adicionarCor);
            case 5:
                return verificarCincos(listaQuantidadeDados,jogador, adicionarCor);
            case 6:
                return verificarSeis(listaQuantidadeDados,jogador, adicionarCor);
            case 7:
                return verificarTrinca(listaQuantidadeDados,jogador, adicionarCor);
            case 8:
                return verificarQuadra(listaQuantidadeDados,jogador, adicionarCor);
            case 9:
                return verificarFullHouse(listaQuantidadeDados,jogador, adicionarCor);
            case 10:
                return verificarSequenciaCurta(listaQuantidadeDados,jogador, adicionarCor);
            case 11:
                return verificarSequenciaLonga(listaQuantidadeDados,jogador, adicionarCor);
            case 12:
                return verificarYahtzee(listaQuantidadeDados,jogador, adicionarCor);
            case 13:
                return verificarSorte(listaQuantidadeDados,jogador, adicionarCor);
            default:
                return "" + -1;
        }
    }
    public static String verificarUns(ArrayList<Integer> listaQuantidadeDados, Jogador jogador,
                                      boolean color){
        if (!color)
            return String.valueOf(listaQuantidadeDados.get(0));
        if (jogador.getPontuacaoUns() != -1)
            return SistemaCor.CORAMARELA + jogador.getPontuacaoUns() + " pts" + SistemaCor.RESETACOR;
        return SistemaCor.CORVERDE + "+" + listaQuantidadeDados.get(0) + " pts" + SistemaCor.RESETACOR;
    }

    public static String verificarDois(ArrayList<Integer> listaQuantidadeDados, Jogador jogador,
                                       boolean color){
        if (!color)
            return String.valueOf(listaQuantidadeDados.get(1) * 2);
        if (jogador.getPontuacaoDois() != -1)
            return SistemaCor.CORAMARELA + jogador.getPontuacaoDois() + " pts" + SistemaCor.RESETACOR;
        return SistemaCor.CORVERDE + "+" + listaQuantidadeDados.get(1) * 2 + " pts" + SistemaCor.RESETACOR;

    }

    public static String verificarTres(ArrayList<Integer> listaQuantidadeDados, Jogador jogador,
                                       boolean color){
        if (!color)
            return String.valueOf(listaQuantidadeDados.get(2) * 3);
        if (jogador.getPontuacaoTres() != -1)
            return SistemaCor.CORAMARELA + jogador.getPontuacaoTres() + " pts" + SistemaCor.RESETACOR;
        return SistemaCor.CORVERDE + "+" + listaQuantidadeDados.get(2) * 3 + " pts" + SistemaCor.RESETACOR;
    }

    public static String verificarQuatros(ArrayList<Integer> listaQuantidadeDados, Jogador jogador,
                                          boolean color){
        if (!color)
            return String.valueOf(listaQuantidadeDados.get(3) * 4);
        if (jogador.getPontuacaoQuatros() != -1)
            return SistemaCor.CORAMARELA + jogador.getPontuacaoQuatros() + " pts" + SistemaCor.RESETACOR;
        return SistemaCor.CORVERDE + "+" + listaQuantidadeDados.get(3) * 4 + " pts" + SistemaCor.RESETACOR;
    }

    public static String verificarCincos(ArrayList<Integer> listaQuantidadeDados, Jogador jogador,
                                         boolean color){
        if (!color)
            return String.valueOf(listaQuantidadeDados.get(4) * 5);
        if (jogador.getPontuacaoCincos() != -1)
            return SistemaCor.CORAMARELA + jogador.getPontuacaoCincos() + " pts" + SistemaCor.RESETACOR;
        return SistemaCor.CORVERDE +  "+" + listaQuantidadeDados.get(4) * 5 + " pts" + SistemaCor.RESETACOR;
    }

    public static String verificarSeis(ArrayList<Integer> listaQuantidadeDados, Jogador jogador,
                                       boolean color){
        if (!color)
            return String.valueOf(listaQuantidadeDados.get(5) * 6);
        if (jogador.getPontuacaoSeis() != -1)
            return SistemaCor.CORAMARELA + jogador.getPontuacaoSeis() + " pts" + SistemaCor.RESETACOR;
        return SistemaCor.CORVERDE + "+" + listaQuantidadeDados.get(5) * 6 + " pts" + SistemaCor.RESETACOR;
    }
    public static String verificarFullHouse(ArrayList<Integer> listaQuantidadeDados, Jogador jogador,
                                            boolean color){
       int pontuacao = 0;
        if (listaQuantidadeDados.contains(3) && listaQuantidadeDados.contains(2))
            pontuacao = 25;
        if (!color)
            return String.valueOf(pontuacao);
        if (jogador.getPontuacaoFullHouse() != -1)
            return SistemaCor.CORAMARELA + jogador.getPontuacaoFullHouse() + " pts" + SistemaCor.RESETACOR;
        return SistemaCor.CORVERDE + "+" + pontuacao + " pts" + SistemaCor.RESETACOR;
    }

    public static String verificarQuadra(ArrayList<Integer> listaQuantidadeDados, Jogador jogador,
                                         boolean color){
        int pontuacao = 0;
        if (listaQuantidadeDados.contains(4)){
            for (int index = 0; index < 6; index++) {
                pontuacao += (index + 1)  * (listaQuantidadeDados.get(index));
            }
        }
        if (!color)
            return String.valueOf(pontuacao);
        if (jogador.getPontuacaoQuadra() != -1)
            return SistemaCor.CORAMARELA + jogador.getPontuacaoQuadra() + " pts" + SistemaCor.RESETACOR;
        return SistemaCor.CORVERDE + "+" + pontuacao + " pts" + SistemaCor.RESETACOR;
    }

    public static String verificarTrinca(ArrayList<Integer> listaQuantidadeDados, Jogador jogador,
                                         boolean color){

        int pontuacao = 0;
        if (listaQuantidadeDados.contains(3)){
            for (int index = 0; index < 6; index++) {
                pontuacao += (index + 1)  * (listaQuantidadeDados.get(index));
            }
        }
        if (!color)
            return String.valueOf(pontuacao);
        if (jogador.getPontuacaoTrinca() != -1)
            return SistemaCor.CORAMARELA + jogador.getPontuacaoTrinca() + " pts" + SistemaCor.RESETACOR;
        return SistemaCor.CORVERDE + "+" + pontuacao + " pts" + SistemaCor.RESETACOR;
    }

    public static String verificarSequenciaLonga(ArrayList<Integer> listaQuantidadeDados, Jogador jogador,
                                                 boolean color){

        int pontuacao = 0;
        for (int c = 0; c < 2; c++){
            if (listaQuantidadeDados.get(c) != 0) {
                pontuacao = 40;
                for (int i = c + 1; i < 5 + c; i++){
                    if (listaQuantidadeDados.get(i) == 0) {
                        pontuacao = 0;
                        break;
                    }
                }
            }
            if (pontuacao == 40)
                break;
        }
        if (!color)
            return String.valueOf(pontuacao);
        if (jogador.getPontuacaoSequenciaLonga() != -1)
            return SistemaCor.CORAMARELA + jogador.getPontuacaoSequenciaLonga() + " pts" +
                    SistemaCor.RESETACOR;
        return SistemaCor.CORVERDE + "+" + pontuacao + " pts" + SistemaCor.RESETACOR;
    }

    public static String verificarSequenciaCurta(ArrayList<Integer> listaQuantidadeDados, Jogador jogador,
                                                 boolean color){

        int pontuacao = 0;
        for (int c = 0; c < 3; c++){
            if (listaQuantidadeDados.get(c) != 0) {
                pontuacao = 30;
                for (int i = c + 1; i < 4 + c; i++){
                    if (listaQuantidadeDados.get(i) == 0) {
                        pontuacao = 0;
                        break;
                    }
                }
            }
            if (pontuacao == 30)
                break;
        }
        if (!color)
            return String.valueOf(pontuacao);
        if (jogador.getPontuacaoSequenciaCurta() != -1)
            return SistemaCor.CORAMARELA + jogador.getPontuacaoSequenciaCurta() + " pts" +
                    SistemaCor.RESETACOR;
        return SistemaCor.CORVERDE + "+" + pontuacao + " pts" + SistemaCor.RESETACOR;
    }
    public static String verificarYahtzee(ArrayList<Integer> listaQuantidadeDados, Jogador jogador,
                                          boolean color){

        int pontuacao = 0;
        if (listaQuantidadeDados.contains(5)){
           pontuacao = 50;
        }
        if (!color)
            return String.valueOf(pontuacao);
        if (jogador.getPontuacaoYahtzee() != -1)
            return SistemaCor.CORAMARELA + jogador.getPontuacaoYahtzee() + " pts" + SistemaCor.RESETACOR;
        return SistemaCor.CORVERDE + "+" + pontuacao + " pts" + SistemaCor.RESETACOR;
    }

    public static String verificarSorte(ArrayList<Integer> listaQuantidadeDados, Jogador jogador,
                                        boolean color){

        int pontuacao = 0;
            for (int index = 0; index < 6; index++) {
                pontuacao += (index + 1)  * (listaQuantidadeDados.get(index));
            }
        if (!color)
            return String.valueOf(pontuacao);
        if (jogador.getPontuacaoSorte() != -1)
            return SistemaCor.CORAMARELA + jogador.getPontuacaoSorte() + " pts" + SistemaCor.RESETACOR;
        return SistemaCor.CORVERDE + "+" + pontuacao + " pts" + SistemaCor.RESETACOR;
    }
}