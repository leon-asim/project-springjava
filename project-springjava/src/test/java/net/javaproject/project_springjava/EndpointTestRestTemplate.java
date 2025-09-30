package net.javaproject.project_springjava;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import static org.assertj.core.api.Assertions.*;
import org.junit.Assert.*;
import org.springframework.web.client.RestTemplate;


public class EndpointTestRestTemplate {

    @Test
    public void test() {
        RestTemplate restTemplate = new RestTemplate();

        String url = "http://localhost:8080";
        ResponseEntity<String> response = restTemplate.getForEntity(url + "/vehicles/1", String.class);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
    }

    @Mock
    private TestRestTemplate restTemplate;

    @Test
    void test2() {
        ResponseEntity<String> response = restTemplate.getForEntity("/vehicles/1", String.class);
        assertThat(response.getStatusCode().is2xxSuccessful()).isTrue();
    }
}
