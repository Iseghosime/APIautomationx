package webautomationx;

import com.google.gson.Gson;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.mashape.unirest.http.options.Option;
import com.mashape.unirest.http.options.Options;
import kong.unirest.ObjectMapper;
import kong.unirest.gson.GsonObjectMapper;
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
        User[] users = Helper.usersFromJson(gson);
        Assertions.assertThat(users.length).isEqualTo(2);

        Assertions.assertThat(users[0].name).isEqualTo("admin");
        Assertions.assertThat(users[0].job).isEqualTo("admin");

        Assertions.assertThat(users[1].name).isEqualTo("ronaldo");
        Assertions.assertThat(users[1].job).isEqualTo("player");
    }

    @Test
    void usersCreationTest() throws UnsupportedEncodingException, UnirestException {
        User[] users = Helper.usersFromJson(gson);
        for (User user : users) {
            HttpResponse<JsonNode> result = Unirest
                    .post("https://reqres.in/api/users")
                    .body(gson.toJson(user))
                    .asJson();

            Assertions.assertThat(result.getStatus()).isEqualTo(201);
            Assertions.assertThat(result.getHeaders().getFirst("Content-Type")).isEqualTo("application/json; charset=utf-8");

            GsonObjectMapper objectMapper = new GsonObjectMapper();
            Response response = objectMapper.readValue(result.getBody().toString(), Response.class);
            System.out.println(response);
        }
    }

}
