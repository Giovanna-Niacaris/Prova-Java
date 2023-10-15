
package br.com.reformas.api.controller;
import br.com.reformas.api.produto.Produto;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/Subtotal")
public class SubtotalController {

    @PostMapping
    public double calculateSubtotal(@RequestBody List<Produto> produtos) {
        double subtotal = 0.0;

        for (Produto produto : produtos) {
            double preco = produto.getPreco();
            int quantidade = produto.getEstoque();
            subtotal += preco * quantidade;
        }

        return subtotal;
    }
}
