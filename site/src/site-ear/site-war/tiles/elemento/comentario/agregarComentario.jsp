<%@ page import="com.tmk.kernel.Globals,
				 com.tmk.controllers.comentario.ComentarioHelper,
				 com.tmk.src.socio.SocioPK,
				 com.tmk.kernel.Convert,
				 com.tmk.common.ComentarioClass"%>
<% response.addHeader("pragma", "no-cache");  %>
<%
SocioPK socioPK = (SocioPK)session.getAttribute("Registracion.socioPK");
SocioPK socioMigracion = (SocioPK)session.getAttribute("socioMigracion");
int idComentario = Convert.toNumber(request.getParameter(ComentarioHelper.CAMPO_ID_COMENTARIO), 0);
int idArticulo = Convert.toNumber(request.getParameter(ComentarioHelper.CAMPO_ARTICULO), 0);
if (idArticulo == 0) {
	idArticulo = Convert.toNumber(request.getParameter("ID_ARTICULO"), 0);
}
String nombreCompleto = (String)session.getAttribute("Registracion.nombreCompleto");

ComentarioClass comentario = new ComentarioClass(idComentario, idArticulo);

int idSucursal = Convert.toNumber(request.getParameter(ComentarioHelper.CAMPO_SUCURSAL), 0);
int idSocio = Convert.toNumber(request.getParameter(ComentarioHelper.CAMPO_SOCIO), 0);

//SocioLocalHome socioHome = (SocioLocalHome)DBUtil.getHome("Socio");
//SocioLocal socio = socioHome.findByPrimaryKey(socioPK);
%>



<script src="/js/Validation.js" type="text/javascript"></script>
<script type="text/javascript">
	function continuar() {
		if (document.formComentario.<%= ComentarioHelper.CAMPO_USO_NICKNAME%>[1].checked) {
                  if (document.formComentario.<%= ComentarioHelper.CAMPO_NICKNAME%>.value=='') {
                      alert ('Seleccionaste la opción de publicar un seudónimo. Por favor, escribí uno.')
                      document.formComentario.<%= ComentarioHelper.CAMPO_NICKNAME%>.focus();
                      return false;
                  }
              }
		if(isEmpty(document.formComentario.<%= ComentarioHelper.CAMPO_COMENTARIO %>.value)) {
			alert('Es obligatorio indicar un comentario.');
			document.formComentario.<%= ComentarioHelper.CAMPO_COMENTARIO %>.focus();
			return false;
             	}
              maxEvaluacion = <%= ComentarioHelper.MAXIMO_EVALUACION %>
	    minEvaluacion = <%= ComentarioHelper.MINIMO_EVALUACION %>
              evaluacion = false;
              for (i=minEvaluacion-1;i<maxEvaluacion;i++){
                  if (document.formComentario.<%= ComentarioHelper.CAMPO_EVALUACION %>[i].checked){
                      evaluacion = true;
                  }
              }
              if (!evaluacion){
		    alert ('Es obligatorio indicar un valor de evaluación.')
		    document.formComentario.<%= ComentarioHelper.CAMPO_EVALUACION %>[0].focus();
                  return false;
              }


             // document.formComentario.submit();
             return true;
	}

          function quitarNickName() {
              document.formComentario.<%= ComentarioHelper.CAMPO_NICKNAME%>.value='';
              return true;
          }

          function maxTextArea(txarea, maximo, lblDigitado, lblRestante) {
		var total = maximo;
		var tam = txarea.value.length;

		if (tam > total){
			aux = txarea.value;
			txarea.value = aux.substring(0,total);
			$(lblDigitado).innerHTML = total;
			$(lblRestante).innerHTML = 0;
		} else {
			$(lblDigitado).innerHTML = tam;
			$(lblRestante).innerHTML = total - tam;
		}
}
</script>


