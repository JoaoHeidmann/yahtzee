import java.io.IOException;
import java.util.ArrayList;

public class SistemaRegistradorTabela {
    public static void marcarTabela(ArrayList<Integer> listaDeDados, Jogador jogador) throws
            IOException, InterruptedException {
        int categoria = 0,
                mudancasDados = 0;
        ArrayList<Integer> listaQuantidadeDados = SistemaPontuacaoJogo.construirListaNumeros(listaDeDados);
        while (!jogador.registrarCategoria(categoria,
                Integer.parseInt(SistemaPontuacaoJogo.escolherVerificacao(
                        listaQuantidadeDados, categoria, jogador, false)))) {
            Menu.exibirDados(listaDeDados);
            Menu.exibirTabelaPontuacaoJogador(listaQuantidadeDados, jogador, true);
            System.out.print("Qual categoria deseja marcar(Digite -1 para modificar os dados)? ");
            categoria =  Menu.input.nextInt();
            while ((categoria < 1 || categoria > 13) && categoria != -1){
                System.out.print("Escolha uma opção de válida: ");
                categoria =  Menu.input.nextInt();
            }
            if (categoria == -1){
                Menu.modificarDados(listaDeDados, mudancasDados);
                listaQuantidadeDados = SistemaPontuacaoJogo.construirListaNumeros(listaDeDados);
                mudancasDados += 1;
            }
        }
        if (categoria >= 1 && categoria <= 6)
            jogador.setPontuacaoBonus(Integer.parseInt(SistemaPontuacaoJogo.escolherVerificacao(
                    listaQuantidadeDados, categoria, jogador, false
            )));
        jogador.setPontuacaTotal(Integer.parseInt(SistemaPontuacaoJogo.escolherVerificacao(
                listaQuantidadeDados, categoria, jogador, false)));

        System.out.println("A categoria foi marcada com sucesso");
        Thread.sleep(1000);
    }
}
