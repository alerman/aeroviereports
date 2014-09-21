package aerovie.alerman.com.mymodule.app2;

import android.app.Application;
import android.test.ApplicationTestCase;

import java.util.Iterator;

import aerovie.alerman.com.aeroviedata.types.Airline;

/**
 * <a href="http://d.android.com/tools/testing/testing_android.html">Testing Fundamentals</a>
 */
public class ApplicationTest extends ApplicationTestCase<Application> {
    public ApplicationTest() {
        super(Application.class);

        Airline airline = new Airline();
        airline.setAirlineId("1");
        airline.setCallsign("call");
        airline.setCity("city");
        airline.setDeleted("deleted");
        airline.setIdent("ident");
        airline.setName("name");
        airline.setRemoteAirlineId("1");
        airline.setSyncRemote("0");

        airline.save();

        assertNotNull(airline.getId());
        Iterator<Airline> line = Airline.findAll(Airline.class);
    }
}