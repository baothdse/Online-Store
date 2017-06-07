package com.cos.entities;
// Generated May 25, 2017 8:40:17 AM by Hibernate Tools 4.3.1.Final

import static javax.persistence.GenerationType.IDENTITY;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

/**
 * Cart generated by hbm2java
 */
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@Table(name = "cart", catalog = "cosmetic_online_store")
public class Cart implements java.io.Serializable {

	private Integer cartId;
	private String totalPrice;
	private String note;
	private Integer userId;
	private Date addedDate;
	private Boolean checkOut;
	private List<SelectedProduct> selectedProducts = new ArrayList<SelectedProduct>();

	public Cart() {
	}

	public Cart(String totalPrice, String note, Integer userId, Date addedDate, Boolean checkOut,
			List<SelectedProduct> selectedproducts) {
		this.totalPrice = totalPrice;
		this.note = note;
		this.userId = userId;
		this.addedDate = addedDate;
		this.checkOut = checkOut;
		this.selectedProducts = selectedproducts;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "cartId", unique = true, nullable = false)
	public Integer getCartId() {
		return this.cartId;
	}

	public void setCartId(Integer cartId) {
		this.cartId = cartId;
	}

	@Column(name = "totalPrice", length = 20)
	public String getTotalPrice() {
		return this.totalPrice;
	}

	public void setTotalPrice(String totalPrice) {
		this.totalPrice = totalPrice;
	}

	@Column(name = "note", length = 65535)
	public String getNote() {
		return this.note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	@Column(name = "userId")
	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "addedDate", length = 10)
	public Date getAddedDate() {
		return this.addedDate;
	}

	public void setAddedDate(Date addedDate) {
		this.addedDate = addedDate;
	}

	@Column(name = "checkOut")
	public Boolean getCheckOut() {
		if (checkOut == null) {
			setCheckOut(false);
		}
		return this.checkOut;
	}

	public void setCheckOut(Boolean checkOut) {
		this.checkOut = checkOut;
	}

	@JsonManagedReference
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "cart")
	public List<SelectedProduct> getSelectedproducts() {
		return this.selectedProducts;
	}

	public void setSelectedproducts(List<SelectedProduct> selectedProducts) {
		this.selectedProducts = selectedProducts;
	}

}
