package aerovie.alerman.com.aeroviedata.types;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;
import com.google.gson.annotations.SerializedName;

import java.util.Date;

/**
 * Created by alerman on 9/16/14.
 */

@Table(name = "pirep")
public class Pirep extends Model {
    //        "CREATE TABLE IF NOT EXISTS `pirep` (`pirep_id` integer primary key autoincrement,
    // `timestamp` timestamp not null default current_timestamp,
    // `user_id` integer NOT NULL DEFAULT '0',
    // `name` varchar(255) not null default '',
    // `pirep_time` integer not null default '0',
    // `my_lat` varchar(255) NOT NULL DEFAULT '',
    // `my_long` varchar(255) NOT NULL DEFAULT '',
    // `altitude` varchar(255) NOT NULL DEFAULT '',
    // `gps_lat` varchar(255) NOT NULL DEFAULT '',
    // `gps_long` varchar(255) NOT NULL DEFAULT '',
    // `gps_altitude` varchar(255) NOT NULL DEFAULT '',
    // `callsign` varchar(255) NOT NULL DEFAULT '',
    // `comment` mediumtext NOT NULL,
    // `ride` varchar(255) NOT NULL DEFAULT 'na',
    // `ride_frequency` varchar(255) NOT NULL DEFAULT 'na',
    // `wx` varchar(255) NOT NULL DEFAULT 'na',
    // `is_clean` varchar(255) NOT NULL DEFAULT 'na',
    // `is_noisy` varchar(255) NOT NULL DEFAULT 'na',
    // `is_smelly` varchar(255) NOT NULL DEFAULT 'na',
    // `photo` blob NOT NULL,
    // `twitter` varchar(255) NOT NULL DEFAULT 'no',
    // `facebook` varchar(255) NOT NULL DEFAULT 'no',
    // `deleted` varchar(255) NOT NULL DEFAULT 'no',
    // `remote_pirep_id` integer not null default '0',
    // `sync_remote` varchar(255) not null default 'no')"];

    //        //MERGE THESE INTO MAIN CREATE TABLE
//        "ALTER TABLE pirep ADD `ride_base` varchar(255) not null default ''"];
//        "ALTER TABLE pirep ADD `ride_top` varchar(255) not null default ''"];
//        "ALTER TABLE pirep ADD `visibility` varchar(255) not null default ''"];
//        "ALTER TABLE pirep ADD `cloud` varchar(255) not null default 'na'"];
//        "ALTER TABLE pirep ADD `cloud_base` varchar(255) not null default ''"];
//        "ALTER TABLE pirep ADD `cloud_top` varchar(255) not null default ''"];
//        "ALTER TABLE pirep ADD `icing` varchar(255) not null default 'na'"];
//        "ALTER TABLE pirep ADD `icing_base` varchar(255) not null default ''"];
//        "ALTER TABLE pirep ADD `icing_top` varchar(255) not null default ''"];
//        "ALTER TABLE pirep ADD `callsign_type` varchar(255) not null default ''"];
//        "ALTER TABLE pirep ADD `oat` varchar(255) not null default ''"];
//        "ALTER TABLE pirep ADD `wind` varchar(255) not null default ''"];
//        "ALTER TABLE pirep ADD `icing_type` varchar(255) not null default ''"];
//        "ALTER TABLE pirep ADD `ride_type` varchar(255) not null default ''"];

