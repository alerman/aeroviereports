package aerovie.alerman.com.aerovieweb.jsonRequestTypes;


import com.google.gson.annotations.SerializedName;

/**
 * Created by alerman on 9/12/14.
 */
public class CreateAccountParameters extends AerovieParameters {

    @SerializedName("first_name")
    private String firstName;
    private String password;

    @SerializedName("last_name")
    private String lastName;
    private String user;

    public CreateAccountParameters() {
        this.connectionDescription = "create_account";
        this.request = "create_account";
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }
}
