package model.po;

import java.io.Serializable;

public class CoursePO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3127920220341340150L;

	private long id;

	private String name;

	public CoursePO() {
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
