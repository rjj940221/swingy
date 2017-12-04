package za.co.wtc.swingy.controller;

import za.co.wtc.swingy.modle.charicters.Hero;
import za.co.wtc.swingy.store.SqlStore;
import za.co.wtc.swingy.view.HeroSelectCLI;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class HeroSelectorControllerCLI {
	@NotNull
    private HeroSelectCLI view;
    @NotNull@NotEmpty

	public HeroSelectorControllerCLI(HeroSelectCLI view) {
		this.view = view;
	}

	public Hero selectHero(){
		try {
		Connection con = SqlStore.getConnection();
		List<Hero> herose = SqlStore.listHerose(con);
		return view.selectHero(herose);} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
