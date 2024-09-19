import java.io.FileWriter;
import java.io.IOException;

public class Jogador implements Comparable<Jogador> {
    private String nome,
    caminhoArquivo,
    corTabela;
    private int pontuacaoUns = -1,
    pontuacaoDois = -1,
    pontuacaoTres = -1,
    pontuacaoQuatros = -1,
    pontuacaoCincos = -1,
    pontuacaoSeis = -1,
    pontuacaoBonus = -63,
    pontuacaoTrinca = -1,
    pontuacaoQuadra = -1,
    pontuacaoFullHouse = -1,
    pontuacaoSequenciaCurta = -1,
    pontuacaoSequenciaLonga = -1,
    pontuacaoYahtzee = -1,
    pontuacaoSorte = -1,
    pontuacaoTotal = 0;

    private boolean bonus = false;
    public Jogador(String nome, String corTabela) throws IOException {
        this.nome = nome;
        this.corTabela = corTabela;
        StringBuilder nomeArquivo = new StringBuilder("jogador");
        String[] nomeFatiado = nome.split(" ");
        for (String palavra: nomeFatiado){
            if (nomeFatiado[nomeFatiado.length - 1].equalsIgnoreCase(palavra)) {
                nomeArquivo.append(palavra).append(".txt");
            } else {
                nomeArquivo.append(palavra);
            }
        }
        this.caminhoArquivo = SistemaExtrairCaminhoArquivo.extrairCaminhoArquivo("ArquivoJogadores") +
                "src/ArquivoJogadores/" + nomeArquivo;
        FileWriter registrador = new FileWriter(caminhoArquivo);
        registrador.write(this.nome);
        registrador.close();
    }

    @Override
    public int compareTo(Jogador pJogador) {
        return (pJogador.getPontuacaoTotal() - this.pontuacaoTotal);
    }

    public String getNome() {
        return nome;
    }
    public String getCaminhoArquivo() {
        return caminhoArquivo;
    }

    public String getCorTabela(){
        return corTabela;
    }

    public int getPontuacaoUns() {
        return pontuacaoUns;
    }

    public boolean setPontuacaoUns(int pontuacaoUns) {
        if (this.pontuacaoUns == -1) {
            this.pontuacaoUns = pontuacaoUns;
            return true;
        }
        return false;
    }

    public int getPontuacaoDois() {
        return pontuacaoDois;
    }

    public boolean setPontuacaoDois(int pontuacaoDois) {
        if (this.pontuacaoDois == -1) {
            this.pontuacaoDois = pontuacaoDois;
            return true;
        }
        return false;
    }

    public int getPontuacaoTres() {
        return pontuacaoTres;
    }

    public boolean setPontuacaoTres(int pontuacaoTres) {
        if (this.pontuacaoTres == -1) {
            this.pontuacaoTres = pontuacaoTres;
            return true;
        }
        return false;
    }

    public int getPontuacaoQuatros() {
        return pontuacaoQuatros;
    }

    public boolean setPontuacaoQuatros(int pontuacaoQuatros) {
        if (this.pontuacaoQuatros == -1) {
            this.pontuacaoQuatros = pontuacaoQuatros;
            return true;
        }
        return false;
    }

    public int getPontuacaoCincos() {
        return pontuacaoCincos;
    }

    public boolean setPontuacaoCincos(int pontuacaoCincos) {
        if (this.pontuacaoCincos == -1) {
            this.pontuacaoCincos = pontuacaoCincos;
            return true;
        }
        return false;
    }

    public int getPontuacaoSeis() {
        return pontuacaoSeis;
    }

    public boolean setPontuacaoSeis(int pontuacaoSeis) {
        if (this.pontuacaoSeis == -1) {
            this.pontuacaoSeis = pontuacaoSeis;
            return true;
        }
        return false;
    }

    public int getPontuacaoBonus(){
        if (this.pontuacaoBonus >= 0)
            return 35;
        return this.pontuacaoBonus;
    }

    public void setPontuacaoBonus(int pontos){
        this.pontuacaoBonus += pontos;
    }
    public int getPontuacaoTrinca() {
        return pontuacaoTrinca;
    }

    public boolean setPontuacaoTrinca(int pontuacaoTrinca) {
        if (this.pontuacaoTrinca == -1) {
            this.pontuacaoTrinca = pontuacaoTrinca;
            return true;
        }
        return false;
    }

