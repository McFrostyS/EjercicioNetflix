package marketing;

public class Ayuntamiento {

	private String nombreContacto;
	private long telefono;
	private Double subvencionMin;
	
	//Getter and Setter
	public String getNombreContacto() {
		return nombreContacto;
	}
	public void setNombreContacto(String nombreContacto) {
		this.nombreContacto = nombreContacto;
	}
	public long getTelefono() {
		return telefono;
	}
	public void setTelefono(long telefono) {
		this.telefono = telefono;
	}
	public Double getSubvencionMin() {
		return subvencionMin;
	}
	public void setSubvencionMin(Double subvencionMin) {
		this.subvencionMin = subvencionMin;
	}
	public Ayuntamiento(String nombreContacto, long telefono, Double subvencionMin) {
		this.nombreContacto = nombreContacto;
		this.telefono = telefono;
		this.subvencionMin = subvencionMin;
	}
	
}