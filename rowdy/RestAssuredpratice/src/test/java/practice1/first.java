package practice1;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
public class first {
	@Test
	public void first() {
		Response r=RestAssured.get("https://reqres.in/api/users?page=2");
		System.out.println(r.getHeader("content-type"));
		System.out.println(r.getStatusCode());
		System.out.println(r.getTime());
		System.out.println(r.getStatusLine());
		System.out.println(r.asString());
		Assert.assertEquals(r.getStatusCode(), 200);
	}
	
	
	
}


