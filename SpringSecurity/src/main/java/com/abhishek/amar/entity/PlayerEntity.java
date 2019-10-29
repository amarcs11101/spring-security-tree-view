package com.abhishek.amar.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.abhishek.amar.enume.PlayerCatergory;

@Entity
@Table(name = "players")
public class PlayerEntity implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Integer id;
	@Column(name = "name")
	private String name;
	@Column(name = "image")
	private String image;
	@Column(name = "category")
	private String category;
	// private PlayerCatergory category;
	@Column(name = "createdAt")
	private Date createdAt;
	@Column(name = "updatedAt")
	private Date updatedAt;
	@Column(name = "country")
	private String country;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Override
	public String toString() {
		return "PlayerEntity [id=" + id + ", name=" + name + ", image=" + image + ", category=" + category
				+ ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + ", country=" + country + "]";
	}

}
