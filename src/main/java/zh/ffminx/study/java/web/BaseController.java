package zh.ffminx.study.java.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import zh.ffminx.study.java.classloader.CustomerClassLoader;

/**
 * @author fengmin.xu E-mail: fengmin.xu@56qq.com
 * @since 2017-12-12 17:38
 */
@RestController
public class BaseController {
    
    @RequestMapping(value = "/", method = {RequestMethod.POST, RequestMethod.GET})
    public void getClassLoader() {
        CustomerClassLoader customerClassLoader = new CustomerClassLoader();
        customerClassLoader.printClassLoader();
    }
    
}
