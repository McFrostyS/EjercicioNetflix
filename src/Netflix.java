import contenido.Serie;
import excepcion.ContenidoNoEncontrado;
import excepcion.EsNumero;
import excepcion.ExcedeDeDoce;
import excepcion.PromocionNoEncontrada;
import marketing.Ayuntamiento;
import marketing.EmpresaMarketing;
import marketing.Promocion;
import contenido.Pelicula;
import contenido.Contenido;
import java.util.*;

public class Netflix {
	// inicializacion //
	int contador = 0;
	double sumaCostes = 0.0;
	int idPromocion = 0;
	boolean error = false, respuesta = false;
	String titulo;

	private List<Contenido> contenidos = new ArrayList<Contenido>(); // Arraylist donde se encuentra todo el contenido//
	private List<Promocion> promociones = new ArrayList<Promocion>(); // Arraylist donde se encuentra todas las
																		// promociones//

	public void addContenido(List<Contenido> contenidos2) { // Añadimos el contenido al Arraylist
		contenidos.addAll(contenidos2);
	}

	public void mostrarContenido() { // Opcion 1 del menú//
		for (Contenido c : contenidos) {
			System.out.println(c.toString());
		}
	}

	public double realizarPromocion(Contenido contenido, String titulo, boolean puertaDelSol, boolean redesSociales) { // Metodo
																														// utilizado
																														// para
																														// obtener
																														// el
																														// coste
																														// de
																														// cada
																														// promoción//
		double coste = 0.0;
		int costePuertaDelSol, costeRedesSociales;
		double porcentaje;
		if (contenido instanceof Pelicula) { // PELICULA
			costePuertaDelSol = 40000;
			costeRedesSociales = 2000;
			porcentaje = 0.07;
			if (puertaDelSol == true && redesSociales == true) { // Puerta del sol SI y Redes sociales SI
				contador++;
				coste = costeRedesSociales + costePuertaDelSol;
				if (contenido.isTendencias() == true) { // Tendencias SI
					coste = (porcentaje * coste) + 42000;
				}
			} else if (puertaDelSol == false && redesSociales == false) { // Puerta del sol NO y Redes sociales NO
				contador++;
				coste = 0;
			} else if (puertaDelSol == true && redesSociales == false) { // Puerta del sol SI y Redes sociales NO
				contador++;
				coste = costePuertaDelSol;
				if (contenido.isTendencias() == true) { // Tendencias SI
					coste = (porcentaje * coste) + costePuertaDelSol;
				}
			} else { // Puerta del sol NO y Redes sociales SI
				contador++;
				coste = costeRedesSociales;
				if (contenido.isTendencias() == true) { // Tendencias SI
					coste = (porcentaje * coste) + costeRedesSociales;
				}
			}
		} else { // SERIE
			costePuertaDelSol = 700;
			costeRedesSociales = 300;
			porcentaje = 0.06;
			Serie serie = (Serie) contenido;
			if (puertaDelSol == true && redesSociales == true) { // Puerta del sol SI y Redes sociales SI
				int costeTemporadas, costeCapitulos;
				costeTemporadas = (costeRedesSociales * serie.getTemporadas());
				costeCapitulos = (costePuertaDelSol * serie.getCapitulos());
				coste = costeTemporadas + costeCapitulos;
				if (contenido.isTendencias() == true) { // Tendencias SI
					coste = (porcentaje * coste) + coste;
				}
			} else if (puertaDelSol == false && redesSociales == false) { // Puerta del sol NO y Redes sociales NO
				coste = 0;
			} else if (puertaDelSol == true && redesSociales == false) { // Puerta del sol SI y Redes sociales NO
				coste = costePuertaDelSol * serie.getCapitulos();
				if (contenido.isTendencias() == true) { // Tendencias SI
					coste = (porcentaje * coste) + coste;
				}
			} else { // Puerta del sol NO y Redes sociales SI
				System.out.println("Numero de temps: " + serie.getTemporadas());
				coste = costeRedesSociales * serie.getTemporadas();
				if (contenido.isTendencias() == true) { // Tendencias SI
					coste = (porcentaje * coste) + coste;
				}
			}
		}
		return coste;
	}

