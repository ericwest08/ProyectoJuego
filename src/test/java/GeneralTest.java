import org.junit.Test;

import java.util.UUID;
import org.apache.log4j.Logger;

public class GeneralTest {

    final static Logger log = Logger.getLogger(GeneralTest.class.getName());

    @Test
    public void setIduserTest() {
        String iduser = UUID.randomUUID().toString();

        int size = iduser.length();
        log.info(iduser);
        log.info(size);
    }
}
