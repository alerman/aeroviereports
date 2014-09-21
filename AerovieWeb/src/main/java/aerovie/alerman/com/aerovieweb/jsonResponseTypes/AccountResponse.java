package aerovie.alerman.com.aerovieweb.jsonResponseTypes;

import com.google.gson.annotations.SerializedName;

/**
 * Created by alerman on 9/14/14.
 */
public class AccountResponse {
    protected String auth;
    protected String error;
    protected String errorno;
    @SerializedName("auth_account_id")
    protected String authAccountId;
    protected String name;
    @SerializedName("facebook_ident")
    protected String facebookIdent;
    @SerializedName("twitter_ident")
    protected String twitterIdent;
    protected String pilot;
    @SerializedName("session_id")
    private String sessionId;

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public String getAuth() {
        return auth;
    }

    public void setAuth(String auth) {
        this.auth = auth;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getErrorno() {
        return errorno;
    }

    public void setErrorno(String errorno) {
        this.errorno = errorno;
    }

    public String getAuthAccountId() {
        return authAccountId;
    }

    public void setAuthAccountId(String authAccountId) {
        this.authAccountId = authAccountId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFacebookIdent() {
        return facebookIdent;
    }

    public void setFacebookIdent(String facebookIdent) {
        this.facebookIdent = facebookIdent;
    }

    public String getTwitterIdent() {
        return twitterIdent;
    }

    public void setTwitterIdent(String twitterIdent) {
        this.twitterIdent = twitterIdent;
    }

    public String getPilot() {
        return pilot;
    }

    public void setPilot(String pilot) {
        this.pilot = pilot;
    }
}
