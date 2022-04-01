package webautomationx;

import com.google.gson.Gson;
import org.assertj.core.api.Assertions;
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
    void jsonReadTest() throws UnsupportedEncodingException {
        InputStream in = this.getClass().getClassLoader().getResourceAsStream("users.json");
        Reader reader = new InputStreamReader(in, "UTF-8");
        User[] users = gson.fromJson(reader, User[].class);

        Assertions.assertThat(users.length).isEqualTo(2);

        Assertions.assertThat(users[0].name).isEqualTo("admin");
        Assertions.assertThat(users[0].job).isEqualTo("admin");

        Assertions.assertThat(users[1].name).isEqualTo("ronaldo");
        Assertions.assertThat(users[1].job).isEqualTo("player");
    }

    @Test
    void usersCreationTest() throws UnsupportedEncodingException {

    }

}
