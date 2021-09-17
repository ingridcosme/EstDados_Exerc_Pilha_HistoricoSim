/*
 * Criar  um  projeto  Java  (HistoricoSim)  e  importe  a  biblioteca  PilhaStrings.  
 * Esse  novo  projeto simular� uma fun��o presente nos navegadores Web, a fun_
 * ��o de hist�rico. A fun��o de hist�rico empilha os endere�os de sites acessa_
 * dos.A  classe  Principal,  no  package  view,  deve  ter  na  Main,  a  cria_
 * ��o  de  uma  Pilha  denominada hist�rico e deve dar ao usu�rio a possibili_
 * dade de inserir um novo endere�o no  hist�rico,  remover  o  �ltimo  endere�o  
 * da  pilha,  saber  qual  foi  o  �ltimo  endere�o  visitado. Um menu deve ser 
 * criado.A classe HistoricoController deve ter os m�todos de valida��o das ope_
 * ra��es oferecidas na Main da Classe Principal. Todos os m�todos devem receber 
 * a pilha criada no m�todo Main como par�metro.
 * �O m�todo de inserir um novo endere�o, deve-se verificar antes, se o endere�o 
 * � v�lido (um endere�o v�lido come�a com http:// e, na sequ�ncia, deve ter algo 
 * no formato www.endere�o.com (podendo ser, .com, .co.uk, .com.br,  etc.). N�o 
 * ser�o aceitos sites sem www;
 * �O m�todo de remover o �ltimo endere�o deve dar um erro se o hist�rico esti_
 * ver vazio ou desempilhar o �ltimo endere�o;
 * �O m�todo de consultar o �ltimo endere�o, deve dar um erro se o hist�rico es_
 * tiver vazio ou apresentar o �ltimo endere�o, sem remov�-lo.
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
            opc = Integer.parseInt(JOptionPane.showInputDialog("Hist�rico\n"
            		+ "O que voc� gostaria de fazer?"
                    + "\n------------------------------------------------------"
                    + "\n1 - Inserir um novo endere�o"
                    + "\n2 - Remover o �ltimo endere�o visitado"
                    + "\n3 - Consultar o �ltimo  endere�o  visitado"
                    + "\n9 - Finalizar a aplica��o"));
            switch(opc){
                case 1: endereco = JOptionPane.showInputDialog("Digite o endere�o"
                		+ " a ser inserido no Hist�rico: ");
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
                case 9: System.out.print("\n\nAplica��o Finalizada!");
                        break;
                default: JOptionPane.showMessageDialog(null, "Op��o inv�lida!");
            }
        }
        while(opc != 9);
	}

}
