package com.smoothstack.avalanche.lms.librarian.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.smoothstack.avalanche.lms.librarian.entity.BookCopies;

@Repository
public interface BookCopiesDAO extends JpaRepository<BookCopies, Long>{

  List<BookCopies> findBookCopiesByBranchId(Long branchId);

}
