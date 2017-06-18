package com.cos.entities;
// Generated Jun 13, 2017 6:54:30 PM by Hibernate Tools 4.3.1.Final

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonBackReference;

/**
 * Videos generated by hbm2java
 */
@Entity
@Table(name = "videos", catalog = "cosmetic_online_store")
public class Videos implements java.io.Serializable {

	private int videoId;
	private User user;
	private String link;
	private Date addedDate;
	private Date addedTime;

	public Videos() {
	}

	public Videos(int videoId) {
		this.videoId = videoId;
	}

	public Videos(int videoId, User user, String link, Date addedDate, Date addedTime) {
		this.videoId = videoId;
		this.user = user;
		this.link = link;
		this.addedDate = addedDate;
		this.addedTime = addedTime;
	}

	@Id

	@Column(name = "videoId", unique = true, nullable = false)
	public int getVideoId() {
		return this.videoId;
	}

	public void setVideoId(int videoId) {
		this.videoId = videoId;
	}

	@JsonBackReference
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "userId")
	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Column(name = "link", length = 65535)
	public String getLink() {
		return this.link;
	}

	public void setLink(String link) {
		this.link = link;
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

}
