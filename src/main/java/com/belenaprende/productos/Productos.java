package com.belenaprende.productos;

import java.util.Date;

public class Productos {

	private String codigoArt;
	private String seccion;
	private String nomArt;
	private String paisOrigen;
	private String importado;
	private Date fecha;
	private String precio;

	public Productos(String seccion, String nomArt, String paisOrigen, String importado, Date fecha, String precio) {
		this.seccion = seccion;
		this.nomArt = nomArt;
		this.paisOrigen = paisOrigen;
		this.importado = importado;
		this.fecha = fecha;
		this.precio = precio;
	}

	public Productos(String codigoArt, String seccion, String nomArt, String paisOrigen, String importado, Date fecha,
			String precio) {
		this.codigoArt = codigoArt;
		this.seccion = seccion;
		this.nomArt = nomArt;
		this.paisOrigen = paisOrigen;
		this.importado = importado;
		this.fecha = fecha;
		this.precio = precio;
	}

	public String getCodigoArt() {
		return codigoArt;
	}

	/**
	 * @param codigoArt the codigoArt to set
	 */
	public void setCodigoArt(String codigoArt) {
		this.codigoArt = codigoArt;
	}

	/**
	 * @return the seccion
	 */
	public String getSeccion() {
		return seccion;
	}

	/**
	 * @param seccion the seccion to set
	 */
	public void setSeccion(String seccion) {
		this.seccion = seccion;
	}

	/**
	 * @return the nomArt
	 */
	public String getNomArt() {
		return nomArt;
	}

	/**
	 * @param nomArt the nomArt to set
	 */
	public void setNomArt(String nomArt) {
		this.nomArt = nomArt;
	}

	/**
	 * @return the paisOrigen
	 */
	public String getPaisOrigen() {
		return paisOrigen;
	}

	/**
	 * @param paisOrigen the paisOrigen to set
	 */
	public void setPaisOrigen(String paisOrigen) {
		this.paisOrigen = paisOrigen;
	}

	/**
	 * @return the importado
	 */
	public String getImportado() {
		return importado;
	}

	/**
	 * @param importado the importado to set
	 */
	public void setImportado(String importado) {
		this.importado = importado;
	}

	/**
	 * @return the fecha
	 */
	public Date getFecha() {
		return fecha;
	}

	/**
	 * @param fecha the fecha to set
	 */
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	/**
	 * @return the precio
	 */
	public String getPrecio() {
		return precio;
	}

	/**
	 * @param precio the precio to set
	 */
	public void setPrecio(String precio) {
		this.precio = precio;
	}

	@Override
	public String toString() {
		return "Productos [codigoArt=" + codigoArt + ", seccion=" + seccion + ", nomArt=" + nomArt + ", paisOrigen="
				+ paisOrigen + ", importado=" + importado + ", fecha=" + fecha + ", precio=" + precio + "]";
	}

}
