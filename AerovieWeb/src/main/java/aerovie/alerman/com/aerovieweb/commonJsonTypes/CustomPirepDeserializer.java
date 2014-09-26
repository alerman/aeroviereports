package aerovie.alerman.com.aerovieweb.commonJsonTypes;

import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;

import aerovie.alerman.com.aeroviedata.types.Airline;
import aerovie.alerman.com.aeroviedata.types.Pirep;

/**
 * Created by alerman on 9/26/14.
 */
public class CustomPirepDeserializer implements JsonDeserializer<Pirep> {


    @Override
    public Pirep deserialize(JsonElement json, Type type,
                               JsonDeserializationContext context) throws JsonParseException {

        JsonArray array = (JsonArray)json;

        Pirep result = new Pirep();
        result.setRemotePirepId(array.get(0).getAsString());
        return result;

    }
}
