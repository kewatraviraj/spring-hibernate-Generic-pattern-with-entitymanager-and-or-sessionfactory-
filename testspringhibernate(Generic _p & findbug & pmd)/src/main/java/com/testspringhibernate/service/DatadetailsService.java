/**
 * 
 */
package com.testspringhibernate.service;

import java.util.List;

import com.testspringhibernate.model.Datadetails;

/**
 * @author Dell
 *
 */
public interface DatadetailsService {
	void savedata(Datadetails data);
	List<Datadetails> listDeatails();
}
