/*
 * @ (#) RouteValidator.java     1.0     5/25/2024
 *
 * Copyright (c) 2024 IUH. All rights reserved
 */
package com.example.apigateway.filter;

import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.function.Predicate;

/*
 * @description:
 * @author: Huynh Minh Thu
 * @date: 10:58 PM 5/25/2024
 * @version: 1.0
 */
@Component
public class RouteValidator {
    public static final List<String> openApiEndpoints = List.of(
            "/auth/login",
            "/auth/register",
            "/eureka",
            "/api/v1/products",
            "/api/v1/products/products/{id}"

    );
    public Predicate<ServerHttpRequest> isSecured =
            request -> openApiEndpoints
                    .stream()
                    .noneMatch(uri -> request.getURI().getPath().contains(uri));

}
