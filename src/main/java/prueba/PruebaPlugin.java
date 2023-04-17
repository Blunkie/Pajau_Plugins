package prueba;

import com.google.inject.Provides;
import net.runelite.api.Client;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.plugins.Plugin;

import javax.inject.Inject;

public class PruebaPlugin extends Plugin {
	@Inject
	private Client client;

	@Inject
	private PruebaConfig pruebaConfig;

	@Provides
	PruebaConfig provideConfig(ConfigManager configManager)
	{
		return (PruebaConfig) configManager.getConfig(PruebaConfig.class);
	}
}
