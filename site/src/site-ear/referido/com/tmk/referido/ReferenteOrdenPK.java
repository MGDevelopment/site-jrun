package com.tmk.referido;
import java.io.Serializable;

public class ReferenteOrdenPK implements Serializable
{
	public Long CODIGO;
	public Integer ID_ORDEN_REFERENTE;

	public ReferenteOrdenPK() {
	}

	public ReferenteOrdenPK(Long CODIGO, Integer ID_ORDEN_REFERENTE) {
        this.CODIGO = CODIGO;
        this.ID_ORDEN_REFERENTE = ID_ORDEN_REFERENTE;
    }

    public int hashCode() {
        StringBuffer hash = new StringBuffer();
        hash.append(this.CODIGO);
        hash.append(this.ID_ORDEN_REFERENTE);

        int hashCode = hash.toString().hashCode();

        return hashCode;
    }

    public boolean equals(Object o) {
        if (o instanceof ReferenteOrdenPK) {
            ReferenteOrdenPK referenteOrdenPK = (ReferenteOrdenPK) o;

            return (
                    this.CODIGO.equals(referenteOrdenPK.CODIGO) &&
                    this.ID_ORDEN_REFERENTE.equals(referenteOrdenPK.ID_ORDEN_REFERENTE)
                    );
        }

        return false;
    }
}


