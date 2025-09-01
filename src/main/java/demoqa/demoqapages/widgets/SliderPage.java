package demoqa.demoqapages.widgets;

import org.openqa.selenium.By;

import static demoqa.utlities.ActionsUtility.dragAndDropBy;
import static demoqa.utlities.GetUtility.getAttribute;
import static java.nio.file.Files.find;

public class SliderPage extends WidgetsPage {

    private By slider = By.xpath("//div[@id='sliderContainer']//input[@type='range']");
    private By sliderValue = By.id("sliderValue");

    public String getSliderValue() {
        return getAttribute(sliderValue, "value");
    }

    public void moveSlider(int x, int y) {
//    Actions act = new Actions(driver);
//    act.dragAndDropBy(find(slider), x, y).perform();
        dragAndDropBy(find(slider), x, y);
    }
}