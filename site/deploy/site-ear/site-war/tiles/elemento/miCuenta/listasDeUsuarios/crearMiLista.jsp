<div style="margin-top: 10px;">	
	<div class="compraWrapper2"><!-- style="background-color: #FBF5EF">-->
			<div class="cProcTit" style="margin-top: 0pt;"><span>Crear lista:</span></div>
			<form action="/CrearLista" metho="POST" onkeypress="manejarEvento(event,'modalDom','modalBack');" name="frmCrearLista" id="frmCrearLista">
		        <div class="cProcFor-wrapper2 cProcForms2">
		            <b style="margin-bottom: 0pt;">Nombre de la lista</b>
		            <div style="margin-bottom: 0pt;">
		            	<span style="margin-right: 10px;">
		            		<input type="text" style="width: 260px;" name="titulo" value="">
		            	</span>
		            </div>
		        </div>
		        <div class="cProcFor-wrapper2 cProcForms2">
		            <b style="margin-bottom: 0pt;">¿Querés comparirla con la comunidad?</b>
		            <div style="margin-bottom: 0pt;width:50px;">
		            	<input type="radio" name="publica" checked="checked" value="S">Si
		        	</div>
		        	<div style="margin-bottom: 0pt;width:55px;">
		            	<input type="radio" name="publica" value="N">No
		        	</div>
		        </div>
		        
		        <div class="cProcFor-wrapper2 cProcForms2">
		            <b style="margin-bottom: 0pt;">Unas palabras sobre tu lista (ayudarán a los demás usuarios a encontrarla)</b>
		            <div style="margin-bottom: 0pt;width:260px;">
		            	<textarea style="width: 260px;" name="descripcion" cols="5" rows="3" class="area" id="lblDescripcion" onkeypress="validarTextAreaLength(this, 'digitado', 'restante', 150)" onkeyup="validarTextAreaLength(this, 'digitado', 'restante', 150);" onblur="validarForm($('#frmCrearLista').get(0));"></textarea>
						<span id="digitado" style="color:red">0</span> Caracteres digitados / Restan <label id="restante"  style="color:red">150</label>
		        	</div>		        	
		        </div>
		        
		        <div class="cProcFor-wrapper2 cProcForms2">
		            <b style="margin-bottom: 0pt;">Contenido principal <br>(no excluyente)</b>
		            <div style="margin-bottom: 0pt;width:80px;">
		            	<input type="radio" checked="" name="categoria_seccion" value="1">Libros
		        	</div>
		            <div style="margin-bottom: 0pt;width:80px;">
		            	<input type="radio" name="categoria_seccion" value="4">Musica
		        	</div>		        	
		        	<div style="margin-bottom: 0pt; width:80px;">
		            	<input type="radio" name="categoria_seccion" value="5">Peliculas
		        	</div>
		        	<div style="margin-bottom: 0pt;width:105px;">
		            	<input type="radio" name="categoria_seccion" value="3">Pasatiempos
		        	</div>
		        </div>
	       		<a class="cProcForButton vPrevButt" style="text-align:center;" href="javascript:sendForm('frmCrearLista','/CrearListas','','');">Crear Lista</a> 			        	         
	       </form>
	       <div class="cProcFor-wrapper2 cProcForms2">
         		<b style="margin-bottom: 0pt;">&nbsp;</b>
         		<div style="margin-bottom: 0pt;width:260px;text-align:center">
         			<label class="error" id="divMensajes"></label>	
         			<a id="btnContinuar" class="cProcForButton vPrevButt" style="text-align:center;visibility:hidden;" href="/miCuenta/listasDeUsuarios/verTodasMisListas.jsp">Continuar</a>
     			</div>
     		</div>
	</div>
</div>