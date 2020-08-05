package tdc.edu.doanlaptrinhdidong2.activityLayout;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;

import com.google.android.material.textfield.TextInputLayout;

import tdc.edu.doanlaptrinhdidong2.R;

public class LayoutInput_activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layoutactivity);
        TextInputLayout textFirstname = (TextInputLayout) findViewById(R.id.text_firstName);
        TextInputLayout textLastname = (TextInputLayout) findViewById(R.id.text_lastName);
        TextInputLayout textEmail = (TextInputLayout) findViewById(R.id.text_email);
        EditText firstname = (EditText) findViewById(R.id.editText_firstName);
        EditText lastname = (EditText) findViewById(R.id.editText_lastName);
        EditText email = (EditText) findViewById(R.id.editText_email);
    }
}
