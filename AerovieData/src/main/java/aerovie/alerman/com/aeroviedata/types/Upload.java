package aerovie.alerman.com.aeroviedata.types;

import com.google.gson.annotations.SerializedName;
import com.orm.SugarRecord;

import java.util.Date;

/**
 * Created by alerman on 9/16/14.
 */
public class Upload extends SugarRecord<Upload> {
    //"CREATE TABLE IF NOT EXISTS upload (
    // `upload_id` integer primary key autoincrement,
    // `timestamp` timestamp not null default current_timestamp,
    // `what` varchar not null default '',
    // `my_id` int not null default '0',
    // `status` varchar not null default '')"];

    @SerializedName("upload_id")
    private String uploadId;
    private Date timestamp;
    private String what;
    @SerializedName("my_id")
    private String myId;
    private String status;

    public String getUploadId() {
        return uploadId;
    }

    public void setUploadId(String uploadId) {
        this.uploadId = uploadId;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public String getWhat() {
        return what;
    }

    public void setWhat(String what) {
        this.what = what;
    }

    public String getMyId() {
        return myId;
    }

    public void setMyId(String myId) {
        this.myId = myId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