    @Column(name="timestamp")
    private Date timestamp;
    @SerializedName("user_id")
    @Column(name="user_id")
    private String userId;
    @Column(name="name")
    private String name;
    @Column(name="pirep_time")
    @SerializedName("pirep_time")
    private String pirepTimestamp;
    @Column(name="my_lat")
    @SerializedName("my_lat")
    private String myLat;
    @Column(name="my_long")
    @SerializedName("my_long")
    private String myLong;
    @Column(name="altitude")
    private String altitude;
    @SerializedName("gps_lat")
    @Column(name="gps_lat")
    private String gpsLat;
    @Column(name="gps_long")
    @SerializedName("gps_long")
    private String gpsLong;
    @Column(name="gps_altitude")
    @SerializedName("gps_altitude")
    private String gpsAltitude;
    @Column(name="callsign")
    private String callsign;
    @Column(name="comment")
    private String comment;
    @Column(name="ride")
    private String ride;
    @Column(name="ride_frequency")
    @SerializedName("ride_frequency")
    private String rideFrequency;
    @Column(name="wx")
    private String wx;
    @Column(name="is_clean")
    @SerializedName("is_clean")
    private String isClean;
    @Column(name="is_noisy")
    @SerializedName("is_noisy")
    private String isNoisy;
    @Column(name="is_smelly")
    @SerializedName("is_smelly")
    private String isSmelly;
    @Column(name="photo")
    private String photo;
    @Column(name="twitter")
    private String twitter;
    @Column(name="facebook")
    private String facebook;
    @Column(name="deleted")
    private String deleted;
    @Column(name="remote_pirep_id", unique = true, onUniqueConflict = Column.ConflictAction.REPLACE)
    @SerializedName("remote_pirep_id")
    private String remotePirepId;
    @Column(name="sync_remote")
    @SerializedName("sync_remote")
    private boolean syncRemote;
    @Column(name="ride_base")
    @SerializedName("ride_base")
    private String rideBase;
    @Column(name="ride_top")
    @SerializedName("ride_top")
    private String rideTop;
    @Column(name="visibility")
    private String visibility;
    @Column(name="cloud")
    private String cloud;
    @Column(name="cloud_base")
    @SerializedName("cloud_base")
    private String cloudBase;
    @Column(name="cloud_top")
    @SerializedName("cloud_top")
    private String cloudTop;
    @Column(name="icing")
    private String icing;
    @Column(name="icing_base")
    @SerializedName("icing_base")
    private String icingBase;
    @Column(name="icing_top")
    @SerializedName("icing_top")
    private String icingTop;
    @Column(name="callsign_type")
    @SerializedName("callsign_type")
    private String callsignType;
    @Column(name="oat")
    private String oat;
    @Column(name="wind")
    private String wind;
    @Column(name="icing_type")
    @SerializedName("icing_type")
    private String icingType;
    @Column(name="rede_type")
    @SerializedName("ride_type")
    private String rideType;
    @Column(name="llws")
    private String llws;

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPirepTimestamp() {
        return pirepTimestamp;
    }

