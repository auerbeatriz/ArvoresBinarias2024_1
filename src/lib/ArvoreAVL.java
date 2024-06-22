package lib;

import java.util.Comparator;

public class ArvoreAVL<T> extends ArvoreBinaria<T> {

    public ArvoreAVL(Comparator<T> comparator) {
        super(comparator);
    }

    //Implementar métodos para efetuar o balanceamento e sobrescrever método de adicionar elemento...

    /**
     * Primeiro adicina o elemento na árvore, e depois analisa se precisa balancear
     * */
    @Override
    protected No<T> adicionar(No<T> raiz, T novoValor) {
        raiz = super.adicionar(raiz, novoValor);
        raiz= balancearArvore(raiz);

        return raiz;
    }

    /**
     * Primeiro remove o elemento na árvore, e depois analisa se precisa balancear
     * */
    protected No<T> excluir(No<T> raiz, T valor){
        raiz = super.removerRecursivo(raiz, valor);
        raiz = balancearArvore(raiz);
        return raiz;
    }
    /**
     * 1. Fator de balanceamento > 1:
     *      subárvore direita é maior que a subárvore esquerda (A \ B \ C) ou (A \ B / C)
     *      é preciso fazer uma rotação a esquerda
     *
     *      1.1 Fator de balanceamento > 0:
     *          subárvore esquerda é maior que a subárvore direita (A \ B / C)
     *          é preciso fazer uma dupla rotação para transformar no caso 1
     *
     * 2. Fator de balanceamento < -1:
     *      subárvore esquerda é maior que a subárvore direita (A / B / C) ou (A / B \ C)
     *      é preciso fazer uma rotação a direita
     *
     *      2.1 Fator de balanceamento < 0:
     *          subárvore direita é maior que a subárvore esquerda (A / B \ C)
     *          é preciso fazer uma dupla rotação para transformar no caso 2
     * */
    private No<T> balancearArvore(No<T> raiz){
        if(raiz.fatorBalanceamento() > 1) {
            if(raiz.getFilhoDireita().fatorBalanceamento() > 0)
                raiz = this.rotacaoEsquerda(raiz);
            else
                raiz = this.rotacaoDireitaEsquerda(raiz);
        }
        else if(raiz.fatorBalanceamento() < -1) {
            if(raiz.getFilhoEsquerda().fatorBalanceamento() < 0)
                raiz = this.rotacaoDireita(raiz);
            else
                raiz = this.rotacaoEsquerdaDireita(raiz);
        }
        return raiz;
    }


    /**
     * raiz da subárvore direita vira raiz
     * a antiga raiz vira filho esquerdo da nova raiz
     * */
    private No<T> rotacaoEsquerda(No<T> raizDesbalanceada) {
        No<T> novaRaiz = raizDesbalanceada.getFilhoDireita();
        raizDesbalanceada.setFilhoDireita(novaRaiz.getFilhoEsquerda());
        novaRaiz.setFilhoEsquerda(raizDesbalanceada);

        this.setAltura(raizDesbalanceada);
        this.setAltura(novaRaiz);

        return novaRaiz;
    }

    /**
     *  raiz da subárvore esquerda vira raiz
     *  a antiga raiz vira filho direito da nova raiz
     * */
    private No<T> rotacaoDireita(No<T> raizDesbalanceada) {
        No<T> novaRaiz = raizDesbalanceada.getFilhoEsquerda();
        raizDesbalanceada.setFilhoEsquerda(novaRaiz.getFilhoDireita());
        novaRaiz.setFilhoDireita(raizDesbalanceada);

        this.setAltura(raizDesbalanceada);
        this.setAltura(novaRaiz);

        return novaRaiz;
    }

    /**
     * Primeiro faz rotação à esquerda com a subárvore
     * Depois rotação à direita com a raiz principal (que vai ser transformada em filho)
     * */
    private No<T> rotacaoEsquerdaDireita(No<T> raizDesbalanceada) {
        No<T> novaRaiz = raizDesbalanceada.getFilhoEsquerda();
        raizDesbalanceada.setFilhoEsquerda(this.rotacaoEsquerda(novaRaiz));
        return this.rotacaoDireita(raizDesbalanceada);
    }

    /**
     * Primeiro faz rotação à direita com a subárvore
     * Depois rotação à esquerda com a raiz principal (que vai ser transformada em filho)
     * */
    private No<T> rotacaoDireitaEsquerda(No<T> raizDesbalanceada) {
        No<T> novaRaiz = raizDesbalanceada.getFilhoDireita();
        raizDesbalanceada.setFilhoDireita(this.rotacaoDireita(novaRaiz));
        return this.rotacaoEsquerda(raizDesbalanceada);
    }
}
