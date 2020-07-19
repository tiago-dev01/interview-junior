package br.com.brainweb.interview.core.features.hero;

import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.brainweb.interview.core.features.powerstats.PowerStatsService;
import br.com.brainweb.interview.model.Hero;
import br.com.brainweb.interview.model.PowerStats;
import br.com.brainweb.interview.model.request.CreateHeroRequest;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class HeroService {

	private final HeroRepository heroRepository;

	private final PowerStatsService powerStatusService;

	@Transactional
	public UUID create(CreateHeroRequest createHeroRequest) {
		return heroRepository.create(new Hero(createHeroRequest,
				powerStatusService.create(PowerStats.builder().intelligence(createHeroRequest.getIntelligence())
						.strength(createHeroRequest.getStrength()).agility(createHeroRequest.getAgility())
						.dexterity(createHeroRequest.getDexterity()).build())));
	}

	public Hero findHeroById(UUID uuid) throws Exception {
		return heroRepository.findHeroById(uuid);
	}

}
