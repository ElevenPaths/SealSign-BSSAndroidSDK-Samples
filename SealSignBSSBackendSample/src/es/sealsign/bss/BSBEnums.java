package es.sealsign.bss;

//----------------------------------------------------
//
// Generated by www.easywsdl.com
// Version: 4.1.7.0
//
// Created by Quasar Development at 15-06-2015
//
//---------------------------------------------------



import java.util.EnumSet;
import java.util.Set;


public class BSBEnums
{

    public enum SignatureProfile
    {
        
        Default(0),
        
        CMS(1),
        
        CAdESBES(2),
        
        CAdEST(3),
        
        CAdESC(4),
        
        CAdESX(5),
        
        CAdESXL(6),
        
        CAdESA(7),
        
        XMLDigSig(8),
        
        XAdESBES(9),
        
        XAdEST(10),
        
        XAdESC(11),
        
        XAdESX(12),
        
        XAdESXL(13),
        
        XAdESA(14),
        
        PDF(15),
        
        PAdESBasic(16),
        
        PAdESBES(17),
        
        PAdESLTV(18),
        
        PAdESXML(19),
        
        Office(20);
        
        private int code;
        
        SignatureProfile(int code ){
            this.code = code;
        }
    
        public int getCode(){
		    return code;
	    }
    

        public static SignatureProfile fromString(String str)
        {
            if (str.equals("Default"))
                return Default;
            if (str.equals("CMS"))
                return CMS;
            if (str.equals("CAdESBES"))
                return CAdESBES;
            if (str.equals("CAdEST"))
                return CAdEST;
            if (str.equals("CAdESC"))
                return CAdESC;
            if (str.equals("CAdESX"))
                return CAdESX;
            if (str.equals("CAdESXL"))
                return CAdESXL;
            if (str.equals("CAdESA"))
                return CAdESA;
            if (str.equals("XMLDigSig"))
                return XMLDigSig;
            if (str.equals("XAdESBES"))
                return XAdESBES;
            if (str.equals("XAdEST"))
                return XAdEST;
            if (str.equals("XAdESC"))
                return XAdESC;
            if (str.equals("XAdESX"))
                return XAdESX;
            if (str.equals("XAdESXL"))
                return XAdESXL;
            if (str.equals("XAdESA"))
                return XAdESA;
            if (str.equals("PDF"))
                return PDF;
            if (str.equals("PAdESBasic"))
                return PAdESBasic;
            if (str.equals("PAdESBES"))
                return PAdESBES;
            if (str.equals("PAdESLTV"))
                return PAdESLTV;
            if (str.equals("PAdESXML"))
                return PAdESXML;
            if (str.equals("Office"))
                return Office;
		    return null;
        }
    }

    public enum SignatureFlags
    {
        
        None(0),
        
        Default(1),
        
        ValidateChain(2),
        
        CheckRevocationStatus(4),
        
        XMLAddXPathRemoveSignatureTransform(8),
        
        XMLAdESIncludeSignerRole(16),
        
        XMLAdESExplicitPolicy(32),
        
        XMLAdESXType2(64),
        
        CMSAdESExplicitPolicy(128),
        
        CMSAdESXType2(256),
        
        PDFAdESIncludeTimestamp(512),
        
        PDFAdESIncludeRevocationInfo(1024),
        
        PDFAdESExplicitPolicy(2048),
        
        IncludeLocation(4096),
        
        XMLAdESVersion122(8192),
        
        XMLAdESIncludeKeyValue(16384),
        
        XMLAdESVersion132(32768),
        
        PDFAdESUseParametersInWidget(65536),
        
        XMLAdESPrettySignature(131072);
        
        private int code;
        
        SignatureFlags(int code ){
            this.code = code;
        }
    
        public int getCode(){
		    return code;
	    }
    

