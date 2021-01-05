package ca.unmined.api.controllers;

import ca.unmined.api.Main;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.web.bind.annotation.*;

import java.io.*;

@RestController
@RequestMapping("/api")
public class MainController {

    @PostMapping("/terminal")
    public String code(@RequestBody String code, @RequestHeader("key") String key) {
        if (!validApiKey(key)) return null;
        String n = "code.py";
        createFile(n);
        String nCode = getCodeFromJson(code);
        dumpText(n, nCode);
        return getPythonOutput(n);
    }

    private static void createFile(String name) {
        try {
            File file = new File(name);
            if (file.createNewFile()) {
                System.out.println("New code file created: " + file.getName()); // TODO: 2021-01-04 remove this println
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void dumpText(String file, String text) {
        try {
            FileWriter writer = new FileWriter(file);
            writer.write(text);
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String getCodeFromJson(String json) {
        try {
            JSONParser parser = new JSONParser();
            JSONObject o = (JSONObject) parser.parse(json);
            return (String) o.get("code");

        } catch (ParseException e) {
            return json;
        }
    }

    private static String getPythonOutput(String name) {
        try {
            String command = "py " + name;
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(new SequenceInputStream(
                            Runtime.getRuntime().exec(command).getErrorStream(),
                            Runtime.getRuntime().exec(command).getInputStream()
                    ))
            );

            String line;
            StringBuilder b = new StringBuilder();
            while((line = in.readLine()) != null) {
                if (line.contains("C:\\Users\\chris\\Documents\\Misc programs\\Test Programs\\JavaServer\\"))
                    line = line.replace("C:\\Users\\chris\\Documents\\Misc programs\\Test Programs\\JavaServer\\", "\\");
                b.append(line);
                b.append("\n");
            }

            in.close();

            return b.toString();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return "An error occurred when running the program";
    }

    private boolean validApiKey(String key) {
        return key.equals(String.valueOf(Main.apiKey));
    }
}
