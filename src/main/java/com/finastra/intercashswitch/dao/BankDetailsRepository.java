package com.finastra.intercashswitch.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.finastra.intercashswitch.entity.BankDetails;

@Repository
public interface BankDetailsRepository extends JpaRepository<BankDetails, String> {
	Optional<BankDetails> findBySwiftCodeOrBicCode(String swiftCode, String bicCode);
}
