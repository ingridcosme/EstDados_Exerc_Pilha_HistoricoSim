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

package controller;

import br.edu.fateczl.ingridcosme.pilhastring.Pilha;

public class HistoricoController {

	public HistoricoController() {
		super();
	}
	
	public boolean validar(String endereco) {
		String[] retorno = endereco.split("\\.");
		if(retorno[0].equals("http://www") && retorno.length > 2) {
			return true;
		} else {
			return false;
		}
	}
	
	public void inserir(Pilha historico, String endereco) {
		if(validar(endereco) == true) {
			historico.push(endereco);
		} else {
			System.err.println("Endere�o <<"+endereco+">> inv�lido!");
		}
	}
	
	public void remover(Pilha historico) throws Exception {
		if(historico.isEmpty()) {
			throw new Exception("N�o h� endere�os para remover!");
		} else {
			String endereco = historico.pop();
			System.out.println("�ltimo endere�o visitado <<"+endereco+">> removido!");
		}
	}
	
	public void consultar(Pilha historico) throws Exception {
		if(historico.isEmpty()) {
			throw new Exception("N�o h� endere�os para consultar!");
		} else {
			String endereco = historico.top();
			System.out.println("�ltimo endere�o visitado: "+endereco);
		}
	}

}
