package ubb.com.steps.api;

import net.thucydides.core.steps.ScenarioSteps;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.anyOf;
import static org.hamcrest.Matchers.is;

public class AbstractApiSteps extends ScenarioSteps {


    protected static <T> T getResource(String path, Class<T> responseClass) {
        return given().relaxedHTTPSValidation()
                .contentType("application/json")
                .when().get(path)
                .then().statusCode(anyOf(is(201), is(200), is(302)))
                .extract().as(responseClass);
    }

    protected static <T> T createResource(String path, Object requestBody, Class<T> responseClass) {
        return given().relaxedHTTPSValidation()
                .contentType("application/json")
                .body(requestBody)
                .when().post(path)
                .then()
                .assertThat().statusCode(anyOf(is(201), is(200), is(302)))
                .extract().as(responseClass);
    }

    protected static <T> T updateResource(String path, Object requestBody, Class<T> responseClass) {
        return given().relaxedHTTPSValidation()
                .contentType("application/json")
                .body(requestBody)
                .when().put(path)
                .then()
                .assertThat().statusCode(anyOf(is(201), is(200), is(302)))
                .extract().as(responseClass);
    }

    public static <T> T deleteResource(String path, Class<T> responseClass) {
        return given().relaxedHTTPSValidation()
                .contentType("application/json")
                .when().delete(path)
                .then()
                .assertThat().statusCode(anyOf(is(201), is(200), is(302)))
                .extract().as(responseClass);
    }

    public void createResource(String path, Object requestBody) {
        createResource(path, requestBody, Object.class);
    }

}
