/**
 * 
 */
package com.finastra.intercashswitch.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.finastra.intercashswitch.entity.PaymentInitiation;

/**
 * @author Vipin.Mangalkar
 *
 */
@Repository
public interface PaymentInitiationRepository extends JpaRepository<PaymentInitiation, String> {

}
