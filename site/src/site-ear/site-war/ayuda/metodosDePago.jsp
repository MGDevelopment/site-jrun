<%@ page import="com.tmk.kernel.Globals,
                 com.tmk.kernel.MedioDeCobroDAO,
                 com.tmk.setup.Contenido" %>

<tr>
	<td class="moduloayuda">
		<p class="FTtit01">TEMATIKA CUENTA CON LOS SIGUIENTES METODOS DE PAGO </p>
		
		<% if (MedioDeCobroDAO.buscaMedioDeCobro(Globals.CLAVE_MEDIO_DE_COBRO_ARCASH).estaHabilitado()) { %>
			<p class="Ftexto02"><strong>Arcash</strong><br/><br/>
				Selecciona esta opción si preferís abonar tu compra a través de Cupones arcash. Para ello deberás haber adquirido previamente un cupón prepago en las entidades habilitadas para ello. Al finalizar la compra deberás ingresar a Arcash y realizar el pago correspondiente para recibir tu pedido. El plazo habitual de salida del depósito de cada producto comenzará a correr una vez efectivizado el pago de su compra. (más información en <a href="http://www.arcash.com.ar">http://www.arcash.com.ar</a>)
			</p>
        <% } %>
		
		<% if (MedioDeCobroDAO.buscaMedioDeCobro(Globals.CLAVE_MEDIO_DE_COBRO_CONTRAREEMBOLSO).estaHabilitado()) { %>
        	<p class="Ftexto02"><strong>Contra reembolso</strong><br/><br/>
        	El envío con cobro contrareembolso sólo es válido dentro de la República Argentina y tiene un costo adicional de <%=Contenido.porcentajeToString(Globals.CARGO_POR_ENVIO_CONTRAREEMBOLSO)%> del total de la orden, que te será cobrado en el momento de la entrega. 

        	</p>
        <% } %>
		
		<% if (MedioDeCobroDAO.buscaMedioDeCobro(Globals.CLAVE_MEDIO_DE_COBRO_DINERO_MAIL).estaHabilitado()) { %>
        	<p class="Ftexto02"><strong>Dinero Mail</strong><br/><br/>
				Selecciona esta opci&oacute;n si prefer&iacute;s abonar tu compra a trav&eacute;s de Dinero Mail. 
				Para ello deber&aacute;s tener una cuenta registrada con dinero disponible.<br> 
				Al finalizar la compra deber&aacute;s ingresar a Dinero Mail y realizar el pago correspondiente para recibir tu pedido. 
				El plazo habitual de salida del dep&oacute;sito de cada producto comenzar&aacute; a correr una vez efectivizado el pago de su compra. 
			</p>
        <% } %>
        
        
        <% if (MedioDeCobroDAO.buscaMedioDeCobro(Globals.CLAVE_MEDIO_DE_COBRO_FAX).estaHabilitado()) { %>
        	<p class="Ftexto02"><strong>Fax</strong><br/><br/>
				En este caso nos tendrás que enviar por fax el formulario que encontrarás cuando gestiones tu pago, el cual tendrás que completarlo con los datos de tu tarjeta de crédito y tus datos personales.
				Si querés imprimir el formulario presioná <a href="<%=Globals.PAGINA_SITIO + "/compra/pagoPorFax.jsp"%> " class="FAyuda">aquí</a>.
			</p>
        <% } %>
        
        <% if (MedioDeCobroDAO.buscaMedioDeCobro(Globals.CLAVE_MEDIO_DE_COBRO_PAGO_FACIL).estaHabilitado()) { %>
        	<p class="Ftexto02"><strong>Pago Fácil</strong><br/><br/>
				Al plazo habitual de salida del depósito de cada producto deberás sumarle 72hs hábiles luego de la realización del pago dado que ese es el tiempo que demoramos en recibir la constancia del mismo.
				Al finalizar la compra deberás imprimir un cupón con el cual deberás realizar el pago en cualquier oficina de Pago Fácil para recibir su pedido.
			</p>
        <% } %>
        
        <% if (MedioDeCobroDAO.buscaMedioDeCobro(Globals.CLAVE_MEDIO_DE_COBRO_RAPI_PAGO).estaHabilitado()) { %>
        	<p class="Ftexto02"><strong>Rapi Pago</strong><br/><br/>
				Al plazo habitual de salida del depósito de cada producto deberás sumarle 72hs hábiles luego de la realización del pago dado que ese es el tiempo que demoramos en recibir la constancia del mismo.
				Al finalizar la compra deberás imprimir un cupón con el cual deberás realizar el pago en cualquier oficina de Rapi Pago para recibir su pedido.
			</p>
        <% } %>
        
        <% if (MedioDeCobroDAO.buscaMedioDeCobro(Globals.CLAVE_MEDIO_DE_COBRO_RIOHB).estaHabilitado()) { %>
        	<p class="Ftexto02"><strong>Santander Rio Online Banking</strong><br/><br/>
				Sólo tenés que ingresar el número de orden e importe y realizar el pago a través de la página del banco. Cuando recibamos el pago enviaremos automáticamente tu pedido
			</p>
        <% } %>        
        
		<p class="Ftexto02"><strong>Tarjetas de Cr&eacute;dito</strong><br/><br/>
		Deber&aacute;s seleccionar el tipo de tarjeta que pose&eacute;s
				<%  StringBuffer validas = new StringBuffer();
					for (int i = 0; i < Globals.MEDIOS_DE_COBRO.length; i++) {
						MedioDeCobroDAO medioDeCobro = Globals.MEDIOS_DE_COBRO[i];
						if (medioDeCobro.estaHabilitado() && medioDeCobro.esTarjeta()) {
							if (validas.length() > 0) {
								validas.append(" ó ");
							}
							validas.append(medioDeCobro.getNombre());
						}
					}
				%>
		(<strong><%=validas%></strong>).<br/>
		
		A continuación deberás completar los datos de la tarjeta tal cual como figuran en el plástico. Por último, deberás ingresar tu tipo y número de documento, y el domicilio donde llega tu resumen. 
		</p>
		        
        <p class="Ftexto02">Ver <a href="/ayuda/ayudaEstandar.jsp?url=/ayuda/seguridad.jsp" class="FAyuda">Seguridad</a></p>
        
		
   </td>
</tr>		