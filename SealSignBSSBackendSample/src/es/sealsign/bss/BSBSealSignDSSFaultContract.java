package es.sealsign.bss;

//----------------------------------------------------
//
// Generated by www.easywsdl.com
// Version: 4.1.7.0
//
// Created by Quasar Development at 15-06-2015
//
//---------------------------------------------------


import java.util.Hashtable;
import org.ksoap2.serialization.*;

public class BSBSealSignDSSFaultContract extends java.lang.Exception implements KvmSerializable
{
    
    public Integer errorCode;
    
    public String message;
    
    public String stackTrace;

    public BSBSealSignDSSFaultContract ()
    {
    }

    public BSBSealSignDSSFaultContract (java.lang.Object paramObj,BSBExtendedSoapSerializationEnvelope __envelope)
    {
	    
	    if (paramObj == null)
            return;
        AttributeContainer inObj=(AttributeContainer)paramObj;


        SoapObject soapObject=(SoapObject)inObj;  
        if (soapObject.hasProperty("errorCode"))
        {	
	        java.lang.Object obj = soapObject.getProperty("errorCode");
            if (obj != null && obj.getClass().equals(SoapPrimitive.class))
            {
                SoapPrimitive j =(SoapPrimitive) obj;
                if(j.toString()!=null)
                {
                    this.errorCode = Integer.parseInt(j.toString());
                }
	        }
	        else if (obj!= null && obj instanceof Integer){
                this.errorCode = (Integer)obj;
            }    
        }
        if (soapObject.hasProperty("message"))
        {	
	        java.lang.Object obj = soapObject.getProperty("message");
            if (obj != null && obj.getClass().equals(SoapPrimitive.class))
            {
                SoapPrimitive j =(SoapPrimitive) obj;
                if(j.toString()!=null)
                {
                    this.message = j.toString();
                }
	        }
	        else if (obj!= null && obj instanceof String){
                this.message = (String)obj;
            }    
        }
        if (soapObject.hasProperty("stackTrace"))
        {	
	        java.lang.Object obj = soapObject.getProperty("stackTrace");
            if (obj != null && obj.getClass().equals(SoapPrimitive.class))
            {
                SoapPrimitive j =(SoapPrimitive) obj;
                if(j.toString()!=null)
                {
                    this.stackTrace = j.toString();
                }
	        }
	        else if (obj!= null && obj instanceof String){
                this.stackTrace = (String)obj;
            }    
        }


    }

    @Override
    public java.lang.Object getProperty(int propertyIndex) {
        //!!!!! If you have a compilation error here then you are using old version of ksoap2 library. Please upgrade to the latest version.
        //!!!!! You can find a correct version in Lib folder from generated zip file!!!!!
        if(propertyIndex==0)
        {
            return this.errorCode!=null?this.errorCode:SoapPrimitive.NullSkip;
        }
        if(propertyIndex==1)
        {
            return this.message!=null?this.message:SoapPrimitive.NullSkip;
        }
        if(propertyIndex==2)
        {
            return this.stackTrace!=null?this.stackTrace:SoapPrimitive.NullSkip;
        }
        return null;
    }


    @Override
    public int getPropertyCount() {
        return 3;
    }

    @Override
    public void getPropertyInfo(int propertyIndex, @SuppressWarnings("rawtypes") Hashtable arg1, PropertyInfo info)
    {
        if(propertyIndex==0)
        {
            info.type = PropertyInfo.INTEGER_CLASS;
            info.name = "errorCode";
            info.namespace= "http://schemas.datacontract.org/2004/07/SealSignBSSService";
        }
        if(propertyIndex==1)
        {
            info.type = PropertyInfo.STRING_CLASS;
            info.name = "message";
            info.namespace= "http://schemas.datacontract.org/2004/07/SealSignBSSService";
        }
        if(propertyIndex==2)
        {
            info.type = PropertyInfo.STRING_CLASS;
            info.name = "stackTrace";
            info.namespace= "http://schemas.datacontract.org/2004/07/SealSignBSSService";
        }
    }
    
    @Override
    public void setProperty(int arg0, java.lang.Object arg1)
    {
    }

    @Override
    public String getInnerText() {
        return null;
    }

    @Override
    public void setInnerText(String s) {

    }
}
