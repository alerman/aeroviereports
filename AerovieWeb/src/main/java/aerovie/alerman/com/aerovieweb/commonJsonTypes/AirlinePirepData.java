package aerovie.alerman.com.aerovieweb.commonJsonTypes;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import aerovie.alerman.com.aeroviedata.types.Airline;
import aerovie.alerman.com.aeroviedata.types.Pirep;
import aerovie.alerman.com.aeroviedata.types.cifpAirport;

/**
 * Created by alerman on 9/26/14.
 */
public class AirlinePirepData {
    @SerializedName("airline")
    private List<Airline> airlines;

    @SerializedName("pirep")
    private List<Pirep> pireps;
    @SerializedName("cifp_airport")
    private List<cifpAirport> airports;

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

    public List<cifpAirport> getAirports() {
        return airports;
    }

    public void setAirports(List<cifpAirport> airports) {
        this.airports = airports;
    }
}
