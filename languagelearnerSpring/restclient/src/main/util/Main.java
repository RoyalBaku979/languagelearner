package util;

import org.json.JSONArray;
import org.json.JSONObject;

public class Main {

    public static void main(String[] args) throws  Exception {
        String resp = RestUtil.getResp("http://localhost:8085/languagelearnerwebapp/rest/users");
        //6,Sarkhan, Rasullu; 5, Inci,Allahverdiyeva

        JSONArray arr = new JSONArray(resp);

        for (int i = 0; i < arr.length(); i++) {
            JSONObject obj = arr.getJSONObject(i);
            System.out.println(obj.getString("name"));
        }
    }
}
