package com.revature.models;

import java.sql.Blob;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="pictures")
public class Picture {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="picture_id")
	private int id;
	
	@Column(name="picture")
	private Blob picture;
	
	@ManyToOne(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinColumn(name="user_id")
	private User user;

	public Picture(int id, Blob picture, User user) {
		super();
		this.id = id;
		this.picture = picture;
		this.user = user;
	}

	public Picture(Blob picture, User user) {
		super();
		this.picture = picture;
		this.user = user;
	}
	
	

	public Picture() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Blob getPicture() {
		return picture;
	}

	public void setPicture(Blob picture) {
		this.picture = picture;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Picture [id=" + id + ", picture=" + picture + ", user=" + user + "]";
	}	
	
	
}
