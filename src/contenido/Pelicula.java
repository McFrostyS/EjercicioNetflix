package contenido;

public class Pelicula extends Contenido{
	
	private String productora;
	private String paisOrigen;
	
	//Getter and Setter
	public String getProductora() {
		return productora;
	}
	public void setProductora(String productora) {
		this.productora = productora;
	}
	public String getPaisOrigen() {
		return paisOrigen;
	}
	public void setPaisOrigen(String paisOrigen) {
		this.paisOrigen = paisOrigen;
	}
	
	//Constructor Pelicula
	public Pelicula(String titulo, int duracion, int fechaEstreno, String descripcion, boolean tendencias, String productora, String paisOrigen) {
		super(titulo, duracion, fechaEstreno, descripcion, tendencias);
		this.productora = productora;
		this.paisOrigen = paisOrigen;
	}
	
	@Override
	public String toString() {
		return "-- " + "Titulo: " + getTitulo() + ", duracion: " + getDuracion() + ", fecha de estreno: " + getFechaEstreno()
				+ ", descripcion: " + getDescripcion() + ", tendencias: " + isTendencias() + "\n";
	}
	@Override
	public void calcularPrecioContenido() {
	}
	
	
}
