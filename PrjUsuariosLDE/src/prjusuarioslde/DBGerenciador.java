/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prjusuarioslde;

import java.util.HashMap;
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
       //adicionando o usuario na lista, caso esteja vazia.  
       if(primeiro == null){
           primeiro = ultimo = produto;
       //se estiver com um cadastro inserido, adiciona após o primeiro.
       }else{
           ultimo.setProximo(produto);
           ultimo = produto;
       }
    }
    
    public Map<Character,DBGerenciador> separarPorSexo(){
        Map<Character, DBGerenciador> mapaSexo = new HashMap<>();
       Usuario atual = primeiro;
       
       while(atual != null){
           char sexo = atual.getSexo();
           //vai verificar se existe algum parametro para o sexo escolhido como atual
           if(!mapaSexo.containsKey(sexo)){
               mapaSexo.put(sexo, new DBGerenciador());
           }
           //adicionando o usuario correspondente ao sexo 
           mapaSexo.get(sexo).inserir_na_lista(atual);
           // move o atual para o proximo da lista
           atual = atual.getProximo();
       }
        return mapaSexo;
    }

    public void removerPosicao(int pos) {
        //verifica se a posicao é valida 
        if(pos <= 0 || pos > length()){
            System.out.println("Posição invalida!");
            return;
        }
        //caso for a opcao 1, remove ela 
        if(pos ==1){
            primeiro = primeiro.getProximo();
            if(primeiro == null){
                //atualiza o ultimo caso for vazia
                ultimo = null;
            }
            //caso nao for a posicao 1, ela le a lista ate a posicao anterior que será excluida
        }else{
            Usuario anterior = null;
            Usuario atual = primeiro;
            int i = 1;
            
            while(i < pos){
                anterior = atual;
                atual = atual.getProximo();
                i++;
            }
            anterior.setProximo(atual.getProximo());
            if(atual == ultimo){
                ultimo = anterior;
            }
        }
        System.out.println("Usuario removido da posicao "+pos+ ".");
    }
    
    public Usuario buscarPosicao(int pos) {
        //verifica se a posicao é valida
        if(pos <= 0 || pos > length()){
            System.out.println("Posição invalida!");
            return null;
        }
        
        Usuario atual = primeiro;
        int i = 1;
        
        while(i < pos ){
            atual = atual.getProximo();
            i++;
        }
        return atual;
    }

    public Usuario[] listar() {
        int tamanho = length();
        
        if(tamanho == 0){
            System.out.println("A lista está vazia");
            return null;
        }
        Usuario[] usuario = new Usuario[tamanho];
        Usuario atual = primeiro;
        int i =0;
        
        while(atual != null){
            usuario[i] = atual;
            atual = atual.getProximo();
            i++;
        }
      return usuario;
    }
    
    public int length(){
        int i =0;
        Usuario atual = primeiro;
        
        while(atual != null){
            i++;
            atual = atual.getProximo();
            
        }
        
        return i;
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
