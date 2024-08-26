public class Main {
    public static void main(String[] args) {

        final int LIMITE_INFERIOR = 5_000;
        final int LIMITE_SUPERIOR = 6000;
        final int INCREMENTO = 100;

        int[] myArray;
        int[] myArrayBubble;
        int[] myArrayInsertion;
        int[] myArrayQuick;
        int[] myArrayMerge;

        System.out.println("N;BubbleSort;InsertionSort;QuickSort;MergeSort");
        for (int n = LIMITE_INFERIOR; n <= LIMITE_SUPERIOR; n += INCREMENTO) {
            myArray = new int[n];
            myArrayBubble = new int[n];
            myArrayInsertion = new int[n];
            myArrayQuick = new int[n];
            myArrayMerge = new int[n];

            ArrayUtils.preencherArrayComValoresInteirosAleatorios(myArray, LIMITE_SUPERIOR, false);

            ArrayUtils.clonarArray(myArray, myArrayBubble);
            ArrayUtils.clonarArray(myArray, myArrayInsertion);
            ArrayUtils.clonarArray(myArray, myArrayQuick);
            ArrayUtils.clonarArray(myArray, myArrayMerge);

            BubbleSort bs = new BubbleSort();
            bs.ordenar(myArrayBubble);

            InsertionSort is = new InsertionSort();
            is.ordenar(myArrayInsertion);

            QuickSort qs = new QuickSort();
            qs.ordenar(myArrayQuick);

            MergeSort ms = new MergeSort();
            ms.ordenar(myArrayMerge);

            System.out.println(n + ";" + bs.getOperacoes() + ";" + is.getOperacoes() + ";" + qs.getOperacoes() + ";" + ms.getOperacoes());
            
        }

        System.out.println("Fim do programa");
    }
}
