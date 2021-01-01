package com.dla.orderservice.remote.snack;

import com.dla.orderservice.model.SnackDto;
import java.util.Collections;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Component
public class SnackClientImpl implements SnackClient {

  WebClient webClient;

  String baseUri;

  @Autowired
  public SnackClientImpl(
      @Value("${app.remote.snack.baseUri}") String baseUri, WebClient webClient) {
    this.baseUri = baseUri;
    this.webClient = webClient;
  }

  @Override
  public List<SnackDto> getAllSnacks() {

    ResponseEntity<List<SnackDto>> response =
        webClient
            .get()
            .uri(baseUri)
            .retrieve()
            .toEntity(new ParameterizedTypeReference<List<SnackDto>>() {})
            .block();

    if(HttpStatus.OK == response.getStatusCode()) {
        return response.getBody();
    } else {
        return Collections.emptyList();
    }
  }

  @Override
  public SnackDto getSnack(int id) {
    ResponseEntity<SnackDto> response =
            webClient
                    .get()
                    .uri(baseUri+"/"+id)
                    .retrieve()
                    .toEntity(SnackDto.class)
                    .block();
    return response.getBody();

  }
}
