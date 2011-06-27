<%@ page import="com.tmk.kernel.Globals,
                 com.tmk.kernel.MedioDeCobroDAO"%>
<tr>
	<td class="moduloayuda">
		<p class="FTtit01">&iquest;COMO COMPRAR EN TEMATIKA.COM?</p>
		<p class="Ftexto02"><b>Una compra f�cil y r�pida</b><br>Ingres� en el detalle del libro que dese�s comprar haciendo un clic en el t�tulo. Agregalo en el carrito de compras haciendo un clic en este �cono:</p>                  
		<tr>
    		<td class="moduloayuda"><img src="/imagenes/carrito.jpg"></td>
	  	</tr>   
		<td class="moduloayuda">
			<p class="Ftexto02">Una vez realizada la operaci�n anterior podr�s visualizar el contenido de tu carrito de compras y tendr�s la posibilidad de seguir comprando o confirmar la compra y proceder al pago.  
			</p>
			<p class="Ftexto02">En el proceso de pago si lo dese�s, seleccion� el papel de regalo. 
			</p>
			<p class="Ftexto02">Una vez que hayas decidido no seguir comprando, continu� tu proceso eligiendo el m�todo de pago. <br/>Las opciones son: 	
				<strong>Pago con Tarjeta
					<% for (int i = 0; i < Globals.MEDIOS_DE_COBRO.length; i++) {
						MedioDeCobroDAO medioDeCobro = Globals.MEDIOS_DE_COBRO[i];
						if (medioDeCobro.estaHabilitado() && (!medioDeCobro.esTarjeta())) {%>
							 - <%=medioDeCobro.getNombre()%>
						<%}%>
					<%}%>.
            	</strong>
            </p>
			
			<p class="Ftexto02">Luego de completados los datos seg�n cada caso, continu� el proceso verificando la informaci�n de tu orden.
			</p>
			
			<p class="Ftexto02">Si todos los datos est�n correctos, pod�s verificar y terminar la compra. 
			</p>			
		 </td>	
   </td>
</tr>