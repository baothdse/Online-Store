package com.cos.entities;
// Generated Jun 23, 2017 6:43:50 PM by Hibernate Tools 4.3.1.Final

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

/**
 * Image generated by hbm2java
 */
@Entity
@Table(name = "image", catalog = "cosmetic_online_store")
public class Image implements java.io.Serializable {

	private Integer imageId;
	private Product product;
	private String link;
	private Boolean main;

	public Image() {
	}

	public Image(Product product, String link, Boolean main) {
		this.product = product;
		this.link = link;
		this.main = main;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "imageId", unique = true, nullable = false)
	public Integer getImageId() {
		return this.imageId;
	}

	public void setImageId(Integer imageId) {
		this.imageId = imageId;
	}

	@JsonBackReference
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "productId")
	public Product getProduct() {
		return this.product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	@Column(name = "link", length = 65535)
	public String getLink() {
		return this.link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	@Column(name = "main")
	public Boolean getMain() {
		return this.main;
	}

	public void setMain(Boolean main) {
		this.main = main;
	}

}
