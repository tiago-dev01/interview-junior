package br.com.brainweb.interview.core.features.hero;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import br.com.brainweb.interview.model.Hero;

public class HeroRowMapper implements RowMapper<Hero> {

	@Override
	public Hero mapRow(ResultSet rs, int rowNum) throws SQLException {
		return Hero.builder().name(rs.getString("name")).enabled(rs.getBoolean("enabled")).build();
	}

}
