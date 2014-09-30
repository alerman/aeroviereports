package aerovie.alerman.com.aeroviedata.types;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;
import com.google.gson.annotations.SerializedName;


import java.util.Date;

/**
 * Created by alerman on 9/16/14.
 */

@Table(name = "upload")
public class Upload extends Model
{
    //"CREATE TABLE IF NOT EXISTS upload (
    // `upload_id` integer primary key autoincrement,
    // `timestamp` timestamp not null default current_timestamp,
    // `what` varchar not null default '',
    // `my_id` int not null default '0',
    // `status` varchar not null default '')"];

    @SerializedName("my_id")
    @Column(name="upload_id", unique = true, onUniqueConflict = Column.ConflictAction.FAIL)
    private String uploadId;
    @Column(name="timestmp")
    private Date timestamp;
    @Column(name="status")
    private String status;
    @Column(name="what")
    private String what;

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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
