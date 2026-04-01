package com.example.swt;

import org.eclipse.swt.SWT;
import org.eclipse.swt.SWTException;
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
    private static final String PLACEHOLDER_SUFFIX = " Item 1";

    public static void main(String[] args) {
        Display display;
        try {
            display = new Display();
        } catch (SWTException e) {
            System.err.println("Grafikumgebung konnte nicht initialisiert werden: " + e.getMessage());
            return;
        }
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

    /**
     * Erstellt und konfiguriert das Hauptfenster der Anwendung.
     *
     * @param display die SWT-Display-Instanz, der das Shell zugeordnet wird
     * @return das konfigurierte Shell-Objekt
     */
    private static Shell createShell(Display display) {
        Shell shell = new Shell(display);
        shell.setText(WINDOW_TITLE);
        shell.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        return shell;
    }

    /**
     * Erstellt die Menuleiste und fuegt alle Menupunkte zum Shell hinzu.
     *
     * @param shell das Hauptfenster, dem die Menuleiste zugeordnet wird
     */
    private static void createMenuBar(Shell shell) {
        Menu menuBar = new Menu(shell, SWT.BAR);
        shell.setMenuBar(menuBar);
        addMenuItem(menuBar, "Menu1");
        addMenuItem(menuBar, "Menu2");
        addMenuItem(menuBar, "Menu3");
        addMenuItem(menuBar, "Menu4");
    }

    /**
     * Fuegt einen Menupunkt mit Drop-Down-Menu zur Menuleiste hinzu.
     *
     * @param menuBar die Menuleiste, der der Eintrag hinzugefuegt wird
     * @param label   der angezeigte Text des Menupunkts
     */
    private static void addMenuItem(Menu menuBar, String label) {
        MenuItem item = new MenuItem(menuBar, SWT.CASCADE);
        item.setText(label);
        Menu dropDown = new Menu(item);
        item.setMenu(dropDown);
        // TODO: SelectionListener hinzufuegen, um auf Benutzeraktionen zu reagieren
        MenuItem placeholder = new MenuItem(dropDown, SWT.PUSH);
        placeholder.setText(label + PLACEHOLDER_SUFFIX);
    }
}
