/**
 * 
 */
package br.com.webstore.testes;

import static org.junit.Assert.assertTrue;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.Test;

import br.com.webstore.utils.Constantes;

/**
 * @author webstore
 *
 */
public class TesteConexaoBanco {
	
	@Test
	public void testaAConexaoComOBancoMySql(){
		EntityManagerFactory factory = Persistence.createEntityManagerFactory(Constantes.NAME_DB);
		EntityManager em = factory.createEntityManager();
		assertTrue(em.isOpen());
	}
}
