package com.apiautomationchallenge.model;

public class AddressClass {
	
	private String street;
    private String suite;
    private String city;
    private String zipcode;
    private GeoClass geo;
    private String phone;
    private String website;
    private CompanyClass company;
	
    public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getSuite() {
		return suite;
	}
	public void setSuite(String suite) {
		this.suite = suite;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	public GeoClass getGeo() {
		return geo;
	}
	public void setGeo(GeoClass geo) {
		this.geo = geo;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getWebsite() {
		return website;
	}
	public void setWebsite(String website) {
		this.website = website;
	}
	public CompanyClass getCompany() {
		return company;
	}
	public void setCompany(CompanyClass company) {
		this.company = company;
	}



}
