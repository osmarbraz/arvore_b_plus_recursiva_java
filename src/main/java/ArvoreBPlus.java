
import java.util.LinkedList;
import java.util.Queue;

/**
 * Árvore B+.
 *
 * Uma Árvore B+ é uma estrutura de dados avançada que estende a Árvore B
 * adicionando uma lista vinculada de nós folha. Essa estrutura é amplamente
 * usada em bancos de dados e sistemas de arquivos para permitir operações
 * eficientes de inserção, exclusão e pesquisa.
 *
 */
public class ArvoreBPlus {

    /**
     * Nó de início da árvore.
     */
    private No raiz;

    /**
     * Ordem da árvore;
     */
    private int t;

    /**
     * Construtor sem parâmetro.
     *
     */
    public ArvoreBPlus() {
        this(3);
        //3 espaços para as chaves
        //4 espaços para os filhos
    }

    /**
     * Construtor com parâmetro.
     *
     * @param t Grau mínimo (define o intervalo para o número de chaves).
     */
    public ArvoreBPlus(int t) {
        this.t = t;

        //Define árvore como vazia
        this.raiz = null;
    }

    /**
     * Recuperador de início.
     *
     * @return O nó do início da árvore.
     */
    public No getRaiz() {
        return raiz;
    }

    /**
     * Modificador de raiz.
     *
     * @param raiz Um nó a ser atribuído ao início da árvore.
     */
    public void setRaiz(No raiz) {
        this.raiz = raiz;
    }

    /**
     * Recuperador de t.
     *
     * @return O grau da árvore
     */
    public int getT() {
        return t;
    }

    /**
     * Modificador de t.
     *
     * @param t O grau da árvore.
     */
    public void setT(int t) {
        this.t = t;
    }

    /**
     * Caminhamento em pré-ordem na sub-árvore.
     *
     * @param _raiz Início da sub-árvore.
     */
    private void listarPreOrdem(No _raiz) {
        //Se _raiz não for nulo
        if (_raiz != null) {
            int i;
            //Percorre todas as chaves do nó _raiz
            for (i = 0; i < _raiz.getN(); i++) {
                //Se for folha
                if (_raiz.getFolha() == true) {
                    //Visita a chave i do nó _raiz
                    System.out.print(_raiz.getChave(i) + " ");
                }
                //Se não for folha
                if (_raiz.getFolha() == false) {
                    //Percorre o filho i do nó _raiz
                    listarPreOrdem(_raiz.getC(i));
                }
            }
            if (_raiz.getFolha() == false) {
                //Percorre o último filho do nó _raiz
                listarPreOrdem(_raiz.getC(i));
            }
        }
    }

    /**
     * Caminhamento em pré-ordem na árvore.
     *
     */
    public void listarPreOrdem() {
        this.listarPreOrdem(this.getRaiz());
    }

    /**
     * Caminhamento em central(in)-ordem na sub-árvore.
     *
     * @param _raiz Início da sub-árvore.
     */
    public void listarCentralOrdem(No _raiz) {
        //Se _raiz não for nulo
        if (_raiz != null) {
            int i;
            //Percorre todas as chaves do nó _raiz
            for (i = 0; i < _raiz.getN(); i++) {
                if (_raiz.getFolha() == false) {
                    //Percorre o filho i do nó _raiz
                    listarCentralOrdem(_raiz.getC(i));
                } else {
                    //Visita a chave i do nó _raiz
                    System.out.print(_raiz.getChave(i) + " ");
                }
            }
            if (_raiz.getFolha() == false) {
                // Percorre o último filho
                listarCentralOrdem(_raiz.getC(_raiz.getN()));
            }
        }
    }

    /**
     * Caminhamento em central(in)-ordem na árvore.
     *
     */
    public void listarCentralOrdem() {
        this.listarCentralOrdem(this.getRaiz());
    }

    /**
     * Caminhamento em pós-ordem na sub-árvore.
     *
     * @param _raiz Início da sub-árvore.
     */
    private void listarPosOrdem(No _raiz) {
        //Se _raiz não for nulo
        if (_raiz != null) {
            int i;
            //Percorre todas as chaves do nó _raiz
            for (i = 0; i < _raiz.getN(); i++) {
                if (_raiz.getFolha() == false) {
                    //Percorre o filho i do nó _raiz
                    listarPosOrdem(_raiz.getC(i));
                } else {
                    //Visita a chave i do nó _raiz
                    System.out.print(_raiz.getChave(i) + " ");
                }
            }
            if (_raiz.getFolha() == false) {
                // Percorre o último filho do nó _raiz
                listarPosOrdem(_raiz.getC(i));
            }
        }
    }

    /**
     * Caminhamento em pós-ordem na árvore.
     *
     */
    public void listarPosOrdem() {
        this.listarPosOrdem(this.getRaiz());
    }

