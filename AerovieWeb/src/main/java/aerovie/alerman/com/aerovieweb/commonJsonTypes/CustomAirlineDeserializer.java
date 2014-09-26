package aerovie.alerman.com.aerovieweb.commonJsonTypes;

import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;

import aerovie.alerman.com.aeroviedata.types.Airline;

/**
 * Created by alerman on 9/26/14.
 */
public class CustomAirlineDeserializer implements JsonDeserializer<Airline> {


    @Override
    public Airline deserialize(JsonElement json, Type type,
                               JsonDeserializationContext context) throws JsonParseException {

        JsonArray array = (JsonArray)json;

        Airline result = new Airline();
        result.setAirlineId(array.get(0).getAsString());
        result.setCallsign(array.get(1).getAsString());
        result.setIdent(array.get(2).getAsString());
        result.setCity(array.get(3).getAsString());
        result.setRemoteAirlineId(array.get(4).getAsString());
        result.setDeleted(array.get(5).getAsString());

        return result;

    }
}
