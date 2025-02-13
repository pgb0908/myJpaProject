package bong.service.collector.component;

import jakarta.annotation.PreDestroy;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class UserInfoCleaner {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @PreDestroy
    public void cleanUp() {
        // 'users' 테이블의 데이터를 삭제하는 SQL 쿼리
        jdbcTemplate.update("DELETE FROM users");
        System.out.println("users 테이블의 데이터가 삭제되었습니다.");
    }
}
