package com.java.junit;

import static org.junit.Assert.*;
import org.junit.Test;

import java.util.Date;

public class VendorTest {

    @Test
    public void testGettersAndSetters() {
        int vendorId = 1;
        String vendorName = "Anirudh";
        String vendorCity = "Banglore";
        String vendorEmail = "anirudh@gmail.com";
        String vendorMobile = "6207414098";
        String vendorStatus = "Active";
        Date vendorStartedDate = new Date();
        double vendorRating = 4.5;
        String vendorReview = "Good";

        Vendor vendor = new Vendor();

        vendor.setVendorId(vendorId);
        vendor.setVendorName(vendorName);
        vendor.setVendorCity(vendorCity);
        vendor.setVendorEmail(vendorEmail);
        vendor.setVendorMobile(vendorMobile);
        vendor.setVendorStatus(vendorStatus);
        vendor.setVendorStartedDate(vendorStartedDate);
        vendor.setVendorRating(vendorRating);
        vendor.setVendorReview(vendorReview);

        assertEquals(vendorId, vendor.getVendorId());
        assertEquals(vendorName, vendor.getVendorName());
        assertEquals(vendorCity, vendor.getVendorCity());
        assertEquals(vendorEmail, vendor.getVendorEmail());
        assertEquals(vendorMobile, vendor.getVendorMobile());
        assertEquals(vendorStatus, vendor.getVendorStatus());
        assertEquals(vendorStartedDate, vendor.getVendorStartedDate());
        assertEquals(vendorRating, vendor.getVendorRating(), 0.001);
        assertEquals(vendorReview, vendor.getVendorReview());
    }

    @Test
    public void testDefaultConstructor() {
        Vendor vendor = new Vendor();

        assertEquals(0, vendor.getVendorId());
        assertNull(vendor.getVendorName());
        assertNull(vendor.getVendorCity());
        assertNull(vendor.getVendorEmail());
        assertNull(vendor.getVendorMobile());
        assertNull(vendor.getVendorStatus());
        assertNull(vendor.getVendorStartedDate());
        assertEquals(0.0, vendor.getVendorRating(), 0.001);
        assertNull(vendor.getVendorReview());
    }

    @Test
    public void testToString() {
        int vendorId = 1;
        String vendorName = "Anirudh";
        String vendorCity = "Banglore";
        String vendorEmail = "anirudh@gmail.com";
        String vendorMobile = "6207414098";
        String vendorStatus = "Active";
        Date vendorStartedDate = new Date();
        double vendorRating = 4.5;
        String vendorReview = "Good";

        Vendor vendor = new Vendor(vendorId, vendorName, vendorCity, vendorEmail, vendorMobile, vendorStatus,
                vendorStartedDate, vendorRating, vendorReview);

        String expectedToString = "Vendor [vendorId=1, vendorName=Anirudh, vendorCity=Banglore, vendorEmail=anirudh@gmail.com, vendorMobile=6207414098, vendorStatus=Active, vendorStartedDate=" + vendorStartedDate + ", vendorRating=4.5, vendorReview=Good]";

        assertEquals(expectedToString, vendor.toString());
    }

    @Test
    public void testHashCode() {
        int vendorId = 1;
        String vendorName = "Anirudh";
        String vendorCity = "Bangalore";
        String vendorEmail = "anirudh@gmail.com";
        String vendorMobile = "6207414098";
        String vendorStatus = "Active";
        Date vendorStartedDate = new Date();
        double vendorRating = 4.5;
        String vendorReview = "Good";

        Vendor vendor1 = new Vendor(vendorId, vendorName, vendorCity, vendorEmail, vendorMobile, vendorStatus,
                vendorStartedDate, vendorRating, vendorReview);
         Vendor vendor2 = new Vendor(vendorId, vendorName, vendorCity,vendorEmail,vendorMobile,vendorStatus,vendorStartedDate,vendorRating,vendorReview);
        assertEquals(vendor1.hashCode(), vendor2.hashCode());
    }

        @Test
        public void testEquals() {
            int vendorId = 1;
            String vendorName = "Anirudh";
            String vendorCity = "Banglore";
            String vendorEmail = "anirudh@gmail.com";
            String vendorMobile = "6207414098";
            String vendorStatus = "Active";
            Date vendorStartedDate = new Date();
            double vendorRating = 4.5;
            String vendorReview = "Good";

            Vendor vendor1 = new Vendor(vendorId, vendorName, vendorCity, vendorEmail, vendorMobile, vendorStatus,
                    vendorStartedDate, vendorRating, vendorReview);

            Vendor vendor2 = new Vendor(vendorId, vendorName, vendorCity, vendorEmail, vendorMobile, vendorStatus,
                    vendorStartedDate, vendorRating, vendorReview);

            Vendor vendor3 = new Vendor(2, "Ariz", "Bhubaneswar", "Ariz@gmail.com", "9876543209", "Inactive",
                    new Date(), 3.0, "Not so good");

//            assertEquals(vendor1, vendor2);
            assertTrue(vendor1.equals(vendor2));
            assertFalse(vendor1.equals(vendor3));
            assertFalse(vendor1.equals(null));
            assertTrue(vendor1.equals(vendor1));
            assertFalse(vendor1.equals(new Vendor(3, "Harsh", "Bihar", "Harsh@gmail.com", "9876543210", "Active",
                   new Date(), 4.0, "Great")));
        }
    }



 

    






