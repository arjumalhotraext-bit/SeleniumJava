package demoqa.base;

import demoqa.demoqapages.alerts_frames_windows.Alerts_Frames_WindowsPage;
import demoqa.demoqapages.elements.ElementsPage;
import demoqa.demoqapages.forms.FormsPage;
import demoqa.demoqapages.widgets.WidgetsPage;
import org.openqa.selenium.By;
import static demoqa.utlities.JavaScriptUtility.scrollToElementJS;

public class HomePage extends demoqa.base.BasePage {

    private By formsCard = By.xpath("//div[@id='app']//h5[text()='Forms']");
    private By elementsCard = By.xpath("//div[@id='app']//h5[text()='Elements']");
    private By widgetsCard = By.xpath("//div[@id='app']//h5[text()='Widgets']");
    private By alertsFrameWindowsCard = By.xpath("//div[@id='app']//h5[contains(text(),'Alerts')]");

    public FormsPage goToForms() {
        scrollToElementJS(formsCard);
        click(formsCard);
        return new FormsPage();
    }

    public ElementsPage goToElements () {
        scrollToElementJS(elementsCard);
        click(elementsCard);
        return new ElementsPage();
    }

    public WidgetsPage goToWidgets() {
        scrollToElementJS(widgetsCard);
        click(widgetsCard);
        return new WidgetsPage();
    }

    public Alerts_Frames_WindowsPage goToAlertsFramesWindowsCard() {
        scrollToElementJS(alertsFrameWindowsCard);
        click(alertsFrameWindowsCard);
        return new Alerts_Frames_WindowsPage();
    }
}
