package Toacito.wardenP34;

import Toacito.Sala;
import Toacito.ToacitoConfig;
import Toacito.ToacitoPlugin;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.GraphicsObject;
import net.runelite.api.events.GraphicsObjectCreated;
import net.runelite.client.eventbus.Subscribe;

import javax.inject.Inject;

@Slf4j
public class WardenP4 extends Sala {

	@Inject
	private Client client;

	@Inject
	private WardenP4Overlay wardenP4Overlay;

	public static GraphicsObject piedra = null;


	@Inject
	protected WardenP4(ToacitoConfig config, ToacitoPlugin plugin) {
		super(config, plugin);
	}

	@Override
	public void load() {
		this.overlayManager.add(wardenP4Overlay);
	}

	@Override
	public void unload() {
		this.overlayManager.remove(wardenP4Overlay);
	}

	@Subscribe
	public void onGraphicsObjectCreated(GraphicsObjectCreated event){
		if(event.getGraphicsObject().getId()==2250 || event.getGraphicsObject().getId() ==2251){
			piedra = event.getGraphicsObject();
			log.info("Katarina: {}",event.getGraphicsObject().getId());
		}
	}

}
