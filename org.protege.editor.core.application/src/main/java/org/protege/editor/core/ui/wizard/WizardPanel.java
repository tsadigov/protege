package org.protege.editor.core.ui.wizard;

import javax.swing.JPanel;


/**
 * A base descriptor class used to reference a Component panel for the Wizard, as
 * well as provide general rules as to how the panel should behave.
 */
public class WizardPanel extends JPanel {
    private static final long serialVersionUID = 3018237002289836978L;

    /**
     * Identifier returned by getNextPanelDescriptor() to indicate that this is the
     * last panel and the text of the 'Next' button should change to 'Finish'.
     */
    public static final FinishIdentifier FINISH = new FinishIdentifier();

    private Wizard wizard;

    private Object panelIdentifier;


    public WizardPanel(Object panelIdentifier) {
        this.panelIdentifier = panelIdentifier;
    }


    protected void initialise() {

    }


    public Object getIdentifier() {
        return panelIdentifier;
    }
    
    
    /* package */ final void setWizard(Wizard w) {
        wizard = w;
    }


    /**
     * Returns a reference to the Wizard component.
     * @return The Wizard class hosting this descriptor.
     */
    public Wizard getWizard() {
        return wizard;
    }


    /**
     * Returns a reference to the current WizardModel for this Wizard component.
     * @return The current WizardModel for this Wizard component.
     */
    public WizardModel getWizardModel() {
        return wizard.getModel();
    }

    //  Override this method to provide an Object-based identifier
    //  for the next panel.


    /**
     * Override this class to provide the Object-based identifier of the panel that the
     * user should traverse to when the Next button is pressed. Note that this method
     * is only called when the button is actually pressed, so that the panel can change
     * the next panel's identifier dynamically at runtime if necessary. Return null if
     * the button should be disabled. Return FinishIdentfier if the button text
     * should change to 'Finish' and the dialog should end.
     * @return Object-based identifier.
     */
    public Object getNextPanelDescriptor() {
        return null;
    }

    //  Override this method to provide an Object-based identifier
    //  for the previous panel.


    /**
     * Override this class to provide the Object-based identifier of the panel that the
     * user should traverse to when the Back button is pressed. Note that this method
     * is only called when the button is actually pressed, so that the panel can change
     * the previous panel's identifier dynamically at runtime if necessary. Return null if
     * the button should be disabled.
     * @return Object-based identifier
     */
    public Object getBackPanelDescriptor() {
        return null;
    }

    //  Override this method in the subclass if you wish it to be called
    //  just before the panel is displayed.


    /**
     * Override this method to provide functionality that will be performed just before
     * the panel is to be displayed.
     */
    public void aboutToDisplayPanel() {

    }

    //  Override this method in the subclass if you wish to do something
    //  while the panel is displaying.


    /**
     * Override this method to perform functionality when the panel itself is displayed.
     */
    public void displayingPanel() {

    }

    //  Override this method in the subclass if you wish it to be called
    //  just before the panel is switched to another or finished.


    /**
     * Override this method to perform functionality just before the panel is to be
     * hidden.
     */
    public void aboutToHidePanel() {

    }


    static class FinishIdentifier {

        public static final String ID = "FINISH";
    }
}
