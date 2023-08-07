package com.belenaprende.productos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

public class ModeloProductos {

	private DataSource origenDatos;

	public ModeloProductos(DataSource miPool) {
		origenDatos = miPool;

	}

	public List<Productos> getProductos() throws Exception {

		List<Productos> listaProductos = new ArrayList<>();
		Connection miConeccion = null;
		Statement miStat = null;
		ResultSet rs = null;

		String sql = "SELECT * FROM productos";
		miConeccion = origenDatos.getConnection();
		miStat = miConeccion.createStatement();
		rs = miStat.executeQuery(sql);
		while (rs.next()) {
			String c_art = rs.getString(1); // 1 hace referencia a la primera columna de nuestra tabla. sql no comienza
											// desde 0. Sería mejor usar "nombreDeColumna" pero como tiene caracteres
											// especiales, yo usé índices

			String sec = rs.getString(2);
			String nomArt = rs.getString(3);
			String precio = rs.getString(4);
			Date fecha = rs.getDate(5);
			String importado = rs.getString(6);
			String paisOrig = rs.getString(7);

			listaProductos.add(new Productos(c_art, sec, nomArt, paisOrig, importado, fecha, precio));
		}

		return listaProductos;
	}

	public void agregarNuevoProducto(Productos productoIntroducido) {
		// Obtener la coneccion con la BBDD
		Connection miConeccion = null;
		PreparedStatement miStat = null;

		try {
			miConeccion = origenDatos.getConnection();
			String sql = "INSERT INTO productos (codigoarticulo, seccion, nombrearticulo, precio, fecha, importado, paisdeorigen) VALUES (?,?,?,?,?,?,?)";

			miStat = miConeccion.prepareStatement(sql);
			miStat.setString(1, productoIntroducido.getCodigoArt());
			miStat.setString(2, productoIntroducido.getSeccion());
			miStat.setString(3, productoIntroducido.getNomArt());
			miStat.setString(4, productoIntroducido.getPrecio());
			java.util.Date fechaCon = productoIntroducido.getFecha();
			java.sql.Date fechaConvertida = new java.sql.Date(fechaCon.getTime());
			miStat.setDate(5, fechaConvertida);
			miStat.setString(6, productoIntroducido.getImportado());
			miStat.setString(7, productoIntroducido.getPaisOrigen());

			miStat.execute();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public Productos getProducto(String codArticulo) {

		Productos elProducto = null;
		Connection miCone = null;
		PreparedStatement miPrepStat = null;
		ResultSet rs = null;
		String codArti = codArticulo;

		// establecer coneccion

		try {
			miCone = origenDatos.getConnection();
			// crear sql q busque el producto
			String sql = "SELECT * FROM productos WHERE codigoarticulo = ?";
			// crear la consulta preparada
			miPrepStat = miCone.prepareStatement(sql);
			// establecer los parametros de consulta
			miPrepStat.setString(1, codArti);
			// ejecutar consulta
			rs = miPrepStat.executeQuery();
			// obtener los datos de respuesta

			if (rs.next()) {
				String c_art = rs.getString(1);
				String sec = rs.getString(2);
				String nomArt = rs.getString(3);
				String precio = rs.getString(4);
				Date fecha = rs.getDate(5);
				String importado = rs.getString(6);
				String paisOrig = rs.getString(7);

				elProducto = new Productos(c_art, sec, nomArt, paisOrig, importado, fecha, precio);
			} else {
				throw new Exception("No hay el producto con el codigo :" + codArti);
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return elProducto;
	}

	public void actualizarProducto(Productos productoActualizado) throws Exception {
		// Obtener la coneccion con la BBDD
		Connection miConeccion = null;
		PreparedStatement miStat = null;

		try {
			miConeccion = origenDatos.getConnection();
			String sql = "UPDATE productos SET seccion=?, nombrearticulo=?, precio=?, "
					+ "fecha=?, importado=?, paisdeorigen=? WHERE codigoarticulo=?";
			miStat = miConeccion.prepareStatement(sql);
			miStat.setString(1, productoActualizado.getSeccion());
			miStat.setString(2, productoActualizado.getNomArt());
			miStat.setString(3, productoActualizado.getPrecio());
			java.util.Date fechaCon = productoActualizado.getFecha();
			java.sql.Date fechaConvertida = new java.sql.Date(fechaCon.getTime());
			miStat.setDate(4, fechaConvertida);
			miStat.setString(5, productoActualizado.getImportado());
			miStat.setString(6, productoActualizado.getPaisOrigen());
			miStat.setString(7, productoActualizado.getCodigoArt());

			miStat.execute();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
