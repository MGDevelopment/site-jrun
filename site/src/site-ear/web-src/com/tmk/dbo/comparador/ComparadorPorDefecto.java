package com.tmk.dbo.comparador;

import java.util.Comparator;
import com.tmk.dbo.DBO;

public class ComparadorPorDefecto implements Comparator<DBO> {
	public int compare(DBO o1, DBO o2) {
		return 1;			
	} 
}