	public void crearPromocionContenido() { // Opción 2 del Menú
		// inicializacion //
		Contenido contenido = null;
		boolean redesSociales = false, puertaDelSol = false;
		String opcionMenu2;
		int opcionMenu2Int = -1;
		int i = 0;
		do {
			i = 0;
			do {
				Scanner teclado2 = new Scanner(System.in); // Teclado 2
				System.out.println("¿Que contenido quieres promocionar?");
				titulo = teclado2.nextLine().toUpperCase();

				// excepcion 1 //
				try {
					contenido = tituloExisteEnContenido(titulo);
					System.out.println("\nContenido seleccionado: " + titulo);
					error = false;
				} catch (ContenidoNoEncontrado ex) {
					System.out.println(ex.getMessage());
					error = true;
				}

				if (error == false) { // Menu de promociones
					System.out.println("\nEscoge una opción:");
					System.out.println("1- Realizar promoción a traves de las redes sociales.");
					System.out.println("2- Realizar promoción con un cartel en la Puerta del Sol");
					System.out.println("3- Realizar ambas promociones");
					Scanner teclado3 = new Scanner(System.in);
					opcionMenu2 = teclado3.nextLine();
					if (esNumeroException(opcionMenu2)) { // Detector de si es un número
						opcionMenu2Int = Integer.parseInt(opcionMenu2);
					}
					respuesta = false;
				} else {
					System.out.println("\nElige otro contenido.");
					respuesta = true;
				}
			} while (respuesta == true);
			// Menu 2 //
			switch (opcionMenu2Int) {
				case 1:
					redesSociales = true;
					puertaDelSol = false;
					break;
				case 2:
					redesSociales = false;
					puertaDelSol = true;
					break;
				case 3:
					redesSociales = true;
					puertaDelSol = true;
					break;
				default:
					System.out.println("\nEscoge otra opción.");
					i = 1;
					break;
			}
		} while (i == 1);

		idPromocion++;
		Promocion promocion = new Promocion(idPromocion, titulo, puertaDelSol, redesSociales, 0.0); // Se crea la
																									// promoción
		double c = realizarPromocion(contenido, promocion.getContenido(), promocion.isPuertaDelSol(),
				promocion.isRedesSociales()); // Se guarda en c el coste de la promocion realizada
		promocion.setCoste(c); // Se inserta c en el coste de la promoción
		promociones.add(promocion); // Se añade la promoción al Arraylist Promociones
		System.out.println("\nPromoción realizada de: " + titulo);
		for (Promocion j : promociones) { // Recorre el ArrayList promociones
			if (contenido instanceof Serie) { // detecta si es una serie
				try { // excepcion 2 //
					ExcedeDeDoceMil();
				} catch (Exception ex) {
					System.out.println(ex.getMessage());
				}
			}
		}
	}

	private Promocion ExcedeDeDoceMil() throws ExcedeDeDoce { // Metedo excepcion 2
		Promocion promocion = null;
		for (Promocion j : promociones) {
			if (j.getCoste() > 12000) {
				throw new ExcedeDeDoce("\nEl coste asciende de los 12000 euros.");
				// j.setCoste(12000);
			}
		}
		return promocion;
	}

	private Contenido tituloExisteEnContenido(String titulo) throws ContenidoNoEncontrado { // Metodo excepcion 1
		Contenido contenido = null;
		for (Contenido c : contenidos) {
			if (c.getTitulo().equals(titulo)) {
				contenido = c;
			}
		}
		if (contenido == null) {
			throw new ContenidoNoEncontrado("Titulo de contenido no encontrado.");
		}
		return contenido;
	}

