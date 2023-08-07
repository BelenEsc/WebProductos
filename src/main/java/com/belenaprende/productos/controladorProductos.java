package com.belenaprende.productos;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 * Servlet implementation class controladorProductos
 */
@WebServlet("/controladorProductos")
public class controladorProductos extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private ModeloProductos modeloProductos; // aqui tiene que venir el modelo. el que conecta con la base de datos

	@Resource(name = "poolConexiones")
	private DataSource miPool;

	@Override
	public void init() throws ServletException { // desde aqui arranca la aplicacion
		// TODO Auto-generated method stub
		super.init();
		try {
			modeloProductos = new ModeloProductos(miPool);
		} catch (Exception e) {
			throw new ServletException(e);
		}

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Leer el parametro que le llega desde el formulario, o sea si hay q insertar o
		// no

		String elComando = request.getParameter("instruccion");

		// sino se envia el parametro listar los productos (o sea si esta vacio)

		if (elComando == null) {
			elComando = "listar";
		}
		// redirigir el flujo de ejecucion al metodo adecuado

		switch (elComando) {
		case "listar":
			obtenerProductos(request, response);
			break;
		case "insertarBBDD":
			agregarProductos(request, response);
			break;
		case "cargar":
			try {
				cargarProductos(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("hola");

			}
			break;
		case "actualizarBBDD":
			try {
				actualizaProductos(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.out.println("hola");
				e.printStackTrace();
			}
			break;

		default:
			obtenerProductos(request, response);
		}

	}

	private void actualizaProductos(HttpServletRequest request, HttpServletResponse response) throws Exception {

		// leer los datos que le vienen del formulario actualizar
		String CodArticulo = request.getParameter("CArt");
		String Seccion = request.getParameter("Sec");
		String NomArt = request.getParameter("NArt");

		String Precio = request.getParameter("Prec");
		SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
		Date Fecha = null;
		try {
			Fecha = formatoFecha.parse(request.getParameter("Fecha"));
		} catch (ParseException e) {
			System.out.println("hola");

			e.printStackTrace();
		}
		String Imp = request.getParameter("Imp");
		String POri = request.getParameter("POri");

		// crear objeto de tipo producto con la info del formulario
		Productos productoActualizado = new Productos(CodArticulo, Seccion, NomArt, POri, Imp, Fecha, Precio);

		// actualizar la bbdd con la info del obj producto
		modeloProductos.actualizarProducto(productoActualizado);

		// volver a listar la info actualizada
		obtenerProductos(request, response);
	}

	private void cargarProductos(HttpServletRequest request, HttpServletResponse response) throws Exception {

		// leer el codigo articulo que se le esta mandado desde el servlet. el que el
		// vlaue CArticulo

		String CodArticulo = request.getParameter("CArticulo");

		// comunicar con el modelo para que el modelo consulte a la bbdd con el criterio
		// que se le esta enviando

		Productos elProducto = modeloProductos.getProducto(CodArticulo);

		// Colocar atributo correspondiente al codigo articulo
		request.setAttribute("ProductoActualizar", elProducto);

		// enviar la info de este articulo al formulario de actualizar

		RequestDispatcher dispatcher = request.getRequestDispatcher("/actualizarProducto.jsp");
		dispatcher.forward(request, response);
	}

	private void agregarProductos(HttpServletRequest request, HttpServletResponse response) {

		// leer la informacion que viene del formulario

		String CodArticulo = request.getParameter("CArt"); // especificar el nombre del campo en el formulario de donde
															// viene la informacion
		String Seccion = request.getParameter("Sec"); // especificar el nombre del campo en el formulario de donde viene
														// la informacion
		String NomArt = request.getParameter("NArt"); // especificar el nombre del campo en el formulario de donde viene
														// la informacion
//		Double Precio = (Double.parseDouble(request.getParameter("Prec"))); // especificar el nombre del campo en el
//																			// formulario de donde viene
		String Precio = request.getParameter("Prec"); // esto deberia ser double pero en mi formulario esta como srting
														// y no se podia cambiar.
		// la informacion
		SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
		Date Fecha = null;
		try {
			Fecha = formatoFecha.parse(request.getParameter("Fecha"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // especificar el nombre del campo en el formulario de donde viene
			// la informacion
		String Imp = request.getParameter("Imp"); // especificar el nombre del campo en el formulario de donde viene la
													// informacion
		String POri = request.getParameter("POri"); // especificar el nombre del campo en el formulario de donde viene
													// la informacion

		// crear un objeto de tipo producto y darle valores

		Productos productoIntroducido = new Productos(CodArticulo, Seccion, NomArt, POri, Imp, Fecha, Precio);

		// enviar el objeto al modelo para uqe lo postee insertar el objeto producto en
		// la BBDD

		modeloProductos.agregarNuevoProducto(productoIntroducido);

		// volver a listar la tabla de productos
		obtenerProductos(request, response);
	}

	private void obtenerProductos(HttpServletRequest request, HttpServletResponse response) {

		// obtener la lista de productos del modelo
		List<Productos> productos;
		try {
			productos = modeloProductos.getProductos();

			// agregar lista de productos al request

			request.setAttribute("LISTAPRODUCTOS", productos);

			// enviar ese request a la pagina jsp con un despachador

			RequestDispatcher miDispacher = request.getRequestDispatcher("/ListaProductos.jsp");
			miDispacher.forward(request, response);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
