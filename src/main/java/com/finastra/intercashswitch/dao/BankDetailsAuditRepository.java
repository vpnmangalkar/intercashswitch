package com.finastra.intercashswitch.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.finastra.intercashswitch.entity.BankDetailsAudit;

@Repository
public interface BankDetailsAuditRepository extends JpaRepository<BankDetailsAudit, Long> {

}
