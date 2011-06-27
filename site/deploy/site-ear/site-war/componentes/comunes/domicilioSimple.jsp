<%@ page import="com.tmk.setup.Contenido,
                 com.tmk.controllers.compra.CompraHelper,
                 com.tmk.kernel.Convert"%>
<%= Convert.capitalizar(Convert.toString(domicilio.getCalle()), false) %> <%= Convert.toString(domicilio.getNumero()) %>
<%= Convert.toString(domicilio.getEdificio()) %> <%= Convert.toString(domicilio.getPiso()) %>
<%= Convert.capitalizar(Convert.toString(domicilio.getDepto()), true) %><br>
<%= Convert.toString(domicilio.getLocalidadExterna(), domicilio.getLocalidad().getNombre()) %> (<%= Convert.toString(domicilio.getCodigoPostal()) %>)<br>
<%= Convert.toString(domicilio.getProvinciaExterna(), domicilio.getProvincia().getNombre()) %><br>
<%= Convert.toString(domicilio.getPais().getNombre()) %><br>

