package com.sample;

import com.sample.model.Employee;
import io.micronaut.core.type.Argument;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.client.HttpClient;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.runtime.EmbeddedApplication;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static io.micronaut.http.HttpHeaders.USER_AGENT;


@MicronautTest
class MultiTenancyAppTest {

    @Inject
    EmbeddedApplication<?> application;

    @Test
    void testItWorks() {
        Assertions.assertTrue(application.isRunning());
    }

    @Inject
    @Client("/")
    HttpClient client;

    @Test
    void requestFromDefaultDS() {

        HttpResponse<Employee> rsp = client.toBlocking().exchange(HttpRequest.GET("hello/1")
                        .header(USER_AGENT, "Micronaut HTTP Client")
                        .header("co", "default"),
                Argument.of(Employee.class));
        Assertions.assertTrue(rsp.code() == 200);
    }

    @Test
    void requestFromSecondaryDS() {

        HttpResponse<Employee> rsp = client.toBlocking().exchange(HttpRequest.GET("hello/1")
                        .header(USER_AGENT, "Micronaut HTTP Client")
                        .header("co", "secondary"),
                Argument.of(Employee.class));
        Assertions.assertTrue(rsp.code() == 200);
    }

}
