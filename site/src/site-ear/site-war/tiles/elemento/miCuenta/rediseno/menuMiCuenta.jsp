
<%@page import="com.tmk.controllers.MainHelper"%><script type="text/javascript">
setInterval('checkSesionStatus();',60000);
function checkSesionStatus() {
	var datos = "param="+Math.random();
	$.ajax({
		cache:false,
		type: "GET",
		dataType:"json",
		url:'/VerificadorDeSesion',
		data: datos,		
		success: function(objeto){
			if(!objeto.Resultado.valor) {
				document.location.href = objeto.Resultado.targetRedirect;		
			}
		}
	});
}
</script>
	<script type="text/javascript" charset="utf-8">
	$(function(){
		$('#menu li a').click(function(event){
			var elem = $(this).next();
			if(elem.is('ul')){
				event.preventDefault();
				$('#menu ul:visible').not(elem).slideUp();
				elem.slideToggle();
			}			
		});
	});
	</script>
	<style type="text/css" media="screen">
		#menu{
			/*-moz-border-radius:5px;
			-webkit-border-radius:5px;*/
			border-radius:5px;
			/*-webkit-box-shadow:1px 1px 3px #888;
			-moz-box-shadow:1px -2px 3px #888;*/
		}
		#menu li{border-bottom:2px solid #666666;}
		#menu ul #menu li, #menu li:last-child{border:none}
		
		#menu ul li {
			border-bottom:1px solid #FFFFFF;
		}
		
		#menu ul li a{
			background-image: none;
			padding-left: 15px; 	
			font-weight: normal;
			background-color: #F1F1F1;
		}
					
		#menu a{
			display:block;
			color:#000000;
			text-decoration:none;
			font-family:'Tahoma', Arial, sans-serif;
			font-size:13px;
			padding:3px 5px;
			/*font-weight:bold;*/
			/*text-shadow:1px 1px 1px #325179;*/
			background-image: url("/imagenes/rediseno/imagenes/gradient_37.gif");
			/*background-color: gray;*/
		}
		#menu a:hover{
			color:#000000;
			font-weight:bold;
			-webkit-transition: color 0.2s linear;
		}
		#menu ul #menu a{background-color:#6594D1;}
		#menu ul #menu a:hover{
			background-color:#FFF;
			color:#2961A9;
			text-shadow:none;
			-webkit-transition: color, background-color 0.2s linear;
		}
		span ul{
			display:block;
			/*background-color:#2961A9;*/			
			margin:0;
			padding:0;
			width:200px;
			border:thin solid;
			list-style:none;
		}
		#menu ul{background-color:#6594D1;}
		#menu li ul {display:none;}
	</style>

