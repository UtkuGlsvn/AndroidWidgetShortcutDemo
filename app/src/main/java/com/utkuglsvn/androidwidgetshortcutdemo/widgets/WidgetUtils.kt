package com.utkuglsvn.androidwidgetshortcutdemo.widgets

import android.app.PendingIntent
import android.appwidget.AppWidgetManager
import android.appwidget.AppWidgetManager.EXTRA_APPWIDGET_ID
import android.content.Context
import android.content.Intent
import android.widget.RemoteViews
import com.utkuglsvn.androidwidgetshortcutdemo.MainActivity
import com.utkuglsvn.androidwidgetshortcutdemo.R


internal fun updateAppWidget(
    context: Context,
    appWidgetManager: AppWidgetManager,
    appWidgetId: Int,
    layoutId: Int,
    action: String
) {
    val remoteViews = RemoteViews(context.packageName, layoutId).apply {
        setTextViewText(R.id.appwidget_text, context.getString(R.string.widget_text))
        setOnClickPendingIntent(R.id.appwidget_text,getPendingIntent(context, action, appWidgetId))
    }
    appWidgetManager.updateAppWidget(appWidgetId, remoteViews)
}

fun getPendingIntent(context: Context?, action: String?, appWidgetId: Int): PendingIntent? {
    val intent = Intent(context, MainActivity::class.java)
    intent.putExtra(EXTRA_APPWIDGET_ID, appWidgetId)
    intent.action = action
    return PendingIntent.getActivity(context, 0, intent, 0)
}