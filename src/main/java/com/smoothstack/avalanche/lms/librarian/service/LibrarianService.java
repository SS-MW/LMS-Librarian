package com.smoothstack.avalanche.lms.librarian.service;


import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.smoothstack.avalanche.lms.librarian.entity.Branch;
import com.smoothstack.avalanche.lms.librarian.entity.BookCopies;

import com.smoothstack.avalanche.lms.librarian.dao.BranchDAO;
import com.smoothstack.avalanche.lms.librarian.dao.BookCopiesDAO;


@Service
public class LibrarianService {

	@Autowired
	private BranchDAO branchDAO;

	@Autowired
	private BookCopiesDAO copiesDAO;

	// -- [ 1 ] -- Get all branches
	public List<Branch> readBranches() {
		return branchDAO.findAll();
	}

	// -- [ 2 ] -- Get book copies by branch
	public List<BookCopies> findBookCopiesByBranchId( Long branchId ) {
		return copiesDAO.findBookCopiesByBranchId( branchId );
	}

	// -- [ 3 ] -- Update branch name/address
	public Branch updateBranch( Branch branch ) {
		return branchDAO.save( branch );
	}

	// -- [ 4 ] -- Update book copies at branch
  public BookCopies updateBookCopies( BookCopies copies ) {
  	return copiesDAO.save( copies );
  }

}
