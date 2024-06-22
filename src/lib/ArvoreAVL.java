package lib;

import java.util.Comparator;

public class ArvoreAVL<T> extends ArvoreBinaria<T> {

    public ArvoreAVL(Comparator<T> comparator) {
        super(comparator);
    }

    //Implementar métodos para efetuar o balanceamento e sobrescrever método de adicionar elemento...

    private No<T> rotacaoEsquerda(No<T> raizDesbalanceada) {
        No<T> novaRaiz = raizDesbalanceada.getFilhoDireita();
        raizDesbalanceada.setFilhoDireita(novaRaiz.getFilhoEsquerda());
        novaRaiz.setFilhoEsquerda(raizDesbalanceada);

        this.setAltura(raizDesbalanceada);
        this.setAltura(novaRaiz);

        return novaRaiz;
    }

    private No<T> rotacaoDireita(No<T> raizDesbalanceada) {
        No<T> novaRaiz = raizDesbalanceada.getFilhoEsquerda();
        raizDesbalanceada.setFilhoEsquerda(novaRaiz.getFilhoDireita());
        novaRaiz.setFilhoDireita(raizDesbalanceada);

        this.setAltura(raizDesbalanceada);
        this.setAltura(novaRaiz);

        return novaRaiz;
    }

    private No<T> rotacaoEsquerdaDireita(No<T> raizDesbalanceada) {
        No<T> novaRaiz = raizDesbalanceada.getFilhoEsquerda();
        raizDesbalanceada.setFilhoEsquerda(this.rotacaoEsquerda(novaRaiz));
        return this.rotacaoDireita(raizDesbalanceada);
    }

    private No<T> rotacaoDireitaEsquerda(No<T> raizDesbalanceada) {
        No<T> novaRaiz = raizDesbalanceada.getFilhoDireita();
        raizDesbalanceada.setFilhoDireita(this.rotacaoDireita(novaRaiz));
        return this.rotacaoEsquerda(raizDesbalanceada);
    }
}
