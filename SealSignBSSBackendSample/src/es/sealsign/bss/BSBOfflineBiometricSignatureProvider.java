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
import java.util.UUID;

public class BSBOfflineBiometricSignatureProvider extends AttributeContainer implements KvmSerializable
{
    
    public String account;
    
    public String id;
    
    public UUID instance;
    
    public byte[] offlineBiometricState;
    
    public String providerParameter;
    
    public String uri;

    public BSBOfflineBiometricSignatureProvider ()
    {
    }

    public BSBOfflineBiometricSignatureProvider (java.lang.Object paramObj,BSBExtendedSoapSerializationEnvelope __envelope)
    {
	    
	    if (paramObj == null)
            return;
        AttributeContainer inObj=(AttributeContainer)paramObj;


        SoapObject soapObject=(SoapObject)inObj;  
        if (soapObject.hasProperty("account"))
        {	
	        java.lang.Object obj = soapObject.getProperty("account");
            if (obj != null && obj.getClass().equals(SoapPrimitive.class))
            {
                SoapPrimitive j =(SoapPrimitive) obj;
                if(j.toString()!=null)
                {
                    this.account = j.toString();
                }
	        }
	        else if (obj!= null && obj instanceof String){
                this.account = (String)obj;
            }    
        }
        if (soapObject.hasProperty("id"))
        {	
	        java.lang.Object obj = soapObject.getProperty("id");
            if (obj != null && obj.getClass().equals(SoapPrimitive.class))
            {
                SoapPrimitive j =(SoapPrimitive) obj;
                if(j.toString()!=null)
                {
                    this.id = j.toString();
                }
	        }
	        else if (obj!= null && obj instanceof String){
                this.id = (String)obj;
            }    
        }
        if (soapObject.hasProperty("instance"))
        {	
	        java.lang.Object obj = soapObject.getProperty("instance");
            if (obj != null && obj.getClass().equals(SoapPrimitive.class))
            {
                SoapPrimitive j =(SoapPrimitive) obj;
                if(j.toString()!=null)
                {
                    this.instance = UUID.fromString(j.toString());
                }
	        }
	        else if (obj!= null && obj instanceof UUID){
                this.instance = (UUID)obj;
            }    
        }
        if (soapObject.hasProperty("offlineBiometricState"))
        {	
	        java.lang.Object j = soapObject.getProperty("offlineBiometricState");
	        this.offlineBiometricState = BSBHelper.getBinary(j,false);
        }
        if (soapObject.hasProperty("providerParameter"))
        {	
	        java.lang.Object obj = soapObject.getProperty("providerParameter");
            if (obj != null && obj.getClass().equals(SoapPrimitive.class))
            {
                SoapPrimitive j =(SoapPrimitive) obj;
                if(j.toString()!=null)
                {
                    this.providerParameter = j.toString();
                }
	        }
	        else if (obj!= null && obj instanceof String){
                this.providerParameter = (String)obj;
            }    
        }
        if (soapObject.hasProperty("uri"))
        {	
	        java.lang.Object obj = soapObject.getProperty("uri");
            if (obj != null && obj.getClass().equals(SoapPrimitive.class))
            {
                SoapPrimitive j =(SoapPrimitive) obj;
                if(j.toString()!=null)
                {
                    this.uri = j.toString();
                }
	        }
	        else if (obj!= null && obj instanceof String){
                this.uri = (String)obj;
            }    
        }


    }

    @Override
    public java.lang.Object getProperty(int propertyIndex) {
        //!!!!! If you have a compilation error here then you are using old version of ksoap2 library. Please upgrade to the latest version.
        //!!!!! You can find a correct version in Lib folder from generated zip file!!!!!
        if(propertyIndex==0)
        {
            return this.account!=null?this.account:SoapPrimitive.NullSkip;
        }
        if(propertyIndex==1)
        {
            return this.id!=null?this.id:SoapPrimitive.NullSkip;
        }
        if(propertyIndex==2)
        {
            return this.instance!=null?this.instance:SoapPrimitive.NullSkip;
        }
        if(propertyIndex==3)
        {
            return this.offlineBiometricState!=null?org.kobjects.base64.Base64.encode(this.offlineBiometricState):SoapPrimitive.NullSkip;
        }
        if(propertyIndex==4)
        {
            return this.providerParameter!=null?this.providerParameter:SoapPrimitive.NullSkip;
        }
        if(propertyIndex==5)
        {
            return this.uri!=null?this.uri:SoapPrimitive.NullSkip;
        }
        return null;
    }


    @Override
    public int getPropertyCount() {
        return 6;
    }

    @Override
    public void getPropertyInfo(int propertyIndex, @SuppressWarnings("rawtypes") Hashtable arg1, PropertyInfo info)
    {
        if(propertyIndex==0)
        {
            info.type = PropertyInfo.STRING_CLASS;
            info.name = "account";
            info.namespace= "http://schemas.datacontract.org/2004/07/SealSignBSSService";
        }
        if(propertyIndex==1)
        {
            info.type = PropertyInfo.STRING_CLASS;
            info.name = "id";
            info.namespace= "http://schemas.datacontract.org/2004/07/SealSignBSSService";
        }
        if(propertyIndex==2)
        {
            info.type = PropertyInfo.STRING_CLASS;
            info.name = "instance";
            info.namespace= "http://schemas.datacontract.org/2004/07/SealSignBSSService";
        }
        if(propertyIndex==3)
        {
            info.type = PropertyInfo.STRING_CLASS;
            info.name = "offlineBiometricState";
            info.namespace= "http://schemas.datacontract.org/2004/07/SealSignBSSService";
        }
        if(propertyIndex==4)
        {
            info.type = PropertyInfo.STRING_CLASS;
            info.name = "providerParameter";
            info.namespace= "http://schemas.datacontract.org/2004/07/SealSignBSSService";
        }
        if(propertyIndex==5)
        {
            info.type = PropertyInfo.STRING_CLASS;
            info.name = "uri";
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