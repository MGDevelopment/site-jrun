<%@page import="com.tmk.categoria.CategGrupoLocalHome"%>
<%@page import="com.tmk.kernel.DBUtil"%>
<%@page import="java.util.Iterator"%>
<%@page import="com.tmk.categoria.CategGrupoLocal"%>
<%@page import="com.tmk.kernel.Convert"%>
<%@page import="com.tmk.kernel.Globals"%>
<%@page import="com.tmk.kernel.ProvinciaDAO"%>
<%@page import="com.tmk.kernel.PaisDAO"%>
<%@page import="com.tmk.kernel.LocalidadDAO"%>

<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>


<% int cantidadExp = 5;%>
<script type="text/JavaScript">
	var provincias = new Array();
	<%
			PaisDAO paisDAO = Globals.ARGENTINA;
			ProvinciaDAO provincias[] = paisDAO.getProvincias();
    %>
    <%
			for (int j = 0; j < provincias.length; j++) {
				ProvinciaDAO provinciaDAO = provincias[j]; %>
				provincias[provincias.length] =new Combo(<%= provinciaDAO.getId() %>, '<%= provinciaDAO.getNombre() %>');
	<%			LocalidadDAO localidades[] = provinciaDAO.getLocalidades();
    %>
    <%
				for (int k = 0; k < localidades.length; k++) {
					LocalidadDAO localidadDAO = localidades[k]; %>
					provincias[provincias.length-1].addComboDependiente(new Combo(<%= localidadDAO.getId() %>, '<%= localidadDAO.getNombre() %>'));
	<%			}
			}
	%>
	var INDEX_PROVINCIA = 0;

	function validarForm(frm) {
				frm.nombre.optional = false;
				frm.apellido.optional = false;
                frm.fechaNac.date = true;
				frm.edad.optional = true;
				frm.tipoDocumento.optional = true;
				frm.nroDocumento.optional = true;
				frm.nroDocumento.number = true;
				frm.sexo.optional = false;
                frm.direccion.optional = false;
                frm.provincia.optional = false;
                frm.otraLocalidad.optional = true;
				if (frm.otraLocalidad.value != '') {
					frm.localidad.optional = true;
				} else {
					frm.localidad.optional = false;
				}
				frm.codigoPostal.optional = true;

                frm.telContacto1.optional = false;
				frm.telContacto2.optional = true;

                frm.email.optional = false;

				frm.nivelEstudio.optional = false;
				frm.estadoEstudio.optional = false;

                frm.institucion.optional = false;

                frm.ultimoCursado.optional = false;

                frm.areaEstudio.optional = false;

				frm.idioma1.optional = false;
				frm.idioma2.optional = true;
				frm.idioma3.optional = true;
				frm.nivelIdioma1.optional = false;
				frm.nivelIdioma2.optional = true;
				frm.nivelIdioma3.optional = true;

				frm.otroIdioma.optional = true;

				/*for (i=1; i<parseInt(frm.cantExp.value)+1; i++) {
					eval ('frm.fechaDesde' + i + '.optional = false;');
					eval ('frm.fechaHasta' + i + '.optional = true;');
					eval ('frm.fechaDesde' + i + '.date = true;');
                    eval ('frm.fechaHasta' + i + '.date = true;');
                	eval ('frm.empresa' + i + '.optional =  false;');
	                eval ('frm.actividad' + i + '.optional = false;');
	                eval ('frm.tipoCargo' + i + '.optional =  false;');
                    eval ('if (frm.tipoCargo' + i + '[0].checked) {' +
	                      'frm.cargo' + i + '.optional =  false;' +
                          'frm.funcion' + i + '.optional =  false;' +
                          'frm.ocupacion' + i + '.optional =  true;' +
	                      '} else {' +
	                      'frm.cargo' + i + '.optional =  true;' +
                          'frm.funcion' + i + '.optional =  true;' +
                          'frm.ocupacion' + i + '.optional =  false;' +
                          '}');
	                eval ('frm.motivoEgreso' + i + '.optional =  false;');
				}*/

               <%--for (i=parseInt(frm.cantExp.value)+1; i<=<%=cantidadExp%>; i++) {
                    eval ('frm.fechaDesde' + i + '.optional = true;');
                    eval ('frm.fechaHasta' + i + '.optional = true;');
                	eval ('frm.empresa' + i + '.optional = true;');
	                eval ('frm.actividad' + i + '.optional = true;');
	                eval ('frm.tipoCargo' + i + '.optional = true;');
	                eval ('frm.cargo' + i + '.optional = true;');
                    eval ('frm.funcion' + i + '.optional = true;');
	                eval ('frm.ocupacion' + i + '.optional = true;');
	                eval ('frm.motivoEgreso' + i + '.optional = true;');
                }--%>
                frm.puestoPostulado.optional = false;

                var verificado = verify(frm);

                if (!verificado) {
                   return verificado;
                }

                <%--if (!validaVendedor(frm)) {
                    alert ('Seleccioná al menos una especialidad para el puesto postulado');
                    frm.puestoPostulado.focus();
                    return false;
                }--%>

                return verificado;
            }



			function calculaEdad(frm){
				if (esFecha(frm.fechaNac)) {
					var fechaHoy = new Date();
					var ano = parseInt(fechaHoy.getFullYear());
					var mes = parseInt(fechaHoy.getMonth()) + 1;
					var dia = parseInt(fechaHoy.getDate());

					var fechaNac = frm.fechaNac.value.split('-');
					var anoNac = parseInt(fechaNac[2]);
					var mesNac = parseInt(fechaNac[1]);
					var diaNac = parseInt(fechaNac[0]);

					var edad = ano - anoNac;

					if (mesNac > mes) {
						edad = edad -1;
                    }
                    if (mesNac == mes && diaNac > dia) {
                        edad = edad -1;
                    }

                    frm.edad.value = edad + ' años';
                    document.getElementById("labEdad").style.display="";
                    //document.getElementById("valEdad").style.display="";
                    return;
				}
				    //document.getElementById("labEdad").style.display="none";
                    //document.getElementById("valEdad").style.display="none";

			}

			function actualizarOtraLocalidad() {
				if (document.frmCV.localidad.options[document.frmCV.localidad.selectedIndex].value==<%=Globals.CODIGO_OTRA_LOCALIDAD%>)	{
					document.frmCV.otraLocalidad.disabled=false;
					//document.frmCV.otraLocalidad.focus();
				} else {
					document.frmCV.otraLocalidad.disabled=true;
				}
			}


			/*function agregarExperiencia (nvo) {
				document.getElementById('sinExperiencia').style.display='none';

                if (parseInt(nvo.value) > 0) {
                    document.getElementById('quitar' + nvo.value).style.display='none';
                }
				nvo.value = parseInt(nvo.value) + 1;
				document.getElementById('exp' + nvo.value).style.display='';
				document.getElementById('quitar' + nvo.value).style.display='';

				if (nvo.value == 5) {
					document.getElementById('agregarExp').style.display = 'none';
				}
                eval('document.frmCV.fechaDesde' + nvo.value + '.focus()')

            }*/



			<%--function quitarExperiencia (nvo) {

       			document.getElementById('exp' + nvo.value).style.display='none';
				document.getElementById('agregarExp').style.display = '';
				nvo.value = parseInt(nvo.value) -1;

				if(parseInt(nvo.value)==0){
				document.getElementById('sinExperiencia').style.display='';
				}

				if (parseInt(nvo.value)>0) {
					document.getElementById('quitar' + nvo.value).style.display='';
				}
			}--%>



			function max(txarea, dig, res)
			{
				total = 250;
				tam = txarea.value.length;
				str="";
				str=str+tam;
				dig.innerHTML = str;
				res.innerHTML = total - str;

				if (tam > total){
					aux = txarea.value;
					txarea.value = aux.substring(0,total);
					dig.innerHTML = total
					res.innerHTML = 0
				}
			}

			function actualizaFechaHasta(chek, input) {
				//alert(chek.checked);
				if (chek.checked) {
					input.value='';
					input.disabled = true;
					input.optional = true;
				} else {
					input.value='dd-mm-aaaa';
					input.disabled = false;
					input.optional = false;
				}
			}

			function habilitaTipoVendedor(sel, tipos) {
				//alert(sel.options[sel.selectedIndex].value);
				if (sel.options[sel.selectedIndex].value=='Vendedor') {
					tipos.style.display='';
				} else {
					tipos.style.display='none';
				}
			}


			function aFecha(obj) {
				obj.value = obj.value.replace("/", "-");
				obj.value = obj.value.replace("/", "-");
			}


			<%--function validaVendedor(frm) {
				var valor = frm.puestoPostulado.options[frm.puestoPostulado.selectedIndex].value;
				var cant = parseInt(frm.cantTipoVendedor.value);
				var retorno = true;
				if (valor == 'Vendedor') {
                    retorno = false;
					for (i=0; i<cant; i++) {
						eval ('if (frm.tipoVendedor' + (i+1) + '.checked){retorno=true;}');
					}
				}
				return retorno;
			}--%>

