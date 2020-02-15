package com.fetchrewards.models;

import static org.junit.Assert.assertEquals;
import org.junit.Test;


public class VersionCompareTest {

    @Test
    public void testGettersAndSetters() {
        VersionCompare vc = new VersionCompare();
        vc.setVersion1("1.0.1");
        vc.setVersion2("1.1.1");

        assertEquals(vc.getVersion1(), "1.0.1");
        assertEquals(vc.getVersion2(), "1.1.1");
    }

}
