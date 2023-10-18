package contenido;

public abstract class Contenido {
	private String titulo;
	private int duracion;
	private int fechaEstreno;
	private String descripcion;
	private boolean tendencias;
	private char tipo;
	
	//Getter and Setter
	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public int getDuracion() {
		return duracion;
	}

	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}

	public int getFechaEstreno() {
		return fechaEstreno;
	}

	public void setFechaEstreno(int fechaEstreno) {
		this.fechaEstreno = fechaEstreno;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public char getTipo() {
		return tipo;
	}

	public void setTipo(char tipo) {
		this.tipo = tipo;
	}

	public boolean isTendencias() {
		return tendencias;
	}

	public void setTendencias(boolean tendencias) {
		this.tendencias = tendencias;
	}

	public Contenido(String titulo, int duracion, int fechaEstreno, String descripcion, Boolean tendencias) {
		this.titulo = titulo;
		this.duracion = duracion;
		this.fechaEstreno = fechaEstreno;
		this.descripcion = descripcion;
		this.tendencias = tendencias;
	}
	
	public abstract void calcularPrecioContenido();
}
