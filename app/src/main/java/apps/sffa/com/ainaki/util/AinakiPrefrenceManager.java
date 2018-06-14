package apps.sffa.com.ainaki.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by mr-code on 6/14/2018.
 */

public class AinakiPrefrenceManager {


    private static SharedPreferences.Editor editor;

    private static SharedPreferences.Editor getPreferencesEditor(Context context) {
        return editor == null ? (editor = PreferenceManager.getDefaultSharedPreferences(context).edit()) : editor;
    }

    private static SharedPreferences prefs;

    private static SharedPreferences getPreferences(Context context) {
        return prefs == null ? (prefs = PreferenceManager.getDefaultSharedPreferences(context)) : prefs;
    }

    public static void putString(Context context, String key, String value) {
        getPreferencesEditor(context).putString(key, value).apply();
    }


    public static void putFloat(Context context, String key, Float value) {
        getPreferencesEditor(context).putFloat(key, value).apply();
    }

    public static void putInteger(Context context, String key, Integer value) {
        getPreferencesEditor(context).putInt(key, value).apply();
    }

    public static void putBoolean(Context context, String key, Boolean value) {
        getPreferencesEditor(context).putBoolean(key, value).apply();
    }

    public static void putLong(Context context, String key, Long value) {
        getPreferencesEditor(context).putLong(key, value).apply();
    }

    public static void putStringSet(Context context, String key, String[] values) {

        HashSet<String> stringSet = new HashSet<>();
        stringSet.addAll(Arrays.asList(values));

        getPreferencesEditor(context).putStringSet(key, stringSet).apply();
    }


    public static String getString(Context context, String key, String defaultValue) {
        return getPreferences(context).getString(key, defaultValue);
    }


    public static float getFloat(Context context, String key, Float defaultValue) {
        return getPreferences(context).getFloat(key, defaultValue);
    }

    public static int getInteger(Context context, String key, Integer defaultValue) {
        return getPreferences(context).getInt(key, defaultValue);
    }

    public static boolean getBoolean(Context context, String key, Boolean defaultValue) {
        return getPreferences(context).getBoolean(key, defaultValue);
    }

    public static long getLong(Context context, String key, Long defaultValue) {
        return getPreferences(context).getLong(key, defaultValue);
    }

    public static Set<String> getStringSet(Context context, String key, String[] defaultValues) {

        HashSet<String> stringSet = new HashSet<>();
        stringSet.addAll(Arrays.asList(defaultValues));

        return getPreferences(context).getStringSet(key, stringSet);
    }
}
