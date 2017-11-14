/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hello.passeio;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Rafael.Soares
 */
public class PasseioDAO {
    
    public List<Passeio> listarPorLocal(String local){
        List<Passeio> resultado = new ArrayList<>();
        
        List<Passeio> todos = listarTodos();

        for(Passeio p : todos){
            if(p.getLocal().equals(local)){
                resultado.add(p);
            }
        }    
        
        return resultado;
    }
    
    
    public List<Passeio> listarTodos(){
         List<Passeio> resultado = new ArrayList<>();
        
        Passeio p1 = new Passeio();
        p1.setNome("passeio 1");
        p1.setLocal("Tagua parque");
        p1.setData("Amanha");
        resultado.add(p1);
        
        Passeio p3 = new Passeio();
        p3.setNome("passeio 1.2");
        p3.setLocal("Tagua parque");
        p3.setData("Amanha");
        resultado.add(p3);
        
        
        Passeio p2 = new Passeio();
        p2.setNome("passeio de sabado");
        p2.setLocal("Cailandia sul");
        p2.setData("Sabado");
        resultado.add(p2);
        
        
        Passeio p4 = new Passeio();
        p4.setNome("passeio domingo");
        p4.setLocal("agua mineral");
        p4.setData("Domingo");
        resultado.add(p4);
        
        return resultado;
    }
}
