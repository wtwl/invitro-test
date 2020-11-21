package pages;

import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;

@DefaultUrl("https://www.invitro.ru/radiology/")
public class RadiologyPage extends PageObject {

    String menuItemXpath = "//ul[@class='side-bar-second__list']/li";
    String subMenuItemXpath = "/./div/ul/li";
    By heading = By.xpath("//div[contains(@class, 'title-block')]/h1");

    private boolean hasSubMenu(By by) {
        WebElement parentEl = getDriver().findElement(by);
        return parentEl.findElements(By.xpath("./div/ul/li")).size() > 0;
    }

    private String getMenuItemXpath(int i) {
        return menuItemXpath + "[" + i + "]";
    }

    private String getSubMenuItemXpath(String parentXpath, int i) {
        return parentXpath + subMenuItemXpath + "[" + i + "]";
    }

    public String getHeading() {
        return getDriver().findElement(heading).getText();
    }

    public void clickOnMenu() {
        int menuSize = getDriver().findElements(By.xpath(menuItemXpath)).size();
        for(int i = 1; i <= menuSize; i++) {
            String nextItemXpath = getMenuItemXpath(i);
            By nextMenuItem = By.xpath(nextItemXpath);
            getDriver().findElement(nextMenuItem).click();

            if(hasSubMenu(nextMenuItem)) {
                By parentMenuBy = By.xpath(nextItemXpath + subMenuItemXpath);
                int subMenuSize = getDriver().findElements(parentMenuBy).size();
                for(int j = 1; j <= subMenuSize; j++) {
                    String nextSubItemXpath = getSubMenuItemXpath(nextItemXpath, j);
                    By nextSubMenuItem = By.xpath(nextSubItemXpath);
                    getDriver().findElement(nextSubMenuItem).click();
                }
            }
        }
    }






}
