<%@ page import="java.util.Vector,
				 javax.naming.InitialContext,
                 java.util.Date,
                 com.tmk.orden.OrdenDAO,
                 com.tmk.setup.Contenido,
                 com.tmk.controllers.compra.CompraHelper,
                 com.tmk.kernel.TmkLogger,
                 com.tmk.kernel.*,
                 com.tmk.controllers.referido.ReferidoManager,
                 com.tmk.orden.TarjetaPrepaga,
                 com.tmk.controllers.alianza.EstadisticaVisitas,
                 com.tmk.src.socio.SocioPK" %>

<%@page import="com.tmk.controllers.carrito.CarritoUtil"%>
<%@page import="com.tmk.controllers.carrito.AgregarArticulo"%>

<%	OrdenDAO ordenDAO = (OrdenDAO)session.getAttribute("ordenDAO");
	SocioPK socioPK = (SocioPK)session.getAttribute("Registracion.socioPK");

	if (ordenDAO == null || socioPK == null) {
		response.sendRedirect("/miCuenta/index.jsp");
  		return;
	}
	//Integer idSocioPrueba = new Integer(85567);
	//Integer idSucursalPrueba = new Integer(201);

	CompraHelper.visitasDePaginaFormaDePago++;
	Vector tarjetasUsuario = new Vector();

	session.setAttribute("tarjetasUsuario", tarjetasUsuario);

	String TEXTO_TARJETA = "Con Tarjeta de Crédito";
	String TEXTO_REEMBOLSO = "Por Contrareembolso";
	String TEXTO_FAX = "Por Fax";

  
    MedioDeCobroDAO tarjetaPrepaga = MedioDeCobroDAO.buscaMedioDeCobro(Globals.CLAVE_MEDIO_DE_COBRO_TARJETA_PREPAGA);

%>

		<%= Globals.keywords(Globals.PAGINA_SITIO) %>


<script type="text/JavaScript">
function validarPrepaga () {
	var tarjetasVacias = true;
	/*alert(document.frmMedioCobro.<%= CompraHelper.CAMPO_MEDIO_COBRO %>.length);
	alert(document.frmMedioCobro.<%= CompraHelper.CAMPO_MEDIO_COBRO %>.name);*/
	for (i=0; i< document.frmMedioCobro.<%= CompraHelper.CAMPO_MEDIO_COBRO %>.length; i++) {
		//if (document.frmMedioCobro.<%= CompraHelper.CAMPO_MEDIO_COBRO%>[i].checked) {
			if (document.frmMedioCobro.<%= CompraHelper.CAMPO_MEDIO_COBRO%>.options[
				document.frmMedioCobro.<%= CompraHelper.CAMPO_MEDIO_COBRO%>.selectedIndex].value == '<%=tarjetaPrepaga.getId() %>') {
				if (document.frmMedioCobro.<%=CompraHelper.CAMPO_TARJETA_PREPAGA%>0.value != '') {
					tarjetasVacias = false;
					if (isNaN(document.frmMedioCobro.<%=CompraHelper.CAMPO_TARJETA_PREPAGA%>0.value)) {
						alert ('El código de tarjeta debe ser numérico');
						document.frmMedioCobro.<%=CompraHelper.CAMPO_TARJETA_PREPAGA%>0.focus();
						return false;
					}
				}
				if (document.frmMedioCobro.<%=CompraHelper.CAMPO_TARJETA_PREPAGA%>1.value != '') {
					tarjetasVacias = false;
					if (isNaN(document.frmMedioCobro.<%=CompraHelper.CAMPO_TARJETA_PREPAGA%>1.value)) {
						alert ('El código de tarjeta debe ser numérico');
						document.frmMedioCobro.<%=CompraHelper.CAMPO_TARJETA_PREPAGA%>1.focus();
						return false;
					}
				}
				if (document.frmMedioCobro.<%=CompraHelper.CAMPO_TARJETA_PREPAGA%>2.value != '') {
					tarjetasVacias = false;
					if (isNaN(document.frmMedioCobro.<%=CompraHelper.CAMPO_TARJETA_PREPAGA%>2.value)) {
						alert ('El código de tarjeta debe ser numérico');
						document.frmMedioCobro.<%=CompraHelper.CAMPO_TARJETA_PREPAGA%>2.focus();
						return false;
					}
				}
				if (document.frmMedioCobro.<%=CompraHelper.CAMPO_TARJETA_PREPAGA%>3.value != '') {
					tarjetasVacias = false;
					if (isNaN(document.frmMedioCobro.<%=CompraHelper.CAMPO_TARJETA_PREPAGA%>3.value)) {
						alert ('El código de tarjeta debe ser numérico');
						document.frmMedioCobro.<%=CompraHelper.CAMPO_TARJETA_PREPAGA%>3.focus();
						return false;
					}
				}
				if (document.frmMedioCobro.<%=CompraHelper.CAMPO_TARJETA_PREPAGA%>4.value != '') {
					tarjetasVacias = false;
					if (isNaN(document.frmMedioCobro.<%=CompraHelper.CAMPO_TARJETA_PREPAGA%>4.value)) {
						alert ('El código de tarjeta debe ser numérico');
						document.frmMedioCobro.<%=CompraHelper.CAMPO_TARJETA_PREPAGA%>4.focus();
						return false;
					}
				}
				if (tarjetasVacias) {
					alert ('Ingrese un código de tarjeta prepaga');
					document.frmMedioCobro.<%=CompraHelper.CAMPO_TARJETA_PREPAGA%>0.focus();
					return false;
				}
			}
		//}
	}
	return true;
}



	function quitaEspacios (cad)
	{
		var i,j;
		s = new String(cad);
		j = s.length;

		for (i=0; i<j; i++) {
			//alert (s.substring (i, i+1));
			if (s.substring(i, i+1) == ' ') {
				s = s.substring (0, i) + s.substring (i+1,j)
				i--;
				j--;
			}
		}
		return s;
	}

