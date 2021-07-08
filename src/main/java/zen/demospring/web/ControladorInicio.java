package zen.demospring.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PostMapping;
import zen.demospring.domain.Usuario;
import zen.demospring.servicio.UsuarioService;

import javax.validation.Valid;


@Controller
@Slf4j
public class ControladorInicio {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/")
    public String inicio(Model model) {

        var usuarios = usuarioService.listarUsuario();
        model.addAttribute("usuarios", usuarios);
        return "index";
    }

    @GetMapping("/agregar")
    public String agregar (Usuario usuario) {
        return "modificar";
    }

    @PostMapping("/guardar")
    public String guardar (@Valid Usuario usuario, Errors errors) {
        if (errors.hasErrors()) {
            return "modificar";
        }
        usuarioService.guardar(usuario);
        return "redirect:/";
    }

    @GetMapping("/editar/{rut}")
    public String editar (Usuario usuario, Model model) {
        usuario = usuarioService.encontrarUsuario(usuario);
        model.addAttribute("usuario", usuario);
        return "modificar";
    }

    @GetMapping("/eliminar")
    public String eliminar (Usuario usuario) {
        usuarioService.eliminar(usuario);
        return "redirect:/";
    }
}
