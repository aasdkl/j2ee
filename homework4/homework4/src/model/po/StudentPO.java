package model.po;

import java.io.Serializable;

public class StudentPO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1285760431719120549L;

	private long id;

	private String name;

	public StudentPO() {
		super();
	}
	
	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

}
