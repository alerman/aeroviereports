package aerovie.alerman.com.aerovieweb.jsonResponseTypes;

import com.google.gson.annotations.SerializedName;

import aerovie.alerman.com.aerovieweb.commonJsonTypes.AirlinePirepData;

/**
 * Created by alerman on 9/26/14.
 */
public class SyncResponse {
    @SerializedName("sync_remote_data")
    private AirlinePirepData syncRemoteData;
    @SerializedName("device_sync_id")
    private String deviceSyncId;



    public AirlinePirepData getSyncRemoteData() {
        return syncRemoteData;
    }

    public void setSyncRemoteData(AirlinePirepData syncRemoteData) {
        this.syncRemoteData = syncRemoteData;
    }

    public String getDeviceSyncId() {
        return deviceSyncId;
    }

    public void setDeviceSyncId(String deviceSyncId) {
        this.deviceSyncId = deviceSyncId;
    }
}
