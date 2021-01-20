/**
 * 
 */
package com.abhishek.amar.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.abhishek.amar.enume.DBType;

/**
 * @author Abhishek Amar
 *
 */
@Entity
@Table(name = "db")
public class DBEntity {
	@Id
	private Integer id;
	private DBType DBtype;
	private String dbName;

	public String getDbName() {
		return dbName;
	}

	public void setDbName(String dbName) {
		this.dbName = dbName;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public DBType getDBtype() {
		return DBtype;
	}

	public void setDBtype(DBType dBtype) {
		DBtype = dBtype;
	}

}
