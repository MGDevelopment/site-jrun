<%@ taglib uri="/WEB-INF/struts-tiles.tld" prefix="tiles" %>
<!-- **** SECCION TEMATIKA **** -->
<tiles:useAttribute name="idSeccion" scope="page" ignore="true" classname="java.lang.Integer"/>
<%--<script language="Javascript">if(window.history.forward(1) != null) window.history.forward(1);</script>--%>
<div id="seccionTematika" >
		<div class="tmtkMesaNovedades"><!-- mesa y ttulos de secciones -->    
                <a href="/libros" class="tmtkMesaSeccionesTit" title="Libros"></a>
                <a href="/musica" class="tmtkMesaSeccionesTit" title="Msica"></a>
                <a href="/peliculas" class="tmtkMesaSeccionesTit" title="Pelculas"></a>
                <a href="/juguetes" class="tmtkMesaSeccionesTit" title="Pasatiempos"></a>    
        </div><!-- FIN mesa y tiulos de secciones -->        
		<tiles:insert name="body" flush="true"/>
		<!-- se agrega para los modales de listas y login -->
		<%--<jsp:include page="/templates/templates/tmpListaYLoginModal.htm"/>--%>	
</div>