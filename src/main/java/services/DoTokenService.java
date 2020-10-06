package services;

import api.model.Login;
import com.crowdar.api.rest.MethodsService;
import com.crowdar.api.rest.Response;

import java.util.HashMap;
import java.util.Map;

public class DoTokenService extends MethodsService {
        public static final ThreadLocal<String> TOKEN = new ThreadLocal<>();

        public static Response get(String jsonName) {
            Map<String, String> Token = new HashMap<>();
            Token.put("Token", TOKEN.get());
            return get(jsonName, Login.class, Token);
        }
    }
