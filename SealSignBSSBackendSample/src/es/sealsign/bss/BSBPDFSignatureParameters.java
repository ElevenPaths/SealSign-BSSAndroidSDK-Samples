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

public class BSBPDFSignatureParameters extends AttributeContainer implements KvmSerializable
{
    
    public String PDFPassword;
    
    public byte[] PDFSignatureBackground;
    
    public Integer PDFSignatureBackgroundHeight=0;
    
    public Boolean PDFSignatureBackgroundStretch=false;
    
    public Integer PDFSignatureBackgroundWidth=0;
    
    public String PDFSignatureFieldName;
    
    public Boolean PDFSignatureFilterOnlyDocSignatures=false;
    
    public Boolean PDFSignatureVisible=false;
    
    public Boolean PDFSignatureWidgetAutoPos=false;
    
    public Boolean PDFSignatureWidgetAutoSize=false;
    
    public Integer PDFSignatureWidgetHeight=0;
    
    public Boolean PDFSignatureWidgetHideText=false;
    
    public Integer PDFSignatureWidgetOffsetX=0;
    
    public Integer PDFSignatureWidgetOffsetY=0;
    
    public Boolean PDFSignatureWidgetOnAllPages=false;
    
    public Boolean PDFSignatureWidgetOnLastPage=false;
    
    public Integer PDFSignatureWidgetOnPage=0;
    
    public Integer PDFSignatureWidgetPageOffset=0;
    
    public Integer PDFSignatureWidgetRotate=0;
    
    public Integer PDFSignatureWidgetWidth=0;

    public BSBPDFSignatureParameters ()
    {
    }

