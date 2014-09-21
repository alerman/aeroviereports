package aerovie.alerman.com.aeroviedata.types;

import com.orm.SugarRecord;

import java.util.Date;

/**
 * Created by alerman on 9/16/14.
 */
public class cifpAirport extends SugarRecord<cifpAirport> {
    //        "CREATE TABLE IF NOT EXISTS cifp_airport (
    //          `cifp_airport_id` integer primary key autoincrement,
    //          `timestamp` not null default current_timestamp,
    //          `ident` varchar(255) not null default '',
    //          `name` varchar(255) not null default '',
    //          `my_lat` varchar(255) not null default '',
    //          `my_long` varchar(255) not null default '',
    //          `remote_cifp_airport_id` integer not null default '0',
    //          `deleted` varchar(255) not null default 'no',
    //          `sync_remote` varchar(255) not null default 'no')"];

    private String cifpAirportId;
    private Date timestamp;
    private String ident;
    private String name;
    private String myLat;
    private String myLong;
    private String remoteCifpAirportId;
    private String deleted;
    private String syncRemote;

    public String getCifpAirportId() {
        return cifpAirportId;
    }

    public void setCifpAirportId(String cifpAirportId) {
        this.cifpAirportId = cifpAirportId;
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

    public String getMyLat() {
        return myLat;
    }

    public void setMyLat(String myLat) {
        this.myLat = myLat;
    }

    public String getMyLong() {
        return myLong;
    }

    public void setMyLong(String myLong) {
        this.myLong = myLong;
    }

    public String getRemoteCifpAirportId() {
        return remoteCifpAirportId;
    }

    public void setRemoteCifpAirportId(String remoteCifpAirportId) {
        this.remoteCifpAirportId = remoteCifpAirportId;
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
