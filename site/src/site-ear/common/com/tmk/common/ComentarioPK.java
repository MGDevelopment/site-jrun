package com.tmk.common;

import java.io.Serializable;

public class ComentarioPK implements Serializable {

    public Integer ID_ARTICULO;
    public Integer ID_COMENTARIO;

    public ComentarioPK() {
    }

    public ComentarioPK(Integer ID_ARTICULO, Integer ID_COMENTARIO) {
        this.ID_ARTICULO = ID_ARTICULO;
        this.ID_COMENTARIO = ID_COMENTARIO;
    }

    public int hashCode() {
        StringBuffer hash = new StringBuffer();
        hash.append(this.ID_ARTICULO);
        hash.append(this.ID_COMENTARIO);

        int hashCode = hash.toString().hashCode();

        return hashCode;
    }

    public boolean equals(Object o) {
        if (o instanceof ComentarioPK) {
            ComentarioPK comentarioPK = (ComentarioPK) o;

            return (
                    this.ID_ARTICULO.equals(comentarioPK.ID_ARTICULO) &&
                    this.ID_COMENTARIO.equals(comentarioPK.ID_COMENTARIO)
                    );
        }

        return false;
    }
}