        public static SignatureFlags fromString(String str)
        {
            if (str.equals("None"))
                return None;
            if (str.equals("Default"))
                return Default;
            if (str.equals("ValidateChain"))
                return ValidateChain;
            if (str.equals("CheckRevocationStatus"))
                return CheckRevocationStatus;
            if (str.equals("XMLAddXPathRemoveSignatureTransform"))
                return XMLAddXPathRemoveSignatureTransform;
            if (str.equals("XMLAdESIncludeSignerRole"))
                return XMLAdESIncludeSignerRole;
            if (str.equals("XMLAdESExplicitPolicy"))
                return XMLAdESExplicitPolicy;
            if (str.equals("XMLAdESXType2"))
                return XMLAdESXType2;
            if (str.equals("CMSAdESExplicitPolicy"))
                return CMSAdESExplicitPolicy;
            if (str.equals("CMSAdESXType2"))
                return CMSAdESXType2;
            if (str.equals("PDFAdESIncludeTimestamp"))
                return PDFAdESIncludeTimestamp;
            if (str.equals("PDFAdESIncludeRevocationInfo"))
                return PDFAdESIncludeRevocationInfo;
            if (str.equals("PDFAdESExplicitPolicy"))
                return PDFAdESExplicitPolicy;
            if (str.equals("IncludeLocation"))
                return IncludeLocation;
            if (str.equals("XMLAdESVersion122"))
                return XMLAdESVersion122;
            if (str.equals("XMLAdESIncludeKeyValue"))
                return XMLAdESIncludeKeyValue;
            if (str.equals("XMLAdESVersion132"))
                return XMLAdESVersion132;
            if (str.equals("PDFAdESUseParametersInWidget"))
                return PDFAdESUseParametersInWidget;
            if (str.equals("XMLAdESPrettySignature"))
                return XMLAdESPrettySignature;
		    return null;
        }
        public static EnumSet<SignatureFlags> getStatusFlags(String strValue)
        {
            String[] values=strValue.split("\\s+");
            
            EnumSet statusFlags = EnumSet.noneOf(SignatureFlags.class);
            for(String val : values)
            {
                SignatureFlags enumValue=SignatureFlags.fromString(val);
                if(!enumValue.equals(SignatureFlags.None))
                {
                    statusFlags.add(enumValue) ;
                }
            }
            return statusFlags;
        } 
        
        public static String getFlagValue(Set<SignatureFlags> flags)
        {
            String value="";
            for(SignatureFlags val :flags)
            {
                value+=val.toString()+" ";
            }
            if(BSBHelper.isEmpty(value))
            {
                value=SignatureFlags.None.toString();
            }
            return value;
        }
    }

    public enum VerificationResult
    {
        
        Valid(0),
        
        IncompleteValidation(1),
        
        Invalid(2);
        
        private int code;
        
        VerificationResult(int code ){
            this.code = code;
        }
    
        public int getCode(){
		    return code;
	    }
    

        public static VerificationResult fromString(String str)
        {
            if (str.equals("Valid"))
                return Valid;
            if (str.equals("IncompleteValidation"))
                return IncompleteValidation;
            if (str.equals("Invalid"))
                return Invalid;
		    return null;
        }
    }

    public enum HashAlgorithm
    {
        
        Default(0),
        
        RIPEMD160(1),
        
        MD5(2),
        
        SHA1(3),
        
        SHA256(4),
        
        SHA384(5),
        
        SHA512(6),
        
        SSL3(7);
        
        private int code;
        
        HashAlgorithm(int code ){
            this.code = code;
        }
    
        public int getCode(){
		    return code;
	    }
    

        public static HashAlgorithm fromString(String str)
        {
            if (str.equals("Default"))
                return Default;
            if (str.equals("RIPEMD160"))
                return RIPEMD160;
            if (str.equals("MD5"))
                return MD5;
            if (str.equals("SHA1"))
                return SHA1;
            if (str.equals("SHA256"))
                return SHA256;
            if (str.equals("SHA384"))
                return SHA384;
            if (str.equals("SHA512"))
                return SHA512;
            if (str.equals("SSL3"))
                return SSL3;
		    return null;
        }
    }

    public enum VerificationStatus
    {
        
        Valid(0),
        
        SignatureCorrupted(1),
        
        SignerNotFound(2),
        
        IncompleteChain(3),
        
        BadCountersignature(4),
        
        BadTimestamp(5),
        
        CertificateExpired(6),
        
        CertificateRevoked(7),
        
        CertificateCorrupted(8),
        
        UntrustedCA(9),
        
        RevInfoNotFound(10),
        
        TimestampInfoNotFound(11),
        
        Failure(12),
        
        CertificateMalformed(13),
        
        Unknown(14),
        
        InvalidPolicy(15),
        
