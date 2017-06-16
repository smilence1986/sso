package demo;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@EnableResourceServer
public class ResourceApplication {

	@RequestMapping("/message")
	public Message home() {
		return new Message("Hello World");
	}

	@RequestMapping(method = RequestMethod.GET, value = "/me")
	public Map<String, String> me(Authentication authentication) {

		Map<String, String> res = new HashMap<>();
		res.put("username", "jianduo");
		res.put("email", "jianduo@124.com");
		res.put("name", "jianuoduo");
		res.put("id", UUID.randomUUID().toString());
		return res;
	}

	public static void main(String[] args) {
		SpringApplication.run(ResourceApplication.class, args);
	}

}

class Message {
	private String id = UUID.randomUUID().toString();
	private String username;

	Message() {
	}

	public Message(String content) {
		this.username = content;
	}

	public String getId() {
		return id;
	}

	public String getContent() {
		return username;
	}
}
