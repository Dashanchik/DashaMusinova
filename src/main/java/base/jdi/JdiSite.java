package base.jdi;

import base.jdi.pages.IndexPageJdi;
import base.page_objects.MetalsAndColorsPage;
import com.epam.jdi.light.elements.pageobjects.annotations.JSite;
import com.epam.jdi.light.elements.pageobjects.annotations.Url;

@JSite("https://epam.github.io/JDI/")
public class JdiSite {

    @Url("index.html")
    public static IndexPageJdi indexPageJdi;

    @Url("metals-colors.html")
    public static MetalsAndColorsPage metalsAndColorsPage;
}