</script>
<script language="javascript">
function completarDatos(mostrar) {
	frm = document.frmCV;
   	frm.empresa.value = '';
   	frm.puesto.value  = '';
   	frm.desde.value= '';
   	frm.hasta.value= '';
   	if(mostrar) {                                	
   		document.getElementById('divEmpresa').style.display  = '';
   		document.getElementById('divPuesto').style.display  = '';
   		document.getElementById('divDesde').style.display  = '';
   		document.getElementById('divHasta').style.display  = '';
	}else {
		document.getElementById('divEmpresa').style.display  = 'none';
   		document.getElementById('divPuesto').style.display  = 'none';
   		document.getElementById('divDesde').style.display  = 'none';
   		document.getElementById('divHasta').style.display  = 'none';
	}
}    
	
</script>
<div style="margin-top: 10px;">	
	<div class="compraWrapper2">
		<table align="center"><tr>
			<td class="Gcentro" width="500">

				<table width="386" border="0" align="center" cellpadding="0" cellspacing="0" >

              <tr>
                <td><table width="386" border="0" cellpadding="0" cellspacing="0" class="moduloayudatop">
                  <tr>
                    <td width="50" class="titulosceldas"><img src="/imagenes/inicio/t-empleo.gif" alt="Oportunidad de Empleo" width="220" height="12" /></td>
                  </tr>

                  <tr>
                 <%--  <form name="frmCV" action="/EnviarCV" method="post"  onsubmit="return validarForm(this);"> --%>
                 <%--<form name="frmCV" action="/enviarEmpleo.do" method="post" >--%>
                 <html:form action="enviarEmpleo" >
                    <td class="moduloayuda">
                    <table width="450" border="0" cellspacing="0" cellpadding="0">

                        <tr>
                          <td colspan="3" valign="bottom" class="FTtit01">DATOS PERSONALES </td>
                          </tr>
                        <tr>
                          <td width="142" valign="bottom" class="Ftexto02"><span class="Ftextorojo">*</span> Nombre: </td>
                          <td colspan="2"><div align="left">
                            <html:text property="nombre" styleClass="ayudatext"/>
                          </div></td>
                           <td width="130">
                          	<html:errors property="nombre"/>
                          </td>
                        </tr>
                        <tr>
                          <td valign="bottom" class="Ftexto02"><span class="Ftextorojo">*</span> Apellido: </td>
                          <td colspan="2"><div align="left">                              
                              <html:text property="apellido" styleClass="ayudatext"/>
                          </div></td>
						<td width="130">
                          	<html:errors property="apellido"/>
                          </td>
                        </tr>

						<tr>
                          <td valign="bottom" class="Ftexto02"><span class="Ftextorojo">*</span> Fecha de nacimiento:<br><B>&nbsp; (dd-mm-aaaa)</B> </td>
                          <td colspan="2"><div align="left">
                          <html:text property="fechaNac" styleClass="empleotext4date" onblur="calculaEdad(frmCV)"/>
                            <span id="labEdad" class="Ftexto02" >Edad:
                             <html:text property="edad" styleClass="Ftexto02" style="border-width:1" size="6" readonly="true" />
                            </span>
                          </div></td>
                          <td width="130">
                          	<html:errors property="fechaNac"/>
                          </td>
                        </tr>
                        <tr>
                          <td valign="bottom" class="Ftexto02"><span class="Ftextorojo">&nbsp;&nbsp;</span>  Documento de identidad: </td>
                          <td width="58"><div align="left">
                            <html:select property="tipoDocumento" styleClass="empleomenu">
                            <html:option value="">Tipo</html:option>
                            <html:option value="dni">DNI</html:option>
                            <html:option value="ci">CI</html:option>
                            </html:select>
                            </div></td>
                          <td width="150"><div align="left">
                            <html:text property="nroDocumento" styleClass="empleotext"/>
                            <html_t
                          </div></td>                          
                        </tr>
                        <tr>
                          <td height="28" valign="bottom" class="Ftexto02"><span class="Ftextorojo">* </span>Sexo: </td>

                          <td height="28" colspan="2" valign="bottom" style="padding-left:3px; text-align:left"><div align="left" class="Ftexto02">
                            <html:radio property="sexo" value="Masculino"></html:radio>
                            	Masculino
                          	<html:radio property="sexo" value="Femenino"></html:radio>
                          		Femenino
						</div></td>
						  <td width="130">
                           	<html:errors property="sexo"/>
                          </td>
                        </tr>
                        <tr>
                          <td valign="bottom" class="Ftexto02"><span class="Ftextorojo">*</span> Direcci&oacute;n: </td>

                          <td colspan="2"><div align="left">
                              <%--<input name="direccion" nombre="Direccion" type="text" class="ayudatext" />--%>
                              <html:text property="direccion" styleClass="ayudatext"/>
                          </div></td>
                          <td width="130">
                          	<html:errors property="direccion"/>
                          </td>
                        </tr>
                        <tr>
                          <td height="28" valign="bottom" class="Ftexto02"><span class="Ftextorojo">&nbsp;&nbsp;</span>  Pa&iacute;s: </td>
                          <td height="28" colspan="2" valign="bottom" style="padding-left:9px"><div align="left" class="Ftexto02">Argentina</div></td>
                        </tr>
                        <tr>
                          <td height="28" valign="bottom" class="Ftexto02"><span class="Ftextorojo">*</span> Provincia: </td>
                          <td height="28" colspan="2" ><div align="left">

                         <select name="provincia" onChange="javascript:INDEX_PROVINCIA = actualizarCombo(this, document.frmCV.localidad, provincias);" class="empleomenu2">                        
							<script type="text/javascript">
								for(i = 0; i < provincias.length; i++) {
								var selected;

								if (provincias[i].id == 402) {
									selected =  " selected ";
									INDEX_PROVINCIA = i ;
								} else {
									selected = ""
								}

								document.write('<option value="' + provincias[i].id + '"' + selected + '>');
								document.write(provincias[i].descripcion);
								document.write('</option>');
							}
							</script>
						</select>


                          </div></td>
                          <td width="130">
                          	<html:errors property="provincia"/>
                          </td>
                        </tr>
                        <tr>
                          <td height="28" valign="bottom" class="Ftexto02"><span class="Ftextorojo">*</span> Localidad: </td>
                          <td height="28" colspan="4"><div align="left">

                          <select name="localidad" class="empleomenu3" onChange="actualizarOtraLocalidad()">
    					    <script type="text/javascript">
								for(i = 0; i < provincias[INDEX_PROVINCIA].comboDependiente.length; i++)
								{
									document.write('<option value="' + provincias[INDEX_PROVINCIA].comboDependiente[i].id + '" ' + '>');
									document.write(provincias[INDEX_PROVINCIA].comboDependiente[i].descripcion);
									document.write('</option>');
								}
							</script>
						 </select>

                            <span class="Ftexto02">Otra</span>
                            <!-- <input name="otraLocalidad" type="text" class="empleotext2" nombre="Otra localidad" />-->
                            <html:text property="otraLocalidad"  styleClass="empleotext2" />
                            <html:errors property="localidad"/>
                          </div></td>
                          <%-- <td width="100">
                          	<html:errors property="localidad"/>
                          </td>--%>
                        </tr>

                        <tr>
                          <td valign="bottom" class="Ftexto02"><span class="Ftextorojo">*</span> C&oacute;digo postal: </td>
                          <td colspan="2"><div align="left">
                            <html:text property="codigoPostal" styleClass="empleotext"/>
                          </div></td>
                          <td width="130">
                          	<html:errors property="codigoPostal"/>
                          </td>
                        </tr>
                        <tr>

                          <td height="35" colspan="3" valign="bottom" class="Ftexto02"><span class="FTtit01">DATOS DE CONTACTO</span></td>
                          </tr>
                        <tr>
                          <td valign="middle" class="Ftexto02"><span class="Ftextorojo">*</span> Tel&eacute;fonos de contacto: </td>
                          <td colspan="2" style="padding-left:1px"><div align="left" class="Ftexto02">1
                            <html:text property="telContacto1" styleClass="empleotext2"/>
                            <span class="Ftextorojo">&nbsp;&nbsp;</span>2
							<html:text property="telContacto2" styleClass="empleotext2"/>
                          </div></td>
                          <td width="130">
                          	<html:errors property="telContacto1"/>
                          </td>
                        </tr>
                        <tr>
                          <td valign="bottom" class="Ftexto02"><span class="Ftextorojo">*</span> E-mail: </td>
                          <td colspan="2"><div align="left">
                              <html:text property="email" styleClass="ayudatext"/>  
                          </div></td>
							<td width="130">
                          		<html:errors property="email"/>
                          </td>
                        </tr>
                        <tr>
                          <td height="35" colspan="3" valign="bottom"><div align="left"><span class="FTtit01">ESTUDIOS</span></div></td>
                          </tr>
                        <tr>
                          <td valign="bottom" class="Ftexto02"><span class="Ftextorojo">*</span> M&aacute;ximo nivel alcanzado: </td>

                          <td colspan="2"><div align="left">
                            <html:select property="nivelEstudio" styleClass="empleomenu2">
                            	<html:option value="Secundaria">Secundario</html:option>
                            	<html:option value="Diploma Técnico">Diploma T&eacute;cnico</html:option>
                            	<html:option value="Universitario">Universitario</html:option>
                            	<html:option value="Master / Magister / Maestría">Master / Magister / Maestr&iacute;a</html:option>
                            	<html:option value="Doctorado">Doctorado</html:option>
                           </html:select>
                          </div></td>
                        </tr>
                        <tr>
                          <td valign="bottom" class="Ftexto02">&nbsp;</td>
                          <td colspan="2"><div align="left"> 
                            <html:select property="estadoEstudio" styleClass="empleomenu2">
                            	<html:option value="Completo">Completo</html:option>
								<html:option value="En Curso">En Curso</html:option>
								<html:option value="Abandonado">Abandonado</html:option>
                            </html:select>
                          </div></td>
                          <td width="130">
                          	<html:errors property="nivelEstudio"/>
                          </td>
                        </tr>
                                               
                        <tr>
                          <td colspan="3" height="35" valign="bottom" class="FTtit01">DATOS LABORALES</td>
                          </tr>
                        <tr>
                          <td height="28" valign="bottom" class="Ftexto02"><span class="Ftextorojo">*</span> Qu&eacute; puesto te gustar&iacute;a ocupar </td>
                          <td colspan="2"><div align="left"> 
                            <html:select property="puestoDeseado" styleClass="empleomenu2">
                            	<html:option value="vendedor">Vendedor</html:option>
								<html:option value="cajero">Cajero</html:option>
								<html:option value="logistica">Log&iacute;stica</html:option>
								<html:option value="administracion">Administracion</html:option>
                            </html:select>
                          </div></td>
                          <td width="130">
                          	<html:errors property="puestoDeseado"/>
                          </td>
                        </tr>
                        <tr>
									<td height="28" valign="middle" class="Ftexto02"><span
										class="Ftextorojo">*</span> Qu&eacute; turno te
									gustar&iacute;a:</td>
									<td height="28" colspan="2" valign="bottom" style="padding-left:3px; text-align:left">
                          <div align="left" class="Ftexto02">
                            <html:radio property="turno" value="Part-Time(24hs: vi,sa,do)"/>Part-Time(24hs: vi,sa,do)<br>
                            <html:radio property="turno" value="Part-Time(4hs. diarias)"/>Part-Time(4 hs. diarias)<br>
                            <html:radio property="turno" value="Full-Time"/>Full-Time
                          		
						 </div></td>
                        </tr>      
                        
                        <tr>
                          <td height="28" valign="bottom" class="Ftexto02"></span>¿Trabaja actualmente? </td>
                          <td height="28" colspan="2" valign="bottom" style="padding-left:3px; text-align:left">
                          <div align="left" class="Ftexto02">
                            <html:radio property="trabaja" value="true" onclick="completarDatos(true);"/>Si
                            <html:radio property="trabaja" value="false" onclick="completarDatos(false);"/>No
						 </div></td>
                        </tr>
                        <tr id="divEmpresa" style="display:none;">
                          <td valign="bottom" class="Ftexto02"><span class="Ftextorojo">*</span> Empresa: </td>
                          <td colspan="2"><div align="left">
                              <html:text property="empresa" styleClass="ayudatext"/>
                          </div></td>
                          <td width="130">
                          	<html:errors property="empresa"/>
                          </td>
                        </tr>
                        <tr id="divPuesto" style="display:none;">
                          <td valign="bottom" class="Ftexto02"><span class="Ftextorojo">*</span> Puesto: </td>
                          <td colspan="2"><div align="left">
                              <html:text property="puesto" styleClass="ayudatext"/>
                          </div></td>
                          <td width="130">
                          	<html:errors property="puesto"/>
                          </td>
                        </tr>                       
                        <tr id="divDesde" style="display:none;">
                          <td valign="bottom" class="Ftexto02"><span class="Ftextorojo">*</span> Desde: </td>
                          <td colspan="2"><div align="left">
                              <html:text property="desde" styleClass="ayudatext"/>
                          </div></td>
                          <td width="130">
                          	<html:errors property="desde"/>
                          </td>
                        </tr>
                        <tr id="divHasta" style="display:none;">
                          <td valign="bottom" class="Ftexto02"><span class="Ftextorojo">*</span> Hasta: </td>
                          <td colspan="2"><div align="left">
                              <html:text property="hasta" styleClass="ayudatext"/>
                          </div></td>
                          <td width="130">
                          	<html:errors property="hasta"/>
                          </td>
                        </tr>
                        </tr>
                        <td>&nbsp;</td>
                        <td colspan="2"><div align="right"><input type="image" src="/imagenes/inicio/b-enviar.gif" alt="Enviar" class="benviar2" width="47" height="9" border="0"></div></td></tr>
                     </table>

                 </td>
                 </html:form>
                 <%--</form> --%>
                </tr>
               </table>
              </td>
              </tr>
             </table>
             <%--
              <td class="Gbarraderecha" width="162">
              <table width="162" border="0" cellspacing="0" cellpadding="0">
         	 	
                	<% String urlInstitucionalRight = "/tiles/elemento/institucional/institucionalRight.jsp?idSeccion=" + Globals.SECCION_HOME;%>
				  	<jsp:include page="<%=urlInstitucionalRight%>"/>             	
            </table>
			</td>
			--%>
</tr>
</table>
</div>
</div>
<script language="javascript">
	//setTimeout('chke(\'\')',1000);
	function chke(){
	var chk = document.frmCV.trabaja;
	var mostrar;
	for(var i=0;i<chk.length;i++) {	
		if(chk[i].checked = 'ckecked'){
			mostrar = chk[i].disabled;
			break;
		}
	}
			
	if(mostrar) {                                	
   		document.getElementById('divEmpresa').style.display  = '';
   		document.getElementById('divPuesto').style.display  = '';
   		document.getElementById('divDesde').style.display  = '';
   		document.getElementById('divHasta').style.display  = '';
	}else {
		document.getElementById('divEmpresa').style.display  = 'none';
   		document.getElementById('divPuesto').style.display  = 'none';
   		document.getElementById('divDesde').style.display  = 'none';
   		document.getElementById('divHasta').style.display  = 'none';
	}
	}
</script>