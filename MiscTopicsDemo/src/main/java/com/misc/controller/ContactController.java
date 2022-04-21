package com.misc.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

//VERSIONING DEMO


@RestController
public class ContactController {

	// Path Parameter based versioning
	@GetMapping(value="/contact/v1", produces = MediaType.APPLICATION_JSON_VALUE)//OLD API
	public Contact getContact() {
		return new Contact("Akshay", 123456);
	}
	
	@GetMapping(value="/contact/v2", produces = MediaType.APPLICATION_JSON_VALUE)//NEW API
	public ContactV2 getContactV2() {
		return new ContactV2("Akshay", 123456);
	}
	
	// Query Parameter based versioning
	@GetMapping(value="/contact", produces = MediaType.APPLICATION_JSON_VALUE, params="version=v1")//OLD API
	public Contact getContactQuery() {
		return new Contact("Akshay", 123456);
	}
	
	@GetMapping(value="/contact", produces = MediaType.APPLICATION_JSON_VALUE, params="version=v2")//NEW API
	public ContactV2 getContactQueryV2() {
		return new ContactV2("Akshay", 123456);
	}
	
	// Header Parameter based versioning
		@GetMapping(value="/contact", produces = MediaType.APPLICATION_JSON_VALUE, headers="version=v1")//OLD API
		public Contact getHeaderQuery() {
			return new Contact("Akshay", 123456);
		}
		
		@GetMapping(value="/contact", produces = MediaType.APPLICATION_JSON_VALUE, headers="version=v2")//NEW API
		public ContactV2 getHeaderQueryV2() {
			return new ContactV2("Akshay", 123456);
		}
	
	//Content Negotiation Based API versioning
		@GetMapping(value="/contact", produces = "application/contact.v1+json")//OLD API
		public Contact getContactContentNegotiationV1() {
			return new Contact("Akshay", 123456);
		}
		
		@GetMapping(value="/contact", produces = "application/contact.v2+json")//NEW API
		public ContactV2 getContactContentNegotiationV2() {
			return new ContactV2("Akshay", 123456);
		}
}

class Contact{
	private String name;
	private int mobile;
	public Contact(String name, int mobile) {
		super();
		this.name = name;
		this.mobile = mobile;
	}
	public Contact() {
		super();
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getMobile() {
		return mobile;
	}
	public void setMobile(int mobile) {
		this.mobile = mobile;
	}
	@Override
	public String toString() {
		return "Contact [name=" + name + ", mobile=" + mobile + "]";
	}
	
	
}
class ContactV2{
	private String name;
	private int mobileNo;
	public ContactV2(String name, int mobileNo) {
		super();
		this.name = name;
		this.mobileNo = mobileNo;
	}
	public ContactV2() {
		super();
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(int mobileNo) {
		this.mobileNo = mobileNo;
	}
	@Override
	public String toString() {
		return "ContactV2 [name=" + name + ", mobileNo=" + mobileNo + "]";
	}
	
	
	
}