package application.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import application.model.UserModel;
import application.repository.userRepo;

@Controller
@RequestMapping(value = {"/home"})
public class userController{
    @Autowired
    private userRepo usuarioRepo;

    @RequestMapping(value = {"/home"})
    public String select(Model ui){
        ui.addAttribute("usuarios", usuarioRepo.findAll());
        return "home";
    }

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public String insert(
        @RequestParam("nome") String nome,
        @RequestParam("idade") int idade,
        @RequestParam(value = "estuda", defaultValue = "false") boolean estuda){
            UserModel usuario = new UserModel();
            usuario.setNome(nome);
            usuario.setIdade(idade);
            usuario.setEstuda(estuda);

            usuarioRepo.save(usuario);
            return "redirect:/home/home";
    }

    // @RequestMapping(value = "/delete")
    // public String delete(@RequestParam("id") long id, Model ui){
    //     Optional<UserModel> resultado = usuarioRepo.findById(id);
    //     if (resultado.isPresent()){
    //         ui.addAttribute("usuario", resultado.get());
    //         return "redirect:/home/home";
    //     }
    //     return "redirect:/home/home";
        // }

    @RequestMapping("/updateForm")
    public String update(@RequestParam("id") long id, Model ui){
        Optional<UserModel> resultado = usuarioRepo.findById(id);

        if (resultado.isPresent()){
            ui.addAttribute("usuario", resultado.get());
            return "userUpdate";   
        }
        return "redirect:/home/home";
    }
    
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String update(
        @RequestParam("id") long id, 
        @RequestParam("nome") String nome,
        @RequestParam("idade") int idade
        ){
        Optional<UserModel> resultado = usuarioRepo.findById(id);
        if (resultado.isPresent()){
            resultado.get().setNome(nome);
            resultado.get().setIdade(idade);
            usuarioRepo.save(resultado.get());
           
        }
        return "redirect:/home/home";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public String delete(@RequestParam("id") long id) {
        usuarioRepo.deleteById(id);
        
        return "redirect:/home/home";

    }
    

}
