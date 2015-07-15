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

public class BSBBiometricSignatureParameters extends AttributeContainer implements KvmSerializable
{
    
    public BSBArrayOfBiometricImageParameters advancedImageParameters=new BSBArrayOfBiometricImageParameters();
    
    public String documentPassword;
    
    public BSBBiometricImageParameters imageParameters;

    public BSBBiometricSignatureParameters ()
    {
    }

    public BSBBiometricSignatureParameters (java.lang.Object paramObj,BSBExtendedSoapSerializationEnvelope __envelope)
    {
	    
	    if (paramObj == null)
            return;
        AttributeContainer inObj=(AttributeContainer)paramObj;


        SoapObject soapObject=(SoapObject)inObj;  
        if (soapObject.hasProperty("advancedImageParameters"))
        {	
	        java.lang.Object j = soapObject.getProperty("advancedImageParameters");
	        this.advancedImageParameters = new BSBArrayOfBiometricImageParameters(j,__envelope);
        }
        if (soapObject.hasProperty("documentPassword"))
        {	
	        java.lang.Object obj = soapObject.getProperty("documentPassword");
            if (obj != null && obj.getClass().equals(SoapPrimitive.class))
            {
                SoapPrimitive j =(SoapPrimitive) obj;
                if(j.toString()!=null)
                {
                    this.documentPassword = j.toString();
                }
	        }
	        else if (obj!= null && obj instanceof String){
                this.documentPassword = (String)obj;
            }    
        }
        if (soapObject.hasProperty("imageParameters"))
        {	
	        java.lang.Object j = soapObject.getProperty("imageParameters");
	        this.imageParameters = (BSBBiometricImageParameters)__envelope.get(j,BSBBiometricImageParameters.class);
        }


    }

    @Override
    public java.lang.Object getProperty(int propertyIndex) {
        //!!!!! If you have a compilation error here then you are using old version of ksoap2 library. Please upgrade to the latest version.
        //!!!!! You can find a correct version in Lib folder from generated zip file!!!!!
        if(propertyIndex==0)
        {
            return this.advancedImageParameters!=null?this.advancedImageParameters:SoapPrimitive.NullSkip;
        }
        if(propertyIndex==1)
        {
            return this.documentPassword!=null?this.documentPassword:SoapPrimitive.NullSkip;
        }
        if(propertyIndex==2)
        {
            return this.imageParameters!=null?this.imageParameters:SoapPrimitive.NullSkip;
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
            info.type = PropertyInfo.VECTOR_CLASS;
            info.name = "advancedImageParameters";
            info.namespace= "http://schemas.datacontract.org/2004/07/SealSignBSSTypes";
        }
        if(propertyIndex==1)
        {
            info.type = PropertyInfo.STRING_CLASS;
            info.name = "documentPassword";
            info.namespace= "http://schemas.datacontract.org/2004/07/SealSignBSSTypes";
        }
        if(propertyIndex==2)
        {
            info.type = BSBBiometricImageParameters.class;
            info.name = "imageParameters";
            info.namespace= "http://schemas.datacontract.org/2004/07/SealSignBSSTypes";
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
