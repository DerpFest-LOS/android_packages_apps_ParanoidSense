package co.aospa.sense.util

import android.content.Context
import android.text.TextUtils
import androidx.preference.PreferenceManager

class PreferenceHelper(context: Context) {

    private val sharedPreferences = PreferenceManager.getDefaultSharedPreferences(
        context.applicationContext
    )

    @Suppress("DEPRECATION")
    fun saveIntValue(key: String?, value: Int) {
        sharedPreferences.edit()
            .putInt(key, value)
            .commit()
    }

    @Suppress("DEPRECATION")
    fun saveBooleanValue(key: String?, value: Boolean) {
        sharedPreferences.edit()
            .putBoolean(key, value)
            .commit()
    }

    @Suppress("DEPRECATION")
    fun removeSharePreferences(value: String?) {
        sharedPreferences.edit()
            .remove(value)
            .commit()
    }

    fun getIntValueByKey(key: String?, value: Int = -1): Int {
        return sharedPreferences.getInt(key, value)
    }

    @Suppress("DEPRECATION")
    fun saveStringValue(key: String?, value: String?) {
        sharedPreferences.edit()
            .putString(key, value)
            .commit()
    }

    fun getStringValueByKey(key: String?): String? {
        return sharedPreferences.getString(key, null)
    }

    @Suppress("DEPRECATION")
    fun saveByteArrayValue(key: String?, value: ByteArray?) {
        requireNotNull(value) { "ByteArray value cannot be null" }

        sharedPreferences.edit()
            .putString(key, String(value))
            .commit()
    }

    fun getByteArrayValueByKey(key: String?): ByteArray? {
        val string = sharedPreferences.getString(key, null)
        return if (string.isNullOrEmpty()) {
            null
        } else {
            string.toByteArray()
        }
    }

    fun getBooleanValueByKey(key: String?): Boolean {
        return sharedPreferences.getBoolean(key, false)
    }
}