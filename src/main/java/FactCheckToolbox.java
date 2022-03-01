import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;
import core.Claim;
import core.ToolBoxResponse;
import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import spark.Spark;

import javax.xml.ws.WebServiceException;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.stream.Collectors;

public class FactCheckToolbox {
    private static final Logger logger = LoggerFactory.getLogger(FactCheckToolbox.class);

    public static void main(String[] args) {
        Controller controller = new Controller();
        logger.warn("FactCheckToolbox started at " + LocalDateTime.now());

        Spark.port(42042);

        Spark.get("check", (request, response) -> {
            String s = request.queryString();
            logger.debug("Received request to check claims: " + s);

            ToolBoxResponse toolBoxResponse = controller.getClaims(s);
            logger.debug("Responding with: " + toolBoxResponse);

            return new ObjectMapper().writeValueAsString(toolBoxResponse);
        });


        Spark.get("checkPretty", (request, response) -> {
            try {
                String s = request.queryString();
                logger.info("Received request to check claims: " + s);

                JSONObject json = new JSONObject();
                ToolBoxResponse toolBoxResponse = controller.getClaims(s);

                json.put("data",
                        toolBoxResponse != null && toolBoxResponse.claims != null ?
                                toolBoxResponse
                                        .claims
                                        .stream()
                                        .map(Claim::prettyClaim)
                                        .collect(Collectors.toList())
                                : new JSONArray()
                );


                return json.toString();
            } catch (Throwable t) {
                logger.error("Failed to handle claims", t);

                JSONObject jsonObject = new JSONObject();
                JSONArray arr = new JSONArray();

                arr.put("Desculpe, não consegui encontrar nada :C");
                jsonObject.put("data", arr);

                return jsonObject.toString();
            }
        });
    }


}
