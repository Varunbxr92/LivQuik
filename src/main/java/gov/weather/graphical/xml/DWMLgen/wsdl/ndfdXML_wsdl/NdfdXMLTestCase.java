/**
 * NdfdXMLTestCase.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package gov.weather.graphical.xml.DWMLgen.wsdl.ndfdXML_wsdl;

public class NdfdXMLTestCase extends junit.framework.TestCase {
    public NdfdXMLTestCase(java.lang.String name) {
        super(name);
    }

    public void testndfdXMLPortWSDL() throws Exception {
        javax.xml.rpc.ServiceFactory serviceFactory = javax.xml.rpc.ServiceFactory.newInstance();
        java.net.URL url = new java.net.URL(new gov.weather.graphical.xml.DWMLgen.wsdl.ndfdXML_wsdl.NdfdXMLLocator().getndfdXMLPortAddress() + "?WSDL");
        javax.xml.rpc.Service service = serviceFactory.createService(url, new gov.weather.graphical.xml.DWMLgen.wsdl.ndfdXML_wsdl.NdfdXMLLocator().getServiceName());
        assertTrue(service != null);
    }

    public void test1ndfdXMLPortNDFDgen() throws Exception {
        gov.weather.graphical.xml.DWMLgen.wsdl.ndfdXML_wsdl.NdfdXMLBindingStub binding;
        try {
            binding = (gov.weather.graphical.xml.DWMLgen.wsdl.ndfdXML_wsdl.NdfdXMLBindingStub)
                          new gov.weather.graphical.xml.DWMLgen.wsdl.ndfdXML_wsdl.NdfdXMLLocator().getndfdXMLPort();
        }
        catch (javax.xml.rpc.ServiceException jre) {
            if(jre.getLinkedCause()!=null)
                jre.getLinkedCause().printStackTrace();
            throw new junit.framework.AssertionFailedError("JAX-RPC ServiceException caught: " + jre);
        }
        assertNotNull("binding is null", binding);

        // Time out after a minute
        binding.setTimeout(60000);

        // Test operation
        java.lang.String value = null;
        value = binding.NDFDgen(new java.math.BigDecimal(0), new java.math.BigDecimal(0), gov.weather.graphical.xml.DWMLgen.schema.DWML_xsd.ProductType.value1, java.util.Calendar.getInstance(), java.util.Calendar.getInstance(), gov.weather.graphical.xml.DWMLgen.schema.DWML_xsd.UnitType.e, new gov.weather.graphical.xml.DWMLgen.schema.DWML_xsd.WeatherParametersType());
        // TBD - validate results
    }

    public void test2ndfdXMLPortNDFDgenByDay() throws Exception {
        gov.weather.graphical.xml.DWMLgen.wsdl.ndfdXML_wsdl.NdfdXMLBindingStub binding;
        try {
            binding = (gov.weather.graphical.xml.DWMLgen.wsdl.ndfdXML_wsdl.NdfdXMLBindingStub)
                          new gov.weather.graphical.xml.DWMLgen.wsdl.ndfdXML_wsdl.NdfdXMLLocator().getndfdXMLPort();
        }
        catch (javax.xml.rpc.ServiceException jre) {
            if(jre.getLinkedCause()!=null)
                jre.getLinkedCause().printStackTrace();
            throw new junit.framework.AssertionFailedError("JAX-RPC ServiceException caught: " + jre);
        }
        assertNotNull("binding is null", binding);

        // Time out after a minute
        binding.setTimeout(60000);

        // Test operation
        java.lang.String value = null;
        value = binding.NDFDgenByDay(new java.math.BigDecimal(0), new java.math.BigDecimal(0), new java.util.Date(), new java.math.BigInteger("0"), gov.weather.graphical.xml.DWMLgen.schema.DWML_xsd.UnitType.e, gov.weather.graphical.xml.DWMLgen.schema.DWML_xsd.FormatType.value1);
        // TBD - validate results
    }

    public void test3ndfdXMLPortNDFDgenLatLonList() throws Exception {
        gov.weather.graphical.xml.DWMLgen.wsdl.ndfdXML_wsdl.NdfdXMLBindingStub binding;
        try {
            binding = (gov.weather.graphical.xml.DWMLgen.wsdl.ndfdXML_wsdl.NdfdXMLBindingStub)
                          new gov.weather.graphical.xml.DWMLgen.wsdl.ndfdXML_wsdl.NdfdXMLLocator().getndfdXMLPort();
        }
        catch (javax.xml.rpc.ServiceException jre) {
            if(jre.getLinkedCause()!=null)
                jre.getLinkedCause().printStackTrace();
            throw new junit.framework.AssertionFailedError("JAX-RPC ServiceException caught: " + jre);
        }
        assertNotNull("binding is null", binding);

        // Time out after a minute
        binding.setTimeout(60000);

        // Test operation
        java.lang.String value = null;
        value = binding.NDFDgenLatLonList(new java.lang.String(), gov.weather.graphical.xml.DWMLgen.schema.DWML_xsd.ProductType.value1, java.util.Calendar.getInstance(), java.util.Calendar.getInstance(), gov.weather.graphical.xml.DWMLgen.schema.DWML_xsd.UnitType.e, new gov.weather.graphical.xml.DWMLgen.schema.DWML_xsd.WeatherParametersType());
        // TBD - validate results
    }

    public void test4ndfdXMLPortNDFDgenByDayLatLonList() throws Exception {
        gov.weather.graphical.xml.DWMLgen.wsdl.ndfdXML_wsdl.NdfdXMLBindingStub binding;
        try {
            binding = (gov.weather.graphical.xml.DWMLgen.wsdl.ndfdXML_wsdl.NdfdXMLBindingStub)
                          new gov.weather.graphical.xml.DWMLgen.wsdl.ndfdXML_wsdl.NdfdXMLLocator().getndfdXMLPort();
        }
        catch (javax.xml.rpc.ServiceException jre) {
            if(jre.getLinkedCause()!=null)
                jre.getLinkedCause().printStackTrace();
            throw new junit.framework.AssertionFailedError("JAX-RPC ServiceException caught: " + jre);
        }
        assertNotNull("binding is null", binding);

        // Time out after a minute
        binding.setTimeout(60000);

        // Test operation
        java.lang.String value = null;
        String lat = "-97.6 36.2";
//        value = binding.NDFDgenByDayLatLonList(new java.lang.String(), new java.util.Date(), new java.math.BigInteger("0"), gov.weather.graphical.xml.DWMLgen.schema.DWML_xsd.UnitType.e, gov.weather.graphical.xml.DWMLgen.schema.DWML_xsd.FormatType.value1);
        value = binding.NDFDgenByDayLatLonList(lat, new java.util.Date(), new java.math.BigInteger("2"), gov.weather.graphical.xml.DWMLgen.schema.DWML_xsd.UnitType.e, gov.weather.graphical.xml.DWMLgen.schema.DWML_xsd.FormatType.value1);
        // TBD - validate results
        System.out.println(value);
    }

    public void test5ndfdXMLPortGmlLatLonList() throws Exception {
        gov.weather.graphical.xml.DWMLgen.wsdl.ndfdXML_wsdl.NdfdXMLBindingStub binding;
        try {
            binding = (gov.weather.graphical.xml.DWMLgen.wsdl.ndfdXML_wsdl.NdfdXMLBindingStub)
                          new gov.weather.graphical.xml.DWMLgen.wsdl.ndfdXML_wsdl.NdfdXMLLocator().getndfdXMLPort();
        }
        catch (javax.xml.rpc.ServiceException jre) {
            if(jre.getLinkedCause()!=null)
                jre.getLinkedCause().printStackTrace();
            throw new junit.framework.AssertionFailedError("JAX-RPC ServiceException caught: " + jre);
        }
        assertNotNull("binding is null", binding);

        // Time out after a minute
        binding.setTimeout(60000);

        // Test operation
        java.lang.String value = null;
        value = binding.gmlLatLonList(new java.lang.String(), java.util.Calendar.getInstance(), gov.weather.graphical.xml.DWMLgen.schema.DWML_xsd.FeatureTypeType.Forecast_Gml2Point, new gov.weather.graphical.xml.DWMLgen.schema.DWML_xsd.WeatherParametersType());
        // TBD - validate results
    }

    public void test6ndfdXMLPortGmlTimeSeries() throws Exception {
        gov.weather.graphical.xml.DWMLgen.wsdl.ndfdXML_wsdl.NdfdXMLBindingStub binding;
        try {
            binding = (gov.weather.graphical.xml.DWMLgen.wsdl.ndfdXML_wsdl.NdfdXMLBindingStub)
                          new gov.weather.graphical.xml.DWMLgen.wsdl.ndfdXML_wsdl.NdfdXMLLocator().getndfdXMLPort();
        }
        catch (javax.xml.rpc.ServiceException jre) {
            if(jre.getLinkedCause()!=null)
                jre.getLinkedCause().printStackTrace();
            throw new junit.framework.AssertionFailedError("JAX-RPC ServiceException caught: " + jre);
        }
        assertNotNull("binding is null", binding);

        // Time out after a minute
        binding.setTimeout(60000);

        // Test operation
        java.lang.String value = null;
        value = binding.gmlTimeSeries(new java.lang.String(), java.util.Calendar.getInstance(), java.util.Calendar.getInstance(), gov.weather.graphical.xml.DWMLgen.schema.DWML_xsd.CompTypeType.IsEqual, gov.weather.graphical.xml.DWMLgen.schema.DWML_xsd.FeatureTypeType.Forecast_Gml2Point, new java.lang.String());
        // TBD - validate results
    }

    public void test7ndfdXMLPortLatLonListSubgrid() throws Exception {
        gov.weather.graphical.xml.DWMLgen.wsdl.ndfdXML_wsdl.NdfdXMLBindingStub binding;
        try {
            binding = (gov.weather.graphical.xml.DWMLgen.wsdl.ndfdXML_wsdl.NdfdXMLBindingStub)
                          new gov.weather.graphical.xml.DWMLgen.wsdl.ndfdXML_wsdl.NdfdXMLLocator().getndfdXMLPort();
        }
        catch (javax.xml.rpc.ServiceException jre) {
            if(jre.getLinkedCause()!=null)
                jre.getLinkedCause().printStackTrace();
            throw new junit.framework.AssertionFailedError("JAX-RPC ServiceException caught: " + jre);
        }
        assertNotNull("binding is null", binding);

        // Time out after a minute
        binding.setTimeout(60000);

        // Test operation
        java.lang.String value = null;
        value = binding.latLonListSubgrid(new java.math.BigDecimal(0), new java.math.BigDecimal(0), new java.math.BigDecimal(0), new java.math.BigDecimal(0), new java.math.BigDecimal(0));
        // TBD - validate results
    }

    public void test8ndfdXMLPortLatLonListLine() throws Exception {
        gov.weather.graphical.xml.DWMLgen.wsdl.ndfdXML_wsdl.NdfdXMLBindingStub binding;
        try {
            binding = (gov.weather.graphical.xml.DWMLgen.wsdl.ndfdXML_wsdl.NdfdXMLBindingStub)
                          new gov.weather.graphical.xml.DWMLgen.wsdl.ndfdXML_wsdl.NdfdXMLLocator().getndfdXMLPort();
        }
        catch (javax.xml.rpc.ServiceException jre) {
            if(jre.getLinkedCause()!=null)
                jre.getLinkedCause().printStackTrace();
            throw new junit.framework.AssertionFailedError("JAX-RPC ServiceException caught: " + jre);
        }
        assertNotNull("binding is null", binding);

        // Time out after a minute
        binding.setTimeout(60000);

        // Test operation
        java.lang.String value = null;
        value = binding.latLonListLine(new java.math.BigDecimal(0), new java.math.BigDecimal(0), new java.math.BigDecimal(0), new java.math.BigDecimal(0));
        // TBD - validate results
    }

    public void test9ndfdXMLPortLatLonListZipCode() throws Exception {
        gov.weather.graphical.xml.DWMLgen.wsdl.ndfdXML_wsdl.NdfdXMLBindingStub binding;
        try {
            binding = (gov.weather.graphical.xml.DWMLgen.wsdl.ndfdXML_wsdl.NdfdXMLBindingStub)
                          new gov.weather.graphical.xml.DWMLgen.wsdl.ndfdXML_wsdl.NdfdXMLLocator().getndfdXMLPort();
        }
        catch (javax.xml.rpc.ServiceException jre) {
            if(jre.getLinkedCause()!=null)
                jre.getLinkedCause().printStackTrace();
            throw new junit.framework.AssertionFailedError("JAX-RPC ServiceException caught: " + jre);
        }
        assertNotNull("binding is null", binding);

        // Time out after a minute
        binding.setTimeout(60000);

        // Test operation
        java.lang.String value = null;
        value = binding.latLonListZipCode(new java.lang.String());
        // TBD - validate results
    }

    public void test10ndfdXMLPortLatLonListSquare() throws Exception {
        gov.weather.graphical.xml.DWMLgen.wsdl.ndfdXML_wsdl.NdfdXMLBindingStub binding;
        try {
            binding = (gov.weather.graphical.xml.DWMLgen.wsdl.ndfdXML_wsdl.NdfdXMLBindingStub)
                          new gov.weather.graphical.xml.DWMLgen.wsdl.ndfdXML_wsdl.NdfdXMLLocator().getndfdXMLPort();
        }
        catch (javax.xml.rpc.ServiceException jre) {
            if(jre.getLinkedCause()!=null)
                jre.getLinkedCause().printStackTrace();
            throw new junit.framework.AssertionFailedError("JAX-RPC ServiceException caught: " + jre);
        }
        assertNotNull("binding is null", binding);

        // Time out after a minute
        binding.setTimeout(60000);

        // Test operation
        java.lang.String value = null;
        value = binding.latLonListSquare(new java.math.BigDecimal(0), new java.math.BigDecimal(0), new java.math.BigDecimal(0), new java.math.BigDecimal(0), new java.math.BigDecimal(0));
        // TBD - validate results
        System.out.println(value);
    }

    public void test11ndfdXMLPortCornerPoints() throws Exception {
        gov.weather.graphical.xml.DWMLgen.wsdl.ndfdXML_wsdl.NdfdXMLBindingStub binding;
        try {
            binding = (gov.weather.graphical.xml.DWMLgen.wsdl.ndfdXML_wsdl.NdfdXMLBindingStub)
                          new gov.weather.graphical.xml.DWMLgen.wsdl.ndfdXML_wsdl.NdfdXMLLocator().getndfdXMLPort();
        }
        catch (javax.xml.rpc.ServiceException jre) {
            if(jre.getLinkedCause()!=null)
                jre.getLinkedCause().printStackTrace();
            throw new junit.framework.AssertionFailedError("JAX-RPC ServiceException caught: " + jre);
        }
        assertNotNull("binding is null", binding);

        // Time out after a minute
        binding.setTimeout(60000);

        // Test operation
        java.lang.String value = null;
        value = binding.cornerPoints(gov.weather.graphical.xml.DWMLgen.schema.DWML_xsd.SectorType.conus);
        // TBD - validate results
        System.out.println(value);
    }

    public void test12ndfdXMLPortLatLonListCityNames() throws Exception {
        gov.weather.graphical.xml.DWMLgen.wsdl.ndfdXML_wsdl.NdfdXMLBindingStub binding;
        try {
            binding = (gov.weather.graphical.xml.DWMLgen.wsdl.ndfdXML_wsdl.NdfdXMLBindingStub)
                          new gov.weather.graphical.xml.DWMLgen.wsdl.ndfdXML_wsdl.NdfdXMLLocator().getndfdXMLPort();
        }
        catch (javax.xml.rpc.ServiceException jre) {
            if(jre.getLinkedCause()!=null)
                jre.getLinkedCause().printStackTrace();
            throw new junit.framework.AssertionFailedError("JAX-RPC ServiceException caught: " + jre);
        }
        assertNotNull("binding is null", binding);

        // Time out after a minute
        binding.setTimeout(60000);

        // Test operation
        java.lang.String value = null;
        value = binding.latLonListCityNames(gov.weather.graphical.xml.DWMLgen.schema.DWML_xsd.DisplayLevelType.value1);
        // TBD - validate results
        System.out.println(value);
    }

}
