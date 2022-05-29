package woowacourse.member.dao;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;
import woowacourse.member.domain.Member;
import woowacourse.shoppingcart.exception.InvalidCustomerException;

import javax.sql.DataSource;
import java.util.Locale;

@Repository
public class MemberDao {

    private final JdbcTemplate jdbcTemplate;
    private final SimpleJdbcInsert simpleJdbcInsert;

    public MemberDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        this.simpleJdbcInsert = new SimpleJdbcInsert(dataSource)
                .withTableName("member")
                .usingGeneratedKeyColumns("id");
    }

    public void save(Member member) {
        SqlParameterSource namedParameterSource = new BeanPropertySqlParameterSource(member);
        simpleJdbcInsert.execute(namedParameterSource);
    }

    public boolean existMemberByEmail(String email) {
        String SQL = "SELECT EXISTS (SELECT * FROM MEMBER WHERE email = ?)";
        return jdbcTemplate.queryForObject(SQL, Boolean.class, email);
    }

    public Long findIdByUserName(final String userName) {
        try {
            final String query = "SELECT id FROM customer WHERE username = ?";
            return jdbcTemplate.queryForObject(query, Long.class, userName.toLowerCase(Locale.ROOT));
        } catch (final EmptyResultDataAccessException e) {
            throw new InvalidCustomerException();
        }
    }
}
