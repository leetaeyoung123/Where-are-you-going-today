package com.varxyz.wgt.owner.serviceImpl;

import com.varxyz.wgt.owner.doamin.Owner;
import com.varxyz.wgt.owner.service.OwnerService;

public class OwnerServiceImpl implements OwnerService {

	@Override
	public void addOwner(Owner owner) {
		ownerDao.addOwner(owner);
	}
	
}
