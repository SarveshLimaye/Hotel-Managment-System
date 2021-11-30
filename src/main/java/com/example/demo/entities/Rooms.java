package com.example.demo.entities;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="ROOM")
public class Rooms {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int rId;
	private String first_name;
	private String last_name;
	private String email;
	private String phone_no;
	private String checkinDate;
	private String checkoutDate;
	private int price;
	private int adults;
	private int children;
	private String category;
	private String special_instructions;
	private long total_price;
	private long total_days;
	
	@ManyToOne
	private User user;
	
	
	public int getrId() {
		return rId;
	}
	public void setrId(int rId) {
		this.rId = rId;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPhone_no() {
		return phone_no;
	}
	public void setPhone_no(String phone_no) {
		this.phone_no = phone_no;
	}
	public String getCheckinDate() {
		return checkinDate;
	}
	public void setCheckinDate(String checkinDate) {
		this.checkinDate = checkinDate;
	}
	public String getCheckoutDate() {
		return checkoutDate;
	}
	public void setCheckoutDate(String checkoutDate) {
		this.checkoutDate = checkoutDate;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public int getAdults() {
		return adults;
	}
	public void setAdults(int adults) {
		this.adults = adults;
	}
	public int getChildren() {
		return children;
	}
	public void setChildren(int children) {
		this.children = children;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getSpecial_instructions() {
		return special_instructions;
	}
	public void setSpecial_instructions(String special_instructions) {
		this.special_instructions = special_instructions;
	}
	public long getTotal_price() {
		return total_price;
	}
	public void setTotal_price(long total_price) {
		this.total_price = total_price;
	}
	public long getTotal_days() {
		return total_days;
	}
	public void setTotal_days(long total_days) {
		this.total_days = total_days;
	}
	@Override
	public String toString() {
		return "Rooms [rId=" + rId + ", first_name=" + first_name + ", last_name=" + last_name + ", email=" + email
				+ ", phone_no=" + phone_no + ", checkinDate=" + checkinDate + ", checkoutDate=" + checkoutDate
				+ ", price=" + price + ", adults=" + adults + ", children=" + children + ", category=" + category
				+ ", special_instructions=" + special_instructions + ", total_price=" + total_price + ", total_days="
				+ total_days + ", user=" + user + "]";
	}
	
	
	
	
	
}
