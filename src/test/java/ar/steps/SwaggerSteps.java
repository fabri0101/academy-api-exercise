package ar.steps;

import api.config.EntityConfiguration;
import api.model.Login;
import com.crowdar.api.rest.APIManager;
import com.crowdar.core.PageSteps;
import com.google.api.client.repackaged.com.google.common.base.Splitter;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.commons.lang.StringUtils;
import org.testng.Assert;
import services.ExamenService;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

public class SwaggerSteps extends PageSteps {

//PRIMER ESCENARIO////////////////////////////////////////////////////////////////////////////////////////
    @When("realizo una peticion operacion (.*) al (.*) usando (.*)")
    public void realizoUnaPeticion(String operation, String entity, String request) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
     EntityConfiguration.valueOf(entity).getEntityService().getMethod(operation.toLowerCase(),String.class).invoke("",request);
    }

    @Then("obtengo el statusCode (.*)")
        public void ObtengoElStatusCode(int statusCode){
        int statusCodeResp = APIManager.getLastResponse().getStatusCode();
        Assert.assertEquals(statusCode, statusCodeResp);

    }

    @And("obtengo el token")
        public void ObtengoElToken(){
        Login resp = (Login)APIManager.getLastResponse().getResponse();
        ExamenService.TOKEN.set(resp.getToken());
    }

//SEGUNDO ESCENARIO//////////////////////////////////////////////////////////////////////////////////////
    @When("realiza una peticion operacion (.*) del entity (.*) utilizando este request (.*) y (.*)")
    public void doRequest(String operation, String entity, String request, String jsonParams) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException{
        Class entityService = EntityConfiguration.valueOf(entity).getEntityService();
        Map<String, String> parameters = getParameters(jsonParams);
        String jsonPath = "request/".concat(request);
        if (parameters == null) {
            entityService.getMethod(operation.toLowerCase(), String.class).invoke("", jsonPath);
        } else {
            entityService.getMethod(operation.toLowerCase(), String.class, Map.class).invoke("", jsonPath, parameters);
        }
    }

    private Map<String, String> getParameters(String jsonReplacementValues) {
        Map<String, String> parameters = null;
        if (!StringUtils.isEmpty(jsonReplacementValues)) {
            parameters = Splitter.on(",").withKeyValueSeparator(":").split(jsonReplacementValues);
        }
        return parameters;
    }

    @Then("se espera obtener un statusCode (.*)")
    public void seEsperaObtenerUnStatusCodeStatusCode(int expStatusCode) {
        int actualStatusCode = APIManager.getLastResponse().getStatusCode();
        Assert.assertEquals(expStatusCode,actualStatusCode, "los statusCode no los iguales");

    }

}