        NotValidForUsage(16);
        
        private int code;
        
        VerificationStatus(int code ){
            this.code = code;
        }
    
        public int getCode(){
		    return code;
	    }
    

        public static VerificationStatus fromString(String str)
        {
            if (str.equals("Valid"))
                return Valid;
            if (str.equals("SignatureCorrupted"))
                return SignatureCorrupted;
            if (str.equals("SignerNotFound"))
                return SignerNotFound;
            if (str.equals("IncompleteChain"))
                return IncompleteChain;
            if (str.equals("BadCountersignature"))
                return BadCountersignature;
            if (str.equals("BadTimestamp"))
                return BadTimestamp;
            if (str.equals("CertificateExpired"))
                return CertificateExpired;
            if (str.equals("CertificateRevoked"))
                return CertificateRevoked;
            if (str.equals("CertificateCorrupted"))
                return CertificateCorrupted;
            if (str.equals("UntrustedCA"))
                return UntrustedCA;
            if (str.equals("RevInfoNotFound"))
                return RevInfoNotFound;
            if (str.equals("TimestampInfoNotFound"))
                return TimestampInfoNotFound;
            if (str.equals("Failure"))
                return Failure;
            if (str.equals("CertificateMalformed"))
                return CertificateMalformed;
            if (str.equals("Unknown"))
                return Unknown;
            if (str.equals("InvalidPolicy"))
                return InvalidPolicy;
            if (str.equals("NotValidForUsage"))
                return NotValidForUsage;
		    return null;
        }
    }

    public enum SignatureType
    {
        
        Default(0),
        
        Enveloped(1),
        
        Enveloping(2),
        
        Detached(3),
        
        DetachedInternal(4);
        
        private int code;
        
        SignatureType(int code ){
            this.code = code;
        }
    
        public int getCode(){
		    return code;
	    }
    

        public static SignatureType fromString(String str)
        {
            if (str.equals("Default"))
                return Default;
            if (str.equals("Enveloped"))
                return Enveloped;
            if (str.equals("Enveloping"))
                return Enveloping;
            if (str.equals("Detached"))
                return Detached;
            if (str.equals("DetachedInternal"))
                return DetachedInternal;
		    return null;
        }
    }

    public enum TimestampType
    {
        
        Generic(0),
        
        ESC(1),
        
        CertsAndCRLs(2),
        
        Archive(3),
        
        Archive2(4);
        
        private int code;
        
        TimestampType(int code ){
            this.code = code;
        }
    
        public int getCode(){
		    return code;
	    }
    

        public static TimestampType fromString(String str)
        {
            if (str.equals("Generic"))
                return Generic;
            if (str.equals("ESC"))
                return ESC;
            if (str.equals("CertsAndCRLs"))
                return CertsAndCRLs;
            if (str.equals("Archive"))
                return Archive;
            if (str.equals("Archive2"))
                return Archive2;
		    return null;
        }
    }

    public enum BiometricSignatureType
    {
        
        Default(0),
        
        Signature(1);
        
        private int code;
        
        BiometricSignatureType(int code ){
            this.code = code;
        }
    
        public int getCode(){
		    return code;
	    }
    

        public static BiometricSignatureType fromString(String str)
        {
            if (str.equals("Default"))
                return Default;
            if (str.equals("Signature"))
                return Signature;
		    return null;
        }
    }

    public enum BiometricSignatureFlags
    {
        
        None(0),
        
        Default(1),
        
        VerifyIdentity(2),
        
        IncludeTimestamp(4),
        
        BiometricImageAsWidgetBackground(8),
        
        IncludeHashWatermark(16),
        
        IncludeAttachments(32),
        
        ExcludeDocumentMetadata(64),
        
        IncludeIdWatermark(128),
        
        IncludeAccountWatermark(256),
        
        XMLBiometricSignatureDetached(512);
        
        private int code;
        
        BiometricSignatureFlags(int code ){
            this.code = code;
        }
    
        public int getCode(){
		    return code;
	    }
    

