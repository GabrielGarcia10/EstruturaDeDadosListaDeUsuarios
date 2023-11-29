/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prjusuarioslde;

import java.util.Map;

/**
 *
 * @author humbertop
 */
public class DBGerenciador {

    Usuario primeiro;
    Usuario ultimo;

    public DBGerenciador() {
        primeiro = ultimo = null;
    }

    public Usuario createItem(String nome, int idade, char sexo){
        return null;
    }
    
    public void  inserir_na_lista(Usuario produto) {
      
    }
    
    public Map<Character,DBGerenciador> separarPorSexo(){
        return null;
    }

    public void removerPosicao(int pos) {
        
    }
    
    public Usuario buscarPosicao(int pos) {
        return null;
    }

    public Usuario[] listar() {
      return null;
    }
    
    public int length(){
        return 0;
    }
    
    public void ordenarporNome() {
        
    }

    public void ordenarporIdade() {
        
    }
    
    private String linha(Usuario usuario) {
        return usuario.getNome()+ "     " + usuario.getIdade()+ "     " + usuario.getSexo();
    }

    public boolean existeID(int id) {
        
        return ((id <= this.length()) ? true : false);
    }

}
