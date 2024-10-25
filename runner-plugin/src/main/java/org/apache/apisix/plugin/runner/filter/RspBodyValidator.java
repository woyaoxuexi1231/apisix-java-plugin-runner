package org.apache.apisix.plugin.runner.filter;

import org.apache.apisix.plugin.runner.PostRequest;
import org.apache.apisix.plugin.runner.PostResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;

/**
 * @author hulei
 * @since 2024/10/25 17:56
 */


@Component
public class RspBodyValidator implements PluginFilter {

    Logger logger = LoggerFactory.getLogger(RspBodyValidator.class);


    @Override
    public String name() {
        return "RspBodyValidator";
    }

    @Override
    public void postFilter(PostRequest request, PostResponse response, PluginFilterChain chain) {

        String rsp = request.getBody(StandardCharsets.UTF_8) == null ? request.getBody() : request.getBody(StandardCharsets.UTF_8);

        logger.info("RspBodyValidatordubuglog: RspBodyValidator response body: {}", rsp);

        PluginFilter.super.postFilter(request, response, chain);
    }

    @Override
    public Boolean requiredRespBody() {
        return true;
    }
}
