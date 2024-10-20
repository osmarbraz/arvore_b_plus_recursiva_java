
import java.util.LinkedList;
import java.util.Queue;

/**
 * Árvore B+.
 * 
 * Uma Árvore B+ é uma estrutura de dados avançada que estende a Árvore B 
 * adicionando uma lista vinculada de nós folha. 
 * Essa estrutura é amplamente usada em bancos de dados e sistemas de 
 * arquivos para permitir operações eficientes de inserção, exclusão e pesquisa.

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

        //Cria a raiz da árvore.
        this.alocarRaiz();
    }

    /**
     * Aloca a raiz da árvore.
     */
    public void alocarRaiz() {
        //Instancia o nó raiz da árvore.
        this.raiz = new No(this.t, true);
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
    public void listarPreOrdem(No _raiz) {
        if (_raiz != null) {
            int i;
            for (i = 0; i < _raiz.getN(); i++) {
                System.out.print(_raiz.getChave(i) + " ");
                listarPreOrdem(_raiz.getC(i));
            }
            //Percorre o último filho            
            listarPreOrdem(_raiz.getC(i));
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
        if (_raiz != null) {
            int i;
            for (i = 0; i < _raiz.getN(); i++) {
                listarCentralOrdem(_raiz.getC(i));

                // Visita a chave i
                System.out.print(_raiz.getChave(i) + " ");
            }
            // Percorre o último filho
            listarCentralOrdem(_raiz.getC(_raiz.getN()));
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
    public void listarPosOrdem(No _raiz) {
        if (_raiz != null) {
            int i;
            for (i = 0; i < _raiz.getN(); i++) {
                //Percorre o filho à esquerda da chave i
                listarPosOrdem(_raiz.getC(i));
                // Visita a chave i
                System.out.print(_raiz.getChave(i) + " ");
            }
            // Percorre o último filho
            listarPosOrdem(_raiz.getC(i));
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
    public void listarEmNilvel(No _raiz) {
        Queue<No> queue = new LinkedList<>();
        queue.add(_raiz);
        while (!queue.isEmpty()) {          
            No atual = queue.poll();
            for (int i = 0; i < atual.getN(); i++) {;
                System.out.print(atual.getChave(i) + " ");
            }
            if (!atual.getFolha()) {
                for (int i = 0; i < atual.getN()+1; i++) {
                    queue.add(atual.getC(i));
                }
            }
            System.out.println(); // Nova linha para cada nível
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
    public void listarEmNilvelDetalhes(No _raiz) {
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

    /**
     * Caminhamento em nível com detalhes na árvore.
     *
     */
    public void listarEmNilvelDetalhes() {
        this.listarEmNilvelDetalhes(this.getRaiz());
    }
    
    /**
     * Dividir(split) um nó em 2 filhos.
     *
     * Função para dividir o filho r deste nó. Observe que r deve estar completo
     * quando esta função for chamada.
     *
     * @param parent Raiz da sub-árvore.
     * @param i Indíce da posição a ser dividida.
     */
    public void dividirFilho(No parent, int i, No child) {
        System.out.println("Dividir filho");
        //parent = x
        //child = y
        //newchild = z
        
        //Dividir parent em duas partes.
        //Recupera o primeiro filho da raiz.
        //y filho da esquerda da raiz(parent)
        //No child = parent.getC(i);        
        int t = child.getT();
        
        //Cria um novo nó filho que irá armazenar chaves (t-1) de child.
        //Este novo nó vai ficar a esquerda de child.
        No newChild = new No(t, child.getFolha());
        newChild.setN(t - 1);

        //Copia as últimas chaves (t-1) de child(esquerda) para newChild(direita)
        for (int j = 0; j < t - 1; j++) {
            newChild.setChave(j, child.getChave(j + t));
            //Zera a chave de child pois já foram copiados para newChild
            //child.setChave(j + t, 0);
        }
        //Se child não for folha
        if (child.getFolha() == false) {
            //Copia os últimos t filhos de child para newChild
            for (int j = 0; j < t ; j++) {
                newChild.setC(j, child.getC(j + t));
                //Zera os filhos de child pois já foram copiados para newChild
                child.setC(j + t, null);
            }
        }
        //Reduz a quantidade de elementos de child
        child.setN(t - 1);
        
        //Como este nó terá um novo filho, cria espaço para o novo filho        
        for (int j = parent.getN(); j > i ; j--) {
            parent.setC(j + 1, parent.getC(j));
        }
        //Conecta o novo filho a este nó
        parent.setC(i + 1, newChild);

        //Uma chave de child se moverá para este nó. 
        //Encontre a localização da nova chave e mova todas as 
        //chaves maiores um espaço à frente.
        //Empurra as chaves de parent para direta para dar lugar a newChild        
        for (int j = parent.getN()-1; j >= i; j--) {
            parent.setChave(j + 1, parent.getChave(j));
        }
        //Copie a chave do meio de child para este nó raiz
        parent.setChave(i, child.getChave(t - 1));
        //Zera a chave de child pois já foi copiado para a raiz
        //child.setChave(t - 1, 0);        
               
        //Incrementa a contagem de chaves neste nó
        parent.setN(parent.getN() + 1);
        
        //Se child não for folha
        if (child.getFolha() == true) {
            newChild.setProximo(child.getProximo());
            child.setProximo(newChild);
        }
    }

    /**
     * Inserir quanto não estiver cheio.
     *
     * Baseado no método B-TREE-INSERT-NONFULL(x,k) Thomas H. Cormen Página 496
     *
     * @param node Raiz da sub-árvore
     * @param k Chave a ser inserida.
     */
    public void inserirNaoCheio(No node, int k) {
        int i = node.getN()-1;
        if (node.getFolha()) {
            while ((i >= 0) && (k < node.getChave(i))) {
                node.setChave(i + 1, node.getChave(i));
                i = i - 1;
            }
            node.setChave(i + 1, k);
            node.setN(node.getN() + 1);            
        } else {
            //Se o nó não é folha

            // Encontra o filho que terá a nova chave
            while ((i >= 0) && (k < node.getChave(i))) {
                i = i - 1;
            }
            i = i + 1;

            // Veja se o filho encontrado está cheio
            if (node.getC(i).getN() == ((2 * node.getT()) - 1)) {
                this.dividirFilho(node, i, node.getC(i));
                if (k > node.getChave(i)) {
                    i = i + 1;
                }
            }
            inserirNaoCheio(node.getC(i), k);
        }
    }
    
    /**
     * Inserção em sub-árvore B.
     *
     * Inserir recursivo em sub-árvore B.
     * Baseado no método B-TREE-INSERT(T,k) Thomas H. Cormen Página 495 Em
     * Cormen r = _raiz
     *
     * @param _raiz Raiz da sub-árvore.
     * @param k Chave a ser inserida.
     */
    public void inserir(No _raiz, int k) {
        //Já atingiu a quantidade máxima de valores no Nó.        
        if (_raiz.getN() == (2 * this.t - 1)) {
            //Cria um novo nó
            //newRoot = s
            No newRoot = new No(this.t, false);
                        
            //Tornar a raiz anterior filho da nova raiz
            newRoot.setC(0, _raiz);
           
            //Dividir a raiz atual e mover 1a chave para a nova raiz
            this.dividirFilho(newRoot, 0, _raiz);

            //Insere na nova sub-árvore
            this.inserirNaoCheio(newRoot, k);
            
            //Modifica a raiz com o novo nó criado
            this.setRaiz(newRoot);
        } else {
            //Arvore não está cheia
            this.inserirNaoCheio(_raiz, k);
        }
    }
    
    /**
     * Inserção na raiz de árvore B.
     *
     * @param k Chave a ser inserida.
     */
    public void inserir(int k) {
        this.inserir(this.getRaiz(), k);
    }

    /**
     * Procura nó na árvore.
     *
     * Procura uma chave k na sub-arvore do nó atual.
     *
     * Baseado no métodoB-TREE-SEARCH(x,k) Thomas H. Cormen Página 492
     *
     * @param _raiz Raiz da sub-ãrvore.
     * @param k Chave a ser procurada.
     */
    public No procurar(No _raiz, int k) {

        if (_raiz != null) {

            int i = 0;
            //Encontra a primeira chave maior ou igual a k
            while ((i < _raiz.getN()) && (k > _raiz.getChave(i))) {
                i = i + 1;
            }
            //Se a chave encontrada for igual a k, retorne este nó
            if ((i < _raiz.getN()) && (k == _raiz.getChave(i))) {
                return _raiz;
            }
            // Se a chave não for encontrada aqui e este for um nó folha
            if (_raiz.getFolha() == true) {
                return null;
            } else {
                //Procura no ´róximo filho
                return procurar(_raiz.getC(i), k);
            }
        } else {
            return null;
        }
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
     */
    public No apagar(No _raiz) {
        if (_raiz != null) {
            if (!_raiz.getFolha()) {
                for (int i = 0; i <= _raiz.getN(); ++i) {
                    apagar(_raiz.getC(i));
                }
                return null;
            }
        }
        return null;
    }

    /**
     * Apaga a árvore apartir da raiz.
     */
    public void apagar() {
        this.setRaiz(apagar(this.getRaiz()));
        //Cria uma nova raiz
        this.alocarRaiz();
    }

    /**
     * Encontra a chave com o valor mínimo na árvore.
     *
     * @param _raiz Início da árvore.
     * @return A chave miníma da árvore.
     */
    public int getValorMinimo(No _raiz) {
        if (_raiz == null) {
            System.out.println("A árvore está vazia.");
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
    public int getValorMaximo(No _raiz) {
        if (_raiz == null) {
            System.out.println("A árvore está vazia.");
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
    public int contarNo(No _raiz) {
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
    public String encontrarFolhas(No _raiz) {
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
    public int getAltura(No _raiz) {
        if (_raiz == null) {
            return 0;
        } else {
            int esquerda = 0;
            for (int i = 0; i < _raiz.getN(); i++) {
                esquerda = esquerda + getAltura(_raiz.getC(i));
            }
            int direita = getAltura(_raiz.getC(_raiz.getN()));
            if (esquerda > direita) {
                return 1 + esquerda;
            } else {
                return 1 + direita;
            }
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
     * Retorna a chave do antecessor de _raiz.
     *
     * @param _raiz Início da árvore.
     * @return O valor da chave.
     */
    public int getChaveAntecessor(No _raiz) {
        while (!_raiz.getFolha()) {
            _raiz = _raiz.getC(_raiz.getN() + 1);
        }
        return _raiz.getChave(_raiz.getN());
    }

    /**
     * Retorna a chave do sucessor de _raiz.
     *
     * @param _raiz Início da árvore.
     * @return O valor da chave.
     */
    public int getChaveSucessor(No _raiz) {
        while (!_raiz.getFolha()) {
            _raiz = _raiz.getC(0);
        }
        return _raiz.getChave(0);
    }

    /**
     * Merge de dois nós.
     *
     * @param _raiz Início da árvore. 
     * @param idx Indice do nó na raiz.
     */
    public void mergeFilhos(No _raiz, int idx) {
        //Recupera o nó do filho
        No filho = _raiz.getC(idx);
        //Recupera o nó do irmão;
        No irmao = _raiz.getC(idx + 1);
        
        System.out.println("Realiza merge de filho: " + filho.getChave(idx));
        System.out.println("Realiza merge de irmao:" + irmao.getChave(idx));
        
        filho.setChave(t / 2 - 1, _raiz.getChave(idx));

        for (int i = 0; i < irmao.getN(); i++) {            
            filho.setChave(i + t / 2, irmao.getChave(i));
        }

        if (!filho.getFolha()) {
            for (int i = 0; i <= irmao.getN(); i++) {
                filho.setC(i + t / 2, irmao.getC(i));
            }
        }

        for (int i = idx + 1; i < _raiz.getN(); i++) {
            _raiz.setChave(i - 1, _raiz.getChave(i));
        }

        for (int i = idx + 2; i <= _raiz.getN(); i++) {
            _raiz.setC(i - 1, _raiz.getC(i));
        }

        //Incrementa o nó filho
        filho.setN(filho.getN() + 1);
        //Decrementa o nó irmao
        _raiz.setN(_raiz.getN() - 1);
        
        irmao = null;        
    }
    
    /**
     * Remove uma chave de um nó folha.
     *
     * @param _raiz Raiz da sub-árvore.
     * @param idx Indice do nó na raiz.
     * @return Verdadeiro ou falso se conseguiu realizar a exclusão.
     */
    public boolean removerFolha(No _raiz, int idx) {
        
        for (int i = idx + 1; i < _raiz.getN(); i++) {
            _raiz.setChave(i - 1, _raiz.getChave(i));
        }

        //Remove k do _raiz
        _raiz.setN(_raiz.getN() - 1);

        return true;
    }

    /**
     * Remove uma chave de um nó não folha.
     *
     * @param _raiz Raiz da sub-árvore.
     * @param idx Indice do nó na raiz.
     */
    public void removerNaoFolha(No _raiz, int idx) {
        // Recupera a chave da _raiz
        int k = _raiz.getChave(idx);
        
        System.out.println("Removendo não folha com valor " + k);

        //O nó antecessor contém chaves igual a t
        if (_raiz.getC(idx).getN() >= t / 2) {
            //Obtem a chave do antecessor
            int kpred = this.getChaveAntecessor(_raiz);
            //Substitui a chave na raiz
            _raiz.setChave(idx, kpred);
            this.remover(_raiz.getC(idx), kpred);
        } else {
            // O nó sucessor contém chaves igual a t
            if (_raiz.getC(idx + 1).getN() >= t / 2) {
                //Obtem a chave do sucessor
                int ksuc = this.getChaveSucessor(_raiz);
                //Substitui a chave na raiz
                _raiz.setChave(idx, ksuc);
                this.remover(_raiz.getC(idx + 1), ksuc);
            } else {
                //Ambos os nós noAnt e noProx contêm apenas chave em quantidades menores que o máximo
                mergeFilhos(_raiz, idx);
                this.remover(_raiz.getC(idx), k);
            }
        }
    }

    /**
     * Pegar emprestado do irmão anterior
     *
     * @param _raiz Raiz da sub-árvore.
     * @param idx Indice do nó na raiz.
     */
    void pegarEmprestadoAnterior(No _raiz, int idx) {
        //Recupera o nó do filho
        No filho = _raiz.getC(idx);
        //Recupera o nó do irmão anterior
        No irmao = _raiz.getC(idx - 1);

        for (int i = filho.getN() - 1; i >= 0; i--) {
            filho.setChave(i + 1, filho.getChave(i));
        }

        if (!filho.getFolha()) {
            for (int i = filho.getN(); i >= 0; i--) {
                filho.setChave(i + 1, filho.getChave(i));
            }
        }

        filho.setChave(0, filho.getChave(idx - 1));

        if (!filho.getFolha()) {
            filho.setC(0, irmao.getC(irmao.getN()));
        }

        //Troca a chave do nó atual pelo irmão anterior
        _raiz.setChave(idx - 1, irmao.getChave(irmao.getN() - 1));

        //Incrementa o nó filho
        filho.setN(filho.getN() + 1);
        //Decrementa o nó irmao
        irmao.setN(irmao.getN() - 1);
    }

    /**
     * Emprestar do irmão seguinte
     * 
     * @param _raiz Raiz da sub-árvore.
     * @param idx Indice do nó na raiz.
     */
    void pergarEmprestadoProximo(No _raiz, int idx) {
        //Recupera o nó do filho
        No filho = _raiz.getC(idx);
        //Recupera o nó do irmão seguinte
        No irmao = _raiz.getC(idx + 1);

        filho.setChave(filho.getN(), filho.getChave(idx));

        if (!filho.getFolha()) {
            filho.setC(filho.getN() + 1, irmao.getC(0));
        }

        filho.setChave(idx, irmao.getChave(0));

        for (int i = 1; i < irmao.getN(); i++) {
            irmao.setChave(i - 1, irmao.getChave(i));
        }

        if (!irmao.getFolha()) {
            for (int i = 1; i <= irmao.getN(); i++) {
                irmao.setC(i - 1, irmao.getC(i));
            }
        }

        //Incrementa o nó filho
        filho.setN(filho.getN() + 1);
        //Decrementa o nó irmão
        irmao.setN(irmao.getN() - 1);
    }

    /**
     * Preenche um nó filho.
     *
     * @param _raiz Raiz da sub-árvore.
     * @param idx Indice do nó na raiz.
     */
    public void preencherFilhos(No _raiz, int idx) {
        if (idx != 0 && _raiz.getC(idx - 1).getN() >= t * 2) {
            this.pegarEmprestadoAnterior(_raiz, idx);
        } else {
            if (idx != _raiz.getN() && _raiz.getC(idx + 1).getN() >= t * 2) {
                this.pergarEmprestadoProximo(_raiz, idx);
            } else {
                if (idx != _raiz.getN()) {
                    this.mergeFilhos(_raiz, idx);
                } else {
                    this.mergeFilhos(_raiz, idx - 1);
                }
            }
        }
    }

    /**
     * Remove uma chave da sub-árvore.
     *
     * Utiliza uma rotina recursiva.
     *
     * @param _raiz Raiz da sub-árvore.
     * @param k Chave a ser removida.
     */
    public void remover(No _raiz, int k) {
        int i = 0;
        
        //System.out.println("antes: i:" + i + " n:" + _raiz.getN());
        //Procura a posição da chave no nó
        while (i < _raiz.getN() && k > _raiz.getChave(i)) {
            //System.out.println("k:" + k + " raiz.chave:" + _raiz.getChave(i));
            i = i + 1;
        }
        //System.out.println("depois: i:" + i + " n:" + _raiz.getN());
        //A chave está no nó _raiz
        if (i < _raiz.getN() && k == _raiz.getChave(i)) {
            //System.out.println("a chave está no nó raiz");
            //O Nó é uma folha
            if (_raiz.getFolha()) {
                //Remove k do _raiz;
                this.removerFolha(_raiz, i);
            } else {
                this.removerNaoFolha(_raiz, i);
            }
        } else {
            //A chave não está em _raiz            
            if (!_raiz.getFolha()) {
                boolean flag = (i == _raiz.getN());

                if (_raiz.getC(i).getN() < t / 2) {
                    this.preencherFilhos(_raiz, i);
                }
                if (flag && i > _raiz.getN()) {
                    this.remover(_raiz.getC(i - 1), k);
                } else {
                    this.remover(_raiz.getC(i), k);
                }
            } else {
                System.out.println("A chave " + k + " não está na árvore");                
            }
        }
    }

    /**
     * Remove uma chave da árvore.
     *
     * @param k Chave a ser removida.
     * @return Verdadeiro ou falso se conseguiu realizar a exclusão.
     */
    public boolean remover(int k) {
        //Quantidade de nós antes da exclusão
        int qtde1 = this.contarNo();
        
        if (this.getRaiz() != null) {
            //Realiza a exclusão
            this.remover(this.getRaiz(), k);
            
            if (this.getRaiz().getN() == 0){
                //Cria uma nova raiz.
                this.alocarRaiz();
            }
        } else {
            System.out.println("Lista está vazia");                                
        }
        //Quantidade de nós depois da exclusão
        int qtde2 = this.contarNo();
        
        return !(qtde1 == qtde2);
    }
}
