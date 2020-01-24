package com.smoothstack.avalanche.lms.controller;


import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.smoothstack.avalanche.lms.entity.Branch;
import com.smoothstack.avalanche.lms.entity.BookCopies;
import com.smoothstack.avalanche.lms.svc.LibrarianSVC;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;


import org.springframework.beans.factory.annotation.Autowired;


@RestController
@RequestMapping( path="/lms/librarian" )
public class LibrarianController {


	@Autowired
	LibrarianSVC LibrarianService;


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
	@GetMapping( "/branch" )
	public List<BookCopies> findBookCopiesByBranchId( @RequestParam Long id ) {
		return LibrarianService.findBookCopiesByBranchId( id );
	}

	// -- [ 3 ] -- Update branch name/address: {"branchName": "Frostburg State University", "branchId": 1, "branchAddress": "2417 Summit Point"}
	@PutMapping( "/branch" )
	public ResponseEntity<Branch> updateBranch( @RequestBody Branch branch ) {
		System.out.println("BRANCH UPDATE CALLED");
		LibrarianService.updateBranch( branch );
		ResponseEntity<Branch> response = new ResponseEntity<Branch>( HttpStatus.NO_CONTENT );
		return response;
	}

	// -- [ 4 ] -- Update book copies at branch: {"bookId": 1, "branchId": 1, "noOfCopies": 15}
	@PutMapping( "/bookcopies" )
	public ResponseEntity<BookCopies> updateBookCopies( @RequestBody BookCopies copies ) {
		System.out.println("BOOK COPIES CALLED");
		// copies.setBranchId( id );
		// System.out.println( copies );
		LibrarianService.updateBookCopies( copies );
		ResponseEntity<BookCopies> response = new ResponseEntity<BookCopies>( HttpStatus.NO_CONTENT );
		return response;
	}

}
