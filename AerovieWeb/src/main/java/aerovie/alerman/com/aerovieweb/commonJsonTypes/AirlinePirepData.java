package aerovie.alerman.com.aerovieweb.commonJsonTypes;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import aerovie.alerman.com.aeroviedata.types.Airline;
import aerovie.alerman.com.aeroviedata.types.Pirep;

/**
 * Created by alerman on 9/26/14.
 */
public class AirlinePirepData {
    @SerializedName("airline")
    private List<Airline> airlines;

    @SerializedName("pirep")
    private List<Pirep> pireps;

    public List<Airline> getAirlines() {
        return airlines;
    }

    public void setAirlines(List<Airline> airlines) {
        this.airlines = airlines;
    }

    public List<Pirep> getPireps() {
        return pireps;
    }

    public void setPireps(List<Pirep> pireps) {
        this.pireps = pireps;
    }
}
