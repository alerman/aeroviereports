package aerovie.alerman.com.aerovieweb;

import android.os.AsyncTask;

import com.google.gson.Gson;

import org.apache.http.HttpVersion;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpParams;
import org.apache.http.params.HttpProtocolParams;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.concurrent.ExecutionException;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import aerovie.alerman.com.aerovieweb.jsonRequestTypes.CreateAccountParameters;
import aerovie.alerman.com.aerovieweb.jsonRequestTypes.LoginParameters;

/**
 * Created by alerman on 9/12/14.
 */
public class WebRequestExecutor {
    private static WebRequestExecutor instance;
    private String url = "https://aerovie.com/api/applite-android.html";
    private Gson gson;

    private WebRequestExecutor(String url) {
        this.url = url;
        this.gson = new Gson();
    }

    public static WebRequestExecutor getInstance(String url) {
        if (instance != null) {
            return instance;
        }
        return new WebRequestExecutor(url);
    }

    public static HttpClient getNewHttpClient() {
        try {
            KeyStore trustStore = KeyStore.getInstance(KeyStore.getDefaultType());
            trustStore.load(null, null);

            SSLSocketFactory sf = new MySSLSocketFactory(trustStore);
            sf.setHostnameVerifier(SSLSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);

            HttpParams params = new BasicHttpParams();
            HttpProtocolParams.setVersion(params, HttpVersion.HTTP_1_1);
            HttpProtocolParams.setContentCharset(params, HTTP.UTF_8);

            SchemeRegistry registry = new SchemeRegistry();
            registry.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
            registry.register(new Scheme("https", sf, 443));

            ClientConnectionManager ccm = new ThreadSafeClientConnManager(params, registry);

            return new DefaultHttpClient(ccm, params);
        } catch (Exception e) {
            return new DefaultHttpClient();
        }
    }

    public String createAccount(String username, String password, String firstName, String lastName) throws IOException, ExecutionException, InterruptedException {
        CreateAccountParameters cap = new CreateAccountParameters();
        cap.setFirstName(firstName);
        cap.setLastName(lastName);
        cap.setPassword(password);
        cap.setUser(username);

        String requestData = new Gson().toJson(cap);
        String response = getResponse(gson.toJson(cap));
        return response;
    }

    public String login(String username, String password) throws IOException, ExecutionException, InterruptedException {
        LoginParameters lp = new LoginParameters();
        lp.setPassword(password);
        lp.setUsername(username);
        String response = getResponse(gson.toJson(lp));
        return response;


    }

    private String getResponse(String params) throws IOException, ExecutionException, InterruptedException {
        AsyncTask<String, Void, String> asyncTask = new AsyncTask<String, Void, String>() {
            @Override
            protected String doInBackground(String... params) {

                try {
                    HttpClient httpclient = WebRequestExecutor.getNewHttpClient();

                    HttpPost post = new HttpPost(url);
                    post.setEntity(new StringEntity("my_request=" + params[0]));
                    post.setHeader("Content-type", "application/json");

                    return new String(EntityUtils.toByteArray(httpclient.execute(post).getEntity()));
                } catch (IOException e) {
                    return null;
                }
            }
        };

        asyncTask.execute(params);
        return asyncTask.get();


    }

    static class MySSLSocketFactory extends SSLSocketFactory {
        SSLContext sslContext = SSLContext.getInstance("TLS");

        public MySSLSocketFactory(KeyStore truststore) throws NoSuchAlgorithmException, KeyManagementException, KeyStoreException, UnrecoverableKeyException {
            super(truststore);

            TrustManager tm = new X509TrustManager() {
                public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException {
                }

                public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException {
                }

                public X509Certificate[] getAcceptedIssuers() {
                    return null;
                }
            };

            sslContext.init(null, new TrustManager[]{tm}, null);
        }

        @Override
        public Socket createSocket(Socket socket, String host, int port, boolean autoClose) throws IOException, UnknownHostException {
            return sslContext.getSocketFactory().createSocket(socket, host, port, autoClose);
        }

        @Override
        public Socket createSocket() throws IOException {
            return sslContext.getSocketFactory().createSocket();
        }
    }

}
