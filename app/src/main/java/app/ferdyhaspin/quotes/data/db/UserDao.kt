package app.ferdyhaspin.quotes.data.db

import androidx.lifecycle.LiveData
import androidx.room.*
import app.ferdyhaspin.quotes.data.db.entities.CURRENT_USER_ID
import app.ferdyhaspin.quotes.data.db.entities.User

@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(user: User): Long

    @Query("SELECT * FROM user WHERE uid = $CURRENT_USER_ID")
    fun getUser(): LiveData<User>

    @Delete
    fun deleteUser(user: User)

}