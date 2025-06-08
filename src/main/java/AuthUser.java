import POJO.User;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class AuthUser extends BaseSpecClass {
    private final User user;

    public AuthUser(User user) {
        this.user = user;
    }

    public Response authUser() {
        Response response = given()
                .spec(requestSpec)
                .body(user)
                .when()
                .post(UriConst.LOGIN_URI);
        return response;
    }
}
