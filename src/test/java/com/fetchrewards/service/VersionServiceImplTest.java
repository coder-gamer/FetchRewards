package com.fetchrewards.service;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import com.fetchrewards.models.VersionCompare;
import com.fetchrewards.models.VersionCompareResult;
import com.fetchrewards.models.VersionCompareResult.Result;

public class VersionServiceImplTest {

    private VersionService versionService;

    @Before
    public void setup() {
        versionService = new VersionServiceImpl();
    }

    @Test
    public void testCompareVersionBeforeCase1() {
        VersionCompare vc = new VersionCompare();
        vc.setVersion1("1.0.0");
        vc.setVersion2("1.0.1");

        VersionCompareResult vcr = versionService.compareVersions(vc);

        assertEquals(vcr.getResult(), Result.before);
    }

    @Test
    public void testCompareVersionBeforeCase2() {
        VersionCompare vc = new VersionCompare();
        vc.setVersion1("1.0");
        vc.setVersion2("1.0.1");

        VersionCompareResult vcr = versionService.compareVersions(vc);

        assertEquals(vcr.getResult(), Result.before);
    }

    @Test
    public void testCompareVersionBeforeCase3() {
        VersionCompare vc = new VersionCompare();
        vc.setVersion1("1");
        vc.setVersion2("1.0.1");

        VersionCompareResult vcr = versionService.compareVersions(vc);

        assertEquals(vcr.getResult(), Result.before);
    }

    @Test
    public void testCompareVersionAfterCase1() {
        VersionCompare vc = new VersionCompare();
        vc.setVersion1("2.0");
        vc.setVersion2("1.0.0");

        VersionCompareResult vcr = versionService.compareVersions(vc);

        assertEquals(vcr.getResult(), Result.after);
    }

    @Test
    public void testCompareVersionAfterCase2() {
        VersionCompare vc = new VersionCompare();
        vc.setVersion1("2.0");
        vc.setVersion2("1.0.99999");

        VersionCompareResult vcr = versionService.compareVersions(vc);

        assertEquals(vcr.getResult(), Result.after);
    }

    @Test
    public void testCompareVersionAfterCase3() {
        VersionCompare vc = new VersionCompare();
        vc.setVersion1("2.0");
        vc.setVersion2("1.987.567");

        VersionCompareResult vcr = versionService.compareVersions(vc);

        assertEquals(vcr.getResult(), Result.after);
    }


    @Test
    public void testCompareVersionEqualsCase1() {
        VersionCompare vc = new VersionCompare();
        vc.setVersion1("2.0");
        vc.setVersion2("2.0");

        VersionCompareResult vcr = versionService.compareVersions(vc);

        assertEquals(vcr.getResult(), Result.equal);
    }

    @Test
    public void testCompareVersionEqualsCase2() {
        VersionCompare vc = new VersionCompare();
        vc.setVersion1("2");
        vc.setVersion2("2.0");

        VersionCompareResult vcr = versionService.compareVersions(vc);

        assertEquals(vcr.getResult(), Result.equal);
    }

    @Test
    public void testCompareVersionEqualsCase3() {
        VersionCompare vc = new VersionCompare();
        vc.setVersion1("2");
        vc.setVersion2("2.0.0");

        VersionCompareResult vcr = versionService.compareVersions(vc);

        assertEquals(vcr.getResult(), Result.equal);
    }

}
