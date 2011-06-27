<%@ page import="com.tmk.kernel.Globals,
                 com.tmk.kernel.MedioDeCobroDAO"%>
<tr>
	<td class="moduloayuda">
		<p class="FTtit01">&iquest;COMO COMPRAR EN TEMATIKA.COM?</p>
		<p class="Ftexto02"><b>Una compra fácil y rápida</b><br>Ingresá en el detalle del libro que deseás comprar haciendo un clic en el título. Agregalo en el carrito de compras haciendo un clic en este ícono:</p>                  
		<tr>
    		<td class="moduloayuda"><img src="/imagenes/carrito.jpg"></td>
	  	</tr>   
		<td class="moduloayuda">
			<p class="Ftexto02">Una vez realizada la operación anterior podrás visualizar el contenido de tu carrito de compras y tendrás la posibilidad de seguir comprando o confirmar la compra y proceder al pago.  
			</p>
			<p class="Ftexto02">En el proceso de pago si lo deseás, seleccioná el papel de regalo. 
			</p>
			<p class="Ftexto02">Una vez que hayas decidido no seguir comprando, continuá tu proceso eligiendo el método de pago. <br/>Las opciones son: 	
				<strong>Pago con Tarjeta
					<% for (int i = 0; i < Globals.MEDIOS_DE_COBRO.length; i++) {
						MedioDeCobroDAO medioDeCobro = Globals.MEDIOS_DE_COBRO[i];
						if (medioDeCobro.estaHabilitado() && (!medioDeCobro.esTarjeta())) {%>
							 - <%=medioDeCobro.getNombre()%>
						<%}%>
					<%}%>.
            	</strong>
            </p>
			
			<p class="Ftexto02">Luego de completados los datos según cada caso, continuá el proceso verificando la información de tu orden.
			</p>
			
			<p class="Ftexto02">Si todos los datos están correctos, podés verificar y terminar la compra. 
			</p>			
		 </td>	
   </td>
</tr>