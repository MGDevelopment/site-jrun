<%@ taglib uri="/WEB-INF/struts-tiles.tld" prefix="tiles" %>
<div class="header">
	<%--<tiles:insert attribute="logo"/>--%>
	<a href="/" class="hLogo" title="Tematika.com"></a>
	<tiles:insert attribute="buscador"/>
	<tiles:insert attribute="panelDeUsuario"/>
</div><div id="msjMax" class="panelMensajes" style="display:none">
	<div class="panelMsjTit">Tenés&nbsp;<span id="totalMsg"></span> mensajes por leer &gt;</div>
	<div class="panelMsjTxt">	
	<a href="javascript:mostrarDiv('msjMin'); javascript:mostrarDiv('msjMax');javascript:setVisualizaMensaje(false)" class="panelMsjCerrar">cerrar</a>
    	<span id="pagMsg"></span> <span id="textoMsgActual"></span> <div><a href="javascript:nada()" class="pnlMsgComandos" id="msgAnterior">&lt;Anterior</a> | <a href="javascript:nada()" class="pnlMsgComandos" id="msgSiguiente">Siguiente&gt;</a> | <a href="javascript:nada()" class="pnlMsgComandos" id="msgLeido">No volver a mostrar este mensaje</a></div>
    </div>
</div><div id="msjMin" class="panelMensajes" style="display:none"> <div class="panelMsjTxt"><a href="javascript:mostrarDiv('msjMin'); javascript:mostrarDiv('msjMax');javascript:setVisualizaMensaje(true)" class="panelMsjAbrir">abrir panel y ver mensajes</a>   </div></div>