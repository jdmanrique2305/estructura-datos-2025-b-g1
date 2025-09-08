public class ejercicio1 {
      public static void main(String[] args) {
        ListaSimple lista = new ListaSimple();

        lista.insertarFinal(10);
        lista.insertarFinal(20);
        lista.insertarInicio(5);
        lista.insertarFinal(30);

        System.out.println("Contenido de la lista:");
        lista.mostrarLista();  
    }
}

    