    public BSBPDFSignatureParameters (java.lang.Object paramObj,BSBExtendedSoapSerializationEnvelope __envelope)
    {
	    
	    if (paramObj == null)
            return;
        AttributeContainer inObj=(AttributeContainer)paramObj;


        SoapObject soapObject=(SoapObject)inObj;  
        if (soapObject.hasProperty("PDFPassword"))
        {	
	        java.lang.Object obj = soapObject.getProperty("PDFPassword");
            if (obj != null && obj.getClass().equals(SoapPrimitive.class))
            {
                SoapPrimitive j =(SoapPrimitive) obj;
                if(j.toString()!=null)
                {
                    this.PDFPassword = j.toString();
                }
	        }
	        else if (obj!= null && obj instanceof String){
                this.PDFPassword = (String)obj;
            }    
        }
        if (soapObject.hasProperty("PDFSignatureBackground"))
        {	
	        java.lang.Object j = soapObject.getProperty("PDFSignatureBackground");
	        this.PDFSignatureBackground = BSBHelper.getBinary(j,false);
        }
        if (soapObject.hasProperty("PDFSignatureBackgroundHeight"))
        {	
	        java.lang.Object obj = soapObject.getProperty("PDFSignatureBackgroundHeight");
            if (obj != null && obj.getClass().equals(SoapPrimitive.class))
            {
                SoapPrimitive j =(SoapPrimitive) obj;
                if(j.toString()!=null)
                {
                    this.PDFSignatureBackgroundHeight = Integer.parseInt(j.toString());
                }
	        }
	        else if (obj!= null && obj instanceof Integer){
                this.PDFSignatureBackgroundHeight = (Integer)obj;
            }    
        }
        if (soapObject.hasProperty("PDFSignatureBackgroundStretch"))
        {	
	        java.lang.Object obj = soapObject.getProperty("PDFSignatureBackgroundStretch");
            if (obj != null && obj.getClass().equals(SoapPrimitive.class))
            {
                SoapPrimitive j =(SoapPrimitive) obj;
                if(j.toString()!=null)
                {
                    this.PDFSignatureBackgroundStretch = new Boolean(j.toString());
                }
	        }
	        else if (obj!= null && obj instanceof Boolean){
                this.PDFSignatureBackgroundStretch = (Boolean)obj;
            }    
        }
        if (soapObject.hasProperty("PDFSignatureBackgroundWidth"))
        {	
	        java.lang.Object obj = soapObject.getProperty("PDFSignatureBackgroundWidth");
            if (obj != null && obj.getClass().equals(SoapPrimitive.class))
            {
                SoapPrimitive j =(SoapPrimitive) obj;
                if(j.toString()!=null)
                {
                    this.PDFSignatureBackgroundWidth = Integer.parseInt(j.toString());
                }
	        }
	        else if (obj!= null && obj instanceof Integer){
                this.PDFSignatureBackgroundWidth = (Integer)obj;
            }    
        }
        if (soapObject.hasProperty("PDFSignatureFieldName"))
        {	
	        java.lang.Object obj = soapObject.getProperty("PDFSignatureFieldName");
            if (obj != null && obj.getClass().equals(SoapPrimitive.class))
            {
                SoapPrimitive j =(SoapPrimitive) obj;
                if(j.toString()!=null)
                {
                    this.PDFSignatureFieldName = j.toString();
                }
	        }
	        else if (obj!= null && obj instanceof String){
                this.PDFSignatureFieldName = (String)obj;
            }    
        }
        if (soapObject.hasProperty("PDFSignatureFilterOnlyDocSignatures"))
        {	
	        java.lang.Object obj = soapObject.getProperty("PDFSignatureFilterOnlyDocSignatures");
            if (obj != null && obj.getClass().equals(SoapPrimitive.class))
            {
                SoapPrimitive j =(SoapPrimitive) obj;
                if(j.toString()!=null)
                {
                    this.PDFSignatureFilterOnlyDocSignatures = new Boolean(j.toString());
                }
	        }
	        else if (obj!= null && obj instanceof Boolean){
                this.PDFSignatureFilterOnlyDocSignatures = (Boolean)obj;
            }    
        }
        if (soapObject.hasProperty("PDFSignatureVisible"))
        {	
	        java.lang.Object obj = soapObject.getProperty("PDFSignatureVisible");
            if (obj != null && obj.getClass().equals(SoapPrimitive.class))
            {
                SoapPrimitive j =(SoapPrimitive) obj;
                if(j.toString()!=null)
                {
                    this.PDFSignatureVisible = new Boolean(j.toString());
                }
	        }
	        else if (obj!= null && obj instanceof Boolean){
                this.PDFSignatureVisible = (Boolean)obj;
            }    
        }
        if (soapObject.hasProperty("PDFSignatureWidgetAutoPos"))
        {	
	        java.lang.Object obj = soapObject.getProperty("PDFSignatureWidgetAutoPos");
            if (obj != null && obj.getClass().equals(SoapPrimitive.class))
            {
                SoapPrimitive j =(SoapPrimitive) obj;
                if(j.toString()!=null)
                {
                    this.PDFSignatureWidgetAutoPos = new Boolean(j.toString());
                }
	        }
	        else if (obj!= null && obj instanceof Boolean){
                this.PDFSignatureWidgetAutoPos = (Boolean)obj;
            }    
        }
        if (soapObject.hasProperty("PDFSignatureWidgetAutoSize"))
        {	
	        java.lang.Object obj = soapObject.getProperty("PDFSignatureWidgetAutoSize");
            if (obj != null && obj.getClass().equals(SoapPrimitive.class))
            {
                SoapPrimitive j =(SoapPrimitive) obj;
                if(j.toString()!=null)
                {
                    this.PDFSignatureWidgetAutoSize = new Boolean(j.toString());
                }
	        }
	        else if (obj!= null && obj instanceof Boolean){
                this.PDFSignatureWidgetAutoSize = (Boolean)obj;
            }    
        }
        if (soapObject.hasProperty("PDFSignatureWidgetHeight"))
        {	
	        java.lang.Object obj = soapObject.getProperty("PDFSignatureWidgetHeight");
            if (obj != null && obj.getClass().equals(SoapPrimitive.class))
            {
                SoapPrimitive j =(SoapPrimitive) obj;
                if(j.toString()!=null)
                {
                    this.PDFSignatureWidgetHeight = Integer.parseInt(j.toString());
                }
	        }
	        else if (obj!= null && obj instanceof Integer){
                this.PDFSignatureWidgetHeight = (Integer)obj;
            }    
        }
        if (soapObject.hasProperty("PDFSignatureWidgetHideText"))
        {	
	        java.lang.Object obj = soapObject.getProperty("PDFSignatureWidgetHideText");
            if (obj != null && obj.getClass().equals(SoapPrimitive.class))
            {
                SoapPrimitive j =(SoapPrimitive) obj;
                if(j.toString()!=null)
                {
                    this.PDFSignatureWidgetHideText = new Boolean(j.toString());
                }
	        }
	        else if (obj!= null && obj instanceof Boolean){
                this.PDFSignatureWidgetHideText = (Boolean)obj;
            }    
        }
        if (soapObject.hasProperty("PDFSignatureWidgetOffsetX"))
        {	
	        java.lang.Object obj = soapObject.getProperty("PDFSignatureWidgetOffsetX");
            if (obj != null && obj.getClass().equals(SoapPrimitive.class))
            {
                SoapPrimitive j =(SoapPrimitive) obj;
                if(j.toString()!=null)
                {
                    this.PDFSignatureWidgetOffsetX = Integer.parseInt(j.toString());
                }
	        }
	        else if (obj!= null && obj instanceof Integer){
                this.PDFSignatureWidgetOffsetX = (Integer)obj;
            }    
        }
        if (soapObject.hasProperty("PDFSignatureWidgetOffsetY"))
        {	
	        java.lang.Object obj = soapObject.getProperty("PDFSignatureWidgetOffsetY");
            if (obj != null && obj.getClass().equals(SoapPrimitive.class))
            {
                SoapPrimitive j =(SoapPrimitive) obj;
                if(j.toString()!=null)
                {
                    this.PDFSignatureWidgetOffsetY = Integer.parseInt(j.toString());
                }
	        }
	        else if (obj!= null && obj instanceof Integer){
                this.PDFSignatureWidgetOffsetY = (Integer)obj;
            }    
        }
        if (soapObject.hasProperty("PDFSignatureWidgetOnAllPages"))
        {	
	        java.lang.Object obj = soapObject.getProperty("PDFSignatureWidgetOnAllPages");
            if (obj != null && obj.getClass().equals(SoapPrimitive.class))
            {
                SoapPrimitive j =(SoapPrimitive) obj;
                if(j.toString()!=null)
                {
                    this.PDFSignatureWidgetOnAllPages = new Boolean(j.toString());
                }
	        }
	        else if (obj!= null && obj instanceof Boolean){
                this.PDFSignatureWidgetOnAllPages = (Boolean)obj;
            }    
        }
        if (soapObject.hasProperty("PDFSignatureWidgetOnLastPage"))
        {	
	        java.lang.Object obj = soapObject.getProperty("PDFSignatureWidgetOnLastPage");
            if (obj != null && obj.getClass().equals(SoapPrimitive.class))
            {
                SoapPrimitive j =(SoapPrimitive) obj;
                if(j.toString()!=null)
                {
                    this.PDFSignatureWidgetOnLastPage = new Boolean(j.toString());
                }
	        }
	        else if (obj!= null && obj instanceof Boolean){
                this.PDFSignatureWidgetOnLastPage = (Boolean)obj;
            }    
        }
        if (soapObject.hasProperty("PDFSignatureWidgetOnPage"))
        {	
	        java.lang.Object obj = soapObject.getProperty("PDFSignatureWidgetOnPage");
            if (obj != null && obj.getClass().equals(SoapPrimitive.class))
            {
                SoapPrimitive j =(SoapPrimitive) obj;
                if(j.toString()!=null)
                {
                    this.PDFSignatureWidgetOnPage = Integer.parseInt(j.toString());
                }
	        }
	        else if (obj!= null && obj instanceof Integer){
                this.PDFSignatureWidgetOnPage = (Integer)obj;
            }    
        }
        if (soapObject.hasProperty("PDFSignatureWidgetPageOffset"))
        {	
	        java.lang.Object obj = soapObject.getProperty("PDFSignatureWidgetPageOffset");
            if (obj != null && obj.getClass().equals(SoapPrimitive.class))
            {
                SoapPrimitive j =(SoapPrimitive) obj;
                if(j.toString()!=null)
                {
                    this.PDFSignatureWidgetPageOffset = Integer.parseInt(j.toString());
                }
	        }
	        else if (obj!= null && obj instanceof Integer){
                this.PDFSignatureWidgetPageOffset = (Integer)obj;
            }    
        }
        if (soapObject.hasProperty("PDFSignatureWidgetRotate"))
        {	
	        java.lang.Object obj = soapObject.getProperty("PDFSignatureWidgetRotate");
            if (obj != null && obj.getClass().equals(SoapPrimitive.class))
            {
                SoapPrimitive j =(SoapPrimitive) obj;
                if(j.toString()!=null)
                {
                    this.PDFSignatureWidgetRotate = Integer.parseInt(j.toString());
                }
	        }
	        else if (obj!= null && obj instanceof Integer){
                this.PDFSignatureWidgetRotate = (Integer)obj;
            }    
        }
        if (soapObject.hasProperty("PDFSignatureWidgetWidth"))
        {	
	        java.lang.Object obj = soapObject.getProperty("PDFSignatureWidgetWidth");
            if (obj != null && obj.getClass().equals(SoapPrimitive.class))
            {
                SoapPrimitive j =(SoapPrimitive) obj;
                if(j.toString()!=null)
                {
                    this.PDFSignatureWidgetWidth = Integer.parseInt(j.toString());
                }
	        }
	        else if (obj!= null && obj instanceof Integer){
                this.PDFSignatureWidgetWidth = (Integer)obj;
            }    
        }


    }

