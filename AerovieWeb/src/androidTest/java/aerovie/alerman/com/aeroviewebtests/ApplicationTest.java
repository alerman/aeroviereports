package aerovie.alerman.com.aeroviewebtests;

import android.app.Application;
import android.test.ApplicationTestCase;
import android.test.suitebuilder.annotation.SmallTest;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

/**
 * <a href="http://d.android.com/tools/testing/testing_android.html">Testing Fundamentals</a>
 */
public class ApplicationTest extends ApplicationTestCase<Application> {
    public ApplicationTest() throws InterruptedException, ExecutionException, IOException {
        super(Application.class);
    }

    @SmallTest
    public void testLogin() throws InterruptedException, ExecutionException, IOException {


        WebRequestExecutor wre = WebRequestExecutor.getInstance("https://aerovie.com/api/applite-android.html");

        String result  = wre.login("alerman@gmail.com","test");
        assertNotNull(result);
    }


}