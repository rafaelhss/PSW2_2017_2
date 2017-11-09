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
import org.springframework.web.bind.annotation.RequestParam;
/**
 *
 * @author rafael.soares
 */
@RestController
public class PasseioController {
    
    @CrossOrigin(origins = "*")
    @RequestMapping("/passeio")
    
    public List<Passeio> listarPasseios(
            @RequestParam(value="local", defaultValue = "") String localizacao,
            @RequestParam(value="nome", defaultValue = "") String nome,
            @RequestParam(value="data-inicio", defaultValue = "") String dataInicio,
            @RequestParam(value="data-fim", defaultValue = "") String dataFim
    ){
        
        if(localizacao !=null && !localizacao.equals("")){
            return new PasseioDAO().listarPorLocal(localizacao);    
        }
        
        
        return new PasseioDAO().listarTodos();
    }
    
}
