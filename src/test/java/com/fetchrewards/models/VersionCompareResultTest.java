package com.fetchrewards.models;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import com.fetchrewards.models.VersionCompareResult.Result;

public class VersionCompareResultTest {

    @Test
    public void testGettersAndSetters() {
        VersionCompareResult vcr = new VersionCompareResult();
        vcr.setResult(Result.equal);
        vcr.setValid(true);

        assertNotNull(vcr.getMessages());
        assertTrue(vcr.isValid());
        assertEquals(vcr.getResult(), Result.equal);

    }

}
