package aerovie.alerman.com.aeroviedata.types;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;
import com.google.gson.annotations.SerializedName;

import java.util.Date;

/**
 * Created by alerman on 9/16/14.
 */
@Table(name = "airline")
public class Airline extends Model {

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
    @Column(name="remote_airline_id", unique = true, onUniqueConflict = Column.ConflictAction.REPLACE)
    private String airlineId;
    @Column(name="timestamp")
    private Date timestamp;
    @Column(name="ident")
    private String ident;
    @Column(name="name")
    private String name;
    @Column(name="city")
    private String city;
    @Column(name="callsign")
    private String callsign;
    @Column(name="deleted")
    private String deleted;
    @SerializedName("sync_remote")
    @Column(name="sync_remote")
    private boolean syncRemote;


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



    public String getDeleted() {
        return deleted;
    }

    public void setDeleted(String deleted) {
        this.deleted = deleted;
    }

    public boolean getSyncRemote() {
        return syncRemote;
    }

    public void setSyncRemote(boolean syncRemote) {
        this.syncRemote = syncRemote;
    }

}
