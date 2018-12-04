package com.example.seleniumtest

import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy

class HomePage {
    @FindBy(tagName = 'label')
    WebElement label
}
