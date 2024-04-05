/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lib;

import java.util.Comparator;

/**
 *
 * @author victoriocarvalho
 */
public class ArvoreBinaria<T> implements IArvoreBinaria<T> {
    
    protected No<T> raiz = null;
    protected Comparator<T> comparador; 
  
    public ArvoreBinaria(Comparator<T> comp) {
        comparador = comp;
    }
    
    @Override
    public void adicionar(T novoValor) {
        this.raiz = this.adicionar(this.raiz, novoValor);
    }

    /**
     * Esse método é recursivo porque achamos mais legível e limpo, apesar de consumir mais memória
     * Procura o ponto de inserção ao dividir a árvore em subárvores
     * O primeiro nó raiz nulo que encontrar deve ser o ponto de inserção, pois significa que chegou ao fim da arvore analisada
     * Senão, busca recursivamente o ponto de inserção analisando a subarvore correspondente, seja o valor
     * de inserção menor ou maior que o valor do nó raíz analisado
     * */
    private No<T> adicionar(No<T> raiz, T novoValor) {
        if(raiz == null) {
            raiz = new No<T>(novoValor);
        }
        else {
            if(this.comparador.compare(novoValor, raiz.getValor()) < 0)
                raiz.setFilhoEsquerda(this.adicionar(raiz.getFilhoEsquerda(), novoValor));
            else
                raiz.setFilhoDireita(this.adicionar(raiz.getFilhoDireita(), novoValor));
        }

        return raiz;
    }

    /**
     * Esse método de pesquisa iterativo se beneficia da inserção indexada da árvore para fazer a busca
     * Esse método é iterativo porque achamos mais legível e limpo, além de economizar memória
     * Em cada iteração, é obtido o nó raiz da subarvore analisada e compara o seu valor com o procurado
     * Se a raiz estiver nula, siginifica que o resultado não foi encontrado
     * Se não, então deve buscar na subárvore correspondente, seja o valor maior ou menor que a raiz da subarvore analisada
     * */
    @Override
    public T pesquisar(T valor) {
        No<T> noAtual = this.raiz;
        while(noAtual != null) {
            int resultadoComparacao  = this.comparador.compare(valor, noAtual.getValor());

            if(resultadoComparacao  == 0)
                return noAtual.getValor();
            else if(resultadoComparacao  < 0)
                noAtual = noAtual.getFilhoEsquerda();
            else
                noAtual = noAtual.getFilhoDireita();
        }

        return null;
    }

   @Override
    public T pesquisar(T valor, Comparator comparador) {
        return this.pesquisar(valor, comparador, this.raiz);
    }

    /**
     * Esse método é recursivo porque achamos mais legível e limpo, apesar de consumir mais memória
     * Pesquisa recursivamente em todos os nós da árvore para encontrar o valor procurado
     * Se a raiz for nula, significa que chegou ao fim da subárvore e o valor não foi encontrado
     * Senão, avalia se é igual a raiz
     * Se não for, busca recursivamente na subarvore à esquerda
     * Se não encontrar na esquerda, então busca recursivamente na subarvore à direita
     * Ele retorna o valor procurado, se for encontrado em alguma subarvore, ou null
     *
     * Tedx with the dev: o primeiro pensamento foi analisar as subarvores em paralelo, mas isso consumiria
     * mais processamento do que o necessário, caso o nó já tivesse sido encontrado em alguma subarvore e estivesse
     * analisando outra ao mesmo tempo
     * */
    private T pesquisar(T valor, Comparator comparador, No<T> raiz) {
        if(raiz == null)
            return null;

        int resultadoComparacao  = comparador.compare(valor, raiz.getValor());

        if(resultadoComparacao == 0)
            return raiz.getValor();

        T valorEncontrado = this.pesquisar(valor, comparador, raiz.getFilhoEsquerda());
        if(valorEncontrado != null) {
            valorEncontrado = this.pesquisar(valor, comparador, raiz.getFilhoDireita());
        }

        return valorEncontrado;
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
        return contarNosRecursivo(raiz);//To change body of generated methods, choose Tools | Templates.
    }
    private int contarNosRecursivo(No<T> no) {
        if (no == null)
            return 0;

        int contLeft = contarNosRecursivo(no.getFilhoEsquerda());
        int contRight = contarNosRecursivo(no.getFilhoDireita());

        return 1 + contLeft + contRight;
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
