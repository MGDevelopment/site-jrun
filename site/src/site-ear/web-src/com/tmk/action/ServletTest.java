package com.tmk.action;

import java.io.BufferedReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Vector;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.flaptor.indextank.apiclient.IndexTankClient;
import com.flaptor.indextank.apiclient.IndexTankClient.Index;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.json.JsonHierarchicalStreamDriver;
import com.tmk.controllers.MainHelper;
import com.tmk.kernel.Convert;
import com.tmk.kernel.Globals;
import com.tmk.kernel.TmkLogger;
import com.tmk.orden.OrdenDAO;
import com.tmk.setup.Contenido;
import com.tmk.src.socio.SocioPK;
import com.tmk.xml.Resultado;
/***
 * Levanta la tempalte de modulo extra, y setea losd datos correspondientes.
 * 
 * @author oclopez
 *
 */
public class ServletTest extends Action {
	
	public ServletTest() {}
		
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		IndexTankClient client = new IndexTankClient("<YOUR API URL HERE>");
		Index index = client.getIndex("<YOUR INDEX NAME HERE>");

		String documentId = "<YOUR DOCUMENT ID>";
		String documentText = "<THE TEXTUAL CONTENT>";

		Map<String, String> fields = new HashMap<String, String>();
		fields.put("text", documentText);

		index.addDocument(documentId, fields);
		
		return null;
	}
}

