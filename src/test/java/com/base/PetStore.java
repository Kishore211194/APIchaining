package com.base;

import java.util.ArrayList;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class PetStore extends BaseClass {
	Response response;
	int petid;

	@Test(priority = 1)
	public void createPet() {

		header("Content-Type", " application/json");
		Category c = new Category(8, "petstore");
		ArrayList<String> photoUrls = new ArrayList<String>();
		photoUrls.add("google");
		ArrayList<Tag> tags = new ArrayList<Tag>();
		Tag t1 = new Tag(10, "dalmination");
		tags.add(t1);
		Root r = new Root(123, c, "Dog", photoUrls, tags, "Available");
		body(r);
		Response response = methodType("POST", "https://petstore.swagger.io/v2/pet");
		int statusCode = getStatusCode(response);
		System.out.println(statusCode);
		Root as = response.as(Root.class);
		petid = as.getId();
		System.out.println(petid);

	}

	@Test(priority = 2)
	public void updatepet() {
		header("Content-Type", " application/json");
		Category c = new Category(7	, "homepet");
		ArrayList<String> photoUrls = new ArrayList<String>();
		photoUrls.add("amazon");
		ArrayList<Tag> tags = new ArrayList<Tag>();
		Tag t1 = new Tag(10, "labor");
		tags.add(t1);
		String randompetname = RandomStringUtils.randomAlphabetic(8);
		Root r = new Root(petid, c, randompetname, photoUrls, tags, "Available");
		body(r);
		Response response = methodType("PUT", "https://petstore.swagger.io/v2/pet");
		int statusCode = getStatusCode(response);
		System.out.println(statusCode);
		Root as = response.as(Root.class);
		petid = as.getId();
		System.out.println(petid);

	}

	@Test(priority = 3)
	public void gettheupdatedpet() {
		header("Content-Type", " application/json");
//		pathParam("Petid", String.valueOf(petid));
		Response response = methodType("GET", "https://petstore.swagger.io/v2/pet/123");
		int statusCode = getStatusCode(response);
		System.out.println(statusCode);
		Root as = response.as(Root.class);
		System.out.println(as.getId());
		System.out.println(as.getName());
		System.out.println(as.getStatus());
	}

	@Test(priority = 4)
	public void deletepetid() {
		header("Content-Type", " application/json");
//		pathParam("Petid", String.valueOf(petid));
		Response response = methodType("DELETE", "https://petstore.swagger.io/v2/pet/123");
		int statusCode = getStatusCode(response);
		System.out.println(statusCode);
		DeletePet dp = response.as(DeletePet.class);
		System.out.println(dp.getCode());
		System.out.println(dp.getMessage());
		System.out.println(dp.getType());
	}

}
