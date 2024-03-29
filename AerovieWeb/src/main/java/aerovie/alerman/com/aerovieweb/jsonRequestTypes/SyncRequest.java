package aerovie.alerman.com.aerovieweb.jsonRequestTypes;

import com.activeandroid.query.Select;
import com.google.common.collect.Lists;
import com.google.gson.annotations.SerializedName;

import aerovie.alerman.com.aeroviedata.types.Airline;
import aerovie.alerman.com.aeroviedata.types.Pirep;
import aerovie.alerman.com.aeroviedata.types.cifpAirport;
import aerovie.alerman.com.aerovieweb.commonJsonTypes.AirlinePirepData;

/**
 * Created by alerman on 9/26/14.
 */
public class SyncRequest extends AerovieParameters{


    @SerializedName("session_id")
    private String sessionId;
    @SerializedName("local_data")
    private AirlinePirepData localData;

    @SerializedName("device_sync_ic")
    private String deviceSyncId;

    public SyncRequest()
    {
        request = "db_sync_remote";
        connectionDescription = "db_sync_remote";
        localData = new AirlinePirepData();
        localData.setAirlines(new Select().all().from(Airline.class).where("sync_remote = ?", true).<Airline>execute());
        localData.setPireps(new Select().all().from(Pirep.class).where("sync_remote = ?", true).<Pirep>execute());
        localData.setAirports(new Select().all().from(cifpAirport.class).where("sync_remote = ?", true).<cifpAirport>execute());
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public AirlinePirepData getLocalData() {
        return localData;
    }

    public void setLocalData(AirlinePirepData localData) {
        this.localData = localData;
    }

    public String getDeviceSyncId() {
        return deviceSyncId;
    }

    public void setDeviceSyncId(String deviceSyncId) {
        this.deviceSyncId = deviceSyncId;
    }
}
