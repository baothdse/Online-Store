package com.cos.entities;
// Generated Jun 23, 2017 6:43:50 PM by Hibernate Tools 4.3.1.Final

import static javax.persistence.GenerationType.IDENTITY;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

/**
 * Cart generated by hbm2java
 */
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name = "cart", catalog = "cosmetic_online_store")
public class Cart implements java.io.Serializable {

	private Integer cartId;
	private String totalPrice;
	private Boolean checkOut;
	private List<SelectedProduct> selectedproducts = new ArrayList<SelectedProduct>(0);
	private CartDetail cartDetail;

	public Cart() {
	}

	public Cart(String totalPrice, Boolean checkOut, List<SelectedProduct> selectedproducts, CartDetail cartDetail) {
		this.totalPrice = totalPrice;
		this.checkOut = checkOut;
		this.selectedproducts = selectedproducts;
		this.cartDetail = cartDetail;
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

	@Column(name = "checkOut")
	public Boolean getCheckOut() {
		return this.checkOut;
	}

	public void setCheckOut(Boolean checkOut) {
		this.checkOut = checkOut;
	}

	@JsonManagedReference
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "cart")
	public List<SelectedProduct> getSelectedproducts() {
		return this.selectedproducts;
	}

	public void setSelectedproducts(List<SelectedProduct> selectedproducts) {
		this.selectedproducts = selectedproducts;
	}

	@OneToOne(fetch = FetchType.LAZY, mappedBy = "cart")
	public CartDetail getCartdetail() {
		return this.cartDetail;
	}

	public void setCartdetail(CartDetail cartDetail) {
		this.cartDetail = cartDetail;
	}

}
