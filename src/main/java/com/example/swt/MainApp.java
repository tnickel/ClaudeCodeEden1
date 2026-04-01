package com.example.swt;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Shell;

public class MainApp {

    public static void main(String[] args) {

        Display display = new Display();

        Shell shell = new Shell(display);
        shell.setText("SWT MenuBar Application");
        shell.setSize(600, 400);

        Menu menuBar = new Menu(shell, SWT.BAR);
        shell.setMenuBar(menuBar);

        MenuItem menue1Item = new MenuItem(menuBar, SWT.CASCADE);
        menue1Item.setText("Menue1");
        Menu menue1DropDown = new Menu(shell, SWT.DROP_DOWN);
        menue1Item.setMenu(menue1DropDown);

        MenuItem menue2Item = new MenuItem(menuBar, SWT.CASCADE);
        menue2Item.setText("Menue2");
        Menu menue2DropDown = new Menu(shell, SWT.DROP_DOWN);
        menue2Item.setMenu(menue2DropDown);

        MenuItem menue3Item = new MenuItem(menuBar, SWT.CASCADE);
        menue3Item.setText("Menue3");
        Menu menue3DropDown = new Menu(shell, SWT.DROP_DOWN);
        menue3Item.setMenu(menue3DropDown);

        MenuItem menue4Item = new MenuItem(menuBar, SWT.CASCADE);
        menue4Item.setText("Menue4");
        Menu menue4DropDown = new Menu(shell, SWT.DROP_DOWN);
        menue4Item.setMenu(menue4DropDown);

        shell.open();

        while (!shell.isDisposed()) {
            if (!display.readAndDispatch()) {
                display.sleep();
            }
        }

        display.dispose();
    }
}
