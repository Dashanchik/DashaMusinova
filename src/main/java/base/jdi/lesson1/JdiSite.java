package base.jdi.lesson1;

import base.jdi.lesson1.pages.IndexPageJdi;
import com.epam.jdi.light.elements.pageobjects.annotations.JSite;
import com.epam.jdi.light.elements.pageobjects.annotations.Url;

@JSite("https://epam.github.io/JDI/")
public class JdiSite {

    @Url("index.html")
    public static IndexPageJdi indexPageJdi;
}
