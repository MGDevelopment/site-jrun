package com.tmk.referido;

import java.io.Serializable;

public class ReferidoPK implements Serializable {

    public Long CODIGO_REFERIDO;


    public ReferidoPK() {
    }

    public ReferidoPK(Long CODIGO_REFERIDO) {
        this.CODIGO_REFERIDO = CODIGO_REFERIDO;

    }

    public int hashCode() {
        StringBuffer hash = new StringBuffer();
        hash.append(this.CODIGO_REFERIDO);
        int hashCode = hash.toString().hashCode();

        return hashCode;
    }

    public boolean equals(Object o) {
        if (o instanceof ReferidoPK) {
            ReferidoPK referidoPK = (ReferidoPK) o;

            return (
                    this.CODIGO_REFERIDO.equals(referidoPK.CODIGO_REFERIDO)
                    );
        }

        return false;
    }
}
