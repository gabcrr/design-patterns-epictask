package br.com.joaocarloslima.epictask.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.joaocarloslima.epictask.model.Desafio;
import br.com.joaocarloslima.epictask.model.Recompensa;
import br.com.joaocarloslima.epictask.model.TipoDesafio;
import br.com.joaocarloslima.epictask.service.DesafioService;

@Controller
public class DesafioControlle {

    @Autowired
    private DesafioService service;

    @GetMapping("/")
    public String listar(Model model) {
        var desafios = service.todos();
        model.addAttribute("desafios", desafios);
        return "index";
    }

    @PostMapping("/concluir")
    public String concluir(@RequestParam Long id, Model model) {
        Recompensa recompensa = service.concluirDesafio(id);
        model.addAttribute("recompensa", recompensa);
        return "resultado";
    }

    @GetMapping("/novo")
    public String novoDesafioForm(Model model) {
        model.addAttribute("desafio", new Desafio());
        model.addAttribute("tipos", TipoDesafio.values());
        return "formulario";
    }

    @PostMapping("/novo")
    public String salvarDesafio(@ModelAttribute Desafio desafio) {
        service.adicionarDesafio(desafio);
        return "redirect:/";
    }

    @ModelAttribute("resumo")
    public String resumoUsuario() {
        int total = service.getInventario().stream()
                .mapToInt(Recompensa::getValor)
                .sum();
        return "Total de recompensas: " + total;
    }

    @GetMapping("/inventario")
    public String inventario(Model model) {
        model.addAttribute("recompensas", service.getInventario());
        return "inventario";
    }

}
