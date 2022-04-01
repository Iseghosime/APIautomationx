package webautomationx;

import com.google.gson.Gson;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;

public class Helper {

    public static User[] usersFromJson(Gson gson) throws UnsupportedEncodingException {
        InputStream in = Helper.class.getClassLoader().getResourceAsStream("users.json");
        if (in == null) return new User[]{};
        Reader reader = new InputStreamReader(in, StandardCharsets.UTF_8);
        return gson.fromJson(reader, User[].class);
    }

}
