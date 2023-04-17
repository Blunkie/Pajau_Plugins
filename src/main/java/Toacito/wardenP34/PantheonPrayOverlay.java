package Toacito.wardenP34;

import net.runelite.api.Client;
import net.runelite.api.VarClientInt;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.OverlayPriority;
import net.runelite.client.ui.overlay.OverlayUtil;

import javax.inject.Inject;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.Rectangle;

public class PantheonPrayOverlay extends Overlay {
	@Inject
	private Pantheon pantheon;

	@Inject
	private Client client;

	@Inject
	PantheonPrayOverlay(Client client, Pantheon pantheonPlugin){
		this.client=client;
		this.pantheon=pantheonPlugin;
		setLayer(OverlayLayer.ABOVE_WIDGETS);
		setPriority(OverlayPriority.HIGH);
		setPosition(OverlayPosition.DYNAMIC);
	}

	@Override
	public Dimension render(Graphics2D graphics) {
		if (pantheon.isOverlaycito())
		{
			Color colorzobich;
			WidgetInfo praycito = null;
			if (pantheon.isRanged()){
				colorzobich = Color.GREEN;
				praycito=WidgetInfo.PRAYER_PROTECT_FROM_MISSILES;
			}else {
				colorzobich = Color.CYAN;
				praycito=WidgetInfo.PRAYER_PROTECT_FROM_MAGIC;
			}
			Widget widget = client.getWidget(praycito);
			if (widget == null || client.getVarcIntValue(VarClientInt.INVENTORY_TAB) != 5) //5 es la PRAYER_TAB
				return null;
			Rectangle limites = widget.getBounds();
			OverlayUtil.renderPolygon(graphics,rectangleToPolygon(limites),colorzobich);
		}
		return null;
	}

	private static Polygon rectangleToPolygon(Rectangle rect) {
		int[] xpoints = { rect.x, rect.x + rect.width, rect.x + rect.width, rect.x };
		int[] ypoints = { rect.y, rect.y, rect.y + rect.height, rect.y + rect.height };
		return new Polygon(xpoints, ypoints, 4);
	}
}