<span>
<ul id="menu">
			
				<li>
					<a  href="javascript:void(0)">DATOS DE SU CUENTA</a>			
					<ul>
						<li>
							<a href="/miCuenta/modificarSocio.jsp">Datos Personales</a>
						</li>
						<li>
							<a href="/miCuenta/domicilios.jsp?TIPO_DOMICILIO=ENVI">Domicilios</a>
						</li>
						<%-- 
							<li><a  href="javascript:void(0)">Domicilios</a>			
								<ul>
									<li><a href="javascript:void(0)">Asia</a></li>
									<li><a href="javascript:void(0)">South America</a></li>
									<li><a href="javascript:void(0)">Australia</a></li>
								</ul>
							</li>
						--%>					
						<!-- 
						<li><a  href="javascript:void(0)">Investors</a>			
						<ul>
							<li><a href="javascript:void(0)">Worldwide</a></li>
							<li><a href="javascript:void(0)">Equity Funds</a></li>
							<li><a href="javascript:void(0)">Multi National</a></li>							
						</ul>
						</li>
						 -->								
					</ul>
				</li>
				<li>
					<a  href="javascript:void(0)">SERVICIOS ADICIONALES</a>			
					<ul>
						<li>
							<a href="/miCuenta/servicios/popego.jsp">Administrar cuenta Popego</a>
						</li>
						<li>
							<a href="/miCuenta/servicios/servicioPopego.jsp" target="<tmpl_var target>">Informacion Sobre Popego</a>
						</li>
					</ul>
				</li>			
				<li>
					<a  href="javascript:void(0)">PROGRAMA EXTRA</a>			
					<ul>
						<%--
						<li>
							<a id="linkExtraConsultar" href="/fidelizacion/panel/puntos.jsp" class="FAyuda">Consultar mis Puntos</a>
														<!-- /miCuenta/registroSocioEXtra.jsp -->
						</li>
						--%>
						<li>
							<% if (request.getSession().getAttribute(MainHelper.SESSION_PUNTAJE_FIDELIZACION) != null) {%>
							<a id="linkExtraConsultar" href="/fidelizacion/panel/puntos.jsp" >Consultar mis Puntos</a>
							<% } else { %>
							<a  id="linkExtraAsociar" href="/miCuenta/registroSocioEXtra.jsp">Ingresar al Programa</a>
							<% }%>
						</li>
					</ul>
				</li>
				<li>
					<a  href="javascript:void(0)">LISTA DE DESEOS</a>			
					<ul>
						<li><a href="/listaDeseos/verListaPropia.jsp">Configuraci&oacute;n de B&uacute;squeda</a></li>
						<li><a href="/listaDeseos/domicilios.jsp">Domicilios</a></li>
						<li><a href="/listaDeseos/enviarCorreo.jsp">Env&iacute;o de e-Mails</a></li>						
					</ul>
				</li>							
				<li>
					<a  href="javascript:void(0)">PROGRAMA DE REFERIDOS</a>			
					<ul>
						<li><a href="/referido/">Informaci&oacute;n y reglas del programa</a></a></li>
						<li><a href="/AgregarReferido">Agregar Referidos</a></a></li>
						<li><a href="/referido/consultarReferido.jsp">Mis Referidos</a></li>						
					</ul>
				</li>			
				<li>
					<a  href="javascript:void(0)">PROMOCIONES</a>			
					<ul>
						<li><a href="/miCuenta/promocionesHistoricas.jsp" class="FAyuda">Promociones Utilizadas</a></li>						
					</ul>
				</li>
				<li>
					<a  href="javascript:void(0)">HISTORIAL DE COMPRAS</a>			
					<ul>
						<li><a href="/compra/misOrdenes.jsp" class="FAyuda">Mis Ordenes</a></li>						
					</ul>
				</li>
				<%-- 
				<li>
					<a  href="javascript:void(0)">MIS LISTAS</a>			
					<ul>
						<li><a href="/miCuenta/listasDeUsuarios/crearMiLista.jsp">Crear lista nueva</a></a></li>
						<!--<li><a href="/miCuenta/listasDeUsuarios/verMisListas.jsp">Mis listas</a></a></li>-->
						<li><a href="/miCuenta/listasDeUsuarios/verTodasMisListas.jsp">Ver mis listas</a></a></li>
						<!--<li><a href="javascript:void(0)">Modificar mis listas</a></li>-->
					</ul>
				</li>
				--%>
				<%--
				<li>
					<a  href="javascript:void(0)">SOBRE TEMATIKA</a>			
					<ul>
						<li>
							<a href="/" target="<tmpl_var target>">Tematika</a>
						</li>
						<li>
							<a href="/institucional/conozcanos.jsp" target="<tmpl_var target>">Marcas ILHSA</a>
						</li>
						<li>
							<a href="/sucursales/?sucursal=205&unegocio=ateneo" target="<tmpl_var target>">Sucursales</a>
						</li>
						<li>
							<a href="/institucional/verEventos.jsp" target="<tmpl_var target>">Eventos</a>
						</li>
						<li>
							<a href="/institucional/prensa.jsp?page=/asociadas/prensa/prensa1.htm" target="<tmpl_var target>">Prensa</a>
						</li>
						<li>
							<a href="/empleos" target="<tmpl_var target>">Empleo</a>
						</li>
					</ul>
				</li>
				--%>	
			</ul>
</span>