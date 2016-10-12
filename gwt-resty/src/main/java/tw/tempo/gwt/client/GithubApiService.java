package tw.tempo.gwt.client;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.fusesource.restygwt.client.MethodCallback;
import org.fusesource.restygwt.client.Options;
import org.fusesource.restygwt.client.RestService;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@Options(serviceRootKey = "github")
public interface GithubApiService extends RestService {
    @GET
    @Path("users/{username}")
    void user(@PathParam("username") String username,
              MethodCallback<User> callback);

    @JsonIgnoreProperties(ignoreUnknown = true)
    class User {
        public String login;
        public String id;
        @JsonProperty("avatar_url")
        public String avatarUrl;
        public String url;
        public String name;
        public String company;
        public String blog;
        public String location;
        public String email;
    }
}
