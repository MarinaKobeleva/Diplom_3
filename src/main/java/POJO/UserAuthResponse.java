package POJO;

public class UserAuthResponse {
    private String success;
    private User user;
    private String accessToken;
    private String refreshToken;

    public UserAuthResponse() {
    }

    public String getSuccess() {
        return success;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public User getUser() {
        return user;
    }

    public void setSuccess(String success) {
        this.success = success;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

}