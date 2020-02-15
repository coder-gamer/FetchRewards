package com.fetchrewards.validator;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;
import com.fetchrewards.models.VersionCompare;
import com.fetchrewards.models.VersionCompareResult;

public class VersionValidatorImplTest {

    private VersionValidator versionValidator;

    @Before
    public void setup() {
        versionValidator = new VersionValidatorImpl();
    }

    @Test
    public void testValidateVersionInvalidLength() {
        VersionCompare vc = new VersionCompare();
        vc.setVersion1("asdfghjklzxcvbnmqwertyuiasdfghjkasdfgh");
        vc.setVersion2("1.1.1.1");

        VersionCompareResult result = versionValidator.validateVersions(vc);

        assertFalse(result.isValid());
    }

    @Test
    public void testValidateVersionInvalidVersion() {
        VersionCompare vc = new VersionCompare();
        vc.setVersion1(".1.1");
        vc.setVersion2("1.1.1.1");

        VersionCompareResult result = versionValidator.validateVersions(vc);

        assertFalse(result.isValid());
    }

    @Test
    public void testValidateVersionInvalidNull() {
        VersionCompare vc = new VersionCompare();
        vc.setVersion1(null);
        vc.setVersion2("1.1.1.1");

        VersionCompareResult result = versionValidator.validateVersions(vc);

        assertFalse(result.isValid());
    }


    @Test
    public void testValidateVersionValidCase() {
        VersionCompare vc = new VersionCompare();
        vc.setVersion1("1.0.1");
        vc.setVersion2("1.1.1.1");

        VersionCompareResult result = versionValidator.validateVersions(vc);

        assertTrue(result.isValid());
    }
}
