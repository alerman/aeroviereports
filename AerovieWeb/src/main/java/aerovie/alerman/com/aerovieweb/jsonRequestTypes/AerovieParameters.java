package aerovie.alerman.com.aerovieweb.jsonRequestTypes;

import com.google.gson.annotations.SerializedName;

/**
 * Created by alerman on 9/12/14.
 */
public abstract class AerovieParameters {

    @SerializedName("master_version")
    protected String masterVersion = "1.21";
    protected String request;
    @SerializedName("os_type")
    protected String osType = "android";

    @SerializedName("connection_description")
    protected String connectionDescription;

    public String getMasterVersion() {
        return masterVersion;
    }

    public void setMasterVersion(String masterVersion) {
        this.masterVersion = masterVersion;
    }

    public String getRequest() {
        return request;
    }

    public void setRequest(String request) {
        this.request = request;
    }

    public String getConnectionDescription() {
        return connectionDescription;
    }

    public void setConnectionDescription(String connectionDescription) {
        this.connectionDescription = connectionDescription;
    }
}
