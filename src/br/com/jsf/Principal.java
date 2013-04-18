/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jsf;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author admin
 */

@SessionScoped
@ManagedBean
public class Principal {

	private String nome;
        private String nomeUp;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNomeUp() {
        return nomeUp;
    }

    public void setNomeUp(String nomeUp) {
        this.nomeUp = nomeUp;
    }
        
   
        
      public String mostraNome(){
         nomeUp =  nome.toUpperCase();
          return "mostraNome";
      }
      
      public String home(){
        // nomeUp =  nome.toUpperCase();
          return "home";
      }
      public String iniciar(){
         //nomeUp =  nome.toUpperCase();
          return "iniciar";
      }
      public String buscar(){
        // nomeUp =  nome.toUpperCase();
          return "buscar";
      }
      
      public String contato(){
          return "contato";
      }
      
      public String moby(){
         //nomeUp =  nome.toUpperCase();
          return "ajuda";
      }
      
      public String tree(){
         //nomeUp =  nome.toUpperCase();
          return "tree";
      }
      
      public String upload(){
         //nomeUp =  nome.toUpperCase();
          return "upload";
      }

}
                    

