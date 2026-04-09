
/**
 * Programa principal de manipulação da Árvore B+.
 */
import javax.swing.JOptionPane;

public class Principal {

    /**
     * Realiza a leitura dos dados dos nós.
     *
     * @return O valor lido.
     */
    public static int leitura() {
        return Integer.parseInt(JOptionPane.showInputDialog("Digite um valor:"));
    }

    /**
     * Árvore de exemplo.
     *
     * @param arvore Árvore a ser preenchida.
     */
    public static void arvoreExemplo(ArvoreBPlus arvore) {
        arvore.inserir(10);
        arvore.inserir(20);
        arvore.inserir(30);
        arvore.inserir(40);
        arvore.inserir(50);
        arvore.inserir(60);
        arvore.inserir(70);
        arvore.inserir(80);
        arvore.inserir(90);
        arvore.inserir(100);
        arvore.inserir(110);
        arvore.inserir(120);
        System.out.println("Caminho Centro:");
        arvore.listarCentralOrdem();
        System.out.println();

        //Grau t = 3
        //Nós: 10 20 30 40 50 60 
        //Árvore:
        //      30
        //10 20    30 40 50 60
        //
        //Nós:10 20 30 40 50 60 70 80 
        //Árvore:
        //      30       50
        //10 20   30 40   50 60 70 80
        //
        //Nós: 10 20 30 40 50 60 70 80 90
        //Árvore:
        //       30       60       70
        //10 20    30  40     50  60    70 80 90
    }

    /**
     * Método principal.
     *
     * @param args
     */
    public static void main(String[] args) {
        /**
         * Declara e instância da árvore.
         */
        ArvoreBPlus ipe = new ArvoreBPlus(2);

        // Controla o menu da lista
        int opcao = -1;

        //Laço do menu de opções
        do {
            //Monta o menu de opções
            opcao = Integer.parseInt(JOptionPane.showInputDialog("\t### Árvore B+ ###\n"
                    + "Selecione a opção desejada:\n"
                    + " 1- Inserir \n"
                    + " 2- Excluir \n"
                    + " 3- Alterar \n"
                    + " 4- Caminhar Pré Ordem\n"
                    + " 5- Caminhar Central(In) Ordem\n"
                    + " 6- Caminhar Pós Ordem\n"
                    + " 7- Caminhar Em Nível\n"
                    + " 8- Caminhar Em Nível Detalhado\n"
                    + " 9- Contar nós \n"
                    + "10- Procurar nó \n"
                    + "11- Mostrar folhas \n"
                    + "12- Altura da árvore\n"
                    + "13- Valor mínimo da árvore\n"
                    + "14- Valor máximo da árvore\n"
                    + "15- Apagar árvore\n"
                    + "99- Sair\n"));

            switch (opcao) {
                case 1: {
                    //Preenche o valor do dado
                    int dado = leitura();
                    //Insere o valor na árvore
                    ipe.inserir(dado);
                    System.out.println("Valor " + dado + " inserido  da árvore.");
                    break;
                }
                case 2: {
                    //Preenche o valor do dado                    
                    int dado = Integer.parseInt(JOptionPane.showInputDialog("Digite o valor a ser removido"));
                    //Remove o valor da árvore
                    if (ipe.remover(dado) == true) {
                        System.out.println("Valor " + dado + " removido da árvore.");
                    } else {
                        System.out.println("Valor " + dado + " não removido da árvore.");
                    }
                    break;
                }
                case 3: {
                    //Preenche o valor do dado                    
                    int dadoAnterior = Integer.parseInt(JOptionPane.showInputDialog("Digite o valor a ser alterado"));
                    int dadoNovo = Integer.parseInt(JOptionPane.showInputDialog("Digite o novo valor"));
                    //Remove o valor da árvore
                    if (ipe.atualizar(dadoAnterior, dadoNovo) == true) {
                        System.out.println("Valor " + dadoAnterior + " atualizado para " + dadoNovo);
                    } else {
                        System.out.println("Valor " + dadoAnterior + " não alterado na árvore.");
                    }
                    break;
                }
                case 4: {
                    System.out.println(">> Caminhamento Pré Ordem");
                    ipe.listarPreOrdem();
                    System.out.println();
                    break;
                }
                case 5: {
                    System.out.println(">> Caminhamento Central(in)");
                    ipe.listarCentralOrdem();
                    System.out.println();
                    break;
                }
                case 6: {
                    System.out.println(">> Caminhamento Pós Ordem");
                    ipe.listarPosOrdem();
                    System.out.println();
                    break;
                }
                case 7: {
                    System.out.println(">> Caminhamento Em Nível");
                    ipe.listarEmNilvel();
                    System.out.println();
                    break;
                }
                case 8: {
                    System.out.println(">> Caminhamento Em Nível Detalhado");
                    ipe.listarEmNilvelDetalhes();
                    System.out.println();
                    break;
                }
                case 9: {
                    //Retorna a quantidade de nós
                    int qtde = ipe.contarNo();
                    System.out.println("Nós encontrados: " + qtde);
                    break;
                }
                case 10: {
                    //Preenche o valor do dado
                    int dado = Integer.parseInt(JOptionPane.showInputDialog("Digite o valor a ser procurado:"));
                    No encontrou = ipe.procurar(dado);
                    if (encontrou != null) {
                        JOptionPane.showMessageDialog(null, "O valor " + dado + " foi encontrado no nó: " + encontrou);
                    } else {
                        JOptionPane.showMessageDialog(null, "O valor " + dado + " não foi encontrado!");
                    }
                    break;
                }
                case 11: {
                    System.out.println("Mostrar Folhas\n" + ipe.encontrarFolhas());
                    break;
                }
                case 12: {
                    System.out.println("Altura árvore: " + ipe.getAltura());
                    break;
                }
                case 13: {
                    System.out.println("Valor mínimo da árvore: " + ipe.getValorMinimo());
                    break;
                }
                case 14: {
                    System.out.println("Valor máximo da árvore: " + ipe.getValorMaximo());
                    break;
                }
                case 15: {
                    ipe.apagar();
                    System.out.println("Árvore apagada");
                    break;
                }
                //Preenche uma árvore com vários nós
                case 98: {
                    arvoreExemplo(ipe);
                    break;
                }

                //Opção de saída do programa
                case 99: {
                    System.out.println("Saindo do programa!");
                    break;
                }
                //Opção inválida do menu
                default: {
                    System.out.println("Opção inválida!");
                    break;
                }
            }//Fim switch   
        } while (opcao != 99); //Fim do while
    }//Fim main
}//Fim Principal
