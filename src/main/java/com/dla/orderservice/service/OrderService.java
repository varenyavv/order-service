package com.dla.orderservice.service;

import com.dla.orderservice.model.SnackDto;
import com.dla.orderservice.remote.snack.SnackClient;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

  @Autowired SnackClient snackClient;

  public List<SnackDto> getMenuItems() {
    return snackClient.getAllSnacks();
  }

  public SnackDto getSnack(int id) {
    return snackClient.getSnack(id);
  }
}
