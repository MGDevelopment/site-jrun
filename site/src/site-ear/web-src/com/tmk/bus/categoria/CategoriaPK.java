package com.tmk.bus.categoria;

public class CategoriaPK{
	private Integer pk[];
	public CategoriaPK(Integer[] pk) {
		this.pk = pk;
		int tam =pk.length;
		for (int i=0; i<pk.length && tam==pk.length; i++) {
			if (pk[i] == null) {
				tam = i;
			}
		}
		this.pk = new Integer[tam];
		for (int i=0; i<this.pk.length; i++) {
			this.pk[i] = pk[i];
		}
	}
	public Integer [] getPK() {
		return pk;
	}

	public String toString() {
		StringBuffer retorno = new StringBuffer("Categoria PK (");
		for (int i=0; i<this.pk.length; i++) {
			retorno.append(this.pk[i] + " ");
		}
		retorno.append(")");
		return retorno.toString();
	}

	public String toCode() {
		StringBuffer retorno = new StringBuffer("");
		for (int i=0; i<this.pk.length; i++) {
			retorno.append(this.pk[i] + "_");
		}
		return retorno.toString();
	}
	/*convierte una cadena que reprenta una pk delimitada por -
	 * en ena CategoiraPK
	 */
	public static CategoriaPK codeToPK(String code){
		String[] array = code.split("_");
		Integer[] pk = new Integer[array.length];
		for(int i=0;i< array.length;i++)
			pk[i] = new Integer(Integer.parseInt(array[i]));
		CategoriaPK cat = new CategoriaPK(pk);
		return cat;
	}
}