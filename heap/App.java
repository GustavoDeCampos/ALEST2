package heap;

public class App {
    public static void main(String[] args) {
        HeapMaximo heap = new HeapMaximo();
        heap.inserir(40);
        heap.inserir(32);
        heap.inserir(15);
        heap.inserir(35);
        heap.inserir(18);
        heap.inserir(8);
        heap.inserir(79);

        System.out.println(heap.remover());
        heap.imprimir();
    }
}
