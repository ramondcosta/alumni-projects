//#if ${BugTrack} == "T" or  ${Comunicacao} == "T" or  ${Categoria} == "T" or  ${CarrinhoCompras} == "T" or ${FormaPagament} == "T" or  ${Perfil} == "T" or  ${Produto} == "T" or  ${SituacaoBug} == "T" or  ${StatusUsuario} == "T" or  ${StatusVenda} == "T" or  ${UnidadeMedida} == "T" or  ${Usuario} == "T" or  ${Venda} == "T" or ${UsuarioStatus} == "T"  or ${BugTrackCadastrar} == "T" or ${BugTrackConsultar} == "T" or ${BugTrackExcluir} == "T" or ${BugTrackAlterar} == "T" or ${FAQCadastrar} == "T" or ${FAQConsultar} == "T" or ${FAQExcluir} == "T" or ${FAQAlterar} == "T"  or ${FAQDetalhar} == "T"  or ${FAQListar} == "T" 
/**
 * 
 */
package br.com.webstore.dao;

import java.util.List;

import javax.persistence.EntityManager;
//import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
//import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

/**
 * @author webstore
 *
 */
public abstract class GenericDao<T, I> {

	//private static final String NAME_DB = "webstoredb";
	
	protected EntityManager entityManager;

	private Class<T> persistedClass;

	protected GenericDao(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	protected GenericDao(EntityManager entityManager, Class<T> persistedClass) {
		this(entityManager);
		this.persistedClass = persistedClass;
	}

	public T insert(T entity) {
		EntityTransaction t = entityManager.getTransaction();
		t.begin();
		entityManager.persist(entity);
		entityManager.flush();
		t.commit();
		return entity;
	}

	public T update(T entity) {
		EntityTransaction t = entityManager.getTransaction();
		t.begin();
		entityManager.merge(entity);
		entityManager.flush();
		t.commit();
		return entity;
	}

	public void remove(I id) {
		T entity = find(id);
		EntityTransaction tx = entityManager.getTransaction();
		tx.begin();
		T mergedEntity = entityManager.merge(entity);
		entityManager.remove(mergedEntity);
		entityManager.flush();
		tx.commit();
	}

	public List<T> getList() {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<T> query = builder.createQuery(persistedClass);
		query.from(persistedClass);
		return entityManager.createQuery(query).getResultList();
	}

	public T find(I id) {
		return entityManager.find(persistedClass, id);
	}
}
//#endif