package zh.ffminx.study.java.database;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * @author fengmin.xu E-mail: fengmin.xu@56qq.com
 * @since 2017-12-14 17:13
 */
public class DymaticDatabase extends AbstractRoutingDataSource {
    
    @Override
    protected Object determineCurrentLookupKey() {
        return null;
    }
    
}
