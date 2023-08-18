package practice1;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;

public class GetAndPost {
	@Test
	public void getmethod() {
		baseURI="https://reqres.in/api";
		given().get("/users/2").then().statusCode(200).
		body("data[1].id", equalTo(8))
		.body("data.first_name",hasItems("Rachel","Michael","Tobias", "Byron", "George") ).log().all();
	
	}
	@Test
	public void postmethos() {
		Map<String, Object> re=new HashMap<String, Object>();
		re.put("name", "venky");
		re.put("last name", "rowdy");
		re.put("job", "tester");
		JSONObject r=new JSONObject(re);
		System.out.println(r.toJSONString());
		baseURI="https://reqres.in/api";
		given().
		header("Content-Type","application/json").contentType(ContentType.JSON).accept(ContentType.JSON).
		
		
		
		body(r.toJSONString()).
		when().put("/users/2").then().statusCode(200).log().all();
		
	}
	@Test
	public void postmethod() {
		JSONObject r=new JSONObject();
		r.put("name", "rowdy");
		r.put("lastname", "narayana");
		System.out.println(r.toJSONString());
		baseURI="https://reqres.in/api";
		given().header("Content-Type","application/json").contentType(ContentType.JSON).accept(ContentType.JSON)
		.body(r.toJSONString()).when().post("api/users/2").then().statusCode(201).log().all();
	}@Test
	public void patchmethod() {
		JSONObject r=new JSONObject();
		r.put("name", "rowdy");
		r.put("lastname", "narayana");
		System.out.println(r.toJSONString());
		baseURI="https://reqres.in/api";
		given().header("Content-Type","application/json").contentType(ContentType.JSON).accept(ContentType.JSON)
		.body(r.toJSONString()).when().patch("api/users/2").then().statusCode(200).log().all();
	}
	@Test
	public void deletemethod() {
//		JSONObject r=new JSONObject();
//		r.put("name", "rowdy");
//		r.put("lastname", "narayana");
//		System.out.println(r.toJSONString());
		baseURI="https://reqres.in/api";
//		given().header("Content-Type","application/json").contentType(ContentType.JSON).accept(ContentType.JSON)
//		.body(r.toJSONString())
		when().delete("api/users/2").then().statusCode(204).log().all();
	}
}
