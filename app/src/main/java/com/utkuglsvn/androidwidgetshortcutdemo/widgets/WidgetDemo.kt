package com.utkuglsvn.androidwidgetshortcutdemo.widgets

import android.appwidget.AppWidgetManager
import android.appwidget.AppWidgetProvider
import android.content.Context
import com.utkuglsvn.androidwidgetshortcutdemo.R

/**
 * Implementation of App Widget functionality.
 */
class WidgetDemo : AppWidgetProvider() {

    companion object {
        const val WIDGET_ACTION = "com.utkuglsvn.androidwidgetshortcutdemo.SECOND_FRAGMENT"
    }


    override fun onUpdate(
        context: Context,
        appWidgetManager: AppWidgetManager,
        appWidgetIds: IntArray
    ) {
        for (appWidgetId in appWidgetIds) {
            updateAppWidget(
                context,
                appWidgetManager,
                appWidgetId,
                R.layout.widget_demo,
                WIDGET_ACTION
            )
        }
    }


    override fun onEnabled(context: Context) {
        // Enter relevant functionality for when the first widget is created
    }


    override fun onDisabled(context: Context) {

    }

}