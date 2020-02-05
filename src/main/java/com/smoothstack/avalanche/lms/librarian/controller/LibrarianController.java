package com.smoothstack.avalanche.lms.librarian.controller;


import java.util.List;

import javax.validation.Valid;

import com.smoothstack.avalanche.lms.librarian.entity.Branch;
import com.smoothstack.avalanche.lms.librarian.entity.BookCopies;
import com.smoothstack.avalanche.lms.librarian.svc.LibrarianService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;


import org.springframework.beans.factory.annotation.Autowired;


@RestController
@RequestMapping( path="/lms/librarian" )
public class LibrarianController {


	@Autowired
	LibrarianService LibrarianService;


	/*
		[] A. Enter branch and list branches
		[]		 1. INPUT > Branch selected
		[]				A. Update details of library
		[]						1. INPUT > Enter branch name
		[]						2. INPUT > Enter branch address
		[]				B. Add copies of book to branch
		[]						1. INPUT > Select book
		[]						2. INPUT > New number of copies of book
		[]				C. RETURN
		[]		2. RETURN
		[] B. QUIT
	*/

	// -- [ 1 ] -- Get All Branches
	@GetMapping( "/branches" )
	public List<Branch> readBranches() {
		return LibrarianService.readBranches();
	}

	// -- [ 2 ] -- Get Book Copies by Branch
	@GetMapping( "/branches:{id}" )
	public List<BookCopies> findBookCopiesByBranchId( @Valid @PathVariable Long id ) {
		return LibrarianService.findBookCopiesByBranchId( id );
	}

	// -- [ 3 ] -- Update branch name/address:  {"id": 1, "name": "Frostburg State University", "address": "2417 Summit Point"}
	@PutMapping( "/branches:{id}" )
	public void updateBranch(
		@RequestBody Branch branch,
		@Valid @PathVariable Long id ) {
		branch.setId(id);
		LibrarianService.updateBranch( branch );
	}

	// -- [ 4 ] -- Update book copies at branch: {"bookId": 1, "branchId": 1, "noOfCopies": 15}
	@PutMapping( "/bookcopies" )
	public void updateBookCopies( @RequestBody BookCopies copies ) {
		LibrarianService.updateBookCopies( copies );
	}

}
