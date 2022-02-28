package core;

import java.util.ArrayList;

public class ToolBoxResponse{
    public ArrayList<Claim> claims;

    @Override
    public String toString() {
        return "{\"ToolBoxResponse\":{"
                + "                        \"claims\":" + claims
                + "}}";
    }
}