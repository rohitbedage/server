package com.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.IVendorDao;
import com.app.pojos.Vendor;

@Service //Mandatory annotation to tell SC whatever follows contains B.L
@Transactional//Mandatory : annotation to tell SC , to use tx mgr bean for
//automatically handlings txs.
public class VendorServiceImpl implements IVendorService {
	//dependency : DAO layer
	@Autowired
	private IVendorDao vendorDao;

	@Override
	public Vendor authenticateUser(String email, String password) {
		// simply invoke dao's method for user authentication
		return vendorDao.authenticateUser(email, password);
	}

}