    /**
     * Caminhamento em nível na sub-árvore.
     *
     * @param _raiz Início da sub-árvore.
     */
    private void listarEmNilvel(No _raiz) {
        //Se _raiz não for nulo
        if (_raiz != null) {
            Queue<No> queue = new LinkedList<>();
            queue.add(_raiz);
            while (!queue.isEmpty()) {
                No atual = queue.poll();
                //Percorre todas as chaves do nó _raiz
                for (int i = 0; i < atual.getN(); i++) {
                    if (atual.getFolha() == true) {
                        //Visita a chave i do nó _raiz
                        System.out.print(atual.getChave(i) + " ");
                    }
                }
                if (atual.getFolha() == false) {
                    for (int i = 0; i < atual.getN() + 1; i++) {
                        queue.add(atual.getC(i));
                    }
                }
                System.out.println(); // Nova linha para cada nível
            }
        }
    }

    /**
     * Caminhamento em nível na árvore.
     *
     */
    public void listarEmNilvel() {
        this.listarEmNilvel(this.getRaiz());
    }

    /**
     * Caminhamento em nível com detalhes na sub-árvore.
     *
     * @param _raiz Início da sub-árvore.
     */
    private void listarEmNilvelDetalhes(No _raiz) {
        if (_raiz != null) {
            //Lista para armanzenar os nós do nível
            Queue<No> queue = new LinkedList<>();
            //Começa pela raiz
            queue.add(_raiz);
            System.out.println("OID Raiz:" + this.getRaiz());
            int nivel = 0;

            while (!queue.isEmpty()) {
                Queue<No> proximoNivel = new LinkedList<>();

                System.out.println("Nível:" + nivel);

                while (!queue.isEmpty()) {
                    //Retira o primeiro nó da fila
                    No atual = queue.poll();

                    //Exib os ddos do nó atual                
                    System.out.println("[" + atual.getDadosVetoresStr() + "]");

                    //Adiciona os filhos do nó atual a lista para exibir o próximo nível                
                    for (int i = 0; i < atual.getN() + 1; i++) {
                        if (atual.getC(i) != null) {
                            proximoNivel.add(atual.getC(i));
                        }
                    }
                }
                nivel = nivel + 1;
                queue = proximoNivel;
            }
        }
    }

    /**
     * Caminhamento em nível com detalhes na árvore.
     *
     */
    public void listarEmNilvelDetalhes() {
        this.listarEmNilvelDetalhes(this.getRaiz());
    }

    /**
     * Atualiza um dado na árvore.
     *
     * @param antigo Dado a ser removido.
     * @param novo Novo dado a ser inserido.
     * @return
     */
    public boolean atualizar(int antigo, int novo) {
        if (remover(antigo)) {
            inserir(novo);
            return true;
        }
        return false;
    }

    /**
     * Dividir(split) um nó em 2 nós descendentes.
     *
     * Função para dividir um nó x da posição i em dois nós decendentes. Observe
     * que x deve estar completo quando a função for chamada.
     *
     * Baseado no método B-TREE-SPLIT-CHILD(x,i) Thomas H. Cormen Página 494.
     *
     * @param x Raiz da sub-árvore.
     * @param i Indíce da posição a ser dividida.
     */
    private void dividirNo(No pai, int i) {
        No y = pai.getC(i);
        No z = new No(t, y.getFolha());

        int meio = t;

        for (int j = 0; j < t; j++) {
            z.setChave(j, y.getChave(j + meio));
        }

        // limpar restante do vetor z
        for (int j = t; j < 2 * t; j++) {
            z.setChave(j, 0);
        }

        if (!z.getFolha()) {
            for (int j = t + 1; j < 2 * t + 1; j++) {
                z.setC(j, null);
            }
        }

        if (!y.getFolha()) {
            for (int j = 0; j <= t; j++) {
                z.setC(j, y.getC(j + meio));
            }
        }

        z.setN(t);
        y.setN(t);

        // Limpar chaves antigas de y
        for (int j = t; j < 2 * t; j++) {
            y.setChave(j, 0);
        }

        // Limpar filhos antigos de y
        if (!y.getFolha()) {
            for (int j = t + 1; j < 2 * t + 1; j++) {
                y.setC(j, null);
            }
        }

        for (int j = pai.getN(); j >= i + 1; j--) {
            pai.setC(j + 1, pai.getC(j));
        }
        pai.setC(pai.getN() + 1, null);
        pai.setC(i + 1, z);

        for (int j = pai.getN() - 1; j >= i; j--) {
            pai.setChave(j + 1, pai.getChave(j));
        }
        pai.setChave(pai.getN(), 0);

        pai.setChave(i, z.getChave(0));
        pai.setN(pai.getN() + 1);

        if (y.getFolha()) {
            z.setProximo(y.getProximo());
            y.setProximo(z);
        }
    }

