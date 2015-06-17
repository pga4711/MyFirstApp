package com.mycompany.myfirstapp;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.content.Intent;
import android.widget.EditText;
import android.view.View;





public class MyActivity extends ActionBarActivity {

    public final static String EXTRA_MESSAGE = "com.mycompany.myfirstapp.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_my, menu);
        return super.onCreateOptionsMenu(menu);
        //getMenuInflater().inflate(R.menu.menu_my, menu);



        //return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.


//Kolla YouTube: Creating and using ActionBar Menu Items https://www.youtube.com/watch?v=4HPWV8DTyE4

        switch (item.getItemId()) {
            case R.id.action_search:
                action_searchMenuItem();
                break;
            case R.id.action_airplane:
                action_airplaneMenuItem();
                break;
            case R.id.action_settings:
                //action_settingsMenuItem();
                break;
        }


        return super.onOptionsItemSelected(item);
    }

    private void action_searchMenuItem(){
        new AlertDialog.Builder(this)
                .setTitle("Search")
                .setMessage("You pressed Search :0")
                .setNeutralButton("OK!!", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                }).show();


    }

    private void action_airplaneMenuItem(){
        new AlertDialog.Builder(this)
                .setTitle("Fly to Destination")
                .setMessage("Where do you want to fly?")
                .setNeutralButton("Brussels", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                }).show();


    }







    /** Called when the user clicks the Send button */
    public void sendMessage(View view) {
        Intent intent = new Intent(this, DisplayMessageActivity.class);
        EditText editText = (EditText) findViewById(R.id.edit_message);
        String message = editText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);

        // Do something in response to button
    }

}
