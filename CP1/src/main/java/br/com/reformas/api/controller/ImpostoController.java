package br.com.reformas.api.controller;
import br.com.reformas.api.produto.SubtotalRequest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Imposto")
public class ImpostoController {

    @PostMapping
    public double calculateImposto(@RequestBody SubtotalRequest request) {
        double subtotal = request.getSubtotal();
        double taxaDeImposto = 0.0535;
        double impostos = subtotal * taxaDeImposto;
        return impostos;
    }
}
