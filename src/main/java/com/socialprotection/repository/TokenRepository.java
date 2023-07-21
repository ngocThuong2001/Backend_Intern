package com.socialprotection.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.socialprotection.entity.Token;

public interface TokenRepository extends JpaRepository<Token, Long> {

//	@Query("select * from tokens t where t.user_id = ?1 and (t.expired = false or t.revoked = false)")
	@Query("select t from token t inner join user u on t.user.userId = u.userId where u.userId = ?1 and (t.expired = false or t.revoked = false)")
	List<Token> findAllValidTokenByUser(long id);

	Optional<Token> findByToken(String token);

}
