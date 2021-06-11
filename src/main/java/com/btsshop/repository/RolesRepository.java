/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.btsshop.repository;

import com.btsshop.entity.user.Roles;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author MODERN 14
 */
@Repository
public interface RolesRepository extends CrudRepository<Roles, Integer> {
}