    /**
     * Inserir quanto não estiver cheio.
     *
     * Baseado no método B-TREE-INSERT-NONFULL(x,k) Thomas H. Cormen Página 496
     *
     * @param _raiz Raiz da sub-árvore
     * @param k Chave a ser inserida.
     */
    private void inserirNaoCheio(No no, int k) {
        int i = no.getN() - 1;

        if (no.getFolha()) {
            while (i >= 0 && k < no.getChave(i)) {
                no.setChave(i + 1, no.getChave(i));
                i--;
            }
            no.setChave(i + 1, k);

            // limpar posição seguinte (se existir lixo)
            if (no.getN() + 1 < 2 * t) {
                no.setChave(no.getN() + 1, 0);
            }
            no.setN(no.getN() + 1);

        } else {
            while (i >= 0 && k < no.getChave(i)) {
                i--;
            }
            i++;

            if (no.getC(i).getN() == 2 * t) {
                dividirNo(no, i);
                if (k > no.getChave(i)) {
                    i++;
                }
            }

            inserirNaoCheio(no.getC(i), k);
        }
    }

    /**
     * Inserção em sub-árvore B+.
     *
     * Com divisão(split) e fusão(merge) preventiva para grau máximo.
     *
     * Insere os resultados de uma divisão de nó na árvore. A função pega uma
     * tupla contendo a chave que será inserida no nó _raiz(pai) e ponteiros
     * para os nós descendentes(filhos) esquerdo e direito. Primeiro, ele
     * verifica se o nó _raiz(pai) é nulo, nesse caso ele cria um novo nó raiz e
     * atualiza os seus atributos. Caso contrário, se o nó não estiver cheio (n
     * &lt; 2 * t -1) ele chamada a função inserirNaoCheio recursivamente até
     * encontrar a posição da chave a realizar a inserção. Se o nó estiver cheio
     * cheio (n = 2 * t -1) ele chamada a função dividirNo para dividir para a
     * nova raiz na posição 0 em dois nós para poder inserir o novo nó e chama a
     * função inserirNaoCheio.
     *
     * Inserir recursivo em sub-árvore B. Baseado no método B-TREE-INSERT(T,k)
     * Thomas H. Cormen Página 495 Em Cormen r = _raiz
     *
     * @param k Chave a ser inserida.
     */
    public void inserir(int k) {
        if (raiz == null) {
            raiz = new No(t, true);
            raiz.setChave(0, k);
            raiz.setN(1);
            return;
        }

        if (raiz.getN() == 2 * t) {
            No nova = new No(t, false);
            nova.setC(0, raiz);

            dividirNo(nova, 0);

            int i = (k > nova.getChave(0)) ? 1 : 0;
            inserirNaoCheio(nova.getC(i), k);

            raiz = nova;
        } else {
            inserirNaoCheio(raiz, k);
        }
    }

    /**
     * Procura nó na árvore.Procura uma chave k na sub-arvore do nó atual.
     *
     * Baseado no métodoB-TREE-SEARCH(x,k) Thomas H. Cormen Página 492
     *
     * @param _raiz Raiz da sub-ãrvore.
     * @param k Chave a ser procurada.
     * @return Retorna o nó que possui o valor k.
     */
    private No procurar(No no, int k) {
        if (no == null) {
            return null;
        }

        int i = 0;

        while (i < no.getN() && k > no.getChave(i)) {
            i++;
        }

        if (no.getFolha()) {
            if (i < no.getN() && k == no.getChave(i)) {
                return no;
            }
            return null;
        }

        return procurar(no.getC(i), k);
    }

    /**
     * Método auxiliar para procurar uma chave na árvore.
     *
     * Não precisa especificar a raiz.
     *
     * @param k Chave a ser procurada na árvore.
     * @return O nó encontrado ou null.
     */
    public No procurar(int k) {
        return this.procurar(this.getRaiz(), k);
    }

    /**
     * Excluir árvore recursivamente apartir de _raiz.
     *
     * @param _raiz Início da árvore a ser excluida.
     * @return Retorna nul para o nó apgado.
     */
    private No apagar(No _raiz) {
        if (_raiz != null) {
            if (!_raiz.getFolha()) {
                for (int i = 0; i <= _raiz.getN(); ++i) {
                    apagar(_raiz.getC(i));
                }
            }
        }
        return null;
    }

    /**
     * Apaga a árvore apartir da raiz.
     */
    public void apagar() {
        this.setRaiz(apagar(this.getRaiz()));
    }

