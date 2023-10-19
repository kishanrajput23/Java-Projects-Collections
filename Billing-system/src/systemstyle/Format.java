package systemstyle;

import billingsystem.Table;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;

/**
 * The Class Format manages the styling of the system.
 */
public class Format {
	
	/**
	 * Formats the innergrid.
	 *
	 * @param innergrid the inner gridpane
	 */
	public static void innergrid(GridPane innergrid) {
		innergrid.setVgap(10);
		innergrid.setMinHeight(150);
		innergrid.setStyle("-fx-border-color: #A9A9A9;");
		innergrid.setPadding(new Insets(10));
	}
	
	/**
	 * Formats the table.
	 *
	 * @param lbl the table label
	 * @param text the table text
	 * @param posX the table x-position
	 * @param posY the table y-position
	 * @param width the table width
	 * @param height the table height
	 */
	public static void table(Table lbl, String text, double posX, double posY, int width, int height) {
		lbl.setText(text);
		lbl.setLayoutX(posX);
		lbl.setLayoutY(posY);
		lbl.setXY(posX, posY);
		lbl.setAlignment(Pos.CENTER);
		lbl.setPrefSize(width, height);
		lbl.setStyle("-fx-background-color: #3F250B; -fx-text-fill: a9a9a9; -fx-font-weight: bold;");
		lbl.setCursor(Cursor.HAND);
	}
}
