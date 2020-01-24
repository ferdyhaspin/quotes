/*
 * Created by ferdyhaspin on 1/23/20 5:57 PM
 */

package app.ferdyhaspin.quotes.data.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import app.ferdyhaspin.quotes.data.db.entities.Quote

@Dao
interface QuoteDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveAllQuotes(quotes : List<Quote>)

    @Query("SELECT * FROM Quote")
    fun getQuotes() : LiveData<List<Quote>>

}