package org.robotframework.ide.eclipse.main.plugin;

import org.eclipse.jface.resource.ColorRegistry;
import org.eclipse.swt.graphics.Color;
import org.eclipse.ui.PlatformUI;

public class RobotTheme {

    private static final String ECLIPSE_DECORATION_COLOR = "DECORATIONS_COLOR";
    private static final String HIGHLIGHTED_CELL_COLOR = "org.robotframework.ide.eclipse.cell.highlight";
    private static final String HIGHLIGHTED_ROW_COLOR = "org.robotframework.ide.eclipse.row.selected";
    private static final String COMMENTS_IN_TABLES = "org.robotframework.ide.eclipse.comment";
    private static final String VARIABLES_IN_TABLES = "org.robotframework.ide.eclipse.variable";

    public static Color getEclipseDecorationColor() {
        return getColorRegistry().get(ECLIPSE_DECORATION_COLOR);
    }

    public static Color getHighlightedCellColor() {
        return getColorRegistry().get(HIGHLIGHTED_CELL_COLOR);
    }

    public static Color getHiglihtedRowColor() {
        return getColorRegistry().get(HIGHLIGHTED_ROW_COLOR);
    }

    public static Color getCommentsColor() {
        return getColorRegistry().get(COMMENTS_IN_TABLES);
    }

    public static Color getVariableColor() {
        return getColorRegistry().get(VARIABLES_IN_TABLES);
    }

    private static ColorRegistry getColorRegistry() {
        return PlatformUI.getWorkbench().getThemeManager().getCurrentTheme().getColorRegistry();
    }

}
