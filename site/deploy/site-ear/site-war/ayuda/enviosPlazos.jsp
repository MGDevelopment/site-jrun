<%@ page import="com.tmk.kernel.Globals,
				 com.tmk.setup.Contenido,
                 com.tmk.kernel.DBUtil,
                 com.tmk.kernel.Convert,
                 java.util.Vector"%>

                    <td class="moduloayuda" align="left">
                                        <b><h5>Envío Gratis en Argentina con tus compras mayores a $150.- No Acumulable con otras promociones.
                                        </h5></b>
                    <div class="Ftexto02" style="font-size:15">
                    	<span class="FTtit01">MEDIOS DE ENVIO</span>
                      <br />
                      <br />
                      <b  class="Ftexto02" >Opciones de env&iacute;o:</b><br />
                      <span class="Ftexto02">Enviamos libros, discos y pel&iacute;culas a todo el mundo. </span><br />
                      <br />
                    <span class="Ftexto02">ARGENTINA:</span><br />
                    - <a href="#1" class="Flink02">Tiempo de Entrega </a><br />
                    - <a href="#2" class="Flink02">Gastos de env&iacute;o </a><br />
                    - <a href="#3" class="Flink02">Seguimiento del env&iacute;o </a><br />

                    - <a href="#4" class="Flink02">Pago Contrareembolso</a> <br />
                    <br />
                     <span class="Ftexto02">RESTO DEL MUNDO:</span><br />
                    - <a href="#5" class="Flink02">Tiempo de Entrega </a><br />
                    - <a href="#6" class="Flink02">Gastos de env&iacute;o </a><br />

                    - <a href="#7" class="Flink02">Seguimiento del env&iacute;o</a><br />
                    <br />
                    <a name="1" id="1"></a><br />
                    <span class="FTtit01">TIEMPO DE ENTREGA DENTRO DE ARGENTINA</span><br />
                    <br /> <span class="Ftexto02">
                    El tiempo de entrega depende de la disponibilidad del producto m&aacute;s el tiempo de env&iacute;o.
                      Los tiempos de env&iacute;o son los siguientes: <br />

                      <br />
                      <strong>Capital Federal:</strong> 48 horas h&aacute;biles.<br />
                      <strong>GBA:</strong> 72 horas h&aacute;biles.<br />
                      <strong>Interior del pa&iacute;s:</strong> 96 horas h&aacute;biles.
                      <br />

                      <br />
                      El horario de entrega para los pedidos dentro de Argentina es de Lunes a Viernes de 9 a 18hs. <br />
                      <br />
                        Por ejemplo: Un producto que en la p&aacute;gina figura con disponibilidad (salida del dep&oacute;sito) 48 horas hábiles y debe enviarse a Posadas demorar&aacute; en llegar 6 d&iacute;as, sin perjuicio de que pueda entregarse en un plazo inferior.
<br />
                        Tiempo de entrega = Disponibilidad + Tiempo de env&iacute;o<br />

                        Para mayores detalles consult&aacute; con nuestro Servicio de Atenci&oacute;n al Cliente <a href="mailto:<%=Globals.MAIL_CALL_CENTER%>"  class="Flink02"><%=Globals.MAIL_CALL_CENTER%></a>. <br />
                        <br /></span>
                        <span class="FTtit01"><a name="2" id="2"></a></span><br />
                        <span class="FTtit01">GASTOS DE ENV&Iacute;O DENTRO DE ARGENTINA<br />
                        </span>
                          <br />
						<span class="Ftexto02">
                        Los importes vigentes se detallan a continuaci&oacute;n:<br />
                        <br /></span>
                        <table cellspacing="0" cellpadding="0" class="Ftexto02">
                          <tr>
                            <td valign="center" align="center" bgcolor="#c0d9ff" height="20"><strong> Destino</strong></td>
                            <td valign="center" align="center" bgcolor="#c0d9ff"><strong>Enviado mediante &nbsp;</strong></td>

                            <td height="35" align="center" valign="center" bgcolor="#c0d9ff" al><strong> Primer<br />
                              producto</strong>(*)</td>
                            <td valign="center" align="center" bgcolor="#c0d9ff"><strong>&nbsp; Producto adicional</strong>(*)</td>
                          </tr>

                   <%
                   		Vector gastosEnvios = DBUtil.getGastosDeEnvio();
                   		for(int i=0; i<gastosEnvios.size();i=i+4){
                   %>
                          <tr>
                            <td valign="center" height="20" style="border-bottom:solid 1px #CCC"><%=Convert.capitalizar(gastosEnvios.get(i).toString(),true)%></td>
                            <td valign="center" align="middle" style="border-bottom:solid 1px #CCC"><%=Convert.capitalizar(gastosEnvios.get(i+1).toString(),true)%></td>
                            <td valign="center" align="right" style="border-bottom:solid 1px #CCC"><div align="center"><%=Contenido.precioToString(Convert.toNumber((Double)gastosEnvios.get(i+2),0))%></div></td>
                            <td valign="center" align="right" style="border-bottom:solid 1px #CCC"><div align="center"><%=Contenido.precioToString(Convert.toNumber((Double)gastosEnvios.get(i+3),0))%></div></td>
                          </tr>
					<%
                   		}
					%>
                        </table>
                        <br />
							* <span class="Ftexto02"><STRONG>Estos valores no incluyen Iva, el&nbsp;impuesto será sumado en el momento de la compra.</STRONG></SPAN>
						<br>
                        <span class="FTtit01"><a name="3" id="3"></a></span><br />
                        <span class="FTtit01">SEGUIMIENTO DEL ENV&Iacute;O DENTRO DE ARGENTINA</span><br />
                        <br /><span class="Ftexto02">