<table width="390" border="0" align="center" cellpadding="0" cellspacing="0" align="center">
       <tr>
       <form name="formComentario" method="POST" action="/Comentario" onsubmit="return continuar()">
       		<input type="hidden" name="<%= ComentarioHelper.CAMPO_SOCIO%>" value="<%=(idSocio != 0)? ""+idSocio: ""%>">
            <input type="hidden" name="<%= ComentarioHelper.CAMPO_SUCURSAL%>" value="<%=(idSucursal != 0)? ""+idSucursal: ""%>">
    		<input type="hidden" name="<%= ComentarioHelper.CAMPO_ID_COMENTARIO%>" value="<%=(idComentario != 0)? ""+idComentario: ""%>">
            <input type="hidden" name="<%= ComentarioHelper.CAMPO_ARTICULO%>" value="<%=idArticulo%>">
         <td>
     	<table width="390" border="0" cellpadding="0" cellspacing="0" class="moduloayudatop">
           <tr>
             <td width="50" class="titulosceldas"><img src="/imagenes/t-agregarcoment.gif" alt="Agregar comentario" width="204" height="12" /></td>
           </tr>
           <tr>
             <td class="moduloayuda"><table width="370" border="0" cellspacing="0" cellpadding="0">

                 <tr>
                   <td valign="bottom" class="Ftexto02"><table width="370" border="0" cellspacing="0" cellpadding="0">
                       <tr>
                         <td height="20" colspan="3" valign="top" class="Ftexto02"><span class="FProductosDetalle"><%=Convert.corregir(comentario.getTituloArticulo(), true).toUpperCase()%></span></td>
                       </tr>
                       <tr>
                         <td height="20" valign="top" class="Ftexto02"><table width="105" border="0" cellspacing="0" cellpadding="0">
                           <tr>
                             <td width="24" height="20" valign="top" class="Ftexto02"><input name="<%= ComentarioHelper.CAMPO_USO_NICKNAME%>" type="radio" value="false" onclick="return quitarNickName()" <%= (comentario.getNickName().equals(""))? "checked": ""%>/></td>
                             <td class="Ftexto02">Mostrar nombre:</td>
                           </tr>
                         </table></td>
                         <td width="238" colspan="2" valign="middle" class="Ftexto02" style="padding-left:9px"><%=nombreCompleto%></td>
                       </tr>
                       <tr>
                         <td valign="bottom" class="Ftexto02"><table width="105" border="0" cellspacing="0" cellpadding="0">
                             <tr>
                               <td width="24" height="20" valign="top" class="Ftexto02"><input  name="<%= ComentarioHelper.CAMPO_USO_NICKNAME%>" type="radio" value="true" /></td>
                               <td class="Ftexto02">Mostrar alias:</td>
                             </tr>
                         </table></td>
                         <td colspan="2" valign="bottom" class="Ftexto02"><input name="<%= ComentarioHelper.CAMPO_NICKNAME%>" type="text" class="ayudatext" value="<%= (comentario.getNickName().equals(""))? "" : comentario.getNickName()%>" maxlength="50" size="50" onclick="document.formComentario.<%= ComentarioHelper.CAMPO_USO_NICKNAME%>[1].checked=true" onkeypress="document.formComentario.<%= ComentarioHelper.CAMPO_USO_NICKNAME%>[1].checked=true" /></td>
                       </tr>
                       <tr class="experienciatabla2">
                         <td height="26" valign="bottom" class="Ftexto02" style="padding-left:23px"><div align="left">Comentario: </div></td>
                         <td colspan="2" rowspan="2"><div align="left">
                             <textarea name="<%= ComentarioHelper.CAMPO_COMENTARIO %>" class="experienciatextarea" onkeyup="maxTextArea(this, 4000, 'digitado', 'restante')" onkeypress="maxTextArea(this, 4000, 'digitado', 'restante')"></textarea>
                             <br>&nbsp;&nbsp;
                             <span class="Ftexto02"><font id="digitado" color="red">0</font> Caracteres digitados / Restan <font id="restante" color="red">4000</font></span>
                         </div></td>
                       </tr>
                       <tr class="experienciatabla2">
                         <td height="74" valign="bottom" class="Ftexto02">&nbsp;</td>
                       </tr>

                       <tr>
                         <td height="20" colspan="3" valign="bottom" class="Ftexto02" style="padding-left:23px">&nbsp;</td>
                       </tr>
                       <tr>
                         <td colspan="3" valign="middle" class="Ftexto02">
                         	<div style="border-bottom:solid 1px #666; padding-bottom:3px; margin-bottom:10px; font-weight:bold;">Calificaci&oacute;n</div>
                         </td>
                       </tr>
                       <tr>
  <%
                          for(int i=ComentarioHelper.MINIMO_EVALUACION;i<=ComentarioHelper.MAXIMO_EVALUACION;i++) {
                       %>
                       <tr>
                         <td valign="middle" class="Ftexto02">
                         <div align="right"><img src="/imagenes/coment-<%=i%>.gif"></div>
                         </td>
                         <td colspan="2" valign="bottom" class="Ftexto02"><table width="200" border="0" cellspacing="0" cellpadding="0">
                           <tr>
                             <td width="24" height="20" valign="top" class="Ftexto02">
                             <input name="<%= ComentarioHelper.CAMPO_EVALUACION %>" type="radio" value="<%=i%>" <%= (i==comentario.getEvaluacion())? "checked" : ""%>/></td>
                             <td class="Ftexto02"><%= ComentarioHelper.TEXTOS[i - ComentarioHelper.MINIMO_EVALUACION]%></td>
                           </tr>
                         </table></td>
                       </tr>
  <%
                     	}
  %>
  <tr>
                         <td height="20" colspan="3" valign="top" class="Ftexto02">
                         	<div align="right">
                        		 <input type="image" src="/imagenes/b-enviar.gif">
                         	</div>
                         </td>
                       </tr>
                   </table></td>
                 </tr>
             </table></td>
           </tr>
         </table>
     	</td>
     	</form>
     	</tr>
     	<tr>
         <!-- ultimos visitados -->
         <td>
         <%
     		String ultimosVisitadosPage = "/tiles/elemento/ultimosVisitados.jsp?idSeccion=" + Globals.SECCION_HOME;
     	 %>
     	<jsp:include page="<%=ultimosVisitadosPage%>"/>
         </td>
          <!-- ultimos visitados -->
       </tr>
</table>