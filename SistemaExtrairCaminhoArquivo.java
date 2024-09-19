import java.io.File;

public class SistemaExtrairCaminhoArquivo {
    public static String extrairCaminhoArquivo(String nomeArquivo){
        File file = new File(nomeArquivo);
        String caminhoCompleto = file.getAbsolutePath();
        int indiceBarra = caminhoCompleto.lastIndexOf("\\") + 1;
        if (indiceBarra == 0) {
            indiceBarra = caminhoCompleto.lastIndexOf("/") + 1;
        }
        String caminhoPasta = caminhoCompleto.substring(0, indiceBarra);
        return caminhoPasta.replace("\\", "/");
    }
}
