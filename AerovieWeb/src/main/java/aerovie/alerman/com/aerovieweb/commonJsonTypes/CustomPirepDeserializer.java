package aerovie.alerman.com.aerovieweb.commonJsonTypes;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonParser;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import java.lang.reflect.Type;

import aerovie.alerman.com.aeroviedata.types.Airline;
import aerovie.alerman.com.aeroviedata.types.Pirep;

/**
 * Created by alerman on 9/26/14.
 */
public class CustomPirepDeserializer implements JsonSerializer<Pirep>,JsonDeserializer<Pirep> {


     private static Gson gson = new Gson();

    @Override
    public Pirep deserialize(JsonElement json, Type type,
                             JsonDeserializationContext context) throws JsonParseException {

        JsonArray array = (JsonArray) json;
        //"local","remote_pirep_id","name","pirep_time","my_lat","my_long","altitude","gps_lat","gps_long","gps_altitude","callsign","comment",
        // "ride","ride_frequency","wx","is_clean","is_noisy","is_smelly","photo","twitter","facebook","ride_base","ride_top",
        // "visibility","cloud","cloud_base","cloud_top","icing","icing_base","icing_top","callsign_type",
        // "oat","wind","icing_type","ride_type","llws","deleted"
        Pirep result = new Pirep();

        result.setSyncRemote(false);
        result.setRemotePirepId(array.get(0).getAsString());
        result.setName(array.get(1).getAsString());
        result.setPirepTimestamp(array.get(2).getAsString());
        result.setMyLat(array.get(3).getAsString());
        result.setMyLong(array.get(4).getAsString());
        result.setAltitude(array.get(5).getAsString());
        result.setGpsLat(array.get(6).getAsString());
        result.setGpsLong(array.get(7).getAsString());
        result.setGpsAltitude(array.get(8).getAsString());
        result.setCallsign(array.get(9).getAsString());
        result.setComment(array.get(10).getAsString());
        result.setRide(array.get(11).getAsString());
        result.setRideFrequency(array.get(12).getAsString());
        result.setWx(array.get(13).getAsString());
        result.setIsClean(array.get(14).getAsString());
        result.setIsNoisy(array.get(15).getAsString());
        result.setIsSmelly(array.get(16).getAsString());
        result.setPhoto(array.get(17).getAsString());
        result.setTwitter(array.get(18).getAsString());
        result.setFacebook(array.get(19).getAsString());
        result.setRideBase(array.get(20).getAsString());
        result.setRideTop(array.get(21).getAsString());
        result.setVisibility(array.get(22).getAsString());
        result.setCloud(array.get(23).getAsString());
        result.setCloudBase(array.get(24).getAsString());
        result.setCloudTop(array.get(25).getAsString());
        result.setIcing(array.get(26).getAsString());
        result.setIcingBase(array.get(27).getAsString());
        result.setIcingTop(array.get(28).getAsString());
        result.setCallsignType(array.get(29).getAsString());
        result.setOat(array.get(30).getAsString());
        result.setWind(array.get(31).getAsString());
        result.setIcingType(array.get(32).getAsString());
        result.setRideType(array.get(33).getAsString());
        result.setLlws(array.get(34).getAsString());
        result.setDeleted(array.get(35).getAsString());

        return result;

    }

    @Override
    public JsonElement serialize(Pirep src, Type typeOfSrc, JsonSerializationContext context) {
        String[] stringArray = new String[36];
        JsonParser parser =new JsonParser();

        stringArray[0] = src.getRemotePirepId();
        stringArray[1] = src.getName();
        stringArray[2] = src.getPirepTimestamp();
        stringArray[3] = src.getMyLat();
        stringArray[4] = src.getMyLong();
        stringArray[5] = src.getAltitude();
        stringArray[6] = src.getGpsLat();
        stringArray[7] = src.getGpsLong();
        stringArray[8] = src.getGpsAltitude();
        stringArray[9] = src.getCallsign();
        stringArray[10] = src.getComment();
        stringArray[11] = src.getRide();
        stringArray[12] = src.getRideFrequency();
        stringArray[13] = src.getWx();
        stringArray[14] = src.getIsClean();
        stringArray[15] = src.getIsNoisy();
        stringArray[16] = src.getIsSmelly();
        stringArray[17] = src.getPhoto();
        stringArray[18] = src.getTwitter();
        stringArray[19] = src.getFacebook();
        stringArray[20] = src.getRideBase();
        stringArray[21] = src.getRideTop();
        stringArray[22] = src.getVisibility();
        stringArray[23] = src.getCloud();
        stringArray[24] = src.getCloudBase();
        stringArray[25] = src.getCloudTop();
        stringArray[26] = src.getIcing();
        stringArray[27] = src.getIcingBase();
        stringArray[28] = src.getIcingTop();
        stringArray[29] = src.getCallsignType();
        stringArray[30] = src.getOat();
        stringArray[31] = src.getWind();
        stringArray[32] = src.getIcingType();
        stringArray[33] = src.getRideType();
        stringArray[34] = src.getLlws();
        stringArray[35] = src.getDeleted();

       return parser.parse(gson.toJson(stringArray));
    }
}
