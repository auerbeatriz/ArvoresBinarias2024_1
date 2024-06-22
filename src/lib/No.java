/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lib;

/**
 *
 * @author victoriocarvalho
 */
public class No<T> {
    
    private T valor;
    private No<T> filhoDireita;
    private No<T> filhoEsquerda;
    private int altura;

    public No(T valor){
        this.valor = valor;
        this.filhoDireita = null;
        this.filhoEsquerda = null;
        this.altura = 0;
    }
    
    /**
     * @return the valor
     */
    public T getValor() {
        return valor;
    }

    /**
     * @param valor the valor to set
     */
    public void setValor(T valor) {
        this.valor = valor;
    }

    /**
     * @return the filhoDireita
     */
    public No<T> getFilhoDireita() {
        return filhoDireita;
    }

    /**
     * @param filhoDireita the filhoDireita to set
     */
    public void setFilhoDireita(No<T> filhoDireita) {
        this.filhoDireita = filhoDireita;
    }

    /**
     * @return the filhoEsquerda
     */
    public No<T> getFilhoEsquerda() {
        return filhoEsquerda;
    }

    /**
     * @param filhoEsquerda the filhoEsquerda to set
     */
    public void setFilhoEsquerda(No<T> filhoEsquerda) {
        this.filhoEsquerda = filhoEsquerda;
    }

    public int getAltura() {
        return this.getAltura(this);
    }

    /**
     * Calcula a altura do nó com base na altura da subárvore mais profunda
     * Primeiro pesquisa a altura da subárvore esquerda
     * Depois a altura da subárvore direita
     * Por fim, manda a altura mais alta
     * */
    private int getAltura(No<T> raiz) {
        if(raiz == null)
            return -1;
        else {
            int alturaDireita = this.getAltura(raiz.filhoDireita);
            int alturaEsquerda = this.getAltura(raiz.filhoEsquerda);

            return Math.max(alturaDireita, alturaEsquerda) + 1;
        }
    }

    /**
     * De acordo com a teoria, o FB = Hd - He
     * */
    public int fatorBalanceamento() {
        return this.getAltura(this.filhoDireita) - this.getAltura(this.filhoEsquerda);
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }
    
}
