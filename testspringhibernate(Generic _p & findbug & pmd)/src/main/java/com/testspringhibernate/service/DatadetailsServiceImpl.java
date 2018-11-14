/**
 * 
 */
package com.testspringhibernate.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.testspringhibernate.dao.DatadetailsDao;
import com.testspringhibernate.model.Datadetails;

/**
 * @author Dell
 *
 */
@Service
public class DatadetailsServiceImpl implements DatadetailsService {
	
	@Autowired
	DatadetailsDao dataoperation;
	
	@Transactional
	public void savedata(Datadetails data) {
	//	dataoperation.persistdata(data);
		dataoperation.create(data);
	}
	
	@Transactional
    public List<Datadetails> listDeatails() {
      return dataoperation.listdetails();
    }

/*	@Transactional
	public boolean delete(int Id) {
		if(dataoperation.deletedata(Id))
			return true;
		return false;
	}*/
}