    @Override
    public java.lang.Object getProperty(int propertyIndex) {
        //!!!!! If you have a compilation error here then you are using old version of ksoap2 library. Please upgrade to the latest version.
        //!!!!! You can find a correct version in Lib folder from generated zip file!!!!!
        if(propertyIndex==0)
        {
            return this.PDFPassword!=null?this.PDFPassword:SoapPrimitive.NullSkip;
        }
        if(propertyIndex==1)
        {
            return this.PDFSignatureBackground!=null?org.kobjects.base64.Base64.encode(this.PDFSignatureBackground):SoapPrimitive.NullNilElement;
        }
        if(propertyIndex==2)
        {
            return PDFSignatureBackgroundHeight;
        }
        if(propertyIndex==3)
        {
            return PDFSignatureBackgroundStretch;
        }
        if(propertyIndex==4)
        {
            return PDFSignatureBackgroundWidth;
        }
        if(propertyIndex==5)
        {
            return this.PDFSignatureFieldName!=null?this.PDFSignatureFieldName:SoapPrimitive.NullSkip;
        }
        if(propertyIndex==6)
        {
            return PDFSignatureFilterOnlyDocSignatures;
        }
        if(propertyIndex==7)
        {
            return PDFSignatureVisible;
        }
        if(propertyIndex==8)
        {
            return PDFSignatureWidgetAutoPos;
        }
        if(propertyIndex==9)
        {
            return PDFSignatureWidgetAutoSize;
        }
        if(propertyIndex==10)
        {
            return PDFSignatureWidgetHeight;
        }
        if(propertyIndex==11)
        {
            return PDFSignatureWidgetHideText;
        }
        if(propertyIndex==12)
        {
            return PDFSignatureWidgetOffsetX;
        }
        if(propertyIndex==13)
        {
            return PDFSignatureWidgetOffsetY;
        }
        if(propertyIndex==14)
        {
            return PDFSignatureWidgetOnAllPages;
        }
        if(propertyIndex==15)
        {
            return PDFSignatureWidgetOnLastPage;
        }
        if(propertyIndex==16)
        {
            return PDFSignatureWidgetOnPage;
        }
        if(propertyIndex==17)
        {
            return PDFSignatureWidgetPageOffset;
        }
        if(propertyIndex==18)
        {
            return PDFSignatureWidgetRotate;
        }
        if(propertyIndex==19)
        {
            return PDFSignatureWidgetWidth;
        }
        return null;
    }


