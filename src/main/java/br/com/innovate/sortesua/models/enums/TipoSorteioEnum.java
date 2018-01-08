package br.com.innovate.sortesua.models.enums;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

public enum TipoSorteioEnum {
	
	MEGASENA (1),
	LOTOFACIL (2);
	
	private static final Map<Integer, TipoSorteioEnum> LOOKUP = new HashMap<>();

	static {
		for (TipoSorteioEnum e : EnumSet.allOf(TipoSorteioEnum.class)) {
			LOOKUP.put(e.getId(), e);
		}
	}

	private Integer id;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	private TipoSorteioEnum(Integer id) {
		this.id = id;
	}

	public static TipoSorteioEnum valueOf(Integer id) {
		return LOOKUP.get(id);
	}

}
