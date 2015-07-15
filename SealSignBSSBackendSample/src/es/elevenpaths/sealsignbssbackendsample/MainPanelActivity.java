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
import es.smartaccess.sealsignbss.SealSignBSSConstants;
import es.smartaccess.sealsignbss.SealSignBSSPanel;
import android.support.v4.content.FileProvider;
import android.support.v7.app.ActionBarActivity;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class MainPanelActivity extends ActionBarActivity {
	private static String baseURL = "http://server";
	private static String demoURI = "demo://C:\\sample.pdf";
	
	BSBBasicHttpBinding_IBiometricSignatureServiceBasic service = null;
     
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_panel_main);
		
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
                    
                    Intent myIntent = new Intent(MainPanelActivity.this, SealSignBSSPanel.class);
            		
                    myIntent.putExtra(SealSignBSSConstants.WIDTH_PORT, 500); // Default and max. value = 640
                    myIntent.putExtra(SealSignBSSConstants.HEIGHT_PORT, 400); // Default and max. value = 480
            	    myIntent.putExtra(SealSignBSSConstants.WIDTH_LAND, 800); // Default and max. value = 640 
            	    myIntent.putExtra(SealSignBSSConstants.HEIGHT_LAND, 500); // Default and max. value = 480

            	    myIntent.putExtra(SealSignBSSConstants.BUTTON_UPPER_MARGIN, 10); // Default value = 6
            	    myIntent.putExtra(SealSignBSSConstants.BUTTON_SIDE_MARGIN, 10); // Default value = 4
            	    myIntent.putExtra(SealSignBSSConstants.BOTTOM_MARGIN, 15); // Default value =  5

            	    myIntent.putExtra(SealSignBSSConstants.BUTTON_M_SAVE_TEXT, "Save"); // Default value = "Salvar"
            	    myIntent.putExtra(SealSignBSSConstants.BUTTON_M_CLEAR_TEXT, "Clear"); // Default value = "Borrar"
            	    myIntent.putExtra(SealSignBSSConstants.DIALOG_TITLE_TEXT, "Saving signature"); // Default value = "Salvando firma"
            	    myIntent.putExtra(SealSignBSSConstants.DIALOG_MSG_TEXT, "Please wait..."); // Default value = "Por favor, espere..."

            	    myIntent.putExtra(SealSignBSSConstants.DATE_TEXT, new java.util.Date().toString()); 
            	    
            	    myIntent.putExtra(SealSignBSSConstants.BIOMETRIC_INSTANCE, beginResponse.instance.toString());
            	    myIntent.putExtra(SealSignBSSConstants.BIOMETRIC_STATE, beginResponse.biometricState); 
            	    
            	    startActivityForResult(myIntent, 0);
				} 
		    	catch (Exception e) {
					e.printStackTrace();
				}
    	    }
    	});
    	
    	thread.start();
    }
    
    public void provider(View view) {
    	Thread thread = new Thread(new Runnable() {
    	    @Override
    	    public void run() {
    	    	try {
    	    		BSBBiometricSignatureBeginResponseBasic beginResponse = service.BeginSignatureProvider("", "", demoURI, null, null);
    	    		
    	    		Intent myIntent = new Intent(MainPanelActivity.this, SealSignBSSPanel.class);
            		
                    myIntent.putExtra(SealSignBSSConstants.WIDTH_PORT, 500); // Default and max. value = 640
                    myIntent.putExtra(SealSignBSSConstants.HEIGHT_PORT, 400); // Default and max. value = 480
            	    myIntent.putExtra(SealSignBSSConstants.WIDTH_LAND, 800); // Default and max. value = 640 
            	    myIntent.putExtra(SealSignBSSConstants.HEIGHT_LAND, 500); // Default and max. value = 480

            	    myIntent.putExtra(SealSignBSSConstants.BUTTON_UPPER_MARGIN, 10); // Default value = 6
            	    myIntent.putExtra(SealSignBSSConstants.BUTTON_SIDE_MARGIN, 10); // Default value = 4
            	    myIntent.putExtra(SealSignBSSConstants.BOTTOM_MARGIN, 15); // Default value =  5

            	    myIntent.putExtra(SealSignBSSConstants.BUTTON_M_SAVE_TEXT, "Save"); // Default value = "Salvar"
            	    myIntent.putExtra(SealSignBSSConstants.BUTTON_M_CLEAR_TEXT, "Clear"); // Default value = "Borrar"
            	    myIntent.putExtra(SealSignBSSConstants.DIALOG_TITLE_TEXT, "Saving signature"); // Default value = "Salvando firma"
            	    myIntent.putExtra(SealSignBSSConstants.DIALOG_MSG_TEXT, "Please wait..."); // Default value = "Por favor, espere..."

            	    myIntent.putExtra(SealSignBSSConstants.DATE_TEXT, new java.util.Date().toString()); 
            	    
            	    myIntent.putExtra(SealSignBSSConstants.BIOMETRIC_INSTANCE, beginResponse.instance.toString());
            	    myIntent.putExtra(SealSignBSSConstants.BIOMETRIC_STATE, beginResponse.biometricState); 
            	    
            	    startActivityForResult(myIntent, 1);
				} 
		    	catch (Exception e) {
					e.printStackTrace();
				}
    	    }
    	});
    	
    	thread.start();
    }
    
    public void verify(View view) {
    	Thread thread = new Thread(new Runnable() {
    	    @Override
    	    public void run() {
    	    	try {
    	    		Intent myIntent = new Intent(MainPanelActivity.this, SealSignBSSPanel.class);
            		
                    myIntent.putExtra(SealSignBSSConstants.WIDTH_PORT, 500); // Default and max. value = 640
                    myIntent.putExtra(SealSignBSSConstants.HEIGHT_PORT, 400); // Default and max. value = 480
            	    myIntent.putExtra(SealSignBSSConstants.WIDTH_LAND, 800); // Default and max. value = 640 
            	    myIntent.putExtra(SealSignBSSConstants.HEIGHT_LAND, 500); // Default and max. value = 480

            	    myIntent.putExtra(SealSignBSSConstants.BUTTON_UPPER_MARGIN, 10); // Default value = 6
            	    myIntent.putExtra(SealSignBSSConstants.BUTTON_SIDE_MARGIN, 10); // Default value = 4
            	    myIntent.putExtra(SealSignBSSConstants.BOTTOM_MARGIN, 15); // Default value =  5

            	    myIntent.putExtra(SealSignBSSConstants.BUTTON_M_SAVE_TEXT, "Save"); // Default value = "Salvar"
            	    myIntent.putExtra(SealSignBSSConstants.BUTTON_M_CLEAR_TEXT, "Clear"); // Default value = "Borrar"
            	    myIntent.putExtra(SealSignBSSConstants.DIALOG_TITLE_TEXT, "Saving signature"); // Default value = "Salvando firma"
            	    myIntent.putExtra(SealSignBSSConstants.DIALOG_MSG_TEXT, "Please wait..."); // Default value = "Por favor, espere..."

            	    myIntent.putExtra(SealSignBSSConstants.DATE_TEXT, new java.util.Date().toString()); 
            	    
            	    myIntent.putExtra(SealSignBSSConstants.BIOMETRIC_INSTANCE, "00000000-0000-0000-0000-000000000000");
            	    myIntent.putExtra(SealSignBSSConstants.BIOMETRIC_STATE, (String)null); 

            	    startActivityForResult(myIntent, 2);
				} 
		    	catch (Exception e) {
					e.printStackTrace();
				}
    	    }
    	});
    	
    	thread.start();
    }
    
    public void offline(View view) {
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
                    
                    Intent myIntent = new Intent(MainPanelActivity.this, SealSignBSSPanel.class);
            		
                    myIntent.putExtra(SealSignBSSConstants.WIDTH_PORT, 500); // Default and max. value = 640
                    myIntent.putExtra(SealSignBSSConstants.HEIGHT_PORT, 400); // Default and max. value = 480
            	    myIntent.putExtra(SealSignBSSConstants.WIDTH_LAND, 800); // Default and max. value = 640 
            	    myIntent.putExtra(SealSignBSSConstants.HEIGHT_LAND, 500); // Default and max. value = 480

            	    myIntent.putExtra(SealSignBSSConstants.BUTTON_UPPER_MARGIN, 10); // Default value = 6
            	    myIntent.putExtra(SealSignBSSConstants.BUTTON_SIDE_MARGIN, 10); // Default value = 4
            	    myIntent.putExtra(SealSignBSSConstants.BOTTOM_MARGIN, 15); // Default value =  5

            	    myIntent.putExtra(SealSignBSSConstants.BUTTON_M_SAVE_TEXT, "Save"); // Default value = "Salvar"
            	    myIntent.putExtra(SealSignBSSConstants.BUTTON_M_CLEAR_TEXT, "Clear"); // Default value = "Borrar"
            	    myIntent.putExtra(SealSignBSSConstants.DIALOG_TITLE_TEXT, "Saving signature"); // Default value = "Salvando firma"
            	    myIntent.putExtra(SealSignBSSConstants.DIALOG_MSG_TEXT, "Please wait..."); // Default value = "Por favor, espere..."

            	    myIntent.putExtra(SealSignBSSConstants.DATE_TEXT, new java.util.Date().toString()); 
            	    
            	    myIntent.putExtra(SealSignBSSConstants.BIOMETRIC_INSTANCE, "00000000-0000-0000-0000-000000000000");
            	    myIntent.putExtra(SealSignBSSConstants.BIOMETRIC_STATE, (String)null); 
            	    myIntent.putExtra(SealSignBSSConstants.BIOMETRIC_OFFLINE_DOCUMENT, documentBytes); 
                  
            	    startActivityForResult(myIntent, 3);
				} 
		    	catch (Exception e) {
					e.printStackTrace();
				}
    	    }
    	});
    	
    	thread.start();
    }
    
    public void offlineFP(View view) {
    	Thread thread = new Thread(new Runnable() {
    	    @Override
    	    public void run() {
    	    	try {
    	    		byte[] documentBytes = null; 
            		
            	    InputStream fileStream = getAssets().open("big-sample.pdf"); 
        	        int size = fileStream.available();
        	        documentBytes = new byte[size];
                    fileStream.read(documentBytes);
                    fileStream.close();
                    
                    Intent myIntent = new Intent(MainPanelActivity.this, SealSignBSSPanel.class);
            		
                    myIntent.putExtra(SealSignBSSConstants.WIDTH_PORT, 500); // Default and max. value = 640
                    myIntent.putExtra(SealSignBSSConstants.HEIGHT_PORT, 400); // Default and max. value = 480
            	    myIntent.putExtra(SealSignBSSConstants.WIDTH_LAND, 800); // Default and max. value = 640 
            	    myIntent.putExtra(SealSignBSSConstants.HEIGHT_LAND, 500); // Default and max. value = 480

            	    myIntent.putExtra(SealSignBSSConstants.BUTTON_UPPER_MARGIN, 10); // Default value = 6
            	    myIntent.putExtra(SealSignBSSConstants.BUTTON_SIDE_MARGIN, 10); // Default value = 4
            	    myIntent.putExtra(SealSignBSSConstants.BOTTOM_MARGIN, 15); // Default value =  5

            	    myIntent.putExtra(SealSignBSSConstants.BUTTON_M_SAVE_TEXT, "Save"); // Default value = "Salvar"
            	    myIntent.putExtra(SealSignBSSConstants.BUTTON_M_CLEAR_TEXT, "Clear"); // Default value = "Borrar"
            	    myIntent.putExtra(SealSignBSSConstants.DIALOG_TITLE_TEXT, "Saving signature"); // Default value = "Salvando firma"
            	    myIntent.putExtra(SealSignBSSConstants.DIALOG_MSG_TEXT, "Please wait..."); // Default value = "Por favor, espere..."

            	    myIntent.putExtra(SealSignBSSConstants.DATE_TEXT, new java.util.Date().toString()); 
            	    
            	    myIntent.putExtra(SealSignBSSConstants.BIOMETRIC_INSTANCE, "00000000-0000-0000-0000-000000000000");
            	    myIntent.putExtra(SealSignBSSConstants.BIOMETRIC_STATE, (String)null); 
            	    
            	    File fileToShare = new File(getFilesDir() + File.separator + "export", "signingDocument.pdf");
            	    
            	    fileToShare.delete();
            	    fileToShare.getParentFile().mkdirs();
            	    fileToShare.createNewFile();

            	    FileOutputStream fos = new FileOutputStream(fileToShare.getPath());
            	    fos.write(documentBytes);
                    fos.close();
            	    
            	    Uri fileUri = FileProvider.getUriForFile(MainPanelActivity.this, "es.elevenpaths.fileprovider", fileToShare);
            	    
            	    myIntent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
            	    myIntent.setDataAndType(fileUri, getContentResolver().getType(fileUri));
                  
            	    startActivityForResult(myIntent, 4);
				} 
		    	catch (Exception e) {
					e.printStackTrace();
				}
    	    }
    	});
    	
    	thread.start();
    }
    
    public void onActivityResult(int requestCode, int resultCode, Intent data) 
    {     
        super.onActivityResult(requestCode, resultCode, data); 

        switch(requestCode) { 
        case (0): 
            if (resultCode == Activity.RESULT_OK) { 
                final byte[] biometricState = data.getByteArrayExtra(SealSignBSSConstants.BIOMETRIC_STATE);
                final String instance = data.getStringExtra(SealSignBSSConstants.BIOMETRIC_INSTANCE);
                
                Thread t = new Thread() {         
                	public void run() { 
		                try {
		                	byte[] signedDocument = service.EndSignature(UUID.fromString(instance), biometricState);
		                	
		                	File signedFile = new File(MainPanelActivity.this.getFilesDir(), "sample.pdf.signed.pdf");
							
							FileOutputStream signedStream = new FileOutputStream(signedFile.getPath());
							signedStream.write(signedDocument);
							signedStream.close();
						} 
		                catch (Exception e) {
							e.printStackTrace();
						}
                	}     
                };      
                
                t.start();
            } 
            break; 
            
        case (1):
        	if (resultCode == Activity.RESULT_OK) { 
                final byte[] biometricState = data.getByteArrayExtra(SealSignBSSConstants.BIOMETRIC_STATE);
                final String instance = data.getStringExtra(SealSignBSSConstants.BIOMETRIC_INSTANCE);
                
                Thread t = new Thread() {         
                	public void run() { 
		                try {
		                	service.EndSignatureProvider(UUID.fromString(instance), biometricState, demoURI, null, false);
						} 
		                catch (Exception e) {
							e.printStackTrace();
						}
                	}     
                };      
                
                t.start();
            } 
            break; 
            
        case (2):
        	if (resultCode == Activity.RESULT_OK) { 
                final byte[] biometricState = data.getByteArrayExtra(SealSignBSSConstants.BIOMETRIC_STATE);
                                
                Thread t = new Thread() {         
                	public void run() { 
		                try {
		                	File signedFile = new File(MainPanelActivity.this.getFilesDir(), "sample.pdf.signed.pdf");
							
		                	FileInputStream documentStream = new FileInputStream(signedFile);
							byte[] documentBytes = new byte[documentStream.available()];
							documentStream.read(documentBytes);
							documentStream.close();
							
							BSBBiometricSignatureVerification verificationRespone = service.Verify(SignatureProfile.PDF, 
									BiometricSignatureType.Default, 
									"", 
									"", 
									es.sealsign.bss.BSBEnums.BiometricVerificationFlags.getStatusFlags("Default"), 
									null, 
									biometricState, 
									null, 
									documentBytes);
							
							Log.i("SealSignBSSBackendSample", verificationRespone.result.toString());
						} 
		                catch (Exception e) {
							e.printStackTrace();
						}
                	}     
                };      
                
                t.start();
            } 
            break;
            
        case (3): 
            if (resultCode == Activity.RESULT_OK) { 
                final byte[] biometricState = data.getByteArrayExtra(SealSignBSSConstants.BIOMETRIC_STATE);
                final String instance = data.getStringExtra(SealSignBSSConstants.BIOMETRIC_INSTANCE);
                
                Thread t = new Thread() {         
                	public void run() { 
		                try {
		                	byte[] documentBytes = null; 
		            		
		            	    InputStream fileStream = getAssets().open("sample.pdf"); 
		        	        int size = fileStream.available();
		        	        documentBytes = new byte[size];
		                    fileStream.read(documentBytes);
		                    fileStream.close();
		                    
		                    BSBOfflineBiometricSignature offlineSignature = new BSBOfflineBiometricSignature();
		                    offlineSignature.biometricSignatureType = BiometricSignatureType.Default;
		                    offlineSignature.id = "";
		                    offlineSignature.account = "";
		                    offlineSignature.biometricOptions = es.sealsign.bss.BSBEnums.BiometricSignatureFlags.getStatusFlags("Default");
		                    offlineSignature.biometricParameters = null;
		                    offlineSignature.options = es.sealsign.bss.BSBEnums.SignatureFlags.getStatusFlags("Default");
		                    offlineSignature.parameters = null;
		                    offlineSignature.instance = UUID.fromString(instance);
		                    offlineSignature.offlineBiometricState = biometricState;
		                    
		                    BSBArrayOfOfflineBiometricSignature offlineSignatures = new BSBArrayOfOfflineBiometricSignature();
		                    offlineSignatures.add(offlineSignature);
		                    
		                    byte[] signedDocument = service.SyncOfflineSignatures(SignatureProfile.PDF, offlineSignatures, null, documentBytes);
		                	
		                	File signedFile = new File(MainPanelActivity.this.getFilesDir(), "sample.pdf.signed.pdf");
							
							FileOutputStream signedStream = new FileOutputStream(signedFile.getPath());
							signedStream.write(signedDocument);
							signedStream.close();
						} 
		                catch (Exception e) {
							e.printStackTrace();
						}
                	}     
                };      
                
                t.start();
            } 
            break;
            
        case (4): 
            if (resultCode == Activity.RESULT_OK) { 
                final byte[] biometricState = data.getByteArrayExtra(SealSignBSSConstants.BIOMETRIC_STATE);
                final String instance = data.getStringExtra(SealSignBSSConstants.BIOMETRIC_INSTANCE);
                
                Thread t = new Thread() {         
                	public void run() { 
		                try {
		                	byte[] documentBytes = null; 
		            		
		            	    InputStream fileStream = getAssets().open("big-sample.pdf"); 
		        	        int size = fileStream.available();
		        	        documentBytes = new byte[size];
		                    fileStream.read(documentBytes);
		                    fileStream.close();
		                    
		                    BSBOfflineBiometricSignature offlineSignature = new BSBOfflineBiometricSignature();
		                    offlineSignature.biometricSignatureType = BiometricSignatureType.Default;
		                    offlineSignature.id = "";
		                    offlineSignature.account = "";
		                    offlineSignature.biometricOptions = es.sealsign.bss.BSBEnums.BiometricSignatureFlags.getStatusFlags("Default");
		                    offlineSignature.biometricParameters = null;
		                    offlineSignature.options = es.sealsign.bss.BSBEnums.SignatureFlags.getStatusFlags("Default");
		                    offlineSignature.parameters = null;
		                    offlineSignature.instance = UUID.fromString(instance);
		                    offlineSignature.offlineBiometricState = biometricState;
		                    
		                    BSBArrayOfOfflineBiometricSignature offlineSignatures = new BSBArrayOfOfflineBiometricSignature();
		                    offlineSignatures.add(offlineSignature);
		                    
		                    byte[] signedDocument = service.SyncOfflineSignatures(SignatureProfile.PDF, offlineSignatures, null, documentBytes);
		                	
		                	File signedFile = new File(MainPanelActivity.this.getFilesDir(), "sample.pdf.signed.pdf");
							
							FileOutputStream signedStream = new FileOutputStream(signedFile.getPath());
							signedStream.write(signedDocument);
							signedStream.close();
						} 
		                catch (Exception e) {
							e.printStackTrace();
						}
                	}     
                };      
                
                t.start();
            } 
            break; 
        } 
    }
}


