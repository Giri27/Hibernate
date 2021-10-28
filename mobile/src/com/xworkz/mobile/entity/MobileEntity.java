package com.xworkz.mobile.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "mobile_table")
@Entity
public class MobileEntity {
	
	@Id
	@Column(name = "mobile_id")
	private int mobileId;
	@Column(name = "mobile_brand")
	private String brand;
	@Column(name = "mobile_price")
	private double price;
	@Column(name = "mobile_rom")
	private String rom;
	@Column(name = "mobile_color")
	private String color;
	@Column(name = "mobile_camera")
	private int pricameraSizeInPixel;
	@Column(name = "mobile_fingerprint")
	private boolean isFingerPrintSupported;
	@Column(name = "mobile_os")
	private String osType;
	
	
	
	public MobileEntity() {
		super();
	}

	public MobileEntity(int mobileId, String brand, double price, String rom, String color, int pricameraSizeInPixel,
			boolean isFingerPrintSupported, String osType) {
		super();
		this.mobileId = mobileId;
		this.brand = brand;
		this.price = price;
		this.rom = rom;
		this.color = color;
		this.pricameraSizeInPixel = pricameraSizeInPixel;
		this.isFingerPrintSupported = isFingerPrintSupported;
		this.osType = osType;
	}
	
	public int getMobileId() {
		return mobileId;
	}
	public void setMobileId(int mobileId) {
		this.mobileId = mobileId;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getRom() {
		return rom;
	}
	public void setRom(String rom) {
		this.rom = rom;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public int getPricameraSizeInPixel() {
		return pricameraSizeInPixel;
	}
	public void setPricameraSizeInPixel(int pricameraSizeInPixel) {
		this.pricameraSizeInPixel = pricameraSizeInPixel;
	}
	public boolean isFingerPrintSupported() {
		return isFingerPrintSupported;
	}
	public void setFingerPrintSupported(boolean isFingerPrintSupported) {
		this.isFingerPrintSupported = isFingerPrintSupported;
	}
	public String getOsType() {
		return osType;
	}
	public void setOsType(String osType) {
		this.osType = osType;
	}

	@Override
	public String toString() {
		return "MobileEntity [mobileId=" + mobileId + ", brand=" + brand + ", price=" + price + ", rom=" + rom
				+ ", color=" + color + ", pricameraSizeInPixel=" + pricameraSizeInPixel + ", isFingerPrintSupported="
				+ isFingerPrintSupported + ", osType=" + osType + "]";
	}
	
	
}