    @Override
    public int getPropertyCount() {
        return 20;
    }

    @Override
    public void getPropertyInfo(int propertyIndex, @SuppressWarnings("rawtypes") Hashtable arg1, PropertyInfo info)
    {
        if(propertyIndex==0)
        {
            info.type = PropertyInfo.STRING_CLASS;
            info.name = "PDFPassword";
            info.namespace= "http://schemas.datacontract.org/2004/07/SealSignDSSTypes";
        }
        if(propertyIndex==1)
        {
            info.type = PropertyInfo.STRING_CLASS;
            info.name = "PDFSignatureBackground";
            info.namespace= "http://schemas.datacontract.org/2004/07/SealSignDSSTypes";
        }
        if(propertyIndex==2)
        {
            info.type = PropertyInfo.INTEGER_CLASS;
            info.name = "PDFSignatureBackgroundHeight";
            info.namespace= "http://schemas.datacontract.org/2004/07/SealSignDSSTypes";
        }
        if(propertyIndex==3)
        {
            info.type = PropertyInfo.BOOLEAN_CLASS;
            info.name = "PDFSignatureBackgroundStretch";
            info.namespace= "http://schemas.datacontract.org/2004/07/SealSignDSSTypes";
        }
        if(propertyIndex==4)
        {
            info.type = PropertyInfo.INTEGER_CLASS;
            info.name = "PDFSignatureBackgroundWidth";
            info.namespace= "http://schemas.datacontract.org/2004/07/SealSignDSSTypes";
        }
        if(propertyIndex==5)
        {
            info.type = PropertyInfo.STRING_CLASS;
            info.name = "PDFSignatureFieldName";
            info.namespace= "http://schemas.datacontract.org/2004/07/SealSignDSSTypes";
        }
        if(propertyIndex==6)
        {
            info.type = PropertyInfo.BOOLEAN_CLASS;
            info.name = "PDFSignatureFilterOnlyDocSignatures";
            info.namespace= "http://schemas.datacontract.org/2004/07/SealSignDSSTypes";
        }
        if(propertyIndex==7)
        {
            info.type = PropertyInfo.BOOLEAN_CLASS;
            info.name = "PDFSignatureVisible";
            info.namespace= "http://schemas.datacontract.org/2004/07/SealSignDSSTypes";
        }
        if(propertyIndex==8)
        {
            info.type = PropertyInfo.BOOLEAN_CLASS;
            info.name = "PDFSignatureWidgetAutoPos";
            info.namespace= "http://schemas.datacontract.org/2004/07/SealSignDSSTypes";
        }
        if(propertyIndex==9)
        {
            info.type = PropertyInfo.BOOLEAN_CLASS;
            info.name = "PDFSignatureWidgetAutoSize";
            info.namespace= "http://schemas.datacontract.org/2004/07/SealSignDSSTypes";
        }
        if(propertyIndex==10)
        {
            info.type = PropertyInfo.INTEGER_CLASS;
            info.name = "PDFSignatureWidgetHeight";
            info.namespace= "http://schemas.datacontract.org/2004/07/SealSignDSSTypes";
        }
        if(propertyIndex==11)
        {
            info.type = PropertyInfo.BOOLEAN_CLASS;
            info.name = "PDFSignatureWidgetHideText";
            info.namespace= "http://schemas.datacontract.org/2004/07/SealSignDSSTypes";
        }
        if(propertyIndex==12)
        {
            info.type = PropertyInfo.INTEGER_CLASS;
            info.name = "PDFSignatureWidgetOffsetX";
            info.namespace= "http://schemas.datacontract.org/2004/07/SealSignDSSTypes";
        }
        if(propertyIndex==13)
        {
            info.type = PropertyInfo.INTEGER_CLASS;
            info.name = "PDFSignatureWidgetOffsetY";
            info.namespace= "http://schemas.datacontract.org/2004/07/SealSignDSSTypes";
        }
        if(propertyIndex==14)
        {
            info.type = PropertyInfo.BOOLEAN_CLASS;
            info.name = "PDFSignatureWidgetOnAllPages";
            info.namespace= "http://schemas.datacontract.org/2004/07/SealSignDSSTypes";
        }
        if(propertyIndex==15)
        {
            info.type = PropertyInfo.BOOLEAN_CLASS;
            info.name = "PDFSignatureWidgetOnLastPage";
            info.namespace= "http://schemas.datacontract.org/2004/07/SealSignDSSTypes";
        }
        if(propertyIndex==16)
        {
            info.type = PropertyInfo.INTEGER_CLASS;
            info.name = "PDFSignatureWidgetOnPage";
            info.namespace= "http://schemas.datacontract.org/2004/07/SealSignDSSTypes";
        }
        if(propertyIndex==17)
        {
            info.type = PropertyInfo.INTEGER_CLASS;
            info.name = "PDFSignatureWidgetPageOffset";
            info.namespace= "http://schemas.datacontract.org/2004/07/SealSignDSSTypes";
        }
        if(propertyIndex==18)
        {
            info.type = PropertyInfo.INTEGER_CLASS;
            info.name = "PDFSignatureWidgetRotate";
            info.namespace= "http://schemas.datacontract.org/2004/07/SealSignDSSTypes";
        }
        if(propertyIndex==19)
        {
            info.type = PropertyInfo.INTEGER_CLASS;
            info.name = "PDFSignatureWidgetWidth";
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
