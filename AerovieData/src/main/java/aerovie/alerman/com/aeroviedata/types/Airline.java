package aerovie.alerman.com.aeroviedata.types;

import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.annotations.SerializedName;
import com.orm.SugarRecord;

import org.json.JSONArray;

import java.lang.reflect.Type;
import java.util.Date;

/**
 * Created by alerman on 9/16/14.
 */
public class Airline extends SugarRecord<Airline> {

    //"CREATE TABLE IF NOT EXISTS airline
    //  (`airline_id` integer primary key autoincrement,
    //  `timestamp` not null default current_timestamp,
    //  `ident` varchar(255) not null default '',
    //  `name` varchar(255) not null default '',
    //  `city` varchar(255) not null default '',
    //  `callsign` varchar(255) not null default '',
    //  `remote_airline_id` integer not null default '0',
    //  `deleted` varchar(255) not null default 'no',
    //  `sync_remote` varchar(255) not null default 'no')"];

    @SerializedName("airline_id")
    private String airlineId;
    private Date timestamp;
    private String ident;
    private String name;
    private String city;
    private String callsign;
    @SerializedName("remoate_airline_id")
    private String remoteAirlineId;
    private String deleted;
    @SerializedName("sync_remote")
    private String syncRemote;


    public String getAirlineId() {
        return airlineId;
    }

    public void setAirlineId(String airlineId) {
        this.airlineId = airlineId;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public String getIdent() {
        return ident;
    }

    public void setIdent(String ident) {
        this.ident = ident;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCallsign() {
        return callsign;
    }

    public void setCallsign(String callsign) {
        this.callsign = callsign;
    }

    public String getRemoteAirlineId() {
        return remoteAirlineId;
    }

    public void setRemoteAirlineId(String remoteAirlineId) {
        this.remoteAirlineId = remoteAirlineId;
    }

    public String getDeleted() {
        return deleted;
    }

    public void setDeleted(String deleted) {
        this.deleted = deleted;
    }

    public String getSyncRemote() {
        return syncRemote;
    }

    public void setSyncRemote(String syncRemote) {
        this.syncRemote = syncRemote;
    }

}
