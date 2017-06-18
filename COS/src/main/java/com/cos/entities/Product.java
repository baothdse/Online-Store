package com.cos.entities;
// Generated Jun 13, 2017 6:54:30 PM by Hibernate Tools 4.3.1.Final

import static javax.persistence.GenerationType.IDENTITY;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

/**
 * Product generated by hbm2java
 */
@Entity
@Table(name = "product", catalog = "cosmetic_online_store")
public class Product implements java.io.Serializable {

	private Integer productId;
	private Discount discount;
	private String productName;
	private String introduction;
	private String productKind;
	private String brand;
	private String price;
	private Integer productQuantity;
	private Date addedDate;
	private Date addedTime;
	private Integer soldQuantity;
	private List<SelectedProduct> selectedproducts = new ArrayList<SelectedProduct>();
	private List<Image> images = new ArrayList<Image>();

	public Product() {
	}

	public Product(String productName) {
		this.productName = productName;
	}

	public Product(Discount discount, String productName, String introduction, String productKind, String brand,
			String price, Integer productQuantity, Date addedDate, Date addedTime, Integer soldQuantity,
			List<SelectedProduct> selectedproducts, List<Image> images) {
		this.discount = discount;
		this.productName = productName;
		this.introduction = introduction;
		this.productKind = productKind;
		this.brand = brand;
		this.price = price;
		this.productQuantity = productQuantity;
		this.addedDate = addedDate;
		this.addedTime = addedTime;
		this.soldQuantity = soldQuantity;
		this.selectedproducts = selectedproducts;
		this.images = images;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "productId", unique = true, nullable = false)
	public Integer getProductId() {
		return this.productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	@JsonBackReference
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "discountId")
	public Discount getDiscount() {
		return this.discount;
	}

	public void setDiscount(Discount discount) {
		this.discount = discount;
	}

	@Column(name = "productName", nullable = false)
	public String getProductName() {
		return this.productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	@Column(name = "introduction", length = 65535)
	public String getIntroduction() {
		return this.introduction;
	}

	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}

	@Column(name = "productKind")
	public String getProductKind() {
		return this.productKind;
	}

	public void setProductKind(String productKind) {
		this.productKind = productKind;
	}

	@Column(name = "brand")
	public String getBrand() {
		return this.brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	@Column(name = "price", length = 20)
	public String getPrice() {
		return this.price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	@Column(name = "productQuantity")
	public Integer getProductQuantity() {
		return this.productQuantity;
	}

	public void setProductQuantity(Integer productQuantity) {
		this.productQuantity = productQuantity;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "addedDate", length = 10)
	public Date getAddedDate() {
		return this.addedDate;
	}

	public void setAddedDate(Date addedDate) {
		this.addedDate = addedDate;
	}

	@Temporal(TemporalType.TIME)
	@Column(name = "addedTime", length = 8)
	public Date getAddedTime() {
		return this.addedTime;
	}

	public void setAddedTime(Date addedTime) {
		this.addedTime = addedTime;
	}

	@Column(name = "soldQuantity")
	public Integer getSoldQuantity() {
		return this.soldQuantity;
	}

	public void setSoldQuantity(Integer soldQuantity) {
		if (soldQuantity == null) {
			setSoldQuantity(0);
		}
		this.soldQuantity = soldQuantity;
	}

	@JsonManagedReference
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "product")
	public List<SelectedProduct> getSelectedproducts() {
		return this.selectedproducts;
	}

	public void setSelectedproducts(List<SelectedProduct> selectedproducts) {
		this.selectedproducts = selectedproducts;
	}

	@JsonManagedReference
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "product")
	public List<Image> getImages() {
		return this.images;
	}

	public void setImages(List<Image> images) {
		this.images = images;
	}

}