Una vez despachada la orden, recibir&aacute;s un mail donde te informaremos el n&uacute;mero de env&iacute;o.<br />
En el caso de los env&iacute;os en el Interior del Pa&iacute;s, encontrar&aacute;s en el mail de confirmaci&oacute;n de tu compra el n&uacute;mero de gu&iacute;a. Consult&aacute; la p&aacute;gina de <a href="http://www.correoargentino.com.ar" target="blank" class="Flink02"> Correo Argentino</a>, la empresa responsable de estos env&iacute;os, para efectuar el seguimiento de tu orden. <br />
</span>
<br />
<span class="FTtit01"><a name="4" id="4"></a></span><br />
<span class="FTtit01">PAGO POR CONTRAREEMBOLSO</span><br />
<br />
<span class="Ftexto02">
El pago por contrareembolso tiene un costo adicional del 5% del valor de la orden y es v&aacute;lido para toda la Rep&uacute;blica Argentina. <br /></span>
<br />
<a name="5" id="5"></a><br />
<span class="FTtit01">TIEMPO DE ENTREGA EN EL RESTO DEL MUNDO </span><br />
<br /><span class="Ftexto02">
El tiempo de entrega depende de la disponibilidad del producto más el tiempo de envío.
<br />

El tiempo de env&iacute;o var&iacute;a entre 72 a 96 horas dependiendo si se trata de una ciudad capital. <br />
Por ejemplo: Un producto que en la p&aacute;gina figura con disponibilidad (salida del dep&oacute;sito) 48 horas hábiles y debe enviarse a Madrid demorar&aacute; en llegar entre 5 y 6 d&iacute;as, sin perjuicio de que pueda entregarse en un plazo inferior.
<br />
Tiempo de entrega = Disponibilidad + Tiempo de env&iacute;o<br />
Para mayores detalles consult&aacute; con nuestro Servicio de Atenci&oacute;n al Cliente <a href="mailto:<%=Globals.MAIL_CALL_CENTER%>" class="Flink02"><%=Globals.MAIL_CALL_CENTER%></a>. <br />
</span>
<br />
<a name="6" id="6"></a><br />
<span class="FTtit01">GASTOS DE ENV&Iacute;O EN EL RESTO DEL MUNDO</span><br />
<br /><span class="Ftexto02">
Los importes vigentes se detallan a continuaci&oacute;n:<br /></span>
<br />
<table width="320" align="center" cellpadding="0" cellspacing="0" class="Ftexto02">
  <tr>
    <td valign="center" align="middle" bgcolor="#c0d9ff" height="20"><div align="center"><strong>Destino &nbsp;</strong></div></td>
    <td valign="center" align="right" bgcolor="#c0d9ff"><div align="center"><strong>&nbsp; Primer producto&nbsp;</strong></div></td>

    <td valign="center" align="right" bgcolor="#c0d9ff"><div align="center"><strong>&nbsp; Producto adicional&nbsp;</strong></div></td>
  </tr>
  <%
     Vector gastosEnviosRestoMundo = DBUtil.getGastosDeEnvioRestoMundo();
     for(int i=0; i<gastosEnviosRestoMundo.size();i=i+3){
  %>
  <tr>
    <td valign="center" height="20" style="border-bottom:solid 1px #CCC"><%=Convert.capitalizar(gastosEnviosRestoMundo.get(i).toString(),true)%></td>
    <td valign="center" align="right" style="border-bottom:solid 1px #CCC"><div align="center"><%=Contenido.precioDollarToString(Convert.toNumber((Double)gastosEnviosRestoMundo.get(i+1),0))%></div></td>
    <td valign="center" align="right" style="border-bottom:solid 1px #CCC"><div align="center"><%=Contenido.precioDollarToString(Convert.toNumber((Double)gastosEnviosRestoMundo.get(i+2),0))%></div></td>

  </tr>
  <%
  	}
  %>
</table>
<br />

<span class="Ftexto03">Nota: Los impuestos aduaneros pueden ser cargados al cliente una vez que el envío llega al país de destino. Estos impuestos son de exclusiva responsabilidad del cliente y varían en cada país sin previo aviso ni notificación. Dado que nosotros no estamos en condiciones de determinar la existencia ni el cargo exacto de dichos impuestos aduaneros, te recomendamos averiguarlo previamente contactándote con la oficina de Aduanas local de tu país para obtener información exacta y actualizada. Los cargos por desaduanaje son también de exclusiva responsabilidad del cliente y responden a normativas locales que se aplican en algunas aduanas del mundo. Debido a que no podemos controlar ni informarte con precisión de la existencia y montos de los mismos, rogamos consultarlo contactándote con la Aduana local.  <br />
  <br />
  <a name="7" id="7"></a><br />

</span>
  <span class="FTtit01">SEGUIMIENTO DEL ENV&Iacute;O EN EL RESTO DEL MUNDO </span><br />
  <br /><span class="Ftexto02">
Una vez despachada la orden, recibirás un mail donde te informaremos el número de guía aérea para poder rastrearlo. Consultá la página de <a href="http://www.dhl.com.ar">DHL</a> (www.dhl.com.ar), la empresa responsable de estos envíos, para efectuar el seguimiento de tu orden.  <br />
                    <br />
</span>
                    </div></td>
