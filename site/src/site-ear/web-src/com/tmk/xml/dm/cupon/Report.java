package com.tmk.xml.dm.cupon;

public class Report {
	private String eMail;
	private String acount;
	private String pin;
	private String startDate;
	private String endDate;
	private String XML;
	private String state;
	private Collection [] collections;
	
	public String getEMail() {
		return this.eMail;
	}
	
	public String getAcount() {
		return this.acount;
	}
	
	public String getPin() {
		return this.pin;
	}
	
	public String getStartDate() {
		return this.startDate;
	}
	
	public String getEndDate() {
		return this.endDate;
	}
	
	public String getXML() {
		return this.XML;
	}
	
	public String getState() {
		return this.state;
	}
	
	public Collection[] getCollections() {
		return collections;	
	}
	
	public boolean esConsultaCorrecta() {
		return "1".equals(state);
	}
	
	public boolean tieneResultados() {
		return (collections != null );
	}
	
	public Collection getCollection(String trxId) throws Exception {
		for (int i=0; i<collections.length; i++) {
			if (collections[i].getTrxId().equals(trxId)) {
				return collections[i];
			}
		}
		throw new Exception("No se encuentra el cupon " + trxId + " en el reporte");
	}
	
	/*
 * -<Report><Email></Email>-> e-mail recibido<Acount></Acount>
 * -> cuenta recibida<Pin></Pin>-> clave recibida
 * <StartDate></StartDate>-> fecha inicial recibida<EndDate></EndDate>-> fecha final recibida
 * <XML></XML>-> flag<State></State>-> estado recibido (*1)-<Pays>-> nodos de botones de pago-<Paytrx_id="">-> nodo pago (*2)<Trx_Date></Trx_Date>-> fecha de pago<Trx_Email></Trx_Email>-> email de pago<Trx_Payment></Trx_Payment>-> importetotal pagado<Trx_ShipAddress></Trx_ShipAddress> -> direcciónde entrega<Trx_Comment></Trx_Comment>-> mensajedel comprador-<Items>-> nodode items-<Item Item_Code="">-> nodoitem (*3)<Item_Quantity></Item_Quantity> -> cantidad<Item_Description></Item_Description> -> descripcion<Item_Payment></Item_Payment> -> importe</Item></Items></Pay></Pays>-
 * <Collections> -> nodosde Tarjetasde cobranzay códigosde barra-<Collection Trx_id=""> -> nodode pago(*4)<Trx_Date> </Trx_Date> -> fecha de pago<Trx_Payment> </Trx_Payment> -> importepagado</Collection></Collections>-<Tickets> -> nodode boletasde pago-<Ticket> -> nodo de pago (*5)<Trx_Date> </Trx_Date> -> fecha de pago<Trx_Name> </Trx_Name>-> nombre del pagador<Trx_Payment> </Trx_Payment> -> importepagado</Ticket></Tickets></Report>
 * 
 * */
}
