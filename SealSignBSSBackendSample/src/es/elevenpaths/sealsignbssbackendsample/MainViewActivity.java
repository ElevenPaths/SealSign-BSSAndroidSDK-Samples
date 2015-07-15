package es.elevenpaths.sealsignbssbackendsample;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.UUID;

import es.sealsign.bss.BSBArrayOfOfflineBiometricSignature;
import es.sealsign.bss.BSBBasicHttpBinding_IBiometricSignatureServiceBasic;
import es.sealsign.bss.BSBBiometricImageParameters;
import es.sealsign.bss.BSBBiometricSignatureBeginResponseBasic;
import es.sealsign.bss.BSBBiometricSignatureParameters;
import es.sealsign.bss.BSBBiometricSignatureVerification;
import es.sealsign.bss.BSBEnums.BiometricSignatureType;
import es.sealsign.bss.BSBEnums.SignatureProfile;
import es.sealsign.bss.BSBOfflineBiometricSignature;
import es.smartaccess.sealsignbss.SealSignBSSView;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class MainViewActivity extends ActionBarActivity {
	private static String baseURL = "http://server";
	private static String demoURI = "demo://C:\\sample.pdf";
	
	BSBBasicHttpBinding_IBiometricSignatureServiceBasic service = null;
     
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_view_main);
		
		service = new BSBBasicHttpBinding_IBiometricSignatureServiceBasic(null, baseURL + "/SealSignBSSService/BiometricSignatureServiceBasic.svc/B");
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		
		return super.onOptionsItemSelected(item);
	}
	
	public void sign(View view) {
		final SealSignBSSView signatureView = (SealSignBSSView)findViewById(R.id.signatureView);
    			
    	Thread thread = new Thread(new Runnable() {
    	    @Override
    	    public void run() {
    	    	try {
    	    		byte[] documentBytes = null; 
            		
            	    InputStream fileStream = getAssets().open("sample.pdf"); 
        	        int size = fileStream.available();
        	        documentBytes = new byte[size];
                    fileStream.read(documentBytes);
                    fileStream.close();
                    
                    BSBBiometricSignatureParameters biometricParameters = new BSBBiometricSignatureParameters();
                    
                    biometricParameters.imageParameters = new BSBBiometricImageParameters();
                    biometricParameters.imageParameters.autoSize = false;
                    biometricParameters.imageParameters.height = 180;
                    biometricParameters.imageParameters.width = 250;
                    biometricParameters.imageParameters.offsetX = 100;
                    biometricParameters.imageParameters.offsetY = 100;
                    biometricParameters.imageParameters.onAllPages = true;
                    biometricParameters.imageParameters.signatureVisible = true;
                    
                    BSBBiometricSignatureBeginResponseBasic beginResponse = service.BeginSignature(SignatureProfile.PDF, 
                    		BiometricSignatureType.Default, 
                    		"", 
                    		"", 
                    		es.sealsign.bss.BSBEnums.BiometricSignatureFlags.getStatusFlags("Default"), 
                    		biometricParameters, 
                    		es.sealsign.bss.BSBEnums.SignatureFlags.getStatusFlags("Default"), 
                    		null, 
                    		null, 
                    		documentBytes);
                    
                    byte[] finalBiometricState = signatureView.getSignature(beginResponse.instance.toString(), beginResponse.biometricState);
                    
                    byte[] signedDocument = service.EndSignature(beginResponse.instance, finalBiometricState);
                    
                    File signedFile = new File(MainViewActivity.this.getFilesDir(), "sample.pdf.signed.pdf");
					
					FileOutputStream signedStream = new FileOutputStream(signedFile.getPath());
					signedStream.write(signedDocument);
					signedStream.close();
				} 
		    	catch (Exception e) {
					e.printStackTrace();
				}
    	    }
    	});
    	
    	thread.start();
    }
    
    public void provider(View view) {
    	final SealSignBSSView signatureView = (SealSignBSSView)findViewById(R.id.signatureView);
    	
    	Thread thread = new Thread(new Runnable() {
    	    @Override
    	    public void run() {
    	    	try {
    	    		BSBBiometricSignatureBeginResponseBasic beginResponse = service.BeginSignatureProvider("", "", demoURI, null, null);
    	    		
    	    		byte[] finalBiometricState = signatureView.getSignature(beginResponse.instance.toString(), beginResponse.biometricState);
                    
                    service.EndSignatureProvider(beginResponse.instance, finalBiometricState, demoURI, null, false);
				} 
		    	catch (Exception e) {
					e.printStackTrace();
				}
    	    }
    	});
    	
    	thread.start();
    }
    
    public void verify(View view) {
    	final SealSignBSSView signatureView = (SealSignBSSView)findViewById(R.id.signatureView);
    	
    	Thread thread = new Thread(new Runnable() {
    	    @Override
    	    public void run() {
    	    	try {
    	    		File signedFile = new File(MainViewActivity.this.getFilesDir(), "sample.pdf.signed.pdf");
					
                	FileInputStream documentStream = new FileInputStream(signedFile);
					byte[] documentBytes = new byte[documentStream.available()];
					documentStream.read(documentBytes);
					documentStream.close();
                    
                    byte[] finalBiometricState = signatureView.getSignature("00000000-0000-0000-0000-000000000000", null);
                    
                    BSBBiometricSignatureVerification verificationRespone = service.Verify(SignatureProfile.PDF, 
                    		BiometricSignatureType.Default, 
                    		"", 
                    		"", 
                    		es.sealsign.bss.BSBEnums.BiometricVerificationFlags.getStatusFlags("Default"), 
                    		null, 
                    		finalBiometricState, 
                    		null, 
                    		documentBytes);
                    
                    Log.i("SealSignBSSBackendSample", verificationRespone.result.toString());
				} 
		    	catch (Exception e) {
					e.printStackTrace();
				}
    	    }
    	});
    	
    	thread.start();
    }
    
    public void offline(View view) {
    	final SealSignBSSView signatureView = (SealSignBSSView)findViewById(R.id.signatureView);
    	
    	Thread thread = new Thread(new Runnable() {
    	    @Override
    	    public void run() {
    	    	try {
    	    		byte[] documentBytes = null; 
            		
            	    InputStream fileStream = getAssets().open("sample.pdf"); 
        	        int size = fileStream.available();
        	        documentBytes = new byte[size];
                    fileStream.read(documentBytes);
                    fileStream.close();
                    
                    byte[] finalBiometricState = signatureView.getOfflineSignature(documentBytes);
                    
                    String instance = signatureView.getBiometricInstance();
                    
                    BSBOfflineBiometricSignature offlineSignature = new BSBOfflineBiometricSignature();
                    offlineSignature.biometricSignatureType = BiometricSignatureType.Default;
                    offlineSignature.id = "";
                    offlineSignature.account = "";
                    offlineSignature.biometricOptions = es.sealsign.bss.BSBEnums.BiometricSignatureFlags.getStatusFlags("Default");
                    offlineSignature.biometricParameters = null;
                    offlineSignature.options = es.sealsign.bss.BSBEnums.SignatureFlags.getStatusFlags("Default");
                    offlineSignature.parameters = null;
                    offlineSignature.instance = UUID.fromString(instance);
                    offlineSignature.offlineBiometricState = finalBiometricState;
                    
                    BSBArrayOfOfflineBiometricSignature offlineSignatures = new BSBArrayOfOfflineBiometricSignature();
                    offlineSignatures.add(offlineSignature);
                    
                    byte[] signedDocument = service.SyncOfflineSignatures(SignatureProfile.PDF, offlineSignatures, null, documentBytes);
                	
                	File signedFile = new File(MainViewActivity.this.getFilesDir(), "sample.pdf.signed.pdf");
					
					FileOutputStream signedStream = new FileOutputStream(signedFile.getPath());
					signedStream.write(signedDocument);
					signedStream.close();
				} 
		    	catch (Exception e) {
					e.printStackTrace();
				}
    	    }
    	});
    	
    	thread.start();
    }
    
    public void clear(View view) {
    	SealSignBSSView signatureView = (SealSignBSSView)findViewById(R.id.signatureView);
    	signatureView.cleanSignature();
    }
}


