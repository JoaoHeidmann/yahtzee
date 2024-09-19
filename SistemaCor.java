public class SistemaCor {
    public static final String CORVERDE = "\u001B[32m";
    public static final String CORAMARELA = "\u001B[33m";
    public static final String CORVERMELHA = "\u001B[31m";
    public static final String CORROXA = "\u001B[35m";
    public static final String CORCIANA = "\u001B[36m";

    public static final String CORAZUL = "\u001B[34m";
    public static final String RESETACOR = "\u001B[0m";

public static void exibicaoCores(){
    System.out.println(CORVERMELHA + "1 - Vermelho;");
    System.out.println(CORVERDE + "2 - Verde;");
    System.out.println(CORAMARELA + "3 - Amarela;");
    System.out.println(CORAZUL + "4 - Azul;");
    System.out.println(CORROXA + "5 - Roxo;");
    System.out.println(CORCIANA + "6 - Ciano;");
    System.out.println(RESETACOR + "7 - Branco(Padrão);");
}

public static String selecionarCor(int opcao){
    switch (opcao){
        case 1:
            return CORVERMELHA;
        case 2:
            return CORVERDE;
        case 3:
            return CORAMARELA;
        case 4:
            return CORAZUL;
        case 5:
            return CORROXA;
        case 6:
            return CORCIANA;
        default:
            return RESETACOR;
    }
}
}
