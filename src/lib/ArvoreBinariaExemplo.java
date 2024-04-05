/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lib;

import java.util.ArrayList;
import java.util.Comparator;

/**
 *
 * @author victoriocarvalho
 */
public class ArvoreBinariaExemplo<T> implements IArvoreBinaria<T> {
    
    protected NoExemplo<T> raiz = null;
    protected Comparator<T> comparador; 
  
    public ArvoreBinariaExemplo(Comparator<T> comp) {
        comparador = comp;
    }
    
    @Override
    public void adicionar(T novoValor) {
        this.raiz = this.adicionar(this.raiz, novoValor);
    }

    private NoExemplo<T> adicionar(NoExemplo<T> raiz, T novoValor) {
        // Raiz da árvore está nula: ponto de inserção (pode ser da árvore original, ou de uma subárvore)
        if(raiz == null) {
            raiz = new NoExemplo<T>(novoValor);
        }
        else {
            // novoValor menor que o valor da raíz: o novo nó deverá ser inserido na subárvore à direita
            if(this.comparador.compare(raiz.getValor(), novoValor) < 0)
                raiz.setFilhoDireita(this.adicionar(raiz.getFilhoDireita(), novoValor));

                // novoValor maior que o valor da raíz: o novo nó deverá ser inserido na subárvore à esquerda
            else
                raiz.setFilhoEsquerda(this.adicionar(raiz.getFilhoEsquerda(), novoValor));
        }

        // Retorna a árvore completa
        return raiz;
    }

    @Override
    public T pesquisar(T valor) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   @Override
    public T pesquisar(T valor, Comparator comparador) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public T remover(T valor) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int altura() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
       
    
    @Override
    public int quantidadeNos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String caminharEmNivel() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.    
    }
    
    @Override
    public String caminharEmOrdem() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.    
    }
        
}
