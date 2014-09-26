package aerovie.alerman.com.aerovieweb.jsonRequestTypes;

import com.google.gson.annotations.SerializedName;

/**
 * Created by alerman on 9/26/14.
 */
public class SyncRequest extends AerovieParameters{


    @SerializedName("session_id")
    private String sessionId;
    @SerializedName("local_data")
    private LocalData localData;

    @SerializedName("device_sync_ic")
    private String deviceSyncId;

    public SyncRequest()
    {
        request = "db_sync_remote";
        connectionDescription = "db_sync_remote";
        localData = new LocalData();
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public LocalData getLocalData() {
        return localData;
    }

    public void setLocalData(LocalData localData) {
        this.localData = localData;
    }

    public String getDeviceSyncId() {
        return deviceSyncId;
    }

    public void setDeviceSyncId(String deviceSyncId) {
        this.deviceSyncId = deviceSyncId;
    }
}
