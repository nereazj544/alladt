package alladt.MongoDB;

import java.util.Scanner;

public class PreubaArraySC {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Introduce el tamaño del array:");
        int size = scanner.nextInt();
        String[] array = new String[size];

        System.out.println("Introduce los elementos del array:");
        for (int i = 0; i < array.length; i++) {
            array[i] = scanner.nextLine();
        }

        scanner.close();

        System.out.println("El array introducido es:");
        for (String i : array) {
            System.out.println(i);
        }
    }
}
