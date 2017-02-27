/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.upi.moudles.sys.service.impl;

import com.upi.common.service.BaseService;
import com.upi.moudles.biz.domain.MCode;
import com.upi.moudles.biz.repository.MCodeRepository;
import com.upi.moudles.biz.repository.PersonRepository;
import com.upi.moudles.sys.domain.MPage;
import com.upi.moudles.sys.domain.MPageType;
import com.upi.moudles.sys.domain.MUser;
import com.upi.moudles.sys.repository.MPageRepository;
import com.upi.moudles.sys.repository.MUserRepository;
import com.upi.moudles.sys.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author hang
 */
@Service
@Transactional(transactionManager = "bizTransactionManager")
public class UserServiceImpl extends BaseService implements UserService {

    @Autowired
    private MUserRepository muserRepository;
    @Autowired
    private MCodeRepository mcodeRepository;
    @Autowired
    private MPageRepository mpageRepository;
    @Autowired
    private PersonRepository personRepository;
    
    @Autowired
    private PagingAndSortingRepository<MUser, Integer> repository;
    
    public Page<MUser> users() {
        return repository.findAll(new PageRequest(1, 20));
    }

    @Override
    public boolean insertUserAndCode(String userName, String code) {
//        MUser foo = new MUser();
//        foo.setUserCd(userName);
//        muserRepository.save(foo);
//        System.out.println("User saved.");
//        MPage mpage = new MPage();
//        mpage.setPageName(userName);
//        mpage.setPageType(new MPageType(1));
//        System.out.println("Page saved.");
        
        MCode mcode = new MCode();
        mcode.setCode(code);
        mcode.setName("TestCode");
        mcodeRepository.save(mcode);
        System.out.println("Code saved.");        
        
        return true;
    }
}
