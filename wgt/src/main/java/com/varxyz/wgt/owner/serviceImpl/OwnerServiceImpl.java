package com.varxyz.wgt.owner.serviceImpl;

import java.util.List;

import com.varxyz.wgt.owner.doamin.Owner;
import com.varxyz.wgt.owner.service.OwnerService;

public class OwnerServiceImpl implements OwnerService {

	// 점주생성
	@Override
	public void addOwner(Owner owner) {
		ownerDao.addOwner(owner);
	}

	// 점주조회
	@Override
	public List<Owner> findAllOwner(String ownerId) {
		return ownerDao.findAllOwner(ownerId);
	}

	//점주수정
	@Override
	public void modifyOwner(Owner owner) {
		ownerDao.modifyOwner(owner);
	}

	// 점주탈퇴
	@Override
	public void delete(String ownerId) {
		ownerDao.delete(ownerId);
	}
	
}
