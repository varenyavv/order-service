package com.dla.orderservice.remote.snack;

import com.dla.orderservice.model.SnackDto;
import java.util.List;

public interface SnackClient {

    List<SnackDto> getAllSnacks();

    SnackDto getSnack(int id);
}
