/**
 * 
 */
package com.testspringhibernate.dao;

import org.springframework.stereotype.Repository;

import com.testspringhibernate.model.Datadetails;

/**
 * @author Dell
 *
 */
@Repository
public class DatadetailsDaoImpl extends GenericDaoImpl<Datadetails> implements DatadetailsDao {

	
   /* @Autowired
	  private SessionFactory sessionFactory;
    */
	/* (non-Javadoc)
	 * @see com.testspringhibernate.dao.DataOperation#persistdata(com.testspringhibernate.model.Displaydata)
	 */
	/*public void persistdata(Datadetails data) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().persist(data);
	}*/

	/* (non-Javadoc)
	 * @see com.testspringhibernate.dao.DataOperation#listdetails()
	 */
	/*@Override
	public List<Datadetails> listdetails() {
		// TODO Auto-generated method stub
	      return sessionFactory.getCurrentSession().createQuery("from shmdata").getResultList();
	}

	 (non-Javadoc)
	 * @see com.testspringhibernate.dao.DataOperation#deletedata(java.lang.Integer)
	 
	@Override
	public boolean deletedata(int Id) {
		// TODO Auto-generated method stub
		Datadetails datadetail = sessionFactory.getCurrentSession().get(Datadetails.class, Id);
		sessionFactory.getCurrentSession().delete(datadetail);
		return true;
	}
*/
}
