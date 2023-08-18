package practice1;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class jsonchema {
	
		@Test
		public void getmethod() {
			baseURI="https://reqres.in/api";
			given().get("/users?page=2").then().assertThat().body(matchesJsonSchemaInClasspath("schema.json")).statusCode(200);
			
		}
}
