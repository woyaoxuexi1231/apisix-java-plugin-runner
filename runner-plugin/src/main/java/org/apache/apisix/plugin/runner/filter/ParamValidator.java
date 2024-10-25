package org.apache.apisix.plugin.runner.filter;

import lombok.extern.slf4j.Slf4j;
import org.apache.apisix.plugin.runner.HttpRequest;
import org.apache.apisix.plugin.runner.HttpResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @author hulei
 * @since 2024/10/25 17:58
 */

@Component
public class ParamValidator implements PluginFilter {

    Logger logger = LoggerFactory.getLogger(TokenValidator.class);

    @Override
    public String name() {
        return "ParamValidator";
    }

    @Override
    public void filter(HttpRequest request, HttpResponse response, PluginFilterChain chain) {
        String token = request.getHeader("token");
        // response.getErrResponse().encode()
        logger.info("ParamValidatordubuglog:  get token: {}", token);
    }
}
