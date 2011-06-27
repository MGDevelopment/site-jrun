var ie=document.all;
var ns=document.layers;
var ns6=document.getElementById&&!document.all;
var popUp;
var popWidth = 295;


function setPopUp(title, mesagge, button, actButton, btnCloseEnabled, image, imageWidth, imageHeight, agregado) {
	iniciarPopUp();
	var bplace ='<tr>' +
					'<td align=\"center\" colspan=\"2\">' +
        				'<input style=\"font-family:\'tahoma\';font-size:11px;text-align:\'center\';\" onclick=\"<ACTBUTTON>\" type=button value=\"<BUTTON>\">' +
                    '</td>' +
			    '</tr>';
	popUp = popUp.replace("<TITLE>", title);
	popUp = popUp.replace("<MSG>", mesagge);
	if (button != '') {
		popUp = popUp.replace("<BPLACE>", bplace);
	} else {
		popUp = popUp.replace("<BPLACE>", '');
	}
	popUp = popUp.replace("<BUTTON>", button);
    popUp = popUp.replace("<ACTBUTTON>", actButton);
	if (btnCloseEnabled) {
	    popUp = popUp.replace("<BTNCLOSEENABLED>", '');
	} else {
		popUp = popUp.replace("<BTNCLOSEENABLED>", 'disabled');
	}
	popUp = popUp.replace("<IMAGE>", image);
	popUp = popUp.replace("<IMAGETDWIDTH>", (parseInt(imageWidth)+10));
	popUp = popUp.replace("<IMAGEWIDTH>", (imageWidth));
	popUp = popUp.replace("<IMAGEHEIGHT>", (imageHeight));
	if (agregado != null) {
		popUp = popUp + agregado;
	}	


}
function setPopUpCarrito(mesagge, image, precio, msg) {
popUp= '<div id="efectoCarritoBack"></div>' +
	   '<div id="efectoCarritoMod">' +
	   '<div id="efectoCarritoTxt"><span class="FProductosDetalle">'+ mesagge +'</span><br />' +
	   '<div style="font-size:10;color:red">'+msg+'</div>' +
	   '<span class="Fprecio">PRECIO: $' + precio + '.-</span></div>' +
	   '<div id="efectoCarritoImages"><img src="' + image + '" class="efectoCarritoImag"></div>' +
	   '<div id="efectoCarritoB"><a href="javascript:actualizarCarrito()"><img src="/imagenes/b-carrContinuar.gif" alt="Continuar" border="0"></a></div>' +
	   '</div>';
}


function setPopUpCarritoSinDisponibilidad(mesagge, image) {
popUp= '<div id="efectoCarritoBack"></div>' +
	   '<div id="efectoCarritoNoMod">' +
	   '<div id="efectoCarritoNoTxt"><span class="FProductosDetalle" style="color:995555">'+ mesagge +'</span><br />' +
	   '</div>' +
	   '<div id="efectoCarritoNoImages"><img src="' + image + '" class="efectoCarritoImag"></div>' +
	   '<div id="efectoCarritoB"><a href="javascript:actualizarCarrito()"><img src="/imagenes/b-carrContinuar.gif" alt="Continuar" border="0"></a></div>' +
	   '</div>';
}


function iniciarPopUp() {
	popUp = '<table cellspacing=\"0\" bgcolor=\"#FFFFFF\" border=\"0\" width=\"' + popWidth + '\" style=\"font-family:\'tahoma\';font-size:11px;\">' +
            	'<tr>' +
                	'<td id=\"drag\" bgcolor=\"#2B4786\" width=\"'+ (popWidth-21) +'\" align=\"left\">' +
                    	'<b id=\"drag\" style=\"color:#ffffff\">&nbsp;<TITLE></b>' +
                    '</td>' +
                    '<td bgcolor=\"#2B4786\" align=\"right\">' +
                    	'<input style=\"font-family:\'lucida console\';font-size:12px;width:20px;height:20px;font-weight:800;\" onclick=\"closepreview()\" type=\"button\" value=\"X\" <BTNCLOSEENABLED>>' +
                    '</td>' +
                '</tr>' +
                '<tr>' +
                	'<td colspan=\"2\">' +
            			'<table width=\"100%\" border=\"0\" style=\"font-family:\'verdana\';font-size:12px;\">' +
				            '<tr >' +
    	    			        '<td width=\"<IMAGETDWIDTH>\">' +
									'<img src=\"<IMAGE>\" width=\"<IMAGEWIDTH>\" height=\"<IMAGEHEIGHT>\">' +
								'</td>' +
								'<td  align=\"left\">' +
         	           				'<MSG>' +
			                    '</td>' +
            			    '</tr>' +
			                '<BPLACE>' +
                        '</table>' +
                    '</td>' +
                '</tr>' +
            '</table>';
            
}

