package com.hub.acchub.Service;

import com.hub.acchub.Models.OrdersModel;
import com.hub.acchub.Repository.LotsRepository;
import com.hub.acchub.Repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository){
        this.orderRepository = orderRepository;
    }

    public List<OrdersModel> OrderByIdLot(long id){
        return orderRepository.findByIdLot(id);
    }

    public List<OrdersModel> OrderAllById(long id){
        return orderRepository.findAllById(id);
    }

    public Optional<OrdersModel> OrderById(long id){
        return orderRepository.findById(id);
    }

    public boolean AddOrder(long id, OrdersModel order){
        OrdersModel NewOrder = new OrdersModel();
        NewOrder.setIdLot(id);
        NewOrder.setName(order.getName());
        NewOrder.setDescription(order.getDescription());
        NewOrder.setPrice(order.getPrice());
        orderRepository.save(NewOrder);
        return true;
    }
}
