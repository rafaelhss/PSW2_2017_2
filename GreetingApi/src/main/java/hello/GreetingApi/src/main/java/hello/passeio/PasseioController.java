/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hello.passeio;


import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.ArrayList;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
/**
 *
 * @author rafael.soares
 */
@RestController
public class PasseioController {
    
    @CrossOrigin(origins = "*")
    @RequestMapping("/passeio")
    public List<Passeio> listarPasseios(){
        List<Passeio> resultado = new ArrayList<>();
        
        Passeio p1 = new Passeio();
        p1.setNome("passeio 1");
        p1.setLocal("Tagua parque");
        p1.setData("Amanha");
        resultado.add(p1);
        
        
        Passeio p2 = new Passeio();
        p2.setNome("passeio de sabado");
        p2.setLocal("Cailandia sul");
        p2.setData("Sabado");
        resultado.add(p2);
        
        
        Passeio p3 = new Passeio();
        p3.setNome("passeio domingo");
        p3.setLocal("agua mineral");
        p3.setData("Domingo");
        resultado.add(p3);
        
        
        return resultado;
        
        
    }
    
}
