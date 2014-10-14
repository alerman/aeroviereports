package aerovie.alerman.com.aeroviereports;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.AlertDialog;
import android.app.PendingIntent;
import android.app.backup.SharedPreferencesBackupHelper;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.activeandroid.ActiveAndroid;

import org.apache.http.impl.conn.tsccm.PoolEntryRequest;

import java.io.IOException;
import java.util.UUID;
import java.util.concurrent.ExecutionException;

import aerovie.alerman.com.aeroviereports.background.DBSyncReceiver;
import aerovie.alerman.com.aerovieweb.WebRequestExecutor;
import common.SharedPreferencesManager;


public class LoginActivity extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        String sessionId = SharedPreferencesManager.retrieve(getApplicationContext(),getString(R.string.sessionId),null);

        if(sessionId!=null)
        {
            loginSuccess();
        }else {

            setContentView(R.layout.activity_login);

            Button signInButton = (Button) this.findViewById(R.id.sign_in);


            Button createAccountButton = (Button) this.findViewById(R.id.create_account);

            createAccountButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    final AlertDialog.Builder builder = new AlertDialog.Builder(LoginActivity.this);
                    LayoutInflater inflater = LoginActivity.this.getLayoutInflater();
                    View dialogView = inflater.inflate(R.layout.dialog_create_account, null);
                    builder.setView(dialogView);
                    final AlertDialog dialog = builder.create();
                    builder.show();
                    Button cancelButton = (Button) dialogView.findViewById(R.id.create_account_cancel);
                    Button createButton = (Button) dialogView.findViewById(R.id.create_account_submit);

                    final EditText usernameEditText = (EditText) dialogView.findViewById(R.id.createUsername);
                    final EditText passwordEditText = (EditText) dialogView.findViewById(R.id.createPassword);
                    final EditText confirmPasswordEditText = (EditText) dialogView.findViewById(R.id.createConfirmPassword);
                    final EditText firstNameEditText = (EditText) dialogView.findViewById(R.id.createFirstName);
                    final EditText lastNameEditText = (EditText) dialogView.findViewById(R.id.createLastName);


                    cancelButton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            dialog.hide();
                        }
                    });

                    createButton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            //Check passwords match
                            String password = passwordEditText.getText().toString();
                            String confirmPassword = confirmPasswordEditText.getText().toString();

                            if (password.equals(confirmPassword)) {
                                try {
                                    //if yes, submit
                                    WebRequestExecutor wre = WebRequestExecutor.getInstance(getString(R.string.aerovie_url));

                                    String response = wre.createAccount(getStringValue(usernameEditText), password,
                                            getStringValue(firstNameEditText), getStringValue(lastNameEditText));
                                    Log.e("createAccount", response);
                                    SharedPreferencesManager.store(getApplicationContext(), getString(R.string.sessionId), response);
                                    loginSuccess();
                                } catch (IOException e) {
                                    //TODO remove printStackTrace
                                    e.printStackTrace();
                                } catch (ExecutionException e) {
                                    //TODO remove printStackTrace
                                    e.printStackTrace();
                                } catch (InterruptedException e) {
                                    //TODO remove printStackTrace
                                    e.printStackTrace();
                                }
                                //On success, hide dialog and log in
                                //On fail show error message
                            } else {

                                //if now, alert that passwords dont match
                                //TODO how to alert on not matching passwords
                                Log.e("LOGIN","PASSWORDS DO NOT MATCH");
                            }
                        }

                        private String getStringValue(EditText editText) {
                            return editText.getText().toString();
                        }
                    });
                }
            });

            final EditText username = (EditText) this.findViewById(R.id.username);
            final EditText password = (EditText) this.findViewById(R.id.password);
            signInButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    WebRequestExecutor wre = WebRequestExecutor.getInstance(getString(R.string.aerovie_url));
                    try {
                        String result = wre.login(username.getText().toString(), password.getText().toString());
                        SharedPreferencesManager.store(getApplicationContext(), getString(R.string.sessionId), result);
                        Log.i("LOGIN", result);
                        //TODO take care of error conditions and failure

                        loginSuccess();
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (ExecutionException e) {
                        e.printStackTrace();
                    }

                }
            });
        }
    }

    private void loginSuccess() {


//        String sessionId = SharedPreferencesManager.retrieve(getApplicationContext(), getString(R.string.sessionId), null);
//        String deviceSyncId = SharedPreferencesManager.retrieve(getApplicationContext(), getString(R.string.deviceId), null);
//        try {
//            deviceSyncId = WebRequestExecutor.getInstance(getApplicationContext().getString(R.string.aerovie_url)).sync(sessionId, deviceSyncId);
//
//            SharedPreferencesManager.store(getApplicationContext(), getString(R.string.deviceId), deviceSyncId);
//            if (deviceSyncId == null) {
//                SharedPreferencesManager.store(getApplicationContext(), getString(R.string.sessionId), null);
//                //TODO show an error message to the screen
//                return;
//            }
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        } catch (ExecutionException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        Intent mainActivity = new Intent(this, MainActivity.class);
        startActivity(mainActivity);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.login, menu);
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
}
