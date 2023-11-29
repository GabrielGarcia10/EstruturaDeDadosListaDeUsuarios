/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prjusuarioslde;

/**
 *
 * @author humbertop
 */
public class Usuario {

   private String nome;
   private int idade;
   private char sexo;

   private Usuario anterior;
   private Usuario proximo;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return this.idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public Usuario getAnterior() {
        return this.anterior;
    }

    public void setAnterior(Usuario anterior) {
        this.anterior = anterior;
    }
    
    public Usuario getProximo() {
        return proximo;
    }

    public void setProximo(Usuario proximo) {
        this.proximo = proximo;
    }

    @Override
    public String toString() {
        return nome+" --- "+idade+" --- "+sexo;
    }
    
    

}
