/**
 * 
 */
package com.finastra.intercashswitch.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.finastra.intercashswitch.entity.NostroAccountDetails;

/**
 * @author u722954
 *
 */
@Repository
public interface NostroAccountDetailsRepository extends JpaRepository<NostroAccountDetails, String> {

	NostroAccountDetails findByOwnerSwiftCodeOrOwnerBicCode(String ownerSwiftCode, String ownerBicCode);
	
	NostroAccountDetails findByPartnerSwiftCodeOrPartnerBicCode(String PartnerSwiftCode, String PartnerBicCode);
}
