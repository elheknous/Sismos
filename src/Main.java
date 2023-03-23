import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        double[][] matrizSismos = new double[7][10];
        menu(matrizSismos);
    }

    private static void menu(double[][] matrizSismos) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Escoja una opcion: ");
        System.out.println("1- Ingresar datos");
        System.out.println("2- Mostrar sismo de mayor magnitud");
        System.out.println("3- Contar sismos mayores o iguales a 5.0");
        System.out.println("4- Enviar SMS por cada sismo mayor o igual a 7.0");
        System.out.println("5- Salir");
        int opcion = sc.nextInt();
        switch (opcion){
            case 1:
                matrizSismos = ingresarDatos(matrizSismos);
                menu(matrizSismos);
                break;
            case 2:
                boolean existenDatos = comprobacionDatos(matrizSismos);
                ejecutarAccion(matrizSismos,existenDatos);
                menu(matrizSismos);
                break;
            case 3:
                boolean existenDatos1 = comprobacionDatos(matrizSismos);
                ejecutarAccionMayor5(matrizSismos,existenDatos1);
                menu(matrizSismos);
                break;
            case 4:
                boolean existenDatos2 = comprobacionDatos(matrizSismos);
                advertencia(matrizSismos,existenDatos2);
                menu(matrizSismos);
                break;
            case 5:
                System.out.println("Hasta la proxima");

        }

    }

    private static void advertencia(double[][] matrizSismos, boolean existenDatos2) {
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 10; j++) {
                if (matrizSismos[i][j] >= 7.0){
                    System.out.println("Advertencia, evacuar, sismo de : "+matrizSismos[i][j] +" de intensidad");
                }
            }
        }
    }

    private static void ejecutarAccionMayor5(double[][] matrizSismos, boolean existenDatos1) {
        if (existenDatos1){
            System.out.println("Lo sentimos, no hay datos disponibles");
        }else {
            mostrarMayor5(matrizSismos);
        }
    }

    private static void ejecutarAccion(double[][] matrizSismos, boolean existenDatos) {
        if (existenDatos){
            System.out.println("Lo sentimos, no hay datos disponibles");
        }else {
            mostrarSismoMayor(matrizSismos);
        }
    }

    private static boolean comprobacionDatos(double[][] matrizSismos) {
        boolean respuesta = false;
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 10; j++) {
                if (matrizSismos[i][j] == 0.0) {
                    respuesta = true;
                }
            }
        }
        return respuesta;
    }

    private static void mostrarMayor5(double[][] matrizSismos) {
        int contador = 0;
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 10; j++) {
                if (matrizSismos[i][j] >= 5.0){
                    contador++;
                }
            }
        }
        System.out.println("La cantidad de sismos mayores a 5 son: "+contador);

    }

    private static void mostrarSismoMayor(double[][] matrizSismos) {
        double mayor = 0.0;
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 10; j++) {
                if (matrizSismos[i][j] > mayor){
                    mayor = matrizSismos[i][j];
                }

            }

        }
        System.out.println("El sismo de mayor magnitud fue de: "+ mayor);
    }

    private static double[][] ingresarDatos(double[][] matriz) {
        double [][] matrizSismos = new double[7][10];
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 10; j++) {
                matrizSismos[i][j] = Math.random()*10;
            }

        }
        imprimirMatriz(matrizSismos);


        return matrizSismos;
    }
    private static void imprimirMatriz(double[][] matriz) {
        String[] dia = {"Lunes","Martes","Miercoles","Jueves","Viernes","Sabado","Domingo"};

        for (int i = 0; i < 7; i++) {
            System.out.print(dia[i]+ ": ");
            for (int j = 0; j < 10; j++) {
                System.out.print("["+matriz[i][j]+"]");
            }
            System.out.println();
        }
    }
}