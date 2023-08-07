package com.belenaprende.productos;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 * Servlet implementation class ServletPruebas
 */
@WebServlet("/ServletPruebas")
public class ServletPruebas extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// definir el datasurce

	@Resource(name = "poolConexiones")
	private DataSource miPool;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletPruebas() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// crear el objeto printWritter

		PrintWriter salida = response.getWriter();
		response.setContentType("text/plain");

		// Crear conexión con BBDD

		Connection miConex = null;
		Statement miStatement = null;
		ResultSet rs = null;
		try {
			miConex = miPool.getConnection();
			String misql = "SELECT * FROM productos";
			miStatement = miConex.createStatement();
			rs = miStatement.executeQuery(misql);
			while (rs.next()) {
				String articulo = rs.getString(3); // el 3 es para referenciar la columna de la tabla productos
				salida.println(articulo);
			}

		} catch (Exception e) {

			System.out.println(e.getMessage());
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