    public void setPirepTimestamp(String pirepTimestamp) {
        this.pirepTimestamp = pirepTimestamp;
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

    public String getAltitude() {
        return altitude;
    }

    public void setAltitude(String altitude) {
        this.altitude = altitude;
    }

    public String getGpsLat() {
        return gpsLat;
    }

    public void setGpsLat(String gpsLat) {
        this.gpsLat = gpsLat;
    }

    public String getGpsLong() {
        return gpsLong;
    }

    public void setGpsLong(String gpsLong) {
        this.gpsLong = gpsLong;
    }

    public String getGpsAltitude() {
        return gpsAltitude;
    }

    public void setGpsAltitude(String gpsAltitude) {
        this.gpsAltitude = gpsAltitude;
    }

    public String getCallsign() {
        return callsign;
    }

    public void setCallsign(String callsign) {
        this.callsign = callsign;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getRide() {
        return ride;
    }

    public void setRide(String ride) {
        this.ride = ride;
    }

    public String getRideFrequency() {
        return rideFrequency;
    }

    public void setRideFrequency(String rideFrequency) {
        this.rideFrequency = rideFrequency;
    }

    public String getWx() {
        return wx;
    }

    public void setWx(String wx) {
        this.wx = wx;
    }

    public String getIsClean() {
        return isClean;
    }

    public void setIsClean(String isClean) {
        this.isClean = isClean;
    }

    public String getIsNoisy() {
        return isNoisy;
    }

    public void setIsNoisy(String isNoisy) {
        this.isNoisy = isNoisy;
    }

    public String getIsSmelly() {
        return isSmelly;
    }

    public void setIsSmelly(String isSmelly) {
        this.isSmelly = isSmelly;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getTwitter() {
        return twitter;
    }

    public void setTwitter(String twitter) {
        this.twitter = twitter;
    }

    public String getFacebook() {
        return facebook;
    }

    public void setFacebook(String facebook) {
        this.facebook = facebook;
    }

    public String getDeleted() {
        return deleted;
    }

    public void setDeleted(String deleted) {
        this.deleted = deleted;
    }

    public String getRemotePirepId() {
        return remotePirepId;
    }

    public void setRemotePirepId(String remotePirepId) {
        this.remotePirepId = remotePirepId;
    }

    public boolean getSyncRemote() {
        return syncRemote;
    }

    public void setSyncRemote(boolean syncRemote) {
        this.syncRemote = syncRemote;
    }

    public String getRideBase() {
        return rideBase;
    }

    public void setRideBase(String rideBase) {
        this.rideBase = rideBase;
    }

    public String getRideTop() {
        return rideTop;
    }

    public void setRideTop(String rideTop) {
        this.rideTop = rideTop;
    }

    public String getVisibility() {
        return visibility;
    }

    public void setVisibility(String visibility) {
        this.visibility = visibility;
    }

    public String getCloud() {
        return cloud;
    }

    public void setCloud(String cloud) {
        this.cloud = cloud;
    }

    public String getCloudBase() {
        return cloudBase;
    }

    public void setCloudBase(String cloudBase) {
        this.cloudBase = cloudBase;
    }

    public String getCloudTop() {
        return cloudTop;
    }

    public void setCloudTop(String cloudTop) {
        this.cloudTop = cloudTop;
    }

    public String getIcing() {
        return icing;
    }

    public void setIcing(String icing) {
        this.icing = icing;
    }

    public String getIcingBase() {
        return icingBase;
    }

    public void setIcingBase(String icingBase) {
        this.icingBase = icingBase;
    }

    public String getIcingTop() {
        return icingTop;
    }

    public void setIcingTop(String icingTop) {
        this.icingTop = icingTop;
    }

    public String getCallsignType() {
        return callsignType;
    }

    public void setCallsignType(String callsignType) {
        this.callsignType = callsignType;
    }

    public String getOat() {
        return oat;
    }

    public void setOat(String oat) {
        this.oat = oat;
    }

    public String getWind() {
        return wind;
    }

    public void setWind(String wind) {
        this.wind = wind;
    }

    public String getIcingType() {
        return icingType;
    }

    public void setIcingType(String icingType) {
        this.icingType = icingType;
    }

    public String getRideType() {
        return rideType;
    }

    public void setRideType(String rideType) {
        this.rideType = rideType;
    }

    public String getLlws() {
        return llws;
    }

    public void setLlws(String llws) {
        this.llws = llws;
    }

    public  String getRideString(){
        if(ride.equalsIgnoreCase("smooth")) {
            return "smooth";
        }else if(ride.equalsIgnoreCase("light")) {
            return "light turbulence";
        }else if(ride.equalsIgnoreCase("light-moderate")) {
            return "light to moderate turbulence";
        }else if(ride.equalsIgnoreCase("moderate")) {
            return "moderate turbulence";
        }else if(ride.equalsIgnoreCase("moderate-severe")) {
           return "moderate to severe turbulence";
        }else if(ride.equalsIgnoreCase("severe")) {
           return "SEVERE turbulence";
        }else if(ride.equalsIgnoreCase("extreme")) {
            return "EXTREME turbulence";
        }else return "smooth";
        //TODO WHAT SHOUD DEFAULT RETURN BE?

    }
}
