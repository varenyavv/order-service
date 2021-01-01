package com.dla.orderservice.controller;

import com.dla.orderservice.model.SnackDto;
import com.dla.orderservice.service.OrderService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

    @Autowired
    OrderService orderService;

    @GetMapping(path = "order/menu")
    public List<SnackDto> getMenuItems(){
        return orderService.getMenuItems();
    }

    @GetMapping(path = "order/snack")
    public SnackDto getSnack(@RequestParam("snackId") int snackId){
        return orderService.getSnack(snackId);
    }

}
