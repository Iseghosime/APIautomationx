package webautomationx;

import com.google.gson.Gson;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.util.List;

public class ApiAutomationTest {

    static Gson gson;

    @BeforeAll
    static void setup() {
        gson = new Gson();
    }

    @Test
    void usersCreationTest() throws UnsupportedEncodingException {
        InputStream in = this.getClass().getClassLoader().getResourceAsStream("users.json");
        Reader reader = new InputStreamReader(in, "UTF-8");
        User[] users = gson.fromJson(reader, User[].class);

        for (User user : users) {
            System.out.println(user.name + " - " + user.job);
        }
    }

}
