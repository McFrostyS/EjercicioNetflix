package marketing;

public class EmpresaMarketing {

	private String nombre;
	private long telefono;
	private Double compatibilidad;
	
	//Getter and Setter
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public long getTelefono() {
		return telefono;
	}
	public void setTelefono(long telefono) {
		this.telefono = telefono;
	}
	public Double getCompatibilidad() {
		return compatibilidad;
	}
	public void setCompatibilidad(Double compatibilidad) {
		this.compatibilidad = compatibilidad;
	}
	
	public EmpresaMarketing(String nombre, long telefono, Double compatibilidad) {
		this.nombre = nombre;
		this.telefono = telefono;
		this.compatibilidad = compatibilidad;
	}
	
}
