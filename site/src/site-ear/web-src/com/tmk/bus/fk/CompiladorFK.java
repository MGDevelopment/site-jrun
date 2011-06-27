package com.tmk.bus.fk;
import java.util.HashMap;


@SuppressWarnings("serial")
public class CompiladorFK extends HashMap{
//	 Singleton
	private static final CompiladorFK instance = new CompiladorFK();	// Llama al constructor

	public static CompiladorFK getInstance() {
		return instance;
	}

	@SuppressWarnings("unchecked")
	private CompiladorFK () {
		super(1);
		this.put("compilador", new String[][] {new String[]{"id_autor", "id_autor"}});
	}
}
