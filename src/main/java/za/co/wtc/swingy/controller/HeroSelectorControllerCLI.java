package za.co.wtc.swingy.controller;

import za.co.wtc.swingy.modle.charicters.Hero;
import za.co.wtc.swingy.view.HeroSelectCLI;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

public class HeroSelectorControllerCLI {
	@NotNull
    private HeroSelectCLI view;
    @NotNull@NotEmpty
    private List<Hero> herose;

	public HeroSelectorControllerCLI(HeroSelectCLI view, @NotNull @NotEmpty List<Hero> herose) {
		this.view = view;
		this.herose = herose;
	}

	public Hero selectHero(){
		return view.selectHero(herose);
	}
}
