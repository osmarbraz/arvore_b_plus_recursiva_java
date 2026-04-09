
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
        //Remove o nó antigo
        if (remover(antigo)) {
            //Insere o novo nó
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

        // y é o nó filho que será dividido (filho do pai na posição i)
        No y = pai.getC(i);

        // z será o novo nó criado após a divisão
        // Ele terá o mesmo tipo de nó (folha ou interno) que y
        No z = new No(t, y.getFolha());

        // =========================
        // CASO 1: NÓ FOLHA (B+ REAL)
        // =========================
        if (y.getFolha()) {

            // Calcula o ponto de divisão (meio do nó)
            // Em B+, usamos a quantidade real de chaves (n), não apenas t
            int meio = (y.getN() + 1) / 2; // divisão correta B+

            // copia metade direita para z
            // Índice auxiliar para preencher o novo nó z
            int j = 0;
            // Copia a metade direita das chaves de y para z
            for (int k = meio; k < y.getN(); k++) {
                // Copia chave para o novo nó (lado direito)
                z.setChave(j, y.getChave(k));
                // Limpa a posição antiga no nó y (boa prática)
                y.setChave(k, 0); // limpa
                j++;
            }

            // Define quantas chaves ficaram no novo nó
            z.setN(j);

            // limpa posições não utilizadas do novo nó
            for (int k = z.getN(); k < 2 * t - 1; k++) {
                z.setChave(k, 0);
            }

            // Atualiza quantidade de chaves do nó original (lado esquerdo)
            y.setN(meio);

            // limpa posições restantes no nó esquerdo
            for (int k = y.getN(); k < 2 * t - 1; k++) {
                y.setChave(k, 0);
            }

            // Encadeamento de folhas (ESSENCIAL em B+)
            // O novo nó aponta para o próximo de y
            z.setProximo(y.getProximo());
            // y passa a apontar para z
            y.setProximo(z);

            // Ajuste dos filhos no nó pai
            // shift filhos no pai
            // Desloca os filhos do pai para abrir espaço para z
            for (int k = pai.getN(); k >= i + 1; k--) {
                pai.setC(k + 1, pai.getC(k));
            }

            // Insere z como novo filho do pai
            pai.setC(i + 1, z);

            // Ajuste das chaves no pai
            // shift chaves no pai
            // Desloca as chaves do pai para abrir espaço
            for (int k = pai.getN() - 1; k >= i; k--) {
                pai.setChave(k + 1, pai.getChave(k));
            }

            // Em B+, NÃO removemos a chave do nó folha
            // Promovemos uma CÓPIA da menor chave do novo nó direito
            pai.setChave(i, z.getChave(0));

            // Atualiza número de chaves do pai
            pai.setN(pai.getN() + 1);

        } // =========================
        // CASO 2: NÓ INTERNO
        // =========================
        else {

            // Chave do meio que será promovida ao pai
            // Diferente da folha, aqui ela é REMOVIDA do nó original
            int chaveMeio = y.getChave(t - 1);

            // Copia as chaves da metade direita para o novo nó z                        
            for (int j = 0; j < t - 1; j++) {
                // Copia chave
                z.setChave(j, y.getChave(j + t));
                // Limpa posição antiga
                y.setChave(j + t, 0); // limpa
            }

            // Copia os filhos correspondentes para z
            for (int j = 0; j < t; j++) {
                // Move ponteiro do filho
                z.setC(j, y.getC(j + t));
                // Remove referência antiga
                y.setC(j + t, null); // limpa
            }

            // Ajusta quantidades de chaves
            z.setN(t - 1);
            y.setN(t - 1);

            // limpa resto do vetor de chaves
            for (int j = y.getN(); j < 2 * t - 1; j++) {
                y.setChave(j, 0);
            }

            // Ajuste dos filhos no pai
            // shift filhos no pai
            // Abre espaço para o novo filho
            for (int j = pai.getN(); j >= i + 1; j--) {
                pai.setC(j + 1, pai.getC(j));
            }

            // Insere o novo nó z como filho do pai
            pai.setC(i + 1, z);

            // Ajuste das chaves no pai
            // shift chaves no pai
            // Abre espaço para a chave promovida
            for (int j = pai.getN() - 1; j >= i; j--) {
                pai.setChave(j + 1, pai.getChave(j));
            }

            // Em nó interno (igual B-tree), a chave do meio SOBE e sai do filho
            pai.setChave(i, chaveMeio);

            // Atualiza número de chaves do pai
            pai.setN(pai.getN() + 1);
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
        // Começa do último índice válido de chaves no nó
        int i = no.getN() - 1;

        // CASO 1: NÓ É FOLHA
        if (no.getFolha()) {
            // Desloca as chaves maiores que k uma posição para a direita
            // para abrir espaço para a nova chave
            while (i >= 0 && k < no.getChave(i)) {
                no.setChave(i + 1, no.getChave(i));
                i--;
            }

            // Insere a nova chave na posição correta (ordenada)
            no.setChave(i + 1, k);

            // Atualiza o número de chaves do nó
            no.setN(no.getN() + 1);

            // Limpa a próxima posição para evitar "lixo" no vetor
            // (boa prática quando se usa arrays fixos)
            if (no.getN() + 1 < 2 * t - 1) {
                no.setChave(no.getN(), 0);
            }

            // CASO 2: NÓ INTERNO
        } else {
            // Encontra o filho que deve receber a nova chave
            // (procura a posição correta descendo na árvore)
            while (i >= 0 && k < no.getChave(i)) {
                i--;
            }
            // Ajusta para o índice do filho correto
            i++;

            // Verifica se o filho está cheio
            if (no.getC(i).getN() == 2 * t - 1) {
                // Divide o filho antes de descer
                // (garante que nunca desceremos em nó cheio)
                dividirNo(no, i);
                // Após a divisão, decide para qual dos dois nós descer
                // Se k for maior que a chave promovida, vai para o novo nó (direita)
                if (k > no.getChave(i)) {
                    i++;
                }
            }
            // Chamada recursiva para continuar a inserção no filho correto
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

        // CASO 1: ÁRVORE VAZIA
        if (raiz == null) {
            // Cria a raiz como um nó folha
            raiz = new No(t, true);
            // Insere a primeira chave diretamente
            raiz.setChave(0, k);
            // Atualiza a quantidade de chaves
            raiz.setN(1);

            // CASO 2: RAIZ CHEIA            
        } else {
            if (raiz.getN() == 2 * t - 1) {
                // Cria um novo nó que será a nova raiz (não é folha)
                No nova = new No(t, false);
                // A antiga raiz passa a ser filha da nova raiz
                nova.setC(0, raiz);

                // Divide a antiga raiz
                // Isso cria dois filhos e promove uma chave para a nova raiz
                dividirNo(nova, 0);

                // Decide em qual dos dois filhos inserir a nova chave
                // Se for maior que a chave promovida → vai para o filho da direita
                int i = 0;
                if (k > nova.getChave(0)) {
                    i++;
                }

                // Insere recursivamente no filho correto (garantido não cheio)
                inserirNaoCheio(nova.getC(i), k);

                // Atualiza a referência da raiz da árvore
                raiz = nova;

                // CASO 3: RAIZ NÃO CHEIA
            } else {
                inserirNaoCheio(raiz, k);
            }
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
        // CASO BASE: NÓ NULO
        if (no == null) {
            // Se o nó for nulo, a chave não existe na árvore
            return null;
        }

        // Índice usado para percorrer as chaves do nó
        int i = 0;

        // Avança enquanto k for maior que as chaves do nó
        // Isso encontra a posição onde k deveria estar
        while (i < no.getN() && k > no.getChave(i)) {
            i++;
        }

        // CASO 1: NÓ É FOLHA
        if (no.getFolha()) {
            // Verifica se a chave foi encontrada na posição i
            if (i < no.getN() && k == no.getChave(i)) {
                // Retorna o nó onde a chave está localizada
                return no;
            }
            // Se não encontrou, a chave não existe na árvore
            return null;
        }

        // CASO 2: NÓ INTERNO
        // Continua a busca recursivamente no filho correto
        // O índice i indica qual filho seguir
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
