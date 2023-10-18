package marketing;

public class Promocion {

	private int idPromocion;
	private String contenido;
	private double coste;
	private boolean puertaDelSol;
	private boolean redesSociales;
	
	//Getter and Setter
	public double getCoste() {
		return coste;
	}
	public void setCoste(double coste) {
		this.coste = coste;
	}
	public int getIdPromocion() {
		return idPromocion;
	}
	public void setIdPromocion(int idPromocion) {
		this.idPromocion = idPromocion;
	}
	public String getContenido() {
		return contenido;
	}
	public void setContenido(String contenido) {
		this.contenido = contenido;
	}
	public boolean isPuertaDelSol() {
		return puertaDelSol;
	}
	public void setPuertaDelSol(boolean puertaDelSol) {
		this.puertaDelSol = puertaDelSol;
	}
	public boolean isRedesSociales() {
		return redesSociales;
	}
	public void setRedesSociales(boolean redesSociales) {
		this.redesSociales = redesSociales;
	}
	public Promocion(int idPromocion, String titulo, boolean puertaDelSol, boolean redesSociales, double coste) {
		this.idPromocion = idPromocion;
		this.contenido = titulo;
		this.coste = 0;
		this.puertaDelSol = puertaDelSol;
		this.redesSociales = redesSociales;
	}
}