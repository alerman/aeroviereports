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
import aerovie.alerman.com.aeroviedata.types.cifpAirport;

/**
 * Created by alerman on 9/26/14.
 */
public class CustomAirportDeserializer implements JsonSerializer<cifpAirport>,JsonDeserializer<cifpAirport> {

    private static Gson gson = new Gson();

    @Override
    public cifpAirport deserialize(JsonElement json, Type type,
                             JsonDeserializationContext context) throws JsonParseException {

        JsonArray array = (JsonArray) json;
        //"local","remote_cifp_airport_id","ident","name","my_lat","my_long","deleted")
        cifpAirport result = new cifpAirport();
        result.setCifpAirportId(array.get(0).getAsString());
        result.setIdent(array.get(1).getAsString());
        result.setName(array.get(2).getAsString());
        result.setMyLat(array.get(3).getAsString());
        result.setMyLong(array.get(4).getAsString());
        result.setDeleted(array.get(5).getAsString());
        result.setSyncRemote(false);

        return result;

    }


    @Override
    public JsonElement serialize(cifpAirport src, Type typeOfSrc, JsonSerializationContext context) {
        String[] stringArray = new String[6];
        JsonParser parser =new JsonParser();
        stringArray[0] = src.getCifpAirportId();
        stringArray[1] = src.getIdent();
        stringArray[2] = src.getName();
        stringArray[3] = src.getMyLat();
        stringArray[4] = src.getMyLong();
        stringArray[5] = src.getDeleted();

        return parser.parse(gson.toJson(stringArray));
    }
}

