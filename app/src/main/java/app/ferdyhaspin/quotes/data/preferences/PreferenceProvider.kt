/*
 * Created by ferdyhaspin on 1/23/20 5:59 PM
 */

package app.ferdyhaspin.quotes.data.preferences

import android.content.Context
import android.content.SharedPreferences
import androidx.preference.PreferenceManager
import javax.inject.Inject

private const val KEY_SAVED_AT = "key_saved_at"

class PreferenceProvider @Inject
constructor(
    private val appContext: Context
) {

    private val preference: SharedPreferences
        get() = PreferenceManager.getDefaultSharedPreferences(appContext)


    fun saveLastSavedAt(savedAt: String) {
        preference.edit().putString(
            KEY_SAVED_AT,
            savedAt
        ).apply()
    }

    fun getLastSavedAt(): String? {
        return preference.getString(KEY_SAVED_AT, null)
    }

}