import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class SistemaArquivarJogador {

    public static void criarPastadeJogadores(String nomePasta){
        File file = new File(SistemaExtrairCaminhoArquivo.extrairCaminhoArquivo(nomePasta) +
                "/src/" + nomePasta);
        if (!file.exists())
            file.mkdir();
    }
    public static void arquivarJogador(Jogador jogador) throws IOException {
        FileWriter escritorArquivo = new FileWriter(jogador.getCaminhoArquivo());
        escritorArquivo.write(jogador.getNome() + "\n");
        for (int c = 1; c < 14; c++){
            escritorArquivo.write(jogador.pegarValorCategorias(c) + "\n");
        }
        escritorArquivo.write(jogador.getPontuacaoTotal() + "\n");
        escritorArquivo.close();
    }
}
