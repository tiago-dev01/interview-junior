package br.com.brainweb.interview.core.features.hero;

import java.util.Map;
import java.util.UUID;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import br.com.brainweb.interview.core.exception.HeroNotFoundException;
import br.com.brainweb.interview.model.Hero;
import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class HeroRepository {

    private static final String CREATE_HERO_QUERY = "INSERT INTO hero" +
        " (name, race, power_stats_id)" +
        " VALUES (:name, :race, :powerStatsId) RETURNING id";

    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    
    private final JdbcTemplate jdbcTemplate;

    UUID create(Hero hero) {
        final Map<String, Object> params = Map.of("name", hero.getName(),
            "race", hero.getRace().name(),
            "powerStatsId", hero.getPowerStatsId());

        return namedParameterJdbcTemplate.queryForObject(
            CREATE_HERO_QUERY,
            params,
            UUID.class);
    }

	public Hero findHeroById(UUID uuid) throws Exception {
		String sql = "SELECT * FROM Hero WHERE id = " + "'"+ uuid +"'";
		try {
			Hero hero = jdbcTemplate.queryForObject(sql, new HeroRowMapper());
			return hero;
		} catch(Exception e) {
			throw new HeroNotFoundException("Hero not found"); 
		}
	}

}
