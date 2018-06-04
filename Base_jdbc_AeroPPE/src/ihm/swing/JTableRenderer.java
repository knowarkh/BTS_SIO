package ihm.swing;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 * Définir l'affichage dans un JTable
 * 
 */
public class JTableRenderer extends DefaultTableCellRenderer {

	private static final long serialVersionUID = 1L;

	@Override
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
			int row, int column) {
		Component component = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

		/**
		 * Fixer la couleur de fond de la première colonne
		 * code RVB
		 */
		if (column == 0) {
			Color clr = new Color(141, 192, 230);
			component.setBackground(clr);
		} else {
			Color clr = new Color(215, 230, 250);
			component.setBackground(clr);
		}
		if (isSelected) {
			Color clr = new Color(254, 254, 254);
			component.setBackground(clr);
		}
		return component;
	}
}