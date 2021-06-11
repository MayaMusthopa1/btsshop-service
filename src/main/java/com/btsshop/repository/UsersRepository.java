/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.btsshop.repository;

import com.btsshop.entity.user.Users;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author ITAdmin
 */
@Repository
public interface UsersRepository extends PagingAndSortingRepository<Users, String> {

    public Users findByUserNameAndPassword(String userName, String password);

}
