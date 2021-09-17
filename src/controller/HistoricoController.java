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
			System.err.println("Endereço <<"+endereco+">> inválido!");
		}
	}
	
	public void remover(Pilha historico) throws Exception {
		if(historico.isEmpty()) {
			throw new Exception("Não há endereços para remover!");
		} else {
			String endereco = historico.pop();
			System.out.println("Último endereço visitado <<"+endereco+">> removido!");
		}
	}
	
	public void consultar(Pilha historico) throws Exception {
		if(historico.isEmpty()) {
			throw new Exception("Não há endereços para consultar!");
		} else {
			String endereco = historico.top();
			System.out.println("Último endereço visitado: "+endereco);
		}
	}

}
