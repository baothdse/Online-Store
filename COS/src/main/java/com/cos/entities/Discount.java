package com.cos.entities;
// Generated Apr 14, 2017 7:39:22 PM by Hibernate Tools 4.3.1.Final

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Discount generated by hbm2java
 */
@Entity
@Table(name = "discount", catalog = "cosmetic_online_store")
public class Discount implements java.io.Serializable {

	private Integer discountId;
	private String discountCode;
	private Date startDate;
	private Date endDate;
	private String amount;
	private Set<Product> products = new HashSet<Product>(0);

	public Discount() {
	}

	public Discount(String discountCode, Date startDate, Date endDate, String amount, Set<Product> products) {
		this.discountCode = discountCode;
		this.startDate = startDate;
		this.endDate = endDate;
		this.amount = amount;
		this.products = products;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "discountId", unique = true, nullable = false)
	public Integer getDiscountId() {
		return this.discountId;
	}

	public void setDiscountId(Integer discountId) {
		this.discountId = discountId;
	}

	@Column(name = "discountCode", length = 20)
	public String getDiscountCode() {
		return this.discountCode;
	}

	public void setDiscountCode(String discountCode) {
		this.discountCode = discountCode;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "startDate", length = 10)
	public Date getStartDate() {
		return this.startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "endDate", length = 10)
	public Date getEndDate() {
		return this.endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	@Column(name = "amount", length = 5)
	public String getAmount() {
		return this.amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	@JsonIgnore
	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "discounts")
	public Set<Product> getProducts() {
		return this.products;
	}

	public void setProducts(Set<Product> products) {
		this.products = products;
	}

}
