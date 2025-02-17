package com.f1rst.registryapi.account;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface AccountRepository extends JpaRepository<AccountEntity, Long> {

    @Query("""
        select case when p.statusAccountEnum = 'ACTIVO' then true else false end
        from AccountEntity p
        where
         p.id.id_agency = :id_agency 
        and p.id.account_number = :account_number
        """)
    Boolean findActivoById(@Param("id_agency") Long id_client, @Param("account_number") Integer account_number);
}