    public int getPontuacaoQuadra() {
        return pontuacaoQuadra;
    }

    public boolean setPontuacaoQuadra(int pontucaoQuadra) {
        if (this.pontuacaoQuadra == -1) {
            this.pontuacaoQuadra = pontucaoQuadra;
            return true;
        }
        return false;
    }

    public int getPontuacaoFullHouse() {
        return pontuacaoFullHouse;
    }

    public boolean setPontuacaoFullHouse(int pontuacaoFullHouse) {
        if (this.pontuacaoFullHouse == -1) {
            this.pontuacaoFullHouse = pontuacaoFullHouse;
            return true;
        }
        return false;
    }

    public int getPontuacaoSequenciaCurta() {
        return pontuacaoSequenciaCurta;
    }

    public boolean setPontuacaoSequenciaCurta(int pontuacaoSequenciaCurta) {
        if (this.pontuacaoSequenciaCurta == -1) {
            this.pontuacaoSequenciaCurta = pontuacaoSequenciaCurta;
            return true;
        }
        return false;
    }

    public int getPontuacaoSequenciaLonga() {
        return pontuacaoSequenciaLonga;
    }

    public boolean setPontuacaoSequenciaLonga(int pontuacaoSequenciaLonga) {
        if (this.pontuacaoSequenciaLonga == -1) {
            this.pontuacaoSequenciaLonga = pontuacaoSequenciaLonga;
            return true;
        }
        return false;
    }

    public int getPontuacaoYahtzee() {
        return pontuacaoYahtzee;
    }

    public boolean setPontuacaoYahtzee(int pontuacaoYahtzee) {
        if (this.pontuacaoYahtzee == -1) {
            this.pontuacaoYahtzee = pontuacaoYahtzee;
            return true;
        }
        return false;
    }



    public int getPontuacaoSorte() {
        return pontuacaoSorte;
    }

    public boolean setPontuacaoSorte(int pontuacaoSorte) {
        if (this.pontuacaoSorte == -1) {
            this.pontuacaoSorte = pontuacaoSorte;
            return true;
        }
        return false;
    }

    public int getPontuacaoTotal(){
        return pontuacaoTotal;
    }

    public void setPontuacaTotal(int pontos){
        pontuacaoTotal += pontos;
        if (!bonus && pontuacaoBonus >= 0){
            bonus = true;
            pontuacaoTotal += 35;
        }
    }

    public int pegarValorCategorias(int categoria){
        switch (categoria){
            case 1:
                return getPontuacaoUns();
            case 2:
                return getPontuacaoDois();
            case 3:
                return getPontuacaoTres();
            case 4:
                return getPontuacaoQuatros();
            case 5:
                return getPontuacaoCincos();
            case 6:
                return getPontuacaoSeis();
            case 7:
                return getPontuacaoTrinca();
            case 8:
                return getPontuacaoQuadra();
            case 9:
                return getPontuacaoFullHouse();
            case 10:
                return getPontuacaoSequenciaCurta();
            case 11:
                return getPontuacaoSequenciaLonga();
            case 12:
                return getPontuacaoYahtzee();
            case 13:
                return getPontuacaoSorte();
            default:
                return -1;
        }
    }
    public boolean registrarCategoria(int categoria, int pontuacao){
        switch (categoria){
            case 1:
                return setPontuacaoUns(pontuacao);
            case 2:
                return setPontuacaoDois(pontuacao);
            case 3:
                return setPontuacaoTres(pontuacao);
            case 4:
                return setPontuacaoQuatros(pontuacao);
            case 5:
                return setPontuacaoCincos(pontuacao);
            case 6:
                return setPontuacaoSeis(pontuacao);
            case 7:
                return setPontuacaoTrinca(pontuacao);
            case 8:
                return setPontuacaoQuadra(pontuacao);
            case 9:
                return setPontuacaoFullHouse(pontuacao);
            case 10:
                return setPontuacaoSequenciaCurta(pontuacao);
            case 11:
                return setPontuacaoSequenciaLonga(pontuacao);
            case 12:
                return setPontuacaoYahtzee(pontuacao);
            case 13:
                return setPontuacaoSorte(pontuacao);
            default:
                return false;
        }
    }
}
