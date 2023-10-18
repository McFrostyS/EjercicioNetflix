package contenido;

public class Serie extends Contenido {

	private int temporadas;
	private int capitulos;
	
	//Getter and Setter
	public int getTemporadas() {
		return temporadas;
	}

	public void setTemporadas(int temporadas) {
		this.temporadas = temporadas;
	}

	public int getCapitulos() {
		return capitulos;
	}

	public void setCapitulos(int capitulos) {
		this.capitulos = capitulos;
	}
	//Constructor
	public Serie(String titulo, int duracion, int fechaEstreno, String descripcion, boolean tendencias, int temporadas, int capitulos) {
		super(titulo, duracion, fechaEstreno, descripcion, tendencias);
		this.temporadas = temporadas;
		this.capitulos = capitulos;
	}

	@Override
	public String toString() {
		return "-- " + "Titulo: " + getTitulo() + ", temporadas: " + temporadas + ", capitulos: " + capitulos
				+ ", duracion: " + getDuracion() + ", Fecha de estreno: " + getFechaEstreno()
				+ ", descripcion: " + getDescripcion() + ", Tendencias: " + isTendencias() + "\n";
	}

	@Override
	public void calcularPrecioContenido() {
		// TODO Auto-generated method stub
		
	}
	
}