package api.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Login {

    @JsonProperty("jwt")
    private String token;
    @JsonProperty("expires")
    private int expires;
    @JsonProperty("username")
    private String username;
    @JsonProperty("role")
    private String[] role;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public int getExpires() {
        return expires;
    }

    public void setExpires(int expires) {
        this.expires = expires;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String[] getRole() {
        return role;
    }

    public void setRole(String[] role) {
        this.role = role;
    }
}
