package Ventanas;

import java.awt.Component;

import javax.swing.DefaultListCellRenderer;
import javax.swing.JList;

import LogicaBatallas.ElementosPartida;

public class Renderer extends DefaultListCellRenderer {
    /**
	 * 
	 */
	private static final long serialVersionUID = 32L;

	public Component getListCellRendererComponent( JList list, Object value, int index, boolean isSelected, boolean cellHasFocus ) {
        Object item = value;

        // if the item to be rendered is Proveedores then display it's Name
        if( item instanceof ElementosPartida ) {
            item = ( ( ElementosPartida ) item ).getPartida();
        }
        return super.getListCellRendererComponent( list, item, index, isSelected, cellHasFocus);
    }
}