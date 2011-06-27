/**
 * @author Lizardo Santiago
 *
 * $Log: BuscarListas.java,v $
 * Revision 1.18  2009/04/08 15:48:01  oClopez
 * modificaciones sobre feed back
 *
 * Revision 1.17  2007/01/22 17:43:20  omsartori
 * - Cambios en detalle de articulos y derivadas, se quitaron algunos componentes Ajax para no afectar el crawling de buscadores
 * - Rediseño de lista de deseos
 *
 * Revision 1.16  2003/12/22 22:27:58  GPistoia
 * -Listado de pedidos especiales
 * -Mejora en listado de ordenes
 * -Medio de cobro restringido
 * -Memoria maxima alocable.
 *
 * Revision 1.15  2003/10/29 19:57:31  GPistoia
 * -Correccion de queries con *
 * -Envio de mail a callcenter
 * -Correccion en promocion, nuevo campo
 * -Numero de tarjeta completo en detalle de orden
 *
 * Revision 1.14  2003/10/27 21:19:51  SLizardo
 * Si no tiene lista, no se agrega a los resultados.
 *
 */
package com.tmk.controllers.listaDeseos;

import com.tmk.kernel.DBUtil;
import com.tmk.kernel.TmkLogger;
import com.tmk.src.listadeseos.ListaDeseosPK;
import com.tmk.util.ShortCuts;
import com.tmk.src.socio.SocioPK;

import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Iterator;
import java.util.Vector;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

public final class BuscarListas extends HttpServlet
{
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String APELLIDOS_NOMBRES = request.getParameter("APELLIDOS_NOMBRES");
		String PROVINCIA_CIUDAD = request.getParameter("PROVINCIA_CIUDAD");

		Vector<ListaDeseosPK> items = new Vector<ListaDeseosPK>();

		StringBuffer sql = new StringBuffer();

		if(APELLIDOS_NOMBRES.trim().length() != 0)
		{
			sql.append("SELECT id_sucursal_socio, id_socio FROM lista_deseos WHERE publica = 1 AND ");
			sql.append("(LOWER(apellidos) LIKE '%").append(APELLIDOS_NOMBRES.toLowerCase()).append("%' OR LOWER(nombres) LIKE '%").append(APELLIDOS_NOMBRES.toLowerCase()).append("%')");
		}

		if(PROVINCIA_CIUDAD.trim().length() != 0)
		{
			if(APELLIDOS_NOMBRES.trim().length() != 0)
			{
				sql.append(" UNION ");
			}
			sql.append("select /*+ index(scd sodo_pais_pcia_loc_i) index(lds ld_soc_i)*/ ");
			sql.append("lds.id_sucursal_socio, lds.id_socio ");
			sql.append("from lista_deseos      lds, ");
			sql.append("socios_domicilios scd, ");
			sql.append("provincias        prv ");
			sql.append("where lds.id_socio          = scd.id_socio ");
			sql.append("and lds.id_sucursal_socio = scd.id_sucursal ");
			sql.append("and lds.tipo_domicilio    = scd.tipo_domicilio ");
			sql.append("and scd.id_provincia      = prv.id_provincia ");
			sql.append("and scd.id_pais           = prv.id_pais ");
			sql.append("and prv.descripcion       like '"+PROVINCIA_CIUDAD.toUpperCase()+"%' ");
			sql.append("UNION ");
			sql.append("select /*+ index(scd sodo_pais_pcia_loc_i) index(lds ld_soc_i)*/ ");
			sql.append("lds.id_sucursal_socio, lds.id_socio ");
			sql.append("from lista_deseos      lds, ");
			sql.append("socios_domicilios scd, ");
			sql.append("localidades       loc ");
			sql.append("where lds.id_socio          = scd.id_socio ");
			sql.append("and lds.id_sucursal_socio = scd.id_sucursal ");
			sql.append("and lds.tipo_domicilio    = scd.tipo_domicilio ");
			sql.append("and scd.id_localidad      = loc.id_localidad ");
			sql.append("and scd.id_provincia      = loc.id_provincia ");
			sql.append("and scd.id_pais           = loc.id_pais ");
			sql.append("and loc.descripcion       like '"+PROVINCIA_CIUDAD.toUpperCase()+"%' ");
		}

		try
		{
			Connection connection = DBUtil.buildConnection();
			try {
				Statement statement = connection.createStatement();
	            try {
					ResultSet resultSet = null;
		            resultSet = statement.executeQuery(sql.toString());
		            try {
						while(resultSet.next())
						{
							ListaDeseosPK listaPK = new ListaDeseosPK(new Integer(resultSet.getInt(1)), new Integer(resultSet.getInt(2)));
							items.add(listaPK);
						}

						Iterator socios = ShortCuts.findSociosByLogin(APELLIDOS_NOMBRES);
						while(socios.hasNext())
						{
							SocioPK socioPK = (SocioPK)socios.next();
							ListaDeseosPK listaPK = new ListaDeseosPK(socioPK.ID_SUCURSAL, socioPK.ID_SOCIO);
							ResultSet rs = statement.executeQuery("SELECT id_sucursal_socio, id_socio FROM lista_deseos WHERE id_sucursal_socio = "+socioPK.ID_SUCURSAL+" AND id_socio = "+socioPK.ID_SOCIO);
							if(rs.next())
							{
								items.add(listaPK);
							}
							rs.close();
						}

		            } finally {
						resultSet.close();
		            }
	            } finally {
					statement.close();
	            }
			} finally {
			connection.close();
			}
		}
		catch (NamingException ne)
		{
			TmkLogger.error(ne.getMessage());
		}
		catch (SQLException se)
		{
			TmkLogger.error(se.getMessage());
		}

		HttpSession session = request.getSession();
		session.setAttribute("ListaDeseos.listas", items.iterator());
		response.sendRedirect("/listaDeseos/indexRO.jsp?busqueda=true");

	}
}
