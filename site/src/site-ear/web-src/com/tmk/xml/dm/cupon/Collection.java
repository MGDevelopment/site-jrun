package com.tmk.xml.dm.cupon;

public class Collection {
/* * <Collections> -> nodosde Tarjetasde cobranzay códigosde barra-<Collection Trx_id=""> -> nodode pago(*4)<Trx_Date> </Trx_Date> -> fecha de pago<Trx_Payment> </Trx_Payment> -> importepagado</Collection></Collections>-<Tickets> -> nodode boletasde pago-<Ticket> -> nodo de pago (*5)<Trx_Date> </Trx_Date> -> fecha de pago<Trx_Name> </Trx_Name>-> nombre del pagador<Trx_Payment> </Trx_Payment> -> importepagado</Ticket></Tickets></Report>
 *
 * */

	private String trxId;
	private String trxDate;
	private String trxPayment;


	public String getTrxId() {
		return trxId;
	}

	public String getTrxDate() {
		return trxDate;
	}

	public String getTrxPayment() {
		return trxPayment;
	}
}
