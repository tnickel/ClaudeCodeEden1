package com.example.swt;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Shell;

/**
 * Einstiegspunkt der SWT-Menubar-Anwendung.
 * Erstellt das Hauptfenster mit einer Menuleiste und startet die SWT-Event-Loop.
 */
public class MainApp {

    private static final String WINDOW_TITLE = "SWT MenuBar Application";
    private static final int WINDOW_WIDTH = 600;
    private static final int WINDOW_HEIGHT = 400;

    public static void main(String[] args) {
        Display display = new Display();
        try {
            Shell shell = createShell(display);
            createMenuBar(shell);
            shell.open();

            // SWT-Event-Loop: verarbeitet UI-Ereignisse bis das Fenster geschlossen wird.
            while (!shell.isDisposed()) {
                if (!display.readAndDispatch()) {
                    display.sleep();
                }
            }
        } finally {
            display.dispose();
        }
    }

    private static Shell createShell(Display display) {
        Shell shell = new Shell(display);
        shell.setText(WINDOW_TITLE);
        shell.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        return shell;
    }

    private static void createMenuBar(Shell shell) {
        Menu menuBar = new Menu(shell, SWT.BAR);
        shell.setMenuBar(menuBar);
        addMenuItem(shell, menuBar, "Menu1");
        addMenuItem(shell, menuBar, "Menu2");
        addMenuItem(shell, menuBar, "Menu3");
        addMenuItem(shell, menuBar, "Menu4");
    }

    private static void addMenuItem(Shell shell, Menu menuBar, String label) {
        MenuItem item = new MenuItem(menuBar, SWT.CASCADE);
        item.setText(label);
        Menu dropDown = new Menu(shell, SWT.DROP_DOWN);
        item.setMenu(dropDown);
        // Platzhalter-Eintrag, damit das Drop-Down sichtbar ist
        MenuItem placeholder = new MenuItem(dropDown, SWT.PUSH);
        placeholder.setText(label + " Item 1");
    }
}
