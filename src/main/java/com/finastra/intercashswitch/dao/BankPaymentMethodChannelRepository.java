package com.finastra.intercashswitch.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.finastra.intercashswitch.entity.BankPaymentMethod;

/**
 * @author Vipin.Mangalkar
 *
 */
@Repository
public interface BankPaymentMethodChannelRepository extends JpaRepository<BankPaymentMethod, Long> {

	List<BankPaymentMethod> findByBankId(String bankId);

	BankPaymentMethod findByBankIdAndPaymentMode(String bankId, String paymentMode);
}