function validarMedioCobro() {
		var sel = document.getElementById('MediosDePago');
		if (sel.options[sel.options.selectedIndex].value == -1) {
			alert ('Seleccione un medio de pago');
			sel.focus();
			return;
		}
/*		alert(sel.options[sel.options.selectedIndex].value);
		alert(<%= Globals.TIPO_MEDIO_DE_COBRO_TARJETAS %>);*/
		if (sel.options[sel.options.selectedIndex].value == '<%= Globals.TIPO_MEDIO_DE_COBRO_TARJETAS %>') {
			switch (isTarjetaValida(document.frmMedioCobro.<%= CompraHelper.CAMPO_NUMERO_TARJETA %>.value, <%=Globals.DIGITOS_TARJETA_MINIMO%>, <%=Globals.DIGITOS_TARJETA_MAXIMO%>)) {
				case 1:
					alert('El número de tarjeta sólo debe contener dígitos');
					document.frmMedioCobro.<%= CompraHelper.CAMPO_NUMERO_TARJETA %>.focus();
					return;

				case 2:
					alert('Al número de tarjeta le faltan números');
					document.frmMedioCobro.<%= CompraHelper.CAMPO_NUMERO_TARJETA %>.focus();
					return;

				case 3:
					alert('Al número de tarjeta le sobran números');
					document.frmMedioCobro.<%= CompraHelper.CAMPO_NUMERO_TARJETA %>.focus();
					return;
			}

			if (isEmpty(document.frmMedioCobro.<%= CompraHelper.CAMPO_CODIGO %>.value)) {
				alert('Indicá un código de seguridad para la tarjeta');
				document.frmMedioCobro.<%= CompraHelper.CAMPO_CODIGO %>.focus();
				return;
			}

			if (!cantidadCaracteres(document.frmMedioCobro.<%= CompraHelper.CAMPO_CODIGO %>.value, 3, 4)) {
				alert('Debés indicar un código de seguridad válido');
				document.frmMedioCobro.<%= CompraHelper.CAMPO_CODIGO %>.focus();
				return;
			}

			if (isEmpty(document.frmMedioCobro.<%= CompraHelper.CAMPO_TITULAR %>.value)) {
				alert('Debés indicar un titular para la tarjeta');
				document.frmMedioCobro.<%= CompraHelper.CAMPO_TITULAR %>.focus();
				return;
			}

			if (isEmpty(document.frmMedioCobro.<%= CompraHelper.CAMPO_NRO_DOC %>.value)) {
				alert('Debés indicar un número de identificación personal');
				document.frmMedioCobro.<%= CompraHelper.CAMPO_NRO_DOC %>.focus();
				return;
			}

			if (isEmpty(document.frmMedioCobro.<%= CompraHelper.CAMPO_DOMICILIO_ENVIO %>.value)) {
				alert('Debés indicar una dirección de envío');
				document.frmMedioCobro.<%= CompraHelper.CAMPO_DOMICILIO_ENVIO %>.focus();
				return;
			}

		}

		if (isEmpty(document.frmMedioCobro.<%= CompraHelper.CAMPO_TELEFONO %>.value)) {
			alert('Ingresá un número de teléfono');
			document.frmMedioCobro.<%= CompraHelper.CAMPO_TELEFONO %>.focus();
			return;
		}

		if (isEmpty(document.frmMedioCobro.<%= CompraHelper.CAMPO_HORARIO %>.value)) {
			alert('Debés indicar un horario para el contacto');
			document.frmMedioCobro.<%= CompraHelper.CAMPO_HORARIO %>.focus();
			return;
		}

		<%
            if (ordenDAO.getDomicilioEnvio()!=null) {
                if (ordenDAO.getDomicilioEnvio().getIdPais().intValue() == CompraHelper.PAIS_BRASIL) {
        %>
                    if (isEmpty(document.frmMedioCobro.<%=CompraHelper.CAMPO_CPF_CNPJ%>.value)) {
                        alert('Por favor, ingresá tu código CPF/CNPJ.');
                        document.frmMedioCobro.<%=CompraHelper.CAMPO_CPF_CNPJ%>.focus();
                        return;
                    }
		<%  	}
            }
        %>

        if (!validarPrepaga()) {
            return;
        }
      


		document.frmMedioCobro.<%= CompraHelper.CAMPO_CUPON%>.value = quitaEspacios(document.frmMedioCobro.<%= CompraHelper.CAMPO_CUPON%>.value);
		if (document.frmMedioCobro.<%= CompraHelper.CAMPO_CUPON%>.value.length>2) {
			if (document.frmMedioCobro.<%= CompraHelper.CAMPO_CUPON%>.value.substring(0,2) == '28') {
				document.frmMedioCobro.<%= CompraHelper.CAMPO_CUPON%>.value = '';
			}
		}
		document.frmMedioCobro.submit();
	}

	function abrirAyuda() {
		window.open("/compra/ayudaTarjetas.jsp", "Codigo",
					"toolbar=no, location=no, directories=no, status=no, menubar=no, scrollbars=yes, resizable=yes, copyhistory=no, width=450, height=625 top=30, left=30");
	}

	var INDEX_TARJETA = 0;
    var tarjetaYPlan = new Array();


	function loadTarjeta() {
		var ctrl = document.frmMedioCobro.tarjetas;
		var value = ctrl.options[ctrl.options.selectedIndex].value;

			if(value != '') {
			<%
                   StringBuffer comboTarjetas = new StringBuffer();
                   for(int i = 0; i < tarjetasUsuario.size(); i++)
				{
			%>
                       if(value == <%= i %>) {
						document.frmMedioCobro.nroTarjeta.value = '<%= tarjetasUsuario.get(i) %>';
					}
			<%
					comboTarjetas.append("<option value=\""+i+"\">" + tarjetasUsuario.get(i) +"</option>" + Globals.ENTER);
			}
			%>
				document.frmMedioCobro.nroTarjeta.focus();
			} else {
				document.frmMedioCobro.reset();
			}
	}



<%

	double totalSinIntereses = ordenDAO.totalSitioCompletoSinIntereses();
	for (int i = 0; i < Globals.MEDIOS_DE_COBRO.length; i++) {
		MedioDeCobroDAO medioDeCobroDAO = Globals.MEDIOS_DE_COBRO[i];
		if (medioDeCobroDAO.esTarjeta() && medioDeCobroDAO.estaHabilitado()) {
			TarjetaPlanDAO planes[] = TarjetaPlanDAO.getParaMedio(medioDeCobroDAO);
%>
			tarjetaYPlan[tarjetaYPlan.length] = new Combo('<%= medioDeCobroDAO.getId() %>', '<%= medioDeCobroDAO.getNombre().toUpperCase() %>');
<%          for (int j = 0; j < planes.length; j++) {
				TarjetaPlanDAO plan = planes[j];
				if (totalSinIntereses >= plan.getMontoMinimo()) {
					StringBuffer textoAMostrar = Convert.capitalizarOriginal(plan.getDescripcion(), false);
					if (plan.getCoeficiente() == 1.0) {
						textoAMostrar.append(" (sin interés)");
					} else if (plan.getCoeficiente() > 1.0) {
						textoAMostrar.append(" (interés del ");
						textoAMostrar.append(Contenido.porcentajeToString((plan.getCoeficiente() - 1) * 100));
						textoAMostrar.append(")");
					}
%>
					tarjetaYPlan[tarjetaYPlan.length-1].addComboDependiente(new Combo('<%= plan.getClave() %>', '<%= textoAMostrar.toString().replaceAll("&nbsp;", " ").replaceAll(".-", " ").replaceAll("  ", " ") %>'));
<%              }
			}
		}
	}
%>

function MostrarDivs(id) {
	var sel = document.getElementById('MediosDePago');
          //starting at one, loop through until the number chosen by the user
          for(i = 1; i < sel.options.length; i++) {
           var div = document.getElementById(sel.options[i].value);
           //change visibility to block, or 'visible'
		if (sel.options[sel.options.selectedIndex].value ==	sel.options[i].value) {
      	        div.style.display = 'block';
      	        $('#barraCentral').get(0).style.height += $('#RIOHB').get(0).style.height;
		} else {
			div.style.display = "none";
		}
    }
}
</script>


