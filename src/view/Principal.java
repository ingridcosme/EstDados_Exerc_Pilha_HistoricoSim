/*
 * Criar  um  projeto  Java  (HistoricoSim)  e  importe  a  biblioteca  PilhaStrings.  
 * Esse  novo  projeto simulará uma função presente nos navegadores Web, a fun_
 * ção de histórico. A função de histórico empilha os endereços de sites acessa_
 * dos.A  classe  Principal,  no  package  view,  deve  ter  na  Main,  a  cria_
 * ção  de  uma  Pilha  denominada histórico e deve dar ao usuário a possibili_
 * dade de inserir um novo endereço no  histórico,  remover  o  último  endereço  
 * da  pilha,  saber  qual  foi  o  último  endereço  visitado. Um menu deve ser 
 * criado.A classe HistoricoController deve ter os métodos de validação das ope_
 * rações oferecidas na Main da Classe Principal. Todos os métodos devem receber 
 * a pilha criada no método Main como parâmetro.
 * •O método de inserir um novo endereço, deve-se verificar antes, se o endereço 
 * é válido (um endereço válido começa com http:// e, na sequência, deve ter algo 
 * no formato www.endereço.com (podendo ser, .com, .co.uk, .com.br,  etc.). Não 
 * serão aceitos sites sem www;
 * •O método de remover o último endereço deve dar um erro se o histórico esti_
 * ver vazio ou desempilhar o último endereço;
 * •O método de consultar o último endereço, deve dar um erro se o histórico es_
 * tiver vazio ou apresentar o último endereço, sem removê-lo.
 */

package view;

import javax.swing.JOptionPane;

import br.edu.fateczl.ingridcosme.pilhastring.Pilha;

import controller.HistoricoController;

public class Principal {

	public static void main(String[] args) {
		Pilha historico = new Pilha();
		HistoricoController hCont = new HistoricoController();
		
		String endereco = "";
		
		int opc=0;
        do{
            opc = Integer.parseInt(JOptionPane.showInputDialog("Histórico\n"
            		+ "O que você gostaria de fazer?"
                    + "\n------------------------------------------------------"
                    + "\n1 - Inserir um novo endereço"
                    + "\n2 - Remover o último endereço visitado"
                    + "\n3 - Consultar o último  endereço  visitado"
                    + "\n9 - Finalizar a aplicação"));
            switch(opc){
                case 1: endereco = JOptionPane.showInputDialog("Digite o endereço"
                		+ " a ser inserido no Histórico: ");
                		hCont.inserir(historico, endereco);
                        break;
                case 2: try {
							hCont.remover(historico);
							} catch (Exception e) {
							e.printStackTrace();
						}
                        break;
                case 3: try {
							hCont.consultar(historico);
						} catch (Exception e) {
							e.printStackTrace();
						}
		                break;
                case 9: System.out.print("\n\nAplicação Finalizada!");
                        break;
                default: JOptionPane.showMessageDialog(null, "Opção inválida!");
            }
        }
        while(opc != 9);
	}

}
