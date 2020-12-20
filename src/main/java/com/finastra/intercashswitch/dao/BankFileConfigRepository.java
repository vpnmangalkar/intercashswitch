package com.finastra.intercashswitch.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.finastra.intercashswitch.entity.BankFileConfig;

/**
 * @author Vipin.Mangalkar
 *
 */
@Repository
public interface BankFileConfigRepository extends JpaRepository<BankFileConfig, Long> {

}
