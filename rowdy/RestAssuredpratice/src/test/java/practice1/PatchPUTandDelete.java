package practice1;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;
public class PatchPUTandDelete {
	@Test
public void putmethod() {
	JSONObject r=new JSONObject();
	r.put("name", "narayana");
	r.put("job", "tester");
	r.put("lastname", "rowdy");
	System.out.println(r.toJSONString());
	baseURI="https://reqres.in/api";
	given().body(r.toJSONString()).when().put("/users/2").then().statusCode(200).log().all();


}@Test
	public void patchmethod() {
		JSONObject r=new JSONObject();
		r.put("name", "narayana");
		r.put("job", "tester");
		r.put("lastname", "rowdy");
		System.out.println(r.toJSONString());
		baseURI="https://reqres.in";
		given().header("Content-Type","application/json").contentType(ContentType.JSON).accept(ContentType.JSON)
		.body(r.toJSONString()).when().put("/api/users/2").then().statusCode(200).log().all();
	}
@Test
public void deletemethod() {
	
	JSONObject r=new JSONObject();
	r.put("name", "narayana");
	r.put("job", "tester");
	r.put("lastname", "rowdy");
	System.out.println(r.toJSONString());
	baseURI="https://reqres.in";
	given().header("Content-Type","application/json").contentType(ContentType.JSON).accept(ContentType.JSON).body(r.toJSONString()).

	when().delete("/api/users/2").then().statusCode(204).log().all();
}
}
