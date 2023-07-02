package com.hub.acchub.Repository;

import com.hub.acchub.Models.OrdersModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<OrdersModel, Long> {

    List<OrdersModel> findAllById(long id);

    List<OrdersModel> findByIdLot(long id);
}
