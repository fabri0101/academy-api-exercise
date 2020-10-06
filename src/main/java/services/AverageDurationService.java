package services;

import api.model.Data;
import api.model.UserCreated;
import com.crowdar.api.rest.MethodsService;
import com.crowdar.api.rest.Response;

public class AverageDurationService extends MethodsService {

    public static Response get(String jsonName) {
        return get(jsonName, String.class);
    }

}
