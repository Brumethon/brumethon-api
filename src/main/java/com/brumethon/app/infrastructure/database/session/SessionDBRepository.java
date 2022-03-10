package com.brumethon.app.infrastructure.database.session;

import com.brumethon.app.infrastructure.database.user.UserDB;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface SessionDBRepository extends CrudRepository<SessionDB, String> {

    @Transactional
    @Modifying
    @Query("DELETE FROM SessionDB WHERE userDB.id = :#{#user.id}")
    void deleteAllByUserID (@Param("user") UserDB user);



//    @Query("delete from CLimit l where l.trader.id =:#{#trader.id}")
//    void deleteLimitsByTrader(@Param("trader") CTrader trader);
}