    /**
     * Encontra a chave com o valor mínimo na árvore.
     *
     * @param _raiz Início da árvore.
     * @return A chave miníma da árvore.
     */
    private int getValorMinimo(No _raiz) {
        if (_raiz == null) {
            return -1;
        } else {
            if (_raiz.getFolha()) {
                //retona a chave com o valor mínimo de x
                return _raiz.getChave(0);
            } else {
                //Procura no próximo filho
                return getValorMinimo(_raiz.getC(0));
            }
        }
    }

    /**
     * Encontra a chave com o valor mínimo da raiz.
     *
     * @return A chave mínima da árvore.
     */
    public int getValorMinimo() {
        return getValorMinimo(this.getRaiz());
    }

    /**
     * Encontra a chave com o valor máximo na árvore.
     *
     * @param _raiz Início da árvore.
     * @return A chave máxima da árvore.
     */
    private int getValorMaximo(No _raiz) {
        if (_raiz == null) {
            return -1;
        } else {
            if (_raiz.getFolha()) {
                //retona a chave com o valor mínimo de x
                return _raiz.getChave(_raiz.getN() - 1);
            } else {
                //Procura no próximo filho
                return getValorMaximo(_raiz.getC(_raiz.getN()));
            }
        }
    }

    /**
     * Encontra a chave com o valor máximo na árvore.
     *
     * @return A chave máxima da árvore.
     */
    public int getValorMaximo() {
        return this.getValorMaximo(this.getRaiz());
    }

    /**
     * Conta os nós de uma sub-árvore.
     *
     * @param _raiz
     * @return A quantidade de nós da sub-árvore.
     */
    private int contarNo(No _raiz) {
        int cont = 0;
        if (_raiz != null) {
            for (int i = 0; i < _raiz.getN(); i++) {
                cont = cont + contarNo(_raiz.getC(i));
                cont = cont + 1;
            }
            cont = cont + contarNo(_raiz.getC(_raiz.getN()));
        }
        return cont;
    }

    /**
     * Conta os nós da árvore.
     *
     * @return A quantidade de nós da árvore.
     */
    public int contarNo() {
        return this.contarNo(this.getRaiz());
    }

    /**
     * Retorna uma String com os valores dos nós folhas de uma árvore binária.
     *
     * @param _raiz Uma raiz de uma subárvore.
     * @return Uma String com os valores dos nós folhas da árvore binária.
     */
    private String encontrarFolhas(No _raiz) {
        String str = "";
        if (_raiz != null) {
            for (int i = 0; i < _raiz.getN(); i++) {
                str = str + encontrarFolhas(_raiz.getC(i));
                if (_raiz.getFolha()) {
                    str = str + " " + _raiz.getChave(i) + " - ";
                }
            }
            str = str + encontrarFolhas(_raiz.getC(_raiz.getN()));
        }
        return str;
    }

    /**
     * Retorna uma String com os valores dos nós folhas da raiz árvore binária.
     *
     * @return Uma String com os valores dos nós folhas da árvore binária.
     */
    public String encontrarFolhas() {
        return encontrarFolhas(this.getRaiz());
    }

    /**
     * Encontra a getAltura de uma sub-árvore.
     *
     * @param _raiz Raiz de uma sub-árvore.
     * @return A getAltura da sub-árvore.
     */
    private int getAltura(No _raiz) {
        if (_raiz == null) {
            return 0;
        } else {
            if (_raiz.getFolha()) {
                return 1;
            }

            return 1 + getAltura(_raiz.getC(0));
        }
    }

    /**
     * Encontra a getAltura da árvore.
     *
     * @return A getAltura da árvore.
     */
    public int getAltura() {
        return this.getAltura(this.getRaiz());
    }

    /**
     * Remove uma chave da sub-árvore.
     *
     * Utiliza uma rotina recursiva.
     *
     * @param _raiz Raiz da sub-árvore.
     * @param k Chave a ser removida.
     */
    public boolean remover(int k) {
        if (raiz == null) {
            return false;
        }

        boolean ok = remover(raiz, k);

        if (!raiz.getFolha() && raiz.getN() == 0) {
            raiz = raiz.getC(0);
        }

        return ok;
    }

    private boolean remover(No no, int k) {
        int i = 0;
        while (i < no.getN() && k > no.getChave(i)) {
            i++;
        }
        // Caso folha
        if (no.getFolha()) {
            if (i < no.getN() && no.getChave(i) == k) {
                // Shift para esquerda
                for (int j = i + 1; j < no.getN(); j++) {
                    no.setChave(j - 1, no.getChave(j));
                }
                // Zera a última posição
                no.setChave(no.getN() - 1, 0);

                // Atualiza quantidade
                no.setN(no.getN() - 1);

                return true;
            }
            return false;
        }

        return remover(no.getC(i), k);
    }
}
