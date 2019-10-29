/**
 * 
 */
package com.abhishek.amar.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Abhishek Amar
 *
 */
@Entity
@Table(name = "country_capital")
public class Country {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String country;
	private String capital;
	private boolean ishidden;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCapital() {
		return capital;
	}

	public void setCapital(String capital) {
		this.capital = capital;
	}

	public boolean isHidden() {
		return ishidden;
	}

	public void setHidden(boolean isHidden) {
		this.ishidden = isHidden;
	}

	@Override
	public String toString() {
		return "Country [id=" + id + ", country=" + country + ", capital=" + capital + ", isHidden=" + ishidden + "]";
	}

}
