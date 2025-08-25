/**
 * Implementação de uma Árvore Binária de Busca.
 * Foco em operações recursivas para inserção, busca e remoção.
 * 
 * @author 
 * Equipe da Disciplina
 * @version 2025.08.14
 */ 
public class ArvoreBinaria implements Arvore {

    private NodoArvore raiz;

    /**
     * Construtor da árvore. Inicia uma árvore vazia.
     */
    public ArvoreBinaria() {
        this.raiz = null;
    }

    // --- MÉTODO DE INSERÇÃO ---
    @Override
    public void inserir(int valor) {
        this.raiz = inserirRecursivo(this.raiz, valor);
    }

    private NodoArvore inserirRecursivo(NodoArvore noAtual, int valor) {
        if (noAtual == null) {
            return new NodoArvore(valor);
        }
        if (valor < noAtual.chave) {
            noAtual.filhoEsquerdo = inserirRecursivo(noAtual.filhoEsquerdo, valor);
        } else if (valor > noAtual.chave) {
            noAtual.filhoDireito = inserirRecursivo(noAtual.filhoDireito, valor);
        }
        return noAtual;
    }
    
    // --- MÉTODO DE PESQUISA ---
    @Override
    public NodoArvore pesquisa(int valor) {
        return pesquisaRecursivo(this.raiz, valor);
    }

    private NodoArvore pesquisaRecursivo(NodoArvore noAtual, int valor) {
        if (noAtual == null || noAtual.chave == valor) {
            return noAtual;
        }
        if (valor < noAtual.chave) {
            return pesquisaRecursivo(noAtual.filhoEsquerdo, valor);
        } else {
            return pesquisaRecursivo(noAtual.filhoDireito, valor);
        }
    }

    // --- MÉTODO DE REMOÇÃO ---
    @Override
    public void remover(int valor) {
        this.raiz = removerRecursivo(this.raiz, valor);
    }

    private NodoArvore removerRecursivo(NodoArvore noAtual, int valor) {
        if (noAtual == null) {
            return null;
        }

        if (valor < noAtual.chave) {
            noAtual.filhoEsquerdo = removerRecursivo(noAtual.filhoEsquerdo, valor);
        } else if (valor > noAtual.chave) {
            noAtual.filhoDireito = removerRecursivo(noAtual.filhoDireito, valor);
        } else {
            // Caso 1: nó sem filhos
            if (noAtual.filhoEsquerdo == null && noAtual.filhoDireito == null) {
                return null;
            }
            // Caso 2: nó com apenas um filho
            else if (noAtual.filhoEsquerdo == null) {
                return noAtual.filhoDireito;
            } else if (noAtual.filhoDireito == null) {
                return noAtual.filhoEsquerdo;
            }
            // Caso 3: nó com dois filhos
            else {
                int menorValor = encontrarMenorValor(noAtual.filhoDireito);
                noAtual.chave = menorValor;
                noAtual.filhoDireito = removerRecursivo(noAtual.filhoDireito, menorValor);
            }
        }
        return noAtual;
    }

    private int encontrarMenorValor(NodoArvore no) {
        int menor = no.chave;
        while (no.filhoEsquerdo != null) {
            menor = no.filhoEsquerdo.chave;
            no = no.filhoEsquerdo;
        }
        return menor;
    }

    // --- MÉTODOS DE IMPRESSÃO ---
    @Override
    public void imprimePreFixado() {
        imprimePreFixadoRecursivo(this.raiz);
        System.out.println();
    }

    private void imprimePreFixadoRecursivo(NodoArvore no) {
        if (no != null) {
            System.out.print(no.chave + " ");
            imprimePreFixadoRecursivo(no.filhoEsquerdo);
            imprimePreFixadoRecursivo(no.filhoDireito);
        }
    }

    @Override
    public void imprimeEmOrdem() {
        imprimeEmOrdemRecursivo(this.raiz);
        System.out.println();
    }

    private void imprimeEmOrdemRecursivo(NodoArvore no) {
        if (no != null) {
            imprimeEmOrdemRecursivo(no.filhoEsquerdo);
            System.out.print(no.chave + " ");
            imprimeEmOrdemRecursivo(no.filhoDireito);
        }
    }

    @Override
    public void imprimePosFixado() {
        imprimePosFixadoRecursivo(this.raiz);
        System.out.println();
    }

    private void imprimePosFixadoRecursivo(NodoArvore no) {
        if (no != null) {
            imprimePosFixadoRecursivo(no.filhoEsquerdo);
            imprimePosFixadoRecursivo(no.filhoDireito);
            System.out.print(no.chave + " ");
        }
    }
}