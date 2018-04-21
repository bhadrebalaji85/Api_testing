package ApiTesting.com.google.api;
//Comment added
import javax.mail.internet.ContentType;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.jayway.restassured.response.Response;

import static com.jayway.restassured.RestAssured.*;

public class Weather_byCity {
  @Test
  public void Test_01() {
	  
	  Response res= when().
	  get("http://api.openweathermap.org/data/2.5/weather?" +
	  		"q=London&appid=ab7c75acbd12c739ec967844e747e448");
	  
	  System.out.println(res.getStatusCode());
	  
	  Assert.assertEquals(res.getStatusCode(), 200);
	  
  }
  
  @Test
  public void Test_02() {
	  
	  Response res= when().
	  get("http://api.openweathermap.org/data/2.5/weather?" +
	  		"q=London&appid=ab7c75acbd12c739ec967844e747e448");
	  
	  System.out.println(res.getStatusCode());
	  
	  Assert.assertEquals(res.getStatusCode(), 200);
	  
	  System.out.println(res.asString());
  }
  
  @Test
  public void Test_03()
  {
	  given().
	  param("q","London").
	  param("appid","ab7c75acbd12c739ec967844e747e448").
	  when().
	  get("http://api.openweathermap.org/data/2.5/weather").
	  then().
	  assertThat().statusCode(200);
	  
  }
  
  @Test
  public void Test_03_jsonpath()
  {
	  String jsonpath=given().
	  param("q","London").
	  param("appid","ab7c75acbd12c739ec967844e747e448").
	  when().
	  get("http://api.openweathermap.org/data/2.5/weather").
	  then().
      contentType(com.jayway.restassured.http.ContentType.JSON).
	  extract().
	  
	  path("sys.country");
	  //assertThat().statusCode(200);
	  
	  System.out.println("Current Humidity"+jsonpath);
	  
  }
}
