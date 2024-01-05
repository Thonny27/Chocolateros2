package com.sport.chocolateros.app;

import com.sport.chocolateros.app.handler.CustomerSoccerFieldHandler;
import com.sport.chocolateros.app.handler.ReserveHandler;
import com.sport.chocolateros.app.handler.TeamHandler;
import com.sport.chocolateros.app.handler.UserHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
public class RouterFunctionConfig {

    @Bean
    public RouterFunction<ServerResponse> routes(UserHandler userHandler,
                                                 CustomerSoccerFieldHandler customerSoccerFieldHandler,
                                                 ReserveHandler reserveHandler,
                                                 TeamHandler teamHandler) {
        return RouterFunctions.route(RequestPredicates.POST("/api/chocolateros/user"), userHandler::save)
                .andRoute(RequestPredicates.PUT("/api/chocolateros/user/{id}"), userHandler::update)
                .andRoute(RequestPredicates.GET("/api/chocolateros/user"), userHandler::findAll)
                .andRoute(RequestPredicates.GET("/api/chocolateros/user/{id}"), userHandler::findById)
                .andRoute(RequestPredicates.POST("/api/chocolateros/customerSoccerField"), customerSoccerFieldHandler::save)
                .andRoute(RequestPredicates.PUT("/api/chocolateros/customerSoccerField/{id}"), customerSoccerFieldHandler::update)
                .andRoute(RequestPredicates.GET("/api/chocolateros/customerSoccerField"), customerSoccerFieldHandler::findAll)
                .andRoute(RequestPredicates.GET("/api/chocolateros/customerSoccerField/{id}"), customerSoccerFieldHandler::findById)
                .andRoute(RequestPredicates.POST("/api/chocolateros/customerSoccerField/filters"), customerSoccerFieldHandler::findByFilters)
                .andRoute(RequestPredicates.POST("/api/chocolateros/reserve/{id}"), reserveHandler::save)
                .andRoute(RequestPredicates.GET("/api/chocolateros/reserve"), reserveHandler::findAllReserves)
                .andRoute(RequestPredicates.GET("/api/chocolateros/reserve/{id}"), reserveHandler::findReservesByUserId)
                .andRoute(RequestPredicates.POST("/api/chocolateros/team"), teamHandler::save)
                .andRoute(RequestPredicates.GET("/api/chocolateros/team"), teamHandler::findAll)
                .andRoute(RequestPredicates.GET("/api/chocolateros/team/{nameTeam}"), teamHandler::findByName);
    }
}
