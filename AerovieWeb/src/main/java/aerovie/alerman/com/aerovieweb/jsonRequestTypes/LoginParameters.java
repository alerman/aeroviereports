package aerovie.alerman.com.aerovieweb.jsonRequestTypes;

import com.google.gson.annotations.SerializedName;

/**
 * Created by alerman on 9/12/14.
 */
public class LoginParameters extends AerovieParameters {
    @SerializedName("user")
    private String username;
    private String password;


    public LoginParameters() {
        this.request = "check_auth";
        this.connectionDescription = "check_auth";
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
