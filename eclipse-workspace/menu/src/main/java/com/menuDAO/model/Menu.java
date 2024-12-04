package com.menuDAO.model;

public class Menu 
{
	private int menuid;
	private int restid;
	private String name;
	private float price;
	private String description;
	private boolean isAvailable;
	private String imagepath;
	
	public int getMenuid() {
		return menuid;
	}
	public void setMenuid(int menuid) {
		this.menuid = menuid;
	}
	public int getRestid() {
		return restid;
	}
	public void setRestid(int restid) {
		this.restid = restid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public boolean isAvailable() {
		return isAvailable;
	}
	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}
	public String getImagepath() {
		return imagepath;
	}
	public void setImagepath(String imagepath) {
		this.imagepath = imagepath;
	}
	
	public Menu() {
		super();
	}
	
	public Menu(int menuid, int restid, String name, float price, String description, boolean isAvailable,
			String imagepath) {
		super();
		this.menuid = menuid;
		this.restid = restid;
		this.name = name;
		this.price = price;
		this.description = description;
		this.isAvailable = isAvailable;
		this.imagepath = imagepath;
	}
	
	@Override
	public String toString() 
	{
		return menuid + "     " + restid + "    " + name + "    " + price + "   "
				 + description + "     " + isAvailable + "    " + imagepath;
	}
}