var scrHeight=0; 
var scrWidth=0;

if (self.screen) {     // for NN4 and IE4
	srcWidth = screen.width;
	srcHeight = screen.height
} else {
	if (self.java) {   // for NN3 with enabled Java
		var jkit = java.awt.Toolkit.getDefaultToolkit();
	    var scrsize = jkit.getScreenSize();
		srcWidth = scrsize.width;
		srcWeight = scrsize.height; 
	}
}


function enlarge(){
		
	if (ie||ns6){
		crossobj=document.getElementById? document.getElementById("divPopUp") : document.all.divPopUp
		if (crossobj.style.visibility=="hidden"){
        
			crossobj.style.left= srcWidth/2 - popWidth/2;
      		crossobj.style.top= 200;
    		crossobj.innerHTML=popUp;
			crossobj.style.visibility="visible";
		}
    } else if (document.layers){
    	if (document.divPopUp.visibility=="hide"){
      		document.divPopUp.document.write(popUp);
        	document.divPopUp.document.close();
        	document.divPopUp.left= srcWidth/2 - popWidth/2;
	        document.divPopUp.top= 200;
        	document.divPopUp.visibility="show";
    	}
	}
	  
    return true;
   
}

function enlargeUbicacion(topScr, leftScr){
	if (ie||ns6){

		crossobj=document.getElementById? document.getElementById("divPopUp") : document.all.divPopUp
		if (crossobj.style.visibility=="hidden"){
        
			crossobj.style.left= leftScr
      		crossobj.style.top= topScr;
      		
    		crossobj.innerHTML=popUp;
    		
			crossobj.style.visibility="visible";
		}
    } else if (document.layers){
    	if (document.divPopUp.visibility=="hide"){
      		document.divPopUp.document.write(popUp);
        	document.divPopUp.document.close();
        	document.divPopUp.left= topScr
	        document.divPopUp.top= leftScr;
        	document.divPopUp.visibility="show";
    	}
	}
	
    return true;
    
}


function closepreview(){
	crossobj.style.visibility="hidden"
}
var nsx,nsy,nstemp;

function drag_dropns(name){
    temp=eval(name);
    temp.captureEvents(Event.MOUSEDOWN | Event.MOUSEUP);
    temp.onmousedown=gons;
    temp.onmousemove=dragns;
    temp.onmouseup=stopns;
}

function gons(e){
    temp.captureEvents(Event.MOUSEMOVE);
    nsx=e.x;
    nsy=e.y;
}

function dragns(e){
    temp.moveBy(e.x-nsx,e.y-nsy);
    return false;
}

function stopns(){
	temp.releaseEvents(Event.MOUSEMOVE);
}

function drag_drop(e){
    if (ie&&dragapproved){
        crossobj.style.left=tempx+event.clientX-offsetx;
        crossobj.style.top=tempy+event.clientY-offsety;
    } else if (ns6&&dragapproved){
        crossobj.style.left=tempx+e.clientX-offsetx;
        crossobj.style.top=tempy+e.clientY-offsety;
    }
	return false;
}

function initializedrag(e){
	if (ie&&event.srcElement.id=="drag"||ns6&&e.target.id=="drag"){
    	offsetx=ie? event.clientX : e.clientX;
	    offsety=ie? event.clientY : e.clientY;
    	tempx=parseInt(crossobj.style.left);
    	tempy=parseInt(crossobj.style.top);
    	dragapproved=true;
    	document.onmousemove=drag_drop;
    }
}

document.onmousedown=initializedrag;
document.onmouseup=new Function("dragapproved=false");