	public void obtenerCostePromocion() { // Opción 5 del menú
		int i, contadorRepeticiones = 0, idPeliculaInt = -1;
		String idPelicula;
		Promocion promocion = null;
		Scanner teclado2 = new Scanner(System.in); // Teclado 2
		do {
			i = 0;
			System.out.println("\n¿De que promoción quieres ver el coste?");
			titulo = teclado2.nextLine().toUpperCase();

			// excepcion 3 //
			try {
				promocion = tituloExisteEnPromocion(titulo);
				System.out.println("\nPromoción seleccionada: " + titulo);
			} catch (PromocionNoEncontrada ex) {
				System.out.println(ex.getMessage());
				i = 1;
			}

			for (Promocion c : promociones) { // Cuenta cuantas pelis o series hay con el mismo nombre
				if (titulo.equals(c.getContenido())) {
					contadorRepeticiones++;
				}
			}

			for (Promocion c : promociones) { // Repasa todo el ArrayList promociones
				String tituloRepeticiones = c.getContenido();
				if (tituloRepeticiones.equals(c.getContenido())) { // Si titulo es el mismo que el titulo que hay en el
																	// ArrayList
					if (contadorRepeticiones >= 2) { // Si hay más de dos iguales
						System.out.println("\nHay dos o más contenidos con el mismo nombre.");
						for (Promocion a : promociones) { // Muestra todas las promociones
							System.out.println("\n-- ID: " + a.getIdPromocion() + ", titulo: " + a.getContenido()
									+ ", Puerta del Sol: "
									+ a.isPuertaDelSol() + ", Redes Sociales: " + a.isRedesSociales());
						}
						System.out.println("\n¿Que ID quieres seleccionar?"); // Te pide la ID que quieras
						idPelicula = teclado2.nextLine();
						if (esNumeroException(idPelicula)) { // Detector de si es un número
							idPeliculaInt = Integer.parseInt(idPelicula);
						}
						for (Promocion a : promociones) {
							if (idPeliculaInt == a.getIdPromocion()) { // Muestra el contenido con el mismo ID
								System.out.println(
										"\nEl coste de: " + a.getContenido() + " es " + a.getCoste() + " euros.");
							}
						}
					}
				}
				break;
			}
		} while (i == 1);
		if (contadorRepeticiones == 1) { // Si no se repite ningun nombre
			System.out.println("\nEl coste de: " + titulo + " es " + promocion.getCoste() + " euros.");
		}
	}

	private Promocion tituloExisteEnPromocion(String titulo) throws PromocionNoEncontrada { // Metodo excepcion 3
		Promocion promocion = null;
		for (Promocion p : promociones) {
			if (p.getContenido().equals(titulo)) {
				promocion = p;
			}
		}
		if (promocion == null) {
			throw new PromocionNoEncontrada("Promoción no encontrada.");
		}
		return promocion;
	}

	public void mostrarPromociones() { // Opción 3 del menú
		for (Promocion c : promociones) {
			System.out.println("ID: " + c.getIdPromocion() + ", Contenido: " + c.getContenido() + ", Puerta del Sol: "
					+ c.isPuertaDelSol() + ", Redes Sociales: " + c.isRedesSociales());
		}
	}

	public void mostrarCostes() { // Opción 4 del menú
		for (Promocion c : promociones) {
			System.out.println("El coste es: " + c.getCoste() + " euros, " + "con ID: " + c.getIdPromocion());
		}
	}

	public void contadorPromociones() { // Opción 6 del menú
		EmpresaMarketing empresa1 = new EmpresaMarketing("Instagram", 693243809, 5000.0);
		System.out
				.println("\nCoste total de las campaña masiva: " + contador * empresa1.getCompatibilidad() + " euros.");
	}

	public void calcularSubvenciones() throws ContenidoNoEncontrado { // Opción 7 del menú
		double subvencionMin = 0.0;
		Contenido contenido = null;
		for (Promocion c : promociones) {
			contenido = tituloExisteEnContenido(c.getContenido());
			if (contenido instanceof Pelicula) { // Si es pelicula
				if (contenido.isTendencias() == true) {
					subvencionMin += 1000.0;
				} else {
					subvencionMin += 750.0;
				}
			} else { // Si es serie
				if (contenido.isTendencias() == true) {
					subvencionMin += 750.0;
				} else {
					subvencionMin += 650.0;
				}
			}
		}
		Ayuntamiento ayuntamiento1 = new Ayuntamiento("Toledo", 925685785, subvencionMin);
		System.out.println("Nombre: " + ayuntamiento1.getNombreContacto() + ", telefono: " + ayuntamiento1.getTelefono()
				+ ", subvención: " + ayuntamiento1.getSubvencionMin());
	}

	public boolean esNumeroException(String i) {
		boolean resul = true;
		try { // excepcion 4 //
			esNumero(i);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			resul = false;
		}
		return resul;
	}

	public void esNumero(String i) throws EsNumero { // Metodo excepcion 4
		if (!i.matches("[+-]?\\d*(\\.\\d+)?")) {
			throw new EsNumero("El valor introducido no es un número.");
		}
	}
}