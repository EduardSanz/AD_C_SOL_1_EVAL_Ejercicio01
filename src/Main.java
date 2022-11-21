import Streams.AddObjetcsStream;
import modelos.Ordenador;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Ordenador> ordenadors = new ArrayList<>();
        try {
            do {
                int opcion = menu();

                switch (opcion) {
                    case 1:
                        ordenadors.add(crearOrdenador());
                        break;
                    case 2:
                        mostrarOrdenadores(ordenadors);
                        break;
                    case 3:
                        cargarOrdenadores(ordenadors);
                        break;
                    case 4:
                        escribirOrdenadores(ordenadors);
                }
            } while (true);
        }
        catch (Exception ex)
        {
            System.out.println("Algo se ha ido a la mierda");
        }
    }


    private static int menu() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("1. Crear Ordenador");
        System.out.println("2. Mostrar Ordenadores");
        System.out.println("3. Cargar Ordenadores");
        System.out.println("4. Guardar Ordenadores");

        return scanner.nextInt();
    }

    private static Ordenador crearOrdenador() {
        Ordenador ordenador = new Ordenador();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Dime el num serie");
        ordenador.setNumSerie(scanner.nextInt());
        scanner.nextLine();
        System.out.println("Dime la marca");
        ordenador.setMarca(scanner.nextLine());
        System.out.println("Dime el modelo");
        ordenador.setModelo(scanner.nextLine());
        System.out.println("Dime la RAM");
        ordenador.setRAM(scanner.nextInt());
        System.out.println("Dime el SSD");
        ordenador.setSSD(scanner.nextFloat());
        return ordenador;
    }

    private static void mostrarOrdenadores(ArrayList<Ordenador> ordenadors) {
        for (Ordenador o : ordenadors) {
            System.out.println(o);
        }
    }

    private static void cargarOrdenadores(ArrayList<Ordenador> ordenadors) throws IOException, ClassNotFoundException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Dime el nombre del fichero");
        File fichero = new File(scanner.nextLine()+".dat");
        if (fichero.exists()){
            ordenadors.clear();

            FileInputStream fis = new FileInputStream(fichero);
            ObjectInputStream ois = new ObjectInputStream(fis);
            try {
                while (true) {
                    Ordenador ordenador = (Ordenador) ois.readObject();
                    ordenadors.add(ordenador);
                }
            }
            catch (EOFException ignored){}
        }
    }

    private static void escribirOrdenadores(ArrayList<Ordenador> ordenadors) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Dime el nombre del fichero");
        File fichero = new File(scanner.nextLine()+".dat");

        boolean existe = fichero.exists();

        ObjectOutputStream oos;

        if (existe) {
            System.out.println("Quieres Sobreescribir el fichero (yes/no) default yes");
            String respuesta = scanner.nextLine();

            if (respuesta.equalsIgnoreCase("no")) {
                oos = new AddObjetcsStream(new FileOutputStream(fichero, true));
            }
            else {
                oos = new ObjectOutputStream(new FileOutputStream(fichero, false));
            }
        }else {
            oos = new ObjectOutputStream(new FileOutputStream(fichero, false));
        }

        for (Ordenador o : ordenadors) {
            oos.writeObject(o);
        }

        oos.close();
    }
}