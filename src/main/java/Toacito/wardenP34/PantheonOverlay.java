package Toacito.wardenP34;

import Toacito.ToacitoConfig;
import net.runelite.api.Client;
import net.runelite.api.Perspective;
import net.runelite.api.Point;
import net.runelite.api.coords.LocalPoint;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.OverlayPriority;
import net.runelite.client.ui.overlay.OverlayUtil;

import javax.inject.Inject;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics2D;

public class PantheonOverlay extends Overlay {

	@Inject
	private Client client;

	@Inject
	private Pantheon pantheon;

	@Inject
	private ToacitoConfig config;


	@Inject
	PantheonOverlay(Client client,Pantheon pantheon,ToacitoConfig config){
		this.client=client;
		this.pantheon=pantheon;
		this.config=config;
		setLayer(OverlayLayer.ABOVE_SCENE);
		setPosition(OverlayPosition.DYNAMIC);
		setPriority(OverlayPriority.HIGH);
	}

	@Override
	public Dimension render(Graphics2D graphics) {
		if(pantheon.isOverlaycito() && config.pantheonConfig())
		{
			String texto;
			Color colorcito;
			if(pantheon.isRanged())
			{
				colorcito= Color.GREEN;
				texto="Ranged";
			}else {
				colorcito= Color.CYAN;
				texto = "Putopian";
			}
			graphics.setFont(new Font("Arial",Font.BOLD,24));
			LocalPoint wea= pantheon.getMaricon().getLocalLocation();
			Point punto = Perspective.getCanvasTextLocation(client,graphics,wea,texto,0);
			OverlayUtil.renderTextLocation(graphics,punto,texto,colorcito);
		}

		return null;
	}
}
