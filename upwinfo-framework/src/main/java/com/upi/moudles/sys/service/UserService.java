/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.upi.moudles.sys.service;

import com.upi.moudles.sys.domain.MUser;
import org.springframework.data.domain.Page;

/**
 *
 * @author hang
 */
public interface UserService {

    Page<MUser> users();

    boolean insertUserAndCode(String userName, String code);
}
