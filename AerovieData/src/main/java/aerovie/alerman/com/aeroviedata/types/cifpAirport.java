package aerovie.alerman.com.aeroviedata.types;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

import java.util.Date;

/**
 * Created by alerman on 9/16/14.
 */
@Table(name = "cifp_airport")
public class cifpAirport extends Model {
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

    @Column(name = "remote_cifp_airport_id", unique = true, onUniqueConflict = Column.ConflictAction.FAIL)
    private String cifpAirportId;
    @Column(name="timestamp")
    private Date timestamp;
    @Column(name="ident")
    private String ident;
    @Column(name="name")
    private String name;
    @Column(name="my_lat")
    private String myLat;
    @Column(name="my_log")
    private String myLong;
    @Column(name="deleted")
    private String deleted;
    @Column(name="sync_remote")
    private boolean syncRemote;

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
