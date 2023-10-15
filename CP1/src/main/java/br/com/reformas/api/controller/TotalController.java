package br.com.reformas.api.controller;

import br.com.reformas.api.produto.TotalRequest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Total")
public class TotalController {

    @PostMapping
    public double calculateTotal(@RequestBody TotalRequest request) {
        double subtotal = request.getSubtotal();
        double descontos = request.getDescontos();
        double impostos = request.getImpostos();
        double total = subtotal + impostos - descontos;
        return total;
    }
}

