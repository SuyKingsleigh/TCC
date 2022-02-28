import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;
import core.ToolBoxResponse;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.util.Collections;

public class Controller {
    private static final OkHttpClient client = new OkHttpClient()
            .newBuilder()
            .protocols(Collections.singletonList(Protocol.HTTP_1_1))
            .build();

    private static final String API_KEY = "AIzaSyCJZWEPBKFNqXADE7PRbMnsKyhcOFaYgN0";
    private static final String BASE_URL = "https://factchecktools.googleapis.com/v1alpha1/";
    private static final Logger logger = LoggerFactory.getLogger(Controller.class);


    public static void main(String[] args) throws IOException {
        System.out.println(new Controller().getClaims("putin%nuclear"));
    }

//    public ToolBoxResponse getClaims(String ...keyWords) throws IOException {
//        return this.getClaims(String.join("%", keyWords));
//    }

    public ToolBoxResponse getClaims(String query) throws IOException {
        String url = BASE_URL + "claims:search?" +
                "query=" + query +
                "&key=" + API_KEY;

        Request request = new Request.Builder()
                .url(url)
                .method("GET", null)
                .addHeader("Accept", "application/json")
                .build();

        try (Response response = client.newCall(request).execute()) {
            logger.debug("Called URL `" + url + "` received code: " + response.code());

            if (response.isSuccessful() && response.body() != null)
                return new ObjectMapper().readValue(response.body().string(), ToolBoxResponse.class);

        } catch (Exception e) {
            logger.debug("Failed to fact check query `" + query + "` url `" + url + "` ", e);
        }
        return null;
    }
}