        public static BiometricSignatureFlags fromString(String str)
        {
            if (str.equals("None"))
                return None;
            if (str.equals("Default"))
                return Default;
            if (str.equals("VerifyIdentity"))
                return VerifyIdentity;
            if (str.equals("IncludeTimestamp"))
                return IncludeTimestamp;
            if (str.equals("BiometricImageAsWidgetBackground"))
                return BiometricImageAsWidgetBackground;
            if (str.equals("IncludeHashWatermark"))
                return IncludeHashWatermark;
            if (str.equals("IncludeAttachments"))
                return IncludeAttachments;
            if (str.equals("ExcludeDocumentMetadata"))
                return ExcludeDocumentMetadata;
            if (str.equals("IncludeIdWatermark"))
                return IncludeIdWatermark;
            if (str.equals("IncludeAccountWatermark"))
                return IncludeAccountWatermark;
            if (str.equals("XMLBiometricSignatureDetached"))
                return XMLBiometricSignatureDetached;
		    return null;
        }
        public static EnumSet<BiometricSignatureFlags> getStatusFlags(String strValue)
        {
            String[] values=strValue.split("\\s+");
            
            EnumSet statusFlags = EnumSet.noneOf(BiometricSignatureFlags.class);
            for(String val : values)
            {
                BiometricSignatureFlags enumValue=BiometricSignatureFlags.fromString(val);
                if(!enumValue.equals(BiometricSignatureFlags.None))
                {
                    statusFlags.add(enumValue) ;
                }
            }
            return statusFlags;
        } 
        
        public static String getFlagValue(Set<BiometricSignatureFlags> flags)
        {
            String value="";
            for(BiometricSignatureFlags val :flags)
            {
                value+=val.toString()+" ";
            }
            if(BSBHelper.isEmpty(value))
            {
                value=BiometricSignatureFlags.None.toString();
            }
            return value;
        }
    }

    public enum BiometricVerificationFlags
    {
        
        None(0),
        
        Default(1),
        
        IncludeDSSInfo(2);
        
        private int code;
        
        BiometricVerificationFlags(int code ){
            this.code = code;
        }
    
        public int getCode(){
		    return code;
	    }
    

        public static BiometricVerificationFlags fromString(String str)
        {
            if (str.equals("None"))
                return None;
            if (str.equals("Default"))
                return Default;
            if (str.equals("IncludeDSSInfo"))
                return IncludeDSSInfo;
		    return null;
        }
        public static EnumSet<BiometricVerificationFlags> getStatusFlags(String strValue)
        {
            String[] values=strValue.split("\\s+");
            
            EnumSet statusFlags = EnumSet.noneOf(BiometricVerificationFlags.class);
            for(String val : values)
            {
                BiometricVerificationFlags enumValue=BiometricVerificationFlags.fromString(val);
                if(!enumValue.equals(BiometricVerificationFlags.None))
                {
                    statusFlags.add(enumValue) ;
                }
            }
            return statusFlags;
        } 
        
        public static String getFlagValue(Set<BiometricVerificationFlags> flags)
        {
            String value="";
            for(BiometricVerificationFlags val :flags)
            {
                value+=val.toString()+" ";
            }
            if(BSBHelper.isEmpty(value))
            {
                value=BiometricVerificationFlags.None.toString();
            }
            return value;
        }
    }

    public enum BiometricVerificationResult
    {
        
        SignatureFound(0),
        
        SignatureNotFound(1);
        
        private int code;
        
        BiometricVerificationResult(int code ){
            this.code = code;
        }
    
        public int getCode(){
		    return code;
	    }
    

        public static BiometricVerificationResult fromString(String str)
        {
            if (str.equals("SignatureFound"))
                return SignatureFound;
            if (str.equals("SignatureNotFound"))
                return SignatureNotFound;
		    return null;
        }
    }

    public enum BiometricVerificationStatus
    {
        
        Match(0),
        
        NoMatch(1),
        
        SignatureCorrupted(2),
        
        Failure(3),
        
        Unknown(4);
        
        private int code;
        
        BiometricVerificationStatus(int code ){
            this.code = code;
        }
    
        public int getCode(){
		    return code;
	    }
    

        public static BiometricVerificationStatus fromString(String str)
        {
            if (str.equals("Match"))
                return Match;
            if (str.equals("NoMatch"))
                return NoMatch;
            if (str.equals("SignatureCorrupted"))
                return SignatureCorrupted;
            if (str.equals("Failure"))
                return Failure;
            if (str.equals("Unknown"))
                return Unknown;
		    return null;
        }
    }

}