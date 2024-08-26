package heap;

import java.lang.reflect.Array;

public class HeapMaximo {
    private int capacidade = 20;
    private int tamanho;
    private int[] chaves;

    public HeapMaximo() {
        this.tamanho = 0;
        this.chaves = new int[capacidade];

        for (int i = 0; i < capacidade; i++) {
            chaves[i] = -1;
        }
    }
    
    public void inserir(int chave){
        chaves[tamanho] = chave;

        int posicao = tamanho;
        int pai = (tamanho - 1) / 2;

        while(chaves[posicao] > chaves[pai]){
            int temp = chaves[pai];
            chaves[pai] = chaves[posicao];
            chaves[posicao] = temp;

            posicao = pai;
            pai = (posicao - 1) / 2;
        }

        tamanho++;
        ArrayUtils.imprimir(chaves);
    }

    public int remover(){
        int prioritario = chaves[0];
        //trocar
        chaves[0] = chaves[tamanho - 1];
        chaves[tamanho - 1] = -1;
        tamanho--;
        afundar(0);
        return prioritario;
    }

    public void afundar(int posicao){

        int filhoEsquerda = 2 * posicao + 1;
        int filhoDireita = 2 * posicao + 2;

        int maiorFilho = filhoEsquerda;

        if(chaves[filhoDireita] > chaves[filhoEsquerda]){
            maiorFilho = filhoDireita;
        }

        if(chaves[posicao] < chaves[maiorFilho]){
            int temp = chaves[posicao];
            chaves[posicao] = chaves[maiorFilho];
            chaves[maiorFilho] = temp;
            afundar(maiorFilho);
        }
    }

    public void imprimir(){
        ArrayUtils.imprimir(chaves);
    }
}
