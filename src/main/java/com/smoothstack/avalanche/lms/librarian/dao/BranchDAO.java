package com.smoothstack.avalanche.lms.librarian.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.smoothstack.avalanche.lms.librarian.entity.Branch;

@Repository
public interface BranchDAO extends JpaRepository<Branch ,Long>{


}
