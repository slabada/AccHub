package com.hub.acchub.Controllers;

import com.hub.acchub.Models.OrdersModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/offer")
public class OfferController {

    @GetMapping("{id}")
    public String getOffer(@PathVariable("id") OrdersModel order, Model model){
        model.addAttribute("offer", order);
        return "offer";
    }
}
