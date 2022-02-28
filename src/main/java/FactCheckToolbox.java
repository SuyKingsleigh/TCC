import core.ToolBoxResponse;
import spark.Spark;

public class FactCheckToolbox {
    public static void main(String[] args) {
        Spark.port(42042);

        Controller controller = new Controller();

        Spark.get("check", (request, response) -> {
            String s = request.queryString();
            System.out.println(s);

            ToolBoxResponse toolBoxResponse = controller.getClaims(s);
            System.out.println(toolBoxResponse);
            return toolBoxResponse.toString();
        });
    }


}
