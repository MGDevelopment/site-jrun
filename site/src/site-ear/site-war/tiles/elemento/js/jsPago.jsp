<%@page import="com.tmk.kernel.TarjetaPlanDAO"%>
<%@page import="com.tmk.kernel.MedioDeCobroDAO"%>
<%@page import="com.tmk.controllers.compra.CompraHelper"%>
<%@page import="com.tmk.kernel.Globals"%>
<%@page import="com.tmk.orden.OrdenDAO"%>
<%@page import="java.util.Vector"%>
<%@page import="com.tmk.setup.Contenido"%>
<%@page import="com.tmk.kernel.Convert"%>

<script type="text/JavaScript">
	<%@include file="/js/Combo.js"%>
	<%@include file="/js/validationForm.js"%>
	<%@include file="/js/Validation.js"%>
</script>
<%--<jsp:include page="/js/Combos.jsp"></jsp:include>--%>

<%
	OrdenDAO ordenDAO = (OrdenDAO)session.getAttribute("ordenDAO");
	Vector tarjetasUsuario = new Vector();
	//session.setAttribute("tarjetasUsuario", tarjetasUsuario);
	MedioDeCobroDAO tarjetaPrepaga = MedioDeCobroDAO.buscaMedioDeCobro(Globals.CLAVE_MEDIO_DE_COBRO_TARJETA_PREPAGA);
%>

<script type="text/JavaScript">
  function validarPrepaga () {
	var tarjetasVacias = true;	
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

function quitaEspacios (cad){
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

		/*if (isEmpty(document.frmMedioCobro.<%= CompraHelper.CAMPO_HORARIO %>.value)) {
			alert('Debés indicar un horario para el contacto');
			document.frmMedioCobro.<%= CompraHelper.CAMPO_HORARIO %>.focus();
			return;
		}*/

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
		if(puedeAvanzar) {
			document.frmMedioCobro.submit();
		}else{
			alert("Verifique los datos de pago");
			document.frmMedioCobro.TIPO_DE_TARJETA.focus();
		}
	}

	/*function abrirAyuda() {
		window.open("/compra/ayudaTarjetas.jsp", "Codigo",
					"toolbar=no, location=no, directories=no, status=no, menubar=no, scrollbars=yes, resizable=yes, copyhistory=no, width=450, height=625 top=30, left=30");
	}*/

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

	/*Esto se uso, cuando huvo problemas con gpay. no elimino el comentario por si vuelve a acurrir el problema. 
	if(id == 'TA'){
		document.getElementById('ELIMINAR1').innerHTML = 'ESTIMADOS CLIENTES : LES PEDIMOS DISCULPAS POR LAS MOLESTIAS OCASIONADAS. NUESTRO SISTEMA DE PAGOS CON TARJETAS DE CRÉDITO NO ESTÁ DISPONIBLE. ESPERAMOS RESOLVERLO LO ANTES POSIBLE.';
		document.getElementById('ELIMINAR2').innerHTML = 'Momentanemante fuera de servicios';
	}
	*/
	//agrego este chequo por que cuando se selecciona un medio de pago tarjeta->VSPA o AMPAT el chequeo 
	//de avence de UI hay que deshabilitarlo
	//si no es tarjeta habilito el campo promocion
	if(id != 'TA'){
		setAvance(true);
		$("input[name=CUPON]").attr("disabled",false);
	}
	
	//starting at one, loop through until the number chosen by the user
    for(i = 1; i < sel.options.length; i++) {
        try{
	    	var div = document.getElementById(sel.options[i].value);
	        //change visibility to block, or 'visible'
			if (sel.options[sel.options.selectedIndex].value ==	sel.options[i].value) {
	      		div.style.display = 'block';
	      	    //$('barraCentral').style.height += $('RIOHB').style.height;
			} else {
				div.style.display = "none";
			}
        }catch(e){
        }
    }
}
</script>