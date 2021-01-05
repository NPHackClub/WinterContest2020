package ca.unmined.api;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.util.ArrayList;

public class UserUtil {
    private int id;
    private String name;
    private String info;
    private String username;
    private String password;

    public UserUtil(int id, String username, String password, String name, String info) {
        this.id = id;
        this.name = name;
        this.info = info;
        this.username = username;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public static String UsersToString(ArrayList<UserUtil> userUtils) {
        StringBuilder out = new StringBuilder();

        assert userUtils != null;
        if (userUtils.size() > 1) {
            out.append("[");
            for (UserUtil userUtil : userUtils) {
                if (userUtils.indexOf(userUtil) == userUtils.size() - 1) out.append(userUtil.toString("]"));
                else out.append(userUtil.toString(",\n"));
            }
        }
        else {
            System.out.println(out.toString());
            return userUtils.get(0).toString();
        }

        return out.toString();
    }
    public static UserUtil UserFromJsonString(String in) throws ParseException {
        JSONObject obj = JSONObjectFromString(in);

        return new UserUtil(Integer.parseInt((String) obj.get("id")),
                (String) obj.get("username"),
                (String) obj.get("password"),
                (String) obj.get("name"),
                (String) obj.get("info")
        );
    }
    private static JSONObject JSONObjectFromString(String in) throws ParseException {
        JSONParser parser = new JSONParser();
        return (JSONObject) parser.parse(in);
    }

    public static boolean CheckIfValid(String data) {
            return data.contains("id")
                    && data.contains("name")
                    && data.contains("info")
                    && data.contains("username")
                    && data.contains("password");
    }

    public String toString() {
        return "{" +
                "\"id\": \"" + id + "\"," +
                "\"username\": \"" + username + "\"," +
                "\"password\": \"" + password + "\"," +
                "\"name\": \"" + name + "\"," +
                "\"info\": \"" + info + "\"" +
                "}";
    }
    public String toString(String after) {
        return "{" +
                "\"id\": \"" + id + "\"," +
                "\"username\": \"" + username + "\"," +
                "\"password\": \"" + password + "\"," +
                "\"name\": \"" + name + "\"," +
                "\"info\": \"" + info + "\"" +
                "}" + after;
    }

    public static String UserToJson(UserUtil u, String after) {
        return "{" +
                "\"id\": \"" + u.getId() + "\"," +
                "\"username\": \"" + u.getUsername() + "\"," +
                "\"password\": \"" + u.getPassword() + "\"," +
                "\"name\": \"" + u.getName() + "\"," +
                "\"info\": \"" + u.getInfo() + "\"" +
                "}" + after;
    }
    public static String UserToJson(int id, String username, String password, String name, String info, String after) {
        return "{" +
                "\"id\": \"" + id + "\"," +
                "\"username\": \"" + username + "\"," +
                "\"password\": \"" + password + "\"," +
                "\"name\": \"" + name + "\"," +
                "\"info\": \"" + info + "\"" +
                "}" + after;
    }
}