<form name="frmMedioCobro" action="/SeleccionarMedioDeCobro" method="post">
<table width="740" border="0" cellpadding="0" cellspacing="0" class="Gtablacontenido" align="center">      
          <tr>
            <td  class="Gbarraizquierda"width="139">
            <table width="140" border="0" align="left" cellpadding="0" cellspacing="0">
              <tr>
                <td align="left" valign="top">
                	<img border="0" usemap="#navegadorCompra" src="/imagenes/compra/micompra-04.gif" width="140" height="139" />
                	<map name="navegadorCompra">
					  <area shape="rect" coords="18,35,107,52"
					      href="<%=CompraHelper.PAGINA_PAPEL_DE_REGALO%>"  title="Papel de Regalo">
					  <area shape="rect" coords="18,55,102,72"
					      href="<%=CompraHelper.PAGINA_DOMICILIO_+ DomicilioDAO.HEADER_ENVIO%>"  title="Datos de Envío">
					  <area shape="rect" coords="18,75,138,92"
					      href="<%=CompraHelper.PAGINA_DOMICILIO_ + DomicilioDAO.HEADER_FACTURACION%>"  title="Datos de Facturación">
					  <!-- area shape="rect" coords="18,95,60,112"
					      href="<%//=CompraHelper.PAGINA_MEDIO_DE_COBRO%>"  title="Pagar"-->
					  <area shape="rect" coords="18,115,132,132"
					      href="<%=CompraHelper.PAGINA_CONFIRMA_COMPRA%>"  title="Terminar la compra">
					</map>
                </td>
              </tr>
            </table></td>            
            <td class="Gcentro" width="422">
             <!-- agrgado -->
            	<table width="386" border="0" align="center" cellpadding="0" cellspacing="0" class="modulocompratop">
			    	<tr>
        				<td class="moduloayuda">
					        <div align="center">
					            <table width="366" border="0" cellpadding="0" cellspacing="0">
					            	<tr>
						                <td>
						                	<table width="366" border="0" cellspacing="0" cellpadding="0">
						                		<!-- VALIDACION QUID NO SE PUEDEN APLICAR NINGUN TIPO DE BENEFICIO -->
						                		<%boolean esSuscripcionQuid = CarritoUtil.estaEnlaOrden(ordenDAO,CarritoUtil.getAriculosExcluidos().get(0));%>
						                		<%if(!esSuscripcionQuid){ %>
                    							<tr>
							                    	<td height="30" colspan="3" valign="top" class="Ftexto02">
								                    	<span class="FTtit01">SI TIENE UN CUP&Oacute;N APL&Iacute;QUELO AQU&Iacute;</span><br />
									                    <span style="font-size:10px;">Podr&aacute;s ver aplicado tu beneficio luego de ingresar los datos de tu medio de pago.</span>
								                    </td>
								                 </tr>
							                     <tr>
								                     <td width="142" valign="bottom" class="Ftexto02">
									                     <div style="width:100%; height:17px; background-color:#FDFFCA; border-bottom:dashed 1px #666; border-top:dashed 1px #666; padding-top:2px;">Ingrese aqui su cup&oacute;n:</div>
								                     </td>
			                     					<%
														Object cuponObj = request.getSession().getAttribute(CompraHelper.PARAMETRO_CUPON);
														String cupon = Convert.toString((ordenDAO.getCupon() == null) ? cuponObj : ordenDAO.getCupon(), "");
														if (cupon.equals(Globals.CUPON_REFERIDO.getId())) {
															cupon = "";
														}
														for (int i = 0; i<Globals.CUPON_REFERENTE.length; i++) {
															if (cupon.equals(Globals.CUPON_REFERENTE[i].getId())) {
																cupon = "";
																break;
															}
														}
													%>

								                     <td width="224" colspan="2">
								                     	<div align="left"><input name="<%= CompraHelper.CAMPO_CUPON %>" value="<%=cupon%>" type="text" class="ayudatext" /></div>
								                     </td>
									             </tr>
									            <%}else { %>
									            	<input name="<%= CompraHelper.CAMPO_CUPON %>" value="" type="hidden" class="ayudatext" />
									            <%}//FIN VALIDACION QUID%>
							                </table>
							            </td>
						            </tr>
						        </table>
				          	</div>
				        </td>
				    </tr>
			    </table>
             <!-- agrgado -->

   				<table width="386" border="0" align="center" cellpadding="0" cellspacing="0" class="modulocompratop" style="margin-top:20px;">
				    <tr>
				        <td class="moduloayuda"><div align="center">
					        <table width="366" border="0" align="center" cellpadding="0" cellspacing="0">
					            <tr>
					                <td width="366" valign="bottom" class="Ftexto02">
					                	<table width="366" border="0" cellpadding="0" cellspacing="0">
                    						<tr>
							                    <td valign="middle">
							                    	<table width="366" border="0" cellspacing="0" cellpadding="0">
								                        <tr>
                            								<td height="22" colspan="3" valign="top" class="Ftexto02"><span class="FTtit01">ELIJA LA FORMA DE PAGO</span></td>
								                        </tr>
								                        <%
								                          	  boolean tieneMedioDeCobro=false;
													          int anoActual=0;
										            		  int vencimiento=0;
										            		  if (ordenDAO.getMedioDeCobro() != null) {
															      tieneMedioDeCobro = true;
     								 						  }
						 			                    %>

								                        <tr>
                            								<td width="141" valign="bottom" class="Ftexto02"><div style="width:100%; height:17px; background-color:#FDFFCA; border-bottom:dashed 1px #666; border-top:dashed 1px #666; padding-top:2px;">Seleccione la opci&oacute;n:</div></td>
								                            <td width="225" colspan="2">
									                            <div align="left">
								    		                        <select id='MediosDePago' name="<%= CompraHelper.CAMPO_MEDIO_COBRO %>" class="compraMenuMedio" onChange="javascript: MostrarDivs(document.getElementById('MediosDePago').value);" style="width:200">
											                            		<option value = "-1" <%= (!tieneMedioDeCobro)?"selected":""%> >Elija una opción</option>
												                            	<option value="<%= Globals.TIPO_MEDIO_DE_COBRO_TARJETAS %>" <%= (tieneMedioDeCobro && ordenDAO.getMedioDeCobro().esTarjeta()) ? " selected " : "" %>><%=TEXTO_TARJETA%></option>
														                      <% MedioDeCobroDAO rioHB = MedioDeCobroDAO.buscaMedioDeCobro(Globals.CLAVE_MEDIO_DE_COBRO_RIOHB);
						 													  	 if (rioHB.estaHabilitado()) {
						 													  %>
												                            	<option value="<%= Globals.CLAVE_MEDIO_DE_COBRO_RIOHB%>" <%= (tieneMedioDeCobro && ordenDAO.getMedioDeCobro().esHomeBanking()) ? " selected " : "" %>><%=rioHB.getNombre()%></option>
												                              <% }

												                              %>

												                              <% boolean estadoPagoFacil = false;
												                              	 MedioDeCobroDAO pagoFacil = MedioDeCobroDAO.buscaMedioDeCobro(Globals.CLAVE_MEDIO_DE_COBRO_PAGO_FACIL);
												                              	 estadoPagoFacil = (( ordenDAO.getAlgunDomicilioEnvio()!=null ) && pagoFacil.estaHabilitado() && ordenDAO.getAlgunDomicilioEnvio().getPais().esArgentina());/* &&
												                              	 			 socioPK.ID_SOCIO.equals(idSocioPrueba) && socioPK.ID_SUCURSAL.equals(idSucursalPrueba));  */
												                              	 if (estadoPagoFacil) {
												                              %>
												                              	 	<option value="<%= Globals.CLAVE_MEDIO_DE_COBRO_PAGO_FACIL%>" <%= (tieneMedioDeCobro && ordenDAO.getMedioDeCobro().esPagoFacil()) ? " selected " : "" %>><%=pagoFacil.getNombre()%></option>
												                              <%
												                              	 }
												                              %>

												                              <% boolean estadoRapiPago = false;
												                              	 MedioDeCobroDAO rapiPago = MedioDeCobroDAO.buscaMedioDeCobro(Globals.CLAVE_MEDIO_DE_COBRO_RAPI_PAGO);
												                              	 estadoRapiPago = (( ordenDAO.getAlgunDomicilioEnvio()!=null ) && rapiPago.estaHabilitado() && ordenDAO.getAlgunDomicilioEnvio().getPais().esArgentina());/* &&
												                              	 			 socioPK.ID_SOCIO.equals(idSocioPrueba) && socioPK.ID_SUCURSAL.equals(idSucursalPrueba));  */
												                              	 if (estadoRapiPago) {
												                              %>
												                              	 	<option value="<%= Globals.CLAVE_MEDIO_DE_COBRO_RAPI_PAGO%>" <%= (tieneMedioDeCobro && ordenDAO.getMedioDeCobro().esRapiPago()) ? " selected " : "" %>><%=rapiPago.getNombre()%></option>
												                              <%
												                              	 }
												                              %>

												                              <% boolean estadoDineroMail = false;
												                              	 MedioDeCobroDAO dineroMail = MedioDeCobroDAO.buscaMedioDeCobro(Globals.CLAVE_MEDIO_DE_COBRO_DINERO_MAIL);
												                              	 estadoDineroMail = ( ordenDAO.getAlgunDomicilioEnvio()!=null  && dineroMail.estaHabilitado() && ordenDAO.getAlgunDomicilioEnvio().getPais().esArgentina());/* &&
												                              	 			 socioPK.ID_SOCIO.equals(idSocioPrueba) && socioPK.ID_SUCURSAL.equals(idSucursalPrueba)); */
												                              	 if (estadoDineroMail) {
												                              %>
												                              	 	<option value="<%= Globals.CLAVE_MEDIO_DE_COBRO_DINERO_MAIL%>" <%= (tieneMedioDeCobro && ordenDAO.getMedioDeCobro().esDineroMail()) ? " selected " : "" %>><%=dineroMail.getNombre()%></option>
												                              <%
												                              	 }
												                              %>
																			
																			<%  /* Logica necesario para habilitar el medio de arcash*/
																				boolean estadoArcash = false;
												                              	MedioDeCobroDAO arcash = MedioDeCobroDAO.buscaMedioDeCobro(Globals.CLAVE_MEDIO_DE_COBRO_ARCASH);
												                              	estadoArcash = ( ordenDAO.getAlgunDomicilioEnvio()!=null  && arcash.estaHabilitado() && ordenDAO.getAlgunDomicilioEnvio().getPais().esArgentina());											                              	 	
											                              	 		if (estadoArcash) {
												                              %>
												                              	 	<option value="<%= Globals.CLAVE_MEDIO_DE_COBRO_ARCASH%>" <%= (tieneMedioDeCobro && ordenDAO.getMedioDeCobro().esArcash()) ? " selected " : "" %>><%=arcash.getNombre()%></option>
												                              <%
												                              	 }
												                              %>	

												                              <%
												                              	boolean estadoReembolso = false;
												                                //boolean esSuscripcionQuid = CarritoUtil.estaEnlaOrden(ordenDAO,CarritoUtil.getAriculosExcluidos().get(0));
												                              	MedioDeCobroDAO reembolso = MedioDeCobroDAO.buscaMedioDeCobro(Globals.CLAVE_MEDIO_DE_COBRO_CONTRAREEMBOLSO);
												                              	
																				estadoReembolso = (( ordenDAO.getAlgunDomicilioEnvio()!=null ) && reembolso.estaHabilitado() && ordenDAO.getAlgunDomicilioEnvio().getPais().esArgentina() && !esSuscripcionQuid);
											    								
											    								if (estadoReembolso) {

											    							  %>
													                            <option value="<%= Globals.CLAVE_MEDIO_DE_COBRO_CONTRAREEMBOLSO%>" <%= (tieneMedioDeCobro && ordenDAO.getMedioDeCobro().esReembolso()) ? " selected " : "" %>><%=reembolso.getNombre()%></option>
													                          <% }
												                              %>
													                          <%
	 												                            boolean estadoFax = false;
													                          	
																				MedioDeCobroDAO fax = MedioDeCobroDAO.buscaMedioDeCobro(Globals.CLAVE_MEDIO_DE_COBRO_FAX);
																				estadoFax = (fax.estaHabilitado());
																				String estadoFaxTexto = (estadoFax) ? " enabled " : " disabled ";
																			  %>
												                            	<option value="<%= Globals.CLAVE_MEDIO_DE_COBRO_FAX%>" <%= (tieneMedioDeCobro && ordenDAO.getMedioDeCobro().esFax()) ? " selected " : "" %>><%=fax.getNombre()%></option>
												                              
												                              <%
																				if (tarjetaPrepaga.estaHabilitado()) {
																			  %>
																				<option value="<%= Globals.CLAVE_MEDIO_DE_COBRO_TARJETA_PREPAGA%>" <%= (tieneMedioDeCobro && ordenDAO.getMedioDeCobro().esTarjetaPrePaga()) ? " selected " : "" %>><%=tarjetaPrepaga.getNombre()%></option>
																			  <% }
												                              %>
										                             </select>
						                            			</div>
						                            		</td>
								                        </tr>
								                        <tr>
                            								<td colspan="3" valign="bottom"></td>
								                        </tr>

                          								<tr>
								                            <td colspan="3" valign="bottom">
									                             <!-- pago con tarjeta !-->
                            									<div id="<%= Globals.TIPO_MEDIO_DE_COBRO_TARJETAS %>" style="display:none">
										                            <table width="365" border="0" cellpadding="0" cellspacing="0" style="margin-top:15px;">
											                            <tr>
                               												<td colspan="3" valign="bottom" style="padding-bottom:5px">
                               													<table width="366" border="0" align="left" cellpadding="0" cellspacing="0">
											                                    	<tr>
													                                    <td class="celdamodulodomicilio2">
													                                    	<table width="300" border="0" cellspacing="0" cellpadding="0">
														                                        <tr>
														                                            <td width="356" valign="middle" class="FTtit01"><%=TEXTO_TARJETA%></td>
														                                        </tr>
																                            </table>
																                        </td>
												                                    </tr>
												                                </table>
												                            </td>
											                            </tr>


											                            <%
													            			if (tarjetasUsuario.size() > 0) {
																		%>
											                            <tr>
											                                <td width="141" valign="bottom" class="Ftexto02">Tarjeta: </td>
											                                <td width="225" colspan="2"><div align="left">
											                                     <select name="tarjetas" onChange="loadTarjeta();" class="empleomenu">
																					 <option value="">&nbsp;</option>
																					 <%= comboTarjetas %>
														  				         </select>
											                                	</div>
											                                </td>
											                            </tr>
		                            									<%
		                            										}
		                            									%>

		                            									<%  boolean esTarjeta= false; %>
																		<%  if (ordenDAO.getMedioDeCobro() != null) {
																			      tieneMedioDeCobro = true;
										     									  esTarjeta = ordenDAO.getMedioDeCobro().esTarjeta();
																		  }
																		%>

																		<tr>
											                                <td valign="bottom" class="Ftexto02" colspan="3">
											                                	Ingrese el tipo de tarjeta que posee de la lista y los datos tal cual como figuran en el plástico. Complete los datos adicionales con su tipo y número de documento, y el domicilio donde llega su resumen.
																				<br>Por cualquier consulta contáctenos en nuestro departamento de venta telefónica al: 0810-33-EXTRA (39872).
											                                </td>
											                            </tr>

											                          <tr>
										                                 <td width="142" valign="bottom" class="Ftexto02">Tarjeta: </td>
										                                 <td width="224" colspan="2">
										                                 	<div align="left">
											                                 	<select name="<%=CompraHelper.CAMPO_TIPO_TARJETA%>" <% if (Globals.HABILITA_CUOTAS) { %> onchange="javascript:INDEX_TARJETA = actualizarCombo(this, document.frmMedioCobro.<%=CompraHelper.CAMPO_PLAN_DE_CUOTAS%>, tarjetaYPlan)" <% } %> class="empleomenu4">
											                                    	<script>
																						for(i = 0; i < tarjetaYPlan.length; i++) {
																					    var selected = '';
																					    <%  if (ordenDAO.getMedioDeCobro() != null) { %>
																					    if (tarjetaYPlan[i].id == '<%= ordenDAO.getMedioDeCobro().getId()%>') {
																					        INDEX_TARJETA =  i;
																					        selected = ' selected ';
																					    }
																			    		<%  } %>
																						document.write('<option value="' + tarjetaYPlan[i].id + '"' + selected + '>');
																						document.write(tarjetaYPlan[i].descripcion);
																						document.write('</option>');
																						}
																				  	</script>
											                                    </select>
										                                	</div>
										                                  </td>
										                                </tr>

											                            <tr>
											                                <td valign="bottom" class="Ftexto02">N&uacute;mero de tarjeta: </td>
											                                <td colspan="2"><div align="left">
											                                    <input name="<%= CompraHelper.CAMPO_NUMERO_TARJETA %>" value="<%= ((esTarjeta)? Convert.toString(ordenDAO.get_NumeroTarjetaCompletoDesencriptado()): "")%>" size="28" maxlength="20" type="text" class="ayudatext" />
											                                	</div>
											                                </td>
											                            </tr>
												                        <tr>
											                                <td valign="bottom" class="Ftexto02">C&oacute;digo de seguridad: </td>
											                                <td colspan="2"><div align="left">
											                                    <input name="<%= CompraHelper.CAMPO_CODIGO %>" value="<%= ((esTarjeta)? Convert.toString/*SinFormato*/(ordenDAO.get_CodigoSeguridad()): "")%>"  type="text" class="empleotext4date" />
											                                </div></td>
										                                </tr>
										                                <!-- AYUDA CODIGO DE SEGURIDAD -->
																		<tr>
																			<td></td>
											                       	        <td colspan="2" valign="bottom" class="Ftexto02">&nbsp;&nbsp;&nbsp;<a href="javascript:abrirAyuda()" class="FAyuda">Ayuda sobre el <b>C&oacute;digo  de  Seguridad</b></a></td>
																		</tr>
																		<tr>
																			<td>&nbsp;</td>
																		</tr>
																		<!-- FIN AYUDA CODIGO DE SEGURIDAD -->
											                            <tr>
											                                <td valign="bottom" class="Ftexto02">Fecha de expiraci&oacute;n: </td>
											                                <td colspan="2"><div align="left">
											                                     <select name="<%= CompraHelper.CAMPO_MES %>" class="empleomenu">
																					<%	for (int indexMes = 1; indexMes <= 12; indexMes++) { %>
																							<option value="<%= indexMes %>" <%= (indexMes == ordenDAO.get_MesVencimiento() && esTarjeta) ? " selected " : "" %>>
																								<%= indexMes %>
																							</option>
																					<%	} %>
												                                  </select>

												                                  <select  name="<%= CompraHelper.CAMPO_ANO %>" class="empleomenu">
																						<%	anoActual = new Date().getYear() + 1900;
																							vencimiento = (ordenDAO.get_AnoVencimiento() == 0) ? (anoActual + 1) : ordenDAO.get_AnoVencimiento();
																							for (int indexAnio = anoActual; indexAnio <= anoActual + 10; indexAnio++) { %>
																								<option value="<%=indexAnio%>" <%=(indexAnio == vencimiento && esTarjeta) ? "selected" : "" %>>
																									<%= indexAnio %>
																								</option>
																						<%	} %>
												                                  </select>

											                                </div></td>
											                            </tr>
											                            <%  if (Globals.HABILITA_CUOTAS) { %>
										                              	<tr>
											                               	<td valign="bottom" class="Ftexto02">Plan de cuotas: </td>
										    	                            <td colspan="2"><div align="left">
										        	                          <select name="<%= CompraHelper.CAMPO_PLAN_DE_CUOTAS %>" class="empleomenu4">
																				<script>
																					for(i = 0; i < tarjetaYPlan[INDEX_TARJETA].comboDependiente.length; i++) {
																					var selected = '';
																					<%  if (ordenDAO.getTarjetaPlanDAO() != null && esTarjeta) { %>
																						selected = (tarjetaYPlan[INDEX_TARJETA].comboDependiente[i].id == '<%= Convert.toString(ordenDAO.getTarjetaPlanDAO().getClave(), "") %>') ? ' selected ' : '';
																					<%  } %>
																					document.write('<option value="' + tarjetaYPlan[INDEX_TARJETA].comboDependiente[i].id + '"' + selected + '>');
																					document.write(tarjetaYPlan[INDEX_TARJETA].comboDependiente[i].descripcion);
																					document.write('</option>');
																					}
																				</script>
										                                      </select>
										                    	            </div></td>
										                	            </tr>

										                	            <tr>
																			<td>&nbsp;</td>
										                       	            <td valign="bottom" class="Ftexto02">&nbsp;&nbsp;&nbsp;"Plan de pago no v&aacute;lido para residentes<br>fuera de Argentina"</td>
																		</tr>
																		<tr>
																			<td>&nbsp;</td>
											 						    </tr>

																	 <%	 } %>
											                            <tr>
											                                <td valign="bottom" class="Ftexto02">Apellido y nombre: </td>
											                                <td colspan="2"><div align="left">
											                                    <input type="text" name="<%= CompraHelper.CAMPO_TITULAR %>" value="<%= (esTarjeta)? Convert.toString(ordenDAO.getNombreCliente()): "" %>" size="60" maxlength="50" class="ayudatext"/>
											                                </div></td>
											                            </tr>
											                            <tr>
											                                <td valign="bottom" class="Ftexto02">Identificaci&oacute;n persoal : </td>
											                                <td colspan="2"><div align="left">
											                                    <select  name="<%=CompraHelper.CAMPO_TIPO_DOC%>" class="empleomenu2">
											                                       <%	for (int td = 0; td < Globals.TIPOS_DOCUMENTO.length; td++) {
																							TipoDeDocumentoDAO tipoDeDocumentoDAO = Globals.TIPOS_DOCUMENTO[td]; %>
																						<option value="<%= tipoDeDocumentoDAO.getId() %>">
																							<%= tipoDeDocumentoDAO.getNombre() %>
																						</option>
																					<%	}%>
											                                    </select>
											                                </div></td>
											                            </tr>
											                            <tr>
											                                <td valign="bottom" class="Ftexto02">N&uacute;mero de identificaci&oacute;n: </td>
											                                <td colspan="2"><div align="left">
											                                    <input name="<%= CompraHelper.CAMPO_NRO_DOC %>" maxlength="15" value="<%= (esTarjeta)? Convert.toStringSinFormato(ordenDAO.getNumeroDocumento()): "" %>" class="ayudatext" />
											                                </div></td>
											                            </tr>
											                            <tr>
											                                <td valign="bottom" style="padding-top:12px"><div align="left"  class="Ftexto02">Domicilio de envio
											                                  del <br />
											                                  resumen de su tarjeta:</div></td>
											                                <td colspan="2" valign="bottom"><div align="left">
											                                    <input name="<%= CompraHelper.CAMPO_DOMICILIO_ENVIO %>" size="100" maxlength="500" value="<%= (esTarjeta)? Convert.toString(ordenDAO.getDomicilioResumen()): "" %>" class="ayudatext" />
											                                </div></td>
											                            </tr>
											                        </table>
									                            </div>
									                            <!-- END pago con tarjeta !-->
														     	<%  //MedioDeCobroDAO rioHB = MedioDeCobroDAO.buscaMedioDeCobro(Globals.CLAVE_MEDIO_DE_COBRO_RIOHB);
																	if (rioHB.estaHabilitado()) {
																%>

									                            <!-- pago con santander !-->
                            									<div id="<%= Globals.CLAVE_MEDIO_DE_COBRO_RIOHB%>" style="display:none;">
										                            <table width="365" border="0" cellpadding="0" cellspacing="0" style="margin-top:15px;">
											                            <tr>
                               												<td valign="bottom" style="padding-bottom:5px">
                               													<table width="366" border="0" align="left" cellpadding="0" cellspacing="0">
											                                    	<tr>
													                                    <td class="celdamodulodomicilio2">
													                                    	<table width="300" border="0" cellspacing="0" cellpadding="0">
														                                        <tr>
															                                        <td width="356" valign="middle" class="FTtit01"><%=rioHB.getNombre()%></td>
															                                    </tr>
															                                </table>
															                            </td>
												                                    </tr>
													                            </table>
													                        </td>
											                            </tr>
											                            <tr>
												                            <td class="Ftexto02">Ingrese al <a target="_blank" href="http://www.santanderrio.com.ar" class="FAyuda"><b><%=rioHB.getNombre() %></b></a>
												                            para realizar el pago de la orden, seg&uacute;n el n&uacute;mero otorgado luego de la confirmaci&oacute;n de la compra.
												                            Por cualquier consulta cont&aacute;ctenos en nuestro departamento de venta telef&oacute;nica al:<br />
												                              <%=Globals.TELEFONO_CALL_CENTER%>. </td>
												                        </tr>
														            </table>
									                            </div>
									                            <!-- END pago con santender !-->
									                             <% } %>
									                            <!-- pago contrareembolso !-->
									                            <%  if (estadoReembolso) {

										                       	%>
                            		                            <div id="<%= Globals.CLAVE_MEDIO_DE_COBRO_CONTRAREEMBOLSO%>" style="display:none;">
                            										<table width="365" border="0" cellpadding="0" cellspacing="0" style="margin-top:15px;">
											                            <tr>
												                            <td valign="bottom" style="padding-bottom:5px">
												                            	<table width="366" border="0" align="left" cellpadding="0" cellspacing="0">
												                                    <tr>
												                                      <td class="celdamodulodomicilio2">
												                                          <table width="300" border="0" cellspacing="0" cellpadding="0">
													                                      	  <tr>
													                                              <td width="356" valign="middle" class="FTtit01"><strong><%=TEXTO_REEMBOLSO + ((estadoReembolso) ? "" : " - No disponible")%></strong></td>
													                                          </tr>
													                                       </table>
													                                  </td>
												                                    </tr>

												                                </table>
												                            </td>
											                            </tr>
											                            <tr>
											                            <td>
													                        <tr>
													                          <td class="Ftexto02">IMPORTANTE: Recuerde que el env&iacute;o con cobro contrareembolso s&oacute;lo es v&aacute;lido dentro de la Rep&uacute;blica Argentina y tiene un costo adicional de 5,0% sobre el total de la orden. El mismo le ser&aacute; cobrado en el momento de la entrega. </td>
													                        </tr>
											                            </td>
											                            </tr>
                            										</table>
									                            </div>
 								                                <%} %>
									                            <!-- END pago con contrareembolso !-->

                            									<!-- pago fax !-->

																<% 
																	estadoFaxTexto = (estadoFax) ? " enabled " : " disabled ";
																%>
															 
									                            <div id="<%= Globals.CLAVE_MEDIO_DE_COBRO_FAX%>" style="display:none;">
										                            <table width="365" border="0" cellpadding="0" cellspacing="0" style="margin-top:15px;">
											                            <tr>
												                            <td valign="bottom" style="padding-bottom:5px">
												                            	<table width="366" border="0" align="left" cellpadding="0" cellspacing="0">
												                                    <tr>
													                                    <td class="celdamodulodomicilio2">
													                                    	<table width="300" border="0" cellspacing="0" cellpadding="0">
														                                        <tr>
														                                            <td width="356" valign="middle" class="FTtit01"><strong><%= TEXTO_FAX + ((estadoFax) ? "" : " - No disponible")%></strong></td>
																                                </tr>
																	                        </table>
																	                    </td>
												                                    </tr>
												                                </table>
												                            </td>
											                              </tr>
											                              <tr class="tabladomicilios">
												                            <td class="Ftexto02">Complete el <a target="_blank"  <%=estadoFaxTexto%> href="<%=CompraHelper.PAGINA_FAX%>" class="FAyuda"><b>Formulario</b></a>, impr&iacute;malo y env&iacute;elo por fax al n&uacute;mero <%=Globals.FAX_CALL_CENTER%>,
													                            o cont&aacute;ctenos en nuestro departamento de venta telef&oacute;nica al <%=Globals.TELEFONO_CALL_CENTER%> y cerraremos su compra.
												                            </td>
												                          </tr>
										                            </table>
									                            </div>
										                        
													            
									                            <!-- END pago con fax !-->
									                            <!-- TARJETA PREPAGA -->
																<%
																if (tarjetaPrepaga.estaHabilitado()) {
																%>
																<div id="<%= Globals.CLAVE_MEDIO_DE_COBRO_TARJETA_PREPAGA%>" style="display:none;">
																	<table width="365" border="0" cellpadding="0" cellspacing="0" style="margin-top:15px;">
															             <tr>
												                            <td>
												                            	<table width="366" border="0" align="left" cellpadding="0" cellspacing="0" onClick="seleccionarMedioCobroPorID('<%=tarjetaPrepaga.getId()%>')">
												                                	<tr>
													                                  	<td class="celdamodulodomicilio2">
													                                  		<table width="300" border="0" cellspacing="0" cellpadding="0">
		 											                                        	<tr>
												                                        			<td width="356" valign="middle" class="FTtit01"><%= tarjetaPrepaga.getNombre()%></td>
														                                        </tr>
			 											                                    </table>
			 											                                </td>
												                                	</tr>
												                            	</table>
												                            </td>
												                         </tr>

												                         <tr>
												                        	<td class="Ftexto02">
												                            	Ingrese aquí los códigos de las Tarjetas Prepagas que desea utilizar. <br>&nbsp;
													                        </td>
												    	                 </tr>

																	 	<tr>
												                      		<td colspan="2">
												                      			<table width="366" border="0" cellpadding="0" cellspacing="0" onClick="seleccionarMedioCobroPorID('<%=tarjetaPrepaga.getId()%>')">
												                        			<tr>
														                            	<td>
														                            		<table width="366" border="0" cellspacing="0" cellpadding="0">
																                            <%
																							int tarjetasCargadas=0;
																							if (tieneMedioDeCobro && ordenDAO.getMedioDeCobro().esTarjetaPrePaga()) {
																								for(tarjetasCargadas=0; tarjetasCargadas<ordenDAO.getTarjetasPrepagas().size(); tarjetasCargadas++) {

																							%>
																						    	<tr>
												                                			  		<td width="142" valign="bottom" class="Ftexto02">C&oacute;digo:</td>
																	                                <td width="224" colspan="2">
																	                                	<div align="left">
																	                                    	<input type="text" maxlength="32" size="45" name="<%=CompraHelper.CAMPO_TARJETA_PREPAGA + tarjetasCargadas%>"
												                                           						value="<%=((TarjetaPrepaga)ordenDAO.getTarjetasPrepagas().get(tarjetasCargadas)).getNro()%>" class="ayudatext"/>
												                                						</div>
												                                					</td>
																	                            </tr>
																	                  		<%
																									}
																								}
																	                    	%>
																		                    <%
																								for (int i=tarjetasCargadas; i<5; i++) {
																							%>
																							      <tr>
																	                                <td width="142" valign="bottom" class="Ftexto02">C&oacute;digo:</td>
																	                                <td width="224" colspan="2">
																	                                	<div align="left">
																	                                    	<input type="text" maxlength="32" size="45" name="<%=CompraHelper.CAMPO_TARJETA_PREPAGA + i%>" class="ayudatext" />
																	                                	</div>
																	                                </td>
																	                              </tr>
																							<%
																								}
																	    	                %>
												    	                   					</table>
												    	                   				</td>
												                        			</tr>
												                      			</table>
												                      		</td>
												                     	</tr>

											   	                  </table>
												               </div>
												              <%} %>
															<!-- FIN TARJETA PREPAGA -->

															  <!-- pago con pago facil !-->
									                            <%  if (estadoPagoFacil) {

										                       	%>
                            		                            <div id="<%= Globals.CLAVE_MEDIO_DE_COBRO_PAGO_FACIL%>" style="display:none;">
                            										<table width="365" border="0" cellpadding="0" cellspacing="0" style="margin-top:15px;">
											                            <tr>
												                            <td valign="bottom" style="padding-bottom:5px">
												                            	<table width="366" border="0" align="left" cellpadding="0" cellspacing="0">
												                                    <tr>
												                                      <td class="celdamodulodomicilio2">
												                                          <table width="300" border="0" cellspacing="0" cellpadding="0">
													                                      	  <tr>
													                                              <td width="356" valign="middle" class="FTtit01"><strong>Pago Fácil</strong></td>
													                                          </tr>
													                                       </table>
													                                  </td>
												                                    </tr>

												                                </table>
												                            </td>
											                            </tr>
											                            <tr>
											                            <td>
													                        <tr>
													                          <td class="Ftexto02">IMPORTANTE: El monto mínimo para operar con Pago Fácil es de $5. Al plazo habitual de salida del depósito de cada producto deberá sumarle 72hs hábiles luego de la realización del pago dado que ese es el tiempo que demoramos en recibir la constancia del mismo.
																					Al finalizar la compra deberá imprimir un cupón con el cual deberá realizar el pago en cualquier oficina de Pago Fácil para recibir su pedido.
																			  </td>
													                        </tr>
											                            </td>
											                            </tr>
                            										</table>
									                            </div>
 								                                <%} %>
									                            <!-- END pago con pago facil !-->

									                             <!-- pago con Rapi Pago !-->
									                            <%  if (estadoRapiPago) {

										                       	%>
                            		                            <div id="<%= Globals.CLAVE_MEDIO_DE_COBRO_RAPI_PAGO%>" style="display:none;">
                            										<table width="365" border="0" cellpadding="0" cellspacing="0" style="margin-top:15px;">
											                            <tr>
												                            <td valign="bottom" style="padding-bottom:5px">
												                            	<table width="366" border="0" align="left" cellpadding="0" cellspacing="0">
												                                    <tr>
												                                      <td class="celdamodulodomicilio2">
												                                          <table width="300" border="0" cellspacing="0" cellpadding="0">
													                                      	  <tr>
													                                              <td width="356" valign="middle" class="FTtit01"><strong>Rapi Pago</strong></td>
													                                          </tr>
													                                       </table>
													                                  </td>
												                                    </tr>

												                                </table>
												                            </td>
											                            </tr>
											                            <tr>
											                            <td>
													                        <tr>
													                          <td class="Ftexto02">IMPORTANTE: El monto mínimo para operar con Rapi Pago es de $5. Al plazo habitual de salida del depósito de cada producto deberá sumarle 72hs hábiles luego de la realización del pago dado que ese es el tiempo que demoramos en recibir la constancia del mismo.
																					Al finalizar la compra deberá imprimir un cupón con el cual deberá realizar el pago en cualquier oficina de Rapi Pago para recibir su pedido.
																			  </td>
													                        </tr>
											                            </td>
											                            </tr>
                            										</table>
									                            </div>
 								                                <%} %>
									                            <!-- END pago con Rapi Pago !-->

									                              <!-- pago con Dinero Mail !-->
									                            <%  if (estadoDineroMail) {

										                       	%>
                            		                            <div id="<%= Globals.CLAVE_MEDIO_DE_COBRO_DINERO_MAIL%>" style="display:none;">
                            										<table width="365" border="0" cellpadding="0" cellspacing="0" style="margin-top:15px;">
											                            <tr>
												                            <td valign="bottom" style="padding-bottom:5px">
												                            	<table width="366" border="0" align="left" cellpadding="0" cellspacing="0">
												                                    <tr>
												                                      <td class="celdamodulodomicilio2">
												                                          <table width="300" border="0" cellspacing="0" cellpadding="0">
													                                      	  <tr>
													                                              <td width="356" valign="middle" class="FTtit01"><strong>Dinero Mail</strong></td>
													                                          </tr>
													                                       </table>
													                                  </td>
												                                    </tr>
															                    </table>
												                            </td>
											                            </tr>
											                            <tr>
											                            <td>
													                        <tr>
													                          <td class="Ftexto02">IMPORTANTE: El monto mínimo para operar con Dinero Mail es de $5. Recuerde que al finalizar la compra deberá ingresar a Dinero Mail y realizar el pago correspondiente para recibir su pedido.
																					El plazo habitual de salida del depósito de cada producto comenzará a correr una vez efectivizado el pago de su compra.
																			  </td>
													                        </tr>
											                            </td>
											                            </tr>
                            										</table>
									                            </div>
 								                                <%} %>
									                            <!-- END pago con Dinero Mail !-->
									                            
									                            <!-- pago con ARCASH !-->
									                            <%  if (estadoArcash) {

										                       	%>
                            		                            <div id="<%= Globals.CLAVE_MEDIO_DE_COBRO_ARCASH%>" style="display:none;">
                            										<table width="365" border="0" cellpadding="0" cellspacing="0" style="margin-top:15px;">
											                            <tr>
												                            <td valign="bottom" style="padding-bottom:5px">
												                            	<table width="366" border="0" align="left" cellpadding="0" cellspacing="0">
												                                    <tr>
												                                      <td class="celdamodulodomicilio2">
												                                          <table width="300" border="0" cellspacing="0" cellpadding="0">
													                                      	  <tr>
													                                              <td width="356" valign="middle" class="FTtit01"><strong>Arcash</strong></td>
													                                          </tr>
													                                       </table>
													                                  </td>
												                                    </tr>
															                    </table>
												                            </td>
											                            </tr>
											                            <tr>
											                            <td>
													                        <tr>
													                          <td class="Ftexto02">
													                          		IMPORTANTE: Seleccione esta opci&oacute;n para abonar con los cupones prepagos Arcash.
																					Ingres&aacute; tus cupones Arcash, el pago ser&aacute; validado online y comenzar&aacute; a correr el plazo habitual de salida del dep&oacute;sito. 
																					M&aacute;s informaci&oacute;n en <a href="http://www.arcash.com.ar" target="_balnck">http://www.arcash.com.ar</a>
																			  </td>
													                        </tr>
											                            </td>
											                            </tr>
                            										</table>
									                            </div>
 								                                <%} %>
									                            <!-- END pago con Arcash !-->
									                        </td>
								                        </tr>
							                        </table>
							                    </td>
						                    </tr>
						                </table>
						            </td>
					            </tr>
				            </table>
				        </div>
				    </td>
			    </tr>
		    </table>
		     <table width="386" border="0" align="center" cellpadding="0" cellspacing="0" class="modulocompratop" style="margin-top:20px;">
		      <tr>
		        <td class="moduloayuda"><div align="center">
		          <table width="366" border="0" align="center" cellpadding="0" cellspacing="0">
		              <tr>
		                <td width="366"><table width="366" border="0" cellpadding="0" cellspacing="0">
		                    <tr>
		                      <td><table width="366" border="0" cellspacing="0" cellpadding="0">
		                          <tr>
		                            <td height="22" colspan="3" valign="top" class="Ftexto02"><span class="FTtit01">INGRESE DATOS DE CONTACTO</span></td>
		                          </tr>
		                          <tr>
		                            <td width="142" valign="bottom" class="Ftexto02">Tel&eacute;fono: </td>
		                            <td width="224" colspan="2"><div align="left">
		                                <input name="<%= CompraHelper.CAMPO_TELEFONO %>" maxlength="35" value="<%= Convert.toString(ordenDAO.getTelefonoContacto()) %>" class="ayudatext" />
		                            </div></td>
		                          </tr>
		                          <tr>
		                            <td valign="bottom" class="Ftexto02">Horario de contacto tel: </td>
		                            <td colspan="2"><div align="left">
		                                <input name="<%= CompraHelper.CAMPO_HORARIO %>" size="30" maxlength="40" value="<%= Convert.toString(ordenDAO.getHorarioContacto()) %>" class="ayudatext" />
		                            </div></td>
		                          </tr>
		                          <tr>
		                            <td height="26" valign="bottom" class="Ftexto02"><div align="left">Comentarios: </div></td>
		                            <td width="224" rowspan="2"><div align="left" class="Ftexto02">
		                                <textarea name="<%= CompraHelper.CAMPO_COMENTARIO %>" value="<%= Convert.toString(ordenDAO.getComentario()) %>" class="experienciatextarea" onkeyup="validarTextAreaLength(this, 'digitado', 'restante', 190)" onkeypress="validarTextAreaLength(this, 'digitado', 'restante', 190)"></textarea>
                                    <br>&nbsp;&nbsp;
                                    <span class="Ftexto02" id="digitado" style="color:red">0</span> Caracteres digitados / Restan <span class="Ftexto02" id="restante"  style="color:red">190</span>
		                            </div></td>
		                          </tr>
		                          <tr>
		                            <td height="74" valign="bottom" class="Ftexto02">&nbsp;</td>
		                          </tr>
		                          <tr><a name="datosReceptor">
		                            <td height="30" colspan="3" valign="middle" class="FTtit01">Datos de la persona autorizada a recibir el pedido:</td>
		                          </tr>
		                          <tr>
		                            <td valign="bottom" class="Ftexto02">Nombre(s): </td>
		                            <td colspan="2"><div align="left">
		                                <input type="text" name="<%=CompraHelper.CAMPO_NOMBRES_RECEPTOR%>" size="30" maxlength="50"
									value="<%=Convert.toString(ordenDAO.getNombresReceptor(), "")%>" class="ayudatext"  />
		                            </div></td>
		                          </tr>
		                          <tr>
		                            <td valign="bottom" class="Ftexto02">Apellido(s):</td>
		                            <td colspan="2"><div align="left">
		                                <input type="text" name="<%=CompraHelper.CAMPO_APELLIDOS_RECEPTOR%>" size="30" maxlength="50"
									value="<%=Convert.toString(ordenDAO.getApellidosReceptor(), "")%>" class="ayudatext" />
		                            </div></td>
		                          </tr>

		                      </table></td>
		                    </tr>
		                </table></td>
		              </tr>
		            </table>
		        </div></td>
		      </tr>
		    </table>
		    <!-- TARJETA EXTRA -->
			<% if (Globals.FIDELIZACION_VIGENTE) { %>
		     <table width="386" border="0" align="center" cellpadding="0" cellspacing="0" class="modulocompratop" style="margin-top:20px;">
      		 	<tr>
			        <td class="moduloayuda">
				        <div align="center">
					        <table width="366" border="0" align="center" cellpadding="0" cellspacing="0">
			  	              <tr>
                			  	<td width="366">
                			  		<table width="366" border="0" cellpadding="0" cellspacing="0">
					                    <tr>
						                	<td>
						                    	<table width="366" border="0" cellspacing="0" cellpadding="0">
							                         <tr><a name="datosExtra">
                            						 	 <td height="22" colspan="3" valign="top" class="Ftexto02"><span class="FTtit01">INGRESE LOS DATOS DE SU TARJETA EXTRA!</span></td>
								                     </tr>
								                     <tr>
								                     	<td width="142" valign="bottom" class="Ftexto02">
									                    	<div style="width:100%; height:17px; background-color:#FDFFCA; border-bottom:dashed 1px #666; border-top:dashed 1px #666; padding-top:2px;">N&ordm; de su tarjeta eXtra:</div>                            </td>
								                        <td width="224" colspan="2">
								                        	<div align="left">
								                        		<input type="text"  name="<%= CompraHelper.CAMPO_TARJETA_EXTRA %>" size="50" maxlength="20" value="<%= Convert.toString(ordenDAO.getNumeroTarjetaExtra()) %>" class="ayudatext"/>
								                            </div>
								                            </td>
							                          </tr>
							                      </table>
							                 </td>
						                  </tr>
						               </table>
						         </td>
				             </tr>
            			    </table>
				        </div>
				     </td>
			      </tr>
    		 </table>
    		 <% } %>
			<!-- FIN TARJETA EXTRA -->
			 <%
			     if(ordenDAO.getDomicilioEnvio() != null){
			   
			     	if (ordenDAO.getDomicilioEnvio().getIdPais().intValue() == CompraHelper.PAIS_BRASIL) {
			                String CPF="";
			                String CNPJ="";
			                String codCPF_CNPJ="";
			                if (ordenDAO.getCPF_CNPJ() !=  null) {
			                    if (ordenDAO.getCPF_CNPJ().indexOf("CPF") >-1) {
			                        CPF = "checked";
			                        codCPF_CNPJ = ordenDAO.getCPF_CNPJ().replaceAll("CPF ", "");
			                    } else {
			                        CNPJ = "checked";
			                        codCPF_CNPJ = ordenDAO.getCPF_CNPJ().replaceAll("CNPJ ", "");
			                    }
			                } else {
			                    CPF = "checked";
			                }
			 %>
			 <a name = "CPF_CNPJ"/>
			 <table width="386" border="0" align="center" cellpadding="0" cellspacing="0" class="modulocompratop" style="margin-top:20px;">
	            <tr>
		     	   <td colspan="2" class="moduloayuda">
		              	<table width="366" border="0" cellpadding="0" cellspacing="0">
		                   	<tr>
		                       	<td>
		                       		<table width="366" border="0" cellspacing="0" cellpadding="0">
		                           		<tr>
		                               		<td height="22" colspan="5" valign="top" class="Ftexto02"><span class="FTtit01">INGRESE CPF / CNPJ</span></td>
		                           		</tr>
		                           		<tr>
		                               		<td width="15" valign="bottom" class="Ftexto02">
		                               			<input type="radio" name="<%=CompraHelper.ES_CPF_CNPJ%>" value="CPF" <%=CPF%>>
		                           			</td>
				                            <td width="45" valign="bottom" class="Ftexto02">CPF</td>
				                            <td width="15" valign="bottom" class="Ftexto02">
		        	                        	<input type="radio" name="<%=CompraHelper.ES_CPF_CNPJ%>" value="CNPJ" <%=CNPJ%>>
		              		                </td>
		                       		        <td width="50" valign="bottom" class="Ftexto02">CNPJ</td>
				                            <td width="214">
				                              	<div align="left">
						                            <input type="text" name="<%=CompraHelper.CAMPO_CPF_CNPJ%>" size="50" maxlength="25" value="<%=codCPF_CNPJ%>" class="ayudatext"/>
		    			                        </div>
		    			                    </td>
	 		                            </tr>
		                       		</table>
		                       	</td>
		                    </tr>
		                </table>
		            </td>
		        </tr>
		     </table>
			 <%
					}
				 }
			 %>


		    <table width="386" border="0" align="center" cellpadding="0" cellspacing="0" class="modulocompratop" style="margin-top:20px;">
		      <tr>
		        <td class="moduloayuda">
		        <div align="center">
		          <table width="366" border="0" align="center" cellpadding="0" cellspacing="0">
		              <tr>
		                </tr>
		              <tr>

		              </tr>
		              <tr>
		                <td colspan="2"><table width="366" border="0" cellpadding="0" cellspacing="0">
		                    <tr>

		                    </tr>
		                </table></td>
		              </tr>
		              <tr>
		                <td width="276">&nbsp;</td>
		                <td width="90"><div align="right"><a href="javascript:validarMedioCobro();"><img src="/imagenes/compra/b-continuar.gif" alt="Continuar" width="74" height="10" border="0"></a></div></td>
		              </tr>
		            </table>
		        </div></td>
		      </tr>
		    </table>
 	 </td>
     <td class="Gbarraderecha" width="162">
     	<table width="162" border="0" cellspacing="0" cellpadding="0">
        	<tr>
                <td>
                	<table width="162" border="0" cellspacing="0" cellpadding="0" class="moduloorden">
                  		<tr>
                    		<td>
                    			<table width="148" border="0" align="center" cellpadding="0" cellspacing="0">
			                        <tr>
            			              	<td><p class="Ftexto02">EN ESTA  P&Aacute;GINA PODR&Aacute; ELEGIR LA FORMA   DE PAGO.</p>
            			             	</td>
                        			</tr>
                        			<tr>
			                          <td class="moduloordencelda"><span class="Ftexto02"><strong>Contrareembolso:</strong><br />
			                            Seleccione esta opci&oacute;n si prefiere abonar la compra en el momento en que recibe el pedido en su domicilio.</span></td>
			                        </tr>
			                        
			                        <tr>
			                          <td class="moduloordencelda"><span class="Ftexto02"><strong>Cup&oacute;n:</strong><br />
			                            - En el caso de poseer un cup&oacute;n especial de descuento, puede ingresarlo en el casillero correspondiente. <br />
			                            - Los descuentos obtenidos con este cup&oacute;n ser&aacute;n mostrados en la pantalla de confirmaci&oacute;n.</span></td>
			                        </tr>
			                        
			                         <tr>
			                          <td class="moduloordencelda"><span class="Ftexto02"><strong>Cupones Arcash:</strong><br />
			                            - Seleccione esta opción para abonar con los cupones prepagos arcash.
										- Al finalizar la compra deberás ingresar a arcash e ingresar el cup&oacute;n pregago.
										- M&aacute;s informaci&oacute;n en <a href="http://www.arcash.com.ar" target="_blank">http://www.arcash.com.ar</a>
			                        </tr>
			                        
			                         <tr>
			                          <td class="moduloordencelda"><span class="Ftexto02"><strong>Dinero Mail:</strong><br />
			                           	- Para abonar con Dinero Mail deber&aacute;s tener una cuenta registrada con dinero disponible en <a href="http://www.dineromail.com" target="_blank">http://www.dineromail.com</a>
										- Los tiempos de salida de despacho comenzarán a correr una vez que efectivices el pago de la compra.
			                           </span></td>
			                        </tr>
			                        
			                        <tr>
			                          <td class="moduloordencelda"><span class="Ftexto02"><strong>Fax:</strong><br />
			                            - Seleccione esta opci&oacute;n si desea completar un fax con los datos de la tarjeta y la orden. <br />
			                            - Luego deber&aacute; enviarlo a nuestras oficinas.</span></td>
			                        </tr>
			                        
			                        <tr>
			                          <td class="moduloordencelda"><span class="Ftexto02"><strong>Pago F&aacute;cil:</strong><br />
			                           	<!--- Seleccione esta opci&oacute;n si desea abonar su compra a trav&aacute;s de las oficinas de Pago F&aacute;cil.-->
			                           	- Al finalizar la compra deberás imprimir un cup&oacute;n con el cual podr&aacute;s realizar el pago en cualquier oficina de Pago Fácil.
										- Los tiempos de salida de despacho comenzar&aacute;n a correr una vez que efectivices el pago de la compra.			                           	
			                           </span></td>
			                        </tr>
			                        
			                        <tr>
			                          <td class="moduloordencelda"><span class="Ftexto02"><strong>Rapi Pago:</strong><br />
			                           	<!--- Seleccione esta opción si desea abonar su compra a través de las oficinas de Rapi Pago.-->
			                           	- Al finalizar la compra deber&aacute;ás imprimir un cupón con el cual podr&aacute;s realizar el pago en cualquier oficina de Rapi Pago.
										- Los tiempos de salida de despacho comenzarán a correr una vez que efectivices el pago de la compra.			                           	
			                           </span></td>
			                        </tr>
			                        
			                        <tr>
			                          <td class="moduloordencelda"><span class="Ftexto02"><strong>Santander Río Online Banking:</strong><br />
			                            - Seleccione esta opción si prefiere abonar la compra a través del sistema de Online Banking del banco Santander Río.  <br />
			                            - El pago se debitará de su cuenta bancaria.</span></td>
			                        </tr>
			                        
			                        <tr>
			                          	<td class="moduloordencelda"><span class="Ftexto02"><strong>Tarjeta de Cr&eacute;dito:</strong><br />
			                            - Deber&aacute; elegir el tipo de tarjeta que posee de la lista. <br />
			                            - A continuaci&oacute;n debe completar los datos de la tarjeta tal cual como figuran en el pl&aacute;stico. <br />
			                            - Por &uacute;ltimo, ingrese su tipo y n&uacute;mero de documento, y el domicilio donde llega su res&uacute;men.</span>
			                        	</td>
			                        </tr>
			                        
			                    </table>
			                </td>
                  		</tr>
                	</table>
                </td>
        	</tr>
     	</table>
     </td>
	</tr>
</table>
</form>
<%=Globals.getGoogleAnalyticsSSL()%>
<script languaje="javascript">
	MostrarDivs(document.getElementById('MediosDePago').value);
</script>
