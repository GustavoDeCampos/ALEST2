package implementacaoHash;

public class TabelaHashEncadeamentoSeparado {
    private final int CAPACIDADE_INICIAL = 5;
    private final double FATOR_DE_CARGA = 0.7;
    private int capacidade;
    private int tamanho;
    private Nodo[] tabela;

    public TabelaHashEncadeamentoSeparado() {
        capacidade = CAPACIDADE_INICIAL;
        tabela = new Nodo[capacidade];
    }

    private int funcaoHash(int chave) {
        return chave % capacidade;
    }

    public void adicionar(int chave, String valor) {
        //IMPLEMENTAR SOLUCAO PARA QUANDO O TAMANHO EXCEDER O FATOR DE CARGA * CAPACIDADE
        if(tamanho>=capacidade*FATOR_DE_CARGA) {

            duplicarTabelaHash();
        }

        Nodo n = new Nodo(chave, valor);
        int posicao = funcaoHash(n.getChave());

        if(tabela[posicao]==null) {
            tabela[posicao] = n;
        }
        else {
            n.setProximo(tabela[posicao]);
            tabela[posicao] = n;
        }
        tamanho++;
    }

    private void duplicarTabelaHash() {
        System.out.println("Duplicando tabela hash");
        Nodo[] tabelaAntiga = tabela;
        capacidade = capacidade * 2;
        tabela = new Nodo[capacidade];
        tamanho = 0;
        
        for(int i=0; i<tabelaAntiga.length; i++) {
            Nodo n = tabelaAntiga[i];
            while(n!=null) {
                adicionar(n.getChave(), n.getValor());
                n = n.getProximo();
            }
        }
    }

    public String buscar(int chave) {
        int posicao = funcaoHash(chave);
        Nodo n = tabela[posicao];

        while (n != null) {
            if (n.getChave() == chave) {
                return n.getValor();
            }
            n = n.getProximo();
        }
        return null;
    }

    public void remover(int chave) {
        //IMPLEMENTAR
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < capacidade; i++) {
            Nodo n = tabela[i];
            sb.append(System.lineSeparator()).append(i).append(" - ");
            while(n!=null) {
                sb.append(i).append(" - ").append(n);
                n = n.getProximo();
            }
        }
        return sb.toString();
    }
}