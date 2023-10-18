import java.util.List;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import contenido.Serie;
import contenido.Pelicula;
import contenido.Contenido;

public class Principal {
    public static void main(String[] args) throws Exception {
        // inicializaciones//
        String opcionMenu;
        int opcionMenuInt = -1;
        Scanner teclado = new Scanner(System.in);
        Netflix n = new Netflix();
        List<Contenido> contenidos = leerFichero2("Contenido.csv");
        n.addContenido(contenidos);

        do {
            System.out.println("\n¿Qué consulta quiere realizar?");
            System.out.println("1- Mostrar Contenido.");
            System.out.println("2- Realizar un Promoción.");
            System.out.println("3- Mostrar Promociones");
            System.out.println("4- Mostrar coste de todas la promociones realizadas.");
            System.out.println("5- Calcular coste de la promoción de una película o serie en concreto.");
            System.out.println("6- Calcular coste de una campaña masiva de Marketing.");
            System.out.println("7- Calcular la subvención que se obtiene a partir de las películas o series.");
            System.out.println("0- Salir del programa.");
            opcionMenu = teclado.nextLine();
            if (n.esNumeroException(opcionMenu)) {
                opcionMenuInt = Integer.parseInt(opcionMenu);
                // Menu 1//
                switch (opcionMenuInt) { // Todos los metodos se encuentran el la clase Netflix
                    case 0:
                        System.out.println("\nSaliendo del programa...\n"); // Salir del programa
                        break;
                    case 1:
                        System.out.println("----Contenido----\n");
                        n.mostrarContenido(); // Mostrar Contenido
                        break;
                    case 2:
                        System.out.println("----Realizar promoción----\n");
                        n.crearPromocionContenido(); // Realizamos Promocion
                        break;
                    case 3:
                        System.out.println("----Promociones----\n");
                        n.mostrarPromociones(); // Mostramos Promociones
                        break;
                    case 4:
                        System.out.println("----Costes de promociones----\n");
                        n.mostrarCostes(); // Mostramos todos los costes
                        break;
                    case 5:
                        System.out.println("----Costes individuales----\n");
                        n.obtenerCostePromocion(); // Mostramos Costes Individuales
                        break;
                    case 6:
                        System.out.println("----Campaña masiva de marketing----\n");
                        n.contadorPromociones(); // Mostramos costes de una campaña masiva de Marketing
                        break;
                    case 7:
                        System.out.println("----Subvenciones----\n");
                        n.calcularSubvenciones(); // Calculamos Subvenciones
                        break;
                    default:
                        System.out.println("Elige una opcion correcta."); // Opcion Incorrecta
                        break;
                }
            }
        } while (opcionMenuInt != 0);
        teclado.close();
    }

    // Metodo Leer Fichero para sacar el contenido de Contenido.csv
    private static ArrayList<Contenido> leerFichero2(String fichero) throws IOException {
        ArrayList<Contenido> contenidos = new ArrayList<Contenido>();
        String titulo, descripcion, tipoContenido, productora, pais;
        int año, duracion, nTemporadas, nCapitulos;
        boolean tendencia;
        Contenido contenido;
        String line;
        try (BufferedReader br = new BufferedReader(new FileReader(fichero))) {
            while ((line = br.readLine()) != null) {
                String[] split = line.split(";");
                tipoContenido = split[0];
                titulo = split[1].toUpperCase();
                año = Integer.valueOf(split[2]);
                duracion = Integer.valueOf(split[3]);
                descripcion = split[4];
                tendencia = Boolean.valueOf(split[5]);

                // Informacion de una Pelicula
                if (tipoContenido.charAt(0) == 's') {
                    nTemporadas = Integer.valueOf(split[6]);
                    nCapitulos = Integer.valueOf(split[7]);
                    contenido = new Serie(titulo, duracion, año, descripcion, tendencia, nTemporadas, nCapitulos);
                }
                // Informacion de una Pelicula
                else {
                    productora = split[6];
                    pais = split[7];
                    contenido = new Pelicula(titulo, duracion, año, descripcion, tendencia, productora, pais);
                }
                contenidos.add(contenido);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return contenidos;
    }
}