package org.apache.apisix.plugin.runner.filter;

import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.apache.apisix.plugin.runner.HttpRequest;
import org.apache.apisix.plugin.runner.HttpResponse;
import org.apache.apisix.plugin.runner.PostRequest;
import org.apache.apisix.plugin.runner.PostResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

@Component
public class TokenValidator implements PluginFilter {

    Logger logger = LoggerFactory.getLogger(TokenValidator.class);

    @Override
    public String name() {
        return "TokenValidator";
    }

    @Override
    public void filter(HttpRequest request, HttpResponse response, PluginFilterChain chain) {

        // get configuration parameters
        String token = request.getHeader("token");
        boolean flag = validate(token);

        // response.getErrResponse().encode()

        logger.info("TokenValidatordubuglog:  receive token: {}", token);
        logger.info("TokenValidatordubuglog:  request headers: {}", request.getHeaders());
        logger.info("TokenValidatordubuglog:  response: {}", response);

        // token verification results
        if (!flag) {
            response.setStatusCode(Integer.parseInt("403"));
            chain.filter(request, response);
        }

        chain.filter(request, response);
    }


    @Override
    public Boolean requiredRespBody() {
        return true;
    }

    private Boolean validate(String token) {
        // TODO: improve the validation process
        return token != null && !token.isEmpty();
    }
}