package aerovie.alerman.com.aerovieweb.commonJsonTypes;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonParser;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import org.json.JSONArray;

import java.lang.reflect.Type;

import aerovie.alerman.com.aeroviedata.types.Airline;

/**
 * Created by alerman on 9/26/14.
 */
public class CustomAirlineDeserializer implements JsonSerializer<Airline>,JsonDeserializer<Airline> {

    private static Gson gson = new Gson();

    @Override
    public Airline deserialize(JsonElement json, Type type,
                               JsonDeserializationContext context) throws JsonParseException {

        JsonArray array = (JsonArray)json;
        // $cols = array("local","remote_airline_id","ident","name","city","callsign","deleted");
        Airline result = new Airline();

        result.setAirlineId(array.get(0).getAsString());
        result.setIdent(array.get(1).getAsString());
        result.setName(array.get(2).getAsString());
        result.setCity(array.get(3).getAsString());
        result.setCallsign(array.get(4).getAsString());
        result.setDeleted(array.get(5).getAsString());
        result.setSyncRemote(false);
        return result;

    }

    @Override
    public JsonElement serialize(Airline src, Type typeOfSrc, JsonSerializationContext context) {

        String[] stringArray = new String[6];
        JsonParser parser =new JsonParser();
        stringArray[0] = String.valueOf(src.getId());
        stringArray[1] = src.getIdent();
        stringArray[2] = src.getName();
        stringArray[3] = src.getCity();
        stringArray[4] = src.getCallsign();
        stringArray[5] = src.getDeleted();

        return parser.parse(gson.toJson(stringArray));
    }
}
