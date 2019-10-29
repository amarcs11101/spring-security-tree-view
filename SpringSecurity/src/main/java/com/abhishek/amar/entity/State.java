/**
 * 
 */
package com.abhishek.amar.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * @author Abhishek Amar
 *
 */
@Entity
@Table(name = "State")
public class State {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String stateName;
	@OneToOne
	private Country country;
	private boolean ishidden;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getStateName() {
		return stateName;
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
	}

	public boolean isIshidden() {
		return ishidden;
	}

	public void setIshidden(boolean ishidden) {
		this.ishidden = ishidden;
	}

}
