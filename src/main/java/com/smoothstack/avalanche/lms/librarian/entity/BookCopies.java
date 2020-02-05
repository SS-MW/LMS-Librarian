package com.smoothstack.avalanche.lms.librarian.entity;

import javax.persistence.Id;
import javax.persistence.GenerationType;
import javax.persistence.GeneratedValue;

import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.Entity;


@Entity
@Table(name = "tbl_book_copies")
public class BookCopies {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "book_id")
	private Long bookId;

	@Column(name = "branch_id")
	private Long branchId;

	@Column(name ="no_of_copies")
	private Long noOfCopies;



	public Long getBookId() {
		return this.bookId;
	}

	public Long getBranchId() {
		return this.branchId;
	}

	public Long getNoOfCopies() {
		return this.noOfCopies;
	}



	public void setBookId(Long bookId) {
		this.bookId = bookId;
	}

	public void setBranchId(Long branchId) {
		this.branchId = branchId;
	}

	public void setNoOfCopies(Long noOfCopies) {
		this.noOfCopies = noOfCopies;
	}

}
