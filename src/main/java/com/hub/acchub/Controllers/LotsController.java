package com.hub.acchub.Controllers;

import com.hub.acchub.Models.LotsModel;
import com.hub.acchub.Models.OrdersModel;
import com.hub.acchub.Service.OrderService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/lots/{id}")
public class LotsController {

    private final OrderService orderService;

    public LotsController(OrderService orderService){
        this.orderService = orderService;
    }

    @GetMapping
    public String GetLots(@PathVariable("id") LotsModel lots, Model model){
        model.addAttribute("lots", lots);
        model.addAttribute("order", orderService.OrderByIdLot(lots.getId()));
        return "lots";
    }

    @GetMapping("/trade")
    public String GetTrade(@PathVariable("id") LotsModel lot, Model model){
        model.addAttribute("lot", lot);
        return "trade";
    }

    @PostMapping("/trade")
    public String AddOrder(@PathVariable("id") long id, OrdersModel order){
        orderService.AddOrder(id, order);
        return "redirect:/";
    }
}
