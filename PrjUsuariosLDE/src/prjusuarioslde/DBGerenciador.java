/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prjusuarioslde;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.logging.Level;
import java.util.logging.Logger;

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

    public Usuario createItem(Usuario user) {
        return this.createItem(user.getNome(), user.getIdade(), user.getSexo());
    }
    
    public Usuario createItem(String nome, String idade, String sexo) {
        return this.createItem(nome, Integer.parseInt(idade), sexo.charAt(0));
    }
    
    public Usuario createItem(String nome, int idade, char sexo) {
        Usuario noh = new Usuario();
        noh.setNome(nome);
        noh.setIdade(idade);
        noh.setSexo(sexo);
        return noh;
    }
    
    public void editItem(Usuario item, String nome, String idade, String sexo){
        this.editItem(item, nome, Integer.parseInt(idade), sexo.charAt(0));
    }
    
    public void editItem(Usuario item, String nome, int idade, char sexo){
        item.setNome(nome);
        item.setIdade(idade);
        item.setSexo(sexo);
    }

    public void inserir_na_lista(Usuario produto) {
        //adicionando o usuario na lista, caso esteja vazia.  
        if (primeiro == null) {
            primeiro = ultimo = produto;
            //se estiver com um cadastro inserido, adiciona após o primeiro.
        } else {
            produto.setAnterior(ultimo);
            ultimo.setProximo(produto);
            ultimo = produto;
        }
    }

    public Map<Character, DBGerenciador> separarPorSexo() {
        Map<Character, DBGerenciador> mapaSexo = new HashMap<>();
        Usuario atual = primeiro;

        while (atual != null) {
            char sexo = atual.getSexo();
            //vai verificar se existe algum parametro para o sexo escolhido como atual
            if (!mapaSexo.containsKey(sexo)) {
                mapaSexo.put(sexo, new DBGerenciador());
            }
            //adicionando o usuario correspondente ao sexo 
            mapaSexo.get(sexo).inserir_na_lista(createItem(atual));
            // move o atual para o proximo da lista
            atual = atual.getProximo();
        }
        return mapaSexo;
    }

    public void removerPosicao(int pos) {
        //verifica se a posicao é valida 
        if (pos <= 0 || pos > length()) {
            try {
                throw new Exception("Posição invalida!");
            } catch (Exception ex) {
                Logger.getLogger(DBGerenciador.class.getName()).log(Level.SEVERE, null, ex);
            }
            return;
        }
        
        //caso for a opcao 1, remove ela 
        if (pos == 1) {
            Usuario temp;
            temp = this.primeiro;
            this.primeiro = this.primeiro.getProximo();
            temp.setAnterior(null);
            temp.setProximo(null);
            temp = null;
            if (this.primeiro == null) {
                //atualiza o ultimo caso for vazia
                this.ultimo = null;
            }else{
                this.primeiro.setAnterior(null);
            }
            //caso nao for a posicao 1, ela le a lista ate a posicao anterior que será excluida
        } else {
            Usuario anterior;
            Usuario atual = this.primeiro;
            int i = 1;

            while (i < pos) {
                atual = atual.getProximo();
                i++;
            }
            
            anterior = atual.getAnterior();
            anterior.setProximo(atual.getProximo());
            atual.setAnterior(null);
            atual.setProximo(null);
            //Se for o ultimo
            if (atual == this.ultimo) {
                this.ultimo = anterior;
            }
        }
        System.gc();
        //System.out.println("Usuario removido da posicao " + pos + ".");
    }

    public Usuario buscarPosicao(int pos){
        //verifica se a posicao é valida
        int length = this.length();
        if (pos <= 0 || pos > length) {
            try {
                throw new Exception("Posição da lista é invalida!");
            } catch (Exception ex) {
                Logger.getLogger(DBGerenciador.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        Usuario atual;
        //Validação para busca mais eficiente
        if (pos == 1 || pos <= (length / 2)) {
            //Se posição se encontrar na primeira metade da lista
            atual = primeiro;
            int i = 1;

            while (i < pos) {
                atual = atual.getProximo();
                i++;
            }
        }else{
            //Se posição se encontrar na segunda metade da lista
            atual = ultimo;
            int i = length;

            while (i > pos) {
                atual = atual.getAnterior();
                i--;
            }
        }
        return atual;
    }

    public int getIndex(Usuario user){
        int i;
        Usuario noh;
        for(i = 0, noh = this.primeiro; noh != user || noh != null; i++, noh = noh.getProximo()){}
        if(noh == null){
            return -1;
        } 
        return i;
    }
    
    public Usuario[] listar() {
        int tamanho = length();

        if (tamanho == 0) {
            return new Usuario[0];
        }
        
        Usuario[] usuario = new Usuario[tamanho];
        Usuario atual = primeiro;
        int i = 0;

        while (atual != null) {
            usuario[i] = atual;
            atual = atual.getProximo();
            i++;
        }
        return usuario;
    }

    public int length() {
        int i = 0;
        Usuario atual = primeiro;

        while (atual != null) {
            i++;
            atual = atual.getProximo();
        }

        return i;
    }

    public void sort(Function<Usuario[],Integer> action){
        Objects.requireNonNull(action);
        
        if(this.length() < 2) return;
        
        Usuario temp;
        Usuario noh;
        Usuario NohAtual;
        int i;
        int s = 1;
        int length =  this.length();
        while(s == 1){
            s = 0;
            //Vez do primeiro
            if(action.apply(new Usuario[] {this.primeiro, this.primeiro.getProximo()}) >= 1){
                s = 1;
                temp = this.primeiro;
                this.primeiro = this.primeiro.getProximo();
                temp.setProximo(this.primeiro.getProximo());
                this.primeiro.setProximo(temp);
            }
            for(i = 0, noh = this.primeiro; i < length-2; i++, noh = noh.getProximo()){
                NohAtual = noh.getProximo();
                 if( action.apply(new Usuario[] {NohAtual, NohAtual.getProximo()}) >= 1){
                    s = 1;
                    temp = NohAtual.getProximo();
                    NohAtual.setProximo(temp.getProximo());
                    temp.setProximo(NohAtual);
                    noh.setProximo(temp);
                }
            }
        }
    }
    
    public void ordenarporNome() {
        this.sort(i -> i[0].getNome().compareTo(i[1].getNome()));
    }

    public void ordenarporIdade() {
        this.sort(i -> Integer.compare(i[0].getIdade(),i[1].getIdade()));
    }

    public void forEach(Consumer<Usuario> action) {
        Objects.requireNonNull(action);
        
        Usuario noh;
        for(noh = primeiro; noh != null; noh = noh.getProximo()){
            action.accept(noh);
        }
    }

    private String linha(Usuario usuario) {
        return usuario.getNome() + "     " + usuario.getIdade() + "     " + usuario.getSexo();
    }

    public boolean existeID(int id) {

        return ((id <= this.length()) ? true : false);
    }

}
