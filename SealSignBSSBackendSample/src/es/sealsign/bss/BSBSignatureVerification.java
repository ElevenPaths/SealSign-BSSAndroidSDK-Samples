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

public class BSBSignatureVerification extends AttributeContainer implements KvmSerializable
{
    
    public BSBEnums.VerificationResult result;
    
    public BSBArrayOfSignatureReference signatures=new BSBArrayOfSignatureReference();

    public BSBSignatureVerification ()
    {
    }

    public BSBSignatureVerification (java.lang.Object paramObj,BSBExtendedSoapSerializationEnvelope __envelope)
    {
	    
	    if (paramObj == null)
            return;
        AttributeContainer inObj=(AttributeContainer)paramObj;


        SoapObject soapObject=(SoapObject)inObj;  
        if (soapObject.hasProperty("result"))
        {	
	        java.lang.Object obj = soapObject.getProperty("result");
            if (obj != null && obj.getClass().equals(SoapPrimitive.class))
            {
                SoapPrimitive j =(SoapPrimitive) obj;
                if(j.toString()!=null)
                {
                    this.result = BSBEnums.VerificationResult.fromString(j.toString());
                }
	        }
	        else if (obj!= null && obj instanceof BSBEnums.VerificationResult){
                this.result = (BSBEnums.VerificationResult)obj;
            }    
        }
        if (soapObject.hasProperty("signatures"))
        {	
	        java.lang.Object j = soapObject.getProperty("signatures");
	        this.signatures = new BSBArrayOfSignatureReference(j,__envelope);
        }


    }

    @Override
    public java.lang.Object getProperty(int propertyIndex) {
        //!!!!! If you have a compilation error here then you are using old version of ksoap2 library. Please upgrade to the latest version.
        //!!!!! You can find a correct version in Lib folder from generated zip file!!!!!
        if(propertyIndex==0)
        {
            return this.result!=null?this.result.toString():SoapPrimitive.NullSkip;
        }
        if(propertyIndex==1)
        {
            return this.signatures!=null?this.signatures:SoapPrimitive.NullSkip;
        }
        return null;
    }


    @Override
    public int getPropertyCount() {
        return 2;
    }

    @Override
    public void getPropertyInfo(int propertyIndex, @SuppressWarnings("rawtypes") Hashtable arg1, PropertyInfo info)
    {
        if(propertyIndex==0)
        {
            info.type = PropertyInfo.STRING_CLASS;
            info.name = "result";
            info.namespace= "http://schemas.datacontract.org/2004/07/SealSignDSSTypes";
        }
        if(propertyIndex==1)
        {
            info.type = PropertyInfo.VECTOR_CLASS;
            info.name = "signatures";
            info.namespace= "http://schemas.datacontract.org/2004/07/SealSignDSSTypes";
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
