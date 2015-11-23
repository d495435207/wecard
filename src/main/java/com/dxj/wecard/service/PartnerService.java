package com.dxj.wecard.service;

import com.dxj.wecard.model.Partner;

public interface PartnerService {

	int delete(int id);

	int insert(Partner record);

	Partner getById(Integer id);

	int update(Partner record);

}