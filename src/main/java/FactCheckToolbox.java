import core.ToolBoxResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import spark.Spark;

import java.time.LocalDateTime;

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
            return toolBoxResponse;
        });
    }


}
