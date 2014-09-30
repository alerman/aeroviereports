package aerovie.alerman.com.aerovieweb.jsonRequestTypes;

import com.google.gson.annotations.SerializedName;

/**
 * Created by alerman on 9/26/14.
 */
public class VerifyRequestType extends AerovieParameters {

    @SerializedName("session_id")
    private String sessionId;
    @SerializedName("device_sync_id")
    private String deviceSyncId;
    @SerializedName("sync_timestamp")
    private String syncTimestamp;

    public VerifyRequestType()
    {
        connectionDescription = "db_sync_remote_verify";
        request = "db_sync_remote_verify";
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public String getDeviceSyncId() {
        return deviceSyncId;
    }

    public void setDeviceSyncId(String deviceSyncId) {
        this.deviceSyncId = deviceSyncId;
    }

    public String getSyncTimestamp() {
        return syncTimestamp;
    }

    public void setSyncTimestamp(String syncTimestamp) {
        this.syncTimestamp = syncTimestamp;
    }
}
