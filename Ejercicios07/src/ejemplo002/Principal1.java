/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejemplo002;
/**
 *
 * @author reroes
 */
public class Principal1 {

    public static void main(String[] args) {

        String[] nombres = {"Jason", "Jonathan", "Kristen", "Robin",
            "Michelle", "Emily", "Noah", "Daniel"};
        String[] apellidos = {"Lynch", "George", "Lang", "Cochran",
            "Young", "Fletcher", "Adkins", "Harris"};
        int[][] notas = {{10, 80, 80, 95}, {40, 80, 80, 45},
        {80, 10, 20, 55}, {70, 30, 20, 65},
        {60, 50, 70, 75}, {50, 70, 30, 85},
        {40, 80, 40, 45}, {30, 90, 50, 95}};

        double promedio_paralelo = obtenerPromedioParalelo(notas);
        String nombre;
        String apellido;
        String tipoNotas;
        String email;
        int notaBaja;
        int notaAlta;

        double promedioEstudiante;
        int numeroNotasArribaPromedio;
        int[] filaNotas;
        String mensajeFinal = "";
        for (int i = 0; i < nombres.length; i++) {
            nombre = nombres[i];
            apellido = apellidos[i];
            filaNotas = notas[i];
            promedioEstudiante = funcion01(filaNotas);
            numeroNotasArribaPromedio = funcion02(filaNotas,
                    promedio_paralelo);
            email = crearUsuario(nombre, apellido);
            notaBaja = crearnotaBaja(filaNotas);
            notaAlta = crearnotaAlta(filaNotas);
            tipoNotas = funcion03(filaNotas);
            mensajeFinal = String.format("%s%s\n",
                    mensajeFinal,
                    presentarReporte(nombre, apellido, email, tipoNotas,
                            promedioEstudiante, numeroNotasArribaPromedio, 
                            notaBaja, notaAlta));
        }

        /*
        A mensaje final mediante un string forat le damos dos valores
        mensajefinal y presentar reporte, luego dentro delm presentar reporte
        le enviamos todos los valores, en este caso 5
         */
        CrearArchivoTexto.agregarRegistros(mensajeFinal);
        /*
        aqui en cambio llamamos a la clase crear etc y utilizamos la funcion 
        agregarregistro
        y le enviamos mensaje final
        
        
        
        
         */

    }

    public static String presentarReporte(String nom, String ap, String email, 
            String notas,
            double prom, int numeroNotas, int notaB, int a) {
        String reporte = String.format("Nombres: %s\n"
                + "Apellidos: %s\n"
                + "username: %s\n"
                + "Con notas: \n"
                + "%s\n"
                + "Promedio - %2f\n"
                + "Número de notas arriba del promedio: %d\n"
                + "Nota mas baja: %d\n"
                + "Nota mas alta: %d\n",
                nom, ap, email, notas, prom, numeroNotas, notaB, a);

        return reporte;
    }

    public static String crearUsuario(String nom, String ap) {
        String email = "";

        String nombre = nom.toLowerCase();
        nombre = nombre.substring(0, 1);
        String apellido = ap.toLowerCase();
        email = String.format("%s%s.%s@ytpl.edu.ec", email,
                nombre,
                apellido);

        return email;
    }

    public static int crearnotaBaja(int[] notas) {
        int notaBaja;
        notaBaja = notas[0];
        for (int i = 0; i < notas.length; i++) {
            if (notas[i] < notaBaja) {
                notaBaja = notas[i];

            }
        }
        return notaBaja;
    }

    public static int crearnotaAlta(int[] notas) {
        int notaBaja;
        notaBaja = notas[0];
        for (int i = 0; i <notas.length; i++) {
            if (notas[i] > notaBaja) {
                notaBaja = notas[i];

            }
        }
        return notaBaja;

    }

    public static double obtenerPromedioParalelo(int[][] n) {
        int suma = 0;
        double promedio;
        int contador = 0;
        for (int i = 0; i < n.length; i++) {
            for (int j = 0; j < n[0].length; j++) {
                suma = suma + n[i][j];
                contador = contador + 1;
            }
        }

        promedio = (double) suma / contador;
        return promedio;
    }

    public static double funcion01(int[] notas) {
        int suma = 0;
        double promedio;
        for (int i = 0; i < notas.length; i++) {
            suma = suma + notas[i];
        }
        promedio = (double) suma / notas.length;
        return promedio;
    }

    public static int funcion02(int[] notas, double promedio) {

        int contador = 0;
        int nota;
        for (int i = 0; i < notas.length; i++) {
            nota = notas[i];
            if (nota > promedio) {
                contador = contador + 1;
            }

        }

        return contador;
    }

    public static String funcion03(int[] notas) {
        String cadena = "";

        int nota;
        for (int i = 0; i < notas.length; i++) {
            nota = notas[i];
            if (nota >= 0 && nota <= 20) {
                cadena = String.format("%s%d-%s\n", cadena, nota, "M");
            } else {
                if (nota > 20 && nota <= 50) {
                    cadena = String.format("%s%d-%s\n", cadena, nota, "MB");
                } else {
                    if (nota > 50) {
                        cadena = String.format("%s%d-%s\n", cadena, nota, "S");
                    }
                }
            }

        }

        return cadena;
    }

}
