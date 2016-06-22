package com.example.basil.calendarman;

import android.Manifest;
import android.app.Activity;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.provider.CalendarContract;
import javax.xml.datatype.Duration;
import java.util.Calendar;
import java.util.TimeZone;
import android.content.Context;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;

/**
 * Created by basil on 22/06/2016.
 */
public class CalendarEvent {
    long startMillis = 0;
    long endMillis = 0;
    Calendar beginTime = Calendar.getInstance();
    int MY_PERMISSIONS_REQUEST_WRITE;



    public void settaTempoEvento (int annoI, int meseI, int giornoI, int oraI, int minutiI, int annoF, int meseF, int giornoF, int oraF, int minutiF){

    beginTime.set(annoI, meseI, giornoI, oraI, minutiI);
    startMillis = beginTime.getTimeInMillis();
    Calendar endTime = Calendar.getInstance();
    endTime.set(annoF, meseF, giornoF, oraF, minutiF);
    endMillis = endTime.getTimeInMillis();
    }

    public void InsertEvent(Context context, Activity activity, String title, String description, int id){
    ContentResolver cr = context.getContentResolver();
    ContentValues values = new ContentValues();
    TimeZone timeZone = TimeZone.getDefault();
    values.put(CalendarContract.Events.DTSTART, startMillis);
    values.put(CalendarContract.Events.DTEND, endMillis);
    values.put(CalendarContract.Events.EVENT_TIMEZONE, timeZone.getID());
    values.put(CalendarContract.Events.TITLE, title);
    values.put(CalendarContract.Events.DESCRIPTION, description);
    values.put(CalendarContract.Events.CALENDAR_ID, id);
        if (ContextCompat.checkSelfPermission(context, Manifest.permission.WRITE_CALENDAR)!= PackageManager.PERMISSION_GRANTED){
            if (ActivityCompat.shouldShowRequestPermissionRationale(activity,Manifest.permission.READ_CALENDAR)){

            }else{
                ActivityCompat.requestPermissions(activity, new String[]{Manifest.permission.WRITE_CALENDAR}, MY_PERMISSIONS_REQUEST_WRITE);

            }
        }
        Uri uri = cr.insert(CalendarContract.Events.CONTENT_URI, values);
    }
    // Retrieve ID for new event
    String eventID = uri.getLastPathSegment();

    Uri uri = CalendarContract.Calendars.CONTENT_URI;
    String[] projection = new String[] {
            CalendarContract.Calendars._ID,
            CalendarContract.Calendars.ACCOUNT_NAME,
            CalendarContract.Calendars.CALENDAR_DISPLAY_NAME,
            CalendarContract.Calendars.NAME,
            CalendarContract.Calendars.CALENDAR_COLOR
    };

    Cursor calendarCursor = managedQuery(uri, projection, null, null, null);
}
