package com.smoothstack.avalanche.lms.svc;

import java.util.Optional;

import java.util.List;
import java.util.ArrayList;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.smoothstack.avalanche.lms.entity.Branch;
import com.smoothstack.avalanche.lms.entity.BookCopies;

import com.smoothstack.avalanche.lms.dao.BranchDAO;
import com.smoothstack.avalanche.lms.dao.BookCopiesDAO;


@Service
public class LibrarianSVC {

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
	public void updateBranch( Branch branch ) {
		branchDAO.save( branch );
	}

	// -- [ 4 ] -- Update book copies at branch
  public void updateBookCopies( BookCopies copies ) {
  	copiesDAO.save( copies );
  }

}
