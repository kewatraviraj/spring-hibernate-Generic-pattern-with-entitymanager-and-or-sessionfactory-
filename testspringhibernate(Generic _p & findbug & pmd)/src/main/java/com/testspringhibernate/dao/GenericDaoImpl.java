/**
 * 
 */
package com.testspringhibernate.dao;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 * @author Dell
 *
 */

public abstract class GenericDaoImpl<T> implements GenericDao<T> {

	@PersistenceContext 
	protected EntityManager entitymanager;
	 
	/*@Autowired
	private SessionFactory sessionFactory;
	*/
	private Class<T> classtype;
	
	public GenericDaoImpl() {
		Type typ = getClass().getGenericSuperclass();
		ParameterizedType paratype = (ParameterizedType) typ;
		classtype = (Class) paratype.getActualTypeArguments()[0];
	}

	@Override
	public long countAll(final Map<String, Object> params) {

		final StringBuffer queryString = new StringBuffer("SELECT count(o) from ");
		queryString.append(classtype.getSimpleName()).append(" o ");
		// queryString.append(this.getQueryClauses(params, null));

		final Query query = this.entitymanager.createQuery(queryString.toString());
		return (Long) query.getSingleResult();
	}

	@Override
	public T create(final T typ) {
		this.entitymanager.persist(typ);
	//	this.sessionFactory.getCurrentSession().persist(typ);
		return typ;
	}

	@Override
	public void delete(final Object id) {
	//	this.sessionFactory.getCurrentSession().remove(this.sessionFactory.getCurrentSession().getReference(classtype, id));
	}

	@Override
	public T find(final Object id) {
		return null;
	//	return (T) this.sessionFactory.getCurrentSession().find(classtype, id);
	}

	@Override
	public T update(final T typ) {
		return typ;
	//	return (T) this.sessionFactory.createEntityManager().merge(typ);
	}

	@Override
	public List<T> listdetails() {
	//	 return this.sessionFactory.getCurrentSession().createQuery("from "+ classtype.getName() + "").getResultList();
	//	return this.sessionFactory.getCurrentSession().createCriteria(classtype).list();
		return this.entitymanager.createQuery("SELECT d FROM "+classtype.getName()+" d").getResultList();
			
	}

